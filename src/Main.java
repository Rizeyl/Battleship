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
    public static final char SHIP_PART = 'O';
    public static final char SYMBOL_DAMAGE = 'X';
    public static final char SYMBOL_SEA_STRIKE = '*';

    public static void main(String[] args) {
        char[][] seaArray = new char[10][10];


        generateMap(seaArray);

        printMap(seaArray);

    }

    private static void generateMap(char[][] seaArray) {
        //Заполняем горизонтальную границу
        for (int i = 0; i <= 10; i++) {
            System.out.printf(ANSI_YELLOW + "[%d]", i);
        }
        System.out.println();

        //Заполняем массив

        for (int i = 0; i < seaArray.length; i++) {
            for (int j = 0; j < seaArray.length; j++) {
                // if (seaArray[i][j] == SHIP_PART) {
                //System.out.println(SHIP_PART + ANSI_GREEN);
                seaArray[2][2] = SHIP_PART;
                seaArray[1][2] = SYMBOL_DAMAGE;
                seaArray[7][5] = SYMBOL_SEA_STRIKE;
                seaArray[i][j] = SYMBOL_SEA;

                // }
            }
        }
    }

    private static void printMap(char[][] seaArray) {
        //Распечатываем массив
        for (int i = 0; i < seaArray.length; i++) {
            //Заполняем вертикальную границу
            System.out.printf(ANSI_YELLOW + "[%c]", 'A' + i);
            for (int j = 0; j < seaArray[i].length; j++) {
                if (seaArray[i][j] == SYMBOL_SEA) {
                    System.out.print(ANSI_BLUE + "[" + seaArray[i][j] + "]");
                }
                if (seaArray[i][j] == SHIP_PART) {
                    System.out.print(ANSI_GREEN + "[" + seaArray[i][j] + "]");

                }
                if (seaArray[i][j] == SYMBOL_DAMAGE) {
                    System.out.print(ANSI_RED + "[" + seaArray[i][j] + "]");
                }
                if (seaArray[i][j] == SYMBOL_SEA_STRIKE) {
                    System.out.print(ANSI_WHITE + "[" + seaArray[i][j] + "]");
                }
            }
            System.out.println();
        }
    }
}
