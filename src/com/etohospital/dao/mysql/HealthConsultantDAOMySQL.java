package com.etohospital.dao.mysql;

import java.util.List;

import com.etohospital.dao.HealthConsultantDAO;
import com.etohospital.model.HealthConsultantModel;

public class HealthConsultantDAOMySQL extends BaseDAOMySQL<HealthConsultantModel> implements HealthConsultantDAO {
	
	@Override
	public int insertHealthConsultant(HealthConsultantModel healthConsultant, int userId) throws Exception {
		
		return genericInsert(healthConsultant, userId);
	}

	@Override
	public int updateHealthConsultant(HealthConsultantModel healthConsultant, int userId) throws Exception {
		
		return genericUpdate(healthConsultant, userId);
	}

	@Override
	public int deleteHealthConsultant(HealthConsultantModel healthConsultant, int userId) throws Exception {
		
		return genericDelete(healthConsultant, userId);
	}

	@Override
	public List<HealthConsultantModel> getHealthConsultant(
			HealthConsultantModel healthConsultant, int userId) throws Exception {
		
		return genericQuery(healthConsultant, userId);
	}
}
