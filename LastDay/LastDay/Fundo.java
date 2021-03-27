import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Teste here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fundo extends Actor
{
    int contador = 0;
    /**
     * Act - do whatever the Teste wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
        if(getX() == 0){
            contador = 1;
        }else if(getX() == 599){
            contador = 2;
        }
        
        if(contador == 1){
            move(1);
        }else{
            move(-1);
        }
        
    }    
}
