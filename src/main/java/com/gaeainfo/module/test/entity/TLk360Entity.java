package com.gaeainfo.module.test.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Time;

/**
 * Created by dell on 2017/12/13.
 */

@Table(name = "T_LK360", schema = "KFPT", catalog = "")
public class TLk360Entity {
    private String pid;
    private String name;
    private String x;
    private String y;
    private String path;
    private String createrid;
    private Time createtime;
    private String delflag;

    @Basic
    @Column(name = "PID", nullable = false, length = 32)
    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    @Basic
    @Column(name = "NAME", nullable = true, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "X", nullable = true, length = 50)
    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    @Basic
    @Column(name = "Y", nullable = true, length = 50)
    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    @Basic
    @Column(name = "PATH", nullable = true, length = 50)
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Basic
    @Column(name = "CREATERID", nullable = true, length = 20)
    public String getCreaterid() {
        return createrid;
    }

    public void setCreaterid(String createrid) {
        this.createrid = createrid;
    }

    @Basic
    @Column(name = "CREATETIME", nullable = false)
    public Time getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Time createtime) {
        this.createtime = createtime;
    }

    @Basic
    @Column(name = "DELFLAG", nullable = false, length = 1)
    public String getDelflag() {
        return delflag;
    }

    public void setDelflag(String delflag) {
        this.delflag = delflag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TLk360Entity that = (TLk360Entity) o;

        if (pid != null ? !pid.equals(that.pid) : that.pid != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (x != null ? !x.equals(that.x) : that.x != null) return false;
        if (y != null ? !y.equals(that.y) : that.y != null) return false;
        if (path != null ? !path.equals(that.path) : that.path != null) return false;
        if (createrid != null ? !createrid.equals(that.createrid) : that.createrid != null) return false;
        if (createtime != null ? !createtime.equals(that.createtime) : that.createtime != null) return false;
        if (delflag != null ? !delflag.equals(that.delflag) : that.delflag != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pid != null ? pid.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (x != null ? x.hashCode() : 0);
        result = 31 * result + (y != null ? y.hashCode() : 0);
        result = 31 * result + (path != null ? path.hashCode() : 0);
        result = 31 * result + (createrid != null ? createrid.hashCode() : 0);
        result = 31 * result + (createtime != null ? createtime.hashCode() : 0);
        result = 31 * result + (delflag != null ? delflag.hashCode() : 0);
        return result;
    }
}
