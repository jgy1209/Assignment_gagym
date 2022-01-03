package com.gagym.mvc.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.gagym.dto.EyebodyDTO;
import com.gagym.mvc.inter.IMypageMainDAO;
import com.gagym.dto.InbodyDTO;
import com.gagym.dto.MemberDTO;

public class MypageMainController implements Controller
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
		
		MemberDTO member = new MemberDTO();
		ArrayList<InbodyDTO> inbodyList = new ArrayList<InbodyDTO>();
		ArrayList<EyebodyDTO> eyebodyList = new ArrayList<EyebodyDTO>();
		int havepoint = 0;
		
		try
		{
				member = dao.privacyList(memNo);
				inbodyList = dao.inbodyList(memNo);
				eyebodyList = dao.eyebodyList(memNo);
				havepoint = dao.havePoint(memNo);
				
				mav.addObject("member", member);
				mav.addObject("inbodyList", inbodyList);
				mav.addObject("eyebodyList", eyebodyList);
				mav.addObject("havepoint", havepoint);
				
				mav.setViewName("/WEB-INF/view/MypageMain.jsp");
			
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		return mav;
	}

}
