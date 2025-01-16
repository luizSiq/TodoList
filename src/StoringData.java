import java.util.Scanner;
import java.nio.file.Paths;
import java.io.FileWriter;
import java.io.IOException;

public class StoringData {

    public boolean checkForCopies (String taskName)
    {
        String file = "storage.txt";
        boolean duplicates = false;

        try(Scanner fileScanner = new Scanner(Paths.get(file)))
        {
            while(fileScanner.hasNextLine())
            {
                String line = fileScanner.nextLine();
                if(line.equals("Task name: " + taskName))
                {
                    duplicates = true;
                    break;
                }
            }

        } catch (IOException e)
        {
            System.out.println("An error occurred");
            e.printStackTrace();
        }

        return duplicates;
    }

    public void saveData(Todo content)
    {
        try
        {
            FileWriter fileWriter = new FileWriter("storage.txt", true);

            fileWriter.write(String.valueOf(content) + System.lineSeparator());
            fileWriter.close();

            System.out.println("Successfully wrote file.");

        } catch (IOException e)
        {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }

    public void printData()
    {
        String file = "storage.txt";

        try (Scanner fileScanner = new Scanner(Paths.get(file)))
        {
            while(fileScanner.hasNextLine())
            {
                String line = fileScanner.nextLine();
                System.out.println(line);
            }

        } catch (IOException e)
        {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }

    public void deleteData(String taskName)
    {

    }

    public void wipeData()
    {

    }
}
