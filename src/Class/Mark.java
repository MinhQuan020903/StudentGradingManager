/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

/**
 *
 * @author KaoWai
 */
public class Mark {

    
    private String tenMH;
    private double diemQT;
    private double diemGK;
    private double diemCK;
    private double diemTBHK;
    private String ghiChu;

    public Mark(String tenMH, double diemQT, double diemGK, double diemCK, double diemTBHK, String ghiChu) {
        this.tenMH = tenMH;
        this.diemQT = diemQT;
        this.diemGK = diemGK;
        this.diemCK = diemCK;
        this.diemTBHK = diemTBHK;
        this.ghiChu = ghiChu;
    }

    
    public String getTenMH() {
        return tenMH;
    }

    public void setTenMH(String tenMH) {
        this.tenMH = tenMH;
    }

    public double getDiemQT() {
        return diemQT;
    }

    public void setDiemQT(double diemQT) {
        this.diemQT = diemQT;
    }

    public double getDiemGK() {
        return diemGK;
    }

    public void setDiemGK(double diemGK) {
        this.diemGK = diemGK;
    }

    public double getDiemCK() {
        return diemCK;
    }

    public void setDiemCK(double diemCK) {
        this.diemCK = diemCK;
    }

    public double getDiemTBHK() {
        return diemTBHK;
    }

    public void setDiemTBHK(double diemTBHK) {
        this.diemTBHK = diemTBHK;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

   
}
