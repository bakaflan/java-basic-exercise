import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class GrammarExercise {
    public static void main(String[] args) {
        String firstWordList = "";
        String secondWordList = "";
        Scanner input = new Scanner(System.in);
        firstWordList = input.next();
        secondWordList = input.next();
        List<String> result = findCommonWordsWithSpace(firstWordList, secondWordList);

    }

    public static List<String> findCommonWordsWithSpace(String firstWordList, String secondWordList) {
        validateWordList(firstWordList);
        validateWordList(secondWordList);

        List<String> firstList = Arrays.stream(firstWordList.split(","))
                .map(String::toUpperCase)
                .distinct()
                .collect(Collectors.toList());
        List<String> secondList = Arrays.stream(secondWordList.split(","))
                .map(String::toUpperCase)
                .distinct()
                .collect(Collectors.toList());

        return firstList.stream()
                .filter(secondList::contains)
                .map(w -> w.replace(""," ").trim())
                .collect(Collectors.toList());
    }

    private static void validateWordList(String wordList) {
        if (wordList.contains(",,") || !wordList.matches("[a-zA-Z,]+")) {
            throw new RuntimeException("input not valid");
        }
    }
}
