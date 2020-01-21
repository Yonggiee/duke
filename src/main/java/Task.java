public class Task {
    public final boolean completed;
    public final String name;

    public Task(String name){
        this.name = name;
        this.completed = false;
    }

    public Task(String name, boolean completed){
        this.name = name;
        this.completed = completed;
    }

    public Task complete(){
        return new Task(this.name, true);
    }

    @Override
    public String toString(){
        String doneCheck = "[✓] ";
        String notDoneCheck = "[✗] ";

        if (completed){
            return doneCheck + this.name;
        } else {
            return notDoneCheck + this.name;            
        }
    }
}