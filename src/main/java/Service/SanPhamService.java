package Service;

import Dao.ManageMySQL;
import Model.SanPham;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Collection;
import java.util.List;

public class SanPhamService {
    public static ArrayList<SanPham>list=new ArrayList<>();

    public  SanPhamService() {
        try {
            list = (ArrayList<SanPham>) ManageMySQL.Select();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public  void saveSp(String name, float price, String moTa, String hinhAnh, int phanloai, int trongKho){
        try {
            ManageMySQL.addSP(name, price, moTa, hinhAnh, phanloai, trongKho);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
    public void editSp(SanPham sanPham,int index){
        list.set(index,sanPham);
    }
    public void deleteSp(int index){
        list.remove(index);
    }

    public SanPham FindByLoai(int loai){
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getPhanloai().equals(loai)){
                return list.get(i);
            }
        }
        return null;
    }

    public SanPham FindSpNew(int id){
        SanPham max=list.get(0);
        for (int i = 0; i < list.size(); i++) {
           if(list.get(i).getId()>max.getId()){
               max=list.get(i);
           }
        }
            return null;
    }
}
