package com.gagym.mybatis.controller;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gagym.mybatis.inter.IInstructorDAO;


@Controller
public class InstructorProfileController
{
	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping(value = "/instructormain.action", method = RequestMethod.GET)
	public ModelAndView InstructorProfile(HttpSession session)
	{		
		ModelAndView mav = new ModelAndView();
		
		IInstructorDAO dao = sqlSession.getMapper(IInstructorDAO.class);
		
		String insNo = (String)session.getAttribute("insNo");
		
		if (insNo==null)
		{
			mav.addObject("msg","회원님은 강사권한이 없습니다.");
            mav.addObject("url","main.action");
            
            mav.setViewName("/WEB-INF/myPageView/Alert.jsp");
            return mav;
		}
		
		mav.addObject("profile", dao.profile(insNo));
		
		String reqNo = dao.searchReq(insNo);
		mav.addObject("areas", dao.areas(reqNo));
		mav.addObject("experiences", dao.experiences(reqNo));
		mav.addObject("prizes", dao.prizes(reqNo));
		mav.addObject("certificates", dao.certificates(reqNo));
		mav.addObject("follower", dao.follower(insNo));
		mav.addObject("grade", dao.grade(insNo));
		
		mav.addObject("nowClass", dao.nowClass(insNo));
		mav.addObject("reviews", dao.reviews(insNo));
		
		mav.setViewName("/WEB-INF/mainView/InstructorPageMain.jsp");
		
		return mav;
		
	}
}
