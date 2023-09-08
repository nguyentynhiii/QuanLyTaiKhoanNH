/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.mycompany.baitaplon;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author nhutn
 */
public enum KyHan {
    MAC_DINH(0, 0, 0.2) {
        @Override
        public double tinhLai(double soTien) {
            return (soTien * this.laiSuat) / 1200;
        }
    },
    MOT_TUAN(7, Calendar.DAY_OF_YEAR, 2.0) {
        @Override
        public double tinhLai(double soTien) {
            return (soTien * this.laiSuat) / (4 * 1200);
        }
    },
    MOT_THANG(1, Calendar.MONTH, 5.5) {
        @Override
        public double tinhLai(double soTien) {
            return (soTien * this.laiSuat) / 1200;
        }
    },
    SAU_THANG(6, Calendar.MONTH, 7.5) {
        @Override
        public double tinhLai(double soTien) {
            return (soTien * this.laiSuat) / 50;
        }
    },
    MOT_NAM(1, Calendar.YEAR, 7.9) {
        @Override
        public double tinhLai(double soTien) {
            return (soTien * this.laiSuat) / 100;
        }
    };
    private int khoangTg;
    private int loai;
    protected double laiSuat;

    private KyHan(int khoangTg, int loai, double laiSuat) {
        this.khoangTg = khoangTg;
        this.loai = loai;
        this.laiSuat = laiSuat;
    }

    public Calendar tinhDaoHan() {
        Calendar c = new GregorianCalendar();
        c.add(this.loai, this.khoangTg);
        return c;
    }

    public abstract double tinhLai(double soTien);
}
