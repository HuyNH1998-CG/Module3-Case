package Service;

import Dao.ManageMySQL;
import Model.SanPham;

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


    public  void saveSp(SanPham sanPham){
        list.add(sanPham);
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
