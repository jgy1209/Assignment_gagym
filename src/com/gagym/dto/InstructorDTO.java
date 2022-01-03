package com.gagym.dto;

public class InstructorDTO
{
	/*
	// 강사 번호, (강사신청 처리 번호), 강사명, 한줄 소개, (강사 신청 번호)
	private String insNo, reqPrcNo, memName, introduce, reqNo;
	
	// (활동지역 번호), (시군구 번호), 시군구명
	private String areaNo, sigunguNo, sigunguName;
	
	// (수상경력 번호), 수상경력명, 수상경력 메달, 수상경력날짜
	private String przNo, przName, przMedal, przDate;
	
	// (활동경력 번호), 활동내역, 활동경력 시작날짜, 활동경력 끝날짜
	private String expNo, expContent, expStartDate, expEndDate;
	
	// (자격증 증명 번호), 자격증 번호, 자격증명, 자격증 발급날짜, 자격증 증명자료경로, (발급처 번호), 발급처
	private String proofNo, cerNo, cerName, cerDate, proofPath, issueNo, issueName;
	*/
	
	// 강사 번호, 강사명, 한줄 소개
	private String insNo, memName, introduce;
	
	// 시군구명
	private String sigunguName;
	
	// 수상경력명, 수상경력 메달, 수상경력날짜
	private String przName, przMedal, przDate;
	
	// 활동내역, 활동경력 시작날짜, 활동경력 끝날짜
	private String expContent, expStartDate, expEndDate;
	
	// 자격증 번호, 자격증명, 자격증 발급날짜, 자격증 증명자료경로, 발급처
	private String cerNo, cerName, cerDate, proofPath, issueName;
	
	// 강사박탈번호, 관리자아이디, 박탈사유, 박탈날짜
	private String insDropNo, adminId, dropReason, dropDate;

	
	// getter / setter
	public String getInsNo()
	{
		return insNo;
	}

	public void setInsNo(String insNo)
	{
		this.insNo = insNo;
	}

	public String getMemName()
	{
		return memName;
	}

	public void setMemName(String memName)
	{
		this.memName = memName;
	}

	public String getIntroduce()
	{
		return introduce;
	}

	public void setIntroduce(String introduce)
	{
		this.introduce = introduce;
	}

	public String getSigunguName()
	{
		return sigunguName;
	}

	public void setSigunguName(String sigunguName)
	{
		this.sigunguName = sigunguName;
	}

	public String getPrzName()
	{
		return przName;
	}

	public void setPrzName(String przName)
	{
		this.przName = przName;
	}

	public String getPrzMedal()
	{
		return przMedal;
	}

	public void setPrzMedal(String przMedal)
	{
		this.przMedal = przMedal;
	}

	public String getPrzDate()
	{
		return przDate;
	}

	public void setPrzDate(String przDate)
	{
		this.przDate = przDate;
	}

	public String getExpContent()
	{
		return expContent;
	}

	public void setExpContent(String expContent)
	{
		this.expContent = expContent;
	}

	public String getExpStartDate()
	{
		return expStartDate;
	}

	public void setExpStartDate(String expStartDate)
	{
		this.expStartDate = expStartDate;
	}

	public String getExpEndDate()
	{
		return expEndDate;
	}

	public void setExpEndDate(String expEndDate)
	{
		this.expEndDate = expEndDate;
	}

	public String getCerNo()
	{
		return cerNo;
	}

	public void setCerNo(String cerNo)
	{
		this.cerNo = cerNo;
	}

	public String getCerName()
	{
		return cerName;
	}

	public void setCerName(String cerName)
	{
		this.cerName = cerName;
	}

	public String getCerDate()
	{
		return cerDate;
	}

	public void setCerDate(String cerDate)
	{
		this.cerDate = cerDate;
	}

	public String getProofPath()
	{
		return proofPath;
	}

	public void setProofPath(String proofPath)
	{
		this.proofPath = proofPath;
	}

	public String getIssueName()
	{
		return issueName;
	}

	public void setIssueName(String issueName)
	{
		this.issueName = issueName;
	}

	public String getInsDropNo()
	{
		return insDropNo;
	}

	public void setInsDropNo(String insDropNo)
	{
		this.insDropNo = insDropNo;
	}

	public String getAdminId()
	{
		return adminId;
	}

	public void setAdminId(String adminId)
	{
		this.adminId = adminId;
	}

	public String getDropReason()
	{
		return dropReason;
	}

	public void setDropReason(String dropReason)
	{
		this.dropReason = dropReason;
	}

	public String getDropDate()
	{
		return dropDate;
	}

	public void setDropDate(String dropDate)
	{
		this.dropDate = dropDate;
	}

	
	
}