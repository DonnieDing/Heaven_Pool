package com.snow.dcl.umcservice.service;

import com.snow.dcl.umcservice.entity.UmcUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.snow.dcl.umcservice.entity.vo.LoginVo;
import com.snow.dcl.umcservice.entity.vo.RegisterVo;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 会员表 服务类
 * </p>
 *
 * @author Dcl_Snow
 * @since 2020-11-27
 */
public interface UmcUserService extends IService<UmcUser> {

    String login(LoginVo loginVo);

    void register(RegisterVo registerVo);

    UmcUser getUmcUserInfo(HttpServletRequest request);

    int countRegisterByDay(String day);
}
