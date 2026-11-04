import java.io.IOException;
import java.io.InputStream;

/**
 * 5607. Un banco con clientes no preferentes
 * omegaUp: https://omegaup.com/arena/problem/banco-clientes-no-preferentes/
 * Autora: Noemi Mata Ruiz
 *
 * Idea: la fila 1 se maneja como cola y la fila 2 (morosos) como pila.
 */
public class Main {

    static final String[] EJEMPLOS = {
            "8\n" +
            "E 1 juan\n" +
            "E 2 paco\n" +
            "E 1 jorge\n" +
            "A 1\n" +
            "E 2 pedro\n" +
            "A 2\n" +
            "A 1\n" +
            "A 2\n"
    };

    // ===== Cola propia (para la fila 1, primero en llegar primero en salir) =====
    static class Cola<T> {
        private Nodo<T> frente;
        private Nodo<T> fin;

        void encolar(T dato) {
            Nodo<T> nuevo = new Nodo<>(dato, null);
            if (fin == null) {
                frente = nuevo;
            } else {
                fin.siguiente = nuevo;
            }
            fin = nuevo;
        }

        T desencolar() {
            if (frente == null) return null;
            T dato = frente.dato;
            frente = frente.siguiente;
            if (frente == null) fin = null;
            return dato;
        }
    }

    static String resolver(byte[] datos) {
        Lector lector = new Lector(datos);
        int n = lector.nextInt();
        Cola<String> fila1 = new Cola<>();
        Pila<String> fila2 = new Pila<>();
        StringBuilder salida = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String evento = lector.next();
            int fila = lector.nextInt();
            if (evento.equals("E")) {
                String nombre = lector.next();
                if (fila == 1) fila1.encolar(nombre);
                else fila2.push(nombre);
            } else {
                String atendido = (fila == 1) ? fila1.desencolar() : fila2.pop();
                salida.append(atendido).append('\n');
            }
        }
        return salida.toString();
    }

    // ===== Pila propia (implementada con nodos enlazados) =====
    static class Nodo<T> {
        T dato;
        Nodo<T> siguiente;

        Nodo(T dato, Nodo<T> siguiente) {
            this.dato = dato;
            this.siguiente = siguiente;
        }
    }

    static class Pila<T> {
        private Nodo<T> tope;
        private int tamanio;

        void push(T dato) {
            tope = new Nodo<>(dato, tope);
            tamanio++;
        }

        T pop() {
            if (tope == null) return null;
            T dato = tope.dato;
            tope = tope.siguiente;
            tamanio--;
            return dato;
        }

        T peek() {
            return tope == null ? null : tope.dato;
        }

        boolean isEmpty() {
            return tope == null;
        }

        int size() {
            return tamanio;
        }
    }

    // ===== Lectura rapida de la entrada =====
    static class Lector {
        private final byte[] buf;
        private int pos = 0;

        Lector(byte[] buf) {
            this.buf = buf;
        }

        String next() {
            while (pos < buf.length && buf[pos] <= ' ') pos++;
            if (pos >= buf.length) return null;
            int ini = pos;
            while (pos < buf.length && buf[pos] > ' ') pos++;
            return new String(buf, ini, pos - ini);
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        String nextLine() {
            if (pos >= buf.length) return null;
            int ini = pos;
            while (pos < buf.length && buf[pos] != '\n') pos++;
            int fin = pos;
            if (pos < buf.length) pos++;
            if (fin > ini && buf[fin - 1] == '\r') fin--;
            return new String(buf, ini, fin - ini);
        }
    }

    // Si no llega nada por la entrada estandar regresa null (se usan los ejemplos)
    static byte[] leerEntrada() throws IOException {
        InputStream in = System.in;
        if (in.available() == 0) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                // sin accion
            }
            if (in.available() == 0) return null;
        }
        return in.readAllBytes();
    }

    public static void main(String[] args) throws IOException {
        byte[] entrada = leerEntrada();
        if (entrada == null) {
            // Casos por defecto: los ejemplos del enunciado
            for (String ejemplo : EJEMPLOS) {
                System.out.println("--- Entrada de ejemplo ---");
                System.out.println(ejemplo.trim());
                System.out.println("--- Salida ---");
                System.out.print(resolver(ejemplo.getBytes()));
                System.out.println();
            }
            return;
        }
        System.out.print(resolver(entrada));
    }
}
