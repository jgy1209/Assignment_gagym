package com.gagym.mvc.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.gagym.mvc.EyebodyDTO;
import com.gagym.mvc.InbodyDTO;
import com.gagym.mvc.MemberDTO;
import com.gagym.mvc.dao.IMypageMainDAO;

public class MypageMainDAO implements IMypageMainDAO
{
	// 인터페이스 자료형을 속성으로 구성
	private DataSource dataSource;

	// setter 구성
	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}
	
	
	// 개인정보 리스트
	@Override
	public MemberDTO privacyList(String mno) throws SQLException
	{
		MemberDTO mem = new MemberDTO();

		Connection conn = dataSource.getConnection();

		String sql = "SELECT MEM_NO, ZIP_CODE, ADDR, DETAIL_ADDR, MEM_NAME, TEL, HOMETEL, EMAIL, FN_GENDER(CRYPTPACK.DECRYPT(SSN2, '1234567')) AS GENDER" + 
					", CASE WHEN SUBSTR(CRYPTPACK.DECRYPT(SSN2, '1234567'), 1, 1) IN ('1','2')" + 
					" THEN EXTRACT(YEAR FROM SYSDATE)-(TO_NUMBER(SUBSTR(SSN1, 1, 2)) + 1899)" + 
					" WHEN SUBSTR(CRYPTPACK.DECRYPT(SSN2, '1234567'), 1, 1) IN ('3','4')" + 
					" THEN EXTRACT(YEAR FROM SYSDATE)-(TO_NUMBER(SUBSTR(SSN1, 1, 2)) + 1999)" + 
					" ELSE -1" + 
					" END AS AGE" + 
					" FROM PRIVACY" + 
					" WHERE MEM_NO=?";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, mno);

		ResultSet rs = pstmt.executeQuery();

		while (rs.next())
		{
			
			mem.setMemNo(rs.getString(1));
			mem.setZipCode(rs.getString(2));
			mem.setAddr(rs.getString(3));
			mem.setDetailAddr(rs.getString(4));
			mem.setMemName(rs.getString(5));
			mem.setTel(rs.getString(6));
			mem.setHometel(rs.getString(7));
			mem.setEmail(rs.getString(8));
			mem.setGender(rs.getString(9));
			mem.setAge(rs.getInt(10));
		}

		rs.close();
		pstmt.close();
		conn.close();

		return mem;

	}
	
	// 인바디 리스트
	@Override
	public ArrayList<InbodyDTO> inbodyList(String mno) throws SQLException
	{
		ArrayList<InbodyDTO> result = new ArrayList<InbodyDTO>();

		Connection conn = dataSource.getConnection();

		String sql = "SELECT INBODY_NO, INBODY_DATE, WEIGHT, TALL, MUSCLE, BODYFAT, BODYFAT_PER, ROUND(WEIGHT/((TALL/100)*(TALL/100)), 2)"
					+ " AS BMI FROM INBODY WHERE MEM_NO=? ORDER BY INBODY_DATE DESC";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, mno);

		ResultSet rs = pstmt.executeQuery();

		while (rs.next())
		{
			InbodyDTO inbody = new InbodyDTO();
			
			inbody.setInbodyNo(rs.getString(1));
			inbody.setInbodyDate(rs.getString(2));
			inbody.setWeight(rs.getDouble(3));
			inbody.setTall(rs.getDouble(4));
			inbody.setMuscle(rs.getDouble(5));
			inbody.setBodyfat(rs.getDouble(6));
			inbody.setBodyfatPer(rs.getDouble(7));
			inbody.setBmi(rs.getDouble(8));
			
			result.add(inbody);
		}

		rs.close();
		pstmt.close();
		conn.close();

		return result;

	}
	
	// 인바디 등록
	@Override
	public int inbodyAdd(InbodyDTO inbody) throws SQLException
	{
		int result = 0;
		
		Connection conn = dataSource.getConnection();
		
		String sql = "INSERT INTO INBODY(INBODY_NO, MEM_NO, INBODY_DATE"
					+ ", WEIGHT, TALL, MUSCLE, BODYFAT, BODYFAT_PER)"
					+ " VALUES('INBODY-'|| SEQ_INBODY.NEXTVAL"
					+ ", ?, SYSDATE, ?, ?, ?, ?, ?)";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, inbody.getMemNo());
		pstmt.setDouble(2, inbody.getWeight());
		pstmt.setDouble(3, inbody.getTall());
		pstmt.setDouble(4, inbody.getMuscle());
		pstmt.setDouble(5, inbody.getBodyfat());
		pstmt.setDouble(6, inbody.getBodyfatPer());
		
		result = pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
		
		return result;
		
	}
	
	// 눈바디 리스트
	@Override
	public ArrayList<EyebodyDTO> eyebodyList(String mno) throws SQLException
	{
		ArrayList<EyebodyDTO> result = new ArrayList<EyebodyDTO>();
		
		Connection conn = dataSource.getConnection();
		
		String sql = "SELECT EYEBODY_NO, MEM_NO, EYEBODY_DATE, PHOTO_PATH FROM EYEBODY WHERE MEM_NO=? ORDER BY EYEBODY_DATE DESC";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, mno);
		
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next())
		{
			EyebodyDTO eyebody = new EyebodyDTO();
			
			eyebody.setEyebodyNo(rs.getString(1));
			eyebody.setMemNo(rs.getString(2));
			eyebody.setEyebodyDate(rs.getString(3));
			eyebody.setPhotoPath(rs.getString(4));
			
			result.add(eyebody);
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		
		return result;
		
	}
	
	
	// 회원 이름, 아이디
	@Override
	public MemberDTO getNameId(String mno) throws SQLException
	{
		MemberDTO dto = new MemberDTO();
		
		Connection conn = dataSource.getConnection();
		
		String sql="SELECT MEM_NAME, MEM_ID FROM PRIVACY WHERE MEM_NO=?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, mno);
		
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next())
		{		
			dto.setMemNo(mno);
			dto.setMemName(rs.getString(1));
			dto.setMemId(rs.getString(2));
			
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		
		return dto;
	}
	
	
	// 비밀번호 일치 여부 (일치하면 1)
	@Override
	public int checkPw(String mno, String pw1) throws SQLException
	{
		int result = 0;		
		
		String pw2 = null;
		
		Connection conn = dataSource.getConnection();
		
		String sql="SELECT MEM_PW FROM PRIVACY WHERE MEM_NO=?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, mno);
		
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next())
		{		
			pw2 = rs.getString(1);
		}
		
		if(pw1.equals(pw2))
		{
			result = 1;
		}
		else
		{
			result = 0;
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		
		return result;
	}
	
	
	// 탈퇴 체크 1. 강좌 예약 존재 여부 (존재하면 1 - 탈퇴불가)
	@Override
	public int withdrawCheckClass(String mno) throws SQLException
	{
		int result = 0;		
		
		Connection conn = dataSource.getConnection();
		
		String sql="SELECT PRC_CODE, CNL_DATE, CLASS_COM_DATE FROM SIGNOUTCHECK1VIEW WHERE MEM_NO =  ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, mno);
		
		ResultSet rs = pstmt.executeQuery();
		
		int prcCode = 0;
		String cnlDate = null;
		String comDate = null;
		
		while (rs.next())
		{		
			prcCode = rs.getInt(1);
			cnlDate = rs.getString(2);
			comDate = rs.getString(3);
		}
		
		if(prcCode == 1)	// 예약 승인된 강좌 중
		{
			if(cnlDate == null && comDate == null)	// 취소도 완료도 아닌 상태 => 예약 존재
			{
				result = 1; 
			}
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		
		return result;
	}
	
	// 탈퇴 체크 2. 원데이 예약 존재 여부 (존재하면 1 - 탈퇴불가)
	@Override
	public int withdrawCheckOneday(String mno) throws SQLException
	{
		int result = 0;		
		
		Connection conn = dataSource.getConnection();
		
		String sql="SELECT ONEDAY_FIX_NO, ONEDAY_CNL_DATE, ONEDAY_COM_DATE FROM SIGNOUTCHECK2VIEW WHERE MEM_NO = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, mno);
		
		ResultSet rs = pstmt.executeQuery();
		
		String fix = null;
		String cnlDate = null;
		String comDate = null;
		
		while (rs.next())
		{		
			fix = rs.getString(1);
			cnlDate = rs.getString(2);
			comDate = rs.getString(3);
		}
		
		if(fix != null)	// 원데이 예약 확정 중
		{
			if(cnlDate == null && comDate ==null)	// 취소도 완료도 아닌 상태 => 예약 존재
			{
				result = 1; 
			}
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		
		return result;
	}

	// 회원 탈퇴
	@Override
	public int withdraw(String mno, String reason, String oth) throws SQLException
	{
		int result = 0;		
		
		Connection conn = dataSource.getConnection();
		
		String sql="{call PRC_MEMBER_OUT(?, ?, ?)}";
		
		CallableStatement cstmt = conn.prepareCall(sql);
		
		cstmt.setString(1, mno);
		cstmt.setString(2, reason);
		cstmt.setString(3, oth);
		
		result = cstmt.executeUpdate();
		
		cstmt.close();
		conn.close();
		
		return result;
	}
}
