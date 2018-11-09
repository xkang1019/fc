package com.ruoyi.fc.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.base.BaseEntity;

/**
 * 中奖轮播表 lunbo
 * 
 * @author ruoyi
 * @date 2018-11-09
 */
public class Lunbo extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Integer id;
	/**  */
	private String userimg;
	/**  */
	private String prizeinfo;

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setUserimg(String userimg) 
	{
		this.userimg = userimg;
	}

	public String getUserimg() 
	{
		return userimg;
	}
	public void setPrizeinfo(String prizeinfo) 
	{
		this.prizeinfo = prizeinfo;
	}

	public String getPrizeinfo() 
	{
		return prizeinfo;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userimg", getUserimg())
            .append("prizeinfo", getPrizeinfo())
            .toString();
    }
}
