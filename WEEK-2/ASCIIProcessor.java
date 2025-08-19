import java.util.*;

public class ASCIIProcessor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        for (char ch : input.toCharArray()) {
            System.out.printf("'%c': %d (%s)%n", ch, (int) ch, classify(ch));
            if (Character.isLetter(ch)) {
                char u = Character.toUpperCase(ch), l = Character.toLowerCase(ch);
                System.out.printf("  Upper: %c | Lower: %c | Diff: %d%n", u, l, Math.abs(u - l));
            }
        }

        System.out.print("\nCaesar shift: ");
        int shift = sc.nextInt(); sc.nextLine();
        String enc = caesar(input, shift);
        System.out.println("Encrypted: " + enc);
        System.out.println("Decrypted: " + caesar(enc, -shift));

        System.out.println("\nASCII Table (65-90):");
        for (int i = 65; i <= 90; i++) System.out.printf("%d -> %c%n", i, (char) i);

        int[] arr = input.chars().toArray();
        System.out.println("ASCII Array: " + Arrays.toString(arr));
        System.out.println("Back to String: " + new String(arr));

        sc.close();
    }

    static String classify(char ch) {
        if (Character.isUpperCase(ch)) return "Uppercase";
        if (Character.isLowerCase(ch)) return "Lowercase";
        if (Character.isDigit(ch)) return "Digit";
        return "Special";
    }

    static String caesar(String t, int s) {
        StringBuilder sb = new StringBuilder();
        for (char ch : t.toCharArray())
            sb.append(Character.isLetter(ch) ? (char) ((ch - (Character.isUpperCase(ch) ? 'A' : 'a') + s + 26) % 26 + (Character.isUpperCase(ch) ? 'A' : 'a')) : ch);
        return sb.toString();
    }
}
