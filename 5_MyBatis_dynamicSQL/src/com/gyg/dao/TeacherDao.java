package com.gyg.dao;

import java.util.List;

import com.gyg.beans.Teacher;

/**
 * teacherdao
 */
public interface TeacherDao {

	// ����id��ѯ��ʦ
	public Teacher getTeacherByID(Integer id);

	// �����Ѿ��еĵ��ڲ�ѯ
	public List<Teacher> getTeacherByCondition(Teacher teacher);

	// ����һ��list���ϣ����з���Ҫ��ѯ��id���в�ѯ
	public List<Teacher> getTeacherByIdIn(List<Integer> list);

	// ѡ���ѯ
	public List<Teacher> getTeacherByConditionChoose(Teacher teacher);

	// ����
	public int updateTeacher(Teacher teacher);
}
