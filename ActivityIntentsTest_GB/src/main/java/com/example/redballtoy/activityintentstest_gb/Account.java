package com.example.redballtoy.activityintentstest_gb;


import android.os.Parcel;
import android.os.Parcelable;

public class Account implements Parcelable {
    private String name;
    private String surName;
    private int age;
    private String email;

    public Account(String name, String surName, int age, String email) {
        setName(name);
        setSurName(surName);
        setAge(age);
        setEmail(email);
    }

    public Account() {

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(surName);
        dest.writeInt(age);
        dest.writeString(email);
    }

    protected Account(Parcel in) {
        name = in.readString();
        surName = in.readString();
        age = in.readInt();
        email = in.readString();
    }

    public static final Creator<Account> CREATOR = new Creator<Account>() {
        @Override
        public Account createFromParcel(Parcel in) {
            return new Account(in);
        }

        @Override
        public Account[] newArray(int size) {
            return new Account[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
