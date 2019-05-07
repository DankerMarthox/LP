package juego;

public class Cthonia extends Ninja{

    public Cthonia(){
        this.Jutsu_1 = "Freedori";
        this.Jutsu_2 = "Punteringan";
        this.Jutsu_3 = "Malloc Tensei";
        this.nivel_Jutsu = 0;
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
        return "Cthonia";
    }
    
}