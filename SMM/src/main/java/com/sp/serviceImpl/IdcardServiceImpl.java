package com.sp.serviceImpl;

import com.sp.mapper.idCardMapper;
import com.sp.pojo.Idcard;
import com.sp.service.IdcardService;

public class IdcardServiceImpl implements IdcardService{

	
	private idCardMapper idcardmapper;
	
	public idCardMapper getIdcardmapper() {
		return idcardmapper;
	}
	public void setIdcardmapper(idCardMapper idcardmapper) {
		this.idcardmapper = idcardmapper;
	}
	@Override
	public Idcard showIdcard(Integer id) {
		// TODO Auto-generated method stub
		
		return idcardmapper.selectById(id);
	}

}
