import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestEmployee {
    private static String url = "jdbc:mysql:///hris";
    private static String user = "root";
    private static String pw = "Password1";
    //Crud test cases
    @Test
    void saveEmployee() {
        Employee emp = new Employee();
        assertTrue(emp.saveEmployee("Tyler","Henry","100-asdok","ashoka","ga",21054,"usa","012993","01-90-1029","manager",1,1) == true);

    }
    @Test
    void deleteEmployee() {
        Employee emp = new Employee();
        assertTrue(emp.deleteEmployee(7));
    }

    @Test
    void updateEmployee() {
        Employee emp = new Employee();
        assertTrue(emp.updateEmployee("Tyler","Henry","100-asdok","ashoka","ga",21054,"usa","012993","01-90-1029","manager",7,1,1) == true);
    }

    @Test
    void showOneEmployee() {
        Employee emp = new Employee();
        assertTrue(emp.showOneEmployee(7) == true);
    }

    @Test
    void showEmployees() {
        Employee emp = new Employee();
        assertTrue(emp.showEmployees() == true);
    }
    //Integration Test
    @Test
    void connectionTest(){
        try {

            Connection con = DriverManager.getConnection(url,user,pw);
            if(con != null){
                System.out.println("Integration test successful!");

            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch(Exception e){

        }
    }
}
