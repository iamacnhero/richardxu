package com.richardxu.net.netty.echo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

/**
 * You create a ServerBootstrap instance to bootstrap the server and bind it
 * later. You create and assign the NioEventLoopGroup instances to handle event
 * processing, such as accepting new connections, receiving data, writing data,
 * and so on. You specify the local InetSocketAddress to which the server binds.
 * You set up a childHandler that executes for every accepted connection. After
 * everything is set up, you call the ServerBootstrap.bind() method to bind the
 * server.
 * 
 * @author <a href="mailto:463692574@qq.com">许峰</a>
 * @version 1.0
 * @since 2016年5月30日
 */
public class EchoServer {
    private final int port;

    public EchoServer(int port) {
        this.port = port;
    }

    public void start() throws InterruptedException {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            ServerBootstrap bootstrap = new ServerBootstrap(); // 创建一个
                                                               // ServerBootstrap
                                                               // 实例
            bootstrap.group(group) // 指定一个 NioEventLoopGroup 用于接收和处理连接
                    .channel(NioServerSocketChannel.class) // 指定
                                                           // NioServerSocketChannel
                                                           // 作为 channel 类型
                    .localAddress(new InetSocketAddress(port)) // 设置
                                                               // InetSocketAddress
                                                               // 作为server绑定的地址
                    .childHandler(new ChannelInitializer<Channel>() { // 然后，当连接接受后，指定ChannelHandler用于处理，这里指定使用ChannelInitializer
                                @Override
                                protected void initChannel(Channel ch)
                                        throws Exception {
                                    // The ChannelPipeline holds all of the
                                    // different ChannelHandlers of a channel,
                                    // so you add the previously written
                                    // EchoServerHandler to the channel’s
                                    // ChannelPipeline
                                    ch.pipeline().addLast(
                                            new EchoServerHandler());
                                }
                            });
            // Bind the server, then wait until the bind completes, the call to
            // the “sync()” method will cause this to block until the server is
            // bound
            ChannelFuture channelFuture = bootstrap.bind().sync();
            System.out.println(EchoServer.class.getName()
                    + " started and listen on "
                    + channelFuture.channel().localAddress());
            // Application will wait until the server’s channel closes (because
            // we call sync() on the channel’s close future).
            channelFuture.channel().closeFuture().sync();
        } finally {
            // shutdown the EventLoopGroup and release all resources, including
            // all created threads
            group.shutdownGracefully().sync();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        if (args.length != 1) {
            System.out.println("Usage: " + EchoServer.class.getSimpleName()
                    + " <port>");
        }
        int port = Integer.parseInt(args[0]);
        new EchoServer(port).start();
    }
}