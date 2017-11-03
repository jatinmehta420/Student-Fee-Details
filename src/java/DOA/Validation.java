package DOA;

import Connection.ConnectionClass;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Validation {

    public static boolean validateAccountant(String email, String password) throws ClassNotFoundException, SQLException {
        boolean status = false;
        Connection con = ConnectionClass.Connect();
        PreparedStatement pst = con.prepareStatement("SELECT * FROM AccountantLogin WHERE email=? AND password=?");
        pst.setString(1, email);
        pst.setString(2, password);
        ResultSet rs = pst.executeQuery();
        status = rs.next();
        con.close();

        return status;
    }

    public static boolean validateAdmin(String email, String password) throws ClassNotFoundException, SQLException {
        boolean status = false;
        Connection con = ConnectionClass.Connect();
        PreparedStatement pst = con.prepareStatement("SELECT * FROM AdminLogin WHERE email=? AND password=?");
        pst.setString(1, email);
        pst.setString(2, password);
        ResultSet rs = pst.executeQuery();
        status = rs.next();
        con.close();

        return status;
    }
}
