package com.fenzsen.blog.dao;

import com.fenzsen.blog.pojo.Setting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Description: 设置相关接口Dao
 * Date: 2020/8/9
 */
public interface SetiingDao extends JpaRepository<Setting,String>, JpaSpecificationExecutor<Setting> {
    Setting findOneByKey(String key);
}
