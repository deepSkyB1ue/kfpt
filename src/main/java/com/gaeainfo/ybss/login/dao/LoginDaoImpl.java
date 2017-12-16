package com.gaeainfo.ybss.login.dao;

import com.gaeainfo.module.base.dao.BaseHibernateDao;
import com.gaeainfo.ybss.login.dto.UserInfoDto;
import com.gaeainfo.ybss.login.dto.UserInfoDtoRequest;
import org.apache.commons.collections.CollectionUtils;
import org.hibernate.SessionFactory;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

@Repository("loginDao")
public class LoginDaoImpl extends BaseHibernateDao implements LoginDao {

    @Autowired
    private SessionFactory ybssSessionFactory;

    @PostConstruct
    public void injectSessionFactory() {
        super.setSessionFactory(ybssSessionFactory);
    }

    @Override
    public UserInfoDto getUserInfoData(UserInfoDtoRequest data) {
        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" select t.jh as \"username\",t.user_realname as \"realname\",t.company as \"dept\", ");
        sqlBuffer.append(" '' as \"tokenId\",'' as \"identity\" ");
        sqlBuffer.append(" from user_list t  ");
        sqlBuffer.append(" where t.user_name = '" + data.getUsername() + "'");
        sqlBuffer.append(" and t.password = '" + data.getPassword() + "'");
        sqlBuffer.append(" and t.status = '1'");
        List<UserInfoDto> userInfoDtos = findListBySQL(sqlBuffer.toString(), UserInfoDto.class);
        if (CollectionUtils.isNotEmpty(userInfoDtos)) {
            return userInfoDtos.get(0);
        } else {
            return null;
        }
    }
}
