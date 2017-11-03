package DOA;

import Bean.*;
import Connection.ConnectionClass;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AccountantDoa {

    public static int save(AccountantBean bean) {
        int status = 0;
        try {
            Connection con = ConnectionClass.Connect();
            PreparedStatement pst = con.prepareStatement("insert into admin(name, email, password, address, contact) values(?,?,?,?,?)");
            pst.setString(1, bean.getName());
            pst.setString(2, bean.getEmail());
            pst.setString(3, bean.getPassword());
            pst.setString(4, bean.getAddress());
            pst.setString(5, bean.getContact());
            status = pst.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("------------------------------------------------->");
        System.out.println(status);
        return status;
    }

    public static List<AccountantBean> getAllRecords() {
        List<AccountantBean> list = new ArrayList<AccountantBean>();
        try {
            Connection con = ConnectionClass.Connect();
            PreparedStatement pst = con.prepareStatement("select * from admin");

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                AccountantBean bean = new AccountantBean();
                bean.setId(rs.getInt(1));
                bean.setName(rs.getString(2));
                bean.setEmail(rs.getString(3));
                bean.setPassword(rs.getString(4));
                bean.setAddress(rs.getString(5));
                bean.setContact(rs.getString(6));
                list.add(bean);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public static AccountantBean getRecordById(int id) {
        AccountantBean bean = new AccountantBean();
        try {
            Connection con = ConnectionClass.Connect();
            PreparedStatement ps = con.prepareStatement("select * from admin where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                bean.setId(rs.getInt(1));
                bean.setName(rs.getString(2));
                bean.setEmail(rs.getString(3));
                bean.setPassword(rs.getString(4));
                bean.setAddress(rs.getString(5));
                bean.setContact(rs.getString(6));
            }
            con.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }

        return bean;
    }
public static int update(AccountantBean bean){
	int status=0;
	try{
		Connection con=ConnectionClass.Connect();
		PreparedStatement ps=con.prepareStatement("update admin set name=?,email=?,password=?,address=?,contact=? where id=?");
		ps.setString(1,bean.getName());
		ps.setString(2,bean.getEmail());
		ps.setString(3,bean.getPassword());
		ps.setString(4,bean.getAddress());
		ps.setString(5,bean.getContact());
		ps.setInt(6,bean.getId());
		status=ps.executeUpdate();
		con.close();
	}catch(Exception ex){System.out.println(ex);}
	return status;
}	
public static int delete(int id){
	int status=0;
	try{
		Connection con=ConnectionClass.Connect();
		PreparedStatement ps=con.prepareStatement("delete from admin where id=?");
		ps.setInt(1,id);
		status=ps.executeUpdate();
		con.close();
	}catch(Exception ex){System.out.println(ex);}
	return status;
}
}
