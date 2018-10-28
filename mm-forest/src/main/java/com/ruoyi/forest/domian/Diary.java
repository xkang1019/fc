package com.ruoyi.forest.domian;

/**
 * @author Administrator
 */
public class Diary {
    private  Integer cardId;
    private String cardContent;
    private boolean type;
    private String creationTime;
    private String content;
    private String [] contentImg;

    public boolean getType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String [] getContentImg() {
        return contentImg;
    }

    public void setContentImg(String [] contentImg) {
        this.contentImg = contentImg;
    }

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public String getCardContent() {
        return cardContent;
    }

    public void setCardContent(String cardContent) {
        this.cardContent = cardContent;
    }

    public boolean isType() {
        return type;
    }
}
