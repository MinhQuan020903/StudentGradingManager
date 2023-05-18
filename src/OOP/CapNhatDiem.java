/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OOP;

/**
 *
 * @author quocd
 */
public class CapNhatDiem {
    private String tenHS;
    private String maHS;
    private String maMH;
    private String hocki;
    private String namhoc;
    private String tenMH;
    private String diemQT;
    private String diemGK;
    private String diemCK;
    private String ghichu;

    public CapNhatDiem(String tenHS, String maHS, String maMH, String hocki, String namhoc, String tenMH, String diemQT, String diemGK, String diemCK, String ghichu) {
        this.tenHS = tenHS;
        this.maHS = maHS;
        this.maMH = maMH;
        this.hocki = hocki;
        this.namhoc = namhoc;
        this.tenMH = tenMH;
        this.diemQT = diemQT;
        this.diemGK = diemGK;
        this.diemCK = diemCK;
        this.ghichu = ghichu;
    }

    public String getTenHS() {
        return tenHS;
    }

    public void setTenHS(String tenHS) {
        this.tenHS = tenHS;
    }

    public String getMaHS() {
        return maHS;
    }

    public void setMaHS(String maHS) {
        this.maHS = maHS;
    }

    public String getMaMH() {
        return maMH;
    }

    public void setMaMH(String maMH) {
        this.maMH = maMH;
    }

    public String getHocki() {
        return hocki;
    }

    public void setHocki(String hocki) {
        this.hocki = hocki;
    }

    public String getNamhoc() {
        return namhoc;
    }

    public void setNamhoc(String namhoc) {
        this.namhoc = namhoc;
    }

    public String getTenMH() {
        return tenMH;
    }

    public void setTenMH(String tenMH) {
        this.tenMH = tenMH;
    }

    public String getDiemQT() {
        return diemQT;
    }

    public void setDiemQT(String diemQT) {
        this.diemQT = diemQT;
    }

    public String getDiemGK() {
        return diemGK;
    }

    public void setDiemGK(String diemGK) {
        this.diemGK = diemGK;
    }

    public String getDiemCK() {
        return diemCK;
    }

    public void setDiemCK(String diemCK) {
        this.diemCK = diemCK;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    @Override
    public String toString() {
        return "CapNhatDiem{" + "tenHS=" + tenHS + ", maHS=" + maHS + ", maMH=" + maMH + ", hocki=" + hocki + ", namhoc=" + namhoc + ", tenMH=" + tenMH + ", diemQT=" + diemQT + ", diemGK=" + diemGK + ", diemCK=" + diemCK + ", ghichu=" + ghichu + '}';
    }
    
    
}
