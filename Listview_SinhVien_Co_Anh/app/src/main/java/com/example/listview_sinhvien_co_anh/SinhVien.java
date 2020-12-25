package com.example.listview_sinhvien_co_anh;




public class SinhVien {

    protected  String HoTen;
    protected  int MaSV;
    protected  int NamSinh;
    protected  String Lop;
    protected  Double Diem;
    protected  String ChucVu;
    protected  int Hinh;


    public SinhVien(String hoTen, int maSV, int namSinh, String lop, Double diem,int hinh, String chucvu) {
        HoTen = hoTen;
        MaSV = maSV;
        NamSinh = namSinh;
        Lop = lop;
        Diem = diem;
        ChucVu= chucvu;
        Hinh = hinh;
    }

    public SinhVien(String hoTen, int maSV, int namSinh, String lop, Double diem,int hinh) {
        HoTen = hoTen;
        MaSV = maSV;
        NamSinh = namSinh;
        Lop = lop;
        Diem = diem;
        Hinh = hinh;
        ChucVu= "không";
    }

    public int getHinh() {
        return Hinh;
    }

    public void setHinh(int hinh) {
        Hinh = hinh;
    }

    public String getChucVu() {
        return ChucVu;
    }

    public void setChucVu(String chucVu) {
        ChucVu = chucVu;
    }

    public SinhVien() {


    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String hoTen) {
        HoTen = hoTen;
    }

    public int getMaSV() {
        return MaSV;
    }

    public void setMaSV(int maSV) {
        MaSV = maSV;
    }

    public int getNamSinh() {
        return NamSinh;
    }

    public void setNamSinh(int namSinh) {
        NamSinh = namSinh;
    }

    public String getLop() {
        return Lop;
    }

    public void setLop(String lop) {
        Lop = lop;
    }

    public Double getDiem() {
        return Diem;
    }

    public void setDiem(Double diem) {
        Diem = diem;
    }
    public String DanhGiaSinhVien ()
    {

        if (ChucVu.equals("không")){
            if (Diem>=9) return ("xuất Sắc");
            else if (Diem>=8) return ("Giỏi");
            else if (Diem>=6) return ("Khá");
            else if (Diem>=5) return ("Trung Bình");
            else  return ("Yếu");
        }else  if (ChucVu.equals("lop truong"))
        {
            if (Diem>=9-0.5) return ("xuất Sắc");
            else if (Diem>=8-0.5) return ("Giỏi");
            else if (Diem>=6-0.5) return ("Khá");
            else if (Diem>=5-0.5) return ("Trung Bình");
            else  return ("Yếu");
        }
        else  if (ChucVu.equals("lop pho"))
        {
            if (Diem>=9-0.3) return ("xuất Sắc");
            else if (Diem>=8-0.3) return ("Giỏi");
            else if (Diem>=6-0.3) return ("Khá");
            else if (Diem>=5-0.3) return ("Trung Bình");
            else  return ("Yếu");
        }
        else  if (ChucVu.equals("bi thu"))
        {
            if (Diem>=9-0.2) return ("xuất Sắc");
            else if (Diem>=8-0.2) return ("Giỏi");
            else if (Diem>=6-0.2) return ("Khá");
            else if (Diem>=5-0.2) return ("Trung Bình");
            else  return ("Yếu");
        }else  return "";

    }
}

