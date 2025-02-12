import static spark.Spark.*;
import com.google.gson.Gson;
import db.FreelancerDAO;
import db.JobDAO;
import models.Freelancer;
import models.Job;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        port(8080);

        Gson gson = new Gson();

 
        FreelancerDAO freelancerDAO = new FreelancerDAO();
        JobDAO jobDAO = new JobDAO();


        get("/freelancers", (req, res) -> {
            res.type("application/json");

            return gson.toJson(freelancerDAO.listFreelancers());
        });

        get("/freelancers/:id", (req, res) -> {
            res.type("application/json");
            int id = Integer.parseInt(req.params(":id"));
            Freelancer freelancer = freelancerDAO.readFreelancer(id);
            if (freelancer != null) {
                return gson.toJson(freelancer);
            } else {
                res.status(404);
                return gson.toJson("Freelancer not found");
            }
        });


        post("/freelancers", (req, res) -> {
            res.type("application/json");
            Freelancer freelancer = gson.fromJson(req.body(), Freelancer.class);
            freelancerDAO.createFreelancer(freelancer);
            return gson.toJson(freelancer);
        });

        put("/freelancers/:id", (req, res) -> {
            res.type("application/json");
            int id = Integer.parseInt(req.params(":id"));
            Freelancer freelancer = gson.fromJson(req.body(), Freelancer.class);
            freelancer.setId(id);
            freelancerDAO.updateFreelancer(freelancer);
            return gson.toJson(freelancer);
        });

        delete("/freelancers/:id", (req, res) -> {
            res.type("application/json");
            int id = Integer.parseInt(req.params(":id"));
            freelancerDAO.deleteFreelancer(id);
            return gson.toJson("Freelancer deleted");
        });


        get("/jobs", (req, res) -> {
            res.type("application/json");

            return gson.toJson(jobDAO.listJobs());
        });

        get("/jobs/:id", (req, res) -> {
            res.type("application/json");
            int id = Integer.parseInt(req.params(":id"));
            Job job = jobDAO.readJob(id);
            if (job != null) {
                return gson.toJson(job);
            } else {
                res.status(404);
                return gson.toJson("Job not found");
            }
        });

        post("/jobs", (req, res) -> {
            res.type("application/json");
            Job job = gson.fromJson(req.body(), Job.class);
            jobDAO.createJob(job);
            return gson.toJson(job);
        });

        put("/jobs/:id", (req, res) -> {
            res.type("application/json");
            int id = Integer.parseInt(req.params(":id"));
            Job job = gson.fromJson(req.body(), Job.class);
            job.setId(id);
            jobDAO.updateJob(job);
            return gson.toJson(job);
        });

        delete("/jobs/:id", (req, res) -> {
            res.type("application/json");
            int id = Integer.parseInt(req.params(":id"));
            jobDAO.deleteJob(id);
            return gson.toJson("Job deleted");
        });
    }
}
