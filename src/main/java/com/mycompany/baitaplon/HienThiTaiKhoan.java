/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.baitaplon;

/**
 *
 * @author nhutn
 */
public interface HienThiTaiKhoan {

    String layKieuTaiKhoan();

    default void show() {
        System.out.println(layKieuTaiKhoan());
        System.out.println(this);
    }
}
