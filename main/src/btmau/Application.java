package btmau;
import java.util.Scanner;

public class Application {
    private static Scanner scan;
    private static StudentManager studentManager;

    public Application() {
    }

    public static void main(String[] args) {
        scan = new Scanner(System.in);
        studentManager = new StudentManager();
        Start();
    }

    public static void Start() {
        while(true) {
            int option = ShowMenu();
            switch(option) {
            case 1:
                studentManager.Add();
                break;
            case 2:
                studentManager.Find();
                break;
            case 3:
                studentManager.UpdateOrDelete();
                break;
            case 4:
                studentManager.List();
                break;
            case 5:
                System.exit(0);
            }
        }
    }

    public static int ShowMenu() {
        System.out.println("");
        System.out.println("");
        System.out.println("WELCOME TO STUDENT MANAGEMENT: ");
        System.out.println("1. Create");
        System.out.println("2. Find and sort");
        System.out.println("3. Update/Delete");
        System.out.println("4. Report");
        System.out.println("5. Exit");
        System.out.println("---------------------");
        System.out.println("Please choose:");
        int num = scan.nextInt();
        return num;
    }
}