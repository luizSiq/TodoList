import java.io.*;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class StoringData {

    String file = "storage.txt";
    Scanner sc = new Scanner(System.in);

    public boolean checkForCopies (String taskName)
    {
        // Mechanism to search if the task the user input already it exist or not
        // Useful to enforce the inability of saving duplicates and causing error when deleting/saving data
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
        // Plain save the task at the bottom of file, appending the content
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
        // Mechanism of searching, loop through the file until the code find the task
        // Iterate through the task it found until it reach an empty line
        boolean taskFound = false;
        try (Scanner fileScanner = new Scanner(Paths.get(file)))
        {
            while(fileScanner.hasNextLine())
            {
                String fileLine = fileScanner.nextLine();
                if(fileLine.equals("Task name: " + taskName))
                {
                    taskFound = true;
                    while(fileScanner.hasNextLine())
                    {
                        String line = fileScanner.nextLine();
                        if(line.isEmpty())
                        {
                            break;
                        }
                        System.out.println(line);
                    }
                    System.out.println("\n");
                    break;
                }
            }

            if (!taskFound) {
                System.out.println("Task named " + taskName + " not found");
            }

        } catch(IOException e)
        {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }

    public void printAllData()
    {
        // While loop to interate through all the lines of the file
        // Print on console to user see
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
        // Instead of creating another file, copying everything and saving back the content without the task needed to delete would be "complex"
        // Its better to save in a arrayList the content that I don't need to change
        // When finding the task name to delete, I can just ignore it and save the rest on the arrayList
        // And finally, overwrite the file with the content saved in the arrayList

        List<String> fileContent = new ArrayList<>();
        boolean taskFound = false;

        try(Scanner fileScanner = new Scanner(Paths.get(file)))
        {
            while(fileScanner.hasNextLine())
            {
                String line = fileScanner.nextLine();
                if(line.equals("Task name: " + taskName))
                {
                    taskFound = true;
                    while(fileScanner.hasNextLine())
                    {
                        String nextLine = fileScanner.nextLine();
                        if(nextLine.isEmpty())
                        {
                            break;
                        }
                    }
                } else
                {
                    fileContent.add(line);
                }
            }

        } catch (IOException e)
        {
            System.out.println("An error occurred");
            e.printStackTrace();
        }

        if(taskFound)
        {
            try (PrintWriter writer = new PrintWriter(file))
            {
                for(String i : fileContent)
                {
                    writer.println(i);
                }
                System.out.println("Task " + taskName + " was deleted succesfully");
            } catch (IOException e)
            {
                System.out.println("An error occurred");
                e.printStackTrace();
            }
        } else
        {
            System.out.println("Task " + taskName + " was not found");
        }

    }

    public void wipeAllData()
    {
        // Overwrite the storage.txt with an empty one with the same name
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
