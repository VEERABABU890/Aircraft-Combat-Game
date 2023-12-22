import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Home here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Home extends World
{

    /**
     * Constructor for objects of class Home.
     * 
     */
    private int count=0;
    public Home()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        backgroundImage();
    }
    public void backgroundImage()
    {
        GreenfootImage backGroundImageSize=getBackground();
        backGroundImageSize.scale(900,1700);
    }
    public void act()
    {
        count++;
        if (count==200)
        {
            Greenfoot.setWorld(new Space());
        }
    }
}
