package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentrepository;

    public void addstudenttodb(Student student) {
        studentrepository.addstudentindb(student);
    }

    public void addteachertodb(Teacher teacher) {
        studentrepository.addteacherindb(teacher);
    }

    public void addStudentTeacherPairtodb(String student, String teacher) {
        studentrepository.addStudentTeacherPairindb(student,teacher);
    }

    public Student getstudentbyname(String name) {
        return studentrepository.givestudentnamefromdb(name);
    }

    public Teacher getteacherbyname(String name) {
        return studentrepository.getteacherbynamefromdb(name);
    }

    public List<String> getStudentsByTeacherName(String teacher) {
        return studentrepository.givestudentbyteachernamefromdb(teacher);
    }

    public List<String> getallstudents() {
        return studentrepository.giveallstudentsfromdb();
    }

    public void deleteteacherbyname(String teacher) {
        studentrepository.deleteteacherbynamefromdb(teacher);
    }

    public void deleteallteachers() {
        studentrepository.deleteallteachersfromdb();
    }

}
