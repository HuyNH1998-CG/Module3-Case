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


    public  void saveSp(SanPham sanPham) throws Exception {
        ManageMySQL.create(sanPham);
        list.add(sanPham);


    }
    public void editSp(int index,SanPham sanPham){
        try {
            ManageMySQL.edit(index,sanPham);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    public void deleteSp(int index)  throws Exception{
        try {
            ManageMySQL.delete(list.get(index).getId());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        list= (ArrayList<SanPham>) ManageMySQL.Select();

    }

    public static ArrayList<SanPham> FindByLoai(String loai)throws Exception{
        return ManageMySQL.FindByLoai( loai);

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
