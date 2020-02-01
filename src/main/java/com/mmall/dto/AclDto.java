package com.mmall.dto;

import com.mmall.model.SysAcl;
import lombok.Data;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

@Data
@ToString
public class AclDto extends SysAcl {

    // 是否默认要选中
    private boolean checked = false;

    // 是否有权限操作
    private boolean hasAcl = false;

    public static AclDto adapt(SysAcl sysAcl) {
        AclDto aclDTO = new AclDto();
        BeanUtils.copyProperties(sysAcl, aclDTO);
        return aclDTO;
    }


}
