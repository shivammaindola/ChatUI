package com.example.styledotmetask;

public class MyListData {
    private int profileImg;
    private String userName;
    private String userMsg;
    private String time;
    private String number;

    MyListData(int profileImg, String userName, String userMsg, String time, String number) {
        this.profileImg = profileImg;
        this.userName = userName;
        this.userMsg = userMsg;
        this.time = time;
        this.number = number;
    }

    int getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(int profileImg) {
        this.profileImg = profileImg;
    }

    String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    String getUserMsg() {
        return userMsg;
    }

    public void setUserMsg(String userMsg) {
        this.userMsg = userMsg;
    }

    String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
