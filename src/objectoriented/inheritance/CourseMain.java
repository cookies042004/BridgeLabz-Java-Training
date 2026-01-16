package objectoriented.inheritance;

class Course {
    String courseName;
    int duration;

    Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }
}

class OnlineCourse extends Course {
    String platform;
    boolean isRecorded;

    OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }
}

class PaidOnlineCourse extends OnlineCourse {
    double fee;
    double discount;

    PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, double fee, double discount) {
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }

    void showDetails() {
        System.out.println("Course: " + courseName + " | Duration: " + duration);
        System.out.println("Platform: " + platform + " | Recorded: " + isRecorded);
        System.out.println("Fee: ₹" + fee + " | Discount: " + discount + "%");
    }
}

public class CourseMain {
    public static void main(String[] args) {
        PaidOnlineCourse p = new PaidOnlineCourse("Java Mastery", 40, "Udemy", true, 499, 20);
        p.showDetails();
    }
}

