package com.gagym.mybatis.inter;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.gagym.dto.ClassReservationDTO;

public interface IMyExerciseClassDAO
{
	public ArrayList<ClassReservationDTO> myExerciseClass(String memNo);
	
	public int autoReject();
	
}
