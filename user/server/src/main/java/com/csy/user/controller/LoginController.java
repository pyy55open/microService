package com.csy.user.controller;

import com.csy.user.VO.ResultVO;
import com.csy.user.constant.CookieConstant;
import com.csy.user.constant.RedisConstant;
import com.csy.user.dataobject.User;
import com.csy.user.enums.ResultEnum;
import com.csy.user.enums.RoleEnum;
import com.csy.user.service.UserService;
import com.csy.user.utils.CookieUtil;
import com.csy.user.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @PostMapping("buyer")
    public ResultVO buyer (@RequestParam("openid") String openid, HttpServletRequest request, HttpServletResponse response){
        //openid校验登录
        User user = userService.findByOpenId(openid);
        if(user == null){
            return ResultVOUtil.error(ResultEnum.ERROR);
        }

        //校验用户类型，卖家、买家
        if(user.getRole() != RoleEnum.BUYER.getCode()){
            return ResultVOUtil.error(ResultEnum.ROLE_ERROE);
        }

        //设置cookie
        CookieUtil.set(response,CookieConstant.OPENID,openid,CookieConstant.expire);

        return ResultVOUtil.error(ResultEnum.SUCCESS);
    }

    @PostMapping("seller")
    public ResultVO seller (@RequestParam("openid") String openid, HttpServletRequest request, HttpServletResponse response){
        Cookie cookie = CookieUtil.get(request,CookieConstant.TOKEN);
        if(cookie!=null && !StringUtils.isEmpty(stringRedisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_TEMPLATE,cookie.getValue())))){
            return ResultVOUtil.success();
        }

        //openid校验登录
        User user = userService.findByOpenId(openid);
        if(user == null){
            return ResultVOUtil.error(ResultEnum.ERROR);
        }

        //校验用户类型，卖家、买家
        if(user.getRole() != RoleEnum.SELLER.getCode()){
            return ResultVOUtil.error(ResultEnum.ROLE_ERROE);
        }

        //cookie存进redis
        String token = UUID.randomUUID().toString();
        Integer expire = CookieConstant.expire;
        stringRedisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_TEMPLATE,token),openid,expire,TimeUnit.SECONDS);

        //设置cookie
        CookieUtil.set(response,CookieConstant.TOKEN,token,CookieConstant.expire);

        return ResultVOUtil.error(ResultEnum.SUCCESS);
    }
}
