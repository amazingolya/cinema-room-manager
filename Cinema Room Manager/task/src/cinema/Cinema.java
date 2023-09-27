package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();

        System.out.println("Enter the number of seats in each row:");
        int columns = scanner.nextInt();

        Room cinemaRoom = new Room(rows, columns);

        int option;
        do {
            printMenu();
            option = scanner.nextInt();
        } while (executeCommand(option, cinemaRoom, scanner));

    }

    public static void printMenu() {
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
    }

    public static boolean executeCommand(final int option, final Room cinemaRoom,
                                         final Scanner scanner) {
        switch (option) {
            case 1: {
                cinemaRoom.showTheSeats();
                System.out.println();
                break;
            }
            case 2: {
                boolean isPurchaseSuccessful;
                do {
                    System.out.println("Enter a row number:");
                    int row = scanner.nextInt();
                    System.out.println("Enter a seat number in that row:");
                    int seat = scanner.nextInt();
                    isPurchaseSuccessful = cinemaRoom.buyTicket(row, seat);
                } while (!isPurchaseSuccessful);
                System.out.println();
                break;
            }
            case 3: {
                cinemaRoom.showStatistics();
                System.out.println();
                break;
            }
            case 0: {
                return false;
            }
        }
        return true;
    }
}