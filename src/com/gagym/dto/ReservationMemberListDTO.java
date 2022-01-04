package com.gagym.dto;

public class ReservationMemberListDTO
{
	// 회원번호, 회원명, 회원아이디, 성별, 주민앞, 주소, 상세주소, 폰번호, 집번호 
	private String memNo, memName, memId, gender, ssn1, addr, detailAddr, tel, homeTel;
	
	// 예약날짜, 취소일시, 완료일시, 처리내용
	private String rsvDate, cnlDate, comDate, prcContent;
	
	// 예약타임, 나이
	private int rsvTime, age;
}
