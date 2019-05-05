package t3;

public abstract class Raza{

    int fuerza;
    int destreza;
    int constitucion;
    public String habilidad;

    public abstract void crearRaza();
    public abstract void habilidad(String habil);
    public abstract String getHabilidad();

    public abstract void setDestrezaRace(int destreza);
    public abstract void setConstitucionRace(int constitucion);
    public abstract void setFuerzaRace(int strength);
    public abstract int getDestrezaRace();
    public abstract int getConstitucionRace();
    public abstract int getFuerzaRace();

}
