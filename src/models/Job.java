package models;

public class Job {
    private int id;
    private String title;
    private String description;

    // Constructor
    public Job(String title, String description) {
        this.title = title;
        this.description = description;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Job [ID=" + id + ", Title=" + title + ", Description=" + description + "]";
    }
}
