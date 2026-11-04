/*
 * 6142. Pila Interactivo - version en C
 * Autora: Noemi Mata Ruiz
 *
 * Alternativa por si omegaUp solo permite la plantilla en C para este problema.
 */
#include <stdlib.h>

typedef struct Nodo {
    int dato;
    struct Nodo *siguiente;
} Nodo;

static Nodo *tope = NULL;

void agrega(int n) {
    Nodo *nuevo = (Nodo *)malloc(sizeof(Nodo));
    nuevo->dato = n;
    nuevo->siguiente = tope;
    tope = nuevo;
}

int saca() {
    if (tope == NULL) return -1;
    Nodo *viejo = tope;
    int dato = viejo->dato;
    tope = viejo->siguiente;
    free(viejo);
    return dato;
}
