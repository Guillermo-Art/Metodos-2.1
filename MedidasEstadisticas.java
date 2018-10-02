//Fernando Castillo Cosme               A01328869
//Guillermo Arturo Hernández Tapia      A01321776

import java.util.Collections;
import java.util.List;

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

    public int moda_estadistica(List<Integer> datos){
        int moda = 0;
        int num_datos = datos.size();
        int frecuencia_aux = 0, frecuencia_moda = 0;

        Collections.sort(datos);

        for(int i=0; i < num_datos; i++){
            frecuencia_aux = 1;
            for(int j = i + 1; j < num_datos; j++){
                if(datos.get(i) == datos.get(j))
                    frecuencia_aux++;
            }
            if(frecuencia_aux > frecuencia_moda){
                frecuencia_moda = frecuencia_aux;
                moda = datos.get(i);
            }
        }
        return moda;
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
