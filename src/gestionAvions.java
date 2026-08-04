import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class gestionAvions {
    public static void main(String[] args) {
        //System.out.println(initplanes());
        //displayavions();
        userChoice();

    }

    public static Map<Integer, Map<String, String>> initplanes() {
        Map<Integer, Map<String, String>> planes = new HashMap<>();

        Map<String, String> plane1 = new HashMap<>();
        Map<String, String> plane2 = new HashMap<>();
        Map<String, String> plane3 = new HashMap<>();
        Map<String, String> plane4 = new HashMap<>();
        Map<String, String> plane5 = new HashMap<>();


        plane1.put("programme", "A380");
        plane1.put("phase actuelle", "construction");
        plane1.put("type", "transport passager");

        plane2.put("programme", "A220");
        plane2.put("phase actuelle", "en service");
        plane2.put("type", "militaire");

        plane3.put("programme", "A300");
        plane3.put("phase actuelle", "clôturé");
        plane3.put("type", "avion d'affaires");

        plane4.put("programme", "A350");
        plane4.put("phase actuelle", "en service");
        plane4.put("type", "transport passager");

        plane5.put("programme", "A320");
        plane5.put("phase actuelle", "conception");
        plane5.put("type", "transport passager");

        planes.put(1, plane1);
        planes.put(2, plane2);
        planes.put(3, plane3);
        planes.put(4, plane4);
        planes.put(5, plane5);

        return planes;
    }

    public static void displayplanes() {
        for (Map.Entry<Integer, Map<String, String>> entreeExterne : initplanes().entrySet()) {
            Integer cleExterne = entreeExterne.getKey();
            Map<String, String> sousMap = entreeExterne.getValue();
            System.out.println("Id avion : " + cleExterne);

            for (Map.Entry<String, String> entreeInterne : sousMap.entrySet()) {
                String cleInterne = entreeInterne.getKey();
                String valeur = entreeInterne.getValue();
                System.out.println(" " + cleInterne + " : " + valeur);
            }
        }
    }

    public static String userChoice() {
        String[] choice = {"1 - Afficher tous les avions",
                "2 - Rechercher un/des avions grâce au programme",
                "3 - Ajouter une pièce à l'avion",
                "4 - Supprimer une pièce de l'avion",
                "5 - Afficher toutes les pièces de l'avion"};

        Scanner reponse = new Scanner(System.in);

        int selection = -1;

        while (selection != 0) {
            System.out.println("Que voulez vous faire ? :");
            for (String option : choice) {
                System.out.println(option);
            }
            System.out.print("Votre choix [sélectionner le numéro correspondant] :");

            if (reponse.hasNextInt()){
                selection = reponse.nextInt();
                reponse.nextLine();

                switch (selection){
                    case 1 -> displayplanes();
                    case 2 -> searchplanes();
                    case 3 -> addpiece();
                    case 4 -> deletepiece();
                    case 5 -> displaypiece();

                }
            }

        }
    }
}


