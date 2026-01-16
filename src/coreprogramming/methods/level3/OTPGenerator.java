package coreprogramming.methods.level3;

import java.util.*;

public class OTPGenerator {
    static int generateOTP() {
        return 100000 + (int)(Math.random() * 900000);
    }

    static boolean isUnique(int[] arr) {
        Set<Integer> s = new HashSet<>();
        for (int x : arr) s.add(x);
        return s.size() == arr.length;
    }

    public static void main(String[] args) {
        int[] otp = new int[10];
        for (int i = 0; i < 10; i++) otp[i] = generateOTP();
        System.out.println(isUnique(otp));
    }
}

