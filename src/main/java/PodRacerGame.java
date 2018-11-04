import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class PodRacerGame
{
    private TreeMap<Integer, String> ranking;
    private ArrayList<Car> cars;
    private String track;

    //Starts the game.
    public void startRace(int laps)
    {
        ranking = new TreeMap<>(Comparator.reverseOrder());
        for(Car car : cars)
        {
            String trackProgress = generateTrack(track, laps);
            int totalCarScore= runThroughTrack(car, trackProgress);
            ranking.put(totalCarScore,car.getName());
        }
    }

    //Generates the track with laps.
    //The reason for doing it this way is if the track starts and ends with a straight so that the acceleration would go uninterrupted.
    private String generateTrack(String track, int amountOfLaps)
    {
        String fullTrack = "";
        for (int lap = 0; lap < amountOfLaps; lap++)
        {
            fullTrack = fullTrack.concat(track);
        }
        return fullTrack;
    }

    private int runThroughTrack(Car car, String trackProgress)
    {
        int carScore = 0;
        if(!isRaceFinished(trackProgress))
        {
            if (nextSegmentType(trackProgress).equals("straight"))
            {
                carScore += calculateStraightCarScore(getStraightLength(trackProgress), car);
                carScore += runThroughTrack(car, getRemainingTrack(getStraightLength(trackProgress),trackProgress));
            }
            else if (nextSegmentType(trackProgress).equals("corner"))
            {
                carScore += calculateCornerCarScore(getCornerLength(trackProgress), car);
                carScore += runThroughTrack(car, getRemainingTrack(getCornerLength(trackProgress),trackProgress));
            }
        }
        return carScore;
    }

    private String getRemainingTrack(int progress, String track)
    {
        return track.substring(progress, track.length());
    }

    //Checks if the race is done.
    private boolean isRaceFinished(String trackProgress)
    {
        return trackProgress.length() == 0;
    }

    //Checks what type of segment is coming up in the track.
    //Throws an exception if it is not a valid character
    private String nextSegmentType(String trackProgress)
    {
        switch (String.valueOf(trackProgress.charAt(0)))
        {
            case "0":
                return "straight";
            case "1":
                return "corner";
            default:
                throw new RuntimeException("Invalid value in track file");
        }
    }

    //Gets the length of a straight for calculations
    //Also checks if the track is at its end.
    private int getStraightLength(String trackProgress)
    {
        if(trackProgress.contains("1"))
        {
            return trackProgress.indexOf("1");
        }
        else
        {
            return trackProgress.length();
        }
    }

    //Gets the length of a corner for calculations
    //Also checks if the track is at its end.
    private int getCornerLength(String trackProgress)
    {
        if(trackProgress.contains("0"))
        {
            return trackProgress.indexOf("0");
        }
        else
        {
            return trackProgress.length();
        }
    }

    //Calculates the points accumulated on a straight.
    private int calculateStraightCarScore(int straightLength, Car car)
    {
        int totalStraightScore = 0;
        int currentSpeed = 0;
        for(int progressThroughStraight = 0; progressThroughStraight < straightLength; progressThroughStraight++)
        {
            currentSpeed += car.getAcceleration();
            if(currentSpeed <= car.getTopSpeed())
            {
                totalStraightScore += currentSpeed;
            }
            else
            {
                totalStraightScore += car.getTopSpeed();
            }
        }
        return totalStraightScore;
    }

    //Calculates the points accumulated on a corner.
    private int calculateCornerCarScore(int cornerLength, Car car)
    {
        int totalCornerScore = 0;
        for(int progressThroughCorner = 0; progressThroughCorner < cornerLength; progressThroughCorner++)
        {
            totalCornerScore += car.getCornerSpeed();
        }
        return totalCornerScore;
    }

    public void setTrack(String track)
    {
        this.track = track;
    }

    public void setCars(ArrayList<Car> cars)
    {
        this.cars = cars;
    }

    public Map<Integer,String> getRankings()
    {
        return ranking;
    }
}
