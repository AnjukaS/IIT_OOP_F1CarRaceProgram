
import java.io.Serializable;


public class Formula1Driver extends Driver implements Serializable{



    //Instant Variables of Formula1Driver

    private int noOfFirstPosition ;
    private int noOfSecondPosition ;
    private int noOfThirdPosition ;
    private int noOfCurrentPoints;
    private int noOfRacesParticipated;
    private int pointsPerRace;

    //Getters and Setters
    public int getNoOfFirstPosition() { return noOfFirstPosition; }

    public int getNoOfSecondPosition() { return noOfSecondPosition; }

    public int getNoOfThirdPosition() { return noOfThirdPosition; }

    public int getNoOfCurrentPoints() { return noOfCurrentPoints; }

    public int getNoOfRacesParticipated() { return noOfRacesParticipated; }

    public int getPointsPerRace() { return pointsPerRace; }

    public void setNoOfFirstPosition(int noOfFirstPosition){ this.noOfFirstPosition = noOfFirstPosition; }

    public void setNoOfSecondPosition(int noOfSecondPosition) { this.noOfSecondPosition = noOfSecondPosition; }

    public void setNoOfThirdPosition(int noOfThirdPosition) { this.noOfThirdPosition = noOfThirdPosition; }

    public void setNoOfCurrentPoints(int noOfCurrentPoints) { this.noOfCurrentPoints = noOfCurrentPoints; }

    public void setNoOfRacesParticipated(int noOfRacesParticipated) { this.noOfRacesParticipated = noOfRacesParticipated; }

    public void setPointsPerRace(int pointsPerRace) { this.pointsPerRace = pointsPerRace; }


    //constructors
    public Formula1Driver(String driverName, String location, String teamName) {

        super(driverName, location, teamName);
        this.noOfFirstPosition = noOfFirstPosition;
        this.noOfSecondPosition = noOfSecondPosition;
        this.noOfThirdPosition = noOfThirdPosition;
        this.noOfCurrentPoints = noOfCurrentPoints;
        this.noOfRacesParticipated = noOfRacesParticipated;
        this.pointsPerRace = pointsPerRace;
    }

    // toString method
    @Override
    public String toString() {
        return super.toString() + "," + "No_Of_FirstPosition=" + noOfFirstPosition +
                ", No_Of_SecondPosition=" + noOfSecondPosition +
                ", No_Of_ThirdPosition=" + noOfThirdPosition +
                ", No_Of_CurrentPoints=" + noOfCurrentPoints +
                ", No_Of_RacesParticipated=" + noOfRacesParticipated+
                ",Points_Per_Race=" + pointsPerRace;

    }

}
