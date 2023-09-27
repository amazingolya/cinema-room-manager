package cinema;

import java.text.DecimalFormat;
import java.util.Arrays;

public class Room {
    private final int rows;
    private final int columns;

    private final String[][] cinemaRoom;

    private int purchasedTickets = 0;
    private int currentIncome = 0;

    public Room(final int rows, final int columns) {
        this.rows = rows;
        this.columns = columns;
        this.cinemaRoom = new String[rows + 1][columns + 1];
        fillRoom();
    }

    private void fillRoom() {
        cinemaRoom[0][0] = " ";
        for (int i = 1; i <= columns; i++) {
            cinemaRoom[0][i] = i + "";
        }
        for (int i = 1; i <= rows; i++) {
            cinemaRoom[i][0] = i + "";
            for (int j = 1; j <= columns; j++) {
                cinemaRoom[i][j] = "S";
            }
        }
    }

    public void showTheSeats() {
        System.out.println("Cinema:");
        for (String[] row: cinemaRoom) {
            System.out.println(Arrays.toString(row).replaceAll(",", "")
                    .replaceAll("\\[", "")
                    .replaceAll("]", ""));
        }
    }

    public boolean buyTicket(final int row, final int seat) {
        if (row < 0 || row > rows || seat < 0 || seat > columns) {
            System.out.println("Wrong input!");
            return false;
        }
        if (cinemaRoom[row][seat].equals("B")) {
            System.out.println("That ticket has already been purchased!");
            return false;
        }
        cinemaRoom[row][seat] = "B";
        purchasedTickets++;
        int ticketPrice = rows * columns < 60 || rows / 2 >= row ? 10 : 8;
        currentIncome += ticketPrice;
        System.out.println("Ticket price: $" + ticketPrice);
        return true;
    }

    public int countTotalIncome() {
        int profit;
        if (rows * columns < 60) {
            profit = rows * columns * 10;
        } else {
            profit = rows / 2 * columns * 10 + (rows - rows / 2) * columns * 8;
        }
        return profit;
    }

    private String formPercentage() {
        if (purchasedTickets == 0) {
            return "0.00%";
        }
        double percentage = (purchasedTickets * 100.00) / (rows * columns);
        DecimalFormat df = new DecimalFormat("#.00");
        return df.format(percentage) + "%";
    }

    public void showStatistics() {
        System.out.println("Number of purchased tickets: " + purchasedTickets);
        System.out.println("Percentage: " +  formPercentage());
        System.out.println("Current income: $" + currentIncome);
        System.out.println("Total income: $" + countTotalIncome());
    }

}
