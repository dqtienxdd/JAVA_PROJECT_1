import java.util.*;

class Chicken {
    private int number;
    private String name;
    private List<String> tailFeathers;

    public Chicken(int number, String name, String feather) {
        this.number = number;
        this.name = name;
        this.tailFeathers = new ArrayList<>();
        addTailFeather(feather);
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public List<String> getTailFeathers() {
        return tailFeathers;
    }

    public void addTailFeather(String feather) {
        tailFeathers.add(feather);
    }

    public void removeTailFeathers() {
        tailFeathers.clear();
    }
}
class Game {
    private List<String> octagonalTiles;
    private List<String> eggShapedTiles;
    private List<Chicken> chickens;
    private List<String> tailFeathers;
    private int currentPlayer;
    private Map<Chicken, Integer> board;

    public Game() {
        octagonalTiles = new ArrayList<>();
        octagonalTiles.add("flower");       // 1
        octagonalTiles.add("balut");        // 2
        octagonalTiles.add("hedgehog");     // 3
        octagonalTiles.add("feather");      // 4
        octagonalTiles.add("egg");          // 5
        octagonalTiles.add("rabbit");       // 6
        octagonalTiles.add("chicken");      // 7
        octagonalTiles.add("snail");        // 8
        octagonalTiles.add("caterpillar");  // 9
        octagonalTiles.add("worm");         // 10
        octagonalTiles.add("omelette");     // 11
        octagonalTiles.add("chick");        // 12
    
        eggShapedTiles = new ArrayList<>();
        for (String tile : octagonalTiles) {
            eggShapedTiles.add(tile);
            eggShapedTiles.add(tile);
        }
    
        chickens = new ArrayList<>();
        tailFeathers = new ArrayList<>();
        tailFeathers.add("Red");
        tailFeathers.add("Green");
        tailFeathers.add("Blue");
        tailFeathers.add("Yellow");
    
        currentPlayer = 0;
        board = new HashMap<>();
    }
    
    public void setup() {
        //Collections.shuffle(octagonalTiles);
        Collections.shuffle(eggShapedTiles);
    
        for (int i = 0; i < 4; i++) {
            Chicken chicken = new Chicken(i + 1, "Chicken " + tailFeathers.get(i), tailFeathers.get(i));
            chickens.add(chicken);
            board.put(chicken, i * 6); // Place each chicken on an egg-shaped tile with 5 free tiles between them
        }
    }
    
    public void printBoard() {
        System.out.println();
        System.out.println("Board:");
        for (Chicken chicken : chickens) {
            System.out.println(chicken.getName() + " - Space " + (board.get(chicken) + 1) + " - Feather: " + chicken.getTailFeathers());
        }
        System.out.println();
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
    
        while (true) {
            Chicken currentChicken = chickens.get(currentPlayer);
    
            System.out.println("--------------------------------------------------");
            System.out.println("PLAYER " + (currentPlayer + 1) + ", it's your turn.");
            System.out.println();
            System.out.println("CURRENT CHICKEN: " + currentChicken.getName());
    
            boolean correctTile = true;
    
            while (correctTile) {
                printBoard();
    
                int currentSpace = board.get(currentChicken);
                String nextTile = eggShapedTiles.get(currentSpace);
                System.out.println("Next tile: " + nextTile);
    
                System.out.print("Guess the number of the octagonal tile (1 to 12): ");
                int guessedNumber = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
    
                if (guessedNumber >= 1 && guessedNumber <= octagonalTiles.size()) {
                    String chosenTile = octagonalTiles.get(guessedNumber - 1);
    
                    if (chosenTile.equals(nextTile)) {
                        int nextSpace = (currentSpace + 1) % eggShapedTiles.size();
                        Chicken nextChicken = getChickenAtSpace(nextSpace);
    
                        if (nextChicken != null) {
                            List<Chicken> overtakenChickens = new ArrayList<>();
                            overtakenChickens.add(nextChicken);
    
                            int overtakenSpace = (nextSpace + 1) % eggShapedTiles.size();
                            Chicken nextAdjacentChicken = getChickenAtSpace(overtakenSpace);
    
                            while (nextAdjacentChicken != null) {
                                overtakenChickens.add(nextAdjacentChicken);
                                overtakenSpace = (overtakenSpace + 1) % eggShapedTiles.size();
                                nextAdjacentChicken = getChickenAtSpace(overtakenSpace);
                            }
                            System.out.println();
                            System.out.println("Overtaking " + overtakenChickens.size() + " chicken(s)! Moving chicken to the next space(s).");
    
                            for (Chicken overtakenChicken : overtakenChickens) {
                                overtakenChicken.removeTailFeathers();
                                currentChicken.addTailFeather(tailFeathers.get(overtakenChicken.getNumber() - 1));
                            }
    
                            board.put(currentChicken, overtakenSpace);
    
                        } else {
                            System.out.println("--------------------------------------------------");
                            System.out.println("CORRECT GUESS! Moving chicken to the next space.");
                            board.put(currentChicken, nextSpace);
                            
                            System.out.println("CURRENT CHICKEN: " + currentChicken.getName());
                        }
                        if (currentChicken.getTailFeathers().size() == 4) {
                            printBoard();
                            System.out.println();
                            System.out.println("Congratulations! Player " + (currentPlayer + 1) + " wins!");
                            return;
                        }
                    } else {
                        System.out.println("--------------------------------------------------");
                        System.out.println("WRONG GUESS! Next player's turn.");
                        correctTile = false;
                    }
                } else {
                    System.out.println("--------------------------------------------------");
                    System.out.println("INVALID GUESS! Next player's turn.");
                    correctTile = false;
                }
            }
            currentPlayer = (currentPlayer + 1) % chickens.size();
            System.out.println();
        }
    }
    private Chicken getChickenAtSpace(int space) {
        for (Chicken chicken : chickens) {
            if (board.get(chicken) == space) {
                return chicken;
            }
        }
        return null;
    }
}

public class ZickeZackeHuhnerkacke {
    public static void main(String[]args) {
        Game game = new Game();
        game.setup();
        game.play();
    }
}