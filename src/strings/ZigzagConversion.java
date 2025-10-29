package strings;

public class ZigzagConversion {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        System.out.println(convert(s, numRows));
    }

    private static String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) return s;
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }
        int currRow = 0;
        boolean goingDown  = false;
        for (char ch : s.toCharArray()){
            rows[currRow].append(ch);
            if (currRow == 0 || currRow == numRows - 1){
                goingDown = !goingDown;
            }
            currRow += goingDown ? 1 : -1;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder row : rows){
            res.append(row);
        }
        return res.toString();
    }
}
