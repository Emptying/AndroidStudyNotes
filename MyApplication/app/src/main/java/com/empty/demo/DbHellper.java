package com.empty.demo;

import com.activeandroid.*;
import com.activeandroid.app.Application;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedList;

/**
 * Created by cws10 on 2016/4/8.
 */


public class DbHellper {
    public static LinkedList<Student> students = new LinkedList<>();

    //查找元素
    public static Student FindStudentByName(String name) {
        Student result = null;
        for (Student st : students) {
            if (st.getName().equals(name)) {
                result = st;
                break;
            }
        }
        return result;
    }



    //密码验证
    public static Student VerifyUser(String name, String pwd) {
        Student result = null;
        Student student = FindStudentByName(name);
        if (student != null && student.getPwd().equals(pwd)) {
            result = student;
        }
        return result;
    }


    //添加元素
    public static boolean Add(Student student) {
        boolean result = false;
        if (FindStudentByName(student.getName()) == null) {
            students.add(student);
            result = true;
        }
        return result;
    }

    //计算MD5
    public static String Md5(String pwd) {
        String md5 = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(pwd.getBytes());
            for (byte o : md.digest()) {
                md5 = md5 + String.format("%02X", o);
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return md5;
    }


}

class Test extends Application {


}
