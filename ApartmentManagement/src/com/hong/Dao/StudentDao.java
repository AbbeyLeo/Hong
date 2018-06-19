/**
 * 
 */
package com.hong.Dao;

import java.util.List;

import com.hong.bean.Student;

/**
 * @author Abbey
 *
 */
public interface StudentDao {
	public void insertStudent(Student student);
	public void deleteStudent(int id);
	public void updateStudent(Student student);
	public Student findStudentById(int id);
	public List<Student> findAllStudents();
	public List<Student> findStudentsByAnything(String anything);
	public List<Student> findStudentsByApart(String apart);
}
