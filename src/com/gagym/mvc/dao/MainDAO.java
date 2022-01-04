package com.gagym.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.gagym.dto.ClassDTO;
import com.gagym.dto.InstructorDTO;
import com.gagym.dto.OnedayDTO;
import com.gagym.mvc.inter.IMainDAO;



public class MainDAO implements IMainDAO
{
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}

	//강좌리스트 (최신순 10개)
	@Override
	public ArrayList<ClassDTO> classList() throws SQLException
	{
		ArrayList<ClassDTO> result = new ArrayList<ClassDTO>();
		
		Connection conn = dataSource.getConnection();
		
		String sql = "SELECT CLASS_NO, CLASS_NAME, TO_CHAR(CLASS_STARTDATE, 'YYYY-MM-DD') AS CLASS_STARTDATE,"
				+ " TO_CHAR(CLASS_ENDDATE, 'YYYY-MM-DD') AS CLASS_ENDDATE,"
				+ " CLASS_POINT, SPORT_NAME, INS_NAME, INS_AREA"
				+ " FROM ( SELECT CLASS_NO, CLASS_NAME, CLASS_STARTDATE, CLASS_ENDDATE,"
				+ " CLASS_POINT, CLASS_DATE, SPORT_NAME, INS_NAME, INS_AREA"
				+ " FROM CLASSVIEW ORDER BY CLASS_DATE DESC )"
				+ " WHERE ROWNUM <= 10";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next())
		{
			ClassDTO classes = new ClassDTO();
			
			classes.setClassNo(rs.getString("CLASS_NO"));
			classes.setClassName(rs.getString("CLASS_NAME"));
			classes.setStartDate(rs.getString("CLASS_STARTDATE"));
			classes.setEndDate(rs.getString("CLASS_ENDDATE"));
			classes.setPoint(rs.getString("CLASS_POINT"));
			classes.setSportName(rs.getString("SPORT_NAME"));
			classes.setInsName(rs.getString("INS_NAME"));
			classes.setInsArea(rs.getString("INS_AREA"));
			
			result.add(classes);
		}
		rs.close();
		pstmt.close();
		conn.close();
		
		return result;
	}
	
	//원데이클래스 리스트 (최신순 10개)
	@Override
	public ArrayList<OnedayDTO> onedayList() throws SQLException
	{
		ArrayList<OnedayDTO> result = new ArrayList<OnedayDTO>();
		
		Connection conn = dataSource.getConnection();
		
		String sql = "SELECT ONEDAY_NAME, TO_CHAR(ONEDAY_WISH_DATE, 'YYYY-MM-DD') AS WISHDATE,"
				+ " START_TIME, END_TIME, SPORT_NAME, ONEDAY_WISH_POINT,"
				+ " ADDR, MEM_NAME, ONEDAY_NO FROM ("
				+ " SELECT ONEDAY_NAME, ONEDAY_WISH_DATE, START_TIME,"
				+ " END_TIME, SPORT_NAME, ONEDAY_WISH_POINT, ADDR, MEM_NAME, MEM_NO,"
				+ " ONEDAY_NO FROM ONEDAYVIEW WHERE ONEDAY_FIX_DATE IS NULL ORDER BY ONEDAY_REG_DATE DESC )"
				+ " WHERE ROWNUM <= 10";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next())
		{
			OnedayDTO oneday = new OnedayDTO();
			
			oneday.setTitle(rs.getString("ONEDAY_NAME"));
			oneday.setWishDate(rs.getString("WISHDATE"));
			oneday.setStartTime(rs.getInt("START_TIME"));
			oneday.setEndTime(rs.getInt("END_TIME"));
			oneday.setSportName(rs.getString("SPORT_NAME"));
			oneday.setWishPoint(rs.getInt("ONEDAY_WISH_POINT"));
			oneday.setAddr(rs.getString("ADDR"));
			oneday.setMemName(rs.getString("MEM_NAME"));
			oneday.setOnedayNo(rs.getString("ONEDAY_NO"));
			//oneday.setOnedayNo(rs.getString("ONEDAY_NO"));
			
			result.add(oneday);
		}
		rs.close();
		pstmt.close();
		conn.close();
		
		return result;
	}

	//강사리스트(이름만 최신 10명)
	@Override
	public ArrayList<InstructorDTO> insList() throws SQLException
	{
		ArrayList<InstructorDTO> result = new ArrayList<InstructorDTO>();
		
		Connection conn = dataSource.getConnection();
		
		String sql = "SELECT INS_NAME"
				+ " FROM"
				+ " ( SELECT INS_NO, INS_NAME, PRC_DATE"
				+ " FROM INSPRIVACYVIEW"
				+ " ORDER BY PRC_DATE DESC )"
				+ " WHERE ROWNUM <= 10";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next())
		{
			InstructorDTO ins = new InstructorDTO();
			
			ins.setInsName(rs.getString("INS_NAME"));

			result.add(ins);
		}
		rs.close();
		pstmt.close();
		conn.close();
		
		return result;
	}

}
