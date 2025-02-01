import db.FreelancerDAO;
import db.JobDAO;
import models.Freelancer;
import models.Job;

public class Main {
    public static void main(String[] args) {
        JobDAO jobDAO = new JobDAO();
        FreelancerDAO freelancerDAO = new FreelancerDAO();

        Job newJob = new Job("Java Developer", "Build web applications");
        jobDAO.createJob(newJob);

        Freelancer newFreelancer = new Freelancer("John Doe", "john.doe@example.com", "Java, Spring Boot, MySQL");
        freelancerDAO.createFreelancer(newFreelancer);


        Job job = jobDAO.readJob(1);
        System.out.println("Read Job: " + job);

        Freelancer freelancer = freelancerDAO.readFreelancer(1);
        System.out.println("Read Freelancer: " + freelancer);

        
        jobDAO.deleteJob(1);

        freelancerDAO.deleteFreelancer(1);

        System.out.println("Listing all jobs:");
        jobDAO.listJobs();

        System.out.println("Listing all freelancers:");
        freelancerDAO.listFreelancers();
    }
}
