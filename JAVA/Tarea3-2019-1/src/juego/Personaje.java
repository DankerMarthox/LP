package juego;

public interface Personaje{
  
    void asignarAtaqueFisico();
        
    void asignarNombre(String nombre);
    
    void asignarVida(int vida);
    
    void asignarNinja(String aldea);

    void asignarObjeto(String objeto, String rareza);
    
    void asignarRango(String rango);
    
    int realizarAtaque(int type, int Jutsu);
    
    void asignarNivel(int nivel);
    
}