package core_programming.methods.level3;

import java.util.Random;

public class FootballTeamHeight {

    static int[] generateHeights() {
        int[] heights = new int[11];
        Random r = new Random();
        for (int i = 0; i < heights.length; i++) {
            heights[i] = 150 + r.nextInt(101);
        }
        return heights;
    }

    static int sum(int[] arr) {
        int s = 0;
        for (int x : arr) s += x;
        return s;
    }

    static double mean(int[] arr) {
        return (double) sum(arr) / arr.length;
    }

    static int shortest(int[] arr) {
        int min = arr[0];
        for (int x : arr) if (x < min) min = x;
        return min;
    }

    static int tallest(int[] arr) {
        int max = arr[0];
        for (int x : arr) if (x > max) max = x;
        return max;
    }

    public static void main(String[] args) {
        int[] heights = generateHeights();
        System.out.println("Mean: " + mean(heights));
        System.out.println("Shortest: " + shortest(heights));
        System.out.println("Tallest: " + tallest(heights));
    }
}

