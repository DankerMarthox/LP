package juego;

public class Javania extends Ninja{

    public Javania(){
        this.Jutsu_1 = "Jutsu Clones de Clases";
        this.Jutsu_2 = "Atadura de Súper Clase";
        this.Jutsu_3 = "Tsunami de Objetos";
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
        return "Javania";
    }
    
}