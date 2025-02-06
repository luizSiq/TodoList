// Tdo
// Name task
// Date of addition
// Add deadline or not
// Task content

// View specific Tdo task
// View all Tdo

// Remove a Tdo

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Todo
{
    private String nameTask;
    private LocalDate currentDate;
    private LocalDate deadLine;
    private String taskContent;
    private boolean deadlineActivated;

    public Todo(){}

    // No deadline
    public Todo(String nameTask, String taskContent)
    {
        this.nameTask = nameTask;
        this.currentDate = LocalDate.now();
        this.taskContent = taskContent;
        this.deadlineActivated = false;
    }

    // With a deadline
    public Todo(String nameTask, String deadLine, String taskContent)
    {
        this.nameTask = nameTask;
        this.currentDate = LocalDate.now();
        this.deadLine = LocalDate.parse(deadLine, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.taskContent = taskContent;
        this.deadlineActivated = true;
    }

    @Override
    public String toString()
    {
        // The print data will be different depending if the user has setup a deadline or not
        String deadLineDisplay = String.valueOf(deadLine);
        String currentDateDisplay = String.valueOf(currentDate);
        if(!deadlineActivated)
        {
               deadLineDisplay = "Deadline undefined";
        }

        return "Task name: " + nameTask + "\n" +
                "Task created at: " + currentDateDisplay + "\n" +
                "Task Content: " + taskContent + "\n" +
                "Task Deadline: " + deadLineDisplay + "\n";
    }
}
