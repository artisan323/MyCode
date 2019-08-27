public class titleToNumber {
    public int titleToNumber(String s) {
        int len = s.length() - 1;
        int n = len;
        int num = 0;
        for(int i = 0; i < len + 1; i++){
            num += Math.pow(26, n) * (s.charAt(i) - 'A' + 1);
            n--;
        }
        return num;
    }
}
