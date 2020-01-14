package com.mmall.param;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;


@Data
public class TestVo {

    @NotBlank
    private String msg;

    @NotNull
    private Integer id;
}
