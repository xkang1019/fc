package com.ruoyi.forest.ov;

/**
 * 日记广场显示类
 * @author Administrator
 */
public class CardsInfoVO {

    private String color;
    private String tilte;
    private String weather;
    private String headImg;
    private String[] imgList;
    private String event;
    private String phrase;
    private boolean type;
    private Integer likenumber;
    private Integer collectnumber;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTilte() {
        return tilte;
    }

    public void setTilte(String tilte) {
        this.tilte = tilte;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String[] getImgList() {
        return imgList;
    }

    public void setImgList(String[] imgList) {
        this.imgList = imgList;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }


    public Integer getLikenumber() {
        return likenumber;
    }

    public void setLikenumber(Integer likenumber) {
        this.likenumber = likenumber;
    }

    public Integer getCollectnumber() {
        return collectnumber;
    }

    public void setCollectnumber(Integer collectnumber) {
        this.collectnumber = collectnumber;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }
}
