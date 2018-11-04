import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class podRacerTest
{
    @Test
    public void raceOneLapWithSuppliedTrack() throws IOException
    {
        String trackFileToRead = "tracks/track.txt";
        String track = getTrackFromFile(trackFileToRead);
        PodRacerGame game = new PodRacerGame();
        game.setTrack(track);
        game.setCars(generateCars());
        game.startRace(1);
        assertEquals("[Car D, Car B, Car A, Car C]", game.getRankings().values().toString());
    }
    @Test
    public void raceOneLap() throws IOException
    {
        PodRacerGame game = new PodRacerGame();
        game.setTrack("0000111");
        game.setCars(generateCars());
        game.startRace(1);
        assertEquals("[Car D, Car B, Car A, Car C]", game.getRankings().values().toString());
    }

    @Test
    public void raceThreeLap() throws IOException
    {
        PodRacerGame game = new PodRacerGame();
        game.setTrack("0000111");
        game.setCars(generateCars());
        game.startRace(3);
        assertEquals("[Car D, Car B, Car A, Car C]", game.getRankings().values().toString());
    }

    @Test
    public void raceThreeLapWithStartAndEndStraight() throws IOException
    {
        PodRacerGame game = new PodRacerGame();
        game.setTrack("0000111000");
        game.setCars(generateCars());
        game.startRace(3);
        assertEquals("[Car D, Car C, Car A, Car B]", game.getRankings().values().toString());
    }

    private ArrayList<Car> generateCars()
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

    private String getTrackFromFile(String trackFileToRead) throws IOException
    {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(trackFileToRead).getFile());
        return new String(Files.readAllBytes(Paths.get(file.getAbsolutePath())));
    }


}
