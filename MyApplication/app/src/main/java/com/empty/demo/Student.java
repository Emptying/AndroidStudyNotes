package com.empty.demo;


import android.os.Parcel;
import android.os.Parcelable;

import com.activeandroid.ActiveAndroid;

/**
 * Created by cws10 on 2016/4/8.
 */
public class Student implements Parcelable {
    private String ID;
    private String name;
    private String pwd;
    public Student(){

    }
    public  Student(String name,String pwd){
        this.name=name;
        this.pwd=pwd;
    }


    protected Student(Parcel in) {
        ID = in.readString();
        name = in.readString();
        pwd = in.readString();
    }


    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

//实现接口
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
        dest.writeString(ID);
        dest.writeString(name);
        dest.writeString(pwd);
    }
}

