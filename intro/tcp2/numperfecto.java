   package tcp2;


   public class numperfecto{

   public static boolean esNumeroPerfecto(int numero) {
    int suma = 0;
    for (int i = 1; i < numero; i++) {
        if (numero % i == 0) {
            suma += i;
        }
    }
    return suma == numero;
}

   }