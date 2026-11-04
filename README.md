# Ejercicios de Pilas en Java

**Autora:** Noemi Mata Ruiz
**Materia:** Estructuras de Datos
**Plataforma de evaluación:** omegaUp

## Descripción general

Este repositorio contiene la solución de los ejercicios impares de la lista "Ejercicios de pilas" de omegaUp (7 problemas en total). Todos están resueltos en Java y cada uno usa una **pila propia**, construida desde cero, en lugar de las colecciones que ya trae el lenguaje.

Una pila es una estructura de datos que funciona como una torre de platos: el último elemento que se coloca arriba es el primero que se retira (LIFO, *Last In, First Out*). Sus operaciones básicas son meter un elemento en el tope (push), sacar el elemento del tope (pop) y consultar el tope sin quitarlo (peek).

## Organización del repositorio

Cada ejercicio está en su propia carpeta, numerada según su posición en la lista de la tarea. Dentro de cada carpeta hay:

- **Main.java**: la solución completa en un solo archivo, lista para copiar y pegar en omegaUp. Incluye la pila propia (clases Nodo y Pila) dentro del mismo archivo.
- **entrada1.txt**: el ejemplo de entrada del enunciado.
- **salida1.txt**: la salida esperada de ese ejemplo.

Si el programa se ejecuta sin darle ninguna entrada, corre automáticamente el ejemplo del enunciado y muestra su resultado, para que se pueda revisar rápido que funciona.

## Ejercicios

| # | Problema | Carpeta |
|---|----------|---------|
| 1 | 1938. Atestamiento del callejón | ejercicio01_AtestamientoDelCallejon |
| 3 | 6333. EasyStack | ejercicio03_EasyStack |
| 5 | 11354. Las bitácoras de la sana distancia | ejercicio05_BitacorasSanaDistancia |
| 7 | 4131. Máximo Elemento en la Pila | ejercicio07_MaximoElementoEnLaPila |
| 9 | 4100. Paréntesis Balanceados | ejercicio09_ParentesisBalanceados |
| 11 | 6142. Pila Interactivo | ejercicio11_PilaInteractivo |
| 13 | 5607. Un banco con clientes no preferentes | ejercicio13_BancoClientesNoPreferentes |

### 1. Atestamiento del callejón
Los autos entran a un callejón con una sola salida, así que el último en entrar es el primero que puede salir. Cada placa se mete a la pila en orden de llegada; después se van sacando autos del tope y contándolos hasta encontrar el solicitado. Si la pila se vacía sin encontrarlo, se indica que el auto no existe.

### 3. EasyStack
Es la práctica directa de las tres operaciones básicas: meter un número, quitar el del tope (sin hacer nada si la pila está vacía) e imprimir el tope, mostrando "Empty!" cuando no hay elementos.

### 5. Las bitácoras de la sana distancia
Se simula minuto a minuto el escritorio de la telefonista. Cada minuto se coloca un papelito encima de la pila; cuando ella se desocupa toma el papelito del tope y se calcula hasta qué minuto estará ocupada con la duración de su bitácora. Cuando ya no llegan papelitos, llama a los restantes de arriba hacia abajo.

### 7. Máximo Elemento en la Pila
Además de la pila de elementos se lleva una segunda pila con el máximo acumulado: cada vez que se mete un número se guarda también el mayor entre ese número y el máximo anterior. Así, el máximo actual siempre está en el tope de la segunda pila y se consulta al instante.

### 9. Paréntesis Balanceados
Para cada cadena se apilan los símbolos que abren; cada símbolo que cierra debe coincidir con el que está en el tope. Si todo coincide y la pila termina vacía se responde "SI", de lo contrario "NO".

### 11. Pila Interactivo
Es un problema interactivo: no se lee entrada, sino que el evaluador llama directamente a las funciones para agregar y sacar elementos. La pila se implementó con nodos y, al sacar de una pila vacía, se regresa -1. En esta carpeta:
- **PilaInteractivo.java** es el archivo que se envía a omegaUp en Java.
- **PilaInteractivo.c** es la misma solución en C, por si la plantilla del problema solo acepta ese lenguaje.
- **Main.java** solo sirve para probar localmente; reproduce la rutina de ejemplo del enunciado.

### 13. Un banco con clientes no preferentes
El banco tiene dos filas con reglas distintas: la fila 1 atiende al primero que llegó (se manejó con una cola propia) y la fila 2, para clientes morosos, atiende al último que llegó (se manejó con la pila). Se recorre la bitácora de eventos y se imprime el nombre de cada cliente en el orden en que fue atendido.

## Pruebas

Todos los ejercicios se probaron con los ejemplos del enunciado y dieron la salida esperada con el veredicto de OmegaUp
