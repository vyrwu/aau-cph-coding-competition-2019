import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Use StringBuffer for String manipulation (append, insert, reverse, delete)
//
public class Main {
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int p = fr.nextInt();
        int d = fr.nextInt();
        int m = fr.nextInt();
        int s = fr.nextInt();
        System.out.print(gameCount(p, d, m, s, 0));
    }

    static int gameCount(int p, int d, int m, int s, int lastCount) {
        int priceCount = lastCount;
        if (s < p) {
            return priceCount;
        } else {
            priceCount++;
            s = s - p;
            p = ((p - d) > m) ? (p - d) : m;
            return gameCount(p, d, m, s, priceCount);
        }
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