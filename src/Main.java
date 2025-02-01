import db.FreelancerDAO;
import db.JobDAO;
import models.Freelancer;
import models.Job;

public class Main {
    public static void main(String[] args) {
        // Create Job and Freelancer DAO instances
        JobDAO jobDAO = new JobDAO();
        FreelancerDAO freelancerDAO = new FreelancerDAO();

        // Creating and inserting a new job
        Job newJob = new Job("Java Developer", "Build web applications");
        jobDAO.createJob(newJob);

        // Correct Freelancer creation with email
        Freelancer newFreelancer = new Freelancer("John Doe", "john.doe@example.com", "Java, Spring Boot, MySQL");
        freelancerDAO.createFreelancer(newFreelancer);


        // Read a job by ID (Example: read job with ID 1)
        Job job = jobDAO.readJob(1);
        System.out.println("Read Job: " + job);

        // Read a freelancer by ID (Example: read freelancer with ID 1)
        Freelancer freelancer = freelancerDAO.readFreelancer(1);
        System.out.println("Read Freelancer: " + freelancer);

        

        // Delete a job by ID (Example: delete job with ID 1)
        jobDAO.deleteJob(1);

        // Delete a freelancer by ID (Example: delete freelancer with ID 1)
        freelancerDAO.deleteFreelancer(1);

        // List all jobs (optional)
        System.out.println("Listing all jobs:");
        jobDAO.listJobs();

        // List all freelancers (optional)
        System.out.println("Listing all freelancers:");
        freelancerDAO.listFreelancers();
    }
}
