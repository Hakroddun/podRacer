import java.util.Map;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Welcome to Pod Racer\nPlease enter location of the track text file: ");
        while (true)
        {
            String track = scanner.nextLine();
            if (track.equalsIgnoreCase("quit")) {
                System.out.println("Exiting Pod Racer.");
                break;
            }
            System.out.print("Please enter the amount of laps that you want to race: ");
            String laps = scanner.nextLine();
            System.out.println("\nStarting Race...");
            PodRacerGame game = new PodRacerGame();
            Utility util = new Utility();
            game.setTrack(util.getTrackFromFile(track));
            game.setCars(util.generateCars());
            game.startRace(Integer.valueOf(laps));
            System.out.println("\nRace done.\n\nResults are as follow:");
            printRankings(game);
            System.out.println("\nPlease enter location of the track text file that you want to race on if you want to race again\notherwise type in quit to exit the game:");
        }
        scanner.close();
    }

    private static void printRankings(PodRacerGame game)
    {
        int position = 1;
        for(Map.Entry<Integer,String> entry : game.getRankings().entrySet())
        {
            Integer score = entry.getKey();
            String carName = entry.getValue();
            System.out.println(position + " place goes to " + carName + " with a score of " + score);
            position++;
        }
    }


}
