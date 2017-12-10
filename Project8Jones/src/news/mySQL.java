/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package news;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Owner
 * *‘******************************************************
‘***  Class Name: mySQL
‘***  Class Author: Angelica Jones
‘******************************************************
‘*** Purpose of the class (Why did you write this class?)
‘***:I am learning how to create a database using mysql
‘******************************************************
 */
 
public class mySQL 
{
    static final String DATABASE_URL = "jdbc:sqlserver://CTASV20R2DRW.tamuct.edu;databaseName=country_queen;user=jones;password=angelica123*";
    
    /*
    Method Name: delSQL()
    Purpose: Deletes objects from database
    Parameter: none
    Method Input: none
    Return Value:none
    Date: 12/7/2017
    */ 
    public void DelSQL()
    {
        System.out.println("I am running");
        
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         
            connection = DriverManager.getConnection(DATABASE_URL);  
            
            
            
            statement = (Statement)connection.createStatement();
            
            String deleteAllB = "DELETE FROM INVENTORY.db_owner.TableBook";
            statement.execute(deleteAllB);
            
            String deleteAllM = "DELETE FROM INVENTORY.db_owner.TableMovie";
            statement.execute(deleteAllM);
            
            String deleteAllP = "DELETE FROM INVENTORY.db_owner.TablePainting";
            statement.execute(deleteAllP);
        }
        catch(SQLException ex)
        {
            System.out.println("SQL Exception   " + ex.getMessage());
        }
       catch (ClassNotFoundException ex) {
           System.out.println("Class Not Found  "+ ex.getMessage());
       }

        finally
        {
            try
            {
                connection.close(); 
                //System.out.println("Successful Deletion");
            }
            catch(Exception ex)
            {
                System.out.println("Close;");
            }
        }        
    }
 
    /*
    Method Name: writeSQL
    Purpose: write storeitem object to database
    Parameter: StoreItem
    Method Input: StoreItem object
    Return Value: none void method
    Date: 12/10/2017
    */     
    public void writeSQL(StoreItem obj)
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
            
            System.out.println("I am connected and Ready to Write");
            
            statement = (Statement)connection.createStatement();
                  
            String insert;
            
            switch (obj.getClass().getSimpleName()) //name  of the Obj Class will be received and compared to store the Obj in the right LinkedList
            {     
                case "Book":
                    
                    books objBook = (books)obj;
                    
                    String BTitle = "'" + objBook.getTitle() + "'";
                    String BAuthor = "'" + objBook.getAuthor() + "'";
                    String BDateAcquired = "'" + objBook.getDateAcquired().toString() + "'";   
                    int BPurchasePrice = objBook.getPurchasePrice();
                    int BAskingPrice = objBook.getAskingPrice();
                    String BGenre = "'" + objBook.getGenre() + "'";
                    
                    //INVENTORY IS MY DATABASE; TABLEBOOK IS MY TABLE; THE NAMES IN THE PARANTHESIS ARE THE NAME OF MY COLUMNS;
                    insert = "INSERT INTO INVENTORY.db_owner.TableBook(Title,Author,DateAcquired,PurchasePrice,AskingPrice,Genre) "
                            + "VALUES(" + BTitle + "," + BAuthor + "," + BDateAcquired + "," +BPurchasePrice + "," + BAskingPrice + "," + BGenre + ");";
                    
                    statement.executeUpdate(insert);
            
                    System.out.println("Book Sucessful");
                    break;
                    
                case "Movie":
                    
                    movies objMovie = (movies)obj;
                    
                    String MTitle = "'" + objMovie.getTitle() + "'";
                    String MAuthor = "'" + objMovie.getAuthor() + "'";
                    String MDateAcquired = "'" + objMovie.getDateAcquired().toString() + "'";   
                    int MPurchasePrice = objMovie.getPurchasePrice();
                    int MAskingPrice = objMovie.getAskingPrice();
                    String MDirector = "'" + objMovie.getDirector() + "'";
                    String MActor = "'" + arrToStr(objMovie.getActors()) + "'";
                    String MActress = "'" + arrToStr(objMovie.getActresses()) + "'";
                    
                    //INVENTORY IS MY DATABASE; TABLEBOOK IS MY TABLE; THE NAMES IN THE PARANTHESIS ARE THE NAME OF MY COLUMNS;
                    insert = "INSERT INTO INVENTORY.db_owner.TableMovie(Title,Author,DateAcquired,PurchasePrice,AskingPrice,Director,Actor,Actress) "
                            + "VALUES(" + MTitle + "," + MAuthor + "," + MDateAcquired + "," +MPurchasePrice + "," + MAskingPrice + "," + MDirector + "," + MActor + "," + MActress + ");";
                    
                    statement.executeUpdate(insert);
            
                    System.out.println("Movie Sucessful");                   

                    break;
                case "Painting":
                    
                    paintings objPainting = (paintings)obj;
                    
                    String PTitle = "'" + objPainting.getTitle() + "'";
                    String PAuthor = "'" + objPainting.getAuthor() + "'";
                    String PDateAcquired = "'" + objPainting.getDateAcquired().toString() + "'";   
                    int PPurchasePrice = objPainting.getPurchasePrice();
                    int PAskingPrice = objPainting.getAskingPrice();
                    int PHeight = objPainting.getHeight();
                    int PWidth = objPainting.getWidth();
                    String PMedia = "'" + objPainting.getMedia() + "'";
                    
                    //INVENTORY IS MY DATABASE; TABLEBOOK IS MY TABLE; THE NAMES IN THE PARANTHESIS ARE THE NAME OF MY COLUMNS;
                    insert = "INSERT INTO INVENTORY.db_owner.TablePainting(Title,Author,DateAcquired,PurchasePrice,AskingPrice,Height,Width,Media) "
                            + "VALUES(" + PTitle + "," + PAuthor + "," + PDateAcquired + "," +PPurchasePrice + "," + PAskingPrice + "," + PHeight + "," +PWidth + "," + PMedia +");";
                    
                    statement.executeUpdate(insert);
            
                    System.out.println("Painting Sucessful");
                    break;                    
                default:  
            }     
        }
        catch(SQLException ex)
        {
            System.out.println("SQL Exception   " + ex.getMessage());
        }
       catch (ClassNotFoundException ex) {
           System.out.println("Class Not Found  "+ ex.getMessage());
       }

        finally
        {
            try
            {

                connection.close();
                
                System.out.println("Successful Run");
            }
            catch(Exception ex)
            {
                System.out.println("Close;");
            }
        }
    }
    
    /*
    Method Name: loadSQL()
    Purpose: loads database objects to the program
    Parameter: none
    Method Input: arrToStr()
    Return Value: ArrayList
    Date: 12/7/2017
    */ 
    public ArrayList loadSQL()
    {   
        ArrayList<StoreItem> arrStore = new ArrayList();

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        ResultSetMetaData metaData = null;
        int numberOfColumns;
        StoreItem obj;
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(DATABASE_URL);  
            
            System.out.println("I am connected and ready to Load Data");
            statement = (Statement)connection.createStatement();
                  
            String LOADQUERY;
            
            
            ///////////////////////////////////////////////////////// ADD BOOK
            
            LOADQUERY = "SELECT Title,Author,DateAcquired,PurchasePrice,AskingPrice,Genre FROM INVENTORY.db_owner.TableBook";
            resultSet = statement.executeQuery(LOADQUERY);
            metaData = resultSet.getMetaData();
            numberOfColumns = metaData.getColumnCount();
            
            
            while(resultSet.next())
            {
                String BTitle = null;
                String BAuthor = null;
                String BDateAcq = null;
      
                int BPurchasePrice = 0;
                int BAskPrice = 0;
                
                books bObj = null;
                
                String BGenre = null;

                for(int i =1; i <= numberOfColumns ; i++)
                {
                    switch(i)
                    {
                        case 1: BTitle = resultSet.getObject(i).toString().trim();break;
                        case 2: BAuthor = resultSet.getObject(i).toString().trim(); break;
                        case 3: BDateAcq = resultSet.getObject(i).toString().trim();break;
                        case 4: BPurchasePrice = Integer.parseInt(resultSet.getObject(i).toString().trim());break;
                        case 5: BAskPrice = Integer.parseInt(resultSet.getObject(i).toString().trim()); break;
                        case 6: BGenre = resultSet.getObject(i).toString().trim();break;
                    }
                    
                    
     
                }
                bObj = new books(BTitle,BAuthor,BDateAcq,BPurchasePrice,BAskPrice,BGenre);
                arrStore.add(bObj);
                
            }
            /////////////////////////////////////////////////////////// ADD MOVIE            
            
            LOADQUERY = "SELECT Title,Author,DateAcquired,PurchasePrice,AskingPrice,Director,Actor,Actress FROM INVENTORY.db_owner.TableMovie";
            resultSet = statement.executeQuery(LOADQUERY);
            metaData = resultSet.getMetaData();
            numberOfColumns = metaData.getColumnCount();
            
            while(resultSet.next())
            {
                String MTitle = null;
                String MAuthor = null;
                String MDateAcq = null;
                int MPurchasePrice = 0;
                int MAskPrice = 0;
                
                movies MObj = null;
                
                String MDirector = null;
                String MActor = null;
                String MActress = null;

                for(int i = 1; i <= numberOfColumns ; i++)
                {
                    
                    switch(i)
                    {
                        case 1: MTitle = resultSet.getObject(i).toString().trim();break;
                        case 2: MAuthor = resultSet.getObject(i).toString().trim(); break;
                        case 3: MDateAcq = resultSet.getObject(i).toString().trim();break;
                        case 4: MPurchasePrice = Integer.parseInt(resultSet.getObject(i).toString().trim());break;
                        case 5: MAskPrice = Integer.parseInt(resultSet.getObject(i).toString().trim()); break;
                        case 6: MDirector = resultSet.getObject(i).toString().trim();break;
                        case 7: MActor =  resultSet.getObject(i).toString().trim(); break;
                        case 8: MActress = resultSet.getObject(i).toString().trim(); break;
                    }
                    
                }
                MObj = new movies(MTitle,MAuthor,MDateAcq,MPurchasePrice,MAskPrice,MDirector,strToArr(MActor),strToArr(MActress));
                
                arrStore.add(MObj);
                
                }           
            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// ADD Painting           
            
            LOADQUERY = "SELECT Title,Author,DateAcquired,PurchasePrice,AskingPrice,Height,Width,Media FROM INVENTORY.db_owner.TablePainting";
            resultSet = statement.executeQuery(LOADQUERY);
            metaData = resultSet.getMetaData();
            numberOfColumns = metaData.getColumnCount();
            
            
            while(resultSet.next())
            {
                String PTitle = null;
                String PAuthor = null;
                String PDateAcq = null;
                int PPurchasePrice = 0;
                int PAskPrice = 0;
                
                paintings MObj = null;
                
                int PHeight = 0;
                int PWidth = 0;
                String PMedia = null;

                for(int i =1; i <= numberOfColumns ; i++)
                {
                    switch(i)
                    {
                        case 1: PTitle = resultSet.getObject(i).toString().trim();break;
                        case 2: PAuthor = resultSet.getObject(i).toString().trim(); break;
                        case 3: PDateAcq = resultSet.getObject(i).toString().trim();break;
                        case 4: PPurchasePrice = Integer.parseInt(resultSet.getObject(i).toString().trim());break;
                        case 5: PAskPrice = Integer.parseInt(resultSet.getObject(i).toString().trim()); break;
                        case 6: PHeight = Integer.parseInt(resultSet.getObject(i).toString().trim());break;
                        case 7: PWidth =  Integer.parseInt(resultSet.getObject(i).toString().trim());break;
                        case 8: PMedia = resultSet.getObject(i).toString().trim();break;
                    }
                   
                }
                MObj = new paintings(PTitle,PAuthor,PDateAcq,PPurchasePrice,PAskPrice,PHeight,PWidth,PMedia);
                arrStore.add(MObj);
                
            }             
        }
        catch(SQLException ex)
        {
            System.out.println("SQL Exception   " + ex.getMessage());
        }
       catch (ClassNotFoundException ex) {
           System.out.println("Class Not Found  "+ ex.getMessage());
       }

        finally
        {
            try
            {

                connection.close();
                
                System.out.println("Successful LOAD");
            }
            catch(Exception ex)
            {
                System.out.println("Close;");
            }
        }
        
        return arrStore;
    }
 
 
    /*
    Method Name: arrToStr()
    Purpose: concatenates an String[] to String
    Parameter: String[]
    Method Input: none
    Return Value: String
    Date: 12/7/2017
    */    
    private String arrToStr(String[] arr)
    {
        String str = "";
        
        for(int i = 0; i < arr.length;i++)
        {
            str += arr[i] + ",";
        }
        
        return str;

    }
  
    /*
    Method Name: strToArr
    Purpose: turns a string to a String[] array
    Parameter: String
    Method Input: none
    Return Value:String[] array
    Date: 12/7/2017
    */ 
    private String[] strToArr(String compound)
    {
              
        String temp = "";
        
        ArrayList<String> arr = new ArrayList();

        for(int i = 0; i < compound.length(); i++)
        {
            
            if(!Character.toString(compound.charAt(i)).equals(","))
            {
                temp += Character.toString(compound.charAt(i));
            }
            
            if(Character.toString(compound.charAt(i)).equals(",") || (i + 1 == compound.length()))
            {
                arr.add(temp);
                temp = "";
            }
        }
        
        String[] actArr =  new String[arr.size()];
        
        for(int i = 0; i < arr.size(); i++)
        {
            actArr[i] = arr.get(i);

        }
        return actArr;
    }
    
}
