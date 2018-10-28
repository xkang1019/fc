package com.ruoyi.module.domain;


import com.ruoyi.common.base.BaseEntity;
import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 奖品列表 prize
 * 
 * @author ruoyi
 * @date 2018-10-27
 */
public class Prize extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** ID */
	private Integer id;
	/** 奖品名称 */
	private String name;
	/** 奖品数量 */
	private Integer number;
	/** 已经抽数量 */
	private Integer pTNum;
	/** 适用的开始时间 */
	private Date beginDate;
	/** 适用的结束时间 */
	private Date endDate;
	/** 在前多少位里面进行选取 */
	private Integer foreNumber;
	/** 指定用户中奖 */
	private Integer userID;
	/** 现在进行抽奖的人数 */
	private Integer nowNumber;
	/** 奖品优先率 */
	private Integer orderID;
	/** 领奖的有效时间 */
	private Date lotteryExp;
	/** 每次中奖发放的奖品数量 */
	private Integer oneMaxPriz;
	/** 状态 */
	private Integer status;

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setName(String name) 
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	public void setNumber(Integer number) 
	{
		this.number = number;
	}

	public Integer getNumber() 
	{
		return number;
	}
	public void setPTNum(Integer pTNum) 
	{
		this.pTNum = pTNum;
	}

	public Integer getPTNum() 
	{
		return pTNum;
	}
	public void setBeginDate(Date beginDate) 
	{
		this.beginDate = beginDate;
	}

	public Date getBeginDate() 
	{
		return beginDate;
	}
	public void setEndDate(Date endDate) 
	{
		this.endDate = endDate;
	}

	public Date getEndDate() 
	{
		return endDate;
	}
	public void setForeNumber(Integer foreNumber) 
	{
		this.foreNumber = foreNumber;
	}

	public Integer getForeNumber() 
	{
		return foreNumber;
	}
	public void setUserID(Integer userID) 
	{
		this.userID = userID;
	}

	public Integer getUserID() 
	{
		return userID;
	}
	public void setNowNumber(Integer nowNumber) 
	{
		this.nowNumber = nowNumber;
	}

	public Integer getNowNumber() 
	{
		return nowNumber;
	}
	public void setOrderID(Integer orderID) 
	{
		this.orderID = orderID;
	}

	public Integer getOrderID() 
	{
		return orderID;
	}
	public void setLotteryExp(Date lotteryExp) 
	{
		this.lotteryExp = lotteryExp;
	}

	public Date getLotteryExp() 
	{
		return lotteryExp;
	}
	public void setOneMaxPriz(Integer oneMaxPriz) 
	{
		this.oneMaxPriz = oneMaxPriz;
	}

	public Integer getOneMaxPriz() 
	{
		return oneMaxPriz;
	}
	public void setStatus(Integer status) 
	{
		this.status = status;
	}

	public Integer getStatus() 
	{
		return status;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("number", getNumber())
            .append("pTNum", getPTNum())
            .append("beginDate", getBeginDate())
            .append("endDate", getEndDate())
            .append("foreNumber", getForeNumber())
            .append("userID", getUserID())
            .append("nowNumber", getNowNumber())
            .append("orderID", getOrderID())
            .append("lotteryExp", getLotteryExp())
            .append("oneMaxPriz", getOneMaxPriz())
            .append("status", getStatus())
            .toString();
    }
}
