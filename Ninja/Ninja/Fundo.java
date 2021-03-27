import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fundo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fundo extends Actor
{
    /**
     * Act - do whatever the Fundo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        movimento();
    }    
    private void movimento(){      
        if(Greenfoot.isKeyDown("a") && getX() < 897 && MyWorld.parou == 0 && MyWorld.arrumaCenario == 1){
            move(4);
        }else
        if(Greenfoot.isKeyDown("d") && getX() > 300 && MyWorld.parou == 0 && MyWorld.arrumaCenario == 1){
            move(-4);
        }else
        if(Greenfoot.isKeyDown("a") && getX() < 897 && MyWorld.parou == 0){
            move(2);
        }else
        if(Greenfoot.isKeyDown("d") && getX() > 300 && MyWorld.parou == 0){
            move(-2);
        }
        
    }
}
