package db;

import java.sql.*;
import models.Job;
import models.Freelancer;

public class FreelancerDAO {

    // Create a new freelancer
    public void createFreelancer(Freelancer freelancer) {
        String query = "INSERT INTO freelancers (name, skills) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, freelancer.getName());
            stmt.setString(2, freelancer.getSkills());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Read a freelancer by ID
    public Freelancer readFreelancer(int id) {
        Freelancer freelancer = null;
        String query = "SELECT * FROM freelancers WHERE id = ?";
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                freelancer = new Freelancer(rs.getString("name"), rs.getString("email"), rs.getString("skills"));
                freelancer.setId(rs.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return freelancer;
    }

    // Update an existing freelancer
    public void updateFreelancer(Freelancer freelancer) {
        String query = "UPDATE freelancers SET name = ?, skills = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, freelancer.getName());
            stmt.setString(2, freelancer.getSkills());
            stmt.setInt(3, freelancer.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete a freelancer by ID
    public void deleteFreelancer(int id) {
        String query = "DELETE FROM freelancers WHERE id = ?";
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // List all freelancers (optional helper method)
    public void listFreelancers() {
        String query = "SELECT * FROM freelancers";
        try (Connection conn = DatabaseConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Skills: " + rs.getString("skills"));
                System.out.println("--------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
