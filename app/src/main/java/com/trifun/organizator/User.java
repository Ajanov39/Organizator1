package com.trifun.organizator;

import android.os.Parcel;
import android.os.Parcelable;

public class User  implements Parcelable{

private String name;
private String eMail;
private int phone;
private  String pas;

    public User(String name, String eMail, int phone, String pas) {
        this.name = name;
        this.eMail = eMail;
        this.phone = phone;
        this.pas = pas;






    }


    protected User(Parcel in) {
        name = in.readString();
        eMail = in.readString();
        phone = in.readInt();
        pas = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getPas() {
        return pas;
    }

    public void setPas(String pas) {
        this.pas = pas;
    }

    @Override
    public int describeContents() { return 0; }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(eMail);
        dest.writeInt(phone);
        dest.writeString(pas);
    }
}



