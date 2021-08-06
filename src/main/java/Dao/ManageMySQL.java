package Dao;

import Model.PhanLoai;
import Model.SanPham;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ManageMySQL {
    static Connection connection = ConnectionMySQL.getConnect();


    public static List<SanPham> Select() throws Exception {
        String Select = "select product.id,product.tenhang,product.hinhanh,product.giatien,product.mota,product.trongkho,product.tinhtrang,tencategory as loai from product inner join category c on product.loai = c.id order by product.id";
        ArrayList<SanPham> list = new ArrayList<>();
        PreparedStatement preparedStatement=connection.prepareStatement(Select);
        ResultSet resultSet = preparedStatement.executeQuery();


        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String ten=resultSet.getString("tenhang");
            float gia=Float.parseFloat(resultSet.getString("giatien"));
            String mota=resultSet.getString("mota");
            String hinhanh=resultSet.getString("hinhanh");
            String phanloai=resultSet.getString("loai");
            int trongKho=resultSet.getInt("trongkho");
            String status=resultSet.getString("tinhtrang");

            list.add(new SanPham(id,ten,gia,mota,hinhanh,phanloai,trongKho,status));
            System.out.println(hinhanh);
        }

        return list;
    }

    public static void addSP(String name, float price, String moTa, String hinhAnh, int phanloai, int trongKho) throws SQLException {
        String Select = "insert into product (tenhang, giatien, hinhanh, mota, loai, trongkho) value (?,?,?,?,?,?)" ;
        PreparedStatement preparedStatement=connection.prepareStatement(Select);
        preparedStatement.setString(1,name);
        preparedStatement.setFloat(2,price);
        preparedStatement.setString(3,hinhAnh);
        preparedStatement.setString(4,name);
        preparedStatement.setInt(5,phanloai);
        preparedStatement.setInt(6,trongKho);
        preparedStatement.executeUpdate();
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
