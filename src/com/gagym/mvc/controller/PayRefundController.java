package com.gagym.mvc.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.gagym.mvc.dao.IMypageMainDAO;
import com.gagym.mvc.PointDTO;

public class PayRefundController implements Controller
{
	private IMypageMainDAO dao;
	
	// setter
	public void setDao(IMypageMainDAO dao)
	{
		this.dao = dao;
	}


	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ModelAndView mav = new ModelAndView();
		
		String memNo = request.getParameter("memNo");
		
		ArrayList<PointDTO> pointList = new ArrayList<PointDTO>();
		int havePoint = 0;
		
		try
		{
				pointList = dao.pointList(memNo);
				havePoint = dao.havePoint(memNo);
				
				mav.addObject("pointList", pointList);
				mav.addObject("havePoint", havePoint);
				
				mav.setViewName("/WEB-INF/view/PayRefund.jsp");
			
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		return mav;
	}

}
