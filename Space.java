import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Space here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Space extends World
{

    /**
     * Constructor for objects of class Space.
     * 
     */
    public HeroAirPlane heroAirPlane;
    public SmallEnimes smallEnemy;
    public BigEnemy bigEnemy;
    public int smallDistance=1;
    public Space()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(500,800, 1); 
        addHeroAirPlane();
        for (int i=1;i<=20;i++)
        {
            if(i<=12)
            {
                addSmallEnemy("RED");
            }
            else
            {
                addSmallEnemy("GREEN");
            }
        }
        addBigEnemy();
        backgroundImage();
    }
    public void addHeroAirPlane()
    {
        heroAirPlane=new HeroAirPlane(4,2);
        addObject(heroAirPlane,245,770);
    }
    public void addSmallEnemy(String color)
    {
        
        while(true)
        {
            
            int y=Greenfoot.getRandomNumber(100);
            int x=Greenfoot.getRandomNumber(490);
            if(y>=50 && x<=480 && x>=20 && color.equals("RED"))
            {
                smallEnemy=new SmallEnimes((Greenfoot.getRandomNumber(3))+1,4);
                addObject(smallEnemy,x+smallDistance,y);
                smallDistance=+10;
                break;
            }
            if(y>=40 && x<=480 && x>=20 && color.equals("GREEN"))
            {
                smallEnemy=new SmallEnimes((Greenfoot.getRandomNumber(4))+1,4,"GREEN");
                addObject(smallEnemy,x+smallDistance,y);
                smallDistance=+10;
                break;
            }
        }
        
    }
    public void addBigEnemy()
    {
        bigEnemy=new BigEnemy(1,3);
        addObject(bigEnemy,250,30);
    }
    public void displayScore()
    {
        showText("Score:"+(HeroAirPlane.score),450,760);
    }
    public void nextLevel()
    {
        if(HeroAirPlane.score==40)
        {
            heroAirPlane.setLocation(heroAirPlane.getX(),heroAirPlane.getY()-4);
            HeroAirPlane.heroHealth=150;
            showText("NEXT LEVEL",250,400);
            if(heroAirPlane.isAtEdge())
            {
                removeObject(heroAirPlane);
                Greenfoot.setWorld(new Next());
                HeroAirPlane.score1=HeroAirPlane.score+HeroAirPlane.score1;
                HeroAirPlane.score=0;
            }
            
        }
    }
    public void backgroundImage()
    {
        GreenfootImage backGroundImageSize=getBackground();
        backGroundImageSize.scale(1000,3000);
    }
    public void act()
    {
        displayScore();
        nextLevel();
    }
    
}
