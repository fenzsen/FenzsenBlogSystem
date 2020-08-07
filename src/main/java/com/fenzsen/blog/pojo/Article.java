package com.fenzsen.blog.pojo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * Date: 2020/8/8
 * Description: 文章实体
 */
@Entity
@Table(name = "tb_article")
public class Article {

    @Id
    @Column(name = "id")
    private String id;

    // 标题
    @Column(name = "title")
    private String title;

    // 用户id
    @Column(name = "user_id")
    private String userId;

    // 分类id
    @Column(name = "category_id")
    private String categoryId;

    // 文章内容
    @Column(name = "content")
    private String content;

    // 类型
    @Column(name = "type")
    private String type;

    // 状态
    @Column(name = "state")
    private String state;

    // 摘要
    @Column(name = "summary")
    private String summary;

    // 标签
    @Column(name = "labels")
    private String labels;

    // 阅读数量
    @Column(name = "view_count")
    private int viewCount;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getLabels() {
        return labels;
    }

    public void setLabels(String labels) {
        this.labels = labels;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
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
