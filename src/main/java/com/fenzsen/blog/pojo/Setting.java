package com.fenzsen.blog.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Date: 2020/8/7
 * Description: 设置实体
 */
@Entity
@Table(name = "tb_settings")
public class Setting {

    @Id
    @Column(name = "id")
    private String id;

    // 键    在 SQL 语句中为关键字，所以用反引号括起来
    @Column(name = "`key`")
    private String key;

    // 值    在 SQL 语句中为关键字，所以用反引号括起来
    @Column(name = "`value`")
    private int value;

    // 创建时间
    @Column(name = "create_time")
    private Date createTime;

    // 更新时间
    @Column(name = "update_time")
    private Date updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
