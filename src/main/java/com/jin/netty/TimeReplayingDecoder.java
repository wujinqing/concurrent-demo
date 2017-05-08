package com.jin.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

/**
 * @author wu.jinqing
 * @date 2017年05月08日
 */
public class TimeReplayingDecoder extends ReplayingDecoder<Void> {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        System.out.println("TimeReplayingDecoder decode invoked!");
        out.add(in.readBytes(4));
    }
}
