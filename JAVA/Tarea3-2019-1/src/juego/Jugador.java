package juego;

public class Jugador implements Personaje {

    private int vida;
    private int vidaMaxima;
    private int energia;
    private int oro;
    private int nivel;
    private int experiencia;
    private int LuckyBastard;
    private int oroTotal;

    private String nombre;
    private Ninja ninja;
    private int misionesCumplidas;

    private String arma;
    private String rango;
    private int ataque;
    private int modificadorArma;
    private int cantidadArmas;


    
    public Jugador() {
        this.energia = 300;
        this.nivel = 1;
        this.vidaMaxima = 101;
        this.vida = 101;
        this.ataque = 4;
        this.modificadorArma = 0;
        this.arma = "Nada";
        this.LuckyBastard = 1;
        this.arma = "Nada";
        this.rango = "Ifnin";
        this.oroTotal = 0;
        this.cantidadArmas = 0;
        this.misionesCumplidas = 0;
    }

    @Override
    public int realizarAtaque(int type, int Jutsu) {
        int atk = 0;
        switch (type) {
        case 0:
            atk = this.ataque;
            break;
        case 1:
            switch (Jutsu) {
            case 0:
                atk = this.nivel * this.ninja.usarJutsu(0);
                break;
            case 1:
                atk = this.ninja.usarJutsu(1);
                break;
            case 2:
                atk = this.nivel * this.ninja.usarJutsu(2);
                break;
            }
            break;
        }
        return atk;
    }

    @Override
    public void asignarVida(int vida) {
        this.vida = vida;
    }

    @Override
    public void asignarNinja(String aldea) {
        switch (aldea) {
        case "Pythonia":
            this.ninja = new Pythonia();
            break;
        case "Cthonia":
            this.ninja = new Cthonia();
            break;
        case "Javania":
            this.ninja = new Javania();
            break;
        case "Schemia":
            this.ninja = new Schemia();
            break;
        case "Prolonia":
            this.ninja = new Prolonia();
            break;
        }
    }

    @Override
    public void asignarNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void asignarAtaqueFisico() {
        this.ataque = this.nivel + this.modificadorArma + 3;
    }

    @Override
    public void asignarObjeto(String arma, String rareza) {
        this.arma = arma;
        switch (rareza) {
        case "Comun":
            this.modificadorArma = 2;
            break;

        case "Rara":
            this.modificadorArma = 3;
            break;

        case "Epica":
            this.modificadorArma = 4;
            break;

        case "Legendaria":
            this.modificadorArma = 5;
            break;
        }
        asignarAtaqueFisico();
        this.cantidadArmas += 1;
    }

    @Override
    public void asignarRango(String rango) {
        this.rango = rango;
        if (rango.equals("Kage")) {
            this.ninja.asignarNivelJutsus(4);
        }
    }

    @Override
    public void asignarNivel(int nivel) {
        this.nivel = nivel;
        this.vidaMaxima = 100 + this.nivel;
        asignarAtaqueFisico();
        if (this.vida < this.vidaMaxima) {
            this.vida = this.vidaMaxima;
        }
        if ((nivel > 2) && (nivel < 7)) {
            this.rango = "Fornin";
            this.ninja.asignarNivelJutsus(2);
        } else if (nivel > 6) {
            this.rango = "Whilenin";
            this.ninja.asignarNivelJutsus(3);
        }
    }

    public void asignarEnergia(int energia) {
        this.energia = energia;
    }

    public void asignarExperiencia(int experiencia) {
        this.experiencia += experiencia;
        this.misionesCumplidas += 1;
        if (this.experiencia > 99) {
            asignarNivel(this.nivel + 1);
            this.experiencia -= 100;
        }
    }

    public void asignarOro(int oro) {
        int oroActual = this.oro;
        this.oro = oro;

        int diferencia = this.oro - oroActual;
        if (diferencia > 0) {
            this.oroTotal += diferencia;
        }

    }

    ///////////////////////////////////////////////

    public String getNombre() {
        return this.nombre;
    }

    public int getVida() {
        return this.vida;
    }

    public int getOro() {
        return this.oro;
    }

    public int getExperiencia() {
        return this.experiencia;
    }

    public int getEnergia() {
        return this.energia;
    }

    public int getNivel() {
        return this.nivel;
    }

    public String getRango() {
        if ((this.rango.equals("Kage")) && (this.nivel > 100)) {
            return "Kage/Sennin";
        }
        if (this.nivel > 100) {
            return "Sennin";
        }
        return this.rango;
    }

    public String getArma() {
        return this.arma;
    }

    public int getModificador() {
        return this.modificadorArma;
    }

    public int getAtaque() {
        return this.ataque;
    }

    public int getLuck() {
        return this.LuckyBastard;
    }

    public void unLucky() {
        this.LuckyBastard = 0;
    }

    public Ninja getNinja() {
        return this.ninja;
    }

    public int getMaxVida() {
        return this.vidaMaxima;
    }

    public void displayJutsus() {
        System.out
                .println("\n[0] " + this.ninja.Jutsu_1 + "\n[1] " + this.ninja.Jutsu_2 + "\n[2] " + this.ninja.Jutsu_3);
    }

    public int getLevelJutsts() {
        return this.ninja.getLevelJutsts();
    }

    public int getOroTotal() {
        return this.oroTotal;
    }

    public int getCantidadArmas() {
        return this.cantidadArmas;
    }

    public int getMisionesCumplidas() {
        return this.misionesCumplidas;
    }

}