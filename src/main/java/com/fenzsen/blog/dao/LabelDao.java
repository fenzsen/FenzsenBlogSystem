package com.fenzsen.blog.dao;

import com.fenzsen.blog.pojo.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * Description: 标签DAO接口
 * Date: 2020/8/8
 */
public interface LabelDao extends JpaRepository<Label,String>, JpaSpecificationExecutor<Label> {

    // 自定义的 JPQL 完成 UPDATE 和 DELETE 操作需要加 @Modifying
    @Modifying
    int deleteOneById(String id);

    // 使用 SQL 语句进行操作
    @Modifying  // 自定义注解
    // @Query 自定义 SQL 语句，但是必须声明 nativeQuery = true 才可以使用自定义 SQL 语句
    @Query(value = "DELETE FROM `tb_labels` WHERE id = ?",nativeQuery = true)
    int customDeleteItemById(String id);

    // 根据id查找一个 Label
    Label findOneById(String id);

}
