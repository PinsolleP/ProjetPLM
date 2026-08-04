import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class gestionAvions {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println (initavion());
        displayavions();²

    }
    public static Map<Integer, Map<String, String>> initavion() {
        Map<Integer, Map<String, String>> avions = new HashMap<>();

        Map<String, String> avion1 = new HashMap<>();
        Map<String, String> avion2 = new HashMap<>();
        Map<String, String> avion3 = new HashMap<>();
        Map<String, String> avion4 = new HashMap<>();
        Map<String, String> avion5 = new HashMap<>();


        avion1.put("programme" , "A380");
        avion1.put("phase actuelle" , "construction");
        avion1.put("type" , "transport passager");

        avion2.put("programme" , "A220");
        avion2.put("phase actuelle" , "en service");
        avion2.put("type" , "militaire");

        avion3.put("programme" , "A300");
        avion3.put("phase actuelle" , "clôturé");
        avion3.put("type" , "avion d'affaires");

        avion4.put("programme" , "A350");
        avion4.put("phase actuelle" , "en service");
        avion4.put("type" , "transport passager");

        avion5.put("programme" , "A320");
        avion5.put("phase actuelle" , "conception");
        avion5.put("type" , "transport passager");

        avions.put(1, avion1);
        avions.put(2, avion2);
        avions.put(3, avion3);
        avions.put(4, avion4);
        avions.put(5, avion5);

        return avions;
    }
    public static void displayavions(){
        for (Map.Entry<Integer, Map<String, String>> entreeExterne : initavion().entrySet()){
            Integer cleExterne = entreeExterne.getKey();
            Map<String, String> sousMap = entreeExterne.getValue();
            System.out.println("Id avion : " + cleExterne);

            for (Map.Entry<String, String> entreeInterne : sousMap.entrySet()){
                String cleInterne = entreeInterne.getKey();
                String valeur = entreeInterne.getValue();
                System.out.println(" " + cleInterne + " : " + valeur);
            }
        }
    }
}
