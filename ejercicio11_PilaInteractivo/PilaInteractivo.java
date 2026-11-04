/**
 * 6142. Pila Interactivo
 * omegaUp: https://omegaup.com/arena/problem/COMI-Pila-Interactivo/
 * Autora: Noemi Mata Ruiz
 *
 * Problema interactivo: el evaluador llama a agrega(n) y saca().
 * Este es el archivo que se envia a omegaUp (lenguaje Java).
 */
public class PilaInteractivo {

    // ===== Pila propia (implementada con nodos enlazados) =====
    static class Nodo {
        int dato;
        Nodo siguiente;

        Nodo(int dato, Nodo siguiente) {
            this.dato = dato;
            this.siguiente = siguiente;
        }
    }

    private static Nodo tope = null;

    // Agrega el entero n en el tope de la pila
    public static void agrega(int n) {
        tope = new Nodo(n, tope);
    }

    // Regresa el elemento del tope y lo quita; -1 si la pila esta vacia
    public static int saca() {
        if (tope == null) return -1;
        int dato = tope.dato;
        tope = tope.siguiente;
        return dato;
    }
}
