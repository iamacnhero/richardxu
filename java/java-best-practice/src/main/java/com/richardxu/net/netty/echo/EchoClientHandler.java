package com.richardxu.net.netty.echo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.CharsetUtil;

@Sharable
public class EchoClientHandler extends ChannelHandlerAdapter {
    public void channelActive(ChannelHandlerContext ctx) {
        ctx.write(Unpooled.copiedBuffer("Netty rocks!", CharsetUtil.UTF_8));
    }

    public void channelRead0(ChannelHandlerContext ctx, ByteBuf in) {
        System.out.println("Client received: "
                + ByteBufUtil.hexDump(in.readBytes(in.readableBytes())));
    }

    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}