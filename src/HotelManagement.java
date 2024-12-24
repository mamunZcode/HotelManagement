import java.io.IOException;

interface HotelManagement {
    void initialiseRooms();

    void displayEmptyRooms();

    void bookRoom();

    void viewAllRooms();

    void deleteCustomerFromRoom();

    void findRoomByCustomerName();

    void storeDataToFile() throws IOException;

    void loadDataFromFile() throws IOException;

    void viewRoomsAlphabetically();
}