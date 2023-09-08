/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.baitaplon;

import java.text.SimpleDateFormat;

/**
 *
 * @author nhutn
 */
public class CauHinh {

    public static final SimpleDateFormat f = new SimpleDateFormat("ddMMyyyy");
    public static final SimpleDateFormat f1 = new SimpleDateFormat("dd/MM/yyyy");
    public static final double LAI_XUAT = 0.2;

    public static final int countNumber(int number) {
        int count = 0;
        while (number > 0) {
            number /= 10;
            count++;
        }
        return count;
    }
}
