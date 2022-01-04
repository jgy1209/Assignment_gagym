package com.gagym.dto;

public class InstructorScheduleDTO
{
	// 강사번호, 회원번호, 회원명, 회원아이디, 예약날짜
	private String insNo, memNo, memName, memId, rsvDate;
	
	// 폰번호, 집번호, 주소, 상세주소
	private String tel, homeTel, addr, detailAddr;
	
	// 수락일시, 예약취소일시, 완료일시 
	private String prcDate, cnlDate, comDate;
	
	// 예약타임
	private int rsvTime;
}
