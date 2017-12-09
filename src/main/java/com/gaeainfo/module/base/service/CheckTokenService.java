package com.gaeainfo.module.base.service;

import com.gaeainfo.module.base.bo.GaeaToken;
import com.gaeainfo.module.base.dao.BaseRedisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Rock on 2017/5/2.
 */
@Service
public class CheckTokenService {

    //过期时间 30分钟
    private final static long EXPIRED_TIME = 1800;

    @Autowired
    private BaseRedisDao baseRedisDao;

    public GaeaToken getToken(String token){
        GaeaToken gaeaToken = baseRedisDao.get(token,GaeaToken.class);
        return gaeaToken;
    }

    public void saveToken(String token, GaeaToken gaeaToken){
        baseRedisDao.save(token,gaeaToken,EXPIRED_TIME);
    }

    public void resetExpired(String token){
        baseRedisDao.expired(token,EXPIRED_TIME);
    }

    public void deletedToken(String token){
        baseRedisDao.delete(token,GaeaToken.class);
    }
}
