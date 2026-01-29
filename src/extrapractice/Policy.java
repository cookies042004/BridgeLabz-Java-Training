package extrapractice;

import java.time.LocalDate;

class Policy {
    int policyNumber;
    String policyHolderName;
    LocalDate expiryDate;
    String coverageType;
    double premium;

    Policy(int policyNumber, String policyHolderName,
           LocalDate expiryDate, String coverageType, double premium) {
        this.policyNumber = policyNumber;
        this.policyHolderName = policyHolderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premium = premium;
    }

    @Override
    public String toString() {
        return policyNumber + " | " + policyHolderName + " | " +
                expiryDate + " | " + coverageType + " | " + premium;
    }
}

