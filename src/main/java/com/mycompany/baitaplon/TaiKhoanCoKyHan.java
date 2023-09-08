/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.baitaplon;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author nhutn
 */
public class TaiKhoanCoKyHan extends TaiKhoanPhu {

    /**
     * @return the ngayDaoHan
     */
    public Calendar getNgayDaoHan() {
        return ngayDaoHan;
    }

    /**
     * @param ngayDaoHan the ngayDaoHan to set
     */
    public void setNgayDaoHan(Calendar ngayDaoHan) {
        this.ngayDaoHan = ngayDaoHan;
    }

    /**
     * @return the kyHan
     */
    public KyHan getKyHan() {
        return kyHan;
    }

    /**
     * @param kyHan the kyHan to set
     */
    public void setKyHan(KyHan kyHan) {
        this.kyHan = kyHan;
    }

    private Calendar ngayDaoHan;
    private KyHan kyHan;

    public TaiKhoanCoKyHan(KyHan kyHan, double soTien) throws Exception {
        super(soTien);
        this.ngayDaoHan = kyHan.tinhDaoHan();
        this.kyHan = kyHan;
    }

    @Override
    public void guiTien(double st) {
        if (this.isDaoHan()) {
            this.soTienGui += st;
        }
    }

    @Override
    public void rutTien(double st, TaiKhoan tk) {
        if (this.soTienGui >= st) {
            if (isDaoHan()) {
                capNhatSoTien();
                tk.guiTien(st);
                this.rutTien(st);
            } else {
                this.setKyHan(KyHan.MAC_DINH);
                tk.guiTien(st);
                this.rutTien(st);
            }
        }
    }

    @Override
    public void rutTien(double st) {
        this.soTienGui -= st;
    }

    @Override
    public double tinhTienLai() {
        return this.kyHan.tinhLai(this.soTienGui);
    }

    @Override
    public void hienThi() {
        super.hienThi();
        System.out.printf("Ky han: %s\n", this.kyHan);
    }

    public void capNhatSoTien() {
        this.soTienGui += tinhTienLai();
    }

    public boolean isDaoHan() {
        Calendar c = new GregorianCalendar();
        boolean v1 = this.getNgayDaoHan().get(Calendar.YEAR) == c.get(Calendar.YEAR);
        boolean v2 = this.getNgayDaoHan().get(Calendar.DAY_OF_YEAR) == c.get(Calendar.DAY_OF_YEAR);
        return v1 && v2;
    }
}
