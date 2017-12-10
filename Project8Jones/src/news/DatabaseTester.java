/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package news;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Owner
 */
public class DatabaseTester 
{
    static final String DATABASE_URL = "jdbc:sqlserver://CTASV20r2drw:1433;databaseName= _Advanced_Java;user=TestClass;password=JavaProjectTC;instanceName=mssqlserver2012";
   // static final String DATABASE_URL = "jdbc:sqlserver://CTASV20sql14:1433;databaseName= _Advanced_Java;user=TestClass;password=Pinzgauer11;instanceName=mssqlserver2012";
   
    public static void main(String[] args)
    {
        String mySQL = "SELECT CID, Customer.Name as 'Customer', Address, Sales.Name as 'Rep'  FROM Customer, Sales WHERE Customer.SalesSID = Sales.SID";
        runSQL(mySQL);
        
        String nameLookUp = JOptionPane.showInputDialog("Enter the first part of a Customer name to search for.");
        mySQL = "SELECT CID, Customer.Name as 'Customer', Address, Sales.Name as 'Rep'  FROM Customer, Sales WHERE Customer.SalesSID = Sales.SID AND Customer.Name LIKE '" + nameLookUp+"%'";
        runSQL(mySQL);
        
        nameLookUp = JOptionPane.showInputDialog("Enter the first part of a Rep name to search for.");
        mySQL = "SELECT CID, Customer.Name as 'Customer',  Sales.Name as 'Rep'  FROM Customer, Sales WHERE Customer.SalesSID = Sales.SID AND Sales.Name LIKE '" + nameLookUp+"%'";
        runSQL(mySQL);
    }
    
    public static void runSQL(String mySQL)
    {
         Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //Driver d = (Driver)Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver").newInstance();
            //connection = DriverManager.getConnection(DATABASE_URL,"TestClass","Pinzgauer11");
            connection = DriverManager.getConnection(DATABASE_URL);          
            statement = connection.createStatement();
            
           
            
            resultSet = statement.executeQuery(mySQL);
            ResultSetMetaData metaData = resultSet.getMetaData();
            //metaData.
            int numberOfCol = metaData.getColumnCount();
            System.out.println("Customers");
            for(int i =1; i<=numberOfCol; i++)
            {
                System.out.printf("%-28s\t",metaData.getColumnName(i).toString().trim());
            }
            System.out.println(" ");
            
            while(resultSet.next())
            {
                for(int i =1; i<=numberOfCol; i++)
               {
                     System.out.printf("%-28s\t",resultSet.getObject(i).toString().trim());
                }
                System.out.println("");
            }
        }
        catch(SQLException ex)
        {
            System.out.println("SQL Exception   " + ex.getMessage());
        }
       catch (ClassNotFoundException ex) {
           System.out.println("Class Not Found  "+ ex.getMessage());
       }
//       catch (InstantiationException ex) {
//           //Logger.getLogger(TestDatabaseFall2014.class.getName()).log(Level.SEVERE, null, ex);
//           System.out.println("InstantiationException  "+ ex.getMessage());
//       }
//       catch (IllegalAccessException ex) {
//           //Logger.getLogger(TestDatabaseFall2014.class.getName()).log(Level.SEVERE, null, ex);
//           System.out.println("IllegalAccessException  "+ ex.getMessage());
//       }
        finally
        {
            try
            {
                resultSet.close();
                statement.close();
                connection.close();
            }
            catch(Exception ex)
            {
                System.out.println("Close problems   "+ ex.getMessage());
            }
        }
    }
    
}
