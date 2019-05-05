package t3;

public class Picaro extends Clase {

    int armadura;
    char estado;

    /*
                Rogue
    Attack type:    Body
    Skill:          Dexterity
    Armor:          10
    */

    public void setArmaduraClass(int armor){
        this.armadura = armor;
    }

    public int getArmaduraClass(){
        return this.armadura;
    }

    public void setEstadoClass(char s){
        this.estado = s;
    }

    public char getEstadoClass(){
        return this.estado;
    }

    public Picaro(){
        crearClase();
    }

    public void crearClase(){
        setArmaduraClass(10);
    }

    public void ataque(Personaje j, Personaje e){   //puede atacar el jugador o el enemigo


        int dAt = 0;    //decide si se efectua el ataque
        int dDa = 0;    //daño efectuado
        int DD = 0;     //doble daño

        dAt = Juego.rollDice(20);

        if (j.getHabilidad() == "suerte" && dAt == 1){
            while (dAt == 1) dAt = Juego.rollDice(20);
        }

        System.out.println("\nFirst roll: "+dAt);

        if (e.getEstado() == 'd'){
            System.out.println(e.getNombre() + " is on defense mode!");

            int dAt2;
            dAt2 = Juego.rollDice(20);

            if (j.getHabilidad() == "suerte" && dAt2 == 1){
                while (dAt2 == 1) dAt2 = Juego.rollDice(20);
            }

            System.out.println("Second roll: "+dAt2);

            if (dAt2 < dAt) dAt = dAt2;
        }

        System.out.println(j.getNombre() +"'s CHOSEN LUCKY NUMBER: " + dAt);

        if (dAt == 20) DD = 1;

        if ((j.getHabilidad() != "Atacante" && dAt >= e.getArmadura()) || (j.getHabilidad() == "Atacante" && dAt >= 2)){

            dDa = Juego.rollDice(8);
            System.out.println("Damage roll: "+dDa);
            dDa += j.getFuerza();
            System.out.println("Strength bonus! +"+j.getFuerza());

            if (DD == 1){     //daño duplicado
                dDa *= 2;
                System.out.println("\n\n\t\tDOUBLE DAMAGE!!!!!\t\t\n\n");
            }
        }
        else{
            if (j.getHabilidad() == "Atacante") System.out.println("Attacker! You got less than 2...");
            System.out.println(j.getNombre()+"! You missed miserably...");
        }

        if (dDa > 0){
            e.asignarVida(e.getVida() - dDa);
            if (e.getVida() > 0){
                System.out.println(e.getNombre() + " HP: " + e.getVida()+"\n\n");
            }
            else{
                e.asignarVida(0);
                System.out.println(e.getNombre() + " IS DEAD!! " + j.getNombre()+ " KILLED HIM/HER!\n\n");
            }
        }
        else{
            System.out.println(j.getNombre() + " didn't hurt " + e.getNombre() + "c:");
            System.out.println(e.getNombre() + " HP: " + e.getVida()+"\n\n");
        }
    }

    public void defender(){
        this.setEstadoClass('d');
    }

}
