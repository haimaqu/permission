package com.mmall.service;


import com.google.common.base.Preconditions;
import com.mmall.dao.SysUserMapper;
import com.mmall.exception.ParamException;
import com.mmall.model.SysUser;
import com.mmall.param.UserParam;
import com.mmall.util.BeanValidator;
import com.mmall.util.MD5Util;
import com.mmall.util.PasswordUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;

    public void save(UserParam param) {
        BeanValidator.check(param);
        if(checkTelephoneExist(param.getTelephone(), param.getId())) {
            throw new ParamException("电话已被占用");
        }
        if(checkEmailExist(param.getMail(), param.getId())) {
            throw new ParamException("邮箱已被占用");
        }
        String password = PasswordUtil.randomPassword();
        // TODO
        password = "12345678";
        String encryptedPassword = MD5Util.encrypt(password);
        SysUser user = SysUser.builder().username(param.getUsername()).telephone(param.getTelephone()).mail(param.getMail())
                .password(encryptedPassword).deptId(param.getDeptId()).status(param.getStatus()).remark(param.getRemark()).build();
        user.setOperator("system");
        user.setOperateIp("127.0.0.1");
        user.setOperateTime(new Date());

        // TODO: sendEmail

        sysUserMapper.insertSelective(user);
    }


    public void update(UserParam param) {
        BeanValidator.check(param);
        if(checkTelephoneExist(param.getTelephone(), param.getId())) {
            throw new ParamException("电话已被占用");
        }
        if(checkEmailExist(param.getMail(), param.getId())) {
            throw new ParamException("邮箱已被占用");
        }
        SysUser before = sysUserMapper.selectByPrimaryKey(param.getId());
        Preconditions.checkNotNull(before, "待更新的用户不存在");
        SysUser after = SysUser.builder().id(param.getId()).username(param.getUsername()).telephone(param.getTelephone()).mail(param.getMail())
                .deptId(param.getDeptId()).status(param.getStatus()).remark(param.getRemark()).build();
        // updateByPrimaryKeySelective是根据值进行更新的，有值才更新，所以after里password值没有的话，就不会更新，即可以不写password
        sysUserMapper.updateByPrimaryKeySelective(after);

    }

    // 登录是使用手机号或邮箱进行的，同一部门下用户名可以相同，所以名字可以不用检查
    public boolean checkEmailExist(String mail, Integer userId) {
        return false;
//        return sysUserMapper.countByMail(mail, userId) > 0;
    }

    public boolean checkTelephoneExist(String telephone, Integer userId) {
        return false;
//        return sysUserMapper.countByTelephone(telephone, userId) > 0;
    }}
