//Fernando Castillo Cosme               A01328869
//Guillermo Arturo Hernández Tapia      A01321776

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class GeneradoresDeAleatorios{

    private List<Integer> int_aleatorios;
    private List<Double> double_aleatorios;

    public GeneradoresDeAleatorios(int X0, int a, int c, int m, int cuantos){
        this.genera_lineal_mixto(X0, a, c, m, cuantos);
    }

    public void genera_lineal_mixto(int X0, int a, int c, int m, int cuantos){
        int_aleatorios = new ArrayList<Integer>();
        double_aleatorios = new ArrayList<Double>();
        int semilla = X0;
        //int_aleatorios.add(semilla);

        for(int i=0; i < cuantos; i++){
            semilla = ((a * semilla) + c) % m;
            int_aleatorios.add(semilla);
        }

        for(int i=0; i < cuantos; i++){
            double_aleatorios.add((double)int_aleatorios.get(i) / (double)m);
        }

        get_cola_periodo_ciclo(int_aleatorios);
    }

    public void get_cola_periodo_ciclo(List<Integer> arr){
        int bandera_ciclo = 0, i;
        int repeatI=0, repeatF=0;
        int longitud_ciclo = 0, longitud_cola=0, longitud_periodo=0;
        int contar[] = new int [99999999];

        for (i = 0; i < arr.size(); i++) {
          if (contar[arr.get(i)] == 1) {
            repeatF=i;
            break;
          }
          else
            contar[arr.get(i)]++;
        }

        for (i=0; i<arr.size(); i++) {
          if (arr.get(i) == arr.get(repeatF)) {
            repeatI=i;
            break;
          }
        }

        System.out.print("Cola: ");
        for (i=0; i<repeatI; i++) {
          System.out.print(arr.get(i) + ", ");
          longitud_cola++;
        }
        System.out.println("\nLongitud Cola: " + longitud_cola);

        System.out.print("\nCiclo: ");
        for (i=repeatI; i<=repeatF; i++) {
          System.out.print(arr.get(i) + ", ");
          longitud_ciclo++;
        }
        System.out.println("\nLongitud Ciclo: " + longitud_ciclo);

        System.out.print("\nPeriodo: ");
        for (i=0; i<=repeatF; i++) {
          System.out.print(arr.get(i) + ", ");
          longitud_periodo++;
        }
        System.out.println("\nLongitud Periodo: " + longitud_periodo + "\n");
    }

    public int get_aleatorios_en_intervalo(double limite_inf, double limite_sup){
        int contador = 0;

        for(int i=0; i < int_aleatorios.size(); i++){
            if(limite_inf < double_aleatorios.get(i) && double_aleatorios.get(i) <= limite_sup)
                contador ++;
        }

        return contador;
    }

    public List<Integer> get_numeros_aleatorios(){
        return int_aleatorios;
    }
}
