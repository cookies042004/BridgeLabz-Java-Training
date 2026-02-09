package java8features;

import java.util.*;
import java.util.stream.*;

class PolicyHolder {
    String holderId, name, policyType;
    int age;
    double premiumAmount;

    PolicyHolder(String holderId, String name, int age, String policyType, double premiumAmount) {
        this.holderId = holderId;
        this.name = name;
        this.age = age;
        this.policyType = policyType;
        this.premiumAmount = premiumAmount;
    }
}

class RiskAssessment {
    String holderId, name;
    double riskScore;

    RiskAssessment(String holderId, String name, double riskScore) {
        this.holderId = holderId;
        this.name = name;
        this.riskScore = riskScore;
    }

    public String toString() {
        return name + " - Risk: " + riskScore;
    }
}

public class RiskAssessmentApp {
    public static void main(String[] args) {

        List<PolicyHolder> holders = Arrays.asList(
                new PolicyHolder("H1", "John", 65, "Life", 40000),
                new PolicyHolder("H2", "Mike", 45, "Life", 20000)
        );

        Map<String, List<RiskAssessment>> categorized =
                holders.stream()
                        .filter(h -> h.policyType.equals("Life") && h.age > 60)
                        .map(h -> new RiskAssessment(
                                h.holderId, h.name,
                                h.premiumAmount / h.age))
                        .sorted(Comparator.comparing(r -> r.riskScore, Comparator.reverseOrder()))
                        .collect(Collectors.groupingBy(
                                r -> r.riskScore > 0.5 ? "High Risk" : "Low Risk"));

        System.out.println(categorized);
    }
}
