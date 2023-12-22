import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Next1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Next1 extends World
{

    /**
     * Constructor for objects of class Next1.
     * 
     */
    public Next1()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(500, 800, 1); 
        showText("GAME OVER",250,400);
        showText("Your Score:"+(Next.score2),250,450);

    }
}
