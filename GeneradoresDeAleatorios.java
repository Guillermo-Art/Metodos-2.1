import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class GeneradoresDeAleatorios{

    public GeneradoresDeAleatorios(){
        
    }

    public List<Integer> congruencia_lineal_mixto(int X0, int a, int c, int m){
        int bandera_ciclo = 0;
        int periodo = 0;

        List<Integer> aleatorios = new ArrayList<Integer>();

        while(bandera_ciclo != X0){
            if(periodo == 0)
                bandera_ciclo = X0;

            X0 = ((a * X0) + c) % m;
            System.out.println(X0);
            aleatorios.add(X0);
            periodo ++;
        }
        System.out.println("Periodo: " + periodo);

        return aleatorios;
    }

    public List<Integer> congruencia_lineal_multiplicativo(int X0, int a, int m){
        int bandera_ciclo = 0;
        int periodo = 0;

        List<Integer> aleatorios = new ArrayList<Integer>();

        while(bandera_ciclo != X0){
            if(periodo == 0)
                bandera_ciclo = X0;

            X0 = (a * X0) % m;
            System.out.println(X0);
            aleatorios.add(X0);
            periodo ++;
        }
        System.out.println("Periodo: " + periodo);

        return aleatorios;
    }
}