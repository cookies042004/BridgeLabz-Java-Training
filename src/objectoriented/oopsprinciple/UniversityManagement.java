package objectoriented.oopsprinciple;


import java.util.ArrayList;

class Faculty{
    String facultyName;

    Faculty(String facultyName){
        this.facultyName = facultyName;
    }

    void showFaculty() {
        System.out.println("- Faculty: " + facultyName);
    }
}

class UniDepartment{
    String deptName;
    ArrayList<Faculty> faculties = new ArrayList<>();

    UniDepartment(String deptName){
        this.deptName = deptName;
    }

    void addFaculty(Faculty f){
        faculties.add(f);
    }

    void showDepartment() {
        System.out.println("\nDepartment: " + deptName);
        for (Faculty f : faculties) {
            f.showFaculty();
        }
    }
}

class University{
    String universityName;
    ArrayList<UniDepartment> departments = new ArrayList<>();
    ArrayList<Faculty> faculties = new ArrayList<>();

    University(String universityName){
        this.universityName = universityName;
    }

    void addDepartment(String deptName){
        departments.add(new UniDepartment(deptName));
    }

    void addFaculty(Faculty f){
        faculties.add(f);
    }

    UniDepartment getDepartment(String deptName) {
        for (UniDepartment d : departments) {
            if (d.deptName.equals(deptName)) {
                return d;
            }
        }
        return null;
    }

    void showUniversity() {
        System.out.println("\nUniversity: " + universityName);

        System.out.println("\nDepartments:");
        for (UniDepartment d : departments) {
            d.showDepartment();
        }

        System.out.println("\nAll Faculties (Independent):");
        for (Faculty f : faculties) {
            f.showFaculty();
        }
    }

    void deleteUniversity() {
        System.out.println("\nDeleting University: " + universityName);

        departments.clear();  // Composition effect: deletes all departments
        System.out.println("All departments removed.");

        // Faculty remains (aggregation)
        System.out.println("Faculties STILL exist (aggregation).");
    }
}

public class UniversityManagement {
    public static void main(String[] args) {
        University uni = new University("Oxford University");

        // Faculties exist independently (aggregation)
        Faculty f1 = new Faculty("Dr. John");
        Faculty f2 = new Faculty("Dr. Sarah");

        // Add faculties to university
        uni.addFaculty(f1);
        uni.addFaculty(f2);

        // Composition: University creates departments
        uni.addDepartment("Computer Science");
        uni.addDepartment("Mathematics");

        // Assign faculty to departments
        UniDepartment cs = uni.getDepartment("Computer Science");
        cs.addFaculty(f1);

        UniDepartment math = uni.getDepartment("Mathematics");
        math.addFaculty(f2);

        // Show structure
        uni.showUniversity();

        // Delete university (composition)
        uni.deleteUniversity();

        // Show faculty still exists after university deletion
        System.out.println("\nFaculty still available after university deletion:");
        f1.showFaculty();
        f2.showFaculty();
    }
}
