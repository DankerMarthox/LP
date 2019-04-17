#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "navidad.h"
#include "polinomio.h"
typedef struct{
	int tipoDeCodificacion;
	void* carta;
}pedido;
//este es un comentario

void* decodificacion(void* (*codigo)(char*), char* carta){
    return (*codigo)(carta);
}
void* codigoUno(char* cartas){
    int indice = 0, charIndex;
    regalos *Regalo = calloc(1, sizeof(regalos));
    char *nombre = calloc(50, sizeof(char)), *regalo = calloc(70, sizeof(char));
    while (cartas[indice] != ' '){
        nombre[indice] = cartas[indice];
        indice++;
    }
    if (cartas[indice] == ' '){
        nombre[indice] = '~';
        indice++;
    }
    Regalo->nombre = nombre;
    int bondad = cartas[indice]-'0';
    if (bondad < 5){
        char obsequio[7] = "Carbon~";
        for (charIndex = 0 ; charIndex < 7 ; charIndex++) regalo[charIndex] = obsequio[charIndex];
        Regalo->regalo = regalo;
    }
    else{
        char tipoJuego = cartas[indice+2], juego = cartas[indice+4];
        if (tipoJuego == '0'){
            if (juego == 'A'){
                char obsequio[20] = "Tumanji~";
                for (charIndex = 0 ; charIndex < 20 ; charIndex++) regalo[charIndex] = obsequio[charIndex];
                Regalo->regalo = regalo;
            }
            if (juego == 'B'){
                char obsequio[20] = "Comunopoly~";
                for (charIndex = 0 ; charIndex < 20 ; charIndex++) regalo[charIndex] = obsequio[charIndex];
                Regalo->regalo = regalo;
            }
            if (juego == 'C'){
                char obsequio[30] = "Caracoles Y Dragones~";
                for (charIndex = 0 ; charIndex < 30 ; charIndex++) regalo[charIndex] = obsequio[charIndex];
                Regalo->regalo = regalo;
            }
            if (juego == 'D'){
                char obsequio[20] = "ADIVINAKIEM~";
                for (charIndex = 0 ; charIndex < 20 ; charIndex++) regalo[charIndex] = obsequio[charIndex];
                Regalo->regalo = regalo;
            }
            if (juego == 'E'){
                char obsequio[20] = "No Sabi Na~";
                for (charIndex = 0 ; charIndex < 20 ; charIndex++) regalo[charIndex] = obsequio[charIndex];
                Regalo->regalo = regalo;
            }
            if (juego == 'F'){
                char obsequio[20] = "Dibuja Bien Porfa~";
                for (charIndex = 0 ; charIndex < 20 ; charIndex++) regalo[charIndex] = obsequio[charIndex];
                Regalo->regalo = regalo;
            }
            if (juego == 'G'){
                char obsequio[20] = "PiumPium~";
                for (charIndex = 0 ; charIndex < 20 ; charIndex++) regalo[charIndex] = obsequio[charIndex];
                Regalo->regalo = regalo;
            }
        }
        if (tipoJuego == '1'){
            if (juego == 'A'){
                char obsequio[40] = "ContraAtaque: Ofensiva Global~";
                for (charIndex = 0 ; charIndex < 40 ; charIndex++) regalo[charIndex] = obsequio[charIndex];
                Regalo->regalo = regalo;
            }
            if (juego == 'B'){
                char obsequio[30] = "Monstruos de Bolsillo~";
                for (charIndex = 0 ; charIndex < 30 ; charIndex++) regalo[charIndex] = obsequio[charIndex];
                Regalo->regalo = regalo;
            }
            if (juego == 'C'){
                char obsequio[40] = "Mantengan la calma y nadie explotara~";
                for (charIndex = 0 ; charIndex < 40 ; charIndex++) regalo[charIndex] = obsequio[charIndex];
                Regalo->regalo = regalo;
            }
            if (juego == 'D'){
                char obsequio[20] = "Pato Juego~";
                for (charIndex = 0 ; charIndex < 20 ; charIndex++) regalo[charIndex] = obsequio[charIndex];
                Regalo->regalo = regalo;
            }
            if (juego == 'E'){
                char obsequio[50] = "Almas negras: Edicion Preparate para morir~";
                for (charIndex = 0 ; charIndex < 50 ; charIndex++) regalo[charIndex] = obsequio[charIndex];
                Regalo->regalo = regalo;
            }
            if (juego == 'F'){
                char obsequio[35] = "HOLA HOLA! Club de literatura~";
                for (charIndex = 0 ; charIndex < 35 ; charIndex++) regalo[charIndex] = obsequio[charIndex];
                Regalo->regalo = regalo;
            }
            if (juego == 'G'){
                char obsequio[20] = "Equipo Fortaleza 2~";
                for (charIndex = 0 ; charIndex < 20 ; charIndex++) regalo[charIndex] = obsequio[charIndex];
                Regalo->regalo = regalo;
            }
        }
    }
    return Regalo;
}
void* codigoDos(char* cartas){
    int charIndex;
    regalos *Regalo = calloc(1, sizeof(regalos));
    char *nombre = calloc(50, sizeof(char)), *regalo = calloc(70, sizeof(char));
    char readCarta;
    readCarta = cartas[0];
    int index;
    for (index = 3 ; index < 50 ; index++){
        if (cartas[index+2] == 0){
            nombre[index-3] = '~';
            break;
        }
        else nombre[index-3] = cartas[index];
    }
    Regalo->nombre = nombre;
    if (readCarta -'0' >= 5){
        char obsequio[10] = "Carbon~";
        for (charIndex = 0 ; charIndex < 10 ; charIndex++) regalo[charIndex] = obsequio[charIndex];
        Regalo->regalo = regalo;
    }
    else{
        char tipoRegalo = cartas[1];
        char primeraLetra = cartas[index], segundaLetra = cartas[index+1];
        if (tipoRegalo == '0'){
            if ((primeraLetra == 'A') && (segundaLetra == 'A')){
                char obsequio[30] = "Homeworks for dummies~";
                for (charIndex = 0 ; charIndex < 30 ; charIndex++) regalo[charIndex] = obsequio[charIndex];
                Regalo->regalo = regalo;
            }
            if ((primeraLetra == 'A') && (segundaLetra == 'B')){
                char obsequio[15] = "Heartless~";
                for (charIndex = 0 ; charIndex < 15 ; charIndex++) regalo[charIndex] = obsequio[charIndex];
                Regalo->regalo = regalo;
            }
            if ((primeraLetra == 'A') && (segundaLetra == 'C')){
                char obsequio[20] = "Fapelusho~";
                for (charIndex = 0 ; charIndex < 20 ; charIndex++) regalo[charIndex] = obsequio[charIndex];
                Regalo->regalo = regalo;
            }
            if ((primeraLetra == 'B') && (segundaLetra == 'A')){
                char obsequio[30] = "Fairy Tales of Tomc~";
                for (charIndex = 0 ; charIndex < 30 ; charIndex++) regalo[charIndex] = obsequio[charIndex];
                Regalo->regalo = regalo;
            }
            if ((primeraLetra == 'B') && (segundaLetra == 'B')){
                char obsequio[20] = "A Sad World~";
                for (charIndex = 0 ; charIndex < 20 ; charIndex++) regalo[charIndex] = obsequio[charIndex];
                Regalo->regalo = regalo;
            }
            if ((primeraLetra == 'B') && (segundaLetra == 'C')){
                char obsequio[25] = "Game of Pointers~";
                for (charIndex = 0 ; charIndex < 25 ; charIndex++) regalo[charIndex] = obsequio[charIndex];
                Regalo->regalo = regalo;
            }
            if ((primeraLetra == 'C') && (segundaLetra == 'A')){
                char obsequio[68] = "The Lord of The Ravs: The Fellowship of the LDS~";
                for (charIndex = 0 ; charIndex < 68 ; charIndex++) regalo[charIndex] = obsequio[charIndex];
                Regalo->regalo = regalo;
            }
            if ((primeraLetra == 'C') && (segundaLetra == 'B')){
                char obsequio[30] = "The Chronicles of Cthonia~";
                for (charIndex = 0 ; charIndex < 30 ; charIndex++) regalo[charIndex] = obsequio[charIndex];
                Regalo->regalo = regalo;
            }
            if ((primeraLetra == 'C') && (segundaLetra == 'C')){
                char obsequio[20] = "The end of Sansano~";
                for (charIndex = 0 ; charIndex < 20 ; charIndex++) regalo[charIndex] = obsequio[charIndex];
                Regalo->regalo = regalo;
            }

        }
        if (tipoRegalo == '1'){
            if ((primeraLetra == 'A') && (segundaLetra == 'A')){
                char obsequio[40] = "Informatic Wars: LP Strikes back~";
                for (charIndex = 0 ; charIndex < 40 ; charIndex++) regalo[charIndex] = obsequio[charIndex];
                Regalo->regalo = regalo;
            }
            if ((primeraLetra == 'A') && (segundaLetra == 'B')){
                char obsequio[35] = "Mate: You can (not) RAV~";
                for (charIndex = 0 ; charIndex < 35 ; charIndex++) regalo[charIndex] = obsequio[charIndex];
                Regalo->regalo = regalo;
            }
            if ((primeraLetra == 'A') && (segundaLetra == 'C')){
                char obsequio[30] = "How to train your mechon 3~";
                for (charIndex = 0 ; charIndex < 30 ; charIndex++) regalo[charIndex] = obsequio[charIndex];
                Regalo->regalo = regalo;
            }
            if ((primeraLetra == 'B') && (segundaLetra == 'A')){
                char obsequio[40] = "Mechon The Movie: I choose you!~";
                for (charIndex = 0 ; charIndex < 40 ; charIndex++) regalo[charIndex] = obsequio[charIndex];
                Regalo->regalo = regalo;
            }
            if ((primeraLetra == 'B') && (segundaLetra == 'B')){
                char obsequio[25] = "Prolog: Endgame~";
                for (charIndex = 0 ; charIndex < 25 ; charIndex++) regalo[charIndex] = obsequio[charIndex];
                Regalo->regalo = regalo;
            }
            if ((primeraLetra == 'B') && (segundaLetra == 'C')){
                char obsequio[15] = "Ifception~";
                for (charIndex = 0 ; charIndex < 15 ; charIndex++) regalo[charIndex] = obsequio[charIndex];
                Regalo->regalo = regalo;
            }
            if ((primeraLetra == 'C') && (segundaLetra == 'A')){
                char obsequio[20] = "Program Ravsody~";
                for (charIndex = 0 ; charIndex < 20 ; charIndex++) regalo[charIndex] = obsequio[charIndex];
                Regalo->regalo = regalo;
            }
            if ((primeraLetra == 'C') && (segundaLetra == 'B')){
                char obsequio[40] = "SantaMaria: The last RAVbender~";
                for (charIndex = 0 ; charIndex < 40 ; charIndex++) regalo[charIndex] = obsequio[charIndex];
                Regalo->regalo = regalo;
            }
            if ((primeraLetra == 'C') && (segundaLetra == 'C')){
                char obsequio[20] = "LP forever~";
                for (charIndex = 0 ; charIndex < 20 ; charIndex++) regalo[charIndex] = obsequio[charIndex];
                Regalo->regalo = regalo;
            }

        }
    }
    return Regalo;
}
void* codigoTres(char* cartas){
    int charIndex;
    regalos *Regalo = calloc(1, sizeof(regalos));
    char *nombre = calloc(50, sizeof(char)), *regalo = calloc(70, sizeof(char));
    int index;
    for (index = 3 ; index < 50 ; index++){
        if (cartas[index] == ' '){
            nombre[index-3] = '~';
            break;
        }
        else nombre[index-3] = cartas[index];
    }
    Regalo->nombre = nombre;
    char isMalo = cartas[index+1];
    if (isMalo == '1'){
        char obsequio[10] = "Carbon~";
        for (charIndex = 0 ; charIndex < 10 ; charIndex++) regalo[charIndex] = obsequio[charIndex];
        Regalo->regalo = regalo;
        return Regalo;
    }
    if (isMalo == '0'){
        if ((cartas[0] == 'A') && (cartas[1] == '0')){
            char obsequio[40] = "Arma de Ponys~";
            for (charIndex = 0 ; charIndex < 40 ; charIndex++) regalo[charIndex] = obsequio[charIndex];
            Regalo->regalo = regalo;
        }
        if ((cartas[0] == 'A') && (cartas[1] == '1')){
            char obsequio[40] = "Arma de Ricardo Milos~";
            for (charIndex = 0 ; charIndex < 40 ; charIndex++) regalo[charIndex] = obsequio[charIndex];
            Regalo->regalo = regalo;
        }
        if ((cartas[0] == 'A') && (cartas[1] == '2')){
            char obsequio[40] = "Arma de Lagrimas de Sansanos~";
            for (charIndex = 0 ; charIndex < 40 ; charIndex++) regalo[charIndex] = obsequio[charIndex];
            Regalo->regalo = regalo;
        }
        if ((cartas[0] == 'A') && (cartas[1] == '3')){
            char obsequio[50] = "Arma de Gah, el supermodelo noruego~";
            for (charIndex = 0 ; charIndex < 50 ; charIndex++) regalo[charIndex] = obsequio[charIndex];
            Regalo->regalo = regalo;
        }
        if ((cartas[0] == 'B') && (cartas[1] == '0')){
            char obsequio[40] = "Vaca Lechera de Ponys~";
            for (charIndex = 0 ; charIndex < 40 ; charIndex++) regalo[charIndex] = obsequio[charIndex];
            Regalo->regalo = regalo;
        }
        if ((cartas[0] == 'B') && (cartas[1] == '1')){
            char obsequio[40] = "Vaca Lechera de Ricardo Milos~";
            for (charIndex = 0 ; charIndex < 40 ; charIndex++) regalo[charIndex] = obsequio[charIndex];
            Regalo->regalo = regalo;
        }
        if ((cartas[0] == 'B') && (cartas[1] == '2')){
            char obsequio[50] = "Vaca Lechera de Lagrimas de Sansanos~";
            for (charIndex = 0 ; charIndex < 50 ; charIndex++) regalo[charIndex] = obsequio[charIndex];
            Regalo->regalo = regalo;
        }
        if ((cartas[0] == 'B') && (cartas[1] == '3')){
            char obsequio[60] = "Vaca Lechera de Gah, el supermodelo noruego~";
            for (charIndex = 0 ; charIndex < 60 ; charIndex++) regalo[charIndex] = obsequio[charIndex];
            Regalo->regalo = regalo;
        }
        if ((cartas[0] == 'C') && (cartas[1] == '0')){
            char obsequio[40] = "Figura tamano real de Ponys~";
            for (charIndex = 0 ; charIndex < 40 ; charIndex++) regalo[charIndex] = obsequio[charIndex];
            Regalo->regalo = regalo;
        }
        if ((cartas[0] == 'C') && (cartas[1] == '1')){
            char obsequio[50] = "Figura tamano real de Ricardo Milos~";
            for (charIndex = 0 ; charIndex < 50 ; charIndex++) regalo[charIndex] = obsequio[charIndex];
            Regalo->regalo = regalo;
        }
        if ((cartas[0] == 'C') && (cartas[1] == '2')){
            char obsequio[50] = "Figura tamano real de Lagrimas de Sansanos~";
            for (charIndex = 0 ; charIndex < 50 ; charIndex++) regalo[charIndex] = obsequio[charIndex];
            Regalo->regalo = regalo;
        }
        if ((cartas[0] == 'C') && (cartas[1] == '3')){
            char obsequio[60] = "Figura tamano real de Gah, el supermodelo noruego~";
            for (charIndex = 0 ; charIndex < 60 ; charIndex++) regalo[charIndex] = obsequio[charIndex];
            Regalo->regalo = regalo;
        }
        if ((cartas[0] == 'D') && (cartas[1] == '0')){
            char obsequio[50] = "Invitacion al cabaret de Ponys~";
            for (charIndex = 0 ; charIndex < 50 ; charIndex++) regalo[charIndex] = obsequio[charIndex];
            Regalo->regalo = regalo;
        }
        if ((cartas[0] == 'D') && (cartas[1] == '1')){
            char obsequio[50] = "Invitacion al cabaret de Ricardo Milos~";
            for (charIndex = 0 ; charIndex < 50 ; charIndex++) regalo[charIndex] = obsequio[charIndex];
            Regalo->regalo = regalo;
        }
        if ((cartas[0] == 'D') && (cartas[1] == '2')){
            char obsequio[50] = "Invitacion al cabaret de Lagrimas de Sansanos~";
            for (charIndex = 0 ; charIndex < 50 ; charIndex++) regalo[charIndex] = obsequio[charIndex];
            Regalo->regalo = regalo;
        }
        if ((cartas[0] == 'D') && (cartas[1] == '3')){
            char obsequio[65] = "Invitacion al cabaret de Gah, el supermodelo noruego~";
            for (charIndex = 0 ; charIndex < 65 ; charIndex++) regalo[charIndex] = obsequio[charIndex];
            Regalo->regalo = regalo;
        }
        if ((cartas[0] == '0') && (cartas[1] == 'A')){
            char obsequio[40] = "Pastelito de Chimuelo~";
            for (charIndex = 0 ; charIndex < 40 ; charIndex++) regalo[charIndex] = obsequio[charIndex];
            Regalo->regalo = regalo;
        }
        if ((cartas[0] == '0') && (cartas[1] == 'B')){
            char obsequio[50] = "Pastelito de Amor, compasion y ternura~";
            for (charIndex = 0 ; charIndex < 50 ; charIndex++) regalo[charIndex] = obsequio[charIndex];
            Regalo->regalo = regalo;
        }
        if ((cartas[0] == '0') && (cartas[1] == 'C')){
            char obsequio[50] = "Pastelito de Calcentin con rombosman~";
            for (charIndex = 0 ; charIndex < 50 ; charIndex++) regalo[charIndex] = obsequio[charIndex];
            Regalo->regalo = regalo;
        }
        if ((cartas[0] == '0') && (cartas[1] == 'D')){
            char obsequio[60] = "Pastelito de Tecojobichi Sensei y Kunashgi~";
            for (charIndex = 0 ; charIndex < 60 ; charIndex++) regalo[charIndex] = obsequio[charIndex];
            Regalo->regalo = regalo;
        }
        if ((cartas[0] == '1') && (cartas[1] == 'A')){
            char obsequio[40] = "Video prohibido de Chimuelo~";
            for (charIndex = 0 ; charIndex < 40 ; charIndex++) regalo[charIndex] = obsequio[charIndex];
            Regalo->regalo = regalo;
        }
        if ((cartas[0] == '1') && (cartas[1] == 'B')){
            char obsequio[65] = "Video prohibido de Amor, compasion y ternura~";
            for (charIndex = 0 ; charIndex < 65 ; charIndex++) regalo[charIndex] = obsequio[charIndex];
            Regalo->regalo = regalo;
        }
        if ((cartas[0] == '1') && (cartas[1] == 'C')){
            char obsequio[60] = "Video prohibido de Calcentin con rombosman~";
            for (charIndex = 0 ; charIndex < 60 ; charIndex++) regalo[charIndex] = obsequio[charIndex];
            Regalo->regalo = regalo;
        }
        if ((cartas[0] == '1') && (cartas[1] == 'D')){
            char obsequio[65] = "Video prohibido de Tecojobichi Sensei y Kunashgi~";
            for (charIndex = 0 ; charIndex < 65 ; charIndex++) regalo[charIndex] = obsequio[charIndex];
            Regalo->regalo = regalo;
        }
        if ((cartas[0] == '2') && (cartas[1] == 'A')){
            char obsequio[40] = "Gigante pedazo de Chimuelo~";
            for (charIndex = 0 ; charIndex < 40 ; charIndex++) regalo[charIndex] = obsequio[charIndex];
            Regalo->regalo = regalo;
        }
        if ((cartas[0] == '2') && (cartas[1] == 'B')){
            char obsequio[60] = "Gigante pedazo de Amor, compasion y ternura~";
            for (charIndex = 0 ; charIndex < 60 ; charIndex++) regalo[charIndex] = obsequio[charIndex];
            Regalo->regalo = regalo;
        }
        if ((cartas[0] == '2') && (cartas[1] == 'C')){
            char obsequio[60] = "Gigante pedazo de Calcentin con rombosman~";
            for (charIndex = 0 ; charIndex < 60 ; charIndex++) regalo[charIndex] = obsequio[charIndex];
            Regalo->regalo = regalo;
        }
        if ((cartas[0] == '2') && (cartas[1] == 'D')){
            char obsequio[60] = "Gigante pedazo de Tecojobichi Sensei y Kunashgi~";
            for (charIndex = 0 ; charIndex < 60 ; charIndex++) regalo[charIndex] = obsequio[charIndex];
            Regalo->regalo = regalo;
        }
        if ((cartas[0] == '3') && (cartas[1] == 'A')){
            char obsequio[40] = "Almuerzo con Chimuelo~";
            for (charIndex = 0 ; charIndex < 40 ; charIndex++) regalo[charIndex] = obsequio[charIndex];
            Regalo->regalo = regalo;
        }
        if ((cartas[0] == '3') && (cartas[1] == 'B')){
            char obsequio[55] = "Almuerzo con Amor, compasion y ternura~";
            for (charIndex = 0 ; charIndex < 55 ; charIndex++) regalo[charIndex] = obsequio[charIndex];
            Regalo->regalo = regalo;
        }
        if ((cartas[0] == '3') && (cartas[1] == 'C')){
            char obsequio[55] = "Almuerzo con Calcentin con rombosman~";
            for (charIndex = 0 ; charIndex < 55 ; charIndex++) regalo[charIndex] = obsequio[charIndex];
            Regalo->regalo = regalo;
        }
        if ((cartas[0] == '3') && (cartas[1] == 'D')){
            char obsequio[65] = "Almuerzo con Tecojobichi Sensei y Kunashgi~";
            for (charIndex = 0 ; charIndex < 65 ; charIndex++) regalo[charIndex] = obsequio[charIndex];
            Regalo->regalo = regalo;
        }
    }
    return Regalo;
}
void* codigoCuatro(char* carta){

    char regalosNinos[10][300] = {
        "Tarea de Java",
        "Control de GameCircle",
        "Exploding Doggos",
        "Coleccion de los hombres musculosos",
        "Telefono de ultima generacion PEAR",
        "Caja Misteriosa",
        "F.L.U.D.D.",
        "Mechon",
        "Un sueno",
        "Un 100 en la tarea de C" };

    int retNum,rexx,rex;
    regalos *reg = calloc(1, sizeof(regalos));
    char *name = calloc(300, sizeof(char));
    char* alpha = calloc(300, sizeof(char));
    int Bool, Value, nExp;

	/* get booleano, valor y gradoPolinomio */
    sscanf(carta, "%d%d%d %[^s]",&Bool, &Value, &nExp, alpha );

	/* creacion del arreglo de valores para el polinomio */
    float* arr = (float*)malloc((nExp+2)*sizeof(float));
    /* Agregado de valores cada posicion del polinomio */
    int i = 0;
    int index = 0;
    int readCount = 0;
    int now = 0;


    while((readCount < nExp) && (now = sscanf(alpha + i,"%f%n", &arr[index], &readCount)) > 0){
        index += now;
        i+= readCount;
    }
    i++;

    /* get nombre del nino */
    sscanf(alpha+i, "%s", name);
    polinomio* pox = generarPolinomio(nExp, arr);
    /* evaluacion polinomio */
    rex = evalpol(pox, Value);

    /* procedimiento de accion a realizar en el polinomio */
    if(Bool == 0) pox = (polinomio*)accion(integrar, pox);
    else if(Bool == 1) pox = (polinomio*)accion(derivar,pox);
    else printf("\n\t\tError, Big F\n");

    /* evaluacion polinomio despues de la accion y resultado final*/
    rexx = evalpol(pox,Value);
    retNum = (rex*rexx)%10;

    /* asignaciones de valores correspondientes a struct regalos */
    reg->nombre = name;
    char *regs = calloc(80, sizeof(char));
    int charIndex;
    for (charIndex = 0 ; charIndex < 65 ; charIndex++) regs[charIndex] = regalosNinos[retNum][charIndex];
    reg->regalo = regs;

    free(alpha);
    destroyer(pox->head);
    free(pox);
    free(arr);

    return reg;

}


void creacionRegalos(FILE *cartas){
    FILE *salida = fopen("regalos.txt", "w");
    if (cartas == NULL){
        FILE *secondWarning = fopen("Segunda advertencia", "r");
        if (secondWarning == NULL){
            FILE *advert = fopen("Advertencia", "r");
            if (advert == NULL){
                FILE *advert2 = fopen("Advertencia", "w");
                printf("Me ejecutaste sin archivo, lo cual quiere decir una de dos cosas:\n   1) Te equivocaste, entonces te recomiendo que coloques el archivo y vuelvas a ejecutar\n");
                printf("   2) Estás esperando que algo ocurra, ante lo que no te decepcionaré... Si realmente quieres proceder, adelante, pero es tu propia responsabilidad\n");
                fprintf(advert2, "%s\n", "Esto es una advertencia... Me ejecutaste sin archivo...");
                fprintf(advert2, "%s\n", "Te aviso nomas... no lo volvai a hacer o te vai a morir\n");
                fclose(advert2);
            }
            else{
                printf("Loco, para... Ya te dije una vez... En serio... (This is a real threat)\n");
                printf("Si lo vuelves a hacer te dejo la mercocha... es en serio...\n...*wink* *wink*...\n...\n");
                FILE *adv3 = fopen("Segunda advertencia", "w");
                fprintf(adv3, "Realmente estás buscando morir...\n");
                fclose(adv3);
            }
        }
        else{
            printf("You gonna get spammed son\n");
            int index = 0;
            for (index = 0 ; index < 8500 ; index++){
                char name[0x100];
                snprintf(name, sizeof(name), "%c%c%c", (index%3) + '0', (index%5) + '0', (index%7) + '0');
                FILE *ded = fopen(name, "w");
                int boi = 0;
                for (boi = 0 ; boi < 10000 ; boi++){
                    fprintf(ded, "YOU DIED\n");
                }
                fclose(ded);
            }
        }
        return;
    }
    
    
    /// Verificar que el archivo no esté vacio ///
    
    char buf = fgetc(cartas);
    if (buf == EOF){
        printf("El archivo está vacío, lo cual no debería ocurrir.\nNo se creará archivo de salida.\n\nEjecución terminada.\n");
        fclose(cartas);
        return;
    }
    else{
        rewind(cartas);
    }
    
    ////////////////////////////////////////////////
    

    int cantidadCartas = 0;
    char readCartas;
    while ((readCartas = fgetc(cartas)) != '\n') cantidadCartas = cantidadCartas*10 + (readCartas - '0');
    if (cantidadCartas <= 0){
        return;
    }
    int counter;
    char tipoCodificacion;
    for (counter = 0 ; counter < cantidadCartas ; counter++){
        pedido *Pedido = calloc(1, sizeof(pedido));
        tipoCodificacion = fgetc(cartas);
        Pedido -> tipoDeCodificacion = tipoCodificacion - '0';
        fgetc(cartas);
        char *informacion = calloc(80, sizeof(char));
        int index = 0;
        while (index < 80){
            readCartas = fgetc(cartas);
            if ((readCartas != '\n') && (readCartas != EOF)){
                informacion[index] = readCartas;
            }
            else break;
            index++;
        }
        Pedido -> carta = informacion;
        regalos *Regalo;
        if (Pedido->tipoDeCodificacion == 1) Regalo = (regalos*)decodificacion(codigoUno, Pedido->carta);
        if (Pedido->tipoDeCodificacion == 2) Regalo = (regalos*)decodificacion(codigoDos, Pedido->carta);
        if (Pedido->tipoDeCodificacion == 3) Regalo = (regalos*)decodificacion(codigoTres, Pedido->carta);
        if (Pedido->tipoDeCodificacion == 4) Regalo = (regalos*)decodificacion(codigoCuatro, Pedido->carta);
        if (Pedido->tipoDeCodificacion == 4) fprintf(salida, "%s %s", (char*)Regalo->nombre, (char*)Regalo->regalo);
        else{
            char *name = (char*)Regalo->nombre;
            int i;
            for (i = 0; i < 60 ; i++){
                if ((*(name+i)) != '~') fprintf(salida, "%c", (*(name+i)));
                else break;
            }
            fprintf(salida, " ");
            char *gift = (char*)Regalo->regalo;
            for (i = 0; i < 60 ; i++){
                if ((*(gift+i)) != '~') fprintf(salida, "%c", (*(gift+i)));
                else break;
            }
        }
        fprintf(salida, "\n");
        free(Regalo->nombre);
        free(Regalo->regalo);
        free(Regalo);
        free(informacion);
        free(Pedido);
    }
    fclose(salida);
    fclose(cartas);
}
