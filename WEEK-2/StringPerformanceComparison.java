public class StringPerformanceComparison {
    public static void main(String[] args) {
        System.out.println("=== PERFORMANCE COMPARISON ===");
        System.out.println("String: " + time(() -> concatStr(1000)) + " ns");
        System.out.println("StringBuilder: " + time(() -> concatSB(1000)) + " ns");
        System.out.println("StringBuffer: " + time(() -> concatSBuf(1000)) + " ns");
        demoSB();
        compareStrings();
    }

    static long time(Runnable r) {
        long s = System.nanoTime();
        r.run();
        return System.nanoTime() - s;
    }

    static String concatStr(int n) {
        String r = "";
        for (int i = 0; i < n; i++)
            r += "Java " + i + " ";
        return r;
    }

    static String concatSB(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++)
            sb.append("Java ").append(i).append(" ");
        return sb.toString();
    }

    static String concatSBuf(int n) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++)
            sb.append("Java ").append(i).append(" ");
        return sb.toString();
    }

    static void demoSB() {
        StringBuilder sb = new StringBuilder("Hello World");
        sb.append("!!!").insert(5, " Java").delete(0, 2).deleteCharAt(3).reverse().replace(0, 5, "ABCDE").setCharAt(0, 'Z');
        sb.ensureCapacity(50);
        sb.trimToSize();
        System.out.println("Capacity: " + sb.capacity());
        System.out.println("Final StringBuilder: " + sb);
    }

    static void compareStrings() {
        String s1 = "Hello", s2 = "Hello", s3 = new String("Hello");
        System.out.println("==: " + (s1 == s2) + ", == new: " + (s1 == s3));
        System.out.println("equals: " + s1.equals(s3));
        System.out.println("equalsIgnoreCase: " + s1.equalsIgnoreCase("hello"));
        System.out.println("compareTo: " + s1.compareTo("Hello"));
        System.out.println("compareToIgnoreCase: " + s1.compareToIgnoreCase("hello"));
    }
}
