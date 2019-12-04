import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Case 12 Super Reduced String
//Steve has a string of lowercase characters in range ascii[‘a’…’z’]. He wants to reduce the string to
//        its shortest length by doing a series of operations. In each operation he selects a pair of adjacent
//        lowercase letters that match, and he deletes them. For instance, the string aab could be shortened
//        to b in one operation.
//        Steve’s task is to delete as many characters as possible using this method and print the resulting
//        string. If the final string is empty, print Empty String
public class Main {
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        String in = fr.next();
        System.out.print(stringSuperReducer(new StringBuffer(in), 0));
    }

    static String stringSuperReducer(StringBuffer s, int index) {
        if (index < s.length()-1) {
            char first = s.charAt(index);
            char second = s.charAt(index + 1);
            if (first == second) {
                s.delete(index, index + 2);
                stringSuperReducer(s, 0);
            } else {
                stringSuperReducer(s, ++index);
            }
        }
        String result = s.toString();
        return result.equals("") ? "Empty String" : result;
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}