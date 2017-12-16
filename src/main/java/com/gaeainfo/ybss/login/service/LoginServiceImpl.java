package com.gaeainfo.ybss.login.service;

import com.gaeainfo.module.base.bo.GaeaToken;
import com.gaeainfo.module.base.service.CheckTokenService;
import com.gaeainfo.ybss.login.dao.LoginDao;
import com.gaeainfo.ybss.login.dto.UserInfoDto;
import com.gaeainfo.ybss.login.dto.UserInfoDtoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.util.Date;
import java.util.Properties;


@Service("loginService")
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginDao loginDao;

    @Autowired
    private CheckTokenService checkTokenService;

    @Override
    public UserInfoDto getUserInfoData(UserInfoDtoRequest data) throws Exception {
        UserInfoDto userInfo = loginDao.getUserInfoData(data);
        if (userInfo != null) {
            //判断登录人是否是管理员
            Properties prop = new Properties();
            prop.load(this.getClass().getResourceAsStream("/resources/adminList.properties"));
            userInfo.setIdentity(prop.stringPropertyNames().contains(userInfo.getUsername()) ? "admin" : "user");
            //获取登录人token
//            GaeaToken gaeaToken = new GaeaToken();
//            gaeaToken.setLoginName(userInfo.getUsername());
//            gaeaToken.setLoginTime(new Date());
//            gaeaToken.setUserInfo(userInfo);
//            gaeaToken.setRoleName(userInfo.getIdentity());
//            checkTokenService.saveToken(gaeaToken.getTokenId(), gaeaToken);
//            userInfo.setTokenId(gaeaToken.getTokenId());
        }
        return userInfo;
    }
}
