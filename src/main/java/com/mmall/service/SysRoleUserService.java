package com.mmall.service;

import com.mmall.dao.SysLogMapper;
import com.mmall.dao.SysRoleUserMapper;
import com.mmall.dao.SysUserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SysRoleUserService {

    @Resource
    private SysRoleUserMapper sysRoleUserMapper;
    @Resource
    private SysUserMapper sysUserMapper;
    @Resource
    private SysLogMapper sysLogMapper;

//    public List<SysUser> getListByRoleId(int roleId) {
//        List<Integer> userIdList = sysRoleUserMapper.getUserIdListByRoleId(roleId);
//        if (CollectionUtils.isEmpty(userIdList)) {
//            return Lists.newArrayList();
//        }
//        return sysUserMapper.getByIdList(userIdList);
//    }

//    public void changeRoleUsers(int roleId, List<Integer> userIdList) {
//        List<Integer> originUserIdList = sysRoleUserMapper.getUserIdListByRoleId(roleId);
//        if (originUserIdList.size() == userIdList.size()) {
//            Set<Integer> originUserIdSet = Sets.newHashSet(originUserIdList);
//            Set<Integer> userIdSet = Sets.newHashSet(userIdList);
//            originUserIdSet.removeAll(userIdSet);
//            if (CollectionUtils.isEmpty(originUserIdSet)) {
//                return;
//            }
//        }
//        updateRoleUsers(roleId, userIdList);
//        saveRoleUserLog(roleId, originUserIdList, userIdList);
//    }

//    @Transactional
//    private void updateRoleUsers(int roleId, List<Integer> userIdList) {
//        sysRoleUserMapper.deleteByRoleId(roleId);
//
//        if (CollectionUtils.isEmpty(userIdList)) {
//            return;
//        }
//        List<SysRoleUser> roleUserList = Lists.newArrayList();
//        for (Integer userId : userIdList) {
//            SysRoleUser roleUser = SysRoleUser.builder().roleId(roleId).userId(userId).operator(RequestHolder.getCurrentUser().getUsername())
//                    .operateIp(IpUtil.getRemoteIp(RequestHolder.getCurrentRequest())).operateTime(new Date()).build();
//            roleUserList.add(roleUser);
//        }
//        sysRoleUserMapper.batchInsert(roleUserList);
//    }
//    private void saveRoleUserLog(int roleId, List<Integer> before, List<Integer> after) {
//        SysLogWithBLOBs sysLog = new SysLogWithBLOBs();
//        sysLog.setType(LogType.TYPE_ROLE_USER);
//        sysLog.setTargetId(roleId);
//        sysLog.setOldValue(before == null ? "" : JsonMapper.obj2String(before));
//        sysLog.setNewValue(after == null ? "" : JsonMapper.obj2String(after));
//        sysLog.setOperator(RequestHolder.getCurrentUser().getUsername());
//        sysLog.setOperateIp(IpUtil.getRemoteIp(RequestHolder.getCurrentRequest()));
//        sysLog.setOperateTime(new Date());
//        sysLog.setStatus(1);
//        sysLogMapper.insertSelective(sysLog);
//    }
}
