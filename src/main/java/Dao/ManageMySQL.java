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

    public static void edit(int id ,String ten, float gia, String mota, String hinhanh, int phanloai, int trongkho)throws SQLException{
        String edit= "update product set tenHang=?,giaTien=?,mota=?,hinhAnh=?,loai=?,trongKho=? where id=?";
        PreparedStatement preparedStatement=connection.prepareStatement(edit);
        preparedStatement.setInt(7,id);
        preparedStatement.setString(1,ten);
        preparedStatement.setFloat(2,gia);
        preparedStatement.setString(3,mota);
        preparedStatement.setString(4,hinhanh);
        preparedStatement.setInt(5,phanloai);
        preparedStatement.setInt(6,trongkho);
        preparedStatement.executeUpdate();
    }

    public static void delete(int id)throws SQLException{
        String delete= "delete from product where id=?";
        PreparedStatement preparedStatement=connection.prepareStatement(delete);
        preparedStatement.setInt(1,id);
        preparedStatement.executeUpdate();
    }
    public List<SanPham> getSanPhamByCat(int catID) throws SQLException {
        List<SanPham> sanPhams = new ArrayList<>();
        String select = "select product.id,product.tenhang,product.hinhanh,product.giatien,product.mota,product.trongkho,product.tinhtrang,tencategory as loai from product inner join category c on product.loai = c.id where c.id=?";
        PreparedStatement statement = connection.prepareStatement(select);
        statement.setInt(1,catID);
        ResultSet rs = statement.executeQuery();
        while (rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("tenhang");
            String image = rs.getString("hinhanh");
            float price = rs.getFloat("giatien");
            String description = rs.getString("mota");
            int inventory = rs.getInt("trongkho");
            String status = rs.getString("tinhtrang");
            String category = rs.getString("loai");
            sanPhams.add(new SanPham(id,name,price,description,image,category,inventory,status));
        }
        return sanPhams;
    }
    public List<SanPham> getSanPhamByCatName(int catID,String fName) throws SQLException {
        List<SanPham> sanPhams = new ArrayList<>();
        String query = "select product.id,product.tenhang,product.hinhanh,product.giatien,product.mota,product.trongkho,product.tinhtrang,tencategory as loai from product inner join category c on product.loai = c.id where c.id=? and tenhang like '%" + fName + "%'";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1,catID);
        ResultSet rs = statement.executeQuery();
        while (rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("tenhang");
            String image = rs.getString("hinhanh");
            float price = rs.getFloat("giatien");
            String description = rs.getString("mota");
            int inventory = rs.getInt("trongkho");
            String status = rs.getString("tinhtrang");
            String category = rs.getString("loai");
            sanPhams.add(new SanPham(id,name,price,description,image,category,inventory,status));
        }
        return sanPhams;
    }
    public List<SanPham> getSanPhamByName(String fName) throws SQLException {
        List<SanPham> sanPhams = new ArrayList<>();
        String query = "select product.id,product.tenhang,product.hinhanh,product.giatien,product.mota,product.trongkho,product.tinhtrang,tencategory as loai from product inner join category c on product.loai = c.id where tenhang like '%" + fName + "%'";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet rs = statement.executeQuery();
        while (rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("tenhang");
            String image = rs.getString("hinhanh");
            float price = rs.getFloat("giatien");
            String description = rs.getString("mota");
            int inventory = rs.getInt("trongkho");
            String status = rs.getString("tinhtrang");
            String category = rs.getString("loai");
            sanPhams.add(new SanPham(id,name,price,description,image,category,inventory,status));
        }
        return sanPhams;
    }
    public SanPham getSanPhamById(int id) throws SQLException {
        SanPham sanPhams = null;
        String query = "select * from product where id=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1,id);
        ResultSet rs = statement.executeQuery();
        while (rs.next()){
            String name = rs.getString("tenhang");
            String image = rs.getString("hinhanh");
            float price = rs.getFloat("giatien");
            String description = rs.getString("mota");
            int inventory = rs.getInt("trongkho");
            String status = rs.getString("tinhtrang");
            String category = String.valueOf(rs.getInt("loai"));
            sanPhams = new SanPham(id,name,price,description,image,category,inventory,status);
        }
        return sanPhams;
    }
    public void deletePrd(int id) throws SQLException {
        String query = "delete from product where id=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1,id);
        statement.executeUpdate();
    }
}
