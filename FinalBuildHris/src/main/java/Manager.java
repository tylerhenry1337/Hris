import java.sql.*;

public class Manager {
    private static String url=  "jdbc:mysql:///hris";
    private static String user = "root";
    private static String pw = "Password1";

    public static void displayManagerMenu(){
        System.out.println("Please select which function you'd like to perform  " +
                "\n1. Create new manager information. \n2. Update existing manager information. \n3. Delete manager information. \n4. Show one manager information. \n5. Show all manager information." );
    }
    static void saveManager(int empId,int depId,String title, String lName){
        try {
            Connection con = DriverManager.getConnection(url,user,pw);
            Statement st = con.createStatement();
            //CREATE
            boolean inserted = st.execute("insert into manager(empl_id,department_id,title,lname" + ") VALUES('"+empId+"','"+depId+"','"+title+"','"+lName+"')");
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch(Exception e){

        }

    }

    static void deleteManager(int id){
        try {
            Connection con = DriverManager.getConnection(url,user,pw);
            Statement st = con.createStatement();
            //DELETE
            boolean delete = st.execute("DELETE FROM manager\n" +
                    "WHERE empl_id =  '"+id+"'");
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch(Exception e){

        }
    }
    //Need to figure out how to return an error if updating an id DNE
    static void updateManager(int empId,int depId,String title, String lName, int manId){
        try {
            Connection con = DriverManager.getConnection(url,user,pw);
            Statement st = con.createStatement();
            //UPDATE
            boolean update = st.execute("UPDATE manager\n" +
                    "SET\n" +
                    "empl_id = '"+empId+"',\n" +
                    "department_id = '"+depId+"',\n" +
                    "title = '"+title+"',\n" +
                    "lname = '"+lName+"'\n" +
                    "WHERE manager_id = '"+manId+"'");
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch(Exception e){

        }
    }
    static void showOneManager(int id){
        try {
            Connection con = DriverManager.getConnection(url,user,pw);
            Statement st = con.createStatement();
            //READ
            String query = "select * from manager where empl_id = '"+id+"'";
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                System.out.println("Employee Id: " + rs.getString("empl_id") + "\n " + "Department ID: " + rs.getString("department_id") + "\n " + "Management title: "
                        + rs.getString("title")+ "\n " + "Manager ID: " + rs.getString("manager_id") +"\n " + "Last name: " + rs.getString("lname"));
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch(Exception e){

        }

    }
    static void showManager(){
        try {
            Connection con = DriverManager.getConnection(url,user,pw);
            Statement st = con.createStatement();
            //READ
            String query = "select * from manager";
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                System.out.println("Employee Id: " + rs.getString("empl_id") + "| " + "Department ID: " + rs.getString("department_id") + "| " + "Management title: "
                        + rs.getString("title")+ "| " + "Manager ID: " + rs.getString("manager_id")+ "| " + "Last name: " + rs.getString("lname"));
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch(Exception e){

        }
    }
}
