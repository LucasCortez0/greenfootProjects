import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Creditos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Creditos extends World
{
    int contador = 0;
    
    /**
     * Constructor for objects of class Creditos.
     * 
     */
    public Creditos()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        adicionar();
    }
    public void act(){
        //Este contador elimina o bug na hora de trocar de mundo.    
        if(contador < 15){
            contador++;    
        }
        //Leva para a tela inicial.
        if(Greenfoot.isKeyDown("enter") && contador == 15){
            Greenfoot.setWorld(new Inicio());    
        }
        //Leva para o jogo.
        if(Greenfoot.isKeyDown("space") && contador == 15){
            Greenfoot.setWorld(new Cenario1());   
            
        }   
    }
    private void adicionar(){
        Fundo fundo = new Fundo();
        addObject(fundo,1100,200);
        
        showText("Fiquei com preguiça de fazer os créditos..., foi mal", 300, 200);
        showText("Pressione espaço para iniciar", 300, 300);
        showText("Enter para voltar ao menu inicial",300, 330);
    }
}
