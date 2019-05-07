package juego;

public class Schemia extends Ninja{

    public Schemia(){
        this.Jutsu_1 = "Parentesiyomi Infinito";
        this.Jutsu_2 = "Jutsu Recursión de Fuego";
        this.Jutsu_3 = "Letsano";
        this.nivel_Jutsu = 1;
    }

    @Override
    public void crearNinja(){
        super.Jutsu_1 = this.Jutsu_1;
        super.Jutsu_2 = this.Jutsu_2;
        super.Jutsu_3 = this.Jutsu_3;
    }
    
    @Override
    public void asignarNivelJutsus(){
        
    }
        
    @Override
    public String getAldea(){
        return "Schemia";
    }
}