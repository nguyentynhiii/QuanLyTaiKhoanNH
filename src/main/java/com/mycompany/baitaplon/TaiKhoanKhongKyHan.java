/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.baitaplon;

/**
 *
 * @author nhutn
 */
public class TaiKhoanKhongKyHan extends TaiKhoan {

    public TaiKhoanKhongKyHan(double soTienGui) throws Exception {
        super(soTienGui);
    }

    @Override
    public void guiTien(double st) {
        this.soTienGui += st;
    }

    @Override
    public void rutTien(double st) {
        if (this.soTienGui >= st) {
            this.soTienGui -= st;
        }
    }

    @Override
    public double tinhTienLai() {
        return (this.soTienGui * CauHinh.LAI_XUAT) / 1200;
    }

    @Override
    public void hienThi() {
        super.hienThi();
        System.out.printf("Lai xuat: %.1f\n", CauHinh.LAI_XUAT);
    }
}
