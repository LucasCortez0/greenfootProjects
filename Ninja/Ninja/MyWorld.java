import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    public static int arrumaCenario = 0;
    public static int fase = 1;
    public static int tutorial = 0;
    //a variavel "parou" verifica se o  cenario pode se mover.
    public static int parou = 0;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 600, 1);        
        adicionarLuk();
        addObject(new Tutorial(), 600, 220);
    }
    private void adicionarLuk(){
        if(fase == 2){
            addObject(new Fundo(),329, 300);
            addObject(new Chao(), 465, 525);
            addObject(new Luk(), 1144, 407);       
            fase = 1;
            
        }else{
            addObject(new Fundo(),867, 300);
            addObject(new Chao(), 734, 525);
            addObject(new Luk(), 66, 407);
            fase = 1;
            }
    }
}
