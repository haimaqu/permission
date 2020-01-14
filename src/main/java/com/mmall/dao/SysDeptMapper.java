package com.mmall.dao;

import com.mmall.model.SysDept;

public interface SysDeptMapper {
    int deleteByPrimaryKey(Integer id);

    // 插入所有字段
    int insert(SysDept record);

    // 先进行判断，没有值的时候不进行处理，只插入有值的值
    int insertSelective(SysDept record);

    SysDept selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysDept record);

    int updateByPrimaryKey(SysDept record);
}