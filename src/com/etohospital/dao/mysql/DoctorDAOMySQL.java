package com.etohospital.dao.mysql;

import java.util.List;

import com.etohospital.dao.DoctorDAO;
import com.etohospital.model.DoctorModel;

public class DoctorDAOMySQL extends BaseDAOMySQL<DoctorModel> implements DoctorDAO {

	@Override
	public int insertDoctor(DoctorModel doctor, int userId) throws Exception {
	
		return genericInsert(doctor, userId);
	}

	@Override
	public int updateDoctor(DoctorModel doctor, int userId) throws Exception {
		
		return genericUpdate(doctor, userId);
	}

	@Override
	public int deleteDoctor(DoctorModel doctor, int userId) throws Exception {
		
		return genericDelete(doctor, userId);
	}

	@Override
	public List<DoctorModel> getDoctor(DoctorModel doctor, int userId) throws Exception {
		
		return genericQuery(doctor, userId);
	}
}
