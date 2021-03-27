
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class cenario1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cenario1 extends World
{
    int spawn = 0;
    int temporiza = 0;
    int verifica = 200;
    int bonusRecarga = 0;
    int bonusRecargaDepoisDeUmTempo = 0;
    /**
     * Constructor for objects of class cenario1.
     * 
     */
    public Cenario1()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 600, 1);
        adicionar();
        
    }
    public void act(){
        addzombi();
        addBonusRecarga();
     
        
        //caso queira ver o temporizador do spawn na pratica, só descomentar.
        // showText("temporiza: " + temporiza, 800 , 50);
        // showText("verifica: " + verifica, 800 , 100);
        // showText("spawn: " + spawn, 800 , 150);
    }
    private void addzombi(){
        spawn++;
        temporiza++;
        //adiciona Zombi, temporizador para acelerar spawn.
        if(spawn == verifica){
            Zombi zombi = new Zombi();
            addObject(zombi, 0, Greenfoot.getRandomNumber(520) + 40);
            spawn = 0;
        }
        if(temporiza > 500 && verifica > 60){
            verifica = verifica - 20;
            temporiza = 0;
        }
        if(temporiza > 500 && verifica <= 60 && verifica >= 40){
            verifica = verifica - 5;
            temporiza = 0;
        }
        //tira bug(quando temporizador chega a 60, para de add zombi, spawn
        //passa lotado).
        if(spawn > verifica){
            spawn = 0;
        }
    }
    private void addBonusRecarga(){
        bonusRecargaDepoisDeUmTempo ++;
        bonusRecarga = Greenfoot.getRandomNumber(2000);
        if(bonusRecargaDepoisDeUmTempo > 4000 && bonusRecarga > 1997){
            addObject(new Recarga(), Greenfoot.getRandomNumber(500) + 250, Greenfoot.getRandomNumber(530) + 40);
        }
    }
    private void adicionar(){
        Luk luk = new Luk();
        addObject(luk, 450, 300);
        addObject(new Sobreviva(), 450, 300);
       
    }
}
