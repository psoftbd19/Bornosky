package com.bornosky;

public class StudentInfo {

    private String id;
    private String name;
    private String roll;
    private String phone;

    private boolean isChecked;

    public StudentInfo(String id, String name, String roll, String phone) {
        this.id = id;
        this.name = name;
        this.roll = roll;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
