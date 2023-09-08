/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.baitaplon;

import static com.mycompany.baitaplon.CauHinh.countNumber;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

/**
 *
 * @author nhutn
 */
public abstract class TaiKhoan {

    /**
     * @return the dsTkp
     */
    public List<TaiKhoanPhu> getDsTkp() {
        return dsTkp;
    }

    /**
     * @param dsTkp the dsTkp to set
     */
    public void setDsTkp(List<TaiKhoanPhu> dsTkp) {
        this.dsTkp = dsTkp;
    }

    /**
     * @return the maSo
     */
    public String getMaSo() {
        return maSo;
    }

    /**
     * @param maSo the maSo to set
     */
    public void setMaSo(String maSo) {
        this.maSo = maSo;
    }

    /**
     * @return the matKhau
     */
    public int getMatKhau() {
        return matKhau;
    }

    /**
     * @param matKhau the matKhau to set
     */
    public void setMatKhau(int matKhau) {
        this.matKhau = matKhau;
    }

    /**
     * @return the dem
     */
    public static int getDem() {
        return dem;
    }

    /**
     * @param aDem the dem to set
     */
    public static void setDem(int aDem) {
        dem = aDem;
    }

    /**
     * @return the random
     */
    public static Random getRandom() {
        return ranDom;
    }

    /**
     * @param aRandom the random to set
     */
    public static void setRandom(Random aRandom) {
        ranDom = aRandom;
    }

    /**
     * @return the soTienGui
     */
    public double getSoTienGui() {
        return soTienGui;
    }

    /**
     * @param soTienGui the soTienGui to set
     */
    public void setSoTienGui(double soTienGui) {
        this.soTienGui = soTienGui;
    }

    /**
     * @return the ngayTao
     */
    public Calendar getNgayTao() {
        return ngayTao;
    }

    /**
     * @param ngayTao the ngayTao to set
     */
    public void setNgayTao(Calendar ngayTao) {
        this.ngayTao = ngayTao;
    }

    private String maSo;
    private int matKhau;
    private static int dem = 0;
    private static Random ranDom = new Random();
    protected List<TaiKhoanPhu> dsTkp = new ArrayList<>();
    protected double soTienGui;
    private Calendar ngayTao;

    {
        this.setNgayTao(new GregorianCalendar());
        maSo = String.format("%8s%04d", CauHinh.f.format(this.getNgayTao().getTime()), ++dem);
        matKhau = ranDom.nextInt(999999) + 100000;
    }

    public TaiKhoan(double soTienGui) throws Exception {
        if (soTienGui >= 50000) {
            this.soTienGui = soTienGui;
        } else {
            throw new Exception("So tien toi thieu 50000");
        }
    }

    public void hienThi() {
        System.out.printf("So tien gui: %.1f\n", this.soTienGui);
        System.out.printf("Ma so: %s\n", this.maSo);
        System.out.printf("Mat khau: %d\n", this.matKhau);
    }

    public abstract void guiTien(double st);

    public abstract void rutTien(double st);

    public abstract double tinhTienLai();

    public void themTaiKhoanPhuCoKyHan(double st, String loaiKyHan) throws Exception {
        KyHan kyHan = KyHan.valueOf(loaiKyHan);
        TaiKhoanPhu tkp = new TaiKhoanCoKyHan(kyHan, st);
        this.dsTkp.add(tkp);
    }

    public void hienThiTaiKhoanPhu() {
        for (TaiKhoanPhu tkp : this.dsTkp) {
            tkp.hienThi();
        }
    }

    public TaiKhoanPhu layTaiKhoanPhu(int viTri) {
        return dsTkp.get(viTri);
    }

    public double tinhTongSoTienGuiTKP() {
        double a = 0;
        for (TaiKhoanPhu tkp : dsTkp) {
            a = a + tkp.getSoTienGui();
        }
        return a;
    }

    public void doiMatKhau(int mkCu, int mkMoi) {
        if (mkCu == this.getMatKhau()) {
            if (countNumber(mkMoi) == 6) {
                this.setMatKhau(mkMoi);
                System.out.println("Doi thanh cong.");
            } else {
                System.out.println("Mat khau khong phu hop");
            }
        } else {
            System.out.println("Nhap sai mat khau cu");
        }
    }
}
