# kafka-spark
kafka 和 spark学习

## kafka 准备工作

### 第一步，下载

windows 环境和 linux环境脚本不一致，Windows环境启动脚本路径为bin\windows\*.bat，而linux路径为bin/*.shell。<br/>
以 windows 为例，官网下载 http://kafka.apache.org/ (kafka_2.11-2.0.1，2.11表示scala版本，2.0.1表示kafka版本)：

### 第二步，启动服务

kafka启动必须先启动zookeeper，如果没有自己的zookeeper服务，这里kafka提供了自带的zookeeper服务。以下命令切换到kafka_2.11-2.0.1路径<br/>
1，先启动zookeeper服务，<br/><br/>
<code>bin\windows\zookeeper-server-start.bat config\zookeeper.properties</code><br/><br/>
2，启动kafka服务，<br/><br/>
<code>bin\windows\kafka-server-start.bat config\server.properties</code><br/><br/>
