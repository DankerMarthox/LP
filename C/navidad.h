#ifndef navidad_h
#define navidad_h


//Struct necesario para la creacion de regalos
typedef struct{
	void* nombre;
	void* regalo;
}regalos;

/*
*   void creacion regalos
******
*   Funcion que crea los regalos en base al imput.
******
*   Input:
*       FILE *cartas : variable que apunta a una linea de un archivo
*
******
*   Returns:
*       Nada
*****/
void creacionRegalos(FILE *cartas);

/*
*   void* codigoUno
******
*   Funcion que hace crea los regalos segun el formato 1, usando el struct regalo.
******
*   Input:
*       FILE *cartas : variable que apunta a una linea de un archivo
*
******
*   Returns:
*       void pointer al el struct regalo creado
*****/
void* codigoUno(char* cartas);

/*
*   void* codigoDos
******
*   Funcion que hace crea los regalos segun el formato 2, usando el struct regalo.
******
*   Input:
*       FILE *cartas : variable que apunta a una linea de un archivo
*
******
*   Returns:
*       void pointer al el struct regalo creado
*****/
void* codigoDos(char* cartas);

/*
*   void* codigoTres
******
*   Funcion que hace crea los regalos segun el formato 3, usando el struct regalo.
******
*   Input:
*       FILE *cartas : variable que apunta a una linea de un archivo
*
******
*   Returns:
*       void pointer al el struct regalo creado
*****/
void* codigoTres(char* cartas);

/*
*   void* codigoCuatro
******
*   Funcion que hace crea los regalos segun el formato 4, usando el struct regalo.
******
*   Input:
*       FILE *cartas : variable que apunta a una linea de un archivo
*
******
*   Returns:
*       void pointer al el struct regalo creado
*****/
void* codigoCuatro(char* cartas);

/*
*   void* decodificacion
******
*   Funcion que utiliza las funciones codigo_i en base a el tipo de codificacion.
*   //esta funcion es un meme
******
*   Input:
*       FILE *cartas : variable que apunta a una linea de un archivo
*
******
*   Returns:
*       void pointer al el struct regalo creado
*****/
void* decodificacion(void* (*codigo)(char*), char* carta);

#endif /* navidad_h */
