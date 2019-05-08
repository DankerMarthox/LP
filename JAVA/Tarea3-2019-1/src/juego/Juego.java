package juego;



import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;
import java.lang.Math;

public class Juego {

    /// Metodos ///
    /*
    
    eleccion: Recibe una entrada numerica para la toma de decisiones del jugador. Reconoce entradas incorrectas.
    Fortuna -> abrirCaja -> displayResultado -> reemplazarArma; Secuencia de invocaciones para el resultado de una caja.
    desafiarKage: Inicia un enfrentamiento con el Kage
    realizarMision: Iniciar una mision
    menu: Menu principal del juego, de donde se eligen las opciones
    generarAldea: Retorna el nombre de alguna aldea (Random), utilizada para crear enemigos al azar
    */

    public static final String ANSI_RESET = "\u001B[0m";

    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    //TODO agregar mas frases
    public static String nameLine(String enemyName) {
        int num = ThreadLocalRandom.current().nextInt(0,6);
        String Line = "";
        switch (num) {

        case 0:
            Line = "MY NAME IS " + enemyName + " THE FOOLISH, I CHALLENGE THOU TO A DUEL FOR NO REASON WHATSOEVER";
            break;
        case 1:
            Line = "Technology is incredible! You can now store and recall items and Pokemon as data via PC!, Also my name is "
                    + enemyName + " Let´s fight!";
            break;
        case 2:
            Line = "This isn´t very cash money of you... I'm " + enemyName + ", I'm going to kill you <3";
            break;
        case 3:
            Line = "HAH... GAYYYYYYYYYYY";
        case 4:
            Line = "HAHA... YES! Тульский";
        case 5:
            Line = "MA NEM JEFFF";
        default:
            Line = "" + enemyName;
        }
        return Line;
    }
    
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    
    public int eleccion(){
        Scanner respuesta = new Scanner(System.in);
        int opcion;
        try{
            opcion = respuesta.nextInt();
        }
        catch(java.util.InputMismatchException e){
            return 0;
        }
        return opcion;
    }
     
    public void reemplazarArma(Jugador player, String nuevaRareza, String nuevaArma){
        String armaActual = player.getArma();
        int modificador = player.getModificador();
        String rareza = "";
        
//<editor-fold defaultstate="collapsed" desc="No arma previa">
        if (armaActual.equals("Nada")){
            System.out.println("Actualmente no tienes ningun arma equipada!. ¿Qué quieres hacer?");
            System.out.println("[1] Sin armas no puedo matar goblins.");

            if (nuevaRareza.equals("Legendaria")){
                System.out.println("[2] Para que quiero un arma legendaria si no puedo conquistar su corazon.");
            }

            else{
                System.out.println("[2] Las armas son para los debiles... Tiempo de usar la cabeza (literalmente).");
            }
            System.out.print("Elige una opción: ");
            int respuesta = eleccion();

            while ((respuesta > 2) || (respuesta < 1)){
                System.out.print("Opcion no valida, ingresa otra (1 o 2): ");
                respuesta = eleccion();
            }
            clearScreen();
            switch (respuesta){
                case 1:
                    player.asignarObjeto(nuevaArma, nuevaRareza);
                    System.out.println(nuevaArma + " equipada!, tu nuevo daño es " + player.getAtaque());
                    break;
                case 2:
                    System.out.println("El arma se te cayo. OOF.\n - El arma no se equipo -");
                    break;
            }
//</editor-fold>
        }
        else{
            switch (modificador){
                case 2:
                    rareza = "Comun";
                    break;
                    
                case 3:
                    rareza = "Rara";
                    break;
                    
                case 4:
                    rareza = "Epica";
                    break;
                    
                case 5:
                    rareza = "Legendaria";
                    break;
            } 
            
            System.out.println("Actualmente tienes equipado '" + armaActual + "' (" + rareza + "). ¿Quieres reemplazarla por '" + nuevaArma + "'?" );
            System.out.print("[1] SWITCH WEAPON LIKE A BABY.\n[2] SOLO LOS DEBILES CAMBIAN DE ARMA\n¿Qué quieres hacer?: ");
            int respuesta = eleccion();

            while ((respuesta > 2) || (respuesta < 1)){
                System.out.print("Opcion no valida, ingresa otra (1 o 2): ");
                respuesta = eleccion();
            }

            switch (respuesta){
                case 1:
                    switch(rareza){
                        case "Legendaria":
                            System.out.println("Rial vas a cambiar esta arma...\nok...");
                        default:
                            System.out.println("-Cambiando arma-");
                    };
                    player.asignarObjeto(nuevaArma, nuevaRareza);
                    System.out.println(nuevaArma + " Lista para romper traseros!, tu nuevo daño esta SOBRE 8000... Ah no?\n");
                    System.out.println("Pues tienes razon, este es tu nuevo damage:" + player.getAtaque());
                    break;
                case 2:
                    System.out.println("El arma no fue equipada.");
                    break;
            }                        
        }        
    }
    public void displayResultado(String arma, String rareza, Jugador player){
        switch(rareza){ 
            case "Comun":
                System.out.println("Conseguiste " + arma + "... mas rara que respirar por la nariz *inserte ironia*.\n");
                System.out.println("Hasta mi pera por el paro es mas fuerte que estas armas (LOL)");
                break;
            case "Rara":
                System.out.println("Vaya... has conseguido " + arma + " Es casi tan rara como el AGUJERO NEGRO DE MI PANTALLA.\n");
                break;
            case "Epica":
                System.out.println("¡Wow!, ¡Tienes una suerte Epica!, conseguiste una " + arma + ". Es mas rara que ver un caballo saltando en una pata.\n");
                break;
            case "Legendaria":
                System.out.println("Oh...");
                System.out.println(player.getNombre()+" Esta digievolucionando de un huevo pokemon... Ah? No? XD");
                System.out.println("¡INCREIBLE!, ¡HAS CONSEGUIDO EL LEGENDARIO FIERRO CON CLAVOS!.\n");
                System.out.println("Te apuesto a que le metiste plata al juego >:(");
                System.out.println("Mentirixxx.\nAun asi, tenia mas probabilidades de salir que un 5* en FGO");
                System.out.println("En serio... Un fierro con clavos...");
                System.out.println("Igual la espada de diamante de minecraft es mas dura ( ͡° ͜ʖ ͡°) \n");
        }
        reemplazarArma(player, rareza, arma);
    }
    
    public void abrirCaja(Jugador player){
        int random = ThreadLocalRandom.current().nextInt(1,21);
        String rareza;
        String nombreArma = "";
        if (random == 1){
            // Arma legendaria
            rareza = "Legendaria";
            nombreArma = "Fierro con Clavos";
            System.out.println("Estaba el baner de "+nombreArma+" suerte.");
        }
        else if (random < 5){
            rareza = "Epica";
            int arma = ThreadLocalRandom.current().nextInt(1,3);
            switch (arma){
                case 1:
                    nombreArma = "Guadaña";
                    break;
                case 2:
                    nombreArma = "Espada";
                    break;
            }
            System.out.println("Esta cosilla igual tiene mas proabilidades de salir");
            System.out.println("Te la cambio por una pizza, no?... ok");
            System.out.println("Estaba el baner de " + nombreArma);
        }
        else if (random < 11){
            rareza = "Rara";
            int arma = ThreadLocalRandom.current().nextInt(1,3);
            switch (arma){
                case 1:
                    nombreArma = "Fuma Shuriken";
                    break;
                case 2:
                    nombreArma = "Senbon";
                    break;
            }
            System.out.println("Si hacemos la equivalencia con los habbo creditos, creo que sales ganando");
            System.out.println("Aun asi, creo que los diamantes de minecraft valen mas");
        }
        else{
            rareza = "Comun";
            int arma = ThreadLocalRandom.current().nextInt(1,4);  
            switch (arma){
                case 1:
                    nombreArma = "Shuriken";
                    break;
                case 2:
                    nombreArma = "Kunai";
                    break;
                case 3:
                    nombreArma = "Sello explosivo";
                    break;
            }
            System.out.println("Al parecer no estas hecho para los gachas, De todas formas... Aqui tienes un palo que encontre por ahi...");
            System.out.println("Mentirix.");
        }
        
        displayResultado(nombreArma, rareza, player);
        System.out.println("Mañana se reinician los banners, vuelve pronto.");
    }
    
    public void Fortuna(Jugador player){
        int oroJugador = player.getOro();
        clearScreen();
        System.out.println("Stranger... Stranger...");
        System.out.println("ola... vendo xalas marca samsung...\npa la mami...no?");
        if (oroJugador < 299){
            System.out.println("\nNo tienes suficiente oro como para comprar una caja (Tienes solo " + oroJugador + ", pobreton).");
            System.out.println(" Intenta ganar oro completando algunas misiones (LOL).");
        }
        
        else if (oroJugador == 299){
            if (player.getLuck() == 1){
                System.out.println("\nVaya... tienes 299 de oro... Hmmmmmm.... Puedo ver que te falta 1 de Oro");
                System.out.println("Ahora te faltan 2...\n\t"+player.getNombre()+".asignarOro(298);");
                System.out.println("Bromix\n*da-dabs*");
                System.out.println("Está bien... te dejaré comprar la caja, pero solo porque te falta 1, eh?...");
                System.out.println("Consideralo una inversion... ");
                System.out.println("Has comprado una caja, y ya no tienes oro");
                player.asignarOro(0);
                abrirCaja(player);
                player.unLucky();
            }
            
            else{
                System.out.println("\n¿¡OTRA VEZ CON 299!?... Vaya a pedirle 1 de oro a su abuela *laughs at you*");
            }
        }
        else{
            clearScreen();
            System.out.println("Que manera de desperdiciar dinero... Sabes que puedes usar CCC verdad?");
            System.out.println("Que es CCC dices?... Obvio que un juego de fate...");
            System.out.println("Quiero decir... CLOSE CODE COMBAT");
            System.out.println("Siiiii... Welp... Aqui tienes tu caja.");
            System.out.println("\n-Has comprado una caja-\nWao such box\nBOI tu nuevo oro es de " + (oroJugador-300));
            System.out.println("TEST YOUR LUCK...");
            player.asignarOro(oroJugador - 300);
            abrirCaja(player);
        }
    }
    
    //TODO
    public void desafiarKage(Jugador player){
        String aldeaJugador = player.getNinja().getAldea();
        Personaje Kage = new Enemigo();
        
        Kage.asignarNinja(aldeaJugador);
        Kage.asignarNivel(15);
        Kage.asignarObjeto("Fierro con Clavos", "Legendaria");
        
        switch (aldeaJugador){
            case "Cthonia":
                Kage.asignarNombre("Ckage Papá Noel");
                break;
            case "Javania":
                Kage.asignarNombre("Javakage Pepe");
                break;
            case "Schemia":
                Kage.asignarNombre("Schekage Alabarlaalabarda Sama");
                break;
            case "Pythonia":
                Kage.asignarNombre("Pykage Comic San");
                break;
            case "Prolonia":
                Kage.asignarNombre("Prokage Porlosbor Des");
                /// INICIAR COMBATE
        }           
    }    
    public ArrayList<Enemigo> createEnemies(int level, Boolean flag){
        String[] enemies = { "Klrak", "Adran", "Isaac", "Elysium", "Krrogh", "Jenkins","Potato","Muramasacchan", "IanPom","ElPEPEENOJON" };
        ArrayList<Enemigo> Enemies = new ArrayList<Enemigo>();
        int enemyno = ThreadLocalRandom.current().nextInt(1,7);
        Enemigo Enemigo;
        int i;
        switch(level){
            case 1:
                if(enemyno > 3){
                    Enemigo = new Enemigo();
                    Enemigo.asignarNinja(generarAldea());
                    Enemigo.asignarRango("Ifnin");
                    Enemigo.asignarNombre(enemies[ThreadLocalRandom.current().nextInt(0, 10)]);
                    Enemigo.asignarNivel(1);
                    Enemies.add(Enemigo);
                }
                break;
            case 4:
                Enemigo = new Enemigo();
                Enemigo.asignarRango("Fornin");
                Enemigo.asignarNinja(generarAldea());
                Enemigo.asignarNombre(enemies[ThreadLocalRandom.current().nextInt(0, 10)]);
                Enemigo.asignarNivel(4);
                Enemies.add(Enemigo);
                break;
            case 6:
                if (flag || (enemyno < 4)) {
                    Enemigo = new Enemigo();
                    Enemigo.asignarRango("Fornin");
                    Enemigo.asignarNinja(generarAldea());
                    Enemigo.asignarNombre(enemies[ThreadLocalRandom.current().nextInt(0, 10)]);
                    Enemigo.asignarNivel(6);
                    Enemies.add(Enemigo);
                }else{
                    for(i = 0; i < 2; i++){
                        Enemigo = new Enemigo();
                        Enemigo.asignarRango("Fornin");
                        Enemigo.asignarNinja(generarAldea());
                        Enemigo.asignarNombre(enemies[ThreadLocalRandom.current().nextInt(0, 10)]);
                        Enemigo.asignarNivel(6);
                        Enemies.add(Enemigo);
                    }
                }
                break;

            case 8:
                if (flag || (enemyno < 4)) {
                    Enemigo = new Enemigo();
                    Enemigo.asignarRango("Whilenin");
                    Enemigo.asignarNinja(generarAldea());
                    Enemigo.asignarNombre(enemies[ThreadLocalRandom.current().nextInt(0, 10)]);
                    Enemigo.asignarNivel(6);
                    Enemies.add(Enemigo);
            } else {
                for (i = 0; i < 2; i++) {
                    Enemigo = new Enemigo();
                    Enemigo.asignarRango("Whilenin");
                    Enemigo.asignarNinja(generarAldea());
                    Enemigo.asignarNombre(enemies[ThreadLocalRandom.current().nextInt(0, 10)]);
                    Enemigo.asignarNivel(6);
                    Enemies.add(Enemigo);
                }
            }
            break;

            case 10:
                if (flag) {
                    Enemigo = new Enemigo();
                    Enemigo.asignarRango("Whilenin");
                    Enemigo.asignarNinja(generarAldea());
                    Enemigo.asignarNombre(enemies[ThreadLocalRandom.current().nextInt(0, 10)]);
                    Enemigo.asignarNivel(10);
                    Enemies.add(Enemigo);
                } else {
                    for (i = 0; i < 2; i++) {
                        Enemigo = new Enemigo();
                        Enemigo.asignarRango("Whilenin");
                        Enemigo.asignarNinja(generarAldea());
                        Enemigo.asignarNombre(enemies[ThreadLocalRandom.current().nextInt(0, 10)]);
                        Enemigo.asignarNivel(10);
                        Enemies.add(Enemigo);
                    }
                }
                break;
        }
        return Enemies;
    }
    
    public String repeatNTimes(String s, int n) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            builder.append(s);
        }
        return builder.toString();
    }

    public void DisplayBattlePlayer(Jugador player){
        int xd = Math.abs(player.getVida()/10);
        if(player.getVida() < 11){
            xd = 1;
        }
        System.out.println("________________________________________ ");
        System.out.println("| "+player.getNombre()+"'s Stats");
        System.out.println("|_______________________________________ ");
        System.out.println("|\tHP: " +repeatNTimes("=", xd)+ " "
                                 + player.getVida()+"\tLvl: " + player.getNivel());
        System.out.println("|\tRango: " + player.getRango()+"\tJutsus: Lvl. " + player.getLevelJutsts());
        System.out.println("|\tArma: " + player.getArma());
        System.out.print("---------------------------------------- ");
    }

    public void DisplayBattleEnemy(Enemigo e){
        int xd = Math.abs(e.getVida()/10);
        if (e.getVida() < 11) {
            xd = 1;
        }
        System.out.println("________________________________________ ");
        System.out.println("| "+ e.getNombre()+"'s Stats");
        System.out.println("|_______________________________________ ");
        System.out.println("|\tHP: "+ repeatNTimes("=", xd)+ " " + 
                                e.getVida()+"\tLvl: " + e.getNivel());
        System.out.println("|\tRango: " + e.getRango()+"\tJutsus: Lvl. " + e.getLevelJutsts());
        System.out.print("----------------------------------------");
    }

    public Boolean Battle(ArrayList<Enemigo> enemies, Jugador player, int level, Boolean second){
        int Total = enemies.size();
        Boolean won = false;
        int gorudo = 0;
        int life = player.getVida();
        int election;
        Boolean one = false;
        int rival = 0;
        switch(Total){
            case 0:
                one = true;
                break;
            case 1:
                System.out.println("\nTOMC... Vas felizmente a hacer tu misión, cuando derepente... ");
                System.out.println("\n" + enemies.get(0).getNombre() + " Te desafía a una batalla!!!!!!!");
                System.out.println("\n" + enemies.get(0).getNombre() + ": " + nameLine(enemies.get(0).getNombre()));
                while((player.getVida() > 0) && (enemies.get(0).getVida() > 0)){
                    clearScreen();
                    System.out.println("[ON BATTLE]");
                    DisplayBattleEnemy(enemies.get(0));
                    System.out.println();
                    DisplayBattlePlayer(player);

                    System.out.println("\nQue harás???... O.o");
                    System.out.println("[0] Usar la cabeza... \n[1] Dark Matter Blaze... ");
                    System.out.print("Selección: ");
                    election = eleccion();
                    while ((election > 1) || (election < 0)) {
                        System.out.print("El único trabajo que tenías lo hiciste mal");
                        System.out.print("Opcion no valida, ingresa otra (0 o 1): ");
                        election = eleccion();
                    }
                    if(election == 1){
                        System.out.print("\nElige tu técnica preferida: ");
                        player.displayJutsus();
                        System.out.print("Selección: ");
                        election = eleccion();
                        while ((election > 2) || (election < 0)) {
                            System.out.print("Pls, selecciona bien pedazo de...");
                            System.out.print("Opcion no valida, ingresa otra (0, 1 o 2): ");
                            election = eleccion();
                        }
                        System.out.print("\n"+enemies.get(0).getNombre()+": Oh no....");                        
                        System.out.print("\n" + player.getNombre() + ": Oh siii... *su wate al enemigo*");
                        enemies.get(0).asignarVida(enemies.get(0).getVida() - player.realizarAtaque(1,election));
                    }else{                        
                        System.out.print("\n"+player.getNombre()+": RASHO LAAAASER!");
                        enemies.get(0).asignarVida(enemies.get(0).getVida() - player.realizarAtaque(0,election));
                        System.out.print("\n"+enemies.get(0).getNombre()+": Gahhhhh!!!!!!, justo en la soledad.");
                    }
                    System.out.print("\n - " + enemies.get(0).getNombre() + " - Te pegó un wate");
                    System.out.print("\n" + enemies.get(0).getNombre()+": Tomá sunuvabitch, tomá...");
                    player.asignarVida(player.getVida() - enemies.get(0).realizarAtaque(0,0));
                    System.out.print("\n" + player.getNombre()+": NOooooooooOOoOoooOO....\n");

                }
                if(enemies.get(0).getVida() < 1 ) {
                    won = true;
                }
                break;
            case 2:
            //hacer String battleDialogues2()
            // este par de weones te desafian a una batalla de mitos y leyendas o una
            // batalla de gallos
            // a quien atacas primero?
            System.out.print("Espero que estés preparado para un trío...\n");            
            System.out.print("\n"+enemies.get(0).getNombre()+": Hey mister... *te agarra del hombro*");
            System.out.print("\n" + enemies.get(1).getNombre() + ": Yeah BOIIIIIIIIIIIIIIIIIIII.... *slaps yo ass*");
            while(player.getVida() > 0){
                if(won){
                    System.out.print("\nIbas caminando por ahí y encontraste lo que estabas buscando....");
                    System.out.print("Felicidades...  misión completa. Sigues siendo un manqueque btw.");
                    break;
                }
                if(enemies.size()>1){
                    System.out.println("\t\t\t[ON BATTLE]"); // esta este weon
                    DisplayBattleEnemy(enemies.get(0)); //y este otro weon
                    DisplayBattleEnemy(enemies.get(1));
                    System.out.println();
                    DisplayBattlePlayer(player);// y vo gil culiao
                    System.out.println("Who do you wanna do first?...."); // esta este weon
                    //a quien atacai enfermo ql
                    System.out.print("Liisto: "); // esta este weon
                    rival = eleccion();
                    while ((rival > 1) || (rival < 0)) {
                        System.out.print("Para de fallar xfa..\nOpcion no valida, ingresa otra (0 o 1): ");
                        rival = eleccion();
                    }
                    System.out.println("Elige tu Devil's action.");
                    System.out.print("Tipo atk: "); // esta este weon
                    //como lo atacai aweonao
                    election = eleccion();
                    while ((election > 1) || (election < 0)) {
                        System.out.print("Opcion no valida, ingresa otra (0 o 1): ");
                        election = eleccion();
                    }
                    if (election == 1) {
                        System.out.print("\nChoose your dark magik: ");
                        player.displayJutsus();
                        election = eleccion();
                        while ((election > 2) || (election < 0)) {
                            System.out.print("Opcion no valida, ingresa otra (0, 1 o 2): ");
                            election = eleccion();
                        }
                        System.out.println("\n"+player.getNombre()+": mueeeerreeeeeeee!!!!!!"); // esta este weon                        
                        System.out.println("\n"+enemies.get(rival).getNombre()+ "Gaaahhh... mi espada sagrada Excalibur...."); // esta este weon
                        enemies.get(rival).asignarVida(enemies.get(rival).getVida() - player.realizarAtaque(1, election));

                    } else {
                        System.out.println("\n"+ player.getNombre()+": ORAORAORAORAORAORAORAORA"); // esta este weon
                        System.out.println("\n"+enemies.get(rival).getNombre()+": MUDAMUDAMUDAMUDAMUDAMUDA....."); // esta este weon
                        enemies.get(rival).asignarVida(enemies.get(rival).getVida() - player.realizarAtaque(0, election));
                    }
                    System.out.println("\n" + enemies.get(0).getNombre()+": ROAD ROLLER DAAAAAAAAA");
                    System.out.print("\n - " + enemies.get(0).getNombre() + " - Te pegó un wate");
                    System.out.println("\n"+ enemies.get(1).getNombre()+": JUTSU DE INVOCACIÓN..... MENDOZAAAAAAAA!!!!");
                    System.out.print("\n - " + enemies.get(1).getNombre() + " - Te pegó un wate");
                    System.out.println("\n" + player.getNombre() + ": NOOOOOOOOOOOOOOOOO....");                    
                    player.asignarVida(player.getVida() - enemies.get(0).realizarAtaque(0, 0));
                    player.asignarVida(player.getVida() - enemies.get(1).realizarAtaque(0, 0));

                }else{
                    //parte con unn solo weon
                    System.out.println("HAH, Solo te falta uno... ponle weno");
                    System.out.println("[ON BATTLE]");
                    DisplayBattleEnemy(enemies.get(0));
                    System.out.println();
                    DisplayBattlePlayer(player);

                    System.out.println("\nQue harás???... O.o");
                    System.out.println("[0] Su phisical_CCC?... \n[1] Star burst stream... ");
                    election = eleccion();
                    while ((election > 1) || (election < 0)) {
                        System.out.print("Opcion no valida, ingresa otra (0 o 1): ");
                        election = eleccion();
                    }
                    if (election == 1) {
                        System.out.print("\nChoose your dark magik: ");
                        player.displayJutsus();
                        election = eleccion();
                        while ((election > 2) || (election < 0)) {
                            System.out.print("Opcion no valida, ingresa otra (0, 1 o 2): ");
                            election = eleccion();
                        }
                        System.out.println("\n" + enemies.get(0).getNombre() + ": Te acercas a mí....");
                        System.out.println("\n" + player.getNombre()+": (I can't beat the sh*t out of you without getting closer)-NO JUTSU.... ORAAA");
                        enemies.get(0).asignarVida(enemies.get(0).getVida() - player.realizarAtaque(1, election));
                    } else {
                        System.out.println("\n" + player.getNombre() + ": TOMA TU 20 EN EL CERTAMEN!");
                        System.out.println("\n" + enemies.get(0).getNombre() + ": Por qué me haces esto, Solaaaar. *hwrrgggmm*");
                        enemies.get(0).asignarVida(enemies.get(0).getVida() - player.realizarAtaque(0, election));
                    }
                    System.out.print("\n - " + enemies.get(0).getNombre() + " - Te pegó un wate");
                    System.out.print("\n" + enemies.get(0).getNombre() + ": Katon... PASAR MATE A LA 3ra-NO JUTSU");
                    System.out.print("\n - " + player.getNombre() + " - NOOOOOOO ME CONVERTÍ EN EL CHAQUETAAAA\n");
                    player.asignarVida(player.getVida() - enemies.get(0).realizarAtaque(0, 0));
                }
                if (enemies.get(0).getVida() < 1 && enemies.get(1).getVida() < 1) {
                    won = true;
                }
            }
            break;
        }
        if (!second && one){
            player.asignarExperiencia(10);
            System.out.println("Has ganado " + 10 + " exp.");
            gorudo = ThreadLocalRandom.current().nextInt(5, 11);
            player.asignarOro(player.getOro() + gorudo);
            System.out.println("Te has ganado " + gorudo + " de oro.\n\n[MISSION COMPLETE]\n");
        }else if (!second && won) {
            System.out.println(
                    "Estuvo buena la pelea, + 10 y a favoritos. " + player.getNombre() + "\nCompetaste la mision!");
            switch (level) {
            case 1:
                player.asignarExperiencia(10);
                System.out.println("Has ganado "+10+" exp.");
                gorudo = ThreadLocalRandom.current().nextInt(5, 11);
                break;
            case 4:
                player.asignarExperiencia(30);
                System.out.println("Has ganado " + 30 + " exp.");
                gorudo = ThreadLocalRandom.current().nextInt(20, 31);
                break;
            case 6:
                player.asignarExperiencia(45);
                System.out.println("Has ganado " + 45 + " exp.");
                gorudo = ThreadLocalRandom.current().nextInt(50, 81);
                break;
            case 8:
                player.asignarExperiencia(70);
                System.out.println("Has ganado " + 70 + " exp.");
                gorudo = ThreadLocalRandom.current().nextInt(100, 121);
                break;
            case 10:
                player.asignarExperiencia(100);
                System.out.println("Has ganado " + 100 + " exp.");
                gorudo = ThreadLocalRandom.current().nextInt(130, 161);
                break;
            }
            System.out.println("Te has ganado " + gorudo + " de oro.\n\n[MISSION COMPLETE]\n");
            System.out.println("Máquina... Troesma... Campeón... Dios... Genio... (LOL)\nTe regeneraré tu vida. ;)");
            System.out.println("[HEALING]");
            System.out.println("\n\t"+player.getNombre()+".asignarvida(" + player.getMaxVida() + ").\n");
            player.asignarOro(player.getOro() + gorudo);
            player.asignarVida(player.getMaxVida());

        }else if (!second && !won){
            System.out.println("\n\t"+player.getNombre()+": I need healing...");
            System.out.println("[YOU LOSE]\nPerdedor... manqueque te apuesto a que eres ifnin.\nTe regeneraré tu vida, pero que no se vuelva a repetir ah?...");
            System.out.println("[HEALING]");
            player.asignarVida(player.getMaxVida());
            System.out.println("\n\t" + player.getNombre() + ".asignarvida(" + life + ").\n");
        }
        if(won){
            return true;
        }else{
            return false;
        }
    }

    public void realizarMision(Jugador player){
        /// Misiones por definir ///
        int enemiesLv = 1;
        Boolean won = false;
        ArrayList<Enemigo> Enemies;
        ArrayList<Enemigo> Enemies2;
        ArrayList<Enemigo> Enemies3;
        clearScreen();
        System.out.println("Con que quieres hacer una mision... No te emociones mucho si eres un ifnin.");
        System.out.println("Me imagino que ya sabes, pero tenemos 5 tipos de ellas:");
        System.out.println("  Tipos:\n\t[0] D (Para los manqueques... Digo, para los nuevos jugadores)");
        System.out.println("\t[1] C (Para los niños bacanes)");
        System.out.println("\t[2] B (Para los adultos mayores que creen que aún son jóvenes)");
        System.out.println("\t[3] A (Para los que llevan más de 40 horas de farmeo total)");
        System.out.println("\t[4] S (Para los que piensan que son buenos... y lo son)");
        System.out.println("\t[5] SADISTIC (HARDCORE PLAYERS ONLY)(EL NIVEL CINCO ES INVENCIBLE)(YO SE QUE QUIERES...)");
        System.out.print("\nSecciona el nivel de la misión: ");
        
        int selection = eleccion();
        
        while ((selection > 5) || (selection < 0)) {
            System.out.print("Opcion no valida, ingresa otra (0 al 5): ");
            selection = eleccion();
        }
        clearScreen();
        System.out.println("\nOk. Elige entre estas misiones.");
        switch(selection){
            case 0:
                System.out.println("\n\t[0] Encontrar al gato de la señora Puff.\n\t[1] Entrega del Little Caesar's.");
                selection = eleccion();
                while ((selection > 1) || (selection < 0)) {
                    System.out.print("Opcion no valida, ingresa otra (0 al 1): ");
                    selection = eleccion();
                }
                Enemies = createEnemies(1,false);
                won = Battle(Enemies, player, 1,false);
                break;
            case 1:
                System.out.println("\n\t[0] Obtener un 5* en FGO [MEGADIFICIL].\n\t[1] Entregar mi tarea de JAVA.");
                selection = eleccion();
                while ((selection > 1) || (selection < 0)) {
                    System.out.print("Opcion no valida, ingresa otra (0 al 1): ");
                    selection = eleccion();
                }
                Enemies = createEnemies(4,false);
                if(player.getNivel() < 4) {
                    System.out.println("\nYo creo que deberías farmear más... [NIVEL INSUFICIENTE]"); 
                    System.out.println("\nPero igual la harás... Arpende a la mala");
                }
                won = Battle(Enemies, player, 4, false);
                break;
            case 2:
                //flag
                Enemies = createEnemies(6,false);
                Enemies2 = createEnemies(6,true);
                System.out.println("\n\t[0] Asesinar al asesino que asesinó a Abaccio.\n\t[1] Entrega de la cabeza de Marie Antoinette. (WAZZUP MY HOMIES)");
                selection = eleccion();
                while ((selection > 1) || (selection < 0)) {
                    System.out.print("Opcion no valida, ingresa otra (0 al 1): ");
                    selection = eleccion();
                }
                if (player.getNivel() < 6) {
                    System.out.println("\nYo creo que deberías farmear más... [NIVEL INSUFICIENTE]"); 
                    System.out.println("\nPero igual la harás... Arpende a la mala");
                }if(Battle(Enemies, player, 6, false) && Battle(Enemies2, player, 6, false)){
                    won = true;
                }
                break;
            case 3:
                Enemies = createEnemies(8, false);
                Enemies2 = createEnemies(8, false);
                System.out.println("\n\t[0] Robarle el sombrero papal al papa para acabr con THE GAME! (A que perdiste).\n\t[1] Encontrar el Santo Grial y entregárselo a Gallahad.");
                if (player.getNivel() < 8) { 
                    System.out.println("\nYo creo que deberías farmear más... [NIVEL INSUFICIENTE]"); 
                    System.out.println("\nPero igual la harás... Arpende a la mala");
                }
                selection = eleccion();
                while ((selection > 1) || (selection < 0)) {
                    System.out.print("Opcion no valida, ingresa otra (0 al 1): ");
                    selection = eleccion();
                }
                if(Battle(Enemies, player, 8, false) && Battle(Enemies2, player, 8, false)){
                    won = true;
                }else{
                    won = false;
                }
                break;
            case 4:
                Enemies = createEnemies(10, false);
                Enemies2 = createEnemies(10,false);
                Enemies3 = createEnemies(10, true);
                System.out.println(
                    "\n\t[0] Salto interdimensional hacia la 11va dimención para asesinar seres del plano astral.\n\t[1] Entregar las gemas del infinito a PURPLE BOI.");
                if(player.getNivel() < 10) { 
                    System.out.println("\nYo creo que deberías farmear más... [NIVEL INSUFICIENTE]"); 
                    System.out.println("\nPero igual la harás... Arpende a la mala"); 
                }
                selection = eleccion();
                while ((selection > 1) || (selection < 0)) {
                    System.out.print("Opcion no valida, ingresa otra (0 al 1): ");
                    selection = eleccion();
                }
                if(Battle(Enemies, player, 10, false) && Battle(Enemies2, player, 10, false) && Battle(Enemies3, player, 10, false)){
                    won = true;
                }else{
                    won = false;
                }
                break;
            case 5:
                System.out.println("\n\t MISION UNICA: DERROTAR UNA DE LAS BESTIAS DE MARTIN [Lv. 50]");
                if(player.getNivel()>49){
                    selection = eleccion();
                    while ((selection > 1) || (selection < 0)) {
                        System.out.print("Opcion no valida, ingresa otra (1): ");
                        selection = eleccion();
                    }
                    LassBossXheroFunc(player);
                }else{
                    System.out.println("\nYo creo que deberías farmear más... [NIVEL INSUFICIENTE][SORRY][SELECT ANOTHER ONE]");
                }
                break;
        }
        System.out.println("[END OF MISSION]\n");
        player.asignarEnergia(player.getEnergia() - 5);
    }
    
    public void menu(Jugador player){
        System.out.println("\nNivel: " + player.getNivel() + "  Experiencia: " + player.getExperiencia() + "/100" + "  Rango: " + player.getRango());
        System.out.println("Salud: " + player.getVida()+ "/" + player.getMaxVida() + "  Daño físico: " + player.getAtaque() + "  Arma: " + player.getArma());
        System.out.println("Energía:" + player.getEnergia() + "\nOro: " + player.getOro() + "\n");
        System.out.println("¿Qué deseas hacer?");
        System.out.println("[1] Su misioncita, perritz?\n[2] GACHA ROLLS");
        
        if ((player.getNivel() < 11) || (player.getRango().equals("Kage"))){
            System.out.print("[3] Dejar el juego como un pérdedor.\nElige una acción: ");
            int respuesta = eleccion();    
            while (((respuesta > 3) || (respuesta < 1)) && (respuesta != 48947)){ //DEBUG ONLY
                System.out.print("Opcion no valida, ingresa otra (1, 2 o 3): ");
                respuesta = eleccion();
            }
            
            switch (respuesta){
                case 1:
                    realizarMision(player);
                    break;
                case 2:
                    System.out.println("DEBUG -- SE INICIO COMPRA");
                    Fortuna(player);
                    break;
                case 3:
                    System.exit(0);
                    break;
                case 48947:
                    System.out.println("\nAhhhhh... Conoces la llave... Skedush!");
                    System.out.println("\n\t"+player.getNombre()+".asignarOro("+ player.getOro()+" + 20000)");
                    player.asignarOro(player.getOro() + 20000);
                    break;
            }
        }
        
        else{
            System.out.print("[3] IM THE STRONGEST MOTHERFUCKER IN THE WORLD... -->KAGE BATTLE<--\n[4] Su casita???\nTu acción: ");
            int respuesta = eleccion();

            //while ((respuesta > 4) || (respuesta < 1)){
            
            while (((respuesta > 4) || (respuesta < 1)) && (respuesta != 48947)){ //DEBUG ONLY
                System.out.print("Opcion no valida, ingresa otra (1 a 4): ");
                respuesta = eleccion();
            }
            
            switch (respuesta){
                case 1:
                    realizarMision(player);
                    break;
                case 2:
                    Fortuna(player);
                    break;
                case 3:
                    desafiarKage(player);
                    break;
                case 4:
                    System.exit(0);
                    break;
                case 48947:
                    System.out.println("\nAhhhhh... Conoces la llave... Skedush!");
                    System.out.println("\n\t" + player.getNombre() + ".asignarOro(" + player.getOro() + " + 20000)");
                    player.asignarOro(player.getOro() + 20000);
                    break;
            }            
            
        }
    }    
    
    public String generarAldea(){
        int aldea = ThreadLocalRandom.current().nextInt(1,6);
        String nombreAldea = "";
        switch (aldea){
            case 1:
                nombreAldea = "Cthonia";
                break;
            case 2:
                nombreAldea = "Javania";
                break;
            case 3:
                nombreAldea = "Prolonia";
                break;
            case 4:
                nombreAldea = "Pythonia";
                break;
            case 5:
                nombreAldea = "Schemia";
                break;
        }
        return nombreAldea;
    }
    
    public static void main(String[] args) {
        
        Juego Game = new Juego();
        
        Jugador player = new Jugador();
        player.asignarOro(899);
        System.out.println("WELCOME TO THE LEAGUE OF DRAVEN...\n oops. Olvida lo que dije");
        System.out.println("Are you a boy... or a girl?... Tampoco");
        System.out.println("AHHHHH, ya, ya sé.");
        System.out.println("Has escuchado de la Super Guerra verdad?... no?... y la guerra contra los canguros?");
        System.out.println("La USM te ha reclutado con el fin de - Ser el mejor maestro pokemon - Digo, ganar la guerra ps");
        System.out.println("Como se origino?... \nFue el resultado de los paros indefinidos...");
        System.out.println("Al principio todo era risas y juegos, hasta que la nacion de los certamenes ataco...");
        System.out.println("No necesitas saber mas... Mejor dicho, lo entenderás después.");
        System.out.println("Hace frio...");
        
        System.out.println("Necesitamos algunos de tus datos.");


        /// Asignacion de Nombre
        System.out.println("\nComo te haces llamar?: ");

        int nameFlag = 1;
        int selection = 0;
        String nombre;
        Scanner sc;
        try{
            do{
                sc = new Scanner(System.in);
                nombre = ANSI_YELLOW + sc.next() + ANSI_RESET;
                System.out.println("\n"+nombre + "... Es esto correcto?\n\n[0]no\n[1]si");
                selection = Integer.parseInt(sc.next());

                if(selection == 0){
                    System.out.println("Ingresa tu nombre nuevamente. No hagas que falle pls.");
                    System.out.println("No sera como la tarea que tenia un nivel secreto con un doragon.");

                }
                if (selection != 1 && selection != 0) {
                    int miniFlag = 1;
                    System.out.println("Por favor, selecciona correctamente.");
                    do {
                        System.out.println("Es " + nombre
                                + " correcto?\n\n[0]no\n[1]si");
                        selection = Integer.parseInt(sc.next());
                        if (selection == 0 || selection == 1) {
                            miniFlag = 0;
                        }
                    } while (miniFlag != 0);
                }
                if (selection == 1) {
                    nameFlag = 0;
                }
            }while(nameFlag != 0);
        }catch(Exception e){
            clearScreen();

            System.out.println("\nMilagrosamente has fallado tu nombre...");
            nombre = ANSI_YELLOW+"PEPE"+ANSI_RESET;
            System.out.println("Se te asignara uno nuevo, digamos... "+nombre);
            System.out.println("Que te parece?...\nNo importa");
        }
        player.asignarNombre(nombre);
        
        /// Eleccion de aldea
        System.out.println("\nExelente, " + player.getNombre() + "\n\nAhora, selecciona tu aldea de origen (los numeros).");
        String aldea1 = "Cthonia", aldea2 = "Javania", aldea3 = "Prolonia", aldea4 = "Pythonia", aldea5 = "Schemia";
        System.out.print("[1] " + aldea1 + "\n[2] " + aldea2 + "\n[3] " + aldea3 + "\n[4] " + aldea4 + "\n[5] " + aldea5 + "\nIngresa tu elección: ");
        int eleccionAldea = Game.eleccion();
        
        while ((eleccionAldea > 5) || (eleccionAldea < 1)){
            System.out.print("Opcion no valida, ingresa otra (1 a 5): ");
            eleccionAldea = Game.eleccion();
        }
        
        switch (eleccionAldea){
            case 1:
                player.asignarNinja(aldea1);
                break;
            case 2:
                player.asignarNinja(aldea2);
                break;
            case 3:
                player.asignarNinja(aldea3);
                break;
            case 4:
                player.asignarNinja(aldea4);
                break;
            case 5:
                player.asignarNinja(aldea5);
                break;
        }
        clearScreen();
        System.out.println("Perfecto, comencemos la simulacion");
        System.out.println("UWU");
        
        while(player.getEnergia() > 0){
            Game.menu(player);
        }
        
        System.out.println("\n\nDEBBUG\nSe acabó la energía");
        
        ///
        
        
    }
	public static void  LassBossXheroFunc(Jugador Name){
		Scanner sc = new Scanner(System.in);
		int selection = 0;

		System.out.println(" THE LEGENDARY ZORRON PERRIN HAS APPEARED!!!!!!!\n\n");
		System.out.println("                               PERRIN EL ZORRON");

		System.out.println("HP ===============================================================\n\t 370.000.000");

		
        String x_a = "     ,  . \n";
        String x_b = "    .'..''.                                                   .' .'.\n";
        String x_c = "  . ' '.   :                                                  ;' ;':. \n";
        String x_d = "  ;'.  '.   ';,                                            _.-= ;~ /_   \n";
        String x_f = "  ';  ';. '.    ';.._                                    _-~  '     ..;.  \n";
        String x_g = "   '.     ';;;'.     ':.                               _.-~  '   .'-~-~`-._ \n";
        String x_h = ".'. :=;     '';;' .,   '';.                     _.--~~:.             --.____88\n";
        String x_i = ";  ';;:..     '';.__'_    ''';;.__.....--~~. .' .              _..-------~~     \n";
        String x_j = " ;.    '''          ':. :._..--~~                               ,'                \n";
        String x_k = "   ;.      ''''.....  , .__ _.-~                 .            ,'   \n";
        String x_l = "     ';_.....'''''..::'.'                        :.          ./      \n";
        String x_m = ".;'''         .:'   .:   ,/  `                  ::.        ,'          \n";
        String x_n = "''';;;;_,'' .:' ,(             ;.                 ::.   ,-'       \n";
        String x_o = "     _.'~      './'`.      . . /:::._______..... _/:.o/             \n";
        String x_p = "<_.'~     ...'/./'...)   . _.,'               `88;?88|                \n";
        String x_q = " ';;;::=''  ,.,/'._,-~ /_.o8P'                88P ?8b                   \n";
        String x_r = "     _,'' . .,/' ,-~    d888P'                  88'  88|                  \n";
        String x_s = "  _.'~  . ., :oP'      ?88b              _..--- 88.--'8b.--..__       \n";
        String x_t = "<     ...'   88o __,---.88o ...__..._.=~- .    `~~   `~~      ~-._.     \n";
        String x_u = " ';;;:='      ~~         ~~~                ~-    -       -   -           \n";

        System.out.println(x_a+x_b+x_c+x_d+x_f+x_g+x_h+x_i+x_j+x_k+x_l+x_m+x_n+x_o+x_p+x_q+x_r+x_s+x_t+x_u);

		System.out.println(Name.getNombre());
		System.out.println("\nNivel: " + Name.getNivel() + "  Experiencia: " + Name.getExperiencia() + "/100"
                + "  Rango: " + Name.getRango());
        System.out.println("Salud: " + Name.getVida() + "/" + Name.getMaxVida() + "  Daño físico: "
                + Name.getAtaque() + "  Arma: " + Name.getArma());
        System.out.println("Energía:" + Name.getEnergia() + "\nOro: " + Name.getOro() + "\n");

		System.out.println("Que haces?");
		System.out.println("\n[0] NIGERUNDAYOOOOOO (Mentirix porque razones BOI)\t[2] PELEAR COMO EL MACHOTE QUE ERES");
		System.out.println("[1] Ayudante, ayudeme pofavoh'                      \t[3] Go Super Saiya- NOPE");
		try{
			selection = Integer.parseInt(sc.next());
			System.out.println("\nElegiste: -'PELEAR COMO EL MACHOTE QUE ERES'-");
			System.out.println("\nI choose you" + Name.getNombre()+"! *Te tira al Zorron*");
		}catch(Exception e){
			System.out.println("\nYou selected -'PELEAR COMO EL MACHOTE QUE ERES'-");
			System.out.println("\nI choose you" + Name.getNombre()+"! *Te tira al Zorron*");
		}finally{
			clearScreen();
			System.out.println("\n<------------To Be Continued");
			System.out.println("\nPfffff, lol I'm not gonna do such a tiring work lol as doing an entire game lol");
			System.out.println("\nKTHXBYE");
			
		}
       // sc.close();
    }
}
