import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class JobListing {
    private String title;
    private String description;

    public JobListing(String title, String description) {
        this.title = title;
        this.description = description;
    }

    // Getters and setters

    @Override
    public String toString() {
        return "Job Listing: " + title + "\nDescription: " + description;
    }
}

class JobApplication {
    private String name;
    private String resume;
    private JobListing jobListing;

    public JobApplication(String name, String resume, JobListing jobListing) {
        this.name = name;
        this.resume = resume;
        this.jobListing = jobListing;
    }

    // Getters and setters

    @Override
    public String toString() {
        return "Applicant Name: " + name + "\nResume: " + resume + "\n" + jobListing;
    }
}

public class JobApplicationApp {
    private static List<JobListing> jobListings = new ArrayList<>();
    private static List<JobApplication> jobApplications = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nJob Application App");
            System.out.println("1. Post Job Listing");
            System.out.println("2. View Job Listings");
            System.out.println("3. Apply for a Job");
            System.out.println("4. View Job Applications");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    postJobListing(scanner);
                    break;
                case 2:
                    viewJobListings();
                    break;
                case 3:
                    applyForJob(scanner);
                    break;
                case 4:
                    viewJobApplications();
                    break;
                case 5:
                    System.out.println("Exiting the application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 5);

        scanner.close();
    }

    private static void postJobListing(Scanner scanner) {
        System.out.print("Enter job title: ");
        String title = scanner.next();
        System.out.print("Enter job description: ");
        scanner.nextLine(); // Consume the newline character
        String description = scanner.nextLine();
        JobListing jobListing = new JobListing(title, description);
        jobListings.add(jobListing);
        System.out.println("Job listing posted successfully!");
    }

    private static void viewJobListings() {
        if (jobListings.isEmpty()) {
            System.out.println("No job listings available.");
            return;
        }

        System.out.println("\nJob Listings:");
        for (JobListing jobListing : jobListings) {
            System.out.println(jobListing);
            System.out.println("-------------------");
        }
    }

    private static void applyForJob(Scanner scanner) {
        if (jobListings.isEmpty()) {
            System.out.println("No job listings available to apply for.");
            return;
        }

        viewJobListings();
        System.out.print("Enter the index of the job you want to apply for: ");
        int index = scanner.nextInt();

        if (index >= 0 && index < jobListings.size()) {
            JobListing selectedJob = jobListings.get(index);
            scanner.nextLine(); // Consume the newline character
            System.out.print("Enter your name: ");
            String name = scanner.nextLine();
            System.out.print("Enter your resume: ");
            String resume = scanner.nextLine();
            JobApplication jobApplication = new JobApplication(name, resume, selectedJob);
            jobApplications.add(jobApplication);
            System.out.println("Application submitted successfully!");
        } else {
            System.out.println("Invalid job index.");
        }
    }

    private static void viewJobApplications() {
        if (jobApplications.isEmpty()) {
            System.out.println("No job applications available.");
            return;
        }

        System.out.println("\nJob Applications:");
        for (JobApplication jobApplication : jobApplications) {
            System.out.println(jobApplication);
            System.out.println("-------------------");
        }
    }
}
