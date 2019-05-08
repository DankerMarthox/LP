package juego;

public class Prolonia extends Ninja{

    public Prolonia(){
        this.Jutsu_1 = "Confusion Falso Verdadero";
        this.Jutsu_2 = "Querykugan";
        this.Jutsu_3 = "Gran Explosión de Backtracking";
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
        return "Prolonia";
    }
}