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
public class movies extends StoreItem
{
    private static int movieCount;
    
    //these are the private variables for the movie class
    public String director;
    //Dr. Woodcock said to disable the actors and actresses arrays completely
    public String [] actors;
    public String [] actresses;
    //classmate Emily suggested that I create an array, array object, and an array copy for the actors and actresses for easy access.
    
    //actors and actresses are supposed to be in array
    
    //this a constructor for the movie class
    public movies(String title, String author, String dateAcquired, int askingPrice, int purchasePrice, String director, String[] actorsArray, String[] actressesArray)
    {
        //call the storeItem class aka the super class.
        super(title, author, dateAcquired, purchasePrice, askingPrice);
        movieCount++;
       
        this.director = director;
        this.actors = new String[actorsArray.length];
        this.actresses = new String[actressesArray.length];
        
        System.arraycopy(actors,0 , this.actors, 0, actors.length);
   
        System.arraycopy(actresses, 0, this.actresses, 0, actresses.length);
    }
    //this is a method that will remove items from the movie class
      public String getTitle() {
        return title;
    }

    /**
     * @return the director
     */
    public String getDirector() {
        return director;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    
    public void setDirecctor(String director) {
        this.director = director;
    }

/*‘******************************************************
‘***  Method Name: Remove
‘***  Method Author:  Angelica
‘******************************************************
‘*** Purpose of the Method (Why did you write this Method?)
‘*** Method Inputs:None
‘*** List all the method parameters with their expected value ranges: none
‘*** Return value: no return
‘*** If this is a function list the return data type and the expected range of 
‘*** values to be returned.
‘******************************************************
‘*** Date: 10/3/17
‘******************************************************

*/
    public void remove()
       {
           //super is an obect of the superclass StoreItem. It is calling the remove method in the super class
           super.remove();
           --movieCount;
           //decrements the number of movies by 1.
       }
    
          
    /*‘******************************************************
‘***  Method Name: printableString
‘***  Method Author:  Angelica
‘******************************************************
‘*** Purpose of the Method: returns the user's information
‘*** Method Inputs:None
‘*** List all the method parameters with their expected value ranges: none
‘*** Return value: title, dateAcquired, purchasePrice, askingPrice, director
‘*** If this is a function list the return data type and the expected range of 
‘*** values to be returned. String, Date, Int
‘******************************************************
‘*** Date: 10/3/17
‘******************************************************

*/

    public String printableString()
    {
        
        return ("The title is : " + title + "\nThe date is : " + dateAcquired + "\nThe purchase price is : " + purchasePrice + "\nThe asking purhase : " + askingPrice + 
                "\nThe director is : " + director + " Actors: " + actors.toString() + " Actresses : " + actresses.toString());
        
    }
    
}
