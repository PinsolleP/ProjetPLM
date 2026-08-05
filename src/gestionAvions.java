import java.util.*;

public class gestionAvions {
    /**
     * Application de gestion d'avions.
     * Permet d'afficher les avions, de rechercher un programme,
     * d'ajouter une pièce et de supprimer une pièce.
     */
    protected static List<Map<String, Object>> planes = new ArrayList<>();
    /**
     * Liste contenant tous les avions enregistrés.
     */
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        /**
         * Point d'entrée du programme.
         * Initialise les données puis affiche le menu principal.
         *
         * @param args arguments de la ligne de commande (non utilisé ici)
         */
        initplanes();
        userChoice();
        scanner.close();
    }

    public static void initplanes() {
        /**
         * Initialise la liste des avions avec leurs informations
         * et leurs pièces.
         */

        //Avion 1
        Map<String, Object> plane1 = new HashMap<>();
        plane1.put("id", "1");
        plane1.put("programme", "A380");
        plane1.put("phase actuelle", "construction");
        plane1.put("type", "transport passager");

        // Liste des pieces avion 1
        List<Map<String, String>> pieces1 = new ArrayList<>();
        Map<String, String> p1 = new HashMap<>();
        p1.put("name", "dérive fixe");
        p1.put("caracteristic", "Aile arrière");
        p1.put("price", "27000 €");
        pieces1.add(p1);

        Map<String, String> p2 = new HashMap<>();
        p2.put("name", "reacteur 812");
        p2.put("caracteristic", "Moteur");
        p2.put("price", "63000 €");
        pieces1.add(p2);

        // On met la liste des pieces dans l'avion
        plane1.put("pieces", pieces1);
        planes.add(plane1);

        //Avion 2
        Map<String, Object> plane2 = new HashMap<>();
        plane2.put("id", "2");
        plane2.put("programme", "A220");
        plane2.put("phase actuelle", "en service");
        plane2.put("type", "militaire");

        // Liste des pieces de l'avion 2
        List<Map<String, String>> pieces2 = new ArrayList<>();
        Map<String, String> p3 = new HashMap<>();
        p3.put("name", "siège");
        p3.put("caracteristic", "habitacle");
        p3.put("price", "7000 €");
        pieces2.add(p3);

        // On met la liste des pieces dans l'avion 2
        plane2.put("pieces", pieces2);
        planes.add(plane2);

        //Avion 3
        Map<String, Object> plane3 = new HashMap<>();
        plane3.put("id", "3");
        plane3.put("programme", "A300");
        plane3.put("phase actuelle", "clôturé");
        plane3.put("type", "avion d'affaires");

        // Liste des pieces de l'avion 3
        List<Map<String, String>> pieces3 = new ArrayList<>();
        Map<String, String> p4 = new HashMap<>();
        p4.put("name", "Train arrière P14");
        p4.put("caracteristic", "Train d'atterrissage renforcé");
        p4.put("price", "55000 €");
        pieces3.add(p4);


        Map<String, String> p5 = new HashMap<>();
        p5.put("name", "radar 1800");
        p5.put("caracteristic", "capteur nez avant");
        p5.put("price", "12000 €");
        pieces3.add(p5);

        // On met la liste des pieces dans l'avion 3
        plane3.put("pieces", pieces3);
        planes.add(plane3);

        //Avion 4
        Map<String, Object> plane4 = new HashMap<>();
        plane4.put("id", "4");
        plane4.put("programme", "A350");
        plane4.put("phase actuelle", "en service");
        plane4.put("type", "transport passager");

        // Liste des pieces de l'avion 4
        List<Map<String, String>> pieces4 = new ArrayList<>();
        Map<String, String> p6 = new HashMap<>();
        p6.put("name", "antenne 41");
        p6.put("caracteristic", "capteur");
        p6.put("price", "1000 €");
        pieces4.add(p6);

        // On met la liste des pieces dans l'avion 4
        plane4.put("pieces", pieces4);
        planes.add(plane4);

        //Avion 5
        Map<String, Object> plane5 = new HashMap<>();
        plane5.put("id", "5");
        plane5.put("programme", "A320");
        plane5.put("phase actuelle", "conception");
        plane5.put("type", "transport passager");
        plane5.put("pieces", new ArrayList<Map<String, String>>()); // pas encore de pièces
        planes.add(plane5);
    }

    public static void displayPlane(Map<String, Object> plane) {
        /**
         * Affiche les informations d'un avion ainsi que
         * la liste de ses pièces.
         *
         * @param plane avion à afficher
         */
        System.out.println("Avions " + plane.get("id"));
        System.out.println("Programme :" + plane.get("programme"));
        System.out.println("Phase :" + plane.get("phase actuelle"));
        System.out.println("Type :" + plane.get("type"));

        List<Map<String, String>> pieces = (List<Map<String, String>>) plane.get("pieces");
        if (pieces.isEmpty()) {
            System.out.println("Aucune pièce enregistrée.");
        } else {
            for (Map<String, String> piece : pieces) {
                System.out.println("Pièce : " + piece.get("name") +
                        " | " + piece.get("caracteristic") +
                        " | " + piece.get("price"));
            }
        }
        System.out.println();
    }

    public static void displayPlanes() {
        /**
         * Affiche tous les avions enregistrés.
         */
        for (Map<String, Object> avion : planes) {
            displayPlane(avion);
        }
    }

    public static Integer userChoice() {
        /**
         * Affiche le menu principal et exécute l'action
         * choisie par l'utilisateur.
         *
         * @return le dernier choix saisi par l'utilisateur
         */
        String[] choice = {"1 - Afficher tous les avions",
                "2 - Rechercher un/des avions grâce au programme",
                "3 - Ajouter une pièce à l'avion",
                "4 - Supprimer une pièce de l'avion",
                "0 - Quitter"};


        int selection = -1;

        while (selection != 0) {
            System.out.println("\nQue voulez vous faire ? :");
            for (String option : choice) {
                System.out.println(option);
            }
            System.out.println("Votre choix [sélectionner le numéro correspondant] :");

            if (scanner.hasNextInt()) {
                selection = scanner.nextInt();
                scanner.nextLine();


                switch (selection) {
                    case 1:
                        displayPlanes();
                        break;
                    case 2:
                        searchplanes();
                        break;
                    case 3:
                        addpiece();
                        break;
                    case 4: deletepiece();
                        break;
                    case 0:
                        System.out.println("Au revoir !");
                        break;
                    default:
                        System.out.println("Choix invalide, veuillez réessayer.");
                }
            } else {
                System.out.println("Veuillez entrer un chiffre valide.");
                scanner.nextLine();
            }
        }
        return selection;
    }

    public static void searchplanes() {
        /**
         * Recherche un avion à partir de son programme
         * et affiche ses informations s'il existe.
         */
        System.out.println("Quel programme recherchez vous ?");
        String search = scanner.nextLine().trim();

        boolean find = false;

        for (Map<String, Object> plane : planes) {
            if (plane.get("programme").toString().equalsIgnoreCase(search)) {
                displayPlane(plane);
                find = true;
                break;
            }
        }
        if (!find) {
            System.out.println("Aucun avion trouvé avec le programme \"" + search + "\"");
        }
    }

    public static void addpiece() {
        /**
         * Ajoute une nouvelle pièce à un avion
         * identifié par son identifiant.
         */
        System.out.println("Saisissez le nom de la pièce :");
        String reponse = scanner.nextLine().trim();

        List<Map<String, String>> pieces5 = new ArrayList<>();
        Map<String, String> p1 = new HashMap<>();
        p1.put("name", reponse);
        pieces5.add(p1);

        System.out.println("Saisissez les caractéristique de la pièce :");
        String searchcaracteristic = scanner.nextLine().trim();
        p1.put("caracteristic", searchcaracteristic);

        System.out.println("Saisissez le prix de la pièce :");
        String searchprice = scanner.nextLine().trim();
        p1.put("price", searchprice);

        System.out.println("Saisissez l'id de l'avion pour ajouter la pièce :");
        String searchplane = scanner.nextLine().trim();

        boolean find = false;


        for (Map<String, Object> plane : planes) {
            if (plane.get("id").toString().equalsIgnoreCase(searchplane)) {
                List<Map<String, String>> pieces = (List<Map<String, String>>) plane.get("pieces");

                Map<String, String> piece = new HashMap<>();
                piece.put("name", reponse);
                piece.put("caracteristic", searchcaracteristic);
                piece.put("price", searchprice);

                pieces.add(piece);

                find = true;
                break;
            }
        }
        if (!find) {
            System.out.println("Aucun avion trouvé avec l' id \"" + searchplane + "\"");

        }
    }

    public static void deletepiece() {
        /**
         * Supprime une pièce d'un avion à partir
         * du nom de la pièce saisi par l'utilisateur.
         */
        System.out.println("Saisissez l'id de l'avion :");
        String searchid = scanner.nextLine().trim();


        for (Map<String, Object> plane : planes) {
            if (plane.get("id").equals(searchid)) {
                List<Map<String, String>> pieces = (List<Map<String, String>>) plane.get("pieces");

                System.out.println("Saisissez le nom de la pièce à supprimer :");
                String searchname = scanner.nextLine().trim();

                boolean found = false;

                for (int i = 0 ; i < pieces.size(); i ++){
                    if (pieces.get(i).get("name").equalsIgnoreCase(searchname)){
                        pieces.remove(i);
                        found = true;
                        System.out.println("Pièce \"" + searchname + "\" supprimée.");
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Aucune pièce trouvé avec le nom \"" + searchname + "\"");
            }
        }
        }
    }
}





