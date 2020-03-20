package com.thoughtworks;

import com.thoughtworks.entities.QueryForStudent;
import com.thoughtworks.entities.Student;
import com.thoughtworks.entities.UpdateForStuden;

import java.util.List;

public class StudentRepository {

    public void save(List<Student> students) {
        students.forEach(this::save);
    }

    public void save(Student student) {
        // TODO:
        String sql = "INSERT INTO student(id,name,gender,admissionYear,birthday,classId) values(?,?,?,?,?,?)";
        UpdateForStuden.update(sql, student.getId(), student.getName(), student.getGender(), student.getAdmissionYear(), student.getBirthday(), student.getClassId());
    }

    public List<Student> query() {
        // TODO:
        String sql = "SELECT id,name,gender,admissionYear,birthday,classId FROM student";
        return QueryForStudent.queryForStudent(sql);

    }

    public List<Student> queryByClassId(String classId) {
        // TODO:
        String sql = "SELECT id,name,gender,admissionYear,birthday,classId FROM student WHERE classId=? ORDER BY id DESC";
        return QueryForStudent.queryForStudent(sql, classId);
    }

    public void update(String id, Student student) {
        // TODO:
        String sql = "UPDATE student SET name=?,gender=?,admissionYear=?,birthday=?,classId=? WHERE id=?";
        UpdateForStuden.update(sql, student.getName(), student.getGender(), student.getAdmissionYear(), student.getBirthday(), student.getClassId(), student.getId());
    }

    public void delete(String id) {
        // TODO:
        String sql = "DELETE FROM student WHERE id=?";
        UpdateForStuden.update(sql, id);
    }
}
