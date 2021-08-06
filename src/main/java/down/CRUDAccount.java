package down;

import models.Account;

import java.sql.*;
import java.util.ArrayList;

public class CRUDAccount {
    static Connection connection= LoginConnectionCSDL.getConnection();

    public static ArrayList<Account> showAccount() throws SQLException {
        String sqlSelect="select * from users";
        Statement statement= connection.createStatement();
        ResultSet resultSet=statement.executeQuery(sqlSelect);
        ArrayList<Account> listAcc= new ArrayList<>();
        while (resultSet.next()){
            int id=resultSet.getInt("id");
            String userName= resultSet.getString("username");
            String passWord= resultSet.getString("password");
            String ten= resultSet.getString("ten");
            String ngaySinh= resultSet.getString("ngaysinh");
            String soDT= resultSet.getString("sodienthoai");
            String email= resultSet.getString("email");
            String diachi= resultSet.getString("diachi");
            String role= resultSet.getString("role");
            listAcc.add( new Account(id,userName,passWord,ten,ngaySinh,soDT,email,diachi,role));
        }
        return listAcc;
    }

    public static void saveAccount(Account account) throws SQLException {
        String sqlSave= "insert into users value (?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement= connection.prepareStatement(sqlSave);
        preparedStatement.setInt(1,account.getId());
        preparedStatement.setString(2,account.getUserName());
        preparedStatement.setString(3,account.getPassWord());
        preparedStatement.setString(4,account.getTen());
        preparedStatement.setString(5,account.getNgaySinh());
        preparedStatement.setString(6,account.getSoDT());
        preparedStatement.setString(7,account.getEmail());
        preparedStatement.setString(8,account.getDiaChi());
        preparedStatement.setString(9,account.getRole());
        preparedStatement.execute();
    }

    public static void editAccount(Account account) throws Exception{
        String sqlEdit="update users set username=?,password=?,ten=?,ngaysinh=?,sodienthoai=?,email=?,diachi=?,role=? where id=?";
        PreparedStatement preparedStatement= connection.prepareStatement(sqlEdit);
        preparedStatement.setInt(9,account.getId());
        preparedStatement.setString(1,account.getUserName());
        preparedStatement.setString(2,account.getPassWord());
        preparedStatement.setString(3,account.getTen());
        preparedStatement.setString(4,account.getNgaySinh());
        preparedStatement.setString(5,account.getSoDT());
        preparedStatement.setString(6,account.getEmail());
        preparedStatement.setString(7,account.getDiaChi());
        preparedStatement.setString(8,account.getRole());
        preparedStatement.execute();
    }

    public static void deleteAccount(int id) throws Exception{
        String sqlDelete="delete from users where id=?";
        PreparedStatement preparedStatement= connection.prepareStatement(sqlDelete);
        preparedStatement.setInt(1,id);
        preparedStatement.execute();
    }
}
