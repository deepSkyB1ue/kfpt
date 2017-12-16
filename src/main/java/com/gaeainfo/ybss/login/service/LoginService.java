package com.gaeainfo.ybss.login.service;

import com.gaeainfo.ybss.login.dto.UserInfoDto;
import com.gaeainfo.ybss.login.dto.UserInfoDtoRequest;

public interface LoginService {

    UserInfoDto getUserInfoData(UserInfoDtoRequest data) throws Exception;
}
