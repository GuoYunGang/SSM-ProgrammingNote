package com.gyg.dao;

import java.util.List;

import com.gyg.beans.Teacher;

/**
 * teacherdao
 */
public interface TeacherDao {

	// 根据id查询老师
	public Teacher getTeacherByID(Integer id);

	// 按照已经有的调节查询
	public List<Teacher> getTeacherByCondition(Teacher teacher);

	// 传入一个list集合，其中放入要查询的id进行查询
	public List<Teacher> getTeacherByIdIn(List<Integer> list);

	// 选择查询
	public List<Teacher> getTeacherByConditionChoose(Teacher teacher);

	// 更新
	public int updateTeacher(Teacher teacher);
}
