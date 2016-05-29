package com.richardxu.net.netty.echo;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

public class EchoClient {
    private final String host;
    private final int port;

    public EchoClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void start() throws Exception {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap(); // 为客户端创建Bootstrap
            b.group(group) // 指定EventLoopGroup处理客户端事件. NioEventLoopGroup is
                           // used, as the NIO-Transport should be used.
                    .channel(NioSocketChannel.class) // 指定channel类型，use correct
                                                     // one for NIO-Transport
                    .remoteAddress(new InetSocketAddress(host, port)) // Set
                                                                      // InetSocketAddress
                                                                      // to
                                                                      // which
                                                                      // client
                                                                      // connects
                    // Specify ChannelHandler, using ChannelInitializer, called
                    // once connection established and channel created
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch)
                                throws Exception {
                            // Add EchoElientHandler to ChannelPipeline that
                            // belongs to channel. ChannelPipeline holds all
                            // ChannelHandlers of channel
                            ch.pipeline().addLast(new EchoClientHandler());
                        }
                    });
            ChannelFuture f = b.connect().sync(); // Connect client to remote
                                                  // peer; wait until sync()
                                                  // completes connect completes
            f.channel().closeFuture().sync(); // Wait until ClientChannel
                                              // closes. This will block
        } finally {
            group.shutdownGracefully().sync(); // Shut down bootstrap and thread
                                               // pools; release all resources
        }
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.err.println("Usage: " + EchoClient.class.getSimpleName()
                    + " <host> <port>");
            return;
        }
        final String host = args[0];
        final int port = Integer.parseInt(args[1]);
        new EchoClient(host, port).start();
    }

}