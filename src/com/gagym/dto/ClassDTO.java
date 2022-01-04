package com.gagym.dto;

public class ClassDTO
{
	// 강좌번호, 강좌명, 강사번호, 강사명, 강사아이디, 강좌시작날짜, 강좌종료날짜
	private String classNo, className, insNo, insName, insId, startDate, endDate;
	
	// 강사활동지역, 운동종목명, 강좌수강아령, 강좌내용, 강사사진경로  
	private String insArea, sportName, point, content, profilePath;

	// 강좌첫타임, 강좌마지막타임
	private int startTime, endTime;
	
	//평점
	private double grade;
	
	

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

	public String getStartDate()
	{
		return startDate;
	}

	public void setStartDate(String startDate)
	{
		this.startDate = startDate;
	}

	public String getEndDate()
	{
		return endDate;
	}

	public void setEndDate(String endDate)
	{
		this.endDate = endDate;
	}

	public String getInsArea()
	{
		return insArea;
	}

	public void setInsArea(String insArea)
	{
		this.insArea = insArea;
	}

	public String getSportName()
	{
		return sportName;
	}

	public void setSportName(String sportName)
	{
		this.sportName = sportName;
	}

	public String getPoint()
	{
		return point;
	}

	public void setPoint(String point)
	{
		this.point = point;
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public String getProfilePath()
	{
		return profilePath;
	}

	public void setProfilePath(String profilePath)
	{
		this.profilePath = profilePath;
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

	public double getGrade()
	{
		return grade;
	}

	public void setGrade(double grade)
	{
		this.grade = grade;
	}
	
	


	

	
	
}