package juego;



public abstract class Ninja {
    
    protected String Jutsu_1;
    protected String Jutsu_2;
    protected String Jutsu_3;
    protected int nivel_Jutsu;
    
    
    public Ninja(){
    }
    
    abstract void crearNinja();
    
    public void asignarNivelJutsus(int n){
        this.nivel_Jutsu = n;
    }
    
    public int usarJutsu(int Jutsu){
        int dmg = 0;
        switch(Jutsu){
            case 0:
                dmg = this.nivel_Jutsu;
                break;
            case 1:
                dmg = 2 * this.nivel_Jutsu;
                break;
            case 2:
                dmg = 3;
                break;
        }
        return dmg;
    }
    
    abstract String getAldea();

    public int getLevelJutsts(){
        return this.nivel_Jutsu;
    }
}
