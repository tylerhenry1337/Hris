import java.sql.*;

public class HealthBenefits {
    private static String url=  "jdbc:mysql:///hris";
    private static String user = "root";
    private static String pw = "Password1";

    public static void displayHealthBenefitsMenu(){
        System.out.println("Please select which function you'd like to perform  " +
                "\n1. Create new employee health benefits. \n2. Update existing employee health benefits. \n3. Delete employee health benefits information. \n4. Show one employee health benefits information. \n5. Show all employee health benefits information." );
    }
    static void saveHealthBenefits(int empId,String plat, String gold, String silver, String bronze){
        try {
            Connection con = DriverManager.getConnection(url,user,pw);
            Statement st = con.createStatement();
            //CREATE
            boolean inserted = st.execute("insert into health_plans(plan_platinum,plan_gold,plan_silver,plan_bronze,empl_id" + ") VALUES('"+plat+"','"+gold+"','"+silver+"','"+bronze+"','"+empId+"')");
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch(Exception e){

        }

    }

    static void deleteHealthBenefits(int id){
        try {
            Connection con = DriverManager.getConnection(url,user,pw);
            Statement st = con.createStatement();
            //DELETE
            boolean delete = st.execute("DELETE FROM health_plan\n" +
                    "WHERE plan_id =  '"+id+"'");
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch(Exception e){

        }
    }
    static void updateHealthBenefits(int empId,int planId,String plat, String gold, String silver, String bronze){
        try {
            Connection con = DriverManager.getConnection(url,user,pw);
            Statement st = con.createStatement();
            //UPDATE
            boolean update = st.execute("UPDATE health_plans\n" +
                    "SET\n" +
                    "plan_platinum = '"+plat+"',\n" +
                    "plan_gold = '"+gold+"',\n" +
                    "plan_silver = '"+silver+"',\n" +
                    "plan_bronze = '"+bronze+"',\n" +
                    "empl_id = '"+empId+"'\n" +
                    "WHERE plan_id = '"+planId+"'");
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch(Exception e){

        }
    }
    static void showOneHealthBenefits(int id){
        try {
            Connection con = DriverManager.getConnection(url,user,pw);
            Statement st = con.createStatement();
            //READ
            String query = "select * from health_plans where empl_id = '"+id+"'";
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                System.out.println("Employee Id: " + rs.getString("empl_id") + "\n " + "Platinum health insurance package: " + rs.getString("plan_platinum") + "\n " + "Gold health insurance package: "
                        + rs.getString("plan_gold")+ "\n " + "Silver health insurance package: " + rs.getString("plan_silver")+ "\n "+ "Bronze health insurance package: " + rs.getString("plan_bronze"));
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch(Exception e){

        }

    }
    static void showHealthBenefits(){
        try {
            Connection con = DriverManager.getConnection(url,user,pw);
            Statement st = con.createStatement();
            //READ
            String query = "select * from health_plans";
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                System.out.println("Employee Id: " + rs.getString("empl_id") + "| " + "Platinum health insurance package: " + rs.getString("plan_platinum") + "| " + "Gold health insurance package: "
                        + rs.getString("plan_gold")+ "| " + "Silver health insurance package: " + rs.getString("plan_silver")+ "| "+ "Bronze health insurance package: " + rs.getString("plan_bronze"));
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch(Exception e){

        }
    }

}
