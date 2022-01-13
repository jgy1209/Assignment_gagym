package com.gagym.mybatis.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gagym.dto.ClassReservationDTO;
import com.gagym.dto.DisputeDTO;
import com.gagym.dto.OnedayDTO;
import com.gagym.dto.ReviewDTO;
import com.gagym.mybatis.inter.IMyExerciseClassDAO;
import com.gagym.mybatis.inter.IMyExerciseOnedayDAO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


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
	public String onedayFix(Model model, String rsvNo, String onedayNo)
	{			
		IMyExerciseOnedayDAO dao = sqlSession.getMapper(IMyExerciseOnedayDAO.class);
		
		dao.onedayFixAdd(rsvNo);
		
		model.addAttribute("msg","강사가 확정되었습니다.");
		model.addAttribute("url","myonedayreservation.action?onedayNo="+onedayNo);
		
		return "/WEB-INF/myPageView/Alert.jsp";
	}
	
	
	// 2-2-1. 나의 원데이클래스 등록 폼
	@RequestMapping(value = "/onedayinsertform.action", method = RequestMethod.GET)
	public String onedayInsertForm(Model model)
	{		
		IMyExerciseOnedayDAO dao = sqlSession.getMapper(IMyExerciseOnedayDAO.class);
		
		// selectBox
		model.addAttribute("sportList", dao.sportList());
		model.addAttribute("timeList", dao.timeList());
		
		return "/WEB-INF/myExerciseView/OnedayInsertForm.jsp";
	}
	
	// 2-2-2. 원데이클래스 등록
	@RequestMapping(value = "/onedayinsert.action", method = RequestMethod.POST)
	public String onedayInsert(Model model, HttpSession session, OnedayDTO oneday)
	{				
		IMyExerciseOnedayDAO dao = sqlSession.getMapper(IMyExerciseOnedayDAO.class);
		
		String memNo = (String)session.getAttribute("memNo");
		
		oneday.setMemNo(memNo);
		
		dao.onedayAdd(oneday);
		
		model.addAttribute("msg","등록이 완료되었습니다.");
		model.addAttribute("url","myexerciseoneday.action");
		
		return "/WEB-INF/myPageView/Alert.jsp";
	}
	
	// 2-3. 나의 원데이클래스 - 삭제
	@RequestMapping(value = "/onedaydelete.action", method = RequestMethod.GET)
	public String onedayDelete(String onedayNo)
	{		
		IMyExerciseOnedayDAO dao = sqlSession.getMapper(IMyExerciseOnedayDAO.class);
		
		dao.onedayRemove(onedayNo);
		
		return "redirect:myexerciseoneday.action";
		
	}
	
	
	// 3. 나의 강좌 - 수강신청 목록
	@RequestMapping(value = "/myexerciseclass.action", method = RequestMethod.GET)
	public String myExerciseClass(HttpSession session, Model model)
	{		
		String memNo = (String)session.getAttribute("memNo");
		
		IMyExerciseClassDAO dao = sqlSession.getMapper(IMyExerciseClassDAO.class);
		
		dao.autoReject();
		
		model.addAttribute("classList", dao.myExerciseClass(memNo));
		
		return "/WEB-INF/myExerciseView/MyExerciseClass.jsp";
		
	}
	
	// 3-1-1. 예약 취소 폼
	@RequestMapping(value = "/classcancelform.action", method = RequestMethod.GET)
	public String myClassCancelForm(Model model, String classRsvNo)
	{		
		IMyExerciseClassDAO dao = sqlSession.getMapper(IMyExerciseClassDAO.class);
		
		model.addAttribute("cnlCheck", dao.cnlCheck(classRsvNo));
		model.addAttribute("classRsvNo", classRsvNo);
		
		return "/WEB-INF/myExerciseView/ClassCancelForm.jsp";
		
	}
	// 3-1-2. 예약 취소 
	@RequestMapping(value = "/classcancel.action", method = RequestMethod.POST)
	public String myClassCancel(ClassReservationDTO dto)
	{		
		IMyExerciseClassDAO dao = sqlSession.getMapper(IMyExerciseClassDAO.class);
		
		dao.classCancel(dto);
		
		return "redirect:myexerciseclass.action";
		
	}
	// 3-2. 수강 확정 
	@RequestMapping(value = "/classcomplete.action", method = RequestMethod.GET)
	public String myClassComplete(String classRsvNo)
	{		
		IMyExerciseClassDAO dao = sqlSession.getMapper(IMyExerciseClassDAO.class);
		
		dao.classComplete(classRsvNo);
		
		return "redirect:myexerciseclass.action";
		
	}
	// 3-3-1. 리뷰 작성 폼
	@RequestMapping(value = "/classreviewinsertform.action", method = RequestMethod.GET)
	public String classReviewInsertForm(Model model, String classComNo)
	{		
		IMyExerciseClassDAO dao = sqlSession.getMapper(IMyExerciseClassDAO.class);
		
		model.addAttribute("review", dao.classInfo(classComNo));
		
		return "/WEB-INF/myExerciseView/ClassReviewForm.jsp";
		
	}
	// 3-3-2. 리뷰 작성
	@RequestMapping(value = "/classreviewinsert.action", method = RequestMethod.POST)
	public String classReviewInsert(ReviewDTO dto)
	{		
		IMyExerciseClassDAO dao = sqlSession.getMapper(IMyExerciseClassDAO.class);
		
		dao.classReviewAdd(dto);
		
		return "redirect:myexerciseclass.action";
	}
	// 3-3-3. 리뷰 보기
	@RequestMapping(value = "/classreview.action", method = RequestMethod.GET)
	public String classReview(Model model, String reviewNo)
	{		
		IMyExerciseClassDAO dao = sqlSession.getMapper(IMyExerciseClassDAO.class);
		
		model.addAttribute("review", dao.classReview(reviewNo));
		
		return "/WEB-INF/myExerciseView/ClassReview.jsp";
		
	}
	// 3-4-1. 분쟁조정 신청 폼
	@RequestMapping(value = "/classdisputeform.action", method = RequestMethod.GET)
	public String classDisputeForm(Model model, String classRsvNo)
	{		
		IMyExerciseClassDAO dao = sqlSession.getMapper(IMyExerciseClassDAO.class);
		
		model.addAttribute("classR", dao.classInfo2(classRsvNo));
		
		return "/WEB-INF/myExerciseView/ClassDisputeForm.jsp";
		
	}
	// 3-4-2. 분쟁조정 신청
	@RequestMapping(value = "/classdispute.action", method = RequestMethod.POST)
	public String classDispute(HttpServletRequest request, HttpSession session, DisputeDTO dto) throws IOException
	{		
		String memNo = (String)session.getAttribute("memNo");
		
		//-- 파일 업로드 위치
		String savePath = "C:\\FinalPrj\\Final\\WebContent\\upload\\dispute\\";
		
		int maxSize = 1024 * 1024 * 1024; 	// 최대 1GB
		String encodingType = "UTF-8";
		MultipartRequest multi = new MultipartRequest(request, savePath, maxSize, encodingType, new DefaultFileRenamePolicy());
		String classDisPath = multi.getFilesystemName("classDisPath");
		
		dto.setMemNo(memNo);
		dto.setClassDisTitle(multi.getParameter("classDisTitle"));
		dto.setClassRsvNo(multi.getParameter("classRsvNo"));
		dto.setClassDisContent(multi.getParameter("classDisContent"));
		dto.setClassDisPath("http://localhost:8090/Final/upload/dispute/" + classDisPath);
		
		IMyExerciseClassDAO dao = sqlSession.getMapper(IMyExerciseClassDAO.class);
		
		dao.classDisputeAdd(dto);
		
		return "redirect:myexerciseclass.action";
		
	}
}
