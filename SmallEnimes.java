import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SmallEnimes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SmallEnimes extends Actor_Rocket
{
    /**
     * Act - do whatever the SmallEnimes wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private final int firingTime=150;
    private int delayTime=0;
    private int size;
    private String color="RED";
    private int speed1;
    public BulletRed bulletRed;
    public SmallEnimes(int speed,int size)
    {
        super(speed,size);
         resize(size);
    }
    public SmallEnimes(int speed,int size,String color)
    {
        super(speed,size);
        setImage("EnimesGreen.png");
        this.color=color;
        resize(size);
        
    }
    public void resize(int size)
    {
        GreenfootImage image=getImage();
        image.scale(image.getWidth()/size,image.getHeight()/size);
    }
    public void bounceVertically()
    {
        setLocation(getX(),getY()+speed);
        if(getY()>=400)
        {
            speed=-(Greenfoot.getRandomNumber(4))+1;
        }
        if(getY()<=70)
        {
            speed=(Greenfoot.getRandomNumber(2))+1;
        }
    }
    public void bounceHorizontally()
    {
        move(speed);
        if(getX()==0)
        {
            speed=(Greenfoot.getRandomNumber(3))+1;
        }
        if(getX()==499)
        {
            speed=-(Greenfoot.getRandomNumber(3))+1;
        }
    }
    public void checkCollision()
    {
        Bullet bullet=(Bullet)getOneIntersectingObject(Bullet.class);
        if(bullet!=null)
        {
            World world=getWorld();
            world.removeObject(this);
            bullet.hitPlaneCount++;
            HeroAirPlane.score++;
        }
    }
   public void releaseBullet(String color)
    {
    
        if(delayTime>=2*firingTime && color.equals("GREEN"))
        {
            World world=getWorld();
            bulletRed=new BulletRed(7,7);
            world.addObject(bulletRed,getX(),getY());
            delayTime=0;
        }
        if(delayTime>=3*firingTime && color.equals("RED"))
        {
            World world=getWorld();
            bulletRed=new BulletRed(7,7);
            world.addObject(bulletRed,getX(),getY());
            delayTime=0;
        }
        
        
    }
    public void act()
    {
        // Add your action code here.
        if(color.equals("RED"))
        {
            bounceVertically();
        }
        if(color.equals("GREEN"))
        {
            bounceHorizontally();
        }
        delayTime++;
        checkCollision();
        releaseBullet(color);
    }
}
