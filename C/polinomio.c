#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "polinomio.h"
#include "navidad.h"
#define MAXSIZE 300
#define NAMELEN 50

 float myPow(float x,int n){
    int i;
    float number = 1;
    for (i = 0; i < n; ++i)
        number *= x;
    return number;
}

listPol* generateNode(int Exp, float Val){
    //printf("YASS\n");
    listPol* node = (listPol*)malloc(sizeof(listPol));
    node->val = Val;
    node->exp = Exp;
    node->next = NULL;
    return node;
}

void next(polinomio* List) {
    if (List->curr != List->tail) {
        List->curr = List->curr->next;
    }
}

polinomio* generarPolinomio(int cantExps, float* arr){

    polinomio* pox = (polinomio*)malloc(sizeof(polinomio) *  cantExps);
    int i = 1;
    int x = cantExps+1;

    pox->curr = pox->head = pox->tail = generateNode(0,arr[0]);
    //pox->curr->next = NULL;

    while( i < x) {
        pox->tail->next = generateNode(i,arr[i]);
        pox->tail = pox->tail->next;
        i++;
    }
    pox->Size = cantExps;
    return pox;
}

void moveToStart(polinomio* List){
    List->curr = List->head;
}

void imprimirSolucion(polinomio* Lista) {
    int i;
    moveToStart(Lista);
    for (i = 0; i < Lista->Size; i++) {
        printf("(%f,%d)", Lista->curr->val, Lista->curr->exp);
        next( Lista);
    }
    puts("\n");
}

void derivar(polinomio* poli){
    moveToStart(poli);
    while(poli->curr != poli->tail){
        ((polinomio*)poli)->curr->val = (((polinomio*)poli)->curr->val)*(((polinomio*)poli)->curr->exp);
        ((polinomio*)poli)->curr->exp -= 1;
        next(poli);
    }
    ((polinomio*)poli)->tail->val = (((polinomio*)poli)->tail->val)*(((polinomio*)poli)->tail->exp);
    ((polinomio*)poli)->tail->exp -= 1;

}

void integrar(polinomio* poli){
    moveToStart(poli);
    while(poli->curr != poli->tail){
        ((polinomio*)poli)->curr->exp += 1;
        ((polinomio*)poli)->curr->val = (((polinomio*)poli)->curr->val)/(((polinomio*)poli)->curr->exp);
        next(poli);
    }
    ((polinomio*)poli)->tail->exp += 1;
    ((polinomio*)poli)->tail->val = (((polinomio*)poli)->tail->val)/(((polinomio*)poli)->tail->exp);
}

//useless function
void* accion(void (*deit)(polinomio*),polinomio* poli){
    (*deit)(poli);
    return poli;

}

int evalpol(polinomio* poli, int n){
    moveToStart(poli);
    float ret = 0;
    while(poli->curr != poli->tail){
      ret += myPow(n,poli->curr->exp) * poli->curr->val;
      next(poli);
    }
    return (int)ret;
}

void destroyer(listPol* head){
    listPol* nxt;
    while (head->next != NULL) {
        head->val = 0;
        head->exp = 0;
        nxt = head->next;
        free(head);
        head = nxt;
    }
    //free(head);
}
