package com.etohospital.service;

import java.util.List;

import com.etohospital.model.HealthConsultantModel;

public interface HealthConsultantService {

	int insertHealthConsultant(HealthConsultantModel healthConsultant, int userId) throws Exception;
	int updateHealthConsultant(HealthConsultantModel healthConsultant, int userId) throws Exception;
	int deleteHealthConsultant(HealthConsultantModel healthConsultant, int userId) throws Exception;
	List<HealthConsultantModel> getHealthConsultant(HealthConsultantModel healthConsultant, int userId) throws Exception;
}
