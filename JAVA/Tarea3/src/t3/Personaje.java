package t3;

public interface Personaje {

	Raza asignarRaza(String R );
	Clase asignarClase(String C);

	public void asignarVida(int v);
	public void asignarNombre(String Name);
	public void setEstado(char s);

	public int getVida();
	public String getNombre();
	public char getEstado();
	public int getArmadura();

	public String getHabilidad();

	public int getFuerza();
	public int getDestreza();
	public int getConstitucion();

	public void attack(Personaje j, Personaje e);
	public void defend();

	public String getClase();
	public String getRaza();
}
