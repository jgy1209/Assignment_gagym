package com.gagym.dto;

public class InstructorScheduleDTO
{
	// 유형, 강좌번호, 강좌명, 강사번호, 회원번호, 회원명, 회원아이디
	private String category, classNo, className, insNo, memNo, memName, memId;
	
	// 예약날짜, 완료일시 
	private String rsvDate, comDate;
	
	// 예약타임
	private int rsvTime;

	public String getCategory()
	{
		return category;
	}

	public void setCategory(String category)
	{
		this.category = category;
	}

	public String getClassNo()
	{
		return classNo;
	}

	public void setClassNo(String classNo)
	{
		this.classNo = classNo;
	}

	public String getClassName()
	{
		return className;
	}

	public void setClassName(String className)
	{
		this.className = className;
	}

	public String getInsNo()
	{
		return insNo;
	}

	public void setInsNo(String insNo)
	{
		this.insNo = insNo;
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

	public String getRsvDate()
	{
		return rsvDate;
	}

	public void setRsvDate(String rsvDate)
	{
		this.rsvDate = rsvDate;
	}

	public String getComDate()
	{
		return comDate;
	}

	public void setComDate(String comDate)
	{
		this.comDate = comDate;
	}

	public int getRsvTime()
	{
		return rsvTime;
	}

	public void setRsvTime(int rsvTime)
	{
		this.rsvTime = rsvTime;
	}
}
