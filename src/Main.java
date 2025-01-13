// TdoList that saves on a file txt

// Main class to initialize the other classes
// Interface class responsible to get the information from user
// Saving class to save the files
// Tdo Class

import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Todo task = new Todo();

        UserInterface ui =  new UserInterface(scanner, task);
        ui.Start();
    }
}