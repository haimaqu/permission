package com.mmall.dao;

import com.mmall.model.SysRoleAcl;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysRoleAclMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysRoleAcl record);

    int insertSelective(SysRoleAcl record);

    SysRoleAcl selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysRoleAcl record);

    int updateByPrimaryKey(SysRoleAcl record);

    // 相当于传入多个角色id，分别查出他们合在一起的权限点的。。总和
    List<Integer> getAclIdListByRoleIdList(@Param("roleIdList") List<Integer> roleIdList);

    // roleId不能为空，所以不能用Integer
    int deleteByRoleId(@Param("roleId")int roleId);

    void batchInsert(@Param("roleAclList") List<SysRoleAcl> roleAclList);

    List<Integer> getRoleIdListByAclId(@Param("aclId")int aclId);



}