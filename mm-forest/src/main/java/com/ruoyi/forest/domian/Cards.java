package com.ruoyi.forest.domian;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.base.BaseEntity;
import java.util.Date;

/**
 * 首页卡片展示表 sys_cards
 * 
 * @author ruoyi
 * @date 2018-10-25
 */
public class Cards extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 卡片ID */
	private Integer id;
	/** 卡片存放地址 */
	private String cardUrl;
	/** 卡片描述内容 */
	private String cardContent;
	/** 创建时间 */
	private Date creationTime;

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setCardUrl(String cardUrl) 
	{
		this.cardUrl = cardUrl;
	}

	public String getCardUrl() 
	{
		return cardUrl;
	}
	public void setCardContent(String cardContent) 
	{
		this.cardContent = cardContent;
	}

	public String getCardContent() 
	{
		return cardContent;
	}
	public void setCreationTime(Date creationTime) 
	{
		this.creationTime = creationTime;
	}

	public Date getCreationTime() 
	{
		return creationTime;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("cardUrl", getCardUrl())
            .append("cardContent", getCardContent())
            .append("creationTime", getCreationTime())
            .toString();
    }
}
