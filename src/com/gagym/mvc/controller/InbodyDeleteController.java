package com.gagym.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.gagym.mvc.dao.IMypageMainDAO;

public class InbodyDeleteController implements Controller
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
		String inbodyNo = request.getParameter("inbodyNo");
		int result = 0;
		
		try
		{
			result = dao.inbodyRemove(inbodyNo);
			
			if(result != 0)
			{
				// alert 띄우고 메인 페이지로 가기
				mav.addObject("msg","삭제되었습니다.");
	            mav.addObject("url","mypagemain.action?memNo="+memNo);
	            
	            mav.setViewName("/WEB-INF/view/alert.jsp");
			}
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		
		return mav;
	}
	
}
