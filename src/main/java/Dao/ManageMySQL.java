package Dao;

import Model.PhanLoai;
import Model.SanPham;

import java.sql.*;
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
        }

        return list;
    }


    public static void create(SanPham sanPham)throws SQLException{
        String create= "insert into product value(?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement=connection.prepareStatement(create);
        preparedStatement.setInt(1,sanPham.getId());
        preparedStatement.setString(2,sanPham.getTen());
        preparedStatement.setFloat(3,sanPham.getGia());
        preparedStatement.setString(4,sanPham.getMota());
        preparedStatement.setString(5,sanPham.getHinhanh());
        preparedStatement.setString(6,sanPham.getPhanloai());
        preparedStatement.setString(7,sanPham.getTrongKho());
        preparedStatement.setString(8,sanPham.getStatus());
        preparedStatement.execute();

    }
    public static void edit(int id, SanPham sanPham)throws SQLException{
        String edit= "update product set tenHang=?,giaTien=?,mota=?,hinhAnh=?,loai=?,trongKho=?,status=? where idSp=?";
        PreparedStatement preparedStatement=connection.prepareStatement(edit);
        preparedStatement.setInt(8,sanPham.getId());
        preparedStatement.setString(1,sanPham.getTen());
        preparedStatement.setFloat(2,sanPham.getGia());
        preparedStatement.setString(3,sanPham.getMota());
        preparedStatement.setString(4,sanPham.getHinhanh());
        preparedStatement.setString(5,sanPham.getPhanloai());
        preparedStatement.setString(6,sanPham.getTrongKho());
        preparedStatement.setString(7,sanPham.getStatus());
        preparedStatement.execute();

    }
    public static void delete(int id)throws SQLException{
        String delete= "delete from product where idSp=?";
        PreparedStatement preparedStatement=connection.prepareStatement(delete);
        preparedStatement.setInt(1,id);
        preparedStatement.execute();
    }
    public static ArrayList<SanPham> findByLoai(String loaiSp)throws SQLException{
        ArrayList<SanPham>findlist=new ArrayList<>();
        String delete= "select * from product where loai like'%"+loaiSp+"%'";
        PreparedStatement preparedStatement=connection.prepareStatement(delete);
        ResultSet resultSet=preparedStatement.executeQuery();

        while (resultSet.next()){
            int id = resultSet.getInt(1);
            String ten=resultSet.getString(2);
            float gia=Float.parseFloat(resultSet.getString(3));
            String mota=resultSet.getString(5);
            String hinhanh=resultSet.getString(4);
            String phanloai=resultSet.getString(6);
            String trongKho=resultSet.getString(7);
            String status=resultSet.getString(8);

            findlist.add(new SanPham(id,ten,gia,mota,hinhanh,phanloai,trongKho,status));

        }
        return findlist;
    }

}
