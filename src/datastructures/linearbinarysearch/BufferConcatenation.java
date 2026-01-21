package datastructures.linearbinarysearch;


public class BufferConcatenation {
    static String concatenateString(String[] words){
        // creating string buffer object
        StringBuffer buffer = new StringBuffer();

        for(String str : words){
            buffer.append(str);
        }

        return buffer.toString();
    }

    public static void main(String[] args) {
        String[] words = {"Java", " ", "is", "powerful"};

        String result = concatenateString(words);

        System.out.println("concatenated string is " + result);
    }
}
