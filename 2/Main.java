import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Case 2 Mars Exploration
//Letters in some of the SOS messages are altered by cosmic radiation during transmission. Given the
//        signal received by Earth as a string, S, determine how many letters of Sami's SOS have been
//        changed by radiation.
public class Main {
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        String in = fr.next();
        int count = 0;
        int msgs = in.length()/3;
        StringBuffer sb = new StringBuffer(in);
        for(int i = 0; i < msgs; ++i) {
            String ss = sb.substring(0, 3);
            if (!ss.equals("SOS")) {
                if (sb.charAt(0) != 'S') {
                    ++count;
                }
                if (sb.charAt(1) != 'O') {
                    ++count;
                }
                if (sb.charAt(2) != 'S') {
                    ++count;
                }
            }
            sb.delete(0,3);
        }
        System.out.println(count);
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