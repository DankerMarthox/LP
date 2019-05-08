package juego;

public class Pythonia extends Ninja{

    public Pythonia(){
        this.Jutsu_1 = "Jutsu Mil Años de Interpretación";
        this.Jutsu_2 = "Jutsu Multi Tamaño";
        this.Jutsu_3 = "Técnica de Confusión de Variables";
        this.nivel_Jutsu = 1;
    }

    @Override
    public void crearNinja(){
        super.Jutsu_1 = this.Jutsu_1;
        super.Jutsu_2 = this.Jutsu_2;
        super.Jutsu_3 = this.Jutsu_3;
    }
    

    @Override
    public String getAldea(){
        return "Pythonia";
    }
}