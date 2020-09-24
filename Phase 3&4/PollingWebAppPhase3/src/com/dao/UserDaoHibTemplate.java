package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pojo.Question;
import com.pojo.User;

@Repository(value="userHibTemplate")
public class UserDaoHibTemplate {

	@Autowired
	HibernateTemplate hibernateTemplate;
	
	@Transactional
	public void addUser(User user) {
		
		hibernateTemplate.save(user);
	}
	
	public List<User> getAllUsers(){
		
		 List<User> list=new ArrayList<>();  
		 list=hibernateTemplate.loadAll(User.class);  
		
		 return list;
	}
	
}
