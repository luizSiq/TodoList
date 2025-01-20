import java.util.Scanner;
import java.nio.file.Paths;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class StoringData {

    String file = "storage.txt";
    Scanner sc = new Scanner(System.in);

    public boolean checkForCopies (String taskName)
    {
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

    public void printData(String taskName)
    {

        /*
         * Can use a similar configuration of deleting
         *
         * Search for "task name: {User Input}"
         * Print text till next empty line
         *
         * */

        try (Scanner fileScanner = new Scanner(Paths.get(file)))
        {

        } catch(IOException e)
        {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }

    public void printAllData()
    {
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
        /*
        * I can search for "Task name: {usrInput}
        * Delete till next empty line
        *
        * I am still not sure about how to do it
        * - I can create a new temporary file, that copies the content of the original file
        * - Rewrites all the data, except the one the user want to delete
        * - Deletes the copy file and keep the original
        *
        *
        * */


    }

    public void wipeAllData()
    {
        try
        {
            PrintWriter writer = new PrintWriter(file);
            writer.close();

            System.out.println("The data was wiped successfully");

        } catch (IOException e)
        {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }
}
