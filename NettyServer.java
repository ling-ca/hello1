package com.ling.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;


public class NettyServer {
    public static void main(String[] args) throws InterruptedException {

        /**
         * 主线程池，处理客户端的链接
         */
        NioEventLoopGroup main = new NioEventLoopGroup();
        /**
         * 从线程池，处理客户端的读写
         */
        NioEventLoopGroup sub = new NioEventLoopGroup();

        //创建netty引导类，配置，串联一系列的netty组件
        ServerBootstrap bootstrap = new ServerBootstrap();

        //1.设置netty的线程模型
        bootstrap.group(main, sub);
        //2.设置netty的通道类型
        bootstrap.channel(NioServerSocketChannel.class);
        //3.设置客户端处理器
        bootstrap.childHandler(new ServerHandler());
        //4.异步绑定端口号
        ChannelFuture channelFuture = bootstrap.bind(8081);//拿到绑定成功的消息
        channelFuture.sync();//阻塞住，直到服务端成功绑定端口号

        System.out.println("绑定成功！服务端成功启动！");






    }
}
