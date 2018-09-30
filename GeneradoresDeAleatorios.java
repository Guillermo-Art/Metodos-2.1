import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class GeneradoresDeAleatorios{

    private int x0;
    private int a;
    private int c;
    private int m;
    private int cuantos;

    private List<Integer> int_aleatorios;
    private List<Double> double_aleatorios;

    public GeneradoresDeAleatorios(int X0, int a, int c, int m, int cuantos){
        this.genera_lineal_mixto(X0, a, c, m, cuantos);  
    }

    public void genera_lineal_mixto(int X0, int a, int c, int m, int cuantos){
        int_aleatorios = new ArrayList<Integer>();
        double_aleatorios = new ArrayList<Double>();
        int semilla = X0;

        for(int i=0; i < cuantos; i++){
            semilla = ((a * semilla) + c) % m;
            int_aleatorios.add(semilla);
        }

        for(int i=0; i < cuantos; i++){
            double_aleatorios.add((double)int_aleatorios.get(i) / (double)m);
        }
    }

    public void get_cola_periodo_ciclo(int semilla){
        int bandera_ciclo = 0;
        int periodo = 0;

        System.out.println("Cola: ");
        while(bandera_ciclo != semilla){
            if(periodo == 0)
                bandera_ciclo = semilla;

            semilla = int_aleatorios.get(periodo); 
            System.out.print(int_aleatorios.get(periodo) + ", ");
            periodo ++;
        }

        System.out.println("\n\nPeriodo: " + periodo);
    }

    public int get_aleatorios_en_intervalo(double limite_inf, double limite_sup){
        int contador = 0;

        for(int i=0; i < int_aleatorios.size(); i++){
            if(limite_inf < double_aleatorios.get(i) && double_aleatorios.get(i) <= limite_sup)
                contador ++;
        }

        return contador;
    }

    public List<Integer> get_numero_aleatorios(){
        return int_aleatorios;
    }
}