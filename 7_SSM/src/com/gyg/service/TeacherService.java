package com.gyg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gyg.beans.Teacher;
import com.gyg.dao.TeacherDao;

@Service
public class TeacherService {
	
	@Autowired
	private TeacherDao teacherDao;
	
	public void test01() {
		
	}

	public Teacher getTeacher(Integer id) {
		// TODO Auto-generated method stub
		Teacher teacher = teacherDao.getTeacherById(id);
		return teacher;
	}

	
}
