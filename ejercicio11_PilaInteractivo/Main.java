/**
 * Prueba local de 6142. Pila Interactivo
 * Autora: Noemi Mata Ruiz
 *
 * Reproduce la rutina de ejemplo del enunciado llamando a las funciones
 * de PilaInteractivo, igual que lo haria el evaluador de omegaUp.
 * (Este archivo NO se envia a omegaUp, solo sirve para probar.)
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("agrega(3)");
        PilaInteractivo.agrega(3);
        System.out.println("agrega(6)");
        PilaInteractivo.agrega(6);
        System.out.println("agrega(9)");
        PilaInteractivo.agrega(9);

        System.out.println("saca() -> " + PilaInteractivo.saca()); // 9
        System.out.println("saca() -> " + PilaInteractivo.saca()); // 6
        System.out.println("saca() -> " + PilaInteractivo.saca()); // 3
        System.out.println("saca() -> " + PilaInteractivo.saca()); // -1
    }
}
