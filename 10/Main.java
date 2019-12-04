import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//Case 10 Binary Search Tree: Lowest Common Ancestor
//You are given the elements of a binary search tree (BST) and two values v1 and v2. First, you need
//        to create the BST, the you should print the lowest common ancestor (LCA) of v1 and v2 in the BST.
//        For example, in the diagram above, the lowest common ancestor of the nodes 4 and 6 is the node
//        3, which is the lowest node that has nodes 4 and 6 as descendants.
public class Main {
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int size = fr.nextInt();
        Node root = new Node(fr.nextInt());
        for(int i = 0; i < size-1; ++i) {
            addToBinaryTree(root, fr.nextInt());
        }
        System.out.print(lowestCommonAncestor(root, fr.nextInt(), fr.nextInt()));
    }

    static int lowestCommonAncestor(Node t, int v1, int v2) {
        if ((v1 == t.n) || (v2 == t.n)) {
            return t.n;
        }
        if ((v1 > t.n && v2 < t.n) || (v1 < t.n && v2 > t.n)) {
            return t.n;
        } else {
            if (v1 > t.n && v2 > t.n) {
                if (t.b == null) {
                    return 0;
                } else {
                    if ((v1 == t.b.n) || (v2 == t.b.n)) {
                        return t.b.n;
                    }
                    return lowestCommonAncestor(t.b, v1, v2);
                }
            } else if (v1 < t.n && v2 < t.n) {
                if (t.s == null) {
                    return 0;
                } else {
                    if ((v1 == t.s.n) || (v2 == t.s.n)) {
                        return t.s.n;
                    }
                    return lowestCommonAncestor(t.s, v1, v2);
                }
            }
        }
        return -1;
    }

    static void addToBinaryTree(Node t, int v) {
        if (t.n != v) {
            if (t.n < v) {
                if (t.b == null) {
                    t.b = new Node(t, v);
                } else {
                    addToBinaryTree(t.b, v);
                }
            } else {
                if (t.s == null) {
                    t.s = new Node(t, v);
                } else {
                    addToBinaryTree(t.s, v);
                }
            }
        }
    }

    static class Node {
        int n;
        Node p;
        Node s = null;
        Node b = null;

        Node(Node p, int n, Node b, Node s) {
            this.n = n;
            this.p = p;
        }

        Node(Node p, int n) {
            this.n = n;
            this.p = p;
        }

        Node(int n) {
            this.n = n;
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