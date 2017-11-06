package Data;

import java.util.ArrayList;

public class UserData {
    private String name;
    private String Username;
    private String email;
    private String address;
    private String mobile;
    private int std;
    private String permission;
    private ArrayList<CourseData> courses;
    private boolean sessionEstablished = false;

    public ArrayList<CourseData> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<CourseData> courses) {
        this.courses = courses;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public boolean isSessionEstablished() {
        return sessionEstablished;
    }

    public void setSessionEstablished(boolean sessionEstablished) {
        this.sessionEstablished = sessionEstablished;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getStd() {
        return std;
    }

    public void setStd(int std) {
        this.std = std;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
