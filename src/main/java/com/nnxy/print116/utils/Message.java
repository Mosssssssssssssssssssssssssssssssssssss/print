package com.nnxy.print116.utils;

import com.sun.tracing.dtrace.ArgsAttributes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class Message {
    private String status;
    private String msg;
    private Object object;
    public Message(String status,String msg){
        this.status = status;
        this.msg = msg;
    }
    public Message(String status,String msg,Object object){
        this.status = status;
        this.msg = msg;
        this.object = object;
    }
}
