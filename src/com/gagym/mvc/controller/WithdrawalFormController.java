package com.gagym.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.gagym.mvc.dao.IMypageMainDAO;
import com.gagym.mvc.MemberDTO;

public class WithdrawalFormController implements Controller
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
		
		try
		{
			MemberDTO nameId = dao.getNameId(memNo);
			
			mav.addObject("nameId", nameId);
			
			mav.setViewName("/WEB-INF/view/WithdrawalForm.jsp");
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		return mav;
	}
	
}
