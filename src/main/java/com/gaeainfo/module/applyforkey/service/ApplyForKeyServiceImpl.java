package com.gaeainfo.module.applyforkey.service;


import com.gaeainfo.framework.core.utils.common.GaeaCommonUtil;
import com.gaeainfo.module.applyforkey.dao.ApplyForKeyDao;
import com.gaeainfo.module.applyforkey.entity.TAuditEntityRequest;
import com.gaeainfo.module.applyforkey.entity.TKfptKeyEntity;
import com.gaeainfo.module.base.dao.BaseHibernateDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.util.Map;
import java.util.Properties;


@Service("ApplyForKeyService")
public class ApplyForKeyServiceImpl implements ApplyForKeyService {

    @Autowired
    private ApplyForKeyDao applyForKeyDao;

    @Autowired
    private BaseHibernateDao baseHibernateDao;

    @Override
    public String insert(TKfptKeyEntity obj) throws Exception {
        String beforeEncryption = GaeaCommonUtil.trimToEmpty(obj.getAndroidmd5()) + GaeaCommonUtil.trimToEmpty(obj.getPackagename());
        //生成实现指定摘要算法的 MessageDigest 对象。
        MessageDigest md = MessageDigest.getInstance("MD5");
        //使用指定的字节数组更新摘要。
        md.update(beforeEncryption.getBytes());
        //通过执行诸如填充之类的最终操作完成哈希计算。
        byte b[] = md.digest();
        //生成具体的md5密码到buf数组
        int i;
        StringBuffer buf = new StringBuffer("");
        for (int offset = 0; offset < b.length; offset++) {
            i = b[offset];
            if (i < 0) {
                i += 256;
            }
            if (i < 16) {
                buf.append("0");
            }
            buf.append(Integer.toHexString(i));
        }
        obj.setServermd5(buf.toString());
        if ("" == GaeaCommonUtil.trimToEmpty(obj.getPid())) {
            baseHibernateDao.save(obj);
        } else {
            baseHibernateDao.update(obj);
        }
        return buf.toString();
    }

    @Override
    public Map<String, Object> getInfo(String username, String pageInfo) throws Exception {
        //判断登录人是否是管理员
        Properties prop = new Properties();
        prop.load(this.getClass().getResourceAsStream("/resources/adminList.properties"));
        username = prop.stringPropertyNames().contains(username) ? "" : username;
        return applyForKeyDao.getInfo(username, Integer.parseInt(pageInfo.split("_")[1]));
    }

    @Override
    public void delete(String pid) throws Exception {
        baseHibernateDao.deleteByPidAndTableName(pid, "T_KFPT_KEY");
    }

    @Override
    public void audit(TAuditEntityRequest obj) throws Exception {
        String sql = "UPDATE T_KFPT_KEY T SET T.status=1,t.auditpersonid='" + obj.getAuditpersonid() + "',T.audittime=to_char(sysdate,'yyyy-mm-dd hh24:mi:ss') WHERE T.PID = '" + obj.getPid() + "'";
        baseHibernateDao.getSession().createSQLQuery(sql).executeUpdate();
    }
}
