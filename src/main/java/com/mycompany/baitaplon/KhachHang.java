
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.baitaplon;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author nhutn
 */
public class KhachHang {

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
     * @return the hoTen
     */
    public String getHoTen() {
        return hoTen;
    }

    /**
     * @param hoTen the hoTen to set
     */
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    /**
     * @return the gioiTinh
     */
    public GioiTinh getGioiTinh() {
        return gioiTinh;
    }

    /**
     * @param gioiTinh the gioiTinh to set
     */
    public void setGioiTinh(GioiTinh gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    /**
     * @return the ngaySinh
     */
    public Date getNgaySinh() {
        return ngaySinh;
    }

    /**
     * @param ngaySinh the ngaySinh to set
     */
    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    /**
     * @return the queQuan
     */
    public String getQueQuan() {
        return queQuan;
    }

    /**
     * @param queQuan the queQuan to set
     */
    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    /**
     * @return the soCCCD
     */
    public String getSoCCCD() {
        return soCCCD;
    }

    /**
     * @param soCCCD the soCCCD to set
     */
    public void setSoCCCD(String soCCCD) {
        this.soCCCD = soCCCD;
    }

    /**
     * @return the tk
     */
    public TaiKhoan getTk() {
        return tk;
    }

    /**
     * @param tk the tk to set
     */
    public void setTk(TaiKhoan tk) {
        this.tk = tk;
    }
    private static int dem = 0;
    private String maSo;
    private Calendar ngayTao;
    private String hoTen;
    private GioiTinh gioiTinh;
    private Date ngaySinh;
    private String queQuan;
    private String soCCCD;
    private TaiKhoan tk;

    {
        this.setNgayTao(new GregorianCalendar());
        maSo = String.format("%8s%4d", CauHinh.f.format(this.getNgayTao().getTime()), ++dem);
    }

    public KhachHang(String hoTen, GioiTinh gioiTinh, Date ngaySinh, String queQuan, String soCCCD) {
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.queQuan = queQuan;
        this.soCCCD = soCCCD;
    }

    public KhachHang(String hoTen, GioiTinh gioiTinh, String ngaySinh, String queQuan, String soCCCD) throws ParseException {
        this(hoTen, gioiTinh, CauHinh.f1.parse(ngaySinh), queQuan, soCCCD);
    }

    public void hienThi() {
        System.out.printf("Gioi tinh: %s\n", this.gioiTinh);
        System.out.printf("Ngay sinh: %s\n", CauHinh.f1.format(this.ngaySinh));
        System.out.printf("Que quan: %s\n", this.queQuan);
        System.out.printf("So CCCD: %s\n", this.soCCCD);
    }
}
