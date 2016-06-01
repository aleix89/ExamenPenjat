package examenaco;



import java.util.Scanner;
import java.util.Random;

/**
 * Aquet programa es el joc del penjat , tens 3 paraules que sortiran al atzar
 * i l'usuari anirà proban lletres.
 * 
 * Si endevina la lletra es descubrira la paraula.
 * Si s'equivoca 5 vegadas perd la partida.
 *   
 * 
 * 
 * @author ies
 *
 */


public class Main {

    static protected String paraules[] = {"hola","programacio","casa"};
    static protected int index;
    static protected String p;


    /**   
     *  
     * En el main es crea un objecte random que s'utilitzara per donar un valor de 0 al 2 a la variable index
     * Aquesta variable s'utilitzara per crear la longitud de la variable p i iniciarla amb guions baixos "_".
     * 
     * Un cop inicialitzada si la string p no es igual a la string del vector i els erros son menys de 5 es comprovara
     * la lletra que entri per teclat. Si el metode nova_lletra retorna tobada = fals hi suma un error.
     * 
     *  Si arriba a 5 errors o es troba la paraula surt del bucle i printa la paraula.
     *  
     *
     * @param args
     */
    
    public static void main(String[] args) {
        System.out.println("Comença el joc!");


        
        Random rand = new Random();
        index = rand.nextInt(3);
        System.out.println(index);

        
        for (int i=0; i<paraules[index].length(); i++) {
            p += "_";
        }

        System.out.println(p);

        Scanner reader = new Scanner(System.in);

        int num_errors = 0;

        while (!p.equals(paraules[index]) && num_errors < 5) {
            if (!nova_lletra(reader.next().charAt(0))) {
                num_errors++;
            }
            System.out.println(p);
        }
   }

    
    /**
     * Funcion que es li passen per parametre una char amb una lletra. Es crea un boolea iniciat a false i una string per guardar
     * la string anterior i no es perdi.
     * La string p la budiem.
     * 
     * Despres comprovarem que la lletra hi es en la string del vector i si es igual a la lletra pasada per parametre,
     * es copiará en la pocició trobada i el boolea trobada canviara a true.
     * 
     * Si no lletra no es troba la string p copiara la lletra de la string de la paraula anterior.
     *
     * 
     * @param nova  es el char passat per parametre conté la lletra que s'utilitzarà per comprobar.
     * @return Returnara el valor del boolea trobada. Cert si troba la lletra i fals si no la troba.
     */
    
    static public boolean nova_lletra(char nova) {
        boolean trobada = false;
        String paraula_old = p;
        p = "";
        for (int i=0; i<paraules[index].length(); i++) {
            if (paraules[index].charAt(i) == nova) {
                p += paraules[index].charAt(i);
                trobada = true;
            }
            else {
                p += paraula_old.charAt(i);
            }
        }
        return trobada;
    }

}
