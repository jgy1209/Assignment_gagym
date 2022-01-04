package com.gagym.dto;

public class OnedayDTO
{
	// 회원번호, 회원명, 회원아이디, 주소(지역), 종목명, 운동희망날짜
	private String memNo, memName, memId, addr, sportName, wishDate;
	
	// 등록날짜, 제목, 내용, 중도폐쇄날짜, 강사확정날짜, 원데이번호
	private String regDate, title, content, stopDate, fixDate, onedayNo;
	
	// 희망아령, 희망첫타임, 희망마지막타임
	private int wishPoint, startTime, endTime;

	
	public String getOnedayNo()
	{
		return onedayNo;
	}

	public void setOnedayNo(String onedayNo)
	{
		this.onedayNo = onedayNo;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getMemNo()
	{
		return memNo;
	}

	public void setMemNo(String memNo)
	{
		this.memNo = memNo;
	}

	public String getMemName()
	{
		return memName;
	}

	public void setMemName(String memName)
	{
		this.memName = memName;
	}

	public String getMemId()
	{
		return memId;
	}

	public void setMemId(String memId)
	{
		this.memId = memId;
	}

	public String getAddr()
	{
		return addr;
	}

	public void setAddr(String addr)
	{
		this.addr = addr;
	}

	public String getSportName()
	{
		return sportName;
	}

	public void setSportName(String sportName)
	{
		this.sportName = sportName;
	}

	public String getWishDate()
	{
		return wishDate;
	}

	public void setWishDate(String wishDate)
	{
		this.wishDate = wishDate;
	}

	public String getRegDate()
	{
		return regDate;
	}

	public void setRegDate(String regDate)
	{
		this.regDate = regDate;
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public String getStopDate()
	{
		return stopDate;
	}

	public void setStopDate(String stopDate)
	{
		this.stopDate = stopDate;
	}

	public String getFixDate()
	{
		return fixDate;
	}

	public void setFixDate(String fixDate)
	{
		this.fixDate = fixDate;
	}

	public int getWishPoint()
	{
		return wishPoint;
	}

	public void setWishPoint(int wishPoint)
	{
		this.wishPoint = wishPoint;
	}

	public int getStartTime()
	{
		return startTime;
	}

	public void setStartTime(int startTime)
	{
		this.startTime = startTime;
	}

	public int getEndTime()
	{
		return endTime;
	}

	public void setEndTime(int endTime)
	{
		this.endTime = endTime;
	}
}