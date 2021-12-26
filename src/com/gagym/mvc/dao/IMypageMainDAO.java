package com.gagym.mvc.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.gagym.mvc.EyebodyDTO;
import com.gagym.mvc.InbodyDTO;
import com.gagym.mvc.MemberDTO;
import com.gagym.mvc.PointDTO;

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

}
