import java.io.Serializable;


public  class Driver implements Serializable{
    //instance variables of Driver
    private String driverName;
    private String location;
    private String teamName;

    //getters and setters
    public String getDriverName() {
        return driverName;
    }

    public String getLocation() {
        return location;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setTeamName(String teamName) {
        this.location = teamName;
    }

    //constructors
    public Driver() {
    }

    public Driver(String driverName, String location, String teamName) {
        this.driverName = driverName;
        this.location = location;
        this.teamName = teamName;
    }

    @Override
    public String toString() {
        return "Driver_Name='" + driverName + '\'' +
                ", Location='" + location + '\'' +
                ", Team_Name='" + teamName + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Driver)) return false;

        Driver that = (Driver) o;

        if (getDriverName() != null ? !getDriverName().equals(that.getDriverName()) : that.getDriverName() != null)
            return false;
        return getLocation() != null ? getLocation().equals(that.getLocation()) : that.getLocation() == null;
    }

    @Override
    public int hashCode() {
        int result = getDriverName() != null ? getDriverName().hashCode() : 0;
        result = 31 * result + (getLocation() != null ? getLocation().hashCode() : 0);
        return result;
    }


}
