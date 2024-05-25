import java.util.Scanner;

public class HotelManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Database db = new Database();

        while (true) {
            System.out.println("Hotel Management System");
            System.out.println("1. Add Hotel");
            System.out.println("2. View Hotels");
            System.out.println("3. Update Hotel");
            System.out.println("4. Delete Hotel");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter hotel name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter hotel location: ");
                    String location = scanner.nextLine();
                    db.addHotel(new Hotel(name, location));
                    break;
                case 2:
                    db.viewHotels();
                    break;
                case 3:
                    System.out.print("Enter hotel ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new hotel name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new hotel location: ");
                    String newLocation = scanner.nextLine();
                    db.updateHotel(new Hotel(updateId, newName, newLocation));
                    break;
                case 4:
                    System.out.print("Enter hotel ID to delete: ");
                    int deleteId = scanner.nextInt();
                    db.deleteHotel(deleteId);
                    break;
                case 5:
                    db.closeConnection();
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
