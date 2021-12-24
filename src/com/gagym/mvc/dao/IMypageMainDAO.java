package com.gagym.mvc.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.gagym.mvc.EyebodyDTO;
import com.gagym.mvc.InbodyDTO;
import com.gagym.mvc.MemberDTO;

public interface IMypageMainDAO
{

	ArrayList<InbodyDTO> inbodyList(String mid) throws SQLException;

	MemberDTO privacyList(String mid) throws SQLException;

	ArrayList<EyebodyDTO> eyebodyList(String mno) throws SQLException;

	int inbodyAdd(InbodyDTO inbody) throws SQLException;

	MemberDTO getNameId(String mno) throws SQLException;
	
	int checkPw(String mno, String pw1) throws SQLException;

	int withdrawCheckClass(String mno) throws SQLException;

	int withdrawCheckOneday(String mno) throws SQLException;

	int withdraw(String mno, String reason, String oth) throws SQLException;

}
