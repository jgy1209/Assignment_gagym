package com.gagym.dto;

public class OnedayReservationDTO
{
	// 강사번호, 강사명, 강사아이디, 활동지역, 진행중인 강좌, 구직신청번호
	private String insNo, insName, insId, area, title, rsvNo;
	
	// 신청날짜, 확정날짜
	private String reqDate, fixDate;
	
	// 제안 아령, 제안 타임
	private int reqPoint, reqTime;

	
	public String getInsNo()
	{
		return insNo;
	}

	public void setInsNo(String insNo)
	{
		this.insNo = insNo;
	}

	public String getInsName()
	{
		return insName;
	}

	public void setInsName(String insName)
	{
		this.insName = insName;
	}

	public String getInsId()
	{
		return insId;
	}

	public void setInsId(String insId)
	{
		this.insId = insId;
	}

	public String getArea()
	{
		return area;
	}

	public void setArea(String area)
	{
		this.area = area;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getReqDate()
	{
		return reqDate;
	}

	public void setReqDate(String reqDate)
	{
		this.reqDate = reqDate;
	}

	public String getFixDate()
	{
		return fixDate;
	}

	public void setFixDate(String fixDate)
	{
		this.fixDate = fixDate;
	}

	public int getReqPoint()
	{
		return reqPoint;
	}

	public void setReqPoint(int reqPoint)
	{
		this.reqPoint = reqPoint;
	}

	public int getReqTime()
	{
		return reqTime;
	}

	public void setReqTime(int reqTime)
	{
		this.reqTime = reqTime;
	}

	public String getRsvNo()
	{
		return rsvNo;
	}

	public void setRsvNo(String rsvNo)
	{
		this.rsvNo = rsvNo;
	}
	
}