package models;

public class Freelancer {
    private int id;
    private String name;
    private String email; // Add the email field
    private String skills;

    public Freelancer(String name, String email, String skills) {
        this.name = name;
        this.email = email;  // Set email
        this.skills = skills;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "Freelancer [ID=" + id + ", Name=" + name + ", Email=" + email + ", Skills=" + skills + "]";
    }
}
