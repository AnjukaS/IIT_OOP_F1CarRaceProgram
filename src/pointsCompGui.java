import java.util.Comparator;


public class pointsCompGui implements Comparator<Formula1Driver> {

    //comparator which is used to sort FORMULA1 DRIVERS according to scored points

    @Override
    public int compare(Formula1Driver f1driver1, Formula1Driver f1driver2) {
        // -----------Sorting numberOfPoints descending order-------------//
        if (f1driver1.getNoOfCurrentPoints() < f1driver2.getNoOfCurrentPoints())
            return -1;
        else if (f1driver1.getNoOfCurrentPoints() > f1driver2.getNoOfCurrentPoints())
            return 1;
        else {
            // -----------Sorting POSITION Difference descending order-------------//
            int maxPosition1 = f1driver1.getNoOfFirstPosition() - f1driver2.getNoOfSecondPosition();
            int maxPosition2 = f1driver2.getNoOfFirstPosition() - f1driver1.getNoOfSecondPosition();
            if (maxPosition1 < maxPosition2)
                return -1;
            else if (maxPosition1 > maxPosition2)
                return 1;
            else return 0;
        }




    }
}

