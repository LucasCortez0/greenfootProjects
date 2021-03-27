import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cenario3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cenario3 extends World
{

    /**
     * Constructor for objects of class Cenario3.
     * 
     */
    public Cenario3()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 600, 1, false); 
        adicionarLuk();
        MyWorld.fase = 3;
    }
    private void adicionarLuk(){
        addObject(new Fundo(),867, 300);
        addObject(new Luk(), 66, 407);
        addObject(new chao3(), 108, 525);
        addObject(new chao2(), 734, 525);
        addObject(new chao1(), 1359, 525);
     
    }
}
