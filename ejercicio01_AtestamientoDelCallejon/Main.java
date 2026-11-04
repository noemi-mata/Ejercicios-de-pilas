import java.io.IOException;
import java.io.InputStream;

/**
 * 1938. Atestamiento del callejon
 * omegaUp: https://omegaup.com/arena/problem/Atestamiento-del-Callejon/
 * Autora: Noemi Mata Ruiz
 *
 * Idea: el callejon es una pila; se sacan autos del tope hasta encontrar el pedido.
 */
public class Main {

    static final String[] EJEMPLOS = {
            "5\n" +
            "256\n" +
            "369\n" +
            "720\n" +
            "964\n" +
            "012\n" +
            "720\n"
    };

    static String resolver(byte[] datos) {
        Lector lector = new Lector(datos);
        int n = lector.nextInt();
        Pila<String> callejon = new Pila<>();
        for (int i = 0; i < n; i++) {
            callejon.push(lector.next());
        }
        String solicitado = lector.next();

        int sacados = 0;
        while (!callejon.isEmpty()) {
            String placa = callejon.pop();
            sacados++;
            if (placa.equals(solicitado)) {
                return sacados + "\n";
            }
        }
        return "No existe el auto\n";
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
