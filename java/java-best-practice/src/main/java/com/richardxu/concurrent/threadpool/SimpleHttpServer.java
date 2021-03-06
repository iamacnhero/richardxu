package com.richardxu.concurrent.threadpool;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 基于线程池的简单Web Server
 * SimpleHttpServer在建立了与客户端的连接之后，并不会处理客户端的请求，而是将其包装成HttpRequestHandler并交由线程池处理。
 * 在线程池中的Worker处理客户端请求的同时，SimpleHttpServer能够继续完成后续客户端连接的建立，不会阻塞后续客户端的请求。
 * 
 * @author <a href="463692574@qq.com">Richard Xu</a>
 * @version 1.0
 * @since 2015年10月31日
 */
public class SimpleHttpServer {
	// 处理HttpRequest的线程池
	static ThreadPool<HttpRequestHandler> threadPool = new DefaultThreadPool<HttpRequestHandler>(1);
	
	// SimpleHttpServer 的根路径
	static String basePath;
	static ServerSocket serverSocket;
	// 服务监听端口
	static int port = 8080;
	
	public static void setPort(int port) {
		if (port > 0) {
			SimpleHttpServer.port = port;
		}
	}

	public static void setBasePath(String basePath) {
		if (basePath != null && new File(basePath).exists() && new File(basePath).isDirectory()) {
			SimpleHttpServer.basePath = basePath;
		}
	}
	
	// 启动SimpleHttpServer
	public static void start() throws IOException {
		serverSocket = new ServerSocket(port);
		Socket socket = null;
		while ((socket = serverSocket.accept()) != null) {
		    // 接收一个客户端Socket，生成一个HttpRequestHandler，放入线程池执行
		    threadPool.execute(new HttpRequestHandler(socket));
		}
	}
	
	static class HttpRequestHandler implements Runnable {
		private Socket socket;
		public HttpRequestHandler(Socket socket) {
			this.socket = socket;
		}
		
		@Override
		public void run() {
			String line = null;
			BufferedReader br = null;
			BufferedReader reader = null;
			PrintWriter out = null;
			InputStream in = null;
			try {
				reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String header = reader.readLine();
				// 由相对路径计算出绝对路径
				String filePath = basePath + header.split(" ")[1];
				out = new PrintWriter(socket.getOutputStream());
				// 如果请求资源的后缀为jpg或ico，则读取资源并输出
				if (filePath.endsWith("jpg") || filePath.endsWith("ico")) {
				    in = new FileInputStream(filePath);
				    ByteArrayOutputStream baos = new ByteArrayOutputStream();
				    int i = 0;
				    while ((i = in.read()) != -1) {
				        baos.write(i);
				    }
				    byte[] array = baos.toByteArray();
				    out.println("HTTP/1.1 200 OK");
				    out.println("Server: Earth");
				    out.println("Content-Type: image/jpeg");
				    out.println("Content-Length: " + array.length);
				    out.println("");
				    socket.getOutputStream().write(array, 0, array.length);
				} else {
				    br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
				    out = new PrintWriter(socket.getOutputStream());
				    out.println("HTTP/1.1 200 OK");
                    out.println("Server: Earth");
                    out.println("Content-Type: text/html; charset=UTF-8");
                    out.println("");
                    while ((line = br.readLine()) != null) {
                        out.println(line);
                    }
				}
				out.flush();
			} catch (Exception e) {
			    out.println("HTTP/1.1 500");
			    out.println("");
			    out.flush();
			} finally {
			    close(br, in, reader, out, socket);
			}
		}
	}
	
	// 关闭流或Socket
	private static void close(Closeable... closeables) {
	    if (closeables != null) {
	        for (Closeable closeable : closeables) {
                try {
                    closeable.close();
                } catch (Exception e) {
                    // skip
                }
            }
	    }
	}
	
}