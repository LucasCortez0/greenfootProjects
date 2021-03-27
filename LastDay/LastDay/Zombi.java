import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Zuzu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Zombi extends Actor
{
    int contador = 0;
    int morte = 0;
    int conta = 0;
    int verifica = 0;
    int contaponto = 0; 
    int contaponto2 = 0; 
    int limite = 0;
    int verificaenter = 0;
    int contatoque = 0;
    int bugmorte = 0;
    public static String nome;
    public static String nomeRecord;
    public static int tiraBugNome = 0;
    public static int ponto = 0;
    public static int vidaluk = 3;
    public static int score = 0;
    /**
     * Act - do whatever the Zuzu wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Zombi(){
        nome();
        //vidaluk = 3;
    }
    public void act() 
    {
        getWorld().showText("vidas: " + vidaluk, 130, 20);
        getWorld().showText("kills: " + ponto, 40, 20);
        getWorld().showText("Player atual: " + nome, 800, 580);
        mover();
        anima();
        vida();
        remove();
        hackeeimesmo();
      
    } 
    private void nome(){
        //Este método possibilita q o player digite seu nome no inicio do jogo.
        if(tiraBugNome == 0){
            nome = Greenfoot.ask("Digite seu nome");
            tiraBugNome = 1;
        }
    }
    private void mover(){
        //Faz o Zombi andar se morte == 0 (Zombi estiver vivo).
        if(morte == 0){
            move(2);    
        }
    }
    private void anima(){
        //Se o Zombi estiver vivo(morte == 0) contador recebe mais um para animação.
        if(morte == 0){
            contador++;   
        }
        
        //Se morte > 1 (Zombi morto) o contador para de adicionar e vai para
        //-1, isso permite que o Zombi exiba a imagem "Morto.png"
        if(morte > 0){
            contador = -1; 
        }
        if(morte == 1){
            conta++;
        }
        
        if(contador > -1 && contador < 11){
            setImage("z1.png");    
        }
        if(contador > 9 && contador < 21){
            setImage("z2.png");    
        }
        if(contador > 19 && contador < 31){
            setImage("z3.png");    
        }
        if(contador > 29 && contador < 41){
            setImage("z4.png");    
        }
            
        if(contador > 40){
            contador = 0;
        }
      
    }
    private void vida(){
        //Se o zombi alcançar o limite da tela, uma vida a menos.
        if(getX() > 898){
            vidaluk--;
            limite ++;
        }
        //Fim de jogo
        if(vidaluk == 0){
            if(ponto > score){
                score = ponto;
                nomeRecord = nome;
            }
            Fim fim = new Fim();
            getWorld().addObject(fim, 450, 300);
            getWorld().showText("Fim de jogo", 450, 300);
            getWorld().showText("Sua pontuação foi de: " + ponto + " pontos", 450, 330);
            getWorld().showText("Maior pontuação: " + score + " " + nomeRecord, 450, 380);
            getWorld().showText("Pressione Enter para voltar ao menu inicial", 450, 550);
            verificaenter = 1;
        }
        if(Greenfoot.isKeyDown("enter") && verificaenter == 1){
            tiraBugNome = 0;
            ponto = 0;
            vidaluk = 3;
            Greenfoot.setWorld(new Inicio());
        }
        //Se o zombi encostar no sobrevivente, uma vida a menos
        contatoque --;
        if(isTouching(Luk.class) && contatoque < 0 && bugmorte == 0 ){
            vidaluk = vidaluk - 1;
            contatoque = 150;
        }
    }
    public void remove(){
        //Remove ao tocar na bala, e faz a pontuação.
        List<Bala> balas = getIntersectingObjects(Bala.class);
        if(balas.size() > 0 && bugmorte == 0){
            getWorld().removeObjects(balas);
            setImage("morto.png");
            morte = 1;
            contaponto = 1;
            //esta variavel faz o Luk não tomar dano ao encostar no zombi
            //morto, e não deixa a bala se destruir no zombi morto
            bugmorte = 1;
            
            
        }
        //Temporizador para ajustar os pontos.
        if(contaponto2 > 0){
            contaponto --;    
        }
        if(contaponto == 1 && contaponto2 == 0){
            ponto ++;
        
            contaponto2 = 20;
        }
        
        //Remove ao tocar nos limites da tela.
        if(isAtEdge()){
            //Essa parte me deu uma puta dor de cabeça.
            getWorld().removeObject(this);    
        }    
        
        //Temporizador para desaparecer o Zombie, começo do código na linha 40.
        if(conta == 20){
            getWorld().removeObject(this);
        }
    }
    private void hackeeimesmo(){
        if(Greenfoot.isKeyDown("1")){
            vidaluk = 3;
        }
    }
}
