import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HeroAirPlane here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HeroAirPlane extends Actor_Rocket
{
    /**
     * Act - do whatever the HeroAirPlane wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public static int score=0;
    public static int score1=0;
    public Bullet bullet;
    private int size;
    public static int heroHealth=150;
    private final int firingTime=25;
    private int delayTime=0;
    public HeroAirPlane(int speed,int size)
    {
        super(speed,size);
        resize(size);
    }
    public void move(int distance)
    {
        if(Greenfoot.isKeyDown("right"))
        {
            if(getX()<=460)
            {
                super.move(distance);
            }
        }
        else if(Greenfoot.isKeyDown("left"))
        {
            if(getX()>=30)
            {
                super.move(-distance);
            }
        }
        if(Greenfoot.isKeyDown("up"))
        {
            setLocation(getX(),getY()-distance);
        }
        else if(Greenfoot.isKeyDown("down"))
        {
            setLocation(getX(),getY()+distance);
        }
    }
    public void resize(int size)
    {
        GreenfootImage image=getImage();
        image.scale(image.getWidth()/size,image.getHeight()/size);
    }
    public void checkCollision()
    {
        BulletRed bulletRed=(BulletRed)getOneIntersectingObject(BulletRed.class);
        if(bulletRed!=null)
        {
            if(heroHealth<=0)
            {   World world=getWorld();
                world.removeObject(this);
                world.showText("GAME OVER",250,400);
                heroHealth=150;
            }
            bulletRed.hitHeroPlaneCount++;
            heroHealth-=4;
        }
    }
    public void releaseBullet()
    {
        if(delayTime>=firingTime)
        {
            World world=getWorld();
            bullet=new Bullet(7,4);
            world.addObject(bullet,getX(),getY()-25);
            delayTime=0;
        }
        
    }
    public void fire()
    {
        if(Greenfoot.isKeyDown("space"))
        {
            releaseBullet();
        }
    }
    public void act()
    {
        // Add your action code here.
        move(speed);
        fire();
        delayTime++;
        checkCollision();
    }
}
