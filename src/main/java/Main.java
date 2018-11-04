import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Welcome to Pod Racer\nPlease enter the amount of laps that you want to race: ");
        while (true)
        {
            String text = scanner.nextLine();
            if (text.equalsIgnoreCase("quit")) {
                System.out.println("Exiting Pod Racer.");
                break;
            }
            System.out.println("\nStarting Race...");
            PodRacerGame game = new PodRacerGame();
            Utility util = new Utility();
            game.setTrack(util.getTrackFromFile("tracks/track.txt"));
            game.setCars(util.generateCars());
            game.startRace(Integer.valueOf(text));
            System.out.println("\nRace done.\n\nResults are as follow:");
            printRankings(game);
            System.out.println("\nPlease enter the amount of laps that you want to race if you want to race again\notherwise type in quit to exit the game:");
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
            System.out.println(position + "place goes to " + carName + " with a score of " + score);
            position++;
        }
    }


}
