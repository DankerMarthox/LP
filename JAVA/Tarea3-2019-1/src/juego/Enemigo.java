package juego;

public class Enemigo implements Personaje{
    
    private int vida;
    private int vidaMaxima;
    private int nivel;
    
    private String nombre;
    private Ninja ninja;
    
    private String arma;
    private String rango;
    private int ataque;
    private int modificadorArma;
    
    public Enemigo(){
        this.vida = 101;
        this.nivel = 1;
        this.nombre = "";
        this.arma = "Nada";
        this.modificadorArma = 0;
        this.ataque = 4;
    }

    @Override
    public int realizarAtaque(int type, int Jutsu){
        int atk = 0;
        switch (type) {
            case 0:
                atk = this.ataque;
                break;
            case 1:
                atk = this.ninja.usarJutsu(Jutsu);
                break;
        }
        return atk;
    }    
     
    @Override
    public void asignarVida(int vida){
        this.vida = vida;
    }
    
    @Override
    public void asignarNivel(int nivel){
        this.nivel = nivel;
        this.vidaMaxima = 100 + nivel;
        this.ataque = 3 + this.nivel + this.modificadorArma;
        if (this.vida < this.vidaMaxima){
            this.vida = this.vidaMaxima;
        }
        if ((nivel > 2) && (nivel < 7)) {
            this.ninja.asignarNivelJutsus(2);
        } else if (nivel > 6) {
            this.ninja.asignarNivelJutsus(3);
        }      
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
                this.ataque = 5 + this.nivel;
                break;
                
            case "Rara":
                this.modificadorArma = 3;
                this.ataque = 6 + this.nivel;
                break;
                 
            case "Epica":
                this.modificadorArma = 4;
                this.ataque = 7 + this.nivel;
                break;
                             
            case "Legendaria":
                this.modificadorArma = 5;
                this.ataque = 8 + this.nivel;
                break;
        }
    }
    
    @Override
    public void asignarRango(String rango){
        this.rango = rango;
        if (rango == "Kage") {
            this.ninja.asignarNivelJutsus(4);
        }
    }        
///////////////////////////////////////////////    
    
    public String getNombre(){
        return this.nombre;
    }
    public int getVida(){
        return this.vida;
    }
    public int getNivel(){
        return this.nivel;
    }
    public String getRango(){
        return this.rango;
    }
    
    public int getLevelJutsts() {
        return this.ninja.getLevelJutsts();
    }
}
