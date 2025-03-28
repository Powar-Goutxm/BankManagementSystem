package bank.management.system;

import java.sql.*;

public class connection {
    Connection conn;
    Statement statement;
    String url = "jdbc:mysql://localhost:3306/BankManagementSystem";
    String user = "root";
    String password = "Ecomp@2025";
    
    public connection(){
       try{
        conn = DriverManager.getConnection(url, user, password);
        if(conn != null){
        System.out.println("Database Connection Established Succesfully");
        
            }else{
        System.out.println("Failed to Establish a Connection");
        }
              statement = conn.createStatement();
       }catch(Exception e){
                System.out.println(e);
           }
       }
}

