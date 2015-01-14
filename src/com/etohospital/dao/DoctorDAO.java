package com.etohospital.dao;

import java.util.List;

import com.etohospital.model.DoctorModel;

public interface DoctorDAO {

	int insertDoctor(DoctorModel doctor, int userId) throws Exception;
	int updateDoctor(DoctorModel doctor, int userId) throws Exception;
	int deleteDoctor(DoctorModel doctor, int userId) throws Exception;
	List<DoctorModel> getDoctor(DoctorModel doctor, int userId) throws Exception;
	
}
