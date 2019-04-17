#include <stdio.h>
#include <stdlib.h>
#include "navidad.h"
#include "polinomio.h"

int main() {
    FILE *archivo = fopen("cartas.txt", "r");
    creacionRegalos(archivo);
    return 0;
}
