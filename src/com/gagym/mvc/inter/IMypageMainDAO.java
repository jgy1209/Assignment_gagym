package com.gagym.mvc.inter;

import java.sql.SQLException;
import java.util.ArrayList;

import com.gagym.dto.EyebodyDTO;
import com.gagym.dto.InbodyDTO;
import com.gagym.dto.InstructorDTO;
import com.gagym.dto.MemberDTO;
import com.gagym.dto.PointDTO;
import com.gagym.dto.AreaDTO;

public interface IMypageMainDAO
{
	MemberDTO privacyList(String mid) throws SQLException;

	int privacyUpdate(MemberDTO member) throws SQLException;
	
	
	ArrayList<InbodyDTO> inbodyList(String mid) throws SQLException;

	ArrayList<EyebodyDTO> eyebodyList(String mno) throws SQLException;

	int inbodyAdd(InbodyDTO inbody) throws SQLException;
	
	int eyebodyAdd(EyebodyDTO eyebody) throws SQLException;

	int inbodyRemove(String inbodyNo) throws SQLException;
	

	MemberDTO getNameId(String mno) throws SQLException;
	
	int checkPw(String mno, String pw1) throws SQLException;

	int withdrawCheckClass(String mno) throws SQLException;

	int withdrawCheckOneday(String mno) throws SQLException;

	int withdraw(String mno, String reason, String oth) throws SQLException;
	

	ArrayList<PointDTO> pointList(String mno) throws SQLException;

	int havePoint(String mno) throws SQLException;

	int refundCheck(String pno) throws SQLException;

	int refundAdd(String pno, int point) throws SQLException;
	

	ArrayList<InstructorDTO> cerList() throws SQLException;

	int insInsertCheck(String mno) throws SQLException;

	ArrayList<AreaDTO> cityList() throws SQLException;
	
	ArrayList<AreaDTO> areaList(String cno) throws SQLException;

	
	int insReqAdd(String memNo) throws SQLException;

	String getInsReqNo(String memNo) throws SQLException;

	int insCerAdd(InstructorDTO ins, String reqNo) throws SQLException;

	int insPrzAdd(InstructorDTO ins, String reqNo) throws SQLException;

	int insExpAdd(InstructorDTO ins, String reqNo) throws SQLException;

	int insAreaAdd(String reqNo, String sigunguNo) throws SQLException;




}
