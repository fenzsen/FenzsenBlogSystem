package com.fenzsen.blog.dao;

import com.fenzsen.blog.pojo.FenUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Description: 用户相关接口Dao
 * Date: 2020/8/9
 */
public interface UserDao extends JpaRepository<FenUser,String>, JpaSpecificationExecutor<FenUser> {



}
