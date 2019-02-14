package easy;

public class leetcode771 {

    String J, S;

    public leetcode771(String j, String s) {
        J = j;
        S = s;
    }

    public String getJ() {
        return J;
    }

    public void setJ(String j) {
        J = j;
    }

    public String getS() {
        return S;
    }

    public void setS(String s) {
        S = s;
    }

    public int result () {

        int count = 0;
        for (int i = 0; i < J.length(); i++) {
            for (int j = 0; j < S.length(); j++) {
                if (S.charAt(j) == J.charAt(i)) {
                    count++;
                }
            }
        }

        return count;

    }

}
