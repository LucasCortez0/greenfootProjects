import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tutorial here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tutorial extends Actor
{
    /**
     * Act - do whatever the Tutorial wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.isKeyDown("enter")){
            
            getWorld().removeObject(this);
            
        }
        
        if(MyWorld.fase == 1){
            setImage("tutorial1.png");
        }
        if(MyWorld.fase == 2){
            setImage("tutorial2.png");
        }
    }    
}
