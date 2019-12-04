import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// Use StringBuffer for String manipulation (append, insert, reverse, delete)
//
public class Main {
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int n = fr.nextInt();
        int k = fr.nextInt();
        PriorityQueue<Integer> cs = new PriorityQueue<>();
        for(int i = 0; i < n-1; ++i) {
            cs.add(fr.nextInt());
        }
        int count = 0;
        while(cs.peek() < k) {
            Integer c1 = cs.poll();
            Integer c2 = cs.poll();
            if(c1 != null && c2 != null) {
                int nc = c1 + 2*c2;
                cs.add(nc);
                count++;
            } else {
                count = -1;
                break;
            }
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
