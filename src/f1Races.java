import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;

public class f1Races implements Serializable {
    private Date raceDate;
    HashMap<Integer, Formula1Driver> position;

    public f1Races(){

    }

    public f1Races(Date raceDate, HashMap<Integer,Formula1Driver> position) {
        this.raceDate = raceDate;
        this.position = position;
    }

    public Date getRaceDate() {
        return raceDate;
    }
    public void setRaceDate(Date raceDate) {
        this.raceDate = raceDate;
    }

    public HashMap<Integer, Formula1Driver> getPosition() {
        return position;
    }
    public void setPosition(HashMap<Integer, Formula1Driver> position) {
        this.position = position;
    }

}

