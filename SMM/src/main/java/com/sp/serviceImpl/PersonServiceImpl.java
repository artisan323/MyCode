package com.sp.serviceImpl;

import com.sp.mapper.PersonMapper;
import com.sp.pojo.Person;
import com.sp.service.PersonService;

public class PersonServiceImpl implements PersonService{

	private PersonMapper personMapper;
	
	
	public PersonMapper getPersonMapper() {
		return personMapper;
	}


	public void setPersonMapper(PersonMapper personMapper) {
		this.personMapper = personMapper;
	}


	@Override
	public Person showPerson(Integer id) {
		
		return personMapper.selectPersonById(id);
	}

	
}
