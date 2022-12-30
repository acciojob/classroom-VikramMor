package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class StudentRepository {

    Map<String,Student> studentmap = new HashMap<>();
    Map<String,Teacher> teachermap = new HashMap<>();
    Map<String,List<String>> teacherstudentmapping = new HashMap<>();

    public void addstudentindb(Student student) {
        studentmap.put(student.getName(),student);
    }

    public void addteacherindb(Teacher teacher) {
        teachermap.put(teacher.getName(),teacher);
    }

    public void addStudentTeacherPairindb(String student, String teacher) {
        if(studentmap.containsKey(student) && teachermap.containsKey(teacher)){
            studentmap.put(student,studentmap.get(student));
            teachermap.put(teacher,teachermap.get(teacher));
            List<String> studentlist = new ArrayList<String>();
            if(teacherstudentmapping.containsKey(teacher)){
                studentlist = teacherstudentmapping.get(teacher);
            }
            studentlist.add(student);
            teacherstudentmapping.put(teacher,studentlist);
        }
    }

    public Student givestudentnamefromdb(String name) {
        return studentmap.get(name);
    }

    public Teacher getteacherbynamefromdb(String name) {
        return teachermap.get(name);
    }

    public List<String> givestudentbyteachernamefromdb(String teacher) {
        List<String> stlist = new ArrayList<>();
        if(teacherstudentmapping.containsKey(teacher)){
            stlist = teacherstudentmapping.get(teacher);
        }
        return stlist;
    }

    public List<String> giveallstudentsfromdb() {
        return new ArrayList<>(studentmap.keySet());
    }

    public void deleteteacherbynamefromdb(String teacher) {
        List<String> slist = new ArrayList<>();
        if(teacherstudentmapping.containsKey(teacher)){
            slist = teacherstudentmapping.get(teacher);
            for(String s: slist){
                if(studentmap.containsKey(s)){
                    studentmap.remove(s);
                }
            }
            teacherstudentmapping.remove(teacher);
        }
        if(teachermap.containsKey(teacher)){
            teachermap.remove(teacher);
        }
    }

    public void deleteallteachersfromdb() {
        HashSet<String> studentset = new HashSet<>();
        for(String teacher:teacherstudentmapping.keySet()){
            for(String student: teacherstudentmapping.get(teacher)){
                studentset.add(student);
            }
        }
        for(String st:studentset){
            if(studentmap.containsKey(st)){
                studentmap.remove(st);
            }

        }
    }

}
