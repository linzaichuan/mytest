package com.itheima.dao;

import com.itheima.domain.SysLog;
import org.apache.ibatis.annotations.Insert;

public interface ISysLogDao {


    @Insert("INSERT into sys_log VALUES (seq_log.nextval,#{visitTime},#{username},#{ip},#{method})")
    void insertLog(SysLog sysLog);

}
