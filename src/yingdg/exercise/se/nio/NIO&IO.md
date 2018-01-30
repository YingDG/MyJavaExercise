比较：

IO                NIO
面向流         面向缓冲
阻塞IO         非阻塞IO
无                 选择器

Java NIO: 单线程管理多个连接
使用场景：
    1.需要管理同时打开的成千上万个连接，这些连接每次只是发送少量的数据，例如聊天服务器
    2.维持许多打开的连接到其他计算机上，如P2P网络中，使用一个单独的线程来管理所有出站连接

Java IO: 多线程管理连接
使用场景：
    1.少量的连接使用非常高的带宽，一次发送大量的数据