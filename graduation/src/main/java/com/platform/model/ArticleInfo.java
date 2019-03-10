package com.platform.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @description:推送文章
 * @author: Air
 * @date: 2019-02-28 22:39
 */
public class ArticleInfo {
    private Integer id;
    private String uuid;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;//创建时间
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date updateTime;//最新更新时间
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date publishTime;//发布时间
    private String title;//标题
    private Integer author;//作者ID
    private String authorName;//作者姓名
    private String image;//图片地址
    private String content;//文章内容
    private Integer type;//文章类型
    private String typeName;//文章类型名称
    private Integer collectNumber;//收藏数
    private Integer upNumber;//点赞数
    private Integer status;//状态

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getAuthor() {
        return author;
    }

    public void setAuthor(Integer author) {
        this.author = author;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getCollectNumber() {
        return collectNumber;
    }

    public void setCollectNumber(Integer collectNumber) {
        this.collectNumber = collectNumber;
    }

    public Integer getUpNumber() {
        return upNumber;
    }

    public void setUpNumber(Integer upNumber) {
        this.upNumber = upNumber;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
