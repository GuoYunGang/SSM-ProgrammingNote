package com.gyg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gyg.beans.Teacher;
import com.gyg.dao.TeacherDao;

@Service
public class TeacherService {

	@Autowired
	public TeacherDao teacherDao;
	
	public Teacher getTeacher(Integer id) {
		Teacher teacher = teacherDao.getTeacherById(id);
		return teacher;
	}
	
}
