package datastructures.linearbinarysearch;

public class SearchWordInSentence {
    public static String findInSentence(String[] sentences, String targetWord){
        for(String sentence : sentences){
            if(sentence.toLowerCase().contains(targetWord.toLowerCase())){
                return sentence;
            }
        }

        return "Not found";
    }

    public static void main(String[] args) {
        String[] sentences = {
                "Java is a powerful language",
                "Data structures are important",
                "Linear search is simple",
                "Practice makes perfect"
        };

        String targetWord = "Akhil";

        String result = findInSentence(sentences, targetWord);

        System.out.println(result);
    }
}
