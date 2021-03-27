import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class chao2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class chao2 extends Actor
{
    /**
     * Act - do whatever the chao2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.isKeyDown("a") && MyWorld.parou == 0 && MyWorld.arrumaCenario == 1){
            move(2);
        }else
        if(Greenfoot.isKeyDown("d") && MyWorld.parou == 0 && MyWorld.arrumaCenario == 1){
            move(-2);
        }else
        if(Greenfoot.isKeyDown("a") && MyWorld.parou == 0){
            move(1);
        }else
        if(Greenfoot.isKeyDown("d") && MyWorld.parou == 0){
            move(-1);
        }
    }    
}
