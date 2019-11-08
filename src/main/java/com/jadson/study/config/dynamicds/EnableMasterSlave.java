package com.jadson.study.config.dynamicds;

import java.lang.annotation.*;

/**
 * 在类上使用此注解后，该类中以ReadOnly结尾的方法会切换到从库
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
public @interface EnableMasterSlave {
}
