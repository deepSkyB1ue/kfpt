package com.gaeainfo.module.applyforkey.dao;


import com.gaeainfo.framework.core.utils.common.GaeaCommonUtil;
import com.gaeainfo.module.base.dao.BaseHibernateDao;
import org.apache.commons.collections.map.HashedMap;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository("ApplyForKeyDao")
public class ApplyForKeyDaoImpl implements ApplyForKeyDao {

    @Autowired
    private BaseHibernateDao baseHibernateDao;

    @Override
    public Map<String, Object> getInfo(String str, int pageNum) throws Exception {
        int pageSize = 6;
        String sql = "select t.pid as \"pid\",t.androidmd5 as \"androidmd5\",t.packagename as \"packagename\",t.servermd5 as \"servermd5\",t.url as \"url\",t.appname as \"appname\",t.company as \"company\",t.contactname as \"contactname\",t.contactnumber as \"contactnumber\" from T_KFPT_KEY t where t.delflag = 0 and t.status=0";
        if ("" != GaeaCommonUtil.trimToEmpty(str)) {
            sql += "and t.createrid = '" + str + "'";
        }
        sql += " order by createtime desc";
        Map<String, Object> map = new HashedMap();
        Query sqlQuery = baseHibernateDao.getSessionFactory().getCurrentSession().createSQLQuery(sql);
        sqlQuery.setFirstResult((pageNum - 1) * pageSize);
        sqlQuery.setMaxResults(pageSize);
        sqlQuery.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        map.put("pageNum", pageNum);
        map.put("pageSize", pageSize);
        map.put("pageData", sqlQuery.list());
        List<Object[]> objectList = baseHibernateDao.queryListBySql(" select to_char(count(1)) from (" + sql + ")");
        int totalSize = Integer.parseInt(GaeaCommonUtil.trimToEmpty(objectList.get(0)));
        map.put("totalSize", totalSize);
        return map;
    }


}