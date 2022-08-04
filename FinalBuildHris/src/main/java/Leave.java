import java.sql.*;

public class Leave {
    private static String url=  "jdbc:mysql:///hris";
    private static String user = "root";
    private static String pw = "Password1";

    public static void displayLeaveMenu(){
        System.out.println("Please select which function you'd like to perform  " +
                "\n1. Create new employee leave. \n2. Update existing employee leave. \n3. Delete employee leave. \n4. Show one employee leave. \n5. Show all employee leave." );
    }
    public static void saveLeave(String sLeave, String mLeave, String rHoliday, String pLeave,String cLeave, int empId){
        try {
            Connection con = DriverManager.getConnection(url,user,pw);
            Statement st = con.createStatement();
            //CREATE
            boolean inserted = st.execute("insert into leave_types(sick_leave,maternity_leave,religious_holiday,paternity_leave,casual_leave,empl_id" + ") " +
                    "VALUES('"+sLeave+"','"+mLeave+"','"+rHoliday+"','"+pLeave+"','"+cLeave+"','"+empId+"')");
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch(Exception e){

        }

    }

    static void deleteLeave(int id){
        try {
            Connection con = DriverManager.getConnection(url,user,pw);
            Statement st = con.createStatement();
            //DELETE
            boolean delete = st.execute("DELETE FROM leave_types\n" +
                    "WHERE leave_id =  '"+id+"'");
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch(Exception e){

        }
    }
    static void updateLeave(String sLeave, String mLeave, String rHoliday, String pLeave,String cLeave, int empId, int lId){
        try {
            Connection con = DriverManager.getConnection(url,user,pw);
            Statement st = con.createStatement();
            //UPDATE
            boolean update = st.execute("UPDATE leave_types\n" +
                    "SET\n" +
                    "sick_leave = '"+sLeave+"',\n" +
                    "maternity_leave = '"+mLeave+"',\n" +
                    "religious_holiday= '"+rHoliday+"',\n" +
                    "paternity_leave = '"+pLeave+"',\n" +
                    "casual_leave = '"+cLeave+"',\n" +
                    "empl_id = '"+empId+"'\n" +
                    "WHERE leave_id = '"+lId+"'");
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch(Exception e){

        }
    }
    static void showOneLeave(int id){
        try {
            Connection con = DriverManager.getConnection(url,user,pw);
            Statement st = con.createStatement();
            //READ
            String query = "select * from leave_types where leave_id= '"+id+"'";
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                System.out.println("Employee Id: " + rs.getString("empl_id") + "\n " + "Leave ID: " + rs.getString("leave_id") + "\n " + "Sick leave: "
                        + rs.getString("sick_leave")+ "\n " + "Maternity leave: " + rs.getString("maternity_leave")+ "\n "+ "Religious leave or holidays: " + rs.getString("religious_holiday")+ "\n " +  "Paternity leave: "+
                        rs.getString("paternity_leave") + "\n "+ "Casual leave:  " +
                        rs.getString("casual_leave"));
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch(Exception e){

        }

    }
    static void showLeave(){
        try {
            Connection con = DriverManager.getConnection(url,user,pw);
            Statement st = con.createStatement();
            //READ
            String query = "select * from leave_types";
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                System.out.println("Employee Id: " + rs.getString("empl_id") + "| " + "Leave ID: " + rs.getString("leave_id") + "| " + "Sick leave: "
                        + rs.getString("sick_leave")+ "| " + "Maternity leave: " + rs.getString("maternity_leave")+ "| "+ "Religious leave or holidays: " + rs.getString("religious_holiday")+ "| " +  "Paternity leave: "+
                        rs.getString("paternity_leave") + "| "+ "Casual leave:  " +
                        rs.getString("casual_leave"));
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch(Exception e){

        }
    }
}
