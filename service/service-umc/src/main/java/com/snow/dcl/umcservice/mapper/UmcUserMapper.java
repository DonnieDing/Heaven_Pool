package com.snow.dcl.umcservice.mapper;

import com.snow.dcl.umcservice.entity.UmcUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 会员表 Mapper 接口
 * </p>
 *
 * @author Dcl_Snow
 * @since 2020-11-27
 */
public interface UmcUserMapper extends BaseMapper<UmcUser> {

    int countRegisterByDay(String day);
}
