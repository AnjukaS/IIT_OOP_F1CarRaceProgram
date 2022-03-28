import java.util.Comparator;


public class WinsComp implements Comparator<Formula1Driver> {
    @Override
    public int compare(Formula1Driver a, Formula1Driver b)
    {
        return b.getNoOfFirstPosition() - a.getNoOfFirstPosition();
    }


}
