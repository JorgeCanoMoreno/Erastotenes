package paquete1;

public class Criba {

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
    public static void inicializarArray(int tamanoArray, boolean[] esPrimo) {
        int i;
        for (i=0; i< tamanoArray; i++) {
            esPrimo[i] = true;
            esPrimo[0] = esPrimo[1] = false;
        }
    }
    public static void cribaDatos(int tamanoArray, boolean[] esPrimo) {
        int i;
        int j;
        for (i=2; i<Math.sqrt(tamanoArray)+1; i++) {
            if (esPrimo[i]) {
                for (j=2*i; j< tamanoArray; j+=i)
                    esPrimo[j] = false;
            }
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

}
