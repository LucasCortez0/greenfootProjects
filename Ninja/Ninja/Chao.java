import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class chao here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Chao extends Actor
{
    /**
     * Act - do whatever the chao wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        movimento();
    }       
    private void movimento(){
        if(Greenfoot.isKeyDown("a") && getX() < 750 && MyWorld.arrumaCenario == 1){
            move(2);
        }else
        if(Greenfoot.isKeyDown("d") && getX() > 450 && MyWorld.arrumaCenario == 1){
            move(-2);
        }else
        if(Greenfoot.isKeyDown("a") && getX() < 750){
            move(1);
        }else
        if(Greenfoot.isKeyDown("d") && getX() > 450){
            move(-1);
        }
    }
}
