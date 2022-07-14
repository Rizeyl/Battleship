import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final char SYMBOL_SEA = '~';
    public static final char SYMBOL_PART = 'O';
    public static final char SYMBOL_DAMAGE = 'X';
    public static final char SYMBOL_STRIKE = '*';
    public static final int SIZE = 10;
    static char[][] map = new char[SIZE][SIZE];


    public static void main(String[] args) {


        generateMap();
        do {


            printMap();
            System.out.println();

            System.out.println(ANSI_RESET + "Введите координаты:");
            Scanner scanner = new Scanner(System.in);
            String userIn = scanner.nextLine();
            String s = userIn.replaceAll("\\s+", "").toUpperCase();

            if (s.equalsIgnoreCase("q")) {
                break;
            }
            int row = getRowNo(s);
            int col = getColNo(s);
            if (col == -1 || row == -1) {
                System.out.println("Вы ввели бред");
                continue;
            }

            System.out.println(row + " - " + col);
            if (!isValid1Paluba(row, col)) {
                System.out.println("Nelza.Fu!");
                continue;
            }
            map[row][col] = SYMBOL_PART;

        } while (true);
        System.out.println("Good bye!");


    }

    private static boolean isValid1Paluba(int row, int col) {
        if (row < 0 || row >= SIZE) {
            return false;
        }
        if (col < 0 || col >= SIZE) {
            return false;
        }

        if (map[row][col] != SYMBOL_SEA) {
            return false;
        }


        // left (compact)
        if (col > 0 && map[row][col - 1] != SYMBOL_SEA) {
            return false;
        }

        //right (compact)
        if (col < 9 && map[row][col + 1] != SYMBOL_SEA) {
            return false;
        }

        // top(compact)
        if (row > 0 && map[row - 1][col] != SYMBOL_SEA) {
            return false;
        }

        //bottom (compact)
        if (row < 9 && map[row + 1][col] != SYMBOL_SEA) {
            return false;
        }

        // left-top (compact)
        if (row > 0 && col > 0 && map[row - 1][col - 1] != SYMBOL_SEA) {
            return false;
        }

        //right-bottom (compact)
        if (row < 9 && col < 9 && map[row + 1][col + 1] != SYMBOL_SEA) {
            return false;
        }
        if (row < 9 && col > 0 && map[row+1][col-1] !=SYMBOL_SEA) {
            return false;
        }
        if (row > 0 && col < 9 && map[row-1][col+1] !=SYMBOL_SEA) {
            return false;
        }

        return true;


    }

    private static int getRowNo(String s) {
        boolean is10 = s.length() == 3 && s.charAt(1) == '1' && s.charAt(2) == '0';
        if (s.length() != 2 && !is10) {
            return -1;
        }

        char firstCh = s.charAt(0);
        if (firstCh < 'A' || firstCh > 'J') {
            return -1;
        }
        return firstCh - 'A';
    }

    private static int getColNo(String s) {
        if (s.length() == 3 && s.charAt(1) == '1' && s.charAt(2) == '0') {
            return 9;
        }
        if (s.length() != 2) {
            return -1;
        }
        char secondCh = s.charAt(1);
        if (secondCh < '1' || secondCh > '9') {
            return -1;
        }

        return secondCh - '1';
    }

    private static void generateMap() {
        int randomPlace1 = (int) (Math.random() * 10);
        int randomPlace2 = (int) (Math.random() * 10);

        //Заполняем массив
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                map[i][j] = SYMBOL_SEA;
            }
        }
        map[randomPlace1][randomPlace2] = SYMBOL_PART;
    }

    private static void printMap() {
        System.out.print("\033[H\033[2J");

        //Заполняем горизонтальную границу
        for (int i = 0; i <= 10; i++) {
            System.out.printf(ANSI_YELLOW + "[%d]", i);
        }
        System.out.println();
        //Распечатываем массив
        for (int i = 0; i < map.length; i++) {
            //Заполняем вертикальную границу
            System.out.printf(ANSI_YELLOW + "[%c]", 'A' + i);
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == SYMBOL_SEA) {
                    System.out.print(ANSI_BLUE);

                }
                if (map[i][j] == SYMBOL_PART) {
                    System.out.print(ANSI_GREEN);

                }
                if (map[i][j] == SYMBOL_DAMAGE) {
                    System.out.print(ANSI_RED);
                }
                if (map[i][j] == SYMBOL_STRIKE) {
                    System.out.print(ANSI_WHITE);
                }
                System.out.print("[" + map[i][j] + "]");
            }
            System.out.println();
        }
    }
}
