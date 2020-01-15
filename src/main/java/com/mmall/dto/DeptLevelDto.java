package com.mmall.dto;

import com.google.common.collect.Lists;
import com.mmall.model.SysDept;
import lombok.Data;
import lombok.ToString;
import org.springframework.beans.BeanUtils;
import sun.font.BidiUtils;

import java.util.List;

/**
 * dto包用来做适配用
 */
@Data
@ToString
public class DeptLevelDto extends SysDept {

    /**
     * 这样才满足一个树形结构
     */
    private List<DeptLevelDto> deptList = Lists.newArrayList();

    /**
     * 当传入SysDept时，直接把他转换成当前的结构
     */
    public static DeptLevelDto adapt(SysDept dept) {
        DeptLevelDto dto = new DeptLevelDto();
        BeanUtils.copyProperties(dept, dto);
        return dto;

    }

}












