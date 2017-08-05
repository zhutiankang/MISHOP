package com.northlight.latte.net;

/**
 * author : 祝天康
 * tips   : 写代码的思想，尽可能的把每个代码的类独立出来，不要把内部类堆到一个类文件里
 * 类多代码少，类多一些，每个类中的代码少一些，不要超过100行，极简洁，越少越好，区分的模块，架构更清晰一些
 * date   : 2017/7/27 09:37
 */

public enum  HttpMethod {
    GET,
    POST,
    POST_RAW, //原始数据
    PUT,
    PUT_RAW,
    DELETE,
    UPLOAD
}
