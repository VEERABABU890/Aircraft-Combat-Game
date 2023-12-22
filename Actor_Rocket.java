import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Actor_Rocket here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Actor_Rocket extends Actor
{
    /**
     * Act - do whatever the Actor_Rocket wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    protected int speed;
    protected int size;
    public Actor_Rocket(int speed, int size)
    {
        this.speed=speed;
        this.size=size;
    }
    
}
