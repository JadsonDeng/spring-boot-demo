package com.jadson.study.mybatisplus.springbootmybatisplus.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author dengjunzhen
 * @date 2023-03-22 16:05
 * @since 1.0
 */
@Getter
@Setter
public class User {

    private Long id;
    private String name;
    private Integer age;
    private String email;

    private Integer isDeleted;
}
