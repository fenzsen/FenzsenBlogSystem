package com.fenzsen.blog.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * Date: 2020/8/7
 * Description: 轮播图实体
 */
@Entity
@Table(name = "tb_looper")
public class Looper {

    @Id
    @Column(name = "id")
    private String id;

    // 轮播图标题
    @Column(name = "title")
    private String title;

    // 顺序
    @Column(name = "order")
    private int order;

    // 状态
    @Column(name = "state")
    private int state;

    // 目标Url
    @Column(name = "target_url")
    private int targetUrl;

    // 图片地址
    @Column(name = "image_url")
    private int imageUrl;

    // 创建时间
    @Column(name = "create_time")
    private Timestamp createTime;

    // 更新时间
    @Column(name = "update_time")
    private Timestamp updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getTargetUrl() {
        return targetUrl;
    }

    public void setTargetUrl(int targetUrl) {
        this.targetUrl = targetUrl;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }
}
