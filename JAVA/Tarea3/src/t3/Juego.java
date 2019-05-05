package t3;


import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;


public class Juego {

	public static final String ANSI_RESET = "\u001B[0m";

	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

//definir metodos: color personaje, color enemigos, color <raza>, color <clase> uwu

	public static String Blink(String text){return "\033[5m"+text+"\033[0m";}

	public static String colorPersonaje(String name){ return ANSI_YELLOW + name + ANSI_RESET; }
	public static String colorEnemigo(String name) { return ANSI_RED + name + ANSI_RESET; }

	public static void clearScreen() {
	    System.out.print("\033[H\033[2J");
	    System.out.flush();
	}
//Lanzar Dados
	public static int rollDice(int i){
		Random rand = new Random();
		int num = 0;
		switch (i) {
			case 6:
				num = rand.nextInt(6)+1;
				break;
			case 8:
				num = rand.nextInt(8)+1;
				break;
			case 20:
				num = rand.nextInt(20)+1;
				break;
		}
		return num;
	}

	public static String nameLine(String enemyName, int num){
		String Line = "";
		switch (num) {

			case 0:
				Line = "MY NAME IS "+enemyName+" THE FOOLISH, I CHALLENGE TO A DUEL FOR NO REASON WHATSOEVER";
				break;
			case 1:
				Line = "Technology is incredible! You can now store and recall items and Pokemon as data via PC!, Also my name is "+enemyName+" Let´s fight!";
				break;
			case 2:
				Line = "This isn´t very cash money of you... I'm "+enemyName+", I'm going to kill you <3";
				break;
			default:
				Line =""+enemyName;
		}
		return Line;
	}

	public static ArrayList<Enemigo> generateEnemiesList(){
		ArrayList<Enemigo> Enemies = new ArrayList<Enemigo>();
		int i;
		Enemigo Enemigo;
		for (i = 0; i < 5; i++) {
			Enemigo = new Enemigo();
			Enemies.add(Enemigo);
		}
		return Enemies;
	}


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rq = new Random();

		Jugador playerOne;
		String Name="";
		String iName="";
		String c ="";
		String r="";

		String[] classes = {"Berserker","Cleric","Mage","Rogue"};
		String[] race = {"Human","Orc","Elf","Dwarf"};
		String[] enemies = {"Klrak","Adran","Isaac","Elysium","Krrogh","Jenkins"};

		ArrayList<Enemigo> Enemies = generateEnemiesList();
		int EnemiesDefeated = 0;
		int ELine =0;

		int rand = 0;
		int angeryOmeter = 0;
		int selection = 0;

		String lastBoss = "";

		int flag = 1;

		try{
			System.out.println("\nBeautifulGameGODMasterRace: Now tell me...\nBeautifulGameGODMasterRace: Are you a boy or a gi- (0.0)/*****\nBeautifulGameGODMasterRace: nothing...\nBeautifulGameGODMasterRace: Puh-lease enter your name Adventurer");
			do{
				System.out.println("Adventurer's name:");

				iName = sc.next();
				Name = ANSI_YELLOW + iName + ANSI_RESET;

				System.out.println("BeautifulGameGODMasterRace: Are you sure you want "+ Name+" as yor name?\nIt CAN´T be changed later...\n(Select 0 or 1)\n\n[0]Yes\n[1]no");

				selection = Integer.parseInt(sc.next());

				if (selection == 0) {
					System.out.println("\nReally?\n(Select 0 or 1)\n\n[0]Yes\n[1]no");
					selection = Integer.parseInt(sc.next());
 				}

				if (selection != 1 && selection !=0){
					int miniFlag = 1;
					System.out.println("BeautifulGameGODMasterRace: Im gonna get maaad");
					do{
						clearScreen();
						System.out.println("BeautifulGameGODMasterRace: Is "+ Name +" right?\nBeautifulGameGODMasterRace: Choose either [0] or [1]\n[0]Yes\n[1]no");
						selection = Integer.parseInt(sc.next());
						if (selection == 0 || selection == 1) {
							miniFlag = 0;
						}
					}while(miniFlag !=0);
				}
				if (selection == 0) {
					flag = 0;
				}
				clearScreen();

			}while(flag != 0);

			System.out.println("BeautifulGameGODMasterRace: Ok Ok... if it's what you really want....\n");
			flag = 1;

		}catch(Exception e){
			System.out.println("\nAdventurer pls stap (> O <)/********");
			System.out.println("BeautifulGameGODMasterRace: Your name will be "+ ANSI_YELLOW +"JohnTitor" + ANSI_RESET +"\nBeautifulGameGODMasterRace: from now on....\nBeautifulGameGODMasterRace: Enjoy your adventure (> O <)/*****\n");
			Name = ANSI_YELLOW +"JohnTitor" + ANSI_RESET ;
			flag = 1;
			angeryOmeter++;
		}

		try{
			System.out.println("BeautifulGameGODMasterRace: Now... I want you to select your " + Blink("CLASS") + "... please do it well");
			do{
				System.out.println("Class:\n[0]Berserker\t\t[2]Mage\n[1]Cleric       \t[3]Rogue");
				selection = Integer.parseInt(sc.next());
				c = classes[selection];

				System.out.println("BeautifulGameGODMasterRace: Your class is " + classes[selection]+"... Is it correct?\n[0]Yes\n[1]No" );

				selection = Integer.parseInt(sc.next());

				if (selection == 0) {
					flag = 0;
				}
				clearScreen();

			}while(flag != 0);

		}catch(Exception e){
			clearScreen();
			System.out.println("\nBeautifulGameGODMasterRace: "+ Name +", BOI pls do it correctly from now on....\nBeautifulGameGODMasterRace: Now your class will be assigned Randomly (heh... stupid)");
			rand = rq.nextInt(3)+1;
			c = classes[rand];
			System.out.println("(BeautifulGameGODMasterRace: That's what you get for doing things I don't like... ( hah))\n\n");
			angeryOmeter++;

		}finally{

			System.out.println("BeautifulGameGODMasterRace: Ok!\nBeautifulGameGODMasterRace: You are a " + c+" now.\nBeautifulGameGODMasterRace: Congratulations!!!!!!!!!\n");
			flag = 1;
		}
		try{
			clearScreen();
			System.out.println("BeautifulGameGODMasterRace: Aaaaand you know the deal... Choose your " + Blink("RACE"));
			System.out.println("BeautifulGameGODMasterRace: Don't even think of screwing this up bigshot... I'll get mad");

			do{
				System.out.println("Race:\n[0]All mighty Human\t\t[2]A beautiful long eared High-Elf\n[1](Dumb) Orc\t\t\t[3]A very smart and crafty Dwarf");
				selection = Integer.parseInt(sc.next());
				System.out.println("BeautifulGameGODMasterRace: Your class is " + race[selection]+"... Is it correct?\n[0]Yes\n[1]No" );
				r = race[selection];

				selection = Integer.parseInt(sc.next());

				if (selection == 0) {
					flag = 0;
				}
				clearScreen();

			}while(flag != 0);

		}catch(Exception e){
			clearScreen();
			System.out.println("\nBeautifulGameGODMasterRace: "+ Name+", You Jerk....\nBeautifulGameGODMasterRace: Now your race will be assigned Randomly\nBeautifulGameGODMasterRace: Thank our graceful king Java-sama for providing the Random() class, ok?");
			rand = rq.nextInt(3)+1;
			r = race[rand];
			System.out.println("BeautifulGameGODMasterRace: I'm starting to get pissed off, you know\n\n");
		}finally{

			System.out.println("\nBeautifulGameGODMasterRace: Ok!\nBeautifulGameGODMasterRace: You are a " + r+" now.\nBeautifulGameGODMasterRace: Congratulations!!!!!!!!!");
			System.out.println("BeautifulGameGODMasterRace: Good for you...\nBeautifulGameGODMasterRace: Now let's begin your story "+ Name+ "!!!!!!!!");
			System.out.println("\n\n\n*Dramatic music starts*\n\n\n");
			System.out.println("BeautifulGameGODMasterRace: "+ Name + " is walking by the city of Order...\n");
			System.out.println("BeautifulGameGODMasterRace: Then... he steps on something");

		}

		/*
								Character creation
		*/
		playerOne = new Jugador(r,c,Name);
		/*
							End of Character Creation
		*/

		try{
			System.out.println("BeautifulGameGODMasterRace: Do you want to say wow?\n[0]Yes, but moderately\n[1]HECK F*ING YEAH");
			selection = Integer.parseInt(sc.next());
			clearScreen();

			if (selection != 1 && selection !=0){
				int miniFlag = 1;
				System.out.println("BeautifulGameGODMasterRace: Are you going to keep messing with me? I swear if you go on...\n");
				do{
					System.out.println("BeautifulGameGODMasterRace: Do you want to say wow?\n[0]Yes, but moderately\n[1]HECK F*CKING YEAH");
					selection = Integer.parseInt(sc.next());
					if (selection == 0 || selection == 1) {
						miniFlag = 0;
					}
				}while(miniFlag !=0);
			}

		} catch(Exception e){
			clearScreen();
			System.out.println("BeautifulGameGODMasterRace: I have an angery-o-meter you know...\nBeautifulGameGODMasterRace: it's based upon your mistakes");
			System.out.println("angery count: "+angeryOmeter+"\nangeryOmeter++;\nBeautifulGameGODMasterRace: OOPS, not supoused to show that lmao");
			System.out.println("----------------------.--------------------");
			angeryOmeter++;



		}finally{
			System.out.println("\n"+Name+":\t- WAO a sacred sword LMAO -\n");
			System.out.println("BeautifulGameGODMasterRace: Do-dododon-do-don! you recieved Lengendary armor[Lv.1] and a legendary sword[Lv.1]");
			System.out.println("BeautifulGameGODMasterRace: From Who? You say...\nBeautifulGameGODMasterRace: From me obiously");
			System.out.println("BeautifulGameGODMasterRace: I'm the god of this world\nBeautifulGameGODMasterRace: Well... Kinda");
		}

		System.out.println("\n\nBeautifulGameGODMasterRace: Anyway..."+ Name+" is doing whatever the thing it was, aaaand");
		System.out.println("BeautifulGameGODMasterRace: Boooooooom...\nBeautifulGameGODMasterRace: "+Name+ " sees someone\n");
		System.out.println("BeautifulGameGODMasterRace: Do you wanna pass RIGHT THROUGH THAT PERSON'S FIELD OF VISION?\n");
		System.out.println("[0]Yes\n[1]ABSOLUTELY YES");

		try{
			selection = Integer.parseInt(sc.next());
			clearScreen();
			if (selection != 1 && selection !=0){
				int miniFlag = 1;
				System.out.println("BeautifulGameGODMasterRace: YOU HAVE GOT TO BE F*CKING WITH ME! (Ò.Ó)");
				angeryOmeter++;
				do{
					System.out.println("BeautifulGameGODMasterRace: Do you wanna pass RIGHT THROUGH THAT PERSON'S FIELD OF VISION?\n[0]Yes\n[1]ABSOLUTELY YES");
					selection = Integer.parseInt(sc.next());
					if (selection == 0 || selection == 1) {
						miniFlag = 0;
					}
				}while(miniFlag !=0);
			}

		}catch(Exception e){
			clearScreen();
			System.out.println("\nBeautifulGameGODMasterRace: You know... the real thing is gonna appear soon if you don't start taking this HOMEWORK seriously");
			System.out.println("angery count: "+angeryOmeter);
			System.out.println("BeautifulGameGODMasterRace: YEAH BOIII CRANK IT UPPPPPPPPP\n(angery-o-meter++;)");

			System.out.println("----------------------.--------------------");
			angeryOmeter++;
		}
		int turn = 0;
		clearScreen();
		try{
			while(EnemiesDefeated < 3 && playerOne.getVida() != 0){
				/*
								Enemy selection
				*/
				rand = rq.nextInt(4)+1;
				/*
								end of Enemy selection
				*/
				turn = 1;
				System.out.println(colorEnemigo(Enemies.get(rand).getNombre().toUpperCase())+": "+nameLine(colorEnemigo(Enemies.get(rand).getNombre().toUpperCase()), ELine)+"\n");
				System.out.println("\033[1m \033[4m" + Enemies.get(rand).getNombre() + "\033[0m");
				System.out.println("Race: " + Enemies.get(rand).getRaza() + "\t" + "Class: " + Enemies.get(rand).getClase());
				System.out.println("Hability: " + Enemies.get(rand).getHabilidad());
				System.out.print("Strength: " + Enemies.get(rand).getFuerza() + "  |  ");
				System.out.print("Constitution: " + Enemies.get(rand).getConstitucion() + "  |  ");
				System.out.println("Dexterity: " + Enemies.get(rand).getDestreza());
				System.out.println("Armor: " + Enemies.get(rand).getArmadura());
				System.out.println("HP: " + Enemies.get(rand).getVida() + "\n\n");

				System.out.println("\033[1m \033[4m" + playerOne.getNombre() + "\033[0m");
				System.out.println("Race: " + playerOne.getRaza() + "\t" + "Class: " + playerOne.getClase());
				System.out.println("Hability: " + playerOne.getHabilidad());
				System.out.print("Strength: " + playerOne.getFuerza() + "  |  ");
				System.out.print("Constitution: " + playerOne.getConstitucion() + "  |  ");
				System.out.println("Dexterity: " + playerOne.getDestreza());
				System.out.println("Armor: " + playerOne.getArmadura());
				System.out.println("HP: " + playerOne.getVida());
				System.out.println("\n\nbeautifulGameGODMasterRace: Oh boi... what do you do now.....\n\n");

				do{
					//habilidad: resistencia
					System.out.println("It's turn "+turn);
					if (playerOne.getHabilidad() == "resistencia") playerOne.asignarVida(playerOne.getVida() + 1);
					if (Enemies.get(rand).getHabilidad() == "resistencia") Enemies.get(rand).asignarVida(Enemies.get(rand).getVida() + 1);

					//estado: ataque
					playerOne.setEstado('a');
					Enemies.get(rand).setEstado('a');
					System.out.println("beautifulGameGODMasterRace: C'mon do your thing");
					System.out.println("\n[0] NIGERUNDAYOOOOOO (not actually avialable bc it's the law here boi)\t[2] FIGHTING LIKE A MAN");
					System.out.println("[1] Say: 'Please lord save me' (defend)                               \t[3] Become a Super Saiya- ABSOLUTELY NOT");

					selection = Integer.parseInt(sc.next());

					if (selection == 2  || selection == 0 || selection == 3){
						if (selection == 0 || selection == 3) {
							System.out.println("beautifulGameGODMasterRace: You know that options [0] and [3] aren't actually avialable rigth?");
							System.out.println("beautifulGameGODMasterRace: They're just for the drama LOL");
							System.out.println("beautifulGameGODMasterRace: Anyway, you'll be atacking now, GET READY!");
						}
						System.out.println("\nYou selected -'ATTACK WITH ALL MY MIGHT'-");
						System.out.println("beautifulGameGODMasterRace: I choose you "+playerOne.getNombre()+"!!!!!!!!!!!");
						System.out.println("*beautifulGameGODMasterRace throws player at the enemy*\n");

						System.out.println("IT'S " + playerOne.getNombre() + "'s TURN!");
						playerOne.attack(playerOne, Enemies.get(rand));

						if (Enemies.get(rand).getVida() == 0 && EnemiesDefeated == 0){
							clearScreen();
							System.out.println("beautifulGameGODMasterRace: YOU ARE OFICIALLY AN AWFUL MONSTER. SHAME ON YOU");
							System.out.println("beautifulGameGODMasterRace: ... I mean, well done! You just won your first battle!\n[XP + 10000]");
							System.out.println("[LEVEL UP!]\n\n");
							System.out.println("beautifulGameGODMasterRace: Anyway... The story contiues, blah blah blah");
							System.out.println("beautifulGameGODMasterRace: Oh look, another rival, let's say hi (you have no other options LOL)\n\n");
							break;
						}
						else if (Enemies.get(rand).getVida() == 0 && EnemiesDefeated > 0){
							clearScreen();
							System.out.println("beautifulGameGODMasterRace: You are getting used to killing people aren't you?... SHAME ON YOU...");
							System.out.println("beautifulGameGODMasterRace: I mean, well done!\nbeautifulGameGODMasterRace: Here, have this\n[XP + 17000]");
							System.out.println("[LEVEL UP!]\n\n");
							System.out.println("beautifulGameGODMasterRace: Anyway... The story contiues, blah blah blah");
							System.out.println("beautifulGameGODMasterRace: Oh look, another rival, let's say hi (you have no other options LOL)\n\n");

							break;
						}
					}
					else if (selection == 1){
						playerOne.defend();
					}

					System.out.println("IT'S " + colorEnemigo(Enemies.get(rand).getNombre()) + "'s TURN!");
					Enemies.get(rand).attack(Enemies.get(rand), playerOne);

					if (playerOne.getVida() == 0){
						System.out.println(playerOne.getNombre()+"YOU ARE DEAD!\nbeautifulGameGODMasterRace: HAHA LOL LMAO GIT GUD!\n");
					}
					turn++;
				} while(playerOne.getVida() > 0 && Enemies.get(rand).getVida() > 0);
				if(playerOne.getVida() > 0) {
					EnemiesDefeated++;
					ELine++;
				}
			}


		}catch(Exception e){
			clearScreen();
			System.out.println("\nBeautifulGameGODMasterRace: You never learn don't you...");
			System.out.println("angery count: "+angeryOmeter);
			System.out.println("angery-o-meter++;");
			System.out.println("\nBeautifulGameGODMasterRace: You selected -'ATTACK WITH ALL MY MIGHT'-");
			System.out.println("\nBeautifulGameGODMasterRace: I choose you "+Name+ "!!!!!!!!!!!\n*BeautifulGameGODMasterRace throws player at the enemy*");
			LassBossXheroFunc(Name);
		}

		if (playerOne.getVida() == 0){
			if (angeryOmeter>=2) LassBossXheroFunc(Name);
		}

		sc.close();


	}


	public static void  LassBossXheroFunc(String Name){
		Scanner sc = new Scanner(System.in);
		int selection = 0;

		System.out.println("BeautifulGameGODMasterRace: THE EVIL DORAGON FAFNIR HAS APPEARED!!!!!!!\n\n");
		System.out.println("                                FAFNIR");

		System.out.println("HP ===============================================================");

		String Xa = "                                        .  .    `//====-              ____,-'~`\n                                               _   __,----'~~~~~~~~~`-----.__\n";
		String Xc = "                        -.            \\_|// .   /||\\\\  `~~~~`---.___./\n                  ______-==.       _-~o  `\\/    |||  \\\\           _,'`\n";
		String Xe = "            __,--'   ,=='||\\=_    ;_,_,/ _-'|-   |`\\   \\\\        ,'\n        _-'      ,='    | \\\\`.    '',/~7  /-   /  ||   `\\.     /\n";
		String Xg = "       .'       ,'       |  \\\\  \\_  ''  /  /-   /   ||      \\   /\n      / _____  /         |     \\\\.`-_/  /|- _/   ,||       \\ /\n";
		String Xi = "     ,-'     `-|--'~~`--_ \\     `==-/  `| \\'--===-'       _/`\n               '         `-|      /|    )-'\\~'      _,--'''\n";
		String Xk = "                           '-~^\\_/ |    |   `\\_   ,^             /\\\n                                /  \\     \\__   \\/~               `\\__\n";
		String Xm = "                            _,-' _/'\\ ,-'~____-'`-/                 ``===\\\n                           ((->/'    \\|||' `.     `\\.  ,                _||\n";
		String Xo = "             ./                       \\_     `\\      `~---|__i__i__\\--~'_/\n             ./                       \\_     `\\      `~---|__i__i__\\--~'_/\n";
		String Xq = "             `B'\\)                  ///,-'~`__--^-  |-------~~~~^'\n             /^>                           ///,--~`-\\\n            `  `\n";

		System.out.print(Xa+Xc+Xe+Xg+Xi+Xk+Xm+Xo+Xq);
		System.out.println(Name);
		System.out.println("HP ==================");
		System.out.println("MP ==================");


		System.out.println("\n\n(BeautifulGameGODMasterRace: that's what you get for not listening to me)");
		System.out.println("BeautifulGameGODMasterRace: What do you do?");
		System.out.println("\n[0] NIGERUNDAYOOOOOO (not actually avialable bc it's the law here boi)\t[2] FIGHTING LIKE A MAN");
		System.out.println("[1] Say: 'Please lord save me'                                        \t[3] Become a Super Saiya- ABSOLUTELY NOT");
		try{
			selection = Integer.parseInt(sc.next());
			System.out.println("\nBeautifulGameGODMasterRace: You selected -'ATTACK WITH ALL MY MIGHT'-");
			System.out.println("\nBeautifulGameGODMasterRace: I choose you Adventurer!!!!!!!!!!!\n*BeautifulGameGODMasterRace throws player at the enemy*");
		}catch(Exception e){
			System.out.println("\nBeautifulGameGODMasterRace: You selected -'ATTACK WITH ALL MY MIGHT'-");
			System.out.println("\nBeautifulGameGODMasterRace: I choose you Adventurer!!!!!!!!!!!\n*BeautifulGameGODMasterRace throws player at the enemy*");
		}finally{
			clearScreen();
			System.out.println("\n<------------To Be Continued");
			System.out.println("\nBeautifulGameGODMasterRace: Pfffff, lol I'm not gonna do such a tiring work lol as doing an entire game lol");
			System.out.println("\nBeautifulGameGODMasterRace: KTHXBYE");
			sc.close();
		}
	}
}
