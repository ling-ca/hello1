package com.ling.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.charset.Charset;

@ChannelHandler.Sharable
public class ServerHandler2 extends SimpleChannelInboundHandler<ByteBuf> {

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {
        //打印的将是连接的请求头信息
        System.out.println(byteBuf.toString(Charset.defaultCharset()));
    }
}
