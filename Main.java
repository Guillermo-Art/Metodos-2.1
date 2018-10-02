//Fernando Castillo Cosme               A01328869
//Guillermo Arturo Hernández Tapia      A01321776

import java.util.List;
import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Main{

    private static MedidasEstadisticas analisis_datos = new MedidasEstadisticas();

    public static void main(String args[]) throws IOException {

        int semilla = 0;
        int multiplicador = 0;
        int corrimiento = 0;
        int modulo = 0;
        int cuantos = 0;

        Scanner sc = new Scanner(System.in);

        semilla = Integer.parseInt(sc.next());
        multiplicador = Integer.parseInt(sc.next());
        corrimiento = Integer.parseInt(sc.next());
        modulo = Integer.parseInt(sc.next());
        cuantos = Integer.parseInt(sc.next());

        sc.close();

        GeneradoresDeAleatorios ga = new GeneradoresDeAleatorios(semilla, multiplicador, corrimiento, modulo, cuantos);

        //ga.get_cola_periodo_ciclo(semilla);

        int intervalo_a = ga.get_aleatorios_en_intervalo(0.0, 0.1);
        System.out.println("[0.0, 0.1]: " + String.format("%.3f", get_porcentaje_aleatorios(cuantos, intervalo_a)) + "%");
        int intervalo_b = ga.get_aleatorios_en_intervalo(0.1, 0.2);
        System.out.println("[0.1, 0.2]: " + String.format("%.3f", get_porcentaje_aleatorios(cuantos, intervalo_b)) + "%");
        int intervalo_c = ga.get_aleatorios_en_intervalo(0.2, 0.3);
        System.out.println("[0.2, 0.3]: " + String.format("%.3f", get_porcentaje_aleatorios(cuantos, intervalo_c)) + "%");
        int intervalo_d = ga.get_aleatorios_en_intervalo(0.3, 0.4);
        System.out.println("[0.3, 0.4]: " + String.format("%.3f", get_porcentaje_aleatorios(cuantos, intervalo_d)) + "%");
        int intervalo_e = ga.get_aleatorios_en_intervalo(0.4, 0.5);
        System.out.println("[0.4, 0.5]: " + String.format("%.3f", get_porcentaje_aleatorios(cuantos, intervalo_e)) + "%");
        int intervalo_f = ga.get_aleatorios_en_intervalo(0.5, 0.6);
        System.out.println("[0.5, 0.6]: " + String.format("%.3f", get_porcentaje_aleatorios(cuantos, intervalo_f)) + "%");
        int intervalo_g = ga.get_aleatorios_en_intervalo(0.6, 0.7);
        System.out.println("[0.6, 0.7]: " + String.format("%.3f", get_porcentaje_aleatorios(cuantos, intervalo_g)) + "%");
        int intervalo_h = ga.get_aleatorios_en_intervalo(0.7, 0.8);
        System.out.println("[0.7, 0.8]: " + String.format("%.3f", get_porcentaje_aleatorios(cuantos, intervalo_h)) + "%");
        int intervalo_i = ga.get_aleatorios_en_intervalo(0.8, 0.9);
        System.out.println("[0.8, 0.9]: " + String.format("%.3f", get_porcentaje_aleatorios(cuantos, intervalo_i)) + "%");
        int intervalo_j = ga.get_aleatorios_en_intervalo(0.9, 1.0);
        System.out.println("[0.9, 1.0]: " + String.format("%.3f", get_porcentaje_aleatorios(cuantos, intervalo_j)) + "%" + "\n");

        imprimeResultadosEstadisticos(ga.get_numeros_aleatorios());
    }

    public static void imprimeResultadosEstadisticos(List<Integer> aleatorios){
        System.out.println("\n*********** Medidas Estadisticas ***********");
        System.out.println("Media: " + analisis_datos.media_estadistica(aleatorios));
        System.out.println("Mediana: " + analisis_datos.mediana_estadistica(aleatorios));
        System.out.print("Moda(s): ");
        analisis_datos.moda_estadistica(aleatorios);
        float varianza = analisis_datos.varianza_estadistica(aleatorios);
        System.out.println("\nVarianza: " + varianza);
        System.out.println("Desviacion estandar: " + analisis_datos.desviacion_estandar(varianza));
    }

    public static double get_porcentaje_aleatorios(int cuantos, int num_valores_intervalo){
        return (double)((100.0 * (double)num_valores_intervalo) / (double)cuantos);
    }
}
