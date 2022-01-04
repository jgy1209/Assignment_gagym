package com.gagym.mybatis.inter;

import java.util.ArrayList;

import com.gagym.dto.InstructorDTO;
import com.gagym.dto.ReviewDTO;

public interface IInstructorDAO
{
	public InstructorDTO profile(String insNo);
	public String searchReq(String insNo);
	public ArrayList<InstructorDTO> areas(String reqNo);
	public ArrayList<InstructorDTO> experiences(String reqNo);
	public ArrayList<InstructorDTO> prizes(String reqNo);
	public ArrayList<InstructorDTO> certificates(String reqNo);
	public int follower(String insNo);
	public double grade(String insNo);
	public ReviewDTO nowClass(String insNo);
	public ArrayList<ReviewDTO> reviews(String insNo);
}
