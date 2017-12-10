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
public class paintings extends StoreItem
{
     public static int paintingCount;
    //this variable is only visible to the painting class.
    
    //here are our private variables
    public int height;
    public int width;
    public String media;
   
   
    //this is a constructor
    public paintings(String title, String author, String dateAcquired, int purchasePrice, int askingPrice, int width, int height, String media)
    {
        //call the storeItem class aka the super class.
        super(title, author, dateAcquired, purchasePrice, askingPrice);
        
        paintingCount++;
        
        this.height = height;
        this.media = media;
        this.width = width;
      
        //object "this" sets the object and plugs in their name
        //refers to this object of this class        
    }
    
    public void setTitle()
    {
        this.title = getTitle();
        //you can add a person by incrementing it. you can delete a person by decrementing the personCount
    }
    
    //this is a getter
    public String getTitle()
    {
        return title;
    }

    public void setHeight()
    {
        this.height = getHeight();
        //you can add a person by incrementing it. you can delete a person by decrementing the personCount
    }
    
    //this is a getter
    public int getHeight()
    {
        return height;
    }
    public void setWidth()
    {
        this.width = getWidth();
    }
    
    public int getWidth()
    {
        return width;
    }
    
    public void setMedia()
    {
        this.setMedia(getMedia());
        //you can add a person by incrementing it. you can delete a person by decrementing the personCount
    }
   
    /**
     * @return the media
     */
    public String getMedia() {
        return media;
    }

    /**
     * @param media the media to set
     */
    public void setMedia(String media) {
        this.media = media;
    }

    /**
     * @return the dateAcquired
     */
    public String getDateAcquired() {
        return dateAcquired;
    }
      public void remove()
    {
        //super is an obect of the superclass StoreItem. It is calling the remove method in the super class

        super.remove();
        --paintingCount;
    }
    /*‘******************************************************
‘***  Method Name: printableString
‘***  Method Author:  Angelica
‘******************************************************
‘*** Purpose of the Method: returns the user's information
‘*** Method Inputs:None
‘*** List all the method parameters with their expected value ranges: none
‘*** Return value: title, dateAcquired, purchasePrice, askingPrice, media, height, width
‘*** If this is a function list the return data type and the expected range of 
‘*** values to be returned. String, Date, Int
‘******************************************************
‘*** Date: 10/3/17
‘******************************************************

*/
      //returns the user's information
    public String printableString()
    {
        return ("The title is : " + title + "The date is : " + dateAcquired + "The purchase price is : " + purchasePrice + "The asking purhase : " + askingPrice + "The media is : " + media + "The width is : " + width + "The height is : " + height);
        
    }
    
}
