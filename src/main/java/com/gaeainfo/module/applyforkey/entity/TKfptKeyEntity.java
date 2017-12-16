package com.gaeainfo.module.applyforkey.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by dell on 2017/12/13.
 */
@Entity
@Table(name = "T_KFPT_KEY", schema = "KFPT", catalog = "")
public class TKfptKeyEntity {
    private String pid;
    private String androidmd5;
    private String packagename;
    private String servermd5;
    private String url;
    private String appname;
    private String company;
    private String contactname;
    private String contactnumber;
    private String status;
    private String auditpersonid;
    private String audittime;
    private String createrid;

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "PID", nullable = false, length = 32)
    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    @Basic
    @Column(name = "ANDROIDMD5", nullable = true, length = 50)
    public String getAndroidmd5() {
        return androidmd5;
    }

    public void setAndroidmd5(String androidmd5) {
        this.androidmd5 = androidmd5;
    }

    @Basic
    @Column(name = "PACKAGENAME", nullable = true, length = 50)
    public String getPackagename() {
        return packagename;
    }

    public void setPackagename(String packagename) {
        this.packagename = packagename;
    }

    @Basic
    @Column(name = "SERVERMD5", nullable = true, length = 50)
    public String getServermd5() {
        return servermd5;
    }

    public void setServermd5(String servermd5) {
        this.servermd5 = servermd5;
    }

    @Basic
    @Column(name = "URL", nullable = true, length = 50)
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "APPNAME", nullable = true, length = 50)
    public String getAppname() {
        return appname;
    }

    public void setAppname(String appname) {
        this.appname = appname;
    }

    @Basic
    @Column(name = "COMPANY", nullable = true, length = 50)
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Basic
    @Column(name = "CONTACTNAME", nullable = true, length = 20)
    public String getContactname() {
        return contactname;
    }

    public void setContactname(String contactname) {
        this.contactname = contactname;
    }

    @Basic
    @Column(name = "CONTACTNUMBER", nullable = true, length = 20)
    public String getContactnumber() {
        return contactnumber;
    }

    public void setContactnumber(String contactnumber) {
        this.contactnumber = contactnumber;
    }

    @Basic
    @Column(name = "STATUS", nullable = false, length = 1)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "AUDITPERSONID", nullable = true, length = 20)
    public String getAuditpersonid() {
        return auditpersonid;
    }

    public void setAuditpersonid(String auditpersonid) {
        this.auditpersonid = auditpersonid;
    }

    @Basic
    @Column(name = "AUDITTIME", nullable = true, length = 20)
    public String getAudittime() {
        return audittime;
    }

    public void setAudittime(String audittime) {
        this.audittime = audittime;
    }

    @Basic
    @Column(name = "CREATERID", nullable = true, length = 20)
    public String getCreaterid() {
        return createrid;
    }

    public void setCreaterid(String createrid) {
        this.createrid = createrid;
    }


}
