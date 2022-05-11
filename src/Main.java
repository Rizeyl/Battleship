import java.util.Arrays;

public class Main {
    public static final String ANSI_BLUE = "\u001B[34m";

    public static void main(String[] args) {
        String[][] seaArray = new String[10][10];
        String sea = "[~]";

//        String[] fieldNumb = {"1", "2", "3", "4", "5", "6", "7", "8", "8", "10"};
//        String[] fieldCh = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
//        String[][] field = new String[10][10];

//        for (int i = 0; i < fieldNumb.length; i++) {
//            for (int j = 0; j < fieldCh.length; j++) {
//            }
//        }
        //Заполняем массив


        for (int i = 0; i < seaArray.length; i++) {
            for (int j = 0; j < seaArray.length; j++) {
                seaArray[i][j] = sea;
            }
        }
        //Распечатываем массив
        for (int i = 0; i < seaArray.length; i++) {
            for (int j = 0; j < seaArray[i].length; j++) {
                System.out.print(ANSI_BLUE + seaArray[i][j]);
            }
            System.out.println();
        }

    }
}
