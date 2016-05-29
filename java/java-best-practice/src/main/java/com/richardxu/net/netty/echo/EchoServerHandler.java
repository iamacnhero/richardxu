package com.richardxu.net.netty.echo;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Netty uses the concept of futures and callbacks, discussed previously,
 * coupled with a design that allows you to hook in and react to different event
 * types. To do this, your channel handler must extend the
 * ChannelInboundHandlerAdapter class and override the messageReceived method.
 * This method is called every time messages are received, which in this case
 * are bytes. This is where you place your logic to echo it back to the client,
 * as shown in the following listing.
 * 
 * @author <a href="mailto:463692574@qq.com">许峰</a>
 * @version 1.0
 * @since 2016年5月30日
 */
@Sharable
public class EchoServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        System.out.println("Server received: " + msg);
        ctx.write(msg); // Write the received message back. Be aware that this
                        // will not "flush" the messages to the remote peer yet.
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        // Flush all previous written messages(that are pending) to the remote
        // peer,
        // and close the channel after the operation is complete.
        ctx.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(
                ChannelFutureListener.CLOSE);
    }

    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close(); // Close channel on exception
    }
}