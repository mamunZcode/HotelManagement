import java.io.*;
import java.util.*;

public class hotelProgram {

    private static boolean mainMenu = true;
    private static boolean subMenu = true;

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        Room[] myHotel = new Room[10];
        for (int i = 0; i < myHotel.length; i++) {
            myHotel[i] = new HotelRoom();
        }

        HotelOperations hotelOperations = new HotelOperations(myHotel);

        hotelOperations.initialiseRooms();

        while (mainMenu) {
            while (subMenu) {
                System.out.println("------------------------------------------");
                System.out.println("Welcome to the Hotel Management Program Made By Mamun");
                System.out.println("------------------------------------------");
                System.out.println("Please select one of the options:");
                System.out.println("A: Book A New Room.");
                System.out.println("E: Display Empty Rooms.");
                System.out.println("V: View All Rooms.");
                System.out.println("D: Delete Customer from Room.");
                System.out.println("F: Find Room from Customer Name.");
                System.out.println("S: Store Program Data into File.");
                System.out.println("L: Load Program Data from File.");
                System.out.println("O: View Rooms Ordered Alphabetically by Name.");
                System.out.println("------------------------------------------");

                String selection = input.next().toUpperCase();

                switch (selection) {
                    case "A":
                        hotelOperations.bookRoom();
                        break;
                    case "E":
                        hotelOperations.displayEmptyRooms();
                        break;
                    case "V":
                        hotelOperations.viewAllRooms();
                        break;
                    case "D":
                        hotelOperations.deleteCustomerFromRoom();
                        break;
                    case "F":
                        hotelOperations.findRoomByCustomerName();
                        break;
                    case "S":
                        hotelOperations.storeDataToFile();
                        break;
                    case "L":
                        hotelOperations.loadDataFromFile();
                        break;
                    case "O":
                        hotelOperations.viewRoomsAlphabetically();
                        break;
                    default:
                        System.out.println("Invalid Selection");
                        break;
                }

                System.out.println("Do you want to select another option? (1: Yes / 2: No)");
                subMenu = input.nextInt() == 1;
            }

            subMenu = true;
            System.out.println("Do you want to continue with the program? (1: Yes / 2: No)");
            mainMenu = input.nextInt() == 1;
        }

        System.out.println("Thank you for using the Hotel Management Program.");
        System.exit(0);
    }
}







