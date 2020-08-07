package com.fenzsen.blog.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * Date: 2020/8/8
 * Description: 分类实体
 */
@Entity
@Table(name="tb_categories")
public class Categories {

    @Id
    @Column(name = "id")
    private String id ;

    // 分类名称
    @Column(name = "name")
    private String categoryName ;

    //分类拼音
    @Column(name = "pinyin")
    private String categoryPy ;

    //描述说明
    @Column(name = "description")
    private String description ;

    // 顺序
    @Column(name = "order")
    private Integer order;

    // 状态
    @Column(name = "status")
    private String status;

    // 创建时间
    @Column(name = "create_time")
    private java.sql.Timestamp createTime;

    // 更新时间
    @Column(name = "update_time")
    private java.sql.Timestamp updateTime;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryPy() {
        return categoryPy;
    }

    public void setCategoryPy(String categoryPy) {
        this.categoryPy = categoryPy;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }
}
