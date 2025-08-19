import java.util.*;

public class StringManipulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence with mixed formatting:");
        String input = sc.nextLine().trim();

        System.out.println("Trimmed: " + input);
        System.out.println("Spaces replaced with underscores: " + input.replace(" ", "_"));
        System.out.println("Without digits: " + input.replaceAll("\\d", ""));
        String[] words = input.split("\\s+");
        System.out.println("Words array: " + Arrays.toString(words));
        System.out.println("Joined with '|': " + String.join(" | ", words));
        System.out.println("Without punctuation: " + input.replaceAll("\\p{Punct}", ""));
        System.out.println("Capitalized words: " + capitalizeWords(words));
        Collections.reverse(Arrays.asList(words));
        System.out.println("Reversed word order: " + String.join(" ", words));
        System.out.println("Word frequency:");
        countWordFrequency(input);
        sc.close();
    }

    static String capitalizeWords(String[] words) {
        StringBuilder sb = new StringBuilder();
        for (String w : words) sb.append(Character.toUpperCase(w.charAt(0))).append(w.substring(1).toLowerCase()).append(" ");
        return sb.toString().trim();
    }

    static void countWordFrequency(String text) {
        Map<String, Integer> freq = new LinkedHashMap<>();
        for (String w : text.toLowerCase().split("\\s+")) {
            w = w.replaceAll("\\p{Punct}", "");
            freq.put(w, freq.getOrDefault(w, 0) + 1);
        }
        freq.forEach((k, v) -> System.out.println(k + ": " + v));
    }
}
