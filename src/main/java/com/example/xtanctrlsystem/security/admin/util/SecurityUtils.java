/*
 * Copyright (c) 2018-2999 广州市蓝海创新科技有限公司 All rights reserved.
 *
 * https://www.mall4j.com/
 *
 * 未经允许，不可做商业用途！
 *
 * 版权所有，侵权必究！
 */
package com.example.xtanctrlsystem.security.admin.util;


import com.example.xtanctrlsystem.security.admin.model.YamiSysUser;
import com.example.xtanctrlsystem.security.common.bo.UserInfoInTokenBO;
import com.example.xtanctrlsystem.security.common.util.AuthUserContext;
import lombok.experimental.UtilityClass;

/**
 *
 * @author panswa
 */
@UtilityClass
public class SecurityUtils {
    /**
     * 获取用户
     */
    public YamiSysUser getSysUser() {
        UserInfoInTokenBO userInfoInTokenBO = AuthUserContext.get();

        YamiSysUser details = new YamiSysUser();
        details.setUserId(Long.valueOf(userInfoInTokenBO.getUserId()));
        details.setEnabled(userInfoInTokenBO.getEnabled());
        details.setUsername(userInfoInTokenBO.getNickName());
        details.setAuthorities(userInfoInTokenBO.getPerms());
        details.setShopId(userInfoInTokenBO.getShopId());
        return details;
    }
}

