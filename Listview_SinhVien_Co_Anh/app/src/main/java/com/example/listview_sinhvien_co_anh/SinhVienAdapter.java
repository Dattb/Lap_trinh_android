package com.example.listview_sinhvien_co_anh;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class SinhVienAdapter extends BaseAdapter {

    Context mycontext;
    int mylayout;
    List <SinhVien> arraySinhVien;
    public  SinhVienAdapter (Context context,int layout,List<SinhVien> sinhVienList )
    {
        mycontext = context;
        mylayout = layout;
        arraySinhVien = sinhVienList;
    }

    @Override
    public int getCount() {
        return arraySinhVien.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater  inflater = (LayoutInflater) mycontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //convertView = inflater.inflate(mylayout,null);
        convertView = inflater.inflate(mylayout,null);
        TextView txtHoTenPhu =  convertView.findViewById(R.id.txtHoTenPhu);
        txtHoTenPhu.setText(arraySinhVien.get(position).HoTen);
        TextView txtCVPhu =   convertView.findViewById(R.id.txtCVPhu);
        txtCVPhu.setText(arraySinhVien.get(position).Diem+"");
        ImageView img = convertView.findViewById(R.id.img);
        img.setImageResource(arraySinhVien.get(position).Hinh);
        return convertView;
    }
}

