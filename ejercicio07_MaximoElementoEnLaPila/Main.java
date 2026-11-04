import java.io.IOException;
import java.io.InputStream;

/**
 * 4131. Maximo Elemento en la Pila
 * omegaUp: https://omegaup.com/arena/problem/Maximo-Elemento-en-la-Pila/
 * Autora: Noemi Mata Ruiz
 *
 * Idea: junto a la pila de elementos se lleva una pila de maximos; su tope siempre es el maximo actual.
 */
public class Main {

    static final String[] EJEMPLOS = {
            "10\n" +
            "1 97\n" +
            "2\n" +
            "1 20\n" +
            "2\n" +
            "1 26\n" +
            "1 20\n" +
            "2\n" +
            "3\n" +
            "1 91\n" +
            "3\n"
    };

    static String resolver(byte[] datos) {
        Lector lector = new Lector(datos);
        int n = lector.nextInt();
        Pila<Long> elementos = new Pila<>();
        Pila<Long> maximos = new Pila<>();
        StringBuilder salida = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int tipo = lector.nextInt();
            if (tipo == 1) {
                long x = lector.nextLong();
                elementos.push(x);
                if (maximos.isEmpty() || x > maximos.peek()) maximos.push(x);
                else maximos.push(maximos.peek());
            } else if (tipo == 2) {
                elementos.pop();
                maximos.pop();
            } else if (tipo == 3) {
                salida.append(maximos.peek()).append('\n');
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
