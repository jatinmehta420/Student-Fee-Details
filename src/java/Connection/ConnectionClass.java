
package Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;


public class ConnectionClass {
    static  Connection con;
    public static Connection Connect() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Accounts", "root", "root");
        return con;
    }
}
