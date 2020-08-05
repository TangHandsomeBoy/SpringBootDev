package com.itcast.demo.domain;

import lombok.Data;

@Data
public class KafkaElk {
    private String level;
    private String trace;
    private String remoteIp;
    private String span;
    private String parent;
    private String thread;
    private String clas;
    private String message;
    private String stack_trace;
}
