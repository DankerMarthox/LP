package juego;

public abstract class Ninja {
    
    protected String Jutsu_1;
    protected String Jutsu_2;
    protected String Jutsu_3;
    protected int nivel_Jutsu;
    
    
    public Ninja(){
    }
    
    abstract void crearNinja();
    
    abstract void asignarNivelJutsus();
    
    abstract void usarJutsu();
    
    abstract String getAldea();
}
