import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Luk here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Luk extends Actor
{
    //animação
    int corre = 0;
    int esquerda = 0;
    int parado = 0;
    int contaParado = 0;
    int prontoPraPular = 0;
    int animaPulo = 0;
    int contaPulo = 0;
    int contadorPulo = 0;
    int verificaPuloSimples = 0;
    int giraEsquerda = 0;
    //movimentação
    int pulou = 0;
    int pulo = -25;
    int apertouSpace = 0;
    int contaPularNovamente = 0;
    int emAcao = 0;
    int contador = 0;
    int arrumaCenario2 = 0;

    /**
     * Act - do whatever the Luk wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        mover();
        fisica();
        anima();
        cenario();
    }    

    private void mover(){   
        //Movimentação para esquerda e direita.
        if(Greenfoot.isKeyDown("a") && getX() > 0){
            setLocation(getX() - 4, getY());
        }else
        if(Greenfoot.isKeyDown("d") && getX() < 1198){
            setLocation(getX() + 4, getY());    
        }else{MyWorld.arrumaCenario = 0;}

        //Movimentação para o pulo.
        if(Greenfoot.isKeyDown("space") && Greenfoot.isKeyDown("shift")){
            apertouSpace = 2;
        }else
        if(Greenfoot.isKeyDown("space")){
            apertouSpace = 1;
        }

        //Pulo simples...
        if(apertouSpace == 1){       
            pulou = 1;
            verificaPuloSimples = 1;           
            if(pulou == 1){
                emAcao = 1;
                setLocation(getX(), getY() + pulo);
                if(pulo < 0){
                    pulo ++;
                }

                //.....
            }

            //Permite pular novamente quando acabar o pulo.
            if(pulo == 0){
                contaPularNovamente ++;
            }

        }

        //Super pulo
        if(apertouSpace == 2 && emAcao == 0 && Greenfoot.isKeyDown("a") || apertouSpace == 2 && emAcao == 0 && Greenfoot.isKeyDown("d")){
            arrumaCenario2 = 1;
            giraEsquerda = esquerda;
            if(esquerda == 0){
                move(4);
            }else
            if(esquerda == 1){
                move(-4);
            }
            setLocation(getX(), getY() + pulo);
            if(pulo < 0){
                pulo ++;
            }   

            //Trava a animação para exibir o super pulo.
            if(contador == 0){
                animaPulo = 1;
                contador = 1;

            }

        }
        //destrava as animações após o super pulo.
        if(contador == 1){
            contaPulo ++;
        }
        if(contaPulo >= 70){
            animaPulo = 0;
            contador = 0;
            contaPulo = 0;
            arrumaCenario2 = 0;
            giraEsquerda = 0;
            prontoPraPular = 20;
            apertouSpace = 0;
            pulo = -25;
        }        
        //Faz o cenario se movimentar mais rapido quando der o super pulo.
        MyWorld.arrumaCenario = arrumaCenario2;
    }  

    private void fisica(){
        //verifica se o cenario pode se mover.
        if(Greenfoot.isKeyDown("a") && getX() >= 0){
            MyWorld.parou = 0;
        }else
        if(Greenfoot.isKeyDown("d") && getX() <= 1999){
            MyWorld.parou = 0;
        }else{MyWorld.parou = 1;}

        //Fisica do chão.
        setLocation(getX(), getY() + 5);
        Actor chao = getOneIntersectingObject(Chao.class); 
        Actor chao1 = getOneIntersectingObject(chao1.class);
        Actor chao2 = getOneIntersectingObject(chao2.class);
        Actor chao3 = getOneIntersectingObject(chao3.class);
        Actor piso = getOneIntersectingObject(Piso.class);
        if(chao != null){
            setLocation(getX(), getY() - 5);  
            emAcao = 0;
            //reseta pulo ao tocar.
            contaPularNovamente = 0;
            apertouSpace = 0;
            pulo = -25;
            emAcao = 0;
            pulou = 0;
            verificaPuloSimples = 0;
            //restaura super pulo ao tocar.
            animaPulo = 0;
            contador = 0;
            contaPulo = 0;
            arrumaCenario2 = 0;
            giraEsquerda = 0;
            prontoPraPular = 20;
            contadorPulo = 0;
            if(animaPulo == 1){
                contadorPulo = 0;
            }else
            if(contaPulo > 35){
                animaPulo = 0;
            }
            if(contaPularNovamente >= 42){
                contaPularNovamente = 0;
                apertouSpace = 0;
                pulo = -25;
                emAcao = 0;
                pulou = 0;
                verificaPuloSimples = 0;
            }
        }else

        if(chao1 != null){
            setLocation(getX(), getY() - 5);            
            emAcao = 0;
            //reseta pulo ao tocar.
            contaPularNovamente = 0;
            apertouSpace = 0;
            pulo = -25;
            emAcao = 0;
            pulou = 0;
            verificaPuloSimples = 0;
            //restaura super pulo ao tocar.
            animaPulo = 0;
            contador = 0;
            contaPulo = 0;
            arrumaCenario2 = 0;
            giraEsquerda = 0;
            prontoPraPular = 20;
            contadorPulo = 0;
            if(animaPulo == 1){
                contadorPulo = 0;
            }else
            if(contaPulo > 35){
                animaPulo = 0;
            }
            if(contaPularNovamente >= 42){
                contaPularNovamente = 0;
                apertouSpace = 0;
                pulo = -25;
                emAcao = 0;
                pulou = 0;
                verificaPuloSimples = 0;
            }
        }else

        if(chao2 != null){
            setLocation(getX(), getY() - 5);            
            emAcao = 0;
            //reseta pulo ao tocar.
            contaPularNovamente = 0;
            apertouSpace = 0;
            pulo = -25;
            emAcao = 0;
            pulou = 0;
            verificaPuloSimples = 0;
            //restaura super pulo ao tocar.
            animaPulo = 0;
            contador = 0;
            contaPulo = 0;
            arrumaCenario2 = 0;
            giraEsquerda = 0;
            prontoPraPular = 20;
            contadorPulo = 0;
            if(animaPulo == 1){
                contadorPulo = 0;
            }else
            if(contaPulo > 35){
                animaPulo = 0;
            }
            if(contaPularNovamente >= 42){
                contaPularNovamente = 0;
                apertouSpace = 0;
                pulo = -25;
                emAcao = 0;
                pulou = 0;
                verificaPuloSimples = 0;
            }
        }else
        if(chao3 != null){
            setLocation(getX(), getY() - 5);
            emAcao = 0;
            //reseta pulo ao tocar.
            contaPularNovamente = 0;
            apertouSpace = 0;
            pulo = -25;
            emAcao = 0;
            pulou = 0;
            verificaPuloSimples = 0;
            //restaura super pulo ao tocar.
            animaPulo = 0;
            contador = 0;
            contaPulo = 0;
            arrumaCenario2 = 0;
            giraEsquerda = 0;
            prontoPraPular = 20;
            contadorPulo = 0;
            if(animaPulo == 1){
                contadorPulo = 0;
            }else
            if(contaPulo > 35){
                animaPulo = 0;
            }
            if(contaPularNovamente >= 42){
                contaPularNovamente = 0;
                apertouSpace = 0;
                pulo = -25;
                emAcao = 0;
                pulou = 0;
                verificaPuloSimples = 0;
            }
        }else

        if(piso != null){
            setLocation(getX(), getY() - 5); 
            emAcao = 0;
            //reseta pulo ao tocar.
            contaPularNovamente = 0;
            apertouSpace = 0;
            pulo = -25;
            emAcao = 0;
            pulou = 0;
            verificaPuloSimples = 0;
            //restaura super pulo ao tocar.
            animaPulo = 0;
            contador = 0;
            contaPulo = 0;
            arrumaCenario2 = 0;
            giraEsquerda = 0;
            prontoPraPular = 20;
            contadorPulo = 0;
            if(animaPulo == 1){
                contadorPulo = 0;
            }else
            if(contaPulo > 35){
                animaPulo = 0;
            }
            if(contaPularNovamente >= 42){
                contaPularNovamente = 0;
                apertouSpace = 0;
                pulo = -25;
                emAcao = 0;
                pulou = 0;
                verificaPuloSimples = 0;
            }
        }else
        if(animaPulo == 0){
            emAcao = 1;    
        }

    }

    private void anima(){
        //Verifica se está andando.
        int animaCorrer = 0;
        if(Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("d")){
            animaCorrer = 1;
            //verifica se o ator ja pode dar o super pulo
            if(prontoPraPular <= 59){
                prontoPraPular ++;
            }
        }else
        //Diminui da ariavel se não estiver pressionando (não pode pular).
        if(prontoPraPular > 0){
            prontoPraPular = 0;
        }

        //Faz a contagem para animação de correr.
        if(animaCorrer == 1){
            corre ++;
        }else{corre = 0;}

        //Verifica se está virado pra esquerda ou direita.
        if(Greenfoot.isKeyDown("a")){
            esquerda = 1;
        }else 
        if(Greenfoot.isKeyDown("d")){
            esquerda = 0;
        }
        //Animação pulo simples (para direita).
        if(verificaPuloSimples == 1 && esquerda == 0){
            setImage("pulo7.png");
        }else
        //Animação pulo simples (para esquerda).
        if(verificaPuloSimples == 1 && esquerda == 1){
            setImage("puloEsquerda7.png");
        }else
        //Animação do super pulo (para direita).
        if(animaPulo == 1 && giraEsquerda == 0){
            contadorPulo ++;
            if(contadorPulo >= 0 && contadorPulo < 5){
                setImage("pulo1.PNG");
            }else
            if(contadorPulo >= 5 && contadorPulo < 10){
                setImage("pulo2.png");
            }else
            if(contadorPulo >= 10 && contadorPulo < 15){
                setImage("pulo3.png");
            }else
            if(contadorPulo >= 15 && contadorPulo < 20){
                setImage("pulo4.png");
            }else
            if(contadorPulo >= 20 && contadorPulo < 25){
                setImage("pulo5.png");
            }else
            if(contadorPulo >= 25 && contadorPulo < 30){
                setImage("pulo6.png");
            }else
            if(contadorPulo >= 30 && contadorPulo < 35){
                setImage("pulo7.png");
            }           
        }else
        //Animação do super pulo (para direita)
        if(animaPulo == 1 && giraEsquerda == 1){
            contadorPulo ++;
            if(contadorPulo >= 0 && contadorPulo < 5){
                setImage("puloEsquerda1.png");
            }else
            if(contadorPulo >= 5 && contadorPulo < 10){
                setImage("puloEsquerda2.png");
            }else
            if(contadorPulo >= 10 && contadorPulo < 15){
                setImage("puloEsquerda3.png");
            }else
            if(contadorPulo >= 15 && contadorPulo < 20){
                setImage("puloEsquerda4.png");
            }else
            if(contadorPulo >= 20 && contadorPulo < 25){
                setImage("puloEsquerda5.png");
            }else
            if(contadorPulo >= 25 && contadorPulo < 30){
                setImage("puloEsquerda6.png");
            }else
            if(contadorPulo >= 30 && contadorPulo < 35){
                setImage("puloEsquerda7.png");
            }
        }else
        //Anima para direita (correndo).
        if(esquerda == 0 && animaPulo == 0){
            if(corre > 0 && corre <= 4){
                setImage("correndo1.png");
            }else
            if(corre > 4 && corre <= 8){
                setImage("correndo2.png");
            }else
            if(corre > 8 && corre <= 12){
                setImage("correndo3.png");
            }else
            if(corre > 12 && corre <= 16){
                setImage("correndo4.png");
            }else
            if(corre > 16 && corre <= 20){
                setImage("correndo5.png");
            }else
            if(corre > 20 && corre <= 24){
                setImage("correndo6.png");
            }
        }else
        //Anima para esquerda (correndo).
        if(esquerda == 1 && animaPulo == 0){
            if(corre > 0 && corre <= 4){
                setImage("correndoEsquerda1.png");
            }else
            if(corre > 4 && corre <= 8){
                setImage("correndoEsquerda2.png");
            }else
            if(corre > 8 && corre <= 12){
                setImage("correndoEsquerda3.png");
            }else
            if(corre > 12 && corre <= 16){
                setImage("correndoEsquerda4.png");
            }else
            if(corre > 16 && corre <= 20){
                setImage("correndoEsquerda5.png");
            }else
            if(corre > 20 && corre <= 24){
                setImage("correndoEsquerda6.png");
            }
        } 
        //Retorna o contador da animação a 0.
        if(corre >= 25){
            corre = 0;
        }

        //Anima para direita (parado).
        if(esquerda == 0 && animaCorrer == 0){
            parado = Greenfoot.getRandomNumber(100);
            if(parado == 0 && contaParado <= 0){
                setImage("parado2.png");
                contaParado = 10;
            }else
            if(parado > 0 && contaParado <= 0){
                if(contaParado <= 0){
                    setImage("parado1.png");
                }
            }
            contaParado --;
        }else
        //Anima para esquerda (parado).
        if(esquerda == 1 && animaCorrer == 0){
            parado = Greenfoot.getRandomNumber(100);
            if(parado == 0 && contaParado <= 0){
                setImage("paradoEsquerda2.png");
                contaParado = 10;
            }else
            if(parado > 0 && contaParado <= 0){
                if(contaParado <= 0){
                    setImage("paradoEsquerda1.png");
                }
            }
            contaParado --;
        }

        // Para ver algumas variaveis na pratica.

        // getWorld().showText("virado pra esquerda " + esquerda, 450, 100);
        // getWorld().showText("esta correndo " + animaCorrer, 450, 120);
        // getWorld().showText("contagem correr " + corre, 450, 140);
        // getWorld().showText("contagem parado " + parado, 450, 160);
        // getWorld().showText("pode pular " + prontoPraPular, 450, 180);

    }

    private void cenario(){
        //avançar
        if(getX() > 1197 && MyWorld.fase == 1){
            Greenfoot.setWorld(new Cenario2());          
        }else
        if(getX() > 1197 && MyWorld.fase == 2){
            Greenfoot.setWorld(new Cenario3());          
        }else
        if(getX() > 1197 && MyWorld.fase == 3){
            getWorld().showText("fim de jogo.", 600, 300);
            Greenfoot.stop();
        }

        //voltar
        if(getX() < 3 && MyWorld.fase == 2){
            Greenfoot.setWorld(new MyWorld());

        }//else
        if(getX() < 3 && MyWorld.fase == 3){
            Greenfoot.setWorld(new Cenario2());
        }

        
    }
}
