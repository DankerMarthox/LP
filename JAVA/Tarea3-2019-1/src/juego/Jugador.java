package juego;

public class Jugador implements Personaje{
    
    private int vida;
    private int vidaMaxima;
    private int energia;
    private int oro;
    private int nivel;
    private int experiencia;
    private int LuckyBastard;
    
    private String nombre;
    private Ninja ninja;
    
    private String arma;
    private String rango;
    private int ataque;
    private int modificadorArma;

    
    
    public Jugador(){
        this.energia = 300;
        this.nivel = 1;
        this.vidaMaxima = 101;
        this.vida = 101;
        this.ataque = 4;
        this.modificadorArma = 0;
        this.arma = "Nada";
        this.LuckyBastard = 1;
        this.arma = "Nada";
        this.rango = "Ifnin";
    }
    
    @Override
    public int realizarAtaque(int type, int Jutsu){
        int atk = 0;
        switch(type){
            case 0:
                atk = this.ataque;
                break;
            case 1:
                switch(Jutsu){
                    case 0:
                        atk = this.nivel * this.ninja.usarJutsu(0);
                        break;
                    case 1:
                        atk = this.ninja.usarJutsu(1);
                        break;
                    case 2:
                        atk = this.nivel * this.ninja.usarJutsu(2);
                        break;
                }
                break;
        }
        return atk;
    }    
    
    
    @Override
    public void asignarVida(int vida){
        this.vida = vida;
    }
    
    @Override
    public void asignarNinja(String aldea){
        switch (aldea){
            case "Pythonia":
                this.ninja = new Pythonia();
                break;
            case "Cthonia":
                this.ninja = new Cthonia();
                break;
            case "Javania":
                this.ninja = new Javania();
                break;
            case "Schemia":
                this.ninja = new Schemia();
                break;
            case "Prolonia":
                this.ninja = new Prolonia();
                break;
        }
    }
 
    @Override
    public void asignarNombre(String nombre){
        this.nombre = nombre;
    }
    
    @Override
    public void asignarAtaqueFisico(){
        this.ataque = this.nivel + this.modificadorArma + 3;
    }
    
    @Override
    public void asignarObjeto(String arma, String rareza){
        this.arma = arma;
        switch (rareza){    
            case "Comun":
                this.modificadorArma = 2;
                break;
                
            case "Rara":
                this.modificadorArma = 3;
                break;
                 
            case "Epica":
                this.modificadorArma = 4;
                break;
                             
            case "Legendaria":
                this.modificadorArma = 5;
                break;
        }
        asignarAtaqueFisico();
    }
    
    @Override
    public void asignarRango(String rango){
        this.rango = rango;
    }        
    
    @Override
    public void asignarNivel(int nivel){
        this.nivel = nivel;
        this.vidaMaxima = 100 + this.nivel;
        asignarAtaqueFisico();
        if (this.vida < this.vidaMaxima){
            this.vida += 1;
        }
        if (nivel == 3){
            this.rango = "Fornin";
        }
        else if(nivel == 5){
            System.out.println("El nivel 5 es invencible... Lol");
        }
        else if (nivel == 7){
            this.rango = "Whilenin";
        }
    }
    
    public void asignarEnergia(int energia){
        this.energia = energia;
    }
    
    public void asignarExperiencia(int experiencia){
        this.experiencia += experiencia;
        if (this.experiencia > 99){
            asignarNivel(this.nivel+1);
            this.experiencia -= 100;
        }    
    }
    
    public void asignarOro(int oro){
        this.oro = oro;
    } 
    
///////////////////////////////////////////////    
    
    public String getNombre(){
        return this.nombre;
    }
    
    public int getVida(){
        return this.vida;
    }
    
    public int getOro(){
        return this.oro;
    }
    
    public int getExperiencia(){
        return this.experiencia;
    }
    
    public int getEnergia(){
        return this.energia;
    }
    
    public int getNivel(){
        return this.nivel;
    }
    
    public String getRango(){
        return this.rango;
    }
    
    public String getArma(){
        return this.arma;
    }
    
    public int getModificador(){
        return this.modificadorArma;
    }
    
    public int getAtaque(){
        return this.ataque;
    }
    
    public int getLuck(){
        return this.LuckyBastard;
    }
    
    public void unLucky(){
        this.LuckyBastard = 0;
    }
    
    public Ninja getNinja(){
        return this.ninja;
    }
    public int getMaxVida(){
        return this.vidaMaxima;
    }

    public void displayJutsus(){
        System.out.println("\n[0] "+this.ninja.Jutsu_1+"\n[1] " + this.ninja.Jutsu_2 +
        "\n[2] " + this.ninja.Jutsu_3);
    }
    
}
