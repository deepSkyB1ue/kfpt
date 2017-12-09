package com.gaeainfo.module.test.service;

import com.gaeainfo.module.base.dao.BaseHibernateDao;
import com.gaeainfo.module.test.bo.Ouser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Created by Rock on 2017/3/17.
 */
@Service
public class OracleUserService {

    @Autowired
    private BaseHibernateDao baseHibernateDao;

    public void saveUser(String name){
        Ouser user = new Ouser();
        user.setId(UUID.randomUUID().toString());
        user.setName(name);
        baseHibernateDao.save(user);
    }

    public List<Ouser> getUserList(){
        return baseHibernateDao.loadAll(Ouser.class);
    }
}
