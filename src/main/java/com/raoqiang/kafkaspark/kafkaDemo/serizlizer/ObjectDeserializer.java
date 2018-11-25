package com.raoqiang.kafkaspark.kafkaDemo.serizlizer;

import com.alibaba.fastjson.JSON;
import org.apache.kafka.common.serialization.Deserializer;

import java.lang.reflect.ParameterizedType;
import java.util.Map;

/**
 * Created by raoqiang on 2018/11/21.
 */

/**
 * message反序列化
 * @param <T>
 */
public class ObjectDeserializer<T> implements Deserializer<T> {

    @Override
    public void configure(Map<String, ?> map, boolean b) {

    }

    /**
     * message 反序列化为对象
     * @param s topic
     * @param bytes json字节数组
     * @return T 实列
     */
    @Override
    public T deserialize(String s, byte[] bytes) {
        if(bytes == null)
            return null;
        return JSON.parseObject(bytes, ((ParameterizedType) getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0]);
    }

    @Override
    public void close() {

    }



}
