
// Console ui
// User will choose functions to execute based on numbers he inputs


import java.util.Scanner;

public class UserInterface {
    private Todo task;
    private Scanner sc;
    private StoringData storingData;

    public UserInterface(Scanner scanner, Todo task)
    {
        this.sc = scanner;
        this.task = task;
        this.storingData = new StoringData();
    }

    public void Start()
    {
        System.out.println("Todo list application!");

        while(true)
        {

            // Add a wipe database functionality
            System.out.println("Press the number:");
            System.out.println("> Add task (1)");
            System.out.println("> View a specific task (2)");
            System.out.println("> List all tasks (3)");
            System.out.println("> Remove a task (4)");
            System.out.println("> Exit (5)");

            String usrInput = sc.nextLine();

            switch(usrInput)
            {
                case "5":
                    System.out.println("App closed");
                    return;
                case "1":
                    while(true)
                    {

                        // When saving data, check for task names that are repeating,
                        // and ask user for a different task name
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

                            System.out.println("Task content: ");
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

                            System.out.println("Task content: ");
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
                    System.out.println("Task index you want to see: ");

                    /*
                    * Can use a similar configuration of deleting
                    *
                    * Search for "task name: {User Input}"
                    * Print text till next empty line
                    *
                    * */
                    break;

                case "3":
                    storingData.printData();
                    break;

                case "4":
                    System.out.println("Task index you want to remove: ");

                    /*
                    * Idea: ask user for task name
                    * Search on storage.txt for -> "task name: {User Input}"
                    * Delete content until next line.
                    *
                    * Add a option to wipe whole storage, make sure to double check if user is sure
                    * */
                    break;
            }

        }
    }
}
