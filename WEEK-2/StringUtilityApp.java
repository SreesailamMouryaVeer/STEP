import java.util.*;

public class StringUtilityApp {
    private static StringBuilder output = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== STRING UTILITY APPLICATION ===\n1. Text Analysis\n2. String Transformation\n3. ASCII Operations\n4. Performance Testing\n5. String Comparison Analysis\n6. Custom Algorithms");
        System.out.print("Choose an option: ");
        int c = sc.nextInt(); sc.nextLine();

        switch (c) {
            case 1: System.out.print("Enter text: "); textAnalysis(sc.nextLine()); break;
            case 2: System.out.print("Enter text: "); String t = sc.nextLine();
                    System.out.print("Enter operations (comma separated): ");
                    System.out.println(transform(t, sc.nextLine().split(","))); break;
            case 3: System.out.print("Enter text: "); asciiOps(sc.nextLine()); break;
            case 4: System.out.print("Enter iterations: "); perfTest(sc.nextInt()); break;
            case 5: System.out.print("Enter first string: "); String s1 = sc.nextLine();
                    System.out.print("Enter second string: "); String s2 = sc.nextLine();
                    compare(new String[]{s1, s2}); break;
            case 6: System.out.print("Enter text: "); customAlgo(sc.nextLine()); break;
            default: System.out.println("Invalid choice");
        }
        System.out.println(output); sc.close();
    }

    static void textAnalysis(String t) {
        output.append("Length: ").append(t.length()).append("\nWord count: ").append(t.split("\\s+").length).append("\n");
        Map<Character, Integer> f = new HashMap<>();
        for (char c : t.toCharArray()) f.put(c, f.getOrDefault(c, 0) + 1);
        output.append("Character frequency: ").append(f).append("\n");
    }

    static String transform(String t, String[] ops) {
        StringBuilder sb = new StringBuilder(t);
        for (String op : ops) switch (op.trim().toLowerCase()) {
            case "trim": sb = new StringBuilder(sb.toString().trim()); break;
            case "upper": sb = new StringBuilder(sb.toString().toUpperCase()); break;
            case "lower": sb = new StringBuilder(sb.toString().toLowerCase()); break;
            case "reverse": sb.reverse(); break;
        }
        return sb.toString();
    }

    static void asciiOps(String t) { for (char ch : t.toCharArray()) output.append(ch).append(": ").append((int) ch).append("\n"); }

    static void perfTest(int n) {
        long s = System.nanoTime(); String str = ""; for (int i = 0; i < n; i++) str += i;
        long e = System.nanoTime(); output.append("String time: ").append(e - s).append(" ns\n");
        s = System.nanoTime(); StringBuilder sb = new StringBuilder(); for (int i = 0; i < n; i++) sb.append(i);
        e = System.nanoTime(); output.append("StringBuilder time: ").append(e - s).append(" ns\n");
        s = System.nanoTime(); StringBuffer sbf = new StringBuffer(); for (int i = 0; i < n; i++) sbf.append(i);
        e = System.nanoTime(); output.append("StringBuffer time: ").append(e - s).append(" ns\n");
    }

    static void compare(String[] s) {
        output.append("== : ").append(s[0] == s[1]).append("\n")
              .append("equals: ").append(s[0].equals(s[1])).append("\n")
              .append("equalsIgnoreCase: ").append(s[0].equalsIgnoreCase(s[1])).append("\n")
              .append("compareTo: ").append(s[0].compareTo(s[1])).append("\n")
              .append("compareToIgnoreCase: ").append(s[0].compareToIgnoreCase(s[1])).append("\n");
    }

    static void customAlgo(String t) {
        String c = t.replaceAll("\\s+", "").toLowerCase();
        output.append("Palindrome: ").append(c.equals(new StringBuilder(c).reverse().toString())).append("\n");
    }
}
