/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package news;

/**
 *
 * @author Owner
 *  *‘******************************************************
‘***  Class Name: StoreItem
‘***  Class Author: Angelica Jones
‘******************************************************
‘*** Purpose of the class (Why did you write this class?)
‘***:This class is used to practice polymorphism. I am 
* learning about the relationships between super and subclasses.
‘******************************************************
 */
public abstract class StoreItem 
{
    //this is a superclass

  
        public void setAskingPrice(int askingPrice) 
        {
            this.askingPrice = askingPrice;
        
        }
    //here are our private variables
        public String title;
        public String dateAcquired;
        public int purchasePrice;
        public int askingPrice;
        protected String author;
        
        //only one variable, it is the counter for the entire storeItem class
        private static int itemCount = 0;
        
              
        //this is a constuctor, creates the instances
        public StoreItem(String title, String author, String dateAcquired, int purchasePrice, int askingPrice)
        {
            this.title = title;
            this.dateAcquired = dateAcquired;
            this.purchasePrice = purchasePrice;
            this.askingPrice = askingPrice;
            this.author = author;
            
            //increase the item count
            itemCount++;
            
        }
        
        /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    public String getAuthor()
    {
        return author;
    }
    /**
     * @return the dateAcquired
     */
    public String getDateAcquired() {
        return dateAcquired;
    }

    /**
     * @return the purchasePrice
     */
    public int getPurchasePrice() {
        return purchasePrice;
    }

    /**
     * @return the askingPrice
     */
    public int getAskingPrice() {
        return askingPrice;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setAuthor(String author)
    {
        this.author = author;
    }

    /**
     * @param dateAcquired the dateAcquired to set
     */
    public void setDateAcquired(String dateAcquired) {
        this.dateAcquired = dateAcquired;
    }

    /**
     * @param purchasePrice the purchasePrice to set
     */
    public void setPurchasePrice(int purchasePrice) 
    {
        this.purchasePrice = purchasePrice;
    }

    /**
     * @param askingPrice the askingPrice to set
     */
    
    public void remove()
    {
        itemCount--;
    }
    
     /*‘******************************************************
‘***  Method Name: printableString
‘***  Method Author:  Angelica
‘******************************************************
‘*** Purpose of the Method: Abstract method
‘*** Method Inputs:None
‘*** List all the method parameters with their expected value ranges: none
‘*** Return value:  
‘*** If this is a function list the return data type and the expected range of 
‘*** values to be returned. 
‘******************************************************
‘*** Date: 10/3/17
‘******************************************************

*/
    public abstract String printableString();
    //the signature of the method, the general idea or abstract, haha, get it? abstract!


    
}
