package models;

public class Account {
    private int id;
    private String userName;
    private String passWord;
    private String ten;
    private String ngaySinh;
    private String soDT;
    private String email;
    private String diaChi;
    private String role;

    public Account() {
    }

    public Account(int id, String userName, String passWord, String ten, String ngaySinh, String soDT, String email, String diaChi, String role) {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.soDT = soDT;
        this.email = email;
        this.diaChi = diaChi;
        this.role = role;
    }

    public Account(String userName, String passWord, String ten, String ngaySinh, String sDT, String email, String diaChi, String role) {
        this.userName = userName;
        this.passWord = passWord;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.soDT = soDT;
        this.email = email;
        this.diaChi = diaChi;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
