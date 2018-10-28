package com.ruoyi.forest.dto;

import java.util.Date;

public class SLDiaryDTO {

    private static final long serialVersionUID = 1L;

    private Integer id;
    //天气
    private String weather;
    //发布时间
    private Date creationtime;
    //内容
    private String content;
    //卡片id
    private Integer cardid;
    //卡片背景
    private String cardimg;
    //内容图片
    private String contentimg;
    //访问量
    private Integer pvnumber;
    //收藏量
    private Integer collectnumber;
    //点赞量
    private Integer likenumber;
    //评论量
    private Integer commentnumber;
    //转发量
    private Integer transpondnumber;
    //头像
    private String haedimg;
    //名称
    private String name;
    //类型
    private Integer type;

    /**
     * 设置：
     */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
     * 获取：
     */
    public Integer getId() {
        return id;
    }
    /**
     * 设置：天气
     */
    public void setWeather(String weather) {
        this.weather = weather;
    }
    /**
     * 获取：天气
     */
    public String getWeather() {
        return weather;
    }
    /**
     * 设置：发布时间
     */
    public void setCreationtime(Date creationtime) {
        this.creationtime = creationtime;
    }
    /**
     * 获取：发布时间
     */
    public Date getCreationtime() {
        return creationtime;
    }
    /**
     * 设置：内容
     */
    public void setContent(String content) {
        this.content = content;
    }
    /**
     * 获取：内容
     */
    public String getContent() {
        return content;
    }
    /**
     * 设置：卡片id
     */
    public void setCardid(Integer cardid) {
        this.cardid = cardid;
    }
    /**
     * 获取：卡片id
     */
    public Integer getCardid() {
        return cardid;
    }
    /**
     * 设置：卡片背景
     */
    public void setCardimg(String cardimg) {
        this.cardimg = cardimg;
    }
    /**
     * 获取：卡片背景
     */
    public String getCardimg() {
        return cardimg;
    }
    /**
     * 设置：内容图片
     */
    public void setContentimg(String contentimg) {
        this.contentimg = contentimg;
    }
    /**
     * 获取：内容图片
     */
    public String getContentimg() {
        return contentimg;
    }
    /**
     * 设置：访问量
     */
    public void setPvnumber(Integer pvnumber) {
        this.pvnumber = pvnumber;
    }
    /**
     * 获取：访问量
     */
    public Integer getPvnumber() {
        return pvnumber;
    }
    /**
     * 设置：收藏量
     */
    public void setCollectnumber(Integer collectnumber) {
        this.collectnumber = collectnumber;
    }
    /**
     * 获取：收藏量
     */
    public Integer getCollectnumber() {
        return collectnumber;
    }
    /**
     * 设置：点赞量
     */
    public void setLikenumber(Integer likenumber) {
        this.likenumber = likenumber;
    }
    /**
     * 获取：点赞量
     */
    public Integer getLikenumber() {
        return likenumber;
    }
    /**
     * 设置：评论量
     */
    public void setCommentnumber(Integer commentnumber) {
        this.commentnumber = commentnumber;
    }
    /**
     * 获取：评论量
     */
    public Integer getCommentnumber() {
        return commentnumber;
    }
    /**
     * 设置：转发量
     */
    public void setTranspondnumber(Integer transpondnumber) {
        this.transpondnumber = transpondnumber;
    }
    /**
     * 获取：转发量
     */
    public Integer getTranspondnumber() {
        return transpondnumber;
    }
    /**
     * 设置：头像
     */
    public void setHaedimg(String haedimg) {
        this.haedimg = haedimg;
    }
    /**
     * 获取：头像
     */
    public String getHaedimg() {
        return haedimg;
    }
    /**
     * 设置：名称
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * 获取：名称
     */
    public String getName() {
        return name;
    }
    /**
     * 设置：类型
     */
    public void setType(Integer type) {
        this.type = type;
    }
    /**
     * 获取：类型
     */
    public Integer getType() {
        return type;
    }
}
