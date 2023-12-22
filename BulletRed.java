import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BulletRed here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BulletRed extends Actor_Rocket
{
    /**
     * Act - do whatever the BulletRed wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public int hitHeroPlaneCount=0;
    public HeroAirPlane heroAirPlane;
    public BulletRed(int speed,int size)
    {
        super(speed,size);
        resize(size);
    }
    public void resize(int size)
    {
         GreenfootImage image=getImage();
        image.scale(image.getWidth()/size,image.getHeight()/size);
    }
    public void removeBullet()
    {
        if(hitHeroPlaneCount==1 || isAtEdge())
        {
            World world=getWorld();
            world.removeObject(this);
        }
    }
    public void act()
    {
        setLocation(getX(),getY()+speed);
        removeBullet();
    }
}
