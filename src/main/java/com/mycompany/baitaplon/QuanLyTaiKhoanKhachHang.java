/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.baitaplon;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nhutn
 */
public class QuanLyTaiKhoanKhachHang {

    /**
     * @return the dsTK
     */
    public List<TaiKhoan> getDsTK() {
        return dsTK;
    }

    /**
     * @param dsTK the dsTK to set
     */
    public void setDsTK(List<TaiKhoan> dsTK) {
        this.dsTK = dsTK;
    }

    /**
     * @return the dsKH
     */
    public List<KhachHang> getDsKH() {
        return dsKH;
    }

    /**
     * @param dsKH the dsKH to set
     */
    public void setDsKH(List<KhachHang> dsKH) {
        this.dsKH = dsKH;
    }

    private List<TaiKhoan> dsTK = new ArrayList<>();
    private List<KhachHang> dsKH = new ArrayList<>();

    public void moTaiKhoanKhongKyHan(String ht, String gt, String ns, String qq, String cccd, double st) throws ParseException, Exception {
        GioiTinh gioiTinh = GioiTinh.valueOf(gt);
        KhachHang kh = new KhachHang(ht, gioiTinh, ns, qq, cccd);
        TaiKhoan tk = new TaiKhoanKhongKyHan(st);
        kh.setTk(tk);
        dsTK.add(tk);
        dsKH.add(kh);
        tk.hienThi();
    }

    public void moTaiKhoanCoKyHan(double st, TaiKhoan tk, String lkh) throws Exception {
        if (st >= 100000) {
            tk.soTienGui -= st;
            tk.themTaiKhoanPhuCoKyHan(st, lkh);
        }
    }


    public TaiKhoan dangNhap(String ms, int mk) {
        return this.dsTK.stream().filter(a -> a.getMaSo().contains(ms) == true
                && a.getMatKhau() == mk).findFirst().get();
    }

    public void guiTien(double st, TaiKhoan tk) {
        tk.guiTien(st);
        System.out.println("Gui tien thanh cong");
        System.out.printf("So tien gui la: %.1f\n", tk.soTienGui);
    }

    public void rutTien(double st, TaiKhoan tk) {
        if (tk.soTienGui >= st) {
            tk.rutTien(st);
            System.out.println("Rut tien thanh cong");
            System.out.printf("So tien gui la: %.1f\n", tk.soTienGui);
        } else {
            System.out.println("Rut tien khong thanh cong");
        }
    }

    public void rutTien(double st, TaiKhoan tk, int vt) {
        tk.layTaiKhoanPhu(vt).rutTien(st, tk);
        System.out.printf("So tien gui la: %.1f\n", tk.layTaiKhoanPhu(vt).soTienGui);
        
    }

    public void tinhTienLai(String ms) {
        for (TaiKhoan tk : this.dsTK) {
            if (tk.getMaSo().contains(ms)) {
                System.out.printf("Tien lai la: %s\n", tk.tinhTienLai());
            }
        }
    }

    public KhachHang traCuuTheoTen(String ht) {
        return this.dsKH.stream().filter(a -> a.getHoTen().equals(ht) == true).findFirst().get();
    }

    public KhachHang traCuuTheoMaSo(String ms) {
        return this.dsKH.stream().filter(a -> a.getMaSo().contains(ms) == true).findFirst().get();
    }

    public List<TaiKhoan> traCuuDanhSach(String ms) {
        KhachHang kh = traCuuTheoMaSo(ms);
        if (kh != null) {
            List<TaiKhoan> ds = new ArrayList<>();
            ds.add(kh.getTk());
            ds.addAll(kh.getTk().dsTkp);
            return ds;
        }
        return null;
    }

    public void hienThi(List<TaiKhoan> ds) {
        for (TaiKhoan tk : ds) {
            tk.hienThi();
        }
    }

    public void hienThi() {
        this.dsKH.forEach(a -> a.hienThi());
    }

    public void sapXep() {
        this.dsKH.sort((a, b) -> {
            double c = a.getTk().getSoTienGui();
            double d = a.getTk().tinhTongSoTienGuiTKP();
            c = c + d;
            double e = b.getTk().getSoTienGui();
            double f = b.getTk().tinhTongSoTienGuiTKP();
            e = e + f;
            return -(c > e ? 1 : (c < e ? -1 : 0));
        });
    }
}
