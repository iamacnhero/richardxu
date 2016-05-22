package com.richardxu.mina;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

/**
 * Test Mina Server
 * ref: http://mina.apache.org/mina-project/quick-start-guide.html
 * 
 * @author <a href="463692574@qq.com">Richard Xu</a>
 * @version 1.0
 * @since 2016年4月15日
 */
public class MinaTimeServer {
	
	public static void main(String[] args) throws IOException {
		int processorCount = Runtime.getRuntime().availableProcessors();
		InetAddress addr = Inet4Address.getLocalHost();
		int port = 9999;
		
		// NioSocketAcceptor: for socket transport (TCP/IP)
		IoAcceptor acceptor = new NioSocketAcceptor(processorCount);
		acceptor.getFilterChain().addLast("logger", new LoggingFilter());
		acceptor.getFilterChain().addLast("codec", new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("UTF-8"))));
		
		acceptor.setHandler(new TimeServerHandler());
		
		acceptor.getSessionConfig().setReadBufferSize(2048);
		// specify when to check for idle sessions in seconds
		acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 10);
		
		acceptor.bind(new InetSocketAddress(addr, port));
	}
}
