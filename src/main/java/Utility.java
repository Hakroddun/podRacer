import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Utility
{
    //Retrieves the track data from a file inside resources;
    public String getTrackFromFile(String trackFileToRead)
    {
        String track = "";
        try
        {
            track = new String(Files.readAllBytes(Paths.get(trackFileToRead)));
        }
        catch (IOException e)
        {
            System.err.println(e.getMessage());
        }
        return track;
    }

    //Generates a default list of cars.
    public ArrayList<Car> generateCars()
    {
        ArrayList<Car> cars = new ArrayList<>();
        Car carA = new Car("Car A",5,10,2);
        Car carB = new Car("Car B",3,9,6);
        Car carC = new Car("Car C",3,15, 3);
        Car carD = new Car("Car D",7,12, 3);
        cars.add(carA);
        cars.add(carB);
        cars.add(carC);
        cars.add(carD);
        return cars;
    }
}
