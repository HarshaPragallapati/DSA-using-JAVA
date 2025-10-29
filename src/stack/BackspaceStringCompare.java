package stack;

public class BackspaceStringCompare {
    public static void main(String[] args) {
        String s = "ab#c", t = "ad#c";
        System.out.println(backspaceCompare(s, t));
    }

    private static boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1, j = t.length() - 1;
        while (i >= 0 || j >= 0) {
            i = getNextValidCharIndex(s, i);
            j = getNextValidCharIndex(t, j);
            if (i < 0 && j < 0) return true;
            if (i < 0 || j < 0) return false;
            if (s.charAt(i) != t.charAt(j)) return false;
            i--;
            j--;
        }
        return true;
    }

    private static int getNextValidCharIndex(String s, int index) {
        int backspaceCount = 0;
        while (index >= 0 && (s.charAt(index) == '#' || backspaceCount > 0)) {
            if (s.charAt(index) == '#') {
                backspaceCount++;
            } else {
                backspaceCount--;
            }
            index--;
        }
        return index;
    }
}
