import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Luk here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Luk extends Actor
{
    /**
     * Act - do whatever the Luk wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int contador = 0;
    int contamunicao = 0;
    int contatempo = 0;
    int verifica1 = 0;
    int verifica2 = 0;
    int verifica3 = 0;
    int verifica4 = 0;
    int atira = 0;
    int desbuga = 0;
    int municao = 30;
    int temporiza = 0;
    
    public Luk(){
        //Da pra colocar um construtor no ator, muito loko.
        setRotation(270);
    }
    public void act() 
    {
        andar();
        girar();
        anima();
        tiro();
    }    
    private void andar(){
        //este método faz o personagem se mover.
        //variavel "verifica 1, 2, 3, 4" serve para animação.
        if(Greenfoot.isKeyDown("a")){
            setLocation(getX() - 4, getY());
            verifica1 = 1;
        }else{verifica1 = 0;}            
        if(Greenfoot.isKeyDown("d")){
            setLocation(getX() + 4, getY());
            verifica2 = 1;
        }else{verifica2 = 0;}            
        if(Greenfoot.isKeyDown("w")){
            setLocation(getX(), getY() - 4);  
            verifica3 = 1;
        }else{verifica3 = 0;}   
        if(Greenfoot.isKeyDown("s")){
            setLocation(getX(), getY() + 4);
            verifica4 = 1;
        }else{verifica4 = 0;}
        //contra força para não dobrar a velocidade nas diagonais.
        if(Greenfoot.isKeyDown("a") && Greenfoot.isKeyDown("w")){
            setLocation(getX() +1, getY() +1);  
        }
        if(Greenfoot.isKeyDown("a") && Greenfoot.isKeyDown("s")){
            setLocation(getX() +1, getY() -1);    
        }
        if(Greenfoot.isKeyDown("d") && Greenfoot.isKeyDown("w")){
            setLocation(getX() -1, getY() +1);   
        }
        if(Greenfoot.isKeyDown("d") && Greenfoot.isKeyDown("s")){
            setLocation(getX() -1, getY() -1);   
        }
        
    }
    private void girar(){
        //Este método faz o personagem girar.
        if(Greenfoot.isKeyDown("left")){
            setRotation(180);    
        }
        if(Greenfoot.isKeyDown("right")){
            setRotation(0);    
        }
        if(Greenfoot.isKeyDown("up")){
            setRotation(270);    
        }
        if(Greenfoot.isKeyDown("down")){
            setRotation(90);    
        }
        if(Greenfoot.isKeyDown("left") && Greenfoot.isKeyDown("up")){
            setRotation(225);    
        }
        if(Greenfoot.isKeyDown("right") && Greenfoot.isKeyDown("up")){
            setRotation(315);    
        }
        if(Greenfoot.isKeyDown("down") && Greenfoot.isKeyDown("left")){
            setRotation(135);  
        }
        if(Greenfoot.isKeyDown("down") && Greenfoot.isKeyDown("right")){
            setRotation(45);  
        }
    }
    private void anima(){
        //se "verificar" for verdadeiro (w,a,s,d pressionado) almenta 1
        //na contagem, fazendo a animação.
        if(verifica1 == 1 || verifica2 == 1 || verifica3 == 1 || verifica4 == 1 && contador < 41){
            contador++;   
        }
        //Faz o personagem voltar a imagem 1 (parado) quando nenhuma tecla
        //estiver pressionada.
        if(verifica1 == 0 && verifica2 == 0 && verifica3 == 0 & verifica4 == 0){
            contador = 0;    
        }
        //Muda as imagens de acordo com o contador.
        if(contador > -1 && contador < 11){
            setImage("p1.png");    
        }
        if(contador > 9 && contador < 21){
            setImage("p2.png");    
        }
        if(contador > 19 && contador < 31){
            setImage("p3.png");    
        }
        if(contador > 29 && contador < 41){
            setImage("p4.png");    
        }
        if(contador == 0){
            setImage("p1.png");
        }
        if(contador > 40){
            contador = 0;
        }
        
    }
    private void tiro(){
        contatempo ++;
        if(contatempo >= 200){
        getWorld().showText("munição: " + municao, 250, 20);    
        }
        if(Greenfoot.isKeyDown("r") && municao < 30){
            Greenfoot.playSound("recarregar.mp3");
            contamunicao = 30;
            contamunicao = contamunicao - municao;
            municao = municao + contamunicao;
            //A variavel temporiza não deixa o Luk atirar enquanto a arma recarrega.
            temporiza = 75;
        }
        temporiza --;
        
        if(atira < 15){
            atira++;    
        }
        if(Greenfoot.isKeyDown("space") && atira == 15 && municao > 0 && temporiza < 0){
            Bala bala = new Bala();    
            getWorld().addObject(bala,getX(),getY()); 
            bala.setRotation(getRotation());
            atira = 0;
            Greenfoot.playSound("tiro.mp3");
            municao --;
        }
      
        if(isTouching(Recarga.class)){
            municao = 30;
        }
        
    }
}
