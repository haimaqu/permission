package com.mmall.dto;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

// 数据库里查询需要的类
// 参数与SearchLogParam一样
@Data
@ToString
public class SearchLogDto {

    private Integer type;

    // 更新之前的值
    private String beforeSeg;

    private String afterSeg;

    private String operator;

    // 开始时间
    private Date fromTime;// yyyy-MM-dd HH:mm:ss

    private Date toTime;// yyyy-MM-dd HH:mm:ss

}
