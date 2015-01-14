package com.etohospital.business;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.etohospital.dao.HealthConsultantDAO;
import com.etohospital.dao.mysql.HealthConsultantDAOMySQL;
import com.etohospital.model.HealthConsultantModel;
import com.etohospital.service.HealthConsultantService;

public class HealthConsultantBusiness implements HealthConsultantService {

	private static Logger logger = LoggerFactory.getLogger(HealthConsultantService.class);
	private static HealthConsultantDAO healthConsultantDAO = new HealthConsultantDAOMySQL();
	
	// 以下代码确保客户端必须完全遵循接口中定义的方法
	private volatile static HealthConsultantService singleton;
	private HealthConsultantBusiness(){};
	public static HealthConsultantService getSingleton() {
		if (singleton == null) {
			synchronized (HealthConsultantBusiness.class) {
				if (singleton == null) {
					singleton = new HealthConsultantBusiness();
				}
			}
		}		
		return singleton;
	}
	
	@Override
	public int insertHealthConsultant(HealthConsultantModel healthConsultant, int userId) throws Exception {
		
		if(healthConsultant.getHealthConsultantID() > 0)
		{
			throw new IllegalArgumentException("Invalid health consultant id value.");
		}
		
		int effectedRows = healthConsultantDAO.insertHealthConsultant(healthConsultant, userId);
		
		if(logger.isDebugEnabled())
		{
			List<HealthConsultantModel> healthConsultants = healthConsultantDAO.getHealthConsultant(healthConsultant, userId);
			logger.debug("Insert one health consultant, the health consultant id: " + healthConsultants.get(0).getHealthConsultantID());
		}
		
		return effectedRows;
	}

	@Override
	public int updateHealthConsultant(HealthConsultantModel healthConsultant, int userId) throws Exception {

		if(healthConsultant.getHealthConsultantID() < 1)
		{
			throw new IllegalArgumentException("Invalid health consultant id value.");
		}
		
		int effectedRows = healthConsultantDAO.updateHealthConsultant(healthConsultant, userId);
		
		if(logger.isDebugEnabled())
		{
			logger.debug("Update one health consultant, the health consultant id: " + healthConsultant.getHealthConsultantID());
		}
		
		return effectedRows;
	}

	@Override
	public int deleteHealthConsultant(HealthConsultantModel healthConsultant, int userId) throws Exception {

		if(healthConsultant.getHealthConsultantID() < 1)
		{
			throw new IllegalArgumentException("Invalid health consultant id value.");
		}
		
		int effectedRows = healthConsultantDAO.deleteHealthConsultant(healthConsultant, userId);
		
		if(logger.isDebugEnabled())
		{
			logger.debug("Delete one health consultant, the health consultant id: " + healthConsultant.getHealthConsultantID());
		}
		
		return effectedRows;
	}

	@Override
	public List<HealthConsultantModel> getHealthConsultant(HealthConsultantModel healthConsultant, int userId) throws Exception 
	{
		List<HealthConsultantModel> healthConsultants = healthConsultantDAO.getHealthConsultant(healthConsultant, userId);
		
		if(logger.isDebugEnabled())
		{			
			if(healthConsultants == null)
			{
				logger.debug("No one health consultant found, the query health consultant model: " + healthConsultant.toString());
			}
			else
			{
				logger.debug(healthConsultants.size() + "  health consultants found, the query health consultant model: " + healthConsultant.toString());
			}		
		}
		
		return healthConsultants;
	}

}
