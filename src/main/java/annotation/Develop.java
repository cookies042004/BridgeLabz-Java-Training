package annotation;

import java.lang.reflect.*;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class)
@interface BugReport {
    String description();
}


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    BugReport[] value();
}

class Developer {

    @BugReport(description = "Null pointer issue")
    @BugReport(description = "Memory leak issue")
    public void fixCode() {}
}

public class Develop {
    public static void main(String[] args) throws Exception {

        Method method = Developer.class.getMethod("fixCode");

        BugReport[] reports = method.getAnnotationsByType(BugReport.class);

        for (BugReport report : reports) {
            System.out.println(report.description());
        }
    }
}
