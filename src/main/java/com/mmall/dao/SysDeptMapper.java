package com.mmall.dao;
import org.apache.ibatis.annotations.Param;


import com.mmall.model.SysDept;

import java.util.List;


@SuppressWarnings("ALL")
public interface SysDeptMapper {
    int deleteByPrimaryKey(@Param("id") Integer id);

    // 插入所有字段
    int insert(SysDept record);

    // 先进行判断，没有值的时候不进行处理，只插入有值的值
    int insertSelective(SysDept record);

    SysDept selectByPrimaryKey(@Param("id") Integer id);

    int updateByPrimaryKeySelective(SysDept record);

    int updateByPrimaryKey(SysDept record);

    /**
     * 获取当前用户的部门列表
     */
    List<SysDept> getAllDept();

    // 当数据库定义了level后，只要一条sql就可以查出当前部门的所有子部门，
    // 因为他们前缀是一致的，同样前缀的都是属于当前这棵树的子部门
    List<SysDept> getChildDeptListByLevel(@Param("level")String level);

    void batchUpdateLevel(@Param("sysDeptList") List<SysDept> sysDeptList);

    int countByNameAndParentId(@Param("parentId") Integer parentId, @Param("name") String name, @Param("id") Integer id);






}