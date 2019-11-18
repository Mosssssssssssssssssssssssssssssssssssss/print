package com.nnxy.print116.entity;

import lombok.Data;

@Data
public class Print {
    private String number;
    private String pageSize;
    private String printStyle;
    private String printColor;
    private String note;
    private Long gmtCreate;
    private Long gmtModify;
    private String fileName;
    private String path;
    private Integer flag;
}
