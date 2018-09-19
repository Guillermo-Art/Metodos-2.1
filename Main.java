//Fernando Castillo Cosme A01328869

import java.util.*;

public class Main{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int semilla = Integer.parseInt(sc.nextLine());
    int multiplicador = Integer.parseInt(sc.nextLine());
    int corrimiento = Integer.parseInt(sc.nextLine());
    int modulo = Integer.parseInt(sc.nextLine());
    int c = Integer.parseInt(sc.nextLine());
    int[] cuantos = new int [c];

    int n = Integer.parseInt(sc.nextLine());
    int[] datos = new int[n];
    String[] arr=new String[n];
    int num, den, cont=0;
    int[] frec=new int[n];
    int[] x = new int [n];

    for (int i =0; i<n; i++) {
      datos[i]=Integer.parseInt(sc.nextLine());
    }

    Arrays.sort(datos);


    Set<Integer> set = new HashSet<Integer>();
    for (int numSet : datos) {
      set.add(numSet);
    }

    Integer[] equis = set.toArray(new Integer[0]);
    Integer[] copia = new Integer[equis.length];
    Fraccion[] frac = new Fraccion[equis.length];

    System.arraycopy(equis,0,copia,0,equis.length);

    for (int i = 0; i<equis.length; i++) {
      frec[i]=contarRepeticiones(equis[i], datos);
      frac[i]=new Fraccion(frec[i], n);
    }


    System.out.println("|   X   |   n   |   N   |      f      |      F      |");
    int contador=0;
    for (int i =0; i<equis.length; i++) {
      contador+=frec[i];
      System.out.println("|   "+equis[i] + "   |   " + frec[i] + "   |   " + contador + "   |   " + frac[i] + "   |   " + contador+"/"+n+"   |");
    }

    double media = obtenerMedia(datos, n);
    System.out.println("\nMedia: " + media);

    int mediana = obtenerMediana(datos, n);
    System.out.println("Mediana: " + mediana);

    int moda = obtenerModa(frec);
    System.out.println("Moda: " + equis[moda]);

    double varianza = obtenerVarianza(datos, media, n);
    System.out.println("Varianza: " + varianza);

    System.out.println("Desviacion Estandar: " + sqrt(varianza));
  }

    public static int contarRepeticiones(int n, int[] array){
      int i = 0, cont = 0;

      while(i < array.length){
        if(array[i] == n)
        cont++;
        i++;
      }

      return cont;
    }

    public static double obtenerMedia(int[] array, int n){
      double media=0;
      for (int i =0; i<array.length; i++) {
        media+=array[i];
      }

      return media/n;
    }

    public static int obtenerMediana(int[] array, int n){
      int mediana=0;
      if (n % 2 == 0) {
        n=n/2;
        mediana=(array[n]+array[n+1])/2;
      } else {
        mediana=array[n/2];
      }

      return mediana;
    }

    public static int obtenerModa(int[] array){
      int moda=0;
      for (int i = 0; i<array.length ; i++) {
          if (array[i] > moda) {
            moda=i;
          }
      }

      return moda;
    }

    public static double obtenerVarianza(int[] array, double media, int n){
      double producto=0;
      double sumatoria=0;
      for (int i = 0; i<array.length ; i++) {
        producto=(double)array[i]-media;
        producto=producto*producto;
        producto=producto/(double)n;
        sumatoria+=producto;
      }

      return sumatoria;
    }


    public static double sqrt(double num){
      double x = num;
      if (num >=0) {
        for (int i = 0; i<4; i++) {
          x=((x*x)+num)/(2*x);
        }
      }
      return x;
    }

    public static pseudoAleatorio(int x0, int a, int c, int m){

    }
}
