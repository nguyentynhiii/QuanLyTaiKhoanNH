/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.baitaplon;

import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author nhutn
 */
public class BaiTapLon {

    public static void main(String[] args) throws Exception {
        boolean isDangNhap = false;
        boolean cont = true;
        QuanLyTaiKhoanKhachHang ql = new QuanLyTaiKhoanKhachHang();
        Scanner sc = new Scanner(System.in);
        TaiKhoan tk = null;
        String taiKhoan = null;
        int matKhau;
        String maSo;
        KhachHang kh;
        String hoTen;
        String gioiTinh;
        String ngaySinh;
        String queQuan;
        String soCCCD;
        double soTienGui;
        String kyHan;
        int viTri;
        do {
            System.out.println("1. Dang ky");
            System.out.println("2. Dang nhap");
            System.out.println("3. Doi mat khau");
            System.out.println("4. Dang ky tai khoan phu");
            System.out.println("5. Gui tien");
            System.out.println("6. Rut tien");
            System.out.println("7. Tinh tien lai");
            System.out.println("8. Rut tien tai khoan co ky han");
            System.out.println("9. Tra cuu theo ten");
            System.out.println("10. Tra cuu theo ma so");
            System.out.println("11. Tra cuu danh sach theo ma so");
            System.out.println("12. Sap xep theo tien gui giam dan");
            System.out.println("13. Thoat");
            System.out.print("Vui long chon chuc nang: ");
            int chon = sc.nextInt();
            switch (chon) {
                case 1:
                    System.out.print("Nhap ho ten: ");
                    hoTen = sc.nextLine();
                    sc.nextLine();
                    try {
                        System.out.print("Nhap ngay sinh: ");
                        ngaySinh = sc.nextLine();
                        System.out.print("Nhap so tien gui: ");
                        soTienGui = Double.parseDouble(sc.nextLine());
                        System.out.print("Nhap que quan: ");
                        queQuan = sc.nextLine();
                        System.out.print("Nhap so CCCD: ");
                        soCCCD = sc.nextLine();
                        System.out.print("Nhap gioi tinh (NAM, NU, KHAC): ");
                        gioiTinh = sc.nextLine();
                        gioiTinh = gioiTinh.toUpperCase();
                        ql.moTaiKhoanKhongKyHan(hoTen, gioiTinh, ngaySinh, queQuan, soCCCD, soTienGui);
                        System.out.println("Mo tai khoan thanh cong");
                    } catch (NumberFormatException ex) {
                        System.out.println("So tien qua lon");
                    } catch (ParseException ex) {
                        System.out.println("Sai dinh dang ngay thang nam");
                    }
                    break;
                case 2:
                    System.out.print("Nhap tai khoan: ");
                    taiKhoan = sc.next();
                    System.out.print("Nhap mat khau: ");
                    matKhau = sc.nextInt();
                    tk = ql.dangNhap(taiKhoan, matKhau);
                    if (tk != null) {
                        isDangNhap = true;
                        System.out.println("Dang nhap thanh cong");
                    } else {
                        System.out.println("Sai tai khoan hoac mat khau");
                    }
                    break;
                case 3:
                    if (isDangNhap == false) {
                        System.out.println("Ban chua dang nhap");
                    } else {
                        try {
                            System.out.print("Nhap Mat Khau Cu: ");
                            int mkCu = sc.nextInt();
                            System.out.print("Nhap mat khau moi: ");
                            matKhau = sc.nextInt();
                            tk.doiMatKhau(mkCu, matKhau);
                        } catch (InputMismatchException e) {
                            System.out.println("Nhap sai dinh dang");
                        }
                    }
                    break;
                case 4:
                    if (isDangNhap == false) {
                        System.out.println("Ban chua dang nhap");
                    } else {
                        try {
                            System.out.print("Nhap so tien gui: ");
                            soTienGui = sc.nextInt();
                            System.out.println("Nhap loai ky han: MOT_TUAN, MOT_THANG ,SAU_THANG ,MOT_NAM");
                            kyHan = sc.next();
                            kyHan = kyHan.toUpperCase();
                            ql.moTaiKhoanCoKyHan(soTienGui, tk, kyHan);
                            System.out.println("Mo tai khoan thanh cong");
                        } catch (InputMismatchException ex) {
                            System.out.println("So tien qua lon");
                        } catch (IllegalArgumentException ex) {
                            System.out.println("Khong co loai ky han nay");
                        }
                    }
                    break;
                case 5:
                    if (isDangNhap == false) {
                        System.out.println("Ban chua dang nhap");
                    } else {
                        try {
                            System.out.print("Nhap so tien gui: ");
                            soTienGui = sc.nextInt();
                            ql.guiTien(soTienGui, tk);
                        } catch (InputMismatchException ex) {
                            System.out.println("So tien qua lon");
                        }
                    }
                    break;
                case 6:
                    if (isDangNhap == false) {
                        System.out.println("Ban chua dang nhap");
                    } else {
                        System.out.print("Nhap so tien rut: ");
                        soTienGui = sc.nextInt();
                        ql.rutTien(soTienGui, tk);
                    }
                    break;
                case 7:
                    System.out.print("Nhap tai khoan: ");
                    taiKhoan = sc.next();
                    ql.tinhTienLai(taiKhoan);
                    break;
                case 8:
                    if (isDangNhap == false) {
                        System.out.println("Ban chua dang nhap");
                    } else {
                        tk.hienThiTaiKhoanPhu();
                        System.out.print("Nhap so tien rut: ");
                        soTienGui = sc.nextInt();
                        System.out.print("Vui long chon tai khoan: ");
                        viTri = sc.nextInt();
                        viTri -= 1;
                        sc.nextLine();
                        ql.rutTien(soTienGui, tk, viTri);
                        break;
                    }
                case 9:
                    System.out.print("Nhap ho ten: ");
                    hoTen = sc.nextLine();
                    sc.nextLine();
                    KhachHang k = ql.traCuuTheoTen(hoTen);
                    if (k == null) {
                        System.out.println("Khong tim thay");
                    } else {
                        k.hienThi();
                    }
                    break;
                case 10:
                    System.out.print("Nhap ma so: ");
                    maSo = sc.nextLine();
                    sc.nextLine();
                    kh = ql.traCuuTheoMaSo(maSo);
                    if (kh == null) {
                        System.out.println("Khong tim thay");
                    } else {
                        kh.hienThi();
                    }
                    break;
                case 11:
                    System.out.print("Nhap ma so: ");
                    maSo = sc.nextLine();
                    sc.nextLine();
                    List<TaiKhoan> ds = ql.traCuuDanhSach(maSo);
                    if (ds != null) {
                        ql.hienThi(ds);
                    } else {
                        System.out.println("Khong tim thay");
                    }
                    break;
                case 12:
                    ql.sapXep();
                    ql.hienThi();
                    break;
                case 13:
                    tk = null;
                    isDangNhap = false;
                    System.out.println("Thoat Chuong Trinh Thanh Cong");
                    cont = false;
                    break;
                case 14:
                    ql.hienThi();
                    break;
            }
        } while (cont);
    }
}