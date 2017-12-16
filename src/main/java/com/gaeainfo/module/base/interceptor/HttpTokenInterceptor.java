package com.gaeainfo.module.base.interceptor;

import com.alibaba.fastjson.JSON;
import com.gaeainfo.framework.core.basic.dto.BaseResponseDto;
import com.gaeainfo.framework.core.utils.common.GaeaCommonUtil;
import com.gaeainfo.module.base.annotation.CheckRequestToken;
import com.gaeainfo.module.base.bo.GaeaToken;
import com.gaeainfo.module.base.constant.CommValue;
import com.gaeainfo.module.base.service.CheckTokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Rock on 2017/4/28.
 */
public class HttpTokenInterceptor extends HandlerInterceptorAdapter {

    private final static String TOKEN_NAME = "kfptToken";

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CheckTokenService checkTokenService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod method = (HandlerMethod) handler;
            com.gaeainfo.module.base.annotation.CheckRequestToken checkRequestToken = method.getMethodAnnotation(CheckRequestToken.class);
            if (checkRequestToken == null || (checkRequestToken != null && checkRequestToken.value())) {
                GaeaToken gaeaToken = null;
                boolean authToken = false;
                boolean authRole = false;

                String token = request.getHeader(TOKEN_NAME);
                PrintWriter out = response.getWriter();
                BaseResponseDto baseResponseDto = new BaseResponseDto();
                try {
                    if (!GaeaCommonUtil.isNullOrEmpty(token)) {
                        gaeaToken = checkTokenService.getToken(token);

                        if (gaeaToken != null) {
                            authToken = true;
                            if (checkRequestToken != null && checkRequestToken.roleName().length > 0) {
                                List<String> list = Arrays.asList(checkRequestToken.roleName());
                                if (list.contains(gaeaToken.getRoleName())) {
                                    authRole = true;
                                }
                            } else if (checkRequestToken != null && checkRequestToken.excludeRoleName().length > 0) {
                                List<String> list = Arrays.asList(checkRequestToken.excludeRoleName());
                                if (!list.contains(gaeaToken.getRoleName())) {
                                    authRole = true;
                                }
                            } else {
                                authRole = true;
                            }
                        }
                    }
                } catch (Exception e) {
                    logger.error("用户权限验证异常！！！", e);
                }
                if (!authToken) {
                    baseResponseDto.setMsg("用户验证失败！");
                    baseResponseDto.setCode(CommValue.ERROR_USER_TOKEN);
                    baseResponseDto.setSuccess(false);
                    out.print(JSON.toJSONString(baseResponseDto));
                    return false;
                } else if (!authRole) {
                    baseResponseDto.setMsg("权限验证失败！");
                    baseResponseDto.setCode(CommValue.ERROR_USER_ROLE);
                    baseResponseDto.setSuccess(false);
                    out.print(JSON.toJSONString(baseResponseDto));
                    return false;
                } else {
                    checkTokenService.resetExpired(token);
                    request.setAttribute(TOKEN_NAME, gaeaToken);
                }
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e) throws Exception {

    }
}