import greenfoot.*; 
import java.util.List; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Recarga here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Recarga extends Actor
{
    int contaremover = 0;
    /**
     * Act - do whatever the Recarga wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        List<Luk> luk = getIntersectingObjects(Luk.class);
        if(luk.size() > 0){
            getWorld().removeObject(this);
        }
        contaremover++;
        if(contaremover == 500){
        getWorld().removeObject(this);    
        }
    }    
}
