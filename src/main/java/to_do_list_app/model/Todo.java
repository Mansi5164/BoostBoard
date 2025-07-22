package to_do_list_app.model;

import jakarta.persistence.*;

@Entity
@Table
public class Todo {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column // optional, could be omitted
    private Long id;

    @Column
    private boolean completed;

    @Column
    private String task;

    public Todo() {}

    // Constructor for easy object creation (optional)
    public Todo(String task, boolean completed) {
        this.task = task;
        this.completed = completed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean getCompleted() {  // ✅ JavaBeans convention uses "is" for boolean
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }
}
