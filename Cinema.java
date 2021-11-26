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
        int totalIncome = ((rows / 2) * seatsPerRow * 10) + ((rows - (rows / 2)) * seatsPerRow * 8);

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

            System.out.print("1. Show the seats\n2. Buy a ticket\n3. Statistics\n0. Exit \n");
            int input = scanner.nextInt();

            switch (input) {
                case 1:
                    printArray(cinema);
                    break;
                case 2:
                    buyTicket(cinema, cinemaSize, rows);
                    printArray(cinema);

                    break;
                case 3:
                    printStats(cinema, cinemaSize, totalIncome);
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
        int row;
        int seat;
        boolean repeatInput;

        do {
            repeatInput = false;
            System.out.println("Enter a row number:");
            row = scanner.nextInt();
            System.out.println("Enter a seat number in that row:");
            seat = scanner.nextInt();

            if (row < 1 || row > theater.length - 1) {
                System.out.println("Wrong input!");
                repeatInput = true;
            } else if (seat < 1 || seat > theater[0].length - 1) {
                System.out.println("Wrong input!");
                repeatInput = true;
            } else if ("B ".equals(theater[row][seat])) {
                System.out.println("That ticket has already been purchased!");
                repeatInput = true;
            }

        } while (repeatInput);

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

    public static void printStats(String [][] theater, int theaterSize, int total) {
        int purchasedTickets = 0;
        int income = 0;
        int rows = 0;
        for (String[] Rows: theater) {
            for (String Seats : Rows) {
                if ((Seats).contains("B")) {
                    purchasedTickets++;
                    if (rows <= ((theater.length - 1) / 2)) {
                        income += 10;
                    } else {
                        income += 8;
                    }

                }
            }
            rows++;
        }
            System.out.printf("Number of purchased tickets: %d\n", purchasedTickets);
            System.out.printf("Percentage: %.2f%%\n", (float)purchasedTickets / theaterSize * 100);
            System.out.printf("Current income: $%d\n", income);
            System.out.printf("Total income: $%d\n", total);

        }
    }
