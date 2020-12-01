import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TaskItem extends TaskList{

    protected String Title;
    protected String Description;
    protected String DueDate;
    protected boolean Complete = false;

    protected String getTitle(){
        return this.Title;
    }

    protected String getDescription(){
        return this.Description;
    }

    protected String getDueDate(){
        return this.DueDate;
    }

    protected void setTitle(String title){
        this.Title = title;
    }

    protected void setDescription(String description){
        this.Description = description;
    }

    protected int setDueDate(String dueDate){
        LocalDate ld;
        try {
            ld = LocalDate.parse(dueDate);
        }
        catch(Exception e){
            System.out.printf("Warning: invalid due date");
            return 0;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.DueDate = formatter.format(ld);
        return 1;
    }

    protected int checkTitle(){
        if(Title.length() == 0) {
            System.out.printf("WARNING: title must be at least 1 character long");
            return 0;
        }
        return 1;
    }

    protected void markComplete(){
        this.Complete = true;
    }

    protected void markUnComplete(){
        this.Complete = false;
    }

}