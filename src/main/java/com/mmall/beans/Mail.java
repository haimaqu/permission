package com.mmall.beans;

import lombok.*;

import java.util.Set;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Mail {

    // 邮件主题
    private String subject;

    // 邮件信息
    private String message;

    // 收件人邮箱
    private Set<String> receivers;


}
