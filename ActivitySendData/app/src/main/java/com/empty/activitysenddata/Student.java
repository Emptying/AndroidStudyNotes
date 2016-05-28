package com.empty.activitysenddata;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by Emptying on 2016/5/9.
 */
//public class Student implements Serializable {
public class Student implements Parcelable {
    private String name;
    private int age;
    public Student(String name ,int age){
        this.name=name;
        this.age=age;
    }

    protected Student(Parcel in) {
        name = in.readString();
        age = in.readInt();
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age){
        this.age=age;
    }
    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public String toString(){
        return "姓名:"+name+"---"+"年龄"+age+"岁";
    }

//需要重写这些方法
    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        //这个需要手动写其他IDE会自己生成
        dest.writeString(name);
        dest.writeInt(age);
    }
}
