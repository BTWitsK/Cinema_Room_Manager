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
        int cinemaSize = rows * seatsPerRow;

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

        boolean exit = false;

        while (!exit) {

            System.out.print("1. Show the seats\n2. Buy a ticket\n0. Exit \n");
            int input = scanner.nextInt();

            switch (input) {
                case 1:
                    printArray(cinema);
                    break;
                case 2:
                    buyTicket(cinema, cinemaSize, rows);
                    printArray(cinema);
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    break;
            }
        }

    }
    public static void buyTicket(String [][] theater, int theaterSize, int rows) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a row number:");
        int row = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        int seat = scanner.nextInt();

        int ticketPrice = 10;
        boolean backSeat = row > (rows / 2);

        if (theaterSize > 60 && backSeat) {
            ticketPrice = 8;
        }

        System.out.printf("Ticket price: $%d\n", ticketPrice);
        theater[row][seat] = "B ";
    }

    public static void printArray(String [][] theater) {
        System.out.println("Cinema:");
        for (String[] Rows: theater) {
            for (String Seats: Rows) {
                System.out.print(Seats);
            }
            System.out.println();
        }
    }

}
