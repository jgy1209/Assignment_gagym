/*=================
  ReviewDTO.java
  - 평점/리뷰
=================*/

package com.gagym.dto;

public class ReviewDTO
{
	// 강좌 번호, 강좌명, 강사 번호
	private String classNo, className, insNo;
	
	// 리뷰, 리뷰 날짜
	private String reviewContent, reviewDate;
	
	// 회원번호, 회원 id, 회원명
	private String memNo, memId, memName;
	
	// 평점
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

	public String getReviewContent()
	{
		return reviewContent;
	}

	public void setReviewContent(String reviewContent)
	{
		this.reviewContent = reviewContent;
	}

	public String getReviewDate()
	{
		return reviewDate;
	}

	public void setReviewDate(String reviewDate)
	{
		this.reviewDate = reviewDate;
	}

	public String getMemNo()
	{
		return memNo;
	}

	public void setMemNo(String memNo)
	{
		this.memNo = memNo;
	}

	public String getMemId()
	{
		return memId;
	}

	public void setMemId(String memId)
	{
		this.memId = memId;
	}

	public String getMemName()
	{
		return memName;
	}

	public void setMemName(String memName)
	{
		this.memName = memName;
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
