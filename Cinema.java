package cinema;
import java.util.Scanner;

public class Cinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seatsPerRow = scanner.nextInt();

        if (rows * seatsPerRow <= 60) {
            System.out.println("Total income:");
            System.out.printf("$%d", rows * seatsPerRow * 10);
        } else {
            int frontHalf = rows / 2;
            int frontPrice = frontHalf * seatsPerRow * 10;
            int backPrice = (rows - frontHalf) * seatsPerRow * 8;
            System.out.println("Total income:");
            System.out.printf("$%d", frontPrice + backPrice);
        }
    }

        /* System.out.println("Cinema:");
        for (int i = 0; i < cinema.length; i++) {
            for (int j = 0; j < cinema[i].length; j++) {
                if (i == 0 && j == 0){
                   cinema[i][j] = " ";
                } else if (i == 0) {
                    cinema[i][j] = j+" ";
                } else if (j == 0) {
                    cinema[i][j] = i+" ";
                } else {
                    cinema[i][j] = "S ";
                }

                System.out.print(cinema[i][j]);
            }
            System.out.println();
        }

    }*/
}