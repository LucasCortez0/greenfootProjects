import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sobreviva here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sobreviva extends Actor
{
    int contagem = 0;
    /**
     * Act - do whatever the Sobreviva wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        contagem ++;
        if(contagem == 150){
        getWorld().removeObject(this);
        }
    }    
}
