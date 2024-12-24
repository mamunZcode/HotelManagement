import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class HotelOperations implements HotelManagement {
    private final Room[] rooms;

    public HotelOperations(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public void initialiseRooms() {
        for (Room room : rooms) {
            room.setName("empty");
        }
        System.out.println("All rooms initialized to empty.");
    }

    @Override
    public void displayEmptyRooms() {
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].getName().equals("empty")) {
                System.out.println("Room " + (i + 1) + " is empty.");
            }
        }
    }

    @Override
    public void bookRoom() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter room number (1-10):");
        int roomNum = input.nextInt() - 1;
        if (roomNum >= 0 && roomNum < rooms.length) {
            if (rooms[roomNum].getName().equals("empty")) {
                System.out.println("Enter customer name:");
                String customerName = input.next();
                rooms[roomNum].setName(customerName);
                System.out.println("Room " + (roomNum + 1) + " booked successfully.");
            } else {
                System.out.println("Room is already booked.");
            }
        } else {
            System.out.println("Invalid room number.");
        }
    }

    @Override
    public void viewAllRooms() {
        for (int i = 0; i < rooms.length; i++) {
            System.out.println("Room " + (i + 1) + " is occupied by " + rooms[i].getName() + ".");
        }
    }

    @Override
    public void deleteCustomerFromRoom() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter room number to delete customer from (1-10):");
        int roomNum = input.nextInt() - 1;
        if (roomNum >= 0 && roomNum < rooms.length) {
            if (!rooms[roomNum].getName().equals("empty")) {
                rooms[roomNum].setName("empty");
                System.out.println("Customer removed from room " + (roomNum + 1) + ".");
            } else {
                System.out.println("Room is already empty.");
            }
        } else {
            System.out.println("Invalid room number.");
        }
    }

    @Override
    public void findRoomByCustomerName() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter customer name:");
        String customerName = input.next();
        boolean found = false;
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].getName().equals(customerName)) {
                System.out.println(customerName + " is in room " + (i + 1) + ".");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Customer not found.");
        }
    }

    @Override
    public void storeDataToFile() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("hotelData.txt"));
        for (int i = 0; i < rooms.length; i++) {
            writer.write("Room " + (i + 1) + ": " + rooms[i].getName());
            writer.newLine();
        }
        writer.close();
        System.out.println("Data stored successfully.");
    }

    @Override
    public void loadDataFromFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("hotelData.txt"));
        String line;
        int index = 0;
        while ((line = reader.readLine()) != null && index < rooms.length) {
            String[] parts = line.split(": ");
            if (parts.length == 2) {
                rooms[index].setName(parts[1]);
            }
            index++;
        }
        reader.close();
        System.out.println("Data loaded successfully.");
    }

    @Override
    public void viewRoomsAlphabetically() {
        Room[] sortedRooms = Arrays.copyOf(rooms, rooms.length);
        Arrays.sort(sortedRooms, Comparator.comparing(Room::getName));
        for (Room room : sortedRooms) {
            System.out.println("Room: " + room.getName());
        }
    }
}