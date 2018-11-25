package com.raoqiang.kafkaspark.kafkaDemo.serizlizer;

import com.alibaba.fastjson.JSON;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

/**
 * Created by raoqiang on 2018/11/21.
 */

/**
 * 对象序列化，将对象发往topic，序列化为byte[]
 * @param <T> 对象泛型
 */
public class ObjectSerializer<T> implements Serializer<T> {

    @Override
    public void configure(Map<String, ?> map, boolean b) {

    }

    /**
     * T对象转换成json byte[]
     * @param s topic
     * @param t 消息对象
     * @return
     */
    @Override
    public byte[] serialize(String s, T t) {
        if (t == null){
            return null;
        }
        return JSON.toJSONBytes(t);
    }

    @Override
    public void close() {

    }

}
