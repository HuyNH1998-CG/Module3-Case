package down;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class LoginConnectionCSDL {
    public static Connection getConnection(){
        try{
            String url="jdbc:mysql://localhost:3306/module3case?userSSL=false&useUnicode=yes&characterEncoding=UTF-8";
            String user="root";
            String passWord="Kanze9152";
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection= DriverManager.getConnection(url,user,passWord);
            return connection;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
