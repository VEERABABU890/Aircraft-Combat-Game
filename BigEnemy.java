import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BigEnemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BigEnemy extends Actor_Rocket
{
    /**
     * Act - do whatever the BigEnemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private final int firingTime=150;
    private int delayTime=0;
    private int bigEnemyHealth=200;
    public BulletRed bulletRed;
    public BigEnemy(int speed,int size)
    {
        super(speed,size);
        resize(size);
    }
    public void resize(int size)
    {
        GreenfootImage image=getImage();
        image.scale(image.getWidth()/size,image.getHeight()/size);
    }
     public void releaseBullet()
    {
    
        if(delayTime>=3*firingTime)
        {
            World world=getWorld();
            bulletRed=new BulletRed(7,4);
            world.addObject(bulletRed,getX(),getY());
            delayTime=0;
        }
        
        
    }
    public void moveforward()
    {
        move(speed);
        if(getX()>=400)
        {
           speed=-1; 
        }
        if(getX()<=100)
        {
            speed=1;
        }
    }
    public void checkCollision()
    {
        Bullet bullet=(Bullet)getOneIntersectingObject(Bullet.class);
        if(bullet!=null)
        {
            bullet.hitPlaneCount++;
            if(bigEnemyHealth%10==0)
            {
                HeroAirPlane.score++;
            }
            bigEnemyHealth-=10;
            if(bigEnemyHealth==0 )
            {   
                World world=getWorld();
                world.removeObject(this);
                
            }
            
        }
    }
    public void act()
    {
        // Add your action code here.
        delayTime++;
        releaseBullet();
        checkCollision();
        moveforward();
    }
}
