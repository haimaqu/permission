package com.mmall.beans;

/**
 * 记录更新的类型
 */
public interface LogType {

    // 更新的类型
    int TYPE_DEPT = 1;

    int TYPE_USER = 2;

    int TYPE_ACL_MODULE = 3;

    int TYPE_ACL = 4;

    int TYPE_ROLE = 5;

    int TYPE_ROLE_ACL = 6;

    // 角色用户的更新
    int TYPE_ROLE_USER = 7;

}
