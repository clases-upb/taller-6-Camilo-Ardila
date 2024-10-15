/*
 * This source file was generated by the Gradle 'init' task
 */
package org.example;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class App {

    public static void main(String[] args) {

        try {

            //System.out.println(Ejercicio_1());
            System.out.println(Ejercicio_2());
            //System.out.println(Ejercicio_3());
            System.out.println(Ejercicio_4(10));
            System.out.println(Ejercicio_5(5));
            System.out.println(Ejercicio_6(8));
            System.out.println(Ejercicio_7());
            System.out.println(Ejercicio_8());
            System.out.println(Ejercicio_9());
           
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    /*
     * 1. Implemente un programa en java donde inserte elementos en dos vectores
     * globales de tamaños aleatorios y de contenido aleatorio (uno numérico y otro
     * de Strings). Considere dejar espacios libres en los vectores.
     * 
     * Desde un menú en el programa principal debe considerar cada opción para
     * llamar las siguientes funciones que también debe programar:
     * 
     * a. Recorrer secuencialmente (recibe un true cuando va del primero al último y
     * un false cuando va del último al primero)
     * • De primer elemento a último elemento: Imprime desde el primer elemento
     * hasta el último del vector dado en el parámetro de entrada.
     * • De último elemento al primer elemento: Imprime desde el último elemento
     * hasta el primero del vector dado en el parámetro de entrada.
     * 
     * b. Actualizar: recibe la posición que va a actualizar y el elemento. Al final
     * imprime el vector actualizado.
     * 
     * c. Añadir: después del último: recibe el elemento que va a añadir. Al final
     * imprime el vector actualizado.
     * 
     * d. Borrar: Recibe la posición donde del elemento que va a borrar.
     * 
     * e. Ordenar el vector:
     * • Ascendentemente.
     * • Descendentemente.
     * 
     * f. Búsqueda: Recibe como parámetro el elemento a buscar y devuelve un String
     * separado por el carácter '-', mostrando las posiciones donde se encuentra el
     * elemento.
     */

    /*
     * 2. Escriba un algoritmo que calcule aleatoriamente N temperaturas, las lleve
     * a un vector y luego calcule su media, cuántas temperaturas están por encima
     * de la media y cuántas por debajo.
     */

    public static String Ejercicio_2()throws Exception{
        try{
            int fil_col = (byte)(Math.random() * (10 - 2) + 1), superiores = 0, inferiores = 0;
            float sumatoria = 0f, media = 0f, aleatorio = 0f;
            float [] v_temperaturas = new float [fil_col];
            String mensaje = "";

            for(int inicio = 0; inicio <= v_temperaturas.length - 1; inicio++){
                aleatorio = (float)(Math.random() * (100 - 0) + 1);
                v_temperaturas [inicio] = aleatorio;
                sumatoria += v_temperaturas [inicio];
                System.out.print(aleatorio + "\t");
            }

            media = sumatoria / v_temperaturas.length;

            for(int contador = 0; contador <= v_temperaturas.length - 1; contador++){
                if(v_temperaturas [contador] > media)
                    superiores ++;
                else if(v_temperaturas[contador] < media)
                    inferiores ++;
            }

            mensaje = "\nLa media de las temperaturas fue " + media + 
                "\n Las temperaturas superiores a la media fueron " + superiores +
                "\n Las temperaturas inferiores a la media fueron " + inferiores;
            
            return mensaje;
        }

        catch(Exception e){
            throw new Exception("Error en el método Ejercicio_2");
        }
    }

    /*
     * 3. Cargue un vector a partir de un archivo de palabras, con mínimo 10
     * palabras. Ordene el vector de manera ascendente y luego de forma descendente.
     * 
     * Escriba el vector inicial sin ordenar, los vectores ordenados.
     */

     public static String Ejercicio_3(String archivoPalabras) throws Exception {
        try {
            
            BufferedReader lector = new BufferedReader(new FileReader(archivoPalabras));
            String[] palabras = new String[10];
            String mensaje = "";

            // Cargar el vector de palabras desde el archivo
            for (int i = 0; i < palabras.length; i++) {
                palabras[i] = lector.readLine();
                if (palabras[i] == null) {
                    throw new Exception("El archivo tiene menos de 10 palabras.");
                }
            }
            lector.close();

            // Mostrar el vector inicial sin ordenar
            mensaje += "Vector inicial sin ordenar:\n";
            for (String palabra : palabras) {
                mensaje += palabra + " ";
            }
            mensaje += "\n";

            // Ordenar de manera ascendente
            Arrays.sort(palabras);
            mensaje += "Vector ordenado de manera ascendente:\n";
            for (String palabra : palabras) {
                mensaje += palabra + " ";
            }
            mensaje += "\n";

            // Ordenar de manera descendente
            Arrays.sort(palabras, Collections.reverseOrder());
            mensaje += "Vector ordenado de manera descendente:\n";
            for (String palabra : palabras) {
                mensaje += palabra + " ";
            }
            mensaje += "\n";

            return mensaje;

        } 
        
        catch (Exception e) {
            throw new Exception("Error en el método Ejercicio_3: " + e.getMessage());
        }
    }

    /*
     * 4. Escriba un algoritmo que cree un vector de N elementos (el N es dado por
     * el usuario) de números short aleatorios positivos mayores que cero, y luego
     * le pregunte al usuario qué posición quiere eliminar. Luego por un menú
     * presente las opciones: Dejar la casilla en 0 o desplazar los elementos de
     * manera que el cero quede en la última posición del vector. Después de la
     * operación mostrará el vector cómo va quedando y volverá a preguntar qué
     * posición quiere borrar y mostrará nuevamente el menú. En el menú aparecerá la
     * opción para terminar el programa.
     */

     public static String Ejercicio_4(int elementos) throws Exception {
        try {
            Scanner teclado = new Scanner(System.in);
            String mensaje = "";
            int eliminada;
            int[] v_positivos = new int[elementos];
            short aleatorio;

            for (int inicio = 0; inicio < v_positivos.length; inicio++) {
                aleatorio = (short) (Math.random() * 100 + 1);
                v_positivos[inicio] = aleatorio;
            }

            mensaje += "Vector inicial:\n";

            for (int num : v_positivos) {
                mensaje += num + " ";
            }

            mensaje += "\n";

            do {
                System.out.println("Seleccione la posición que desea eliminar (o ingrese -1 para salir): ");
                eliminada = teclado.nextInt();

                if (eliminada >= 0 && eliminada < v_positivos.length) {
                    System.out.println("¿Qué desea hacer?\n1. Dejar la casilla en 0\n2. Desplazar los elementos para que el cero quede al final");
                    int opcion = teclado.nextInt();

                    if (opcion == 1) {
                        v_positivos[eliminada] = 0;
                    }
                    
                    else if (opcion == 2) {
                        
                        for (int inicio = eliminada; inicio < v_positivos.length - 1; inicio++) {
                            v_positivos[inicio] = v_positivos[inicio + 1];
                        }
        
                        v_positivos[v_positivos.length - 1] = 0;
                    }

                    mensaje += "Vector actualizado:\n";

                    for (int num : v_positivos) {
                        mensaje += num + " ";
                    }

                    mensaje += "\n";

                } 
                
                else if (eliminada != -1) 
                    System.out.println("La posición debe estar entre 0 y " + (v_positivos.length - 1));

            } while (eliminada != -1);

            return mensaje;

        } 
        
        catch (Exception e) {
            throw new Exception("Error en el método Ejercicio_4");
        }
    }
    
    /*
     * 5. Escriba un algoritmo para convertir un número decimal en un número
     * hexadecimal, apoyado en vectores.
     */
    
     public static String Ejercicio_5(int decimal) throws Exception {
        try {

            String mensaje = "El número decimal " + decimal + " en hexadecimal es: ";
            char[] hexadecimales = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
            int[] residuos = new int[100];  // Arreglo para guardar residuos
            int indice = 0;

            // Convertir decimal a hexadecimal
            while (decimal > 0) {
                residuos[indice] = decimal % 16;  // Guardar el residuo
                decimal = decimal / 16;
                indice++;
            }

            // Imprimir el número en hexadecimal en orden inverso
            for (int inicio = indice - 1; inicio >= 0; inicio--) {
                mensaje += hexadecimales[residuos[inicio]];
            }

            return mensaje;

        } 
        
        catch (Exception e) {
            throw new Exception("Error en el método Ejercicio_5 " + e.toString() );
        }
    }

    /*
     * 6. Escriba un algoritmo que solicite al usuario el orden de una matriz
     * cuadrática, implemente su matriz transpuesta (investiga qué es) y la imprima.
     */

    public static String Ejercicio_6(int tamano)throws Exception{
        try{
            String mensaje = "";
            int aleatorio = 0;
            
            int [][] m_normal = new int [tamano][tamano];
            int [][] m_transpuesta = new int [tamano][tamano];

            for(int filas = 0; filas <= m_normal.length - 1; filas++){

                for(int columnas = 0; columnas <= m_normal[filas].length - 1; columnas++){
                    aleatorio = (int)(Math.random() * (100 - 10) + 10 + 1);
                    m_normal [filas][columnas] = aleatorio;

                    System.out.print(m_normal[filas][columnas] + "\t");
                }
                System.out.println();
            }

            System.out.println();

            for(int columnas = 0; columnas <= m_transpuesta.length - 1;columnas++){

                for(int filas = 0; filas <= m_normal[columnas].length - 1; filas++){

                    m_transpuesta[filas][columnas] = m_normal[columnas][filas];

                    System.out.print(m_normal[filas][columnas] + "\t");
                }
                System.out.println();
            }

            return null;
        }

        catch(Exception e){
            throw new Exception("Ha ocurrido un error en el método Ejercicio_6");
        }

        
    }
    
    /*
     * 7. Escriba un algoritmo que calcule el producto y la división. Los operandos
     * serán la suma de elementos de la diagonal principal y la suma de los
     * elementos de la diagonal secundaria. Los elementos de la matriz deben ser
     * llenados usando la función random para calcular números aleatorios entre 10 y
     * 100.
     */

    public static String Ejercicio_7()throws Exception{
        try{
            String mensaje = "";
            int aleatorio = 0;
            int sumatoria_1 = 0, sumatoria_2 = 0;
            float producto = 0f, division = 0f;
            int fil_col = (byte)(Math.random() * (10 - 4) + 4 + 1);
            int m_aleatorios [][] = new int [fil_col][fil_col];

            for(int filas = 0; filas <= m_aleatorios.length - 1; filas++){

                for(int columnas = 0; columnas <= m_aleatorios[filas].length - 1; columnas++){
                    aleatorio = (int)(Math.random() * (100 - 10) + 1);
                    m_aleatorios [filas][columnas] = aleatorio;

                    System.out.print(m_aleatorios [filas][columnas] + "\t");
                }
                System.out.println();
            }

            for(int filas = 0; filas <= m_aleatorios.length - 1; filas++){

                for(int columnas = 0; columnas <= m_aleatorios[filas].length - 1; columnas++){
                    if(filas == columnas)
                        sumatoria_1 += m_aleatorios [filas][columnas];
                        
                    else if(filas + columnas == fil_col-1)
                        sumatoria_2 += m_aleatorios [filas][columnas];     
                }    
            }
        
            producto = sumatoria_1 * sumatoria_2;
            division = (float)sumatoria_1 / sumatoria_2;
            
            mensaje = "\nLa sumatoria de la diagonal principal es " + sumatoria_1 + 
                "\nLa sumatoria de la diagonal secundaria es: " + sumatoria_2 +
                "\nEl producto de las sumatorias es: " + producto +
                "\nLa división de las sumatorias es: " + division;
            
            return mensaje;
        }

        catch(Exception e){
            throw new Exception("Error en el método Ejercicio_7");
        }
    }
    
    /*
     * 8. Escriba un algoritmo que llene de manera aleatoria una matriz de 100 filas
     * por 3 columnas con Xs y Os. Y mediante un vector cuente el número de Xs y Os
     * en cada fila. Imprima la matriz antes de llenarla, luego de llenarla y el
     * vector con el resultado.
     */
    
    public static String Ejercicio_8()throws Exception{
        try{
            String mensaje = "";   
            int filas = 100, columnas = 3;
            char [][] matriz = new char[filas][columnas];
            int[] v_Xs = new int[filas];
            int[] v_Os = new int[filas];
            

            for(int fil = 0; fil <= matriz.length - 1; fil++){

                for(int col = 0; col <= matriz[fil].length - 1; col++){      

                    matriz [fil][col] = Math.random()<0.5?'X':'O';
                    System.out.print(matriz [fil][col] + "\t");
                }
                System.out.println();
            }
            
            for(int fil = 0; fil <= matriz.length - 1; fil++){

                for(int col = 0; col <= matriz[fil].length - 1; col++){      
                    if(matriz [fil][col] == 'X')
                        v_Xs [fil] ++;
                    else{
                        v_Os [fil] ++;
                    }
                }
            }

            for(int fil = 0; fil <= matriz.length - 1; fil++){

                System.out.println("Para la fila " + (fil+1) + " hay " + v_Xs [fil] + " Xs y " + v_Os[fil] + " Os");
                
            }
            
            return null;
        }

        catch(Exception e){
            throw new Exception ("Error en el método Ejercicio_8");
        }
    }
    
    /*
     * 9. Llene una matriz de 5x5 con números aleatorios entre 1 y 9. En un vector
     * adicional, calcule la cantidad de números repetidos por cada fila y en otro
     * vector la cantidad de números repetidos de cada columna.
     */

     public static String Ejercicio_9() throws Exception {
        try {
            String mensaje = "";
            int[][] m_aleatorios = new int[5][5];
            int[] v_repetidos_filas = new int[5];
            int[] v_repetidos_columnas = new int[5];
            int aleatorio = 0;

            for (int fila = 0; fila < m_aleatorios.length; fila++) {
                for (int columna = 0; columna < m_aleatorios[fila].length; columna++) {
                    aleatorio = (int)(Math.random() * (9 - 1 + 1) + 1);  
                    m_aleatorios[fila][columna] = aleatorio;
                    System.out.print(aleatorio + "\t");
                }
                System.out.println();
            }

            for (int fila = 0; fila < m_aleatorios.length; fila++) {
                int contador_filas = 0;
                for (int i = 0; i < m_aleatorios[fila].length; i++) {
                    for (int j = i + 1; j < m_aleatorios[fila].length; j++) {
                        if (m_aleatorios[fila][i] == m_aleatorios[fila][j]) {
                            contador_filas++;
                            break;  
                        }
                    }
                }
                v_repetidos_filas[fila] = contador_filas;
            }

            // Contar números repetidos por columna
            for (int columna = 0; columna < m_aleatorios[0].length; columna++) {
                int contador_columnas = 0;

                for (int col = 0; col < m_aleatorios.length; col++) {

                    for (int fil = col + 1; fil < m_aleatorios.length; fil++) {

                        if (m_aleatorios[col][columna] == m_aleatorios[fil][columna]) {
                            contador_columnas++;
                            break;
                        }
                    }
                }
                v_repetidos_columnas[columna] = contador_columnas;
            }

            mensaje += "Repetidos por fila:\n";

            for (int inicio = 0; inicio < v_repetidos_filas.length; inicio++) {
                mensaje += "Fila " + (inicio + 1) + ": " + v_repetidos_filas[inicio] + "\n";
            }

            mensaje += "Repetidos por columna:\n";
            for (int inicio = 0; inicio < v_repetidos_columnas.length; inicio++) {
                mensaje += "Columna " + (inicio + 1) + ": " + v_repetidos_columnas[inicio] + "\n";
            }

            return mensaje;
        } 
        
        catch (Exception e) {
            throw new Exception("Error en el método Ejercicio_9" + e.toString());
        }
    }

}
