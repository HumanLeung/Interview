package com.company.nio;

/*
一、 缓冲区(buffer) : 在Java NIO 中负责数据的存取. 缓冲区就是数据. 用于存储不同的数据类型的数据
根据数据类型不同（boolean除外）
ByteBuffer
CharBuffer
ShortBuffer
IntBuffer
LongBuffer
FloatBuffer
DoubleBuffer


上述缓冲区的管理方式几乎一致， 通过allocate() 获取缓冲区

二、 缓冲区存取数据的两个核心方法:
 put(): 存入数据到缓冲区中
 get(): 获取缓冲区中的数据

三、缓冲区中的四个核心属性:
capacity : 容量, 表示缓冲区中最大存储数据的容量.
 */

import java.nio.ByteBuffer;

public class Demo2 {
    public static void main(String[] args) {
        ByteBuffer buf = ByteBuffer.allocate(1024);

    }
}
