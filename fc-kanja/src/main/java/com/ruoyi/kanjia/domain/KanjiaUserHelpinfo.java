package com.ruoyi.kanjia.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.base.BaseEntity;

import java.math.BigDecimal;

/**
 * 砍价表 kanjia_user_helpinfo
 * 
 * @author xkang
 * @date 2018-12-06
 */
public class KanjiaUserHelpinfo extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Integer id;
	/** 被砍价人 */
	private Integer uid;
	/** 砍价人 */
	private Integer toUid;
	/** 砍价金额 */
	private BigDecimal money;

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setUid(Integer uid) 
	{
		this.uid = uid;
	}

	public Integer getUid() 
	{
		return uid;
	}
	public void setToUid(Integer toUid) 
	{
		this.toUid = toUid;
	}

	public Integer getToUid() 
	{
		return toUid;
	}
	public void setMoney(BigDecimal money) 
	{
		this.money = money;
	}

	public BigDecimal getMoney() 
	{
		return money;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("uid", getUid())
            .append("toUid", getToUid())
            .append("money", getMoney())
            .toString();
    }
}
