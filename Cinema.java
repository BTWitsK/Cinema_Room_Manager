package cinema;
import java.util.Scanner;

public class Cinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seatsPerRow = scanner.nextInt();

        String[][] cinema = new String[rows + 1][seatsPerRow + 1];

        System.out.println("Cinema:");
        for (int i = 0; i < cinema.length; i++) {
            for (int j = 0; j < cinema[i].length; j++) {
                if (i == 0 && j == 0) {
                    cinema[i][j] = " ";
                } else if (i == 0) {
                    cinema[i][j] = " " + j;
                } else if (j == 0) {
                    cinema[i][j] = i + " ";
                } else {
                    cinema[i][j] = "S ";
                }
                System.out.print(cinema[i][j]);
            }
            System.out.println();
        }

        int cinemaSize = rows * seatsPerRow;
        System.out.println("Enter a row number:");
        int row = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        int seat = scanner.nextInt();

        int ticketPrice = 10;
        boolean backSeat = row > (rows / 2);

        if (cinemaSize > 60 && backSeat) {
            ticketPrice = 8;
        }

        System.out.printf("Ticket price: $%d\n", ticketPrice);
        cinema[row][seat] = "B ";

        System.out.println("Cinema:");
        for (String[] Rows: cinema) {
            for (String Seats: Rows) {
                System.out.print(Seats);
            }
            System.out.println();
        }
    }
}
