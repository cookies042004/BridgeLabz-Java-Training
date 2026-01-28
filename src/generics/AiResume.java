package generics;

import java.util.*;

// abstract job role
abstract class JobRole {
    String candidateName;

    JobRole(String candidateName) {
        this.candidateName = candidateName;
    }

    abstract void screen();
}

// different job roles
class SoftwareEngineer extends JobRole {

    SoftwareEngineer(String candidateName) {
        super(candidateName);
    }

    void screen() {
        System.out.println(candidateName + " screened for Software Engineer role");
    }
}

class DataScientist extends JobRole {
    DataScientist(String candidateName) {
        super(candidateName);
    }

    void screen() {
        System.out.println(candidateName + " screened for Data Scientist role");
    }
}

class ProductManager extends JobRole {

    ProductManager(String candidateName) {
        super(candidateName);
    }

    void screen() {
        System.out.println(candidateName + " screened for Product Manager role");
    }
}

// generic resume class
class Resume<T extends JobRole> {
    T jobRole;

    Resume(T jobRole) {
        this.jobRole = jobRole;
    }

    void processResume() {
        jobRole.screen();
    }
}

// utility class
class ResumeScreeningUtil {
    // Generic method to create resume
    static <T extends JobRole> Resume<T> createResume(T role) {
        return new Resume<>(role);
    }

    // Wildcard method to screen multiple job roles
    static void screenAll(List<? extends JobRole> roles) {
        for (JobRole role : roles) {
            role.screen();
        }
    }
}

public class AiResume {
    public static void main(String[] args) {
        Resume<SoftwareEngineer> seResume =
                ResumeScreeningUtil.createResume(
                        new SoftwareEngineer("Akhil")
                );

        Resume<DataScientist> dsResume =
                ResumeScreeningUtil.createResume(
                        new DataScientist("Rohit")
                );

        Resume<ProductManager> pmResume =
                ResumeScreeningUtil.createResume(
                        new ProductManager("Neha")
                );

        // Individual processing
        seResume.processResume();
        dsResume.processResume();
        pmResume.processResume();

        // Screening pipeline (wildcard usage)
        List<JobRole> pipeline = new ArrayList<>();
        pipeline.add(new SoftwareEngineer("Ankit"));
        pipeline.add(new DataScientist("Priya"));
        pipeline.add(new ProductManager("Suman"));

        System.out.println("---- Screening Pipeline ----");
        ResumeScreeningUtil.screenAll(pipeline);
    }
}

