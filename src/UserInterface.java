
// Console ui
// User will choose functions to execute based on numbers he inputs


import java.util.Scanner;

public class UserInterface {
    private Todo task;
    private Scanner sc;
    private StoringData storingData;

    public UserInterface(Scanner scanner, Todo task)
    {
        // Initializing the classes used in this class
        this.sc = scanner;
        this.task = task;
        this.storingData = new StoringData();
    }

    public void Start()
    {
        System.out.println("Todo list application!");

        while(true)
        {

            // Simple user interface
            // The user can interact with the code through the numbers
            // I need to add error handling for characters not expected by the program
            System.out.println("Press the number:");
            System.out.println("> Add task (1)");
            System.out.println("> View a specific task (2)");
            System.out.println("> List all tasks (3)");
            System.out.println("> Remove a task (4)");
            System.out.println("> Wipe all the tasks (5)");
            System.out.println("> Exit (6)");

            String usrInput = sc.nextLine();

            switch(usrInput)
            {
                case "6":
                    System.out.println("App closed");
                    return;
                case "1":
                    while(true)
                    {
                        System.out.println("Will your task have a deadline? ");
                        System.out.println("yes(1) or no(2)");
                        String a = sc.nextLine();

                        if(a.equals("1"))
                        {
                            String taskName;

                            while(true)
                            {
                                System.out.print("Task name: ");
                                taskName = sc.nextLine();

                                if(!(storingData.checkForCopies(taskName)))
                                {
                                    break;
                                }
                                System.out.println("Task already exists, try another name.");
                            }
                            System.out.print("Deadline date (DD/MM/YYYY): ");
                            String deadline = sc.nextLine();

                            System.out.print("Task content: ");
                            String taskContent = sc.nextLine();

                            task = new Todo(taskName, deadline, taskContent);

                            storingData.saveData(task);
                            break;
                        }
                        else if(a.equals("2"))
                        {
                            String taskName;

                            while(true)
                            {
                                System.out.print("Task name: ");
                                taskName = sc.nextLine();

                                if(!(storingData.checkForCopies(taskName)))
                                {
                                    break;
                                }
                                System.out.println("Task already exists, try another name.");
                            }

                            System.out.print("Task content: ");
                            String taskContent = sc.nextLine();

                            task = new Todo(taskName, taskContent);

                            storingData.saveData(task);
                            break;
                        }
                        else
                        {
                            System.out.println("Invalid input, try again\n");
                        }
                    }
                    break;

                case "2":
                    System.out.print("Task name you want to see: ");
                    String taskName = sc.nextLine();
                    storingData.printData(taskName);
                    break;

                case "3":
                    storingData.printAllData();
                    break;

                case "4":
                    System.out.println("Task name you want to remove: ");
                    taskName = sc.nextLine();
                    storingData.deleteData(taskName);

                    break;

                case "5":
                    System.out.println("Are you sure you want to wipe all data?");
                    System.out.println("(1) yes  (2) no");
                    String option = sc.nextLine();

                    while(true)
                    {
                        if(option.equals("1"))
                        {
                            storingData.wipeAllData();
                            break;
                        }
                        else if(option.equals("2"))
                        {
                            System.out.println("No data was deleted");
                            break;
                        }
                        else
                        {
                            System.out.println("Invalid input, try again!");
                        }
                    }
            }
        }
    }
}
