import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class consoleMenu {

    private final static Formula1ChampionshipManager formula1ChampionshipManager = new Formula1ChampionshipManager();
    private static ArrayList<Formula1Driver> Formula1DriverArrayList;

    public static void main(String[] args) throws IOException {

        formula1ChampionshipManager.loadSavedDetails() ;

        Scanner sc = new Scanner(System.in);

        int operation = 0; //operation variable used to store users menu preference
        System.out.println("**************************************************************************************************");
        System.out.print("*                                       W E L C O M E                                            *\n");
        System.out.print("*                                            T O                                                 *\n");
        System.out.print("*                             F O R M U L A 1  C H A M P I O N S H I P                           *\n");
        System.out.println("**************************************************************************************************");

        do {
            System.out.println("---------- Formula1 Championship ----------\n");
            System.out.println("(1) Add a new driver");
            System.out.println("(2) Delete an existing driver");
            System.out.println("(3) Change  an existing driver");
            System.out.println("(4) View statistics of a driver");
            System.out.println("(5) View the Formula1 Driver Table");
            System.out.println("(6) Add Played Race");
            System.out.println("(7) Save details");
            System.out.println("(8) GUI");
            System.out.println("(9) Enter any other number except 1 to 8 to exit");
            System.out.print("Enter the operation number : ");
            while (!sc.hasNextInt()) {
                System.out.println("\nInvalid !! ... operation number should be integer");
                System.out.print("\nEnter the operation number : ");
                sc.next();
            }

            operation = sc.nextInt();

            switch (operation) {
                case 1:
                    addDriverDetails();
                    break;
                case 2:
                    deleteDriver();
                    break;
                case 3:
                    changeDriver();
                    break;
                case 4:
                    displayStatics();
                    break;
                case 5:
                    formula1ChampionshipManager.displayDriverTable();
                    break;
                case 6:
                    addRace();
                    break;
                case 7:
                    formula1ChampionshipManager.saveDetailsToFile();
                    break;
                case 8:
                    formula1ChampionshipManager.gui();
                    break;
            }
            System.out.println();
        } while (operation < 9 && operation > 0);
        System.out.println(" Exiting System....");
    }


    //--------Implementing a method to add the driver details--------//
    private static void addDriverDetails()  {
        Formula1Driver formula1Driver;
        Scanner input = new Scanner(System.in);

        System.out.println("Enter name of the driver: ");
        String driverName = input.nextLine().toUpperCase();

        //-----------Checking whether user entered name correctly-----------//
        while (!driverName.matches("[a-zA-Z]+"))
        {
            System.out.println("Invalid name entered! Please enter valid driver name ");
            System.out.println("Enter name of the driver: ");
            driverName = input.nextLine().toUpperCase();
        }


        System.out.println("Enter location of the driver: ");
        String location = input.nextLine().toUpperCase();

        //-----------Checking whether user entered location name correctly-----------//
        while (!location.matches("[a-zA-Z]+"))
        {
            System.out.println("Invalid name entered! Please enter valid location name ");
            System.out.println("Enter location of the driver: ");
            location = input.nextLine().toUpperCase();
        }

        System.out.println("Enter name of the team: ");
        String teamName = input.nextLine().toUpperCase();

        //-----------Checking whether user entered team name correctly-----------//
        while (!teamName.matches("[a-zA-Z]+"))
        {
            System.out.println("Invalid name entered! Please enter valid team name ");
            System.out.println("Enter team name of the driver: ");
            teamName = input.nextLine().toUpperCase();
        }

        //Formula1 championship manager adds new driver's details in to the system
        formula1ChampionshipManager.addNewDriver(driverName, location, teamName);
    }


    //--------Implementing a method to  delete the driver using name of the driver--------//
    private static void deleteDriver()  {
        System.out.println("Enter the name of the driver you want to remove: ");
        Scanner sc = new Scanner(System.in);
        String driverName = sc.nextLine().toUpperCase();

        //-----------Checking whether user entered correct name correctly-----------//
        while (!driverName.matches("[a-zA-Z]+"))
        {
            System.out.println("\nInvalid name entered! Please enter valid driver name ");
            System.out.println("\nEnter the name of the driver you want to remove: ");
            driverName = sc.nextLine().toUpperCase();
        }

        System.out.println("Enter the name of the team you want to remove: ");
        String teamName = sc.nextLine().toUpperCase();

        //-----------Checking whether user entered correct team name correctly-----------//
        while (!teamName.matches("[a-zA-Z]+"))
        {
            System.out.println("\nInvalid name entered! Please enter valid team name ");
            System.out.println("\nEnter the name of the team you want to remove: ");
            teamName = sc.nextLine().toUpperCase();
        }
        formula1ChampionshipManager.deleteDriver(driverName, teamName);
    }

    private static void changeDriver() {
        System.out.println("Enter the name of the team you want to change");
        Scanner sc = new Scanner(System.in);
        String changingTeam = sc.nextLine().toUpperCase();

        while (!changingTeam.matches("[a-zA-Z]+"))
        {
            System.out.println("\nInvalid team entered! Please enter valid team name ");
            System.out.println("\nEnter the name of the team you want to change: ");
            changingTeam = sc.nextLine().toUpperCase();
        }

        System.out.println("Enter the name of the driver you want to change: ");
        String driverName = sc.nextLine().toUpperCase();

        //-----------Checking whether user entered correct name correctly-----------//
        while (!driverName.matches("[a-zA-Z]+"))
        {
            System.out.println("\nInvalid name entered! Please enter valid team name ");
            System.out.println("\nEnter the name of the team you want to remove: ");
            driverName = sc.nextLine().toUpperCase();
        }
        formula1ChampionshipManager.changeDriver(driverName, changingTeam);


    }

    private static void displayStatics() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of driver that should display statistics: ");
        String name = sc.nextLine().toUpperCase();

        //-----------Checking whether user entered correct name correctly-----------//
        while (!name.matches("[a-zA-Z]+"))
        {
            System.out.println("Invalid name entered! Please enter valid driver name ");
            System.out.println("Enter the name of driver that should display statistics: ");
            name = sc.nextLine().toUpperCase();
        }
        formula1ChampionshipManager.displayStatics(name);
    }


    private static void addRace() {
        System.out.println("Enter the date of the new race: ");
        Scanner sc = new Scanner(System.in);
        Date raceDate = null;
        try {
            System.out.print("\n[*] Enter the match date (dd-MM-yyyy) : ");
            String getRaceDate = sc.next();
            raceDate = new SimpleDateFormat("dd-MM-yyyy").parse(getRaceDate);
            formula1ChampionshipManager.addRace(raceDate);
        } catch (ParseException e) {
            System.out.println("\nDate should be in dd-mm-yyyy format");
        }

    }

}


//Reference:/https://www.javatpoint.com/java-regex

