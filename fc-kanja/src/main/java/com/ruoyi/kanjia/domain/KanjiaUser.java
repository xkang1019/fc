package com.ruoyi.kanjia.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.base.BaseEntity;

import java.math.BigDecimal;

/**
 * 报名表 kanjia_user
 * 
 * @author xkang
 * @date 2018-12-06
 */
public class KanjiaUser extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** id */
	private Integer id;
	/** uid */
	private Integer uid;
	/** 现价 */
	private BigDecimal presentPrice;
	/** 原价 */
	private BigDecimal originalPrice;
	/** 底价 */
	private BigDecimal floorPrice;
	/** 微信名字 */
	private String uname;
	/** 微信头像 */
	private String uimg;

	private String nickname;

	private String phone;

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

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
	public void setPresentPrice(BigDecimal presentPrice) 
	{
		this.presentPrice = presentPrice;
	}

	public BigDecimal getPresentPrice() 
	{
		return presentPrice;
	}
	public void setOriginalPrice(BigDecimal originalPrice) 
	{
		this.originalPrice = originalPrice;
	}

	public BigDecimal getOriginalPrice() 
	{
		return originalPrice;
	}
	public void setFloorPrice(BigDecimal floorPrice) 
	{
		this.floorPrice = floorPrice;
	}

	public BigDecimal getFloorPrice() 
	{
		return floorPrice;
	}
	public void setUname(String uname) 
	{
		this.uname = uname;
	}

	public String getUname() 
	{
		return uname;
	}
	public void setUimg(String uimg) 
	{
		this.uimg = uimg;
	}

	public String getUimg() 
	{
		return uimg;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("uid", getUid())
            .append("presentPrice", getPresentPrice())
            .append("originalPrice", getOriginalPrice())
            .append("floorPrice", getFloorPrice())
            .append("uname", getUname())
            .append("uimg", getUimg())
            .toString();
    }
}
