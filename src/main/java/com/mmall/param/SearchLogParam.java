package com.mmall.param;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class SearchLogParam {

    private Integer type;

    // 更新之前的值
    private String beforeSeg;

    private String afterSeg;

    private String operator;

    // 开始时间
    private String fromTime;// yyyy-MM-dd HH:mm:ss

    private String toTime;// yyyy-MM-dd HH:mm:ss

}


