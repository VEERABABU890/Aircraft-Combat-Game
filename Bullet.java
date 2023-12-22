import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor_Rocket
{
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public int hitPlaneCount=0;
    public Bullet(int speed,int size)
    {
        super(speed,size);
        resize(size);
    }
    public void resize(int size)
    {
         GreenfootImage image=getImage();
        image.scale(image.getWidth()/size,image.getHeight()/size);
    }
    public void move(int distance)
    {
        setLocation(getX(),getY()-distance);
    }
     public void act()
    {
        // Add your action code here.
        move(speed);
        removeBullet();
    }
    public void removeBullet()
    {
        if(hitPlaneCount==1 || isAtEdge())
        {
            World world=getWorld();
            world.removeObject(this);
        }
    }
}
