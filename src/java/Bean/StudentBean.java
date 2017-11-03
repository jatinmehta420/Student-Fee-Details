package Bean;

public class StudentBean {

    private String name, email, sex, course, fee, paid, due, address, contact;
    private int  rollno;
    public StudentBean(){
        
    }

    public StudentBean(String name, String email, String sex, String course, String fee, String paid, String due, String address, String contact) {
        this.name = name;
        this.email = email;
        this.sex = sex;
        this.course = course;
        this.fee = fee;
        this.paid = paid;
        this.due = due;
        this.address = address;
        this.contact = contact;
    }
    
    public StudentBean(int rollno, String name, String email, String sex, String course, String fee, String paid, String due, String address, String contact){
        this.rollno=rollno;
        this.name = name;
        this.email = email;
        this.sex = sex;
        this.course = course;
        this.fee = fee;
        this.paid = paid;
        this.due = due;
        this.address = address;
        this.contact = contact;
    }

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getPaid() {
        return paid;
    }

    public void setPaid(String paid) {
        this.paid = paid;
    }

    public String getDue() {
        return due;
    }

    public void setDue(String due) {
        this.due = due;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

}
