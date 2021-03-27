import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cenario2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cenario2 extends World
{

    /**
     * Constructor for objects of class Cenario2.
     * 
     */
    public Cenario2()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 600, 1, false); 
        adicionarLuk();
        addObject(new Tutorial(), 600, 220);
        
    }
    private void adicionarLuk(){
        if(MyWorld.fase == 3){
            addObject(new Fundo(),329, 300);
            addObject(new chao3(), -173, 525);
            addObject(new chao1(), 1092, 525); 
            addObject(new Luk(), 1144, 407);
            
            //plataformas
            addObject(new Piso(), 169, 401);
            addObject(new Piso(), 433, 364);
            addObject(new Piso(), 687, 464);
            addObject(new Piso(), 896, 327);
            
            MyWorld.fase = 2;
        }else
        {
            addObject(new Fundo(),867, 300);
            addObject(new chao3(), 110, 525); 
            addObject(new chao1(), 1375, 525);            
            addObject(new Luk(), 66, 407);
            
            //plataformas
            addObject(new Piso(), 384, 401);
            addObject(new Piso(), 648, 364);
            addObject(new Piso(), 902, 464);
            addObject(new Piso(), 1111, 327);
            MyWorld.fase = 2;  
        }
    }
}
