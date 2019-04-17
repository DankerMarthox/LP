#ifndef polinomio_h
#define polinomio_h

/*
*      struct listpol
*      monomio de una lista, nodo
*/
typedef struct node{
    float val;      //valor que acompaña a la x
    int exp;        //exponente de la x
    struct node* next;
}listPol;

/*
*      struct polinomio
*      lista enlazada
*/
typedef struct {
    listPol* head;  // puntero  la cabeza
    listPol* tail;  //puntero a la cola
    listPol* curr;  //puntero al nodo actual
    int Size;       //tamano de la lista
}polinomio;




/*
*   void integrar
******
*   Funcion que integra un polinomio.
******
*   Input:
*       polinomio* poli : pilinomio (lista elazada)
*
******
*   Returns:
*       nada
*****/
void integrar(polinomio* poli);

/*
*   void derivar
******
*   Funcion que deriva un polinomio.
******
*   Input:
*       polinomio* poli : pilinomio (lista elazada)
*
******
*   Returns:
*       nada
*****/
void derivar(polinomio* poli);

/*
*   void* accion
******
*   Funcion que hace uso de las funciones derivar o integrar.
******
*   Input:
*       void deit: puntero a funcion
*       polinomio* poli: polinomio (lista enlazada)
*
******
*   Returns:
*       puntero al polinomio modificado
*****/
void* accion(void (*deit)(polinomio*),polinomio* poli);

/*
*   int evapol
******
*   Funcion evalua un polinomio.
******
*   Input:
*       int n: valor a evaluar
*       polinomio* poli: polinomio (lista enlazada)
*
******
*   Returns:
*       puntero al polinomio modificado
*****/
int evalpol(polinomio* poli, int n);
void* codigoCuatro(char* carta);
void* decodificacion(void* (*codigo)(char*), char* carta);

/*
*   void* decodificacion
******
*   Funcion que decodifica una carta.
*   //esta funcion es un meme
******
*   Input:
*       void codigo: puntero a funcion
*       char* carta: arreglo de char que contiene la carta
*
******
*   Returns:
*       puntero al regalo
*****/
void* decodificacion(void* (*codigo)(char*), char* carta);

/*
*   listPol* generateNode
******
*   Funcion que genera un nodo de la lista (monomio).
******
*   Input:
*       int exp: exponente
*       float val: valor que multiplica a la x
*
******
*   Returns:
*       listPol*, puntero a un nodo creado
*****/
listPol* generateNode(int Exp, float Val);

/*
*   polinomio* generarPolinomio
******
*   Funcion que genera un polinomio (lista enlazada).
******
*   Input:
*       int cantExps: grado polinomio
*       float* arr: arreglo de floats con los valores que acompañan a la x en un monomio
*
******
*   Returns:
*       polinomio*, puntero a un polinomio creado
*****/
polinomio* generarPolinomio(int cantExps, float* arr);

/*
*   void moveTostart
******
*   Funcion que mueve el puntero de una lista al head.
******
*   Input:
*       polinomio* list
*
******
*   Returns:
*       nada
*****/
void moveToStart(polinomio* List);

/*
*   void next
******
*   Funcion que avanza el puntero de la lista en una posicion.
******
*   Input:
*       polinomio* list
*
******
*   Returns:
*       nada
*****/
void next(polinomio* List);

/*
*   void next
******
*   Funcion que borra una lista.
******
*   Input:
*       listPol* head, puntero a la cabeza de una lista
*
******
*   Returns:
*       nada
*****/
void destroyer(listPol* head);

/*
*   void next
******
*   Funcion que imprime una lista tipo polinomio.
******
*   Input:
*       polinomio* lista, puntero a una lista enlazada
*
******
*   Returns:
*       nada
*****/
void imprimirSolucion(polinomio* Lista);


#endif /* POLINOMIO_H */
