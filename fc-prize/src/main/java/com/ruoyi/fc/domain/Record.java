package com.ruoyi.fc.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.base.BaseEntity;
import java.util.Date;

/**
 * 用户分享记录表 prize_record
 * 
 * @author ruoyi
 * @date 2018-10-27
 */
public class Record extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** ID */
	private Integer id;
	/** 用户id */
	private Integer uid;
	/** 用户名称 */
	private String uname;
	/** 分享类型 */
	private Integer type;
	/** 分享时间 */
	private Date dateTime;
	/** 用户头像 */
	private String uimg;

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
	public void setUname(String uname) 
	{
		this.uname = uname;
	}

	public String getUname() 
	{
		return uname;
	}
	public void setType(Integer type) 
	{
		this.type = type;
	}

	public Integer getType() 
	{
		return type;
	}
	public void setDateTime(Date dateTime) 
	{
		this.dateTime = dateTime;
	}

	public Date getDateTime() 
	{
		return dateTime;
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
            .append("uname", getUname())
            .append("type", getType())
            .append("dateTime", getDateTime())
            .append("uimg", getUimg())
            .toString();
    }
}
