import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Inicio extends World
{
    int contador = 0;
    int contamusica = 0;
    GreenfootSound musica = new GreenfootSound("musica.mp3");
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public Inicio()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, true); 
        adicionar();
       
    }
    public void act(){
        texto(); 
        som();
        mudarmundo();
    }
    
    private void adicionar(){
        Fundo fundo = new Fundo();
        addObject(fundo,1100,200);
        addObject(new Logo(), 300, 150);
      }
    
    private void som(){
        if(contamusica == 0){
             musica.play();
             contamusica = 1;
        }
        
    }
    private void mudarmundo(){
        //Este contador elimina o bug na hora de trocar de mundo. 
        if(contador <15){
            contador++;    
        }
        //Este contador leva para tela de Créditos.
        if(Greenfoot.isKeyDown("enter") && contador == 15){
            Greenfoot.setWorld(new Creditos());
            musica.stop();
        }
        if(Greenfoot.isKeyDown("space") && contador == 15){
            Greenfoot.setWorld(new Cenario1());
            musica.stop();
        }
    }

    private void texto(){

        showText("Pressione espaço para iniciar", 300, 300);
        showText("Enter para os créditos", 300, 330);

       
    }
}