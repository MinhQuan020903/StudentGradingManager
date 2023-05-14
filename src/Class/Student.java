/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

/**
 *
 * @author KaoWai
 */
public class Student {
    private String hoTen;
    private String id;
    private String email;
    private String matKhau;
    private String sdt;
    private String ngaySinh;
    private String gioiTinh;
    private String khoi;
    private String lop;

    public String getMaTK() {
        return maTK;
    }

    public void setMaTK(String maTK) {
        this.maTK = maTK;
    }
    private String maTK;
    public Student() {
    }
    
    public Student(String hoTen, String id, String email, String matKhau, String sdt, String ngaySinh, String gioiTinh, String khoi, String lop, String maTK) {
        this.hoTen = hoTen;
        this.id = id;
        this.email = email;
        this.matKhau = matKhau;
        this.sdt = sdt;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.khoi = khoi;
        this.lop = lop;
        this.maTK = maTK;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getKhoi() {
        return khoi;
    }

    public void setKhoi(String khoi) {
        this.khoi = khoi;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }
    
}
