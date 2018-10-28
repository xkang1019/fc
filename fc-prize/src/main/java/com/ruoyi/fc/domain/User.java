package com.ruoyi.fc.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.base.BaseEntity;
import java.util.Date;

/**
 * 用户抽奖表 prize_user
 * 
 * @author ruoyi
 * @date 2018-10-27
 */
public class User extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** ID */
	private Integer id;
	/** 用户id */
	private Integer uid;
	/** 用户名称 */
	private String uname;
	/** 奖品id */
	private Integer pid;
	/** 奖品名称 */
	private String pname;
	/** 中奖时间 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date datetime;
	/** 奖品状态 */
	private Integer status;
	/** 兑换密钥 */
	private String password;
	/** 领取时间 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date receiveTime;

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
	public void setPid(Integer pid) 
	{
		this.pid = pid;
	}

	public Integer getPid() 
	{
		return pid;
	}
	public void setPname(String pname) 
	{
		this.pname = pname;
	}

	public String getPname() 
	{
		return pname;
	}
	public void setDatetime(Date datetime) 
	{
		this.datetime = datetime;
	}

	public Date getDatetime() 
	{
		return datetime;
	}
	public void setStatus(Integer status) 
	{
		this.status = status;
	}

	public Integer getStatus() 
	{
		return status;
	}
	public void setPassword(String password) 
	{
		this.password = password;
	}

	public String getPassword() 
	{
		return password;
	}
	public void setReceiveTime(Date receiveTime) 
	{
		this.receiveTime = receiveTime;
	}

	public Date getReceiveTime() 
	{
		return receiveTime;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("uid", getUid())
            .append("uname", getUname())
            .append("pid", getPid())
            .append("pname", getPname())
            .append("datetime", getDatetime())
            .append("status", getStatus())
            .append("password", getPassword())
            .append("receiveTime", getReceiveTime())
            .toString();
    }
}
