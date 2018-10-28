package com.ruoyi.forest.domian;

import java.io.Serializable;
import java.util.Date;


/**
 * 
 * 
 * @author lzy
 * @email 1992lcg@163.com
 * @date 2018-09-12 10:43:25
 */
public class SysCardsDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//卡片ID
	private Integer id;
	//卡片存放地址
	private String cardUrl;
	//卡片描述内容
	private String cardContent;
	//创建时间
	private Date creationTime;

	/**
	 * 设置：卡片ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：卡片ID
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：卡片存放地址
	 */
	public void setCardUrl(String cardUrl) {
		this.cardUrl = cardUrl;
	}
	/**
	 * 获取：卡片存放地址
	 */
	public String getCardUrl() {
		return cardUrl;
	}
	/**
	 * 设置：卡片描述内容
	 */
	public void setCardContent(String cardContent) {
		this.cardContent = cardContent;
	}
	/**
	 * 获取：卡片描述内容
	 */
	public String getCardContent() {
		return cardContent;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreationTime() {
		return creationTime;
	}
}
