/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OOP;

/**
 *
 * @author quocd
 */
public class StudentBase {
    private String MAHS;
    private String HOTEN;
    private String MALOP;
    private String SDT;
    private String NGSINH;
    private String GIOITINH;
    private String MATK;

    public StudentBase(String MAHS, String HOTEN, String MALOP, String SDT, String NGSINH, String GIOITINH, String MATK) {
        this.MAHS = MAHS;
        this.HOTEN = HOTEN;
        this.MALOP = MALOP;
        this.SDT = SDT;
        this.NGSINH = NGSINH;
        this.GIOITINH = GIOITINH;
        this.MATK = MATK;
    }

    public String getMAHS() {
        return MAHS;
    }

    public void setMAHS(String MAHS) {
        this.MAHS = MAHS;
    }

    public String getHOTEN() {
        return HOTEN;
    }

    public void setHOTEN(String HOTEN) {
        this.HOTEN = HOTEN;
    }

    public String getMALOP() {
        return MALOP;
    }

    public void setMALOP(String MALOP) {
        this.MALOP = MALOP;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getNGSINH() {
        return NGSINH;
    }

    public void setNGSINH(String NGSINH) {
        this.NGSINH = NGSINH;
    }

    public String getGIOITINH() {
        return GIOITINH;
    }

    public void setGIOITINH(String GIOITINH) {
        this.GIOITINH = GIOITINH;
    }

    public String getMATK() {
        return MATK;
    }

    public void setMATK(String MATK) {
        this.MATK = MATK;
    }

    @Override
    public String toString() {
        return "StudentBase{" + "MAHS=" + MAHS + ", HOTEN=" + HOTEN + ", MALOP=" + MALOP + ", SDT=" + SDT + ", NGSINH=" + NGSINH + ", GIOITINH=" + GIOITINH + ", MATK=" + MATK + '}';
    }
    
}
