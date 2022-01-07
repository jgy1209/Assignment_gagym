package com.gagym.mybatis.controller;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gagym.dto.OnedayDTO;
import com.gagym.mybatis.inter.IMyExerciseOnedayDAO;


@Controller
public class MyExerciseController
{
	@Autowired
	private SqlSession sqlSession;
	
	// 1. 나의 운동 메인 진입
	@RequestMapping(value = "/myexercise.action", method = RequestMethod.GET)
	public String myExercise(HttpSession session, Model model)
	{		
		String memNo = (String)session.getAttribute("memNo");
		
		if (memNo==null)
		{
			
			model.addAttribute("msg","로그인 후 이용가능합니다.");
			model.addAttribute("url","login.action");
			
			return "/WEB-INF/myPageView/Alert.jsp";
		}
		
		return "/WEB-INF/myExerciseView/MyExerciseMain.jsp";
		
	}
	
	
	// 2. 나의 원데이클래스
	@RequestMapping(value = "/myexerciseoneday.action", method = RequestMethod.GET)
	public String myExerciseOneday(HttpSession session, Model model)
	{		
		
		String memNo = (String)session.getAttribute("memNo");
		
		IMyExerciseOnedayDAO dao = sqlSession.getMapper(IMyExerciseOnedayDAO.class);
		
		model.addAttribute("onedayList", dao.myExerciseOneday(memNo));
		
		return "/WEB-INF/myExerciseView/MyExerciseOneday.jsp";
		
	}
	
	// 2-1-1. 나의 원데이클래스 - 강사 신청 목록
	@RequestMapping(value = "/myonedayreservation.action", method = RequestMethod.GET)
	public String myExerciseOnedayReservation(Model model, String onedayNo)
	{		
		IMyExerciseOnedayDAO dao = sqlSession.getMapper(IMyExerciseOnedayDAO.class);
		
		model.addAttribute("onedayNo", onedayNo);
		model.addAttribute("fixCheck", dao.fixCheck(onedayNo));
		model.addAttribute("onedayRsvList", dao.myOnedayReservation(onedayNo));
		
		return "/WEB-INF/myExerciseView/MyOnedayReservation.jsp";
	}
	
	// 2-1-2. 원데이클래스 강사 확정
	@RequestMapping(value = "/onedayfix.action", method = RequestMethod.GET)
	public String onedayFix(String rsvNo, String onedayNo)
	{			
		IMyExerciseOnedayDAO dao = sqlSession.getMapper(IMyExerciseOnedayDAO.class);
		
		dao.onedayFixAdd(rsvNo);
		
		return "redirect:myonedayreservation.action?onedayNo="+ onedayNo;
	}
	
	
	// 2-2-1. 나의 원데이클래스 등록 폼
	@RequestMapping(value = "/onedayinsertform.action", method = RequestMethod.GET)
	public String onedayInsertForm(Model model)
	{		
		IMyExerciseOnedayDAO dao = sqlSession.getMapper(IMyExerciseOnedayDAO.class);
		
		model.addAttribute("sportList", dao.sportList());
		model.addAttribute("timeList", dao.timeList());
		
		return "/WEB-INF/myExerciseView/OnedayInsertForm.jsp";
	}
	
	// 2-2-2. 원데이클래스 등록
	@RequestMapping(value = "/onedayinsert.action", method = RequestMethod.POST)
	public String onedayInsert(HttpSession session, OnedayDTO oneday)
	{				
		IMyExerciseOnedayDAO dao = sqlSession.getMapper(IMyExerciseOnedayDAO.class);
		
		String memNo = (String)session.getAttribute("memNo");
		
		oneday.setMemNo(memNo);
		
		dao.onedayAdd(oneday);
		
		return "redirect:myexerciseoneday.action";
	}
	
	
	// 2-3. 나의 원데이클래스 - 삭제
	@RequestMapping(value = "/onedaydelete.action", method = RequestMethod.GET)
	public String onedayDelete(String onedayNo)
	{		
		IMyExerciseOnedayDAO dao = sqlSession.getMapper(IMyExerciseOnedayDAO.class);
		
		dao.onedayRemove(onedayNo);
		
		return "redirect:myexerciseoneday.action";
		
	}
	
	// 2-4. 원데이 게시글 상세 조회
	@RequestMapping(value="/onedaycontent.action", method = RequestMethod.GET)
	public String onedayContent(Model model, String onedayNo)
	{
		IMyExerciseOnedayDAO dao = sqlSession.getMapper(IMyExerciseOnedayDAO.class);
		
		OnedayDTO oneday = new OnedayDTO();
		
		oneday = dao.onedayContent(onedayNo);
		
		model.addAttribute("oneday", oneday);
		model.addAttribute("member", dao.onedayPrivacy(oneday.getMemNo()));		// 게시글의 memNo를 이용하여 개인정보 출력
		
		return "/WEB-INF/myExerciseView/OnedayContent.jsp";
	}
}
