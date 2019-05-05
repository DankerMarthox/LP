package t3;

public abstract class Clase {
    int armadura;
    char estado;
    
    abstract void crearClase();
    abstract void ataque(Personaje j, Personaje e);
    abstract void defender();


    public abstract void setArmaduraClass(int armor);
    public abstract int getArmaduraClass();

    public abstract void setEstadoClass(char s);
    public abstract char getEstadoClass();
}
