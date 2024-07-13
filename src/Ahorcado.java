import java.util.Scanner;

public class Ahorcado {
    public static void main(String[] args) throws Exception {
        Scanner read=new Scanner(System.in);
        String palabraSecreta = "creatividad";
        int intentosMaximos=palabraSecreta.length();
        int intentos=0;
        boolean acertado=false;

        char[] letrasInsertadas = new char[palabraSecreta.length()];

        for (int i = 0; i<palabraSecreta.length(); i++) {
            letrasInsertadas[i]='_';
        }

        System.out.println("***** Bienvenido al juego de Ahorcado *****");
        System.out.println("- Adivina la palabra misteriosa y ganarás ... !");
        System.out.println("Total de intentos "+intentosMaximos);


        while (!acertado) {
            System.out.println("Palabra misteriosa: " + String.valueOf(letrasInsertadas) + "  (" + palabraSecreta.length() + ")");

            System.out.print("Ingresa un caracter: ");
            char caracter=Character.toLowerCase(read.next().charAt(0)); //toma el primer caracter
            boolean caracterEncontrado=false;

            for(int j=0; j<letrasInsertadas.length; j++){
                if (caracter == palabraSecreta.charAt(j)) {
                    letrasInsertadas[j]=caracter;
                    caracterEncontrado=true;
                }
            }
            if (caracterEncontrado) {
                System.out.println("Genial, el caracter "+caracter+" sí se encuentra en la palabra");
            } else {
                System.out.println("Lo siento, el caracter "+caracter+ " no se encuentra en la palabra");
                intentos++;
                System.out.println("Te quedan "+(intentosMaximos-intentos));
            }

            if (String.valueOf(letrasInsertadas).equals(palabraSecreta) && intentosMaximos>intentos) {
                acertado=true;
                System.out.println("Genial la palabra secreta es: "+palabraSecreta);
            }
            if (intentos == intentosMaximos) {
                System.out.println("Que mal te quedaste sin intentos");
                acertado=true;
            }
        }
    }
}
