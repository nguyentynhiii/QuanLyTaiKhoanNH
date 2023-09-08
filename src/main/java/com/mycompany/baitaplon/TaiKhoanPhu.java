/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.baitaplon;

/**
 *
 * @author nhutn
 */
public abstract class TaiKhoanPhu extends TaiKhoan {

    public TaiKhoanPhu(double soTien) throws Exception {
        super(soTien);
    }

    @Override
    public abstract void guiTien(double st);

    public abstract void rutTien(double st, TaiKhoan tk);

    @Override
    public void hienThi() {
        System.out.printf("So tien gui: %.1f\n", this.soTienGui);
    }
}
