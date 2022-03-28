
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;


public class  Formula1ChampionshipManager implements ChampionshipManager {


    ArrayList<Formula1Driver> Formula1DriverArrayList = new ArrayList<>();
    ArrayList<f1Races> f1RacesArrayList = new ArrayList<>();

    public ArrayList<Formula1Driver> getFormula1DriverArrayList() {
        return Formula1DriverArrayList;
    }

    public ArrayList<f1Races> getF1RacesArrayList() {
        return f1RacesArrayList;
    }

    public void setFormula1DriverArrayList(ArrayList<Formula1Driver> Formula1DriverArrayList) {
        this.Formula1DriverArrayList = Formula1DriverArrayList;
    }

    @Override
    public void addNewDriver(String driverName, String location, String teamName) {

        Formula1Driver formula1Driver = new Formula1Driver(driverName, location, teamName);
        Formula1DriverArrayList.add(formula1Driver);
        System.out.println("The Driver " + driverName + " has been added successfully !");
    }


    @Override
    public void deleteDriver(String driverName, String teamName) {
        for (Formula1Driver formula1Driver : Formula1DriverArrayList) {
            if (formula1Driver.getDriverName().equals(driverName)) {
                Formula1DriverArrayList.remove(formula1Driver);
                System.out.println("The driver " + driverName + " Has Been Removed Successfully!");
                return;
            }
        }
    }

    @Override
    public void changeDriver(String driverName, String teamName) {

        for (Formula1Driver formula1Driver : Formula1DriverArrayList) {
            if (teamName.equals(formula1Driver.getTeamName())) {
                formula1Driver.setDriverName(driverName);
                System.out.println("The driver " + driverName + " Has Been Changed Successfully!");
                return;
            }
        }
    }

    @Override
    public void addRace(Date date) {

        HashMap<Integer, Formula1Driver> position = new HashMap<>();
        System.out.println("The new race has been added!");
        for (Formula1Driver formula1Driver : Formula1DriverArrayList) {
            int racePosition = (int) ((Math.random() * (9)) + 1);
            switch (racePosition) {

                case 1:
                    formula1Driver.setPointsPerRace(25);
                    formula1Driver.setNoOfFirstPosition(formula1Driver.getNoOfFirstPosition() + 1);
                    formula1Driver.setNoOfCurrentPoints(formula1Driver.getNoOfCurrentPoints() + formula1Driver.getPointsPerRace());
                    formula1Driver.setNoOfRacesParticipated(formula1Driver.getNoOfRacesParticipated() + 1);
                    break;
                case 2:
                    formula1Driver.setPointsPerRace(18);
                    formula1Driver.setNoOfSecondPosition(formula1Driver.getNoOfSecondPosition() + 1);
                    formula1Driver.setNoOfCurrentPoints(formula1Driver.getNoOfCurrentPoints() + formula1Driver.getPointsPerRace());
                    formula1Driver.setNoOfRacesParticipated(formula1Driver.getNoOfRacesParticipated() + 1);
                    break;
                case 3:
                    formula1Driver.setPointsPerRace(15);
                    formula1Driver.setNoOfThirdPosition(formula1Driver.getNoOfThirdPosition() + 1);
                    formula1Driver.setNoOfCurrentPoints(formula1Driver.getNoOfCurrentPoints() + formula1Driver.getPointsPerRace());
                    formula1Driver.setNoOfRacesParticipated(formula1Driver.getNoOfRacesParticipated() + 1);
                    break;
                case 4:
                    formula1Driver.setPointsPerRace(12);
                    formula1Driver.setNoOfCurrentPoints(formula1Driver.getNoOfCurrentPoints() + formula1Driver.getPointsPerRace());
                    formula1Driver.setNoOfRacesParticipated(formula1Driver.getNoOfRacesParticipated() + 1);
                    break;
                case 5:
                    formula1Driver.setPointsPerRace(10);
                    formula1Driver.setNoOfCurrentPoints(formula1Driver.getNoOfCurrentPoints() + formula1Driver.getPointsPerRace());
                    formula1Driver.setNoOfRacesParticipated(formula1Driver.getNoOfRacesParticipated() + 1);
                    break;
                case 6:
                    formula1Driver.setPointsPerRace(8);
                    formula1Driver.setNoOfCurrentPoints(formula1Driver.getNoOfCurrentPoints() + formula1Driver.getPointsPerRace());
                    formula1Driver.setNoOfRacesParticipated(formula1Driver.getNoOfRacesParticipated() + 1);
                    break;
                case 7:
                    formula1Driver.setPointsPerRace(6);
                    formula1Driver.setNoOfCurrentPoints(formula1Driver.getNoOfCurrentPoints() + formula1Driver.getPointsPerRace());
                    formula1Driver.setNoOfRacesParticipated(formula1Driver.getNoOfRacesParticipated() + 1);
                    break;
                case 8:
                    formula1Driver.setPointsPerRace(4);
                    formula1Driver.setNoOfCurrentPoints(formula1Driver.getNoOfCurrentPoints() + formula1Driver.getPointsPerRace());
                    formula1Driver.setNoOfRacesParticipated(formula1Driver.getNoOfRacesParticipated() + 1);
                    break;
                case 9:
                    formula1Driver.setPointsPerRace(2);
                    formula1Driver.setNoOfCurrentPoints(formula1Driver.getNoOfCurrentPoints() + formula1Driver.getPointsPerRace());
                    formula1Driver.setNoOfRacesParticipated(formula1Driver.getNoOfRacesParticipated() + 1);
                    break;
                case 10:
                    formula1Driver.setPointsPerRace(1);
                    formula1Driver.setNoOfCurrentPoints(formula1Driver.getNoOfCurrentPoints() + formula1Driver.getPointsPerRace());
                    formula1Driver.setNoOfRacesParticipated(formula1Driver.getNoOfRacesParticipated() + 1);
                    break;


            }
            position.put(racePosition, formula1Driver);
        }
        f1Races race = new f1Races(date, position);
        f1RacesArrayList.add(race);
    }


    @Override
    public void displayStatics(String driverName) {

        if (Formula1DriverArrayList.isEmpty()) {
            System.out.println("No drivers are added");
        } else {
            for (Formula1Driver formula1Driver : Formula1DriverArrayList) {
                if (formula1Driver.getDriverName().equals(driverName)) {
                    System.out.println("Statistics");
                    System.out.println("----------");
                    System.out.println("Driver name                 : " + formula1Driver.getDriverName());
                    System.out.println("Number of first position    : " + formula1Driver.getNoOfFirstPosition());
                    System.out.println("Number of second position   : " + formula1Driver.getNoOfSecondPosition());
                    System.out.println("Number of third position    : " + formula1Driver.getNoOfThirdPosition());
                    System.out.println("Total Number of  points     : " + formula1Driver.getNoOfCurrentPoints());
                    System.out.println("Total Races participated    : " + formula1Driver.getNoOfRacesParticipated());
                    return;
                }
            }

            {
                System.out.printf("%s is not available\n", driverName);
                System.out.println();
            }
        }
    }


    @Override
    public void displayDriverTable() {
        if (Formula1DriverArrayList.isEmpty()) {
            System.out.println("No drivers are added");
        } else {
            System.out.println("                                                        PREMIERE LEAGUE TABLE                                                                     ");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("|   %8s   |   %13s   |  %4s   |   %4s   |   %4s   |   %10s   |   %10s   | \n", "DRIVER NAME", "TEAM NAME", "RACES", "1ST ", "2ND ", "3RD ", "POINTS");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------");

            Collections.sort(Formula1DriverArrayList, new pointsSorting());

            for (Formula1Driver formula1Driver : Formula1DriverArrayList) {
                System.out.printf("|%9s %18s %14s %10s %10s %14s %19s       |\n", formula1Driver.getDriverName(), formula1Driver.getTeamName(), formula1Driver.getNoOfRacesParticipated(), formula1Driver.getNoOfFirstPosition(), formula1Driver.getNoOfSecondPosition(), formula1Driver.getNoOfThirdPosition(), formula1Driver.getNoOfCurrentPoints());
                System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------");
            }
        }


    }


    @Override
    public void saveDetailsToFile() throws IOException {
        FileOutputStream driverOutputStream = new FileOutputStream("DriverFile.ser");
        ObjectOutputStream outputStream = new ObjectOutputStream(driverOutputStream);
        outputStream.writeObject(Formula1DriverArrayList);
        outputStream.close();
        driverOutputStream.close();


        FileOutputStream f1RacesOutputStream = new FileOutputStream("RaceFile.ser");
        ObjectOutputStream f1outputStream = new ObjectOutputStream(f1RacesOutputStream);
        f1outputStream.writeObject(f1RacesArrayList);
        f1outputStream.close();
        f1RacesOutputStream.close();

        System.out.println("Driver and Race details has been SAVED successfully");


    }


    public void loadSavedDetails() {
        try {


            FileInputStream fInputStream = new FileInputStream("DriverFile.ser");
            //-----------Create an ObjectInputStream for the file-----------//
            ObjectInputStream oInputStream = new ObjectInputStream(fInputStream);

            Object d = oInputStream.readObject();

            Formula1DriverArrayList = (ArrayList<Formula1Driver>) d;


        } catch (EOFException e) {

        } catch (ClassCastException e) {
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }


        try {


            FileInputStream f1InputStream = new FileInputStream("RaceFile.ser");
            //-----------Create an ObjectInputStream for the file-----------//
            ObjectInputStream o1InputStream = new ObjectInputStream(f1InputStream);

            Object b = o1InputStream.readObject();

            f1RacesArrayList = (ArrayList<f1Races>) b;

        } catch (EOFException e) {

        } catch (ClassCastException e) {
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }



        System.out.println(" Details has been loaded successfully");


    }

    public void gui() {
        JFrame frame = new JFrame("GUI");
        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(9, 3)); //FlowLayout/ GridLayout/
        panel.setVisible(true); //obj.show;

        frame.add(panel);
        frame.setVisible(true); //obj.show;
        frame.setSize(1000, 1000);

        JLabel l2 = new JLabel("GUI");
        JLabel l = new JLabel(" OPTIONS OF TABLES INCLUDED   ");
        JButton but1 = new JButton(" LIST OF DRIVERS AND THEIR STATS IN DESCENDING ORDER"); //creating instance of JButton

        panel.add(l);
        panel.add(but1);

        ActionListener act1 = new ActionListener() {
            public void actionPerformed(ActionEvent eve1) {
                Collections.sort(Formula1DriverArrayList, new pointsSorting());

                JFrame frame = new JFrame("TABLE ");
                JPanel panel = new JPanel();

                panel.setLayout(new FlowLayout());

                frame.add(panel);
                frame.setVisible(true); //obj.show;
                frame.setSize(800, 800);

                JLabel l1 = new JLabel("Formula1 Championship Drivers &  Statistics");
                panel.add(l1);
                //Creating JTable
                String col[] = {"Driver Name", "Team Name", "Location", "Points", "1st position", "2nd position", "3rd position", "No of Races "};
                DefaultTableModel tableModel = new DefaultTableModel(col, 0);
                JTable table = new JTable(tableModel);

                panel.add(table);
                tableModel.addRow(col);

                for (int i = 0; i < Formula1DriverArrayList.size(); i++) {
                    String driverName = Formula1DriverArrayList.get(i).getDriverName();
                    String teamName = Formula1DriverArrayList.get(i).getTeamName();
                    String location = Formula1DriverArrayList.get(i).getLocation();
                    int points = Formula1DriverArrayList.get(i).getNoOfCurrentPoints();
                    int first = Formula1DriverArrayList.get(i).getNoOfFirstPosition();
                    int second = Formula1DriverArrayList.get(i).getNoOfSecondPosition();
                    int third = Formula1DriverArrayList.get(i).getNoOfThirdPosition();
                    int noOfRace = Formula1DriverArrayList.get(i).getNoOfRacesParticipated();
                    Object[] data = {driverName, teamName, location, points, first, second, third, noOfRace};
                    tableModel.addRow(data);
                }
            }


        };

        JButton but2 = new JButton("TABLE ACCORDING TO THE POINTS WON BY DRIVERS"); //creating instance of JButton

        panel.add(but2);

        ActionListener act2 = new ActionListener() {
            public void actionPerformed(ActionEvent eve1) {
                Collections.sort(Formula1DriverArrayList, new pointsCompGui());

                JFrame frame = new JFrame("TABLE ");
                JPanel panel = new JPanel();

                panel.setLayout(new FlowLayout());

                frame.add(panel);
                frame.setVisible(true); //obj.show;
                frame.setSize(800, 800);

                JLabel l1 = new JLabel("Formula 1 Championship Drivers & Statistics");
                panel.add(l1);

                //Creating JTable
                String col[] = {"Name", "Team", "Location", "Points", "1st position", "2nd position", "3rd position", "No of Race"};
                DefaultTableModel tableModel = new DefaultTableModel(col, 0);
                JTable table = new JTable(tableModel);

                panel.add(table);
                tableModel.addRow(col);
                //Load arraylist data into the JTable
                for (int i = 0; i < Formula1DriverArrayList.size(); i++) {
                    String driverName = Formula1DriverArrayList.get(i).getDriverName();
                    String teamName = Formula1DriverArrayList.get(i).getTeamName();
                    String location = Formula1DriverArrayList.get(i).getLocation();
                    int points = Formula1DriverArrayList.get(i).getNoOfCurrentPoints();
                    int first = Formula1DriverArrayList.get(i).getNoOfFirstPosition();
                    int second = Formula1DriverArrayList.get(i).getNoOfSecondPosition();
                    int third = Formula1DriverArrayList.get(i).getNoOfThirdPosition();
                    int noOfRace = Formula1DriverArrayList.get(i).getNoOfRacesParticipated();
                    Object[] data = {driverName, teamName, location, points, first, second, third, noOfRace};
                    tableModel.addRow(data);
                }
            }
        };

        JButton but3 = new JButton("TABLE ACCORDING TO THE LARGEST NUMBER OF 1ST POSITION WON"); //creating instance of JButton

        panel.add(but3);

        ActionListener act3 = new ActionListener() {
            public void actionPerformed(ActionEvent eve1) {
                Collections.sort(Formula1DriverArrayList, new WinsComp());
                JFrame frame = new JFrame("TABLE ");
                JPanel panel = new JPanel();

                panel.setLayout(new FlowLayout());

                frame.add(panel);
                frame.setVisible(true); //obj.show;
                frame.setSize(800, 800);

                JLabel l1 = new JLabel("Formula 1 Championship Drivers & Statistics");
                panel.add(l1);

                //Creating JTable
                String col[] = {"Name", "Team", "Location", "Points", "1st position", "2nd position", "3rd position", "No of Race"};
                DefaultTableModel tableModel = new DefaultTableModel(col, 0);
                JTable table = new JTable(tableModel);

                panel.add(table);
                tableModel.addRow(col);

                for (int i = 0; i < Formula1DriverArrayList.size(); i++) {
                    String driverName = Formula1DriverArrayList.get(i).getDriverName();
                    String teamName = Formula1DriverArrayList.get(i).getTeamName();
                    String location = Formula1DriverArrayList.get(i).getLocation();
                    int points = Formula1DriverArrayList.get(i).getNoOfCurrentPoints();
                    int first = Formula1DriverArrayList.get(i).getNoOfFirstPosition();
                    int second = Formula1DriverArrayList.get(i).getNoOfSecondPosition();
                    int third = Formula1DriverArrayList.get(i).getNoOfThirdPosition();
                    int noOfRace = Formula1DriverArrayList.get(i).getNoOfRacesParticipated();
                    Object[] data = {driverName, teamName, location, points, first, second, third, noOfRace};
                    tableModel.addRow(data);
                }
            }
        };

        JButton but4 = new JButton("RANDOM RACE WITH RANDOM POSITIONS");
        panel.add(but4);

        ActionListener act4 = new ActionListener() {
            public void actionPerformed(ActionEvent eve4) {
                JFrame frame = new JFrame("TABLE");
                JPanel panel = new JPanel();
                panel.setLayout(new FlowLayout());
                frame.setContentPane(panel);
                frame.setSize(800, 800);
                frame.setVisible(true);


                for (Formula1Driver formula1Driver : Formula1DriverArrayList) {
                    int racePosition = (int) ((Math.random() * (9)) + 1);
                    switch (racePosition) {
                        case 1:
                            formula1Driver.setPointsPerRace(25);
                            formula1Driver.setNoOfFirstPosition(formula1Driver.getNoOfFirstPosition() + 1);
                            formula1Driver.setNoOfCurrentPoints(formula1Driver.getNoOfCurrentPoints() + formula1Driver.getPointsPerRace());
                            formula1Driver.setNoOfRacesParticipated(formula1Driver.getNoOfRacesParticipated() + 1);
                            setFormula1DriverArrayList(Formula1DriverArrayList);
                            JLabel l1 = new JLabel(formula1Driver.getDriverName() + " : 1");
                            panel.add(l1);
                            break;
                        case 2:
                            formula1Driver.setPointsPerRace(18);
                            formula1Driver.setNoOfSecondPosition(formula1Driver.getNoOfSecondPosition()+ 1);
                            formula1Driver.setNoOfCurrentPoints(formula1Driver.getNoOfCurrentPoints() + formula1Driver.getPointsPerRace());
                            formula1Driver.setNoOfRacesParticipated(formula1Driver.getNoOfRacesParticipated() + 1);
                            setFormula1DriverArrayList(Formula1DriverArrayList);
                            JLabel l2 = new JLabel(formula1Driver.getDriverName() + " : 2");
                            panel.add(l2);
                            break;
                        case 3:
                            formula1Driver.setPointsPerRace(15);
                            formula1Driver.setNoOfThirdPosition(formula1Driver.getNoOfThirdPosition() + 1);
                            formula1Driver.setNoOfCurrentPoints(formula1Driver.getNoOfCurrentPoints() + formula1Driver.getPointsPerRace());
                            formula1Driver.setNoOfRacesParticipated(formula1Driver.getNoOfRacesParticipated() + 1);
                            setFormula1DriverArrayList(Formula1DriverArrayList);
                            JLabel l3 = new JLabel(formula1Driver.getDriverName() + " : 3");
                            panel.add(l3);
                            break;
                        case 4:
                            formula1Driver.setPointsPerRace(12);
                            formula1Driver.setNoOfCurrentPoints(formula1Driver.getNoOfCurrentPoints() + formula1Driver.getPointsPerRace());
                            formula1Driver.setNoOfRacesParticipated(formula1Driver.getNoOfRacesParticipated() + 1);
                            setFormula1DriverArrayList(Formula1DriverArrayList);
                            JLabel l4 = new JLabel(formula1Driver.getDriverName() + " : 4");
                            panel.add(l4);
                            break;
                        case 5:
                            formula1Driver.setPointsPerRace(10);
                            formula1Driver.setNoOfCurrentPoints(formula1Driver.getNoOfCurrentPoints() + formula1Driver.getPointsPerRace());
                            formula1Driver.setNoOfRacesParticipated(formula1Driver.getNoOfRacesParticipated() + 1);
                            setFormula1DriverArrayList(Formula1DriverArrayList);
                            JLabel l5 = new JLabel(formula1Driver.getDriverName() + " : 5");
                            panel.add(l5);
                            break;
                        case 6:
                            formula1Driver.setPointsPerRace(8);
                            formula1Driver.setNoOfCurrentPoints(formula1Driver.getNoOfCurrentPoints() + formula1Driver.getPointsPerRace());
                            formula1Driver.setNoOfRacesParticipated(formula1Driver.getNoOfRacesParticipated() + 1);
                            setFormula1DriverArrayList(Formula1DriverArrayList);
                            JLabel l6 = new JLabel(formula1Driver.getDriverName() + " : 6");
                            panel.add(l6);
                            break;
                        case 7:
                            formula1Driver.setPointsPerRace(6);
                            formula1Driver.setNoOfCurrentPoints(formula1Driver.getNoOfCurrentPoints() + formula1Driver.getPointsPerRace());
                            formula1Driver.setNoOfRacesParticipated(formula1Driver.getNoOfRacesParticipated() + 1);
                            setFormula1DriverArrayList(Formula1DriverArrayList);
                            JLabel l7 = new JLabel(formula1Driver.getDriverName() + " : 7");
                            panel.add(l7);
                            break;
                        case 8:
                            formula1Driver.setPointsPerRace(4);
                            formula1Driver.setNoOfCurrentPoints(formula1Driver.getNoOfCurrentPoints() + formula1Driver.getPointsPerRace());
                            formula1Driver.setNoOfRacesParticipated(formula1Driver.getNoOfRacesParticipated() + 1);
                            setFormula1DriverArrayList(Formula1DriverArrayList);
                            JLabel l8 = new JLabel(formula1Driver.getDriverName() + " : 8");
                            panel.add(l8);
                            break;
                        case 9:
                            formula1Driver.setPointsPerRace(2);
                            formula1Driver.setNoOfCurrentPoints(formula1Driver.getNoOfCurrentPoints() + formula1Driver.getPointsPerRace());
                            formula1Driver.setNoOfRacesParticipated(formula1Driver.getNoOfRacesParticipated() + 1);
                            setFormula1DriverArrayList(Formula1DriverArrayList);
                            JLabel l9 = new JLabel(formula1Driver.getDriverName() + " : 9");
                            panel.add(l9);
                            break;
                        case 10:
                            formula1Driver.setPointsPerRace(1);
                            formula1Driver.setNoOfCurrentPoints(formula1Driver.getNoOfCurrentPoints() + formula1Driver.getPointsPerRace());
                            formula1Driver.setNoOfRacesParticipated(formula1Driver.getNoOfRacesParticipated() + 1);
                            setFormula1DriverArrayList(Formula1DriverArrayList);
                            JLabel l10 = new JLabel(formula1Driver.getDriverName() + " : 10");
                            panel.add(l10);
                            break;
                    }
                }
            }
        };

        JButton but5 = new JButton(" PROBABILITY OF WINNING ");

        panel.add(but5);


        JButton but6 = new JButton(" RACE DATES IN ASCENDING ORDER ");

        panel.add(but6);

        ActionListener act6 = new ActionListener() {
            public void actionPerformed(ActionEvent eve6) {
                JFrame frame = new JFrame("TABLE");
                JPanel panel = new JPanel();

                panel.setLayout(new GridLayout());

                frame.setContentPane(panel);
                frame.setSize(  800, 800);
                frame.setVisible(true);

                ArrayList<Date> dateList = new ArrayList<>();

                for (f1Races race : f1RacesArrayList) {
                    Date date = race.getRaceDate();
                    dateList.add(date);
                }

                Collections.sort(dateList);

                DefaultTableModel model = new DefaultTableModel(1, 0);

                JTable table = new JTable(model);
                table.setRowHeight(30);
                panel.add(table);

                model.addColumn("Dates", new String[]{"Race Dates"});

                for (int i = 0; i < dateList.size(); i++) {
                    Date dt = dateList.get(i);

                    Object[] row = {" " + dt};
                    model.addRow(row);

                }

            }
    };

        JButton but7 = new JButton(" SEARCH FOR DETAILS ");
        panel.add(but7);

        ActionListener act7 = new ActionListener() {
            public void actionPerformed(ActionEvent eve7) {

                JFrame frame = new JFrame("TABLE ");
                JPanel panel = new JPanel();

                panel.setLayout(new FlowLayout());

                frame.add(panel);
                frame.setVisible(true); //obj.show;
                frame.setSize(800, 800);

                JLabel l1 = new JLabel("Driver Name:");
                JTextField t1 = new JTextField(20);

                panel.add(l1);
                panel.add(t1);

                JButton but7 = new JButton(" SEARCH ");
                panel.add(but7);



                ActionListener act = new ActionListener() {
                    public void actionPerformed(ActionEvent eve) {

                        JFrame frame = new JFrame("TABLE ");
                        JPanel panel = new JPanel();

                        panel.setLayout(new GridLayout(21, 3));

                        frame.add(panel);
                        frame.setVisible(true);
                        frame.setSize(1000, 1000);

                        JLabel l = new JLabel("Race details:");
                        panel.add(l);

                        String name = t1.getText();

                        String textFieldValue = t1.getText();
                        for (Formula1Driver formula1Driver : Formula1DriverArrayList) {
                            if (formula1Driver.getDriverName().equals(textFieldValue)) {
                                JLabel l1 = new JLabel("Driver Name : " + formula1Driver.getDriverName());
                                panel.add(l1);

                                for (f1Races race : f1RacesArrayList) {
                                    if (formula1Driver.getDriverName().equals(textFieldValue)) {
                                        JLabel l2 = new JLabel("Race Date : " + race.getRaceDate());
                                        panel.add(l2);
                                    }
                                    for (Integer position : race.position.keySet()) {
                                        if (race.getPosition().get(position).equals(formula1Driver)) {

                                            JLabel l2 = new JLabel("Race Position : " + position);
                                            panel.add(l2);
                                        }

                                    }
                                }
                            }
                            }
                        }


                };

                but7.addActionListener(act);


            }

            ;


        };

        but1.addActionListener(act1);
        but2.addActionListener(act2);
        but3.addActionListener(act3);
        but4.addActionListener(act4);
        but6.addActionListener(act6);
        but7.addActionListener(act7);

    }
}




