import java.io.IOException;
import java.util.Date;


public interface ChampionshipManager {
    public void addNewDriver(String driverName, String location, String teamName) ;
    public void deleteDriver(String driverName, String teamName);
    public void changeDriver(String driverName, String teamName);
    public void displayStatics(String driverName);
    public void displayDriverTable();
    public void addRace(Date date);
    public void saveDetailsToFile() throws IOException;
}
