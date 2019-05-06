package juego;

public interface Personaje{
  
    void asignarAtaqueFisico();
        
    void asignarNombre(String nombre);
    
    void asignarVida(int vida);
    
    void asignarNinja(String aldea);

    void asignarObjeto(String objeto, String rareza);
    
    void asignarRango(String rango);
    
    void realizarAtaque();
    
    void asignarNivel(int nivel);
    
}