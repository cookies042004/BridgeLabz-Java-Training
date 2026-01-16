package coreprogramming.strings.level2;

import java.util.Random;
import java.util.Scanner;

public class Vote {
    // method for generating random age between ten and ninety-nine for given n person
    public static int[] generateAge(int n){
        int[] result = new int[n];
        Random r = new Random();

        for(int i = 0;i < n;i++){
            result[i] = r.nextInt(90) + 10;
        }

        return result;
    }

    // method for checking is eligible for vote or not.
    static int[][] eligibleOrNot(int[] person){
        int n = person.length;
        int[][] result = new int[n][2];

        for(int i = 0;i < n;i++) {
            result[i][0] = person[i];
            if (person[i] < 18) {
                result[i][1] = 0;
            } else {
                result[i][1] = 1;
            }
        }

        return result;
    }

    static void displayingIsEligibleOrNot(int[][] result){
        int n = result.length;

        for(int i = 0;i < n;i++){
            if(result[i][1] == 1){
                System.out.println("Person age is " + result[i][0] + " and Can Vote");
            }
            else{
                System.out.println("Person age is " + result[i][0] + " and Cannot Vote");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number");
        int students = sc.nextInt();

        int[] studentsAge = generateAge(students);
        int[][] canVote = eligibleOrNot(studentsAge);
        displayingIsEligibleOrNot(canVote);
    }
}
