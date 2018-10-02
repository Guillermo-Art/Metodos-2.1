//Fernando Castillo Cosme               A01328869
//Guillermo Arturo Hernández Tapia      A01321776

import java.util.Collections;
import java.util.*;

public class MedidasEstadisticas{

    public MedidasEstadisticas(){

    }

    public float media_estadistica(List<Integer> datos){
        float suma = 0f;

        for (int n : datos) {
            suma += n;
        }
        return (suma / datos.size());
    }

    public float mediana_estadistica(List<Integer> datos){
        int pos = 0;
        int num_datos = datos.size();
        float aux1, aux2 = 0f;

        Collections.sort(datos);

        aux1 = num_datos / 2;
        if(num_datos % 2 == 0){
            pos = (int)aux1;
            aux2 = (float)(datos.get(pos) + datos.get(pos - 1))/2;
        }
        if(num_datos % 2 == 1){
            pos = (int)(aux1 + 0.5);
            aux2 = (float)(datos.get(pos));
        }
        return aux2;
    }

    public void moda_estadistica(List<Integer> datos){
        List<Integer> moda = new ArrayList<Integer>();
        int maxCount=0, i =0;

        for (i=0; i<datos.size(); ++i) {
          int count=0;
          for (int j=0; j<datos.size(); ++j) {
            if (datos.get(j) == datos.get(i)) ++count;
          }
          if (count>maxCount) {
            maxCount=count;
            moda.clear();
            moda.add(datos.get(i));
          }
          else if (count == maxCount) {
            moda.add(datos.get(i));
          }
        }

        Set<Integer> set = new HashSet<>();
        set.addAll(moda);
        moda.clear();
        moda.addAll(set);
        Collections.sort(moda);

        for (i=0; i<moda.size(); i++) {
          System.out.print(moda.get(i)+", ");
        }

    }

    public float varianza_estadistica(List<Integer> datos){
        float suma_potencias = 0f;
        float media = media_estadistica(datos);

        for (int n : datos) {
            suma_potencias += potencia((n - media), 2);
        }

        return (suma_potencias / datos.size());
    }

    public float desviacion_estandar(float n){
        return sqrt(n);
    }

    private int potencia(float base, int exponente){
        int resultado = 1;
        for(int i=0; i < exponente; i++){
            resultado *= base;
        }
        return resultado;
    }

    private float sqrt(float n){
        if(n < 0f)
            return -1;
        if(n == 0f || n == 1f)
            return (float)n;

        float raiz = 0.0f;
        float precision = 0.1f;
        float cuadrado = 0.0f;

        while(cuadrado < n){
            raiz += precision;
            cuadrado = raiz * raiz;
        }
        return raiz;
    }
}
