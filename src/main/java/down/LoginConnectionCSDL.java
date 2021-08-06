package down;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class LoginConnectionCSDL {
    public static Connection getConnection(){
        try{
            String url="jdbc:mysql://localhost:3306/module3case";
            String user="root";
            String passWord="dtk1051030073";
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection= DriverManager.getConnection(url,user,passWord);
            return connection;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
