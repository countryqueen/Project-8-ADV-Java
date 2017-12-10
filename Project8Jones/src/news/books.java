/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package news;

/**
 *
 * @author Owner
 */
public class books extends StoreItem
{
     private static int bookCount;
    //here are our private variables
    //private bookCount int Static;
    private String title;
    private String genre;
    
    
    //here is our constructor
   public books(String title, String author, String dateAcquired, int purchasePrice,int askingPrice, String genre)
    {
        //call the storeItem class aka the super class.
        super(title, author, dateAcquired, purchasePrice, askingPrice);
        
        this.genre = genre;
        this.title = title;
        //setting the values in the constructor
        //initial value
    
    }
   
   /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return the genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @param genre the genre to set
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }
    
    //here is our method to remove a book item. This will decrement the bookCount
    public void remove()
    {
        //this calls the super method in the super class 
        super.remove();
        --bookCount;
        
    }
    
         
    /*‘******************************************************
‘***  Method Name: printableString
‘***  Method Author:  Angelica
‘******************************************************
‘*** Purpose of the Method: returns the user's information
‘*** Method Inputs:None
‘*** List all the method parameters with their expected value ranges: none
‘*** Return value: title, dateAcquired, purchasePrice, askingPrice, genre, author, 
‘*** If this is a function list the return data type and the expected range of 
‘*** values to be returned. String, Date, Int
‘******************************************************
‘*** Date: 10/3/17
‘******************************************************

*/
    public String printableString()
    {
        return ("The title is : " + title + "The genre is : " + genre + "The date is : " + dateAcquired + "The purchase price is : " + purchasePrice + "The asking purhase : " + askingPrice + "The author is : " + author);
    }
    
}
