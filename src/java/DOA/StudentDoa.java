package DOA;

import java.sql.Connection;
import Bean.StudentBean;
import Connection.ConnectionClass;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDoa {

    public static int save(StudentBean bean) {
        int status = 0;

        try {
            Connection con = ConnectionClass.Connect();
            PreparedStatement pst = con.prepareStatement("INSERT INTO details(name, email, sex, course, fee, paid, due, address, contact) VALUES(?,?,?,?,?,?,?,?,?)");
            pst.setString(1, bean.getName());
            pst.setString(2, bean.getEmail());
            pst.setString(3, bean.getSex());
            pst.setString(4, bean.getCourse());
            pst.setString(5, bean.getFee());
            pst.setString(6, bean.getPaid());
            pst.setString(7, bean.getDue());
            pst.setString(8, bean.getAddress());
            pst.setString(9, bean.getContact());
            status = pst.executeUpdate();
            con.close();
        } catch (Exception e) {
        }
        return status;
    }

    public static StudentBean getRecordByRoll(int rollno) {
        StudentBean bean = new StudentBean();
        try {
            Connection con = ConnectionClass.Connect();
            PreparedStatement pst = con.prepareStatement("SELECT * FROM details WHERE rollno=?");
            pst.setInt(1, rollno);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                bean.setRollno(rs.getInt(1));
                bean.setName(rs.getString(2));
                bean.setEmail(rs.getString(3));
                bean.setSex(rs.getString(4));
                bean.setCourse(rs.getString(5));
                bean.setFee(rs.getString(6));
                bean.setPaid(rs.getString(7));
                bean.setDue(rs.getString(8));
                bean.setAddress(rs.getString(9));
                bean.setContact(rs.getString(10));
                con.close();
            }

        } catch (Exception e) {
        }
        return bean;
    }

    public static List getAllRecords() {
        List<StudentBean> list = new ArrayList<StudentBean>();
        try {
            Connection con = ConnectionClass.Connect();
            PreparedStatement pst = con.prepareStatement("SELECT * FROM details");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                StudentBean bean = new StudentBean();
                bean.setRollno(rs.getInt(1));
                bean.setName(rs.getString(2));
                bean.setEmail(rs.getString(3));
                bean.setSex(rs.getString(4));
                bean.setCourse(rs.getString(5));
                bean.setFee(rs.getString(6));
                bean.setPaid(rs.getString(7));
                bean.setDue(rs.getString(8));
                bean.setAddress(rs.getString(9));
                bean.setContact(rs.getString(10));
                list.add(bean);
            }
            con.close();
        } catch (Exception e) {
        }
        return list;
    }

    public static int update(StudentBean bean) {
        int status = 0;
        try {
            Connection con = ConnectionClass.Connect();
            PreparedStatement pst = con.prepareStatement("UPDATE details SET name=?, email=?, sex=?, course=?, fee=?, paid=?, due=?, address=?, contact=? WHERE rollno=?");
            pst.setString(1, bean.getName());
            pst.setString(2, bean.getEmail());
            pst.setString(3, bean.getSex());
            pst.setString(4, bean.getCourse());
            pst.setString(5, bean.getFee());
            pst.setString(6, bean.getPaid());
            pst.setString(7, bean.getDue());
            pst.setString(8, bean.getAddress());
            pst.setString(9, bean.getContact());
            pst.setInt(10, bean.getRollno());
            status=pst.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return  status;
    }
    public static int delete(int rollno){
        int status=0;
        try{
            Connection con= ConnectionClass.Connect();
            PreparedStatement pst = con.prepareStatement("DELETE FROM details WHERE rollno=?");
            pst.setInt(1, rollno);
            status=pst.executeUpdate();
            con.close();
        }catch(Exception e){
            System.out.println(e);
        }
        return status;
    }
    public static List<StudentBean> getDues(){
        List<StudentBean> list = new ArrayList<StudentBean>();
        try {
            Connection con = ConnectionClass.Connect();
            PreparedStatement pst = con.prepareStatement("SELECT * FROM details WHERE due>0");
            ResultSet rs= pst.executeQuery();
            while(rs.next()){
                StudentBean bean = new StudentBean();
                bean.setRollno(rs.getInt(1));
                bean.setName(rs.getString(2));
                bean.setEmail(rs.getString(3));
                bean.setSex(rs.getString(4));
                bean.setCourse(rs.getString(5));
                bean.setFee(rs.getString(6));
                bean.setPaid(rs.getString(7));
                bean.setDue(rs.getString(8));
                bean.setAddress(rs.getString(9));
                bean.setContact(rs.getString(10));
                list.add(bean);
                con.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
}
