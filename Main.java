//Guillermo Arturo Hernández Tapia      A01321776

import java.util.List;
import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Main{

    private static MedidasEstadisticas analisis_datos = new MedidasEstadisticas();
    public static void main(String args[]) throws IOException{

        GeneradoresDeAleatorios ga = new GeneradoresDeAleatorios();

        int semilla = 0;
        int multiplicador = 0;
        int corrimiento = 0;
        int modulo = 0;
        int numero_valores_generados = 0;

        Scanner sc = new Scanner(System.in);
        
        semilla = Integer.parseInt(sc.next());
        multiplicador = Integer.parseInt(sc.next());
        corrimiento = Integer.parseInt(sc.next());
        modulo = Integer.parseInt(sc.next());
        numero_valores_generados = Integer.parseInt(sc.next());

        imprimeResultadosEstadisticos(ga.congruencia_lineal_mixto(semilla, multiplicador, corrimiento, modulo));
        imprimeResultadosEstadisticos(ga.congruencia_lineal_multiplicativo(semilla, multiplicador, modulo));
        
        sc.close();
    }

    public static void imprimeResultadosEstadisticos(List<Integer> aleatorios){
        System.out.println("\n*********** Medidas Estadisticas ***********");
        System.out.println("Media: " + analisis_datos.media_estadistica(aleatorios));
        System.out.println("Mediana: " + analisis_datos.mediana_estadistica(aleatorios));
        System.out.println("Moda: " + analisis_datos.moda_estadistica(aleatorios));
        float varianza = analisis_datos.varianza_estadistica(aleatorios);
        System.out.println("Varianza: " + varianza);
        System.out.println("Desviacion estandar: " + analisis_datos.desviacion_estandar(varianza));
    }
}