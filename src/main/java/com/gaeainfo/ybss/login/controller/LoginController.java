package com.gaeainfo.ybss.login.controller;

import com.gaeainfo.framework.core.basic.dto.BaseRequestDto;
import com.gaeainfo.framework.core.basic.dto.BaseResponseDto;
import com.gaeainfo.framework.core.utils.common.GaeaCommonUtil;
import com.gaeainfo.module.base.annotation.CheckRequestToken;
import com.gaeainfo.ybss.login.dto.UserInfoDto;
import com.gaeainfo.ybss.login.dto.UserInfoDtoRequest;
import com.gaeainfo.ybss.login.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Api(value = "Login", description = "登录模块")
@Controller
@RequestMapping(value = "login")
public class LoginController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private LoginService loginService;

    @ApiOperation(value = "用户登录", notes = "返回保存结果")
    @ResponseBody
//    @CheckRequestToken(false)
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public BaseResponseDto<String> login(@RequestBody BaseRequestDto<UserInfoDtoRequest> baseRequestDto, HttpSession session) {
        BaseResponseDto baseResponseDto = new BaseResponseDto();
        baseResponseDto.setTime(baseRequestDto.getTime());
        try {
            UserInfoDto userInfoDto = loginService.getUserInfoData(baseRequestDto.getData());
            if ("" != GaeaCommonUtil.trimToEmpty(userInfoDto.getIdentity())) {
                baseResponseDto.setData(userInfoDto);
                baseResponseDto.setSuccess(true);
            } else {
                baseResponseDto.setSuccess(false);
                baseResponseDto.setMsg("登录失败，请校验用户名或密码!");
            }
        } catch (Exception e) {
            baseResponseDto.setSuccess(false);
            baseResponseDto.setMsg("登录失败!");
            e.printStackTrace();
            logger.error("LoginController --> login error: 登录模块报错" + e.getMessage());
        }
        return baseResponseDto;
    }
}
