package com.highline.login.dto;

public class UpdateUserPasswordRequest {

    private String userName;

    private String newPasswordFirst;

    private String newPasswordSecond;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNewPasswordFirst() {
        return newPasswordFirst;
    }

    public void setNewPasswordFirst(String newPasswordFirst) {
        this.newPasswordFirst = newPasswordFirst;
    }

    public String getNewPasswordSecond() {
        return newPasswordSecond;
    }

    public void setNewPasswordSecond(String newPasswordSecond) {
        this.newPasswordSecond = newPasswordSecond;
    }

    @Override
    public String toString() {
        return "UpdateUserPasswordRequest{" +
                "userName='" + userName + '\'' +
                ", newPasswordFirst='" + newPasswordFirst + '\'' +
                ", newPasswordSecond='" + newPasswordSecond + '\'' +
                '}';
    }
}
