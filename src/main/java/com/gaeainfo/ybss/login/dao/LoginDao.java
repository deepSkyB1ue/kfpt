package com.gaeainfo.ybss.login.dao;

import com.gaeainfo.ybss.login.dto.UserInfoDto;
import com.gaeainfo.ybss.login.dto.UserInfoDtoRequest;

public interface LoginDao {

    UserInfoDto getUserInfoData(UserInfoDtoRequest data);

}
