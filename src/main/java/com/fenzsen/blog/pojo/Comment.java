package com.fenzsen.blog.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * Date: 2020/8/8
 * Description: 评论实体
 */
@Entity
@Table(name = "tb_comment")
public class Comment {

    @Id
    @Column(name = "id")
    private String id;

    // 父内容
    @Column(name = "parent_content")
    private String parentContent;

    // 文章Id
    @Column(name = "article_id")
    private String articleId;

    // 评论内容
    @Column(name = "content")
    private String content;

    // 评论用户ID
    @Column(name = "user_id")
    private String userId;

    // 评论用户头像
    @Column(name = "user_avatar")
    private String userAvatar;

    // 评论用户名称
    @Column(name = "user_name")
    private String userName;

    // 状态
    @Column(name = "state")
    private String state;

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

    public String getParentContent() {
        return parentContent;
    }

    public void setParentContent(String parentContent) {
        this.parentContent = parentContent;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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
