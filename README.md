# kafka-spark
kafka 和 spark学习

## kafka 准备工作

### 第一步，下载

windows 环境和 linux环境脚本不一致，Windows环境启动脚本路径为bin\windows\\\*.bat，而linux路径为bin/*.shell。<br/>
以 windows 为例，官网下载 http://kafka.apache.org/ (kafka_2.11-2.0.1，2.11表示scala版本，2.0.1表示kafka版本)：

### 第二步，启动服务

kafka启动必须先启动zookeeper，如果没有自己的zookeeper服务，这里kafka提供了自带的zookeeper服务。以下命令切换到kafka_2.11-2.0.1路径<br/>
1，先启动zookeeper服务<br/><br/>
<code>bin\windows\zookeeper-server-start.bat config\zookeeper.properties</code><br/><br/>
2，启动kafka服务<br/><br/>
<code>bin\windows\kafka-server-start.bat config\server.properties</code><br/><br/>
3，创建topic<br/><br/>
<code>bin\windows\kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 5 --topic test</code><br/>
replication-factor代表可用副本数量，partitions代表分区数量.<br/>
查看创建的所有topic <code>bin\windows\kafka-topics.bat --list --zookeeper localhost:2181</code>.<br/>
查看创建的topic详细信息 <code>bin\windows\kafka-topics.bat --describe --zookeeper localhost:2181 --topic test</code>.<br/>
```
Topic:test      PartitionCount:5        ReplicationFactor:1     Configs:
        Topic: test     Partition: 0    Leader: 0       Replicas: 0     Isr: 0
        Topic: test     Partition: 1    Leader: 0       Replicas: 0     Isr: 0
        Topic: test     Partition: 2    Leader: 0       Replicas: 0     Isr: 0
        Topic: test     Partition: 3    Leader: 0       Replicas: 0     Isr: 0
        Topic: test     Partition: 4    Leader: 0       Replicas: 0     Isr: 0
```
其中：Topic表示topic名称，Partition表示分区号，Leader表示目前主broker（负责读写）,Replicas表示分区所在broker，Isr表示所有当前可用broker.<br/><br/>
>"leader" is the node responsible for all reads and writes for the given partition. Each node will be the leader for a randomly selected portion of the partitions.<br/>
>"replicas" is the list of nodes that replicate the log for this partition regardless of whether they are the leader or even if they are currently alive.<br/>
>"isr" is the set of "in-sync" replicas. This is the subset of the replicas list that is currently alive and caught-up to the leader.<br/>
 
4，启动生产者，向topic发送message<br/><br/>
`bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic test`<br/>
可在命令行输入发送的message内容<br/><br/>
5，启动消费者，消费指定topic的message<br/><br/>
`bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic test --from-beginning`<br/>
任何在生产者窗口输入的message将会在消费者窗口展示
