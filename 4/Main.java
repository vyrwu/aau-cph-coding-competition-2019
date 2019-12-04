import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Case 4 Halloween Sale
//Usually, all games are sold at the same price, p euros. However, they are planning to have the
//        seasonal Halloween Sale next month in which you can buy games at a cheaper price. Specifically,
//        the first game you buy during the sale will be sold at p euros, but every subsequent game you buy
//        will be sold at exactly d euros less than the cost of the previous one you bought. This will continue
//        until the cost becomes less than or equal to m euros, after which every game you buy will cost m
//        euros each.
//        For example, if p = 20, d = 3, and m = 6, then the following are the costs of the first 11 games you
//        buy, in order:
//        20, 17, 14, 11, 8, 6, 6, 6, 6, 6, 6
//        You have euros s in your Mist wallet. How many games can you buy during the Halloween Sale?
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