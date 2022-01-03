package com.gagym.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.gagym.mvc.inter.IMypageMainDAO;
import com.gagym.dto.PointDTO;

public class RefundFormController implements Controller
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
		String pointPayNo = request.getParameter("pointPayNo");
		int point = Integer.parseInt(request.getParameter("point"));
		int pointPay = 0;
		
		try
		{
			int check = dao.refundCheck(pointPayNo);
			
			if(check == 1)
			{
				pointPay = (point * 1000);
			}
			else
			{
				pointPay = (point * 800);
			}
			
			PointDTO dto = new PointDTO();
			
			dto.setMemNo(memNo);
			dto.setPointPayNo(pointPayNo);
			dto.setPoint(point);
			dto.setPointPay(pointPay);
			
			mav.addObject("point", dto);
			
			mav.setViewName("/WEB-INF/view/RefundForm.jsp");
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		return mav;
	}
	
}
