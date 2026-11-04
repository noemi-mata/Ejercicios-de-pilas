import java.io.IOException;
import java.io.InputStream;

/**
 * 11354. Las bitacoras de la sana distancia
 * omegaUp: https://omegaup.com/arena/problem/Las-bitacoras-de-la-sana-distanc/
 * Autora: Noemi Mata Ruiz
 *
 * Idea: simular minuto a minuto; los papelitos se apilan y la telefonista toma el del tope cuando se desocupa.
 */
public class Main {

    static final String[] EJEMPLOS = {
            "5\n" +
            "2 1 3 1 2\n" +
            "300000000\n" +
            "100000000\n" +
            "400000000\n" +
            "500000000\n" +
            "900000000\n"
    };

    static String resolver(byte[] datos) {
        Lector lector = new Lector(datos);
        int n = lector.nextInt();
        int[] duraciones = new int[n];
        for (int i = 0; i < n; i++) duraciones[i] = lector.nextInt();
        long[] telefonos = new long[n];
        for (int i = 0; i < n; i++) telefonos[i] = lector.nextLong();

        Pila<Long> escritorio = new Pila<>();
        StringBuilder salida = new StringBuilder();
        long libreEnMinuto = 0;   // minuto en que la telefonista se desocupa
        int siguienteLlamada = 0; // indice de la siguiente duracion de la bitacora

        for (int minuto = 1; minuto <= n; minuto++) {
            escritorio.push(telefonos[minuto - 1]);
            if (libreEnMinuto <= minuto) {
                salida.append(escritorio.pop()).append('\n');
                libreEnMinuto = minuto + duraciones[siguienteLlamada++];
            }
        }
        // Ya no llegan papelitos: se llaman los que quedan de arriba hacia abajo
        while (!escritorio.isEmpty()) {
            salida.append(escritorio.pop()).append('\n');
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
