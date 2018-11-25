package com.raoqiang.kafkaspark.kafkaDemo.beans;

/**
 * Created by raoqiang on 2018/11/21.
 */

/**
 * message bean
 */
public class Message {

    private String header;

    private int states;

    private String body;

    private String describe;


    public Message() {
    }

    public Message(String header, int states, String body, String describe) {
        this.header = header;
        this.states = states;
        this.body = body;
        this.describe = describe;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public int getStates() {
        return states;
    }

    public void setStates(int states) {
        this.states = states;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @Override
    public String toString() {
        return "Message{" +
                "header='" + header + '\'' +
                ", states=" + states +
                ", body='" + body + '\'' +
                ", describe='" + describe + '\'' +
                '}';
    }
}
