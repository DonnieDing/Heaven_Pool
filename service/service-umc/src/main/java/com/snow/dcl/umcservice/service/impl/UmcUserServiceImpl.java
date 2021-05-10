package com.snow.dcl.umcservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.snow.dcl.commonbase.exceptionhandler.CustomException;
import com.snow.dcl.commonutils.JwtUtils;
import com.snow.dcl.commonutils.MD5Utils;
import com.snow.dcl.umcservice.entity.UmcUser;
import com.snow.dcl.umcservice.entity.vo.LoginVo;
import com.snow.dcl.umcservice.entity.vo.RegisterVo;
import com.snow.dcl.umcservice.mapper.UmcUserMapper;
import com.snow.dcl.umcservice.service.UmcUserService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 会员表 服务实现类
 * </p>
 *
 * @author Dcl_Snow
 * @since 2020-11-27
 */
@Service
public class UmcUserServiceImpl extends ServiceImpl<UmcUserMapper, UmcUser> implements UmcUserService {

    @Resource
    RedisTemplate<String, String> redisTemplate;

    @Override
    public void register(RegisterVo registerVo) {
        String mobile = registerVo.getMobile();
        String password = registerVo.getPassword();
        String nickname = registerVo.getNickname();
        String code = registerVo.getCode();

        String mobileCode = redisTemplate.opsForValue().get(mobile);
        if (!code.equals(mobileCode)) {
            throw new CustomException(20001, "验证码错误！");
        }

        QueryWrapper<UmcUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("mobile", mobile);
        Integer count = baseMapper.selectCount(queryWrapper);
        if (count > 0) {
            throw new CustomException(20001, "该手机号已经注册！");
        }

        UmcUser umcUser = new UmcUser();
        umcUser.setMobile(mobile);
        umcUser.setPassword(MD5Utils.encrypt(password));
        umcUser.setNickname(nickname);
        umcUser.setIsDisabled(false);
        baseMapper.insert(umcUser);
    }

    @Override
    public String login(LoginVo loginVo) {
        String mobile = loginVo.getMobile();
        String password = loginVo.getPassword();
        QueryWrapper<UmcUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("mobile", mobile);
        UmcUser umcUser = baseMapper.selectOne(queryWrapper);
        if (null == umcUser) {
            throw new CustomException(20001, "用户不存在！");
        }
        if (!MD5Utils.encrypt(password).equals(umcUser.getPassword())) {
            throw new CustomException(20001, "用户名或密码错误！");
        }
        if (umcUser.getIsDisabled()) {
            throw new CustomException(20001, "该用户已经被禁用，请联系系统管理员！");
        }
        String token = JwtUtils.createJwtToken(umcUser.getId(), umcUser.getNickname());
        return token;
    }

    @Override
    public UmcUser getUmcUserInfo(HttpServletRequest request) {
        String umcUserId = JwtUtils.getIdByJwtToken(request);
        UmcUser umcUser = baseMapper.selectById(umcUserId);
        return umcUser;
    }

    @Override
    public int countRegisterByDay(String day) {
        return baseMapper.countRegisterByDay(day);
    }
}
