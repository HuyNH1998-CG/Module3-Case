package Dao;

import Model.PhanLoai;
import Model.SanPham;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ManageMySQL {
    static Connection connection = ConnectionMySQL.getConnect();


    public static List<SanPham> Select() throws Exception {
        String Select = "SELECT * FROM product";
        ArrayList<SanPham> list = new ArrayList<>();
        PreparedStatement preparedStatement=connection.prepareStatement(Select);
        ResultSet resultSet = preparedStatement.executeQuery();


        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String ten=resultSet.getString(2);
            float gia=Float.parseFloat(resultSet.getString(3));
            String mota=resultSet.getString(5);
            String hinhanh=resultSet.getString(4);
            String phanloai=resultSet.getString(6);
            String trongKho=resultSet.getString(7);
            String status=resultSet.getString(8);

            list.add(new SanPham(id,ten,gia,mota,hinhanh,phanloai,trongKho,status));
            System.out.println(hinhanh);
        }

        return list;
    }

//    public static ArrayList<PhanLoai> SelectLoaiSp() throws Exception {
//        String Select = "SELECT * FROM case_study.category";
//        ArrayList<PhanLoai> listLoaiSP = new ArrayList<>();
//
//        Statement statement =  connection.createStatement();
//        ResultSet resultSet = statement.executeQuery(Select);
//
//        while (resultSet.next()) {
//            int idLoai= Integer.parseInt(resultSet.getString("Id_loai"));
//            String tenLoai=resultSet.getString("tenLoai");
//
//            listLoaiSP.add(new PhanLoai(idLoai,tenLoai));
//        }
//
//        return  listLoaiSP;
//    }
}
