import java.util.Scanner;
public class Main{
    
    public static int[] generarPrimos (int max){

        int i,j;
        if (max >= 2) {
            int tamanoArray = max + 1; // Tamaño del array
            boolean[] esPrimo = new boolean[tamanoArray];
            inicializarArray(tamanoArray, esPrimo);
            cribaDatos(tamanoArray, esPrimo);
            int cuenta = recuentoPrimos(tamanoArray, esPrimo);
            int[] primos = new int[cuenta];

            for (i=0, j=0; i<tamanoArray; i++) {
                if (esPrimo[i])
                    primos[j++] = i;
            }
            return primos;
            
            } else {
            return new int[0];
            }
        }

    private static int recuentoPrimos(int tamanoArray, boolean[] esPrimo) {
        int i;
        int cuenta = 0;
        for (i=0; i< tamanoArray; i++) {
        if (esPrimo[i])
        cuenta++;
        }
        return cuenta;
    }

    private static void cribaDatos(int tamanoArray, boolean[] esPrimo) {
        int i;
        int j;
        for (i=2; i<Math.sqrt(tamanoArray)+1; i++) {
        if (esPrimo[i]) {

        for (j=2*i; j< tamanoArray; j+=i)
        esPrimo[j] = false;
        }
      }
    }

    private static void inicializarArray(int tamanoArray, boolean[] esPrimo) {
        int i;
        for (i=0; i< tamanoArray; i++) {
            esPrimo[i] = true;
            esPrimo[0] = esPrimo[1] = false;
        }
    }

    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        System.out.println("Introduce el número para la criba de Erastótenes:");
        int dato=teclado.nextInt();
        int[] vector =new int[dato];
        System.out.println("\nVector inicial hasta :"+dato);
        for (int i = 0; i < vector.length; i++) {
            if (i%10==0) System.out.println();
            System.out.print(i+1+"\t");
        }
        vector=generarPrimos(dato);
        System.out.println("\nVector de primos hasta:"+dato);
        for (int i = 0; i < vector.length; i++) {
            if (i%10==0) System.out.println();
            System.out.print(vector[i]+"\t");
        }
    }
}
