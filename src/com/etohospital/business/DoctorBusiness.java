package com.etohospital.business;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.etohospital.dao.DoctorDAO;
import com.etohospital.dao.mysql.DoctorDAOMySQL;
import com.etohospital.model.DoctorModel;
import com.etohospital.service.DoctorService;

public class DoctorBusiness implements DoctorService {

	private static Logger logger = LoggerFactory.getLogger(DoctorService.class);
	private static DoctorDAO doctorDAO = new DoctorDAOMySQL();
	
	// 以下代码确保客户端必须完全遵循接口中定义的方法
	private volatile static DoctorService singleton;
	private DoctorBusiness(){};
	public static DoctorService getSingleton() {
		if (singleton == null) {
			synchronized (DoctorBusiness.class) {
				if (singleton == null) {
					singleton = new DoctorBusiness();
				}
			}
		}		
		return singleton;
	}
	
	@Override
	public int insertDoctor(DoctorModel doctor, int userId) throws Exception {
		
		if(doctor.getDoctorID() > 0)
		{
			throw new IllegalArgumentException("Invalid customer id value.");
		}
		
		int effectedRows = doctorDAO.insertDoctor(doctor, userId);
		
		if(logger.isDebugEnabled())
		{
			List<DoctorModel> doctors = doctorDAO.getDoctor(doctor, userId);
			logger.debug("Insert one doctor, the doctor id: " + doctors.get(0).getDoctorID());
		}
		
		return effectedRows;
	}

	@Override
	public int updateDoctor(DoctorModel doctor, int userId) throws Exception {
		
		if(doctor.getDoctorID() < 1)
		{
			throw new IllegalArgumentException("Invalid customer id value.");
		}
		
		int effectedRows = doctorDAO.updateDoctor(doctor, userId);
		
		if(logger.isDebugEnabled())
		{			
			logger.debug("Update one doctor, the doctor id: " + doctor.getDoctorID());
		}
		
		return effectedRows;
	}

	@Override
	public int deleteDoctor(DoctorModel doctor, int userId) throws Exception {

		if(doctor.getDoctorID() < 1)
		{
			throw new IllegalArgumentException("Invalid customer id value.");
		}
		
		int effectedRows = doctorDAO.updateDoctor(doctor, userId);
		
		if(logger.isDebugEnabled())
		{			
			logger.debug("Delete one doctor, the doctor id: " + doctor.getDoctorID());
		}
		
		return effectedRows;
	}

	@Override
	public List<DoctorModel> getDoctor(DoctorModel doctor, int userId) throws Exception {
		
		List<DoctorModel> doctors = doctorDAO.getDoctor(doctor, userId);
		
		if(logger.isDebugEnabled())
		{			
			if(doctors == null)
			{
				logger.debug("No one doctor found, the query doctor model: " + doctor.toString());
			}
			else
			{
				logger.debug(doctors.size() + " doctors found, the query doctor model: " + doctor.toString());
			}		
		}
		
		return doctors;
	}

}
