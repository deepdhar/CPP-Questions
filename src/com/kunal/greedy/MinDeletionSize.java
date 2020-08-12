package com.kunal.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
// https://leetcode.com/problems/delete-columns-to-make-sorted-ii/
public class MinDeletionSize {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
//        int t = in.nextInt();
        solver.solve(1, in, out);
        out.close();
    }

    static class Task {
        public void solve(int testNumber, InputReader in, PrintWriter out) throws IOException {

        }
        public int minDeletionSize(String[] A) {
            int N = A.length;
            int W = A[0].length();
            int ans = 0;

            // cur : all rows we have written
            // For example, with A = ["abc","def","ghi"] we might have
            // cur = ["ab", "de", "gh"].
            String[] cur = new String[N];
            for (int j = 0; j < W; ++j) {
                // cur2 : What we potentially can write, including the
                //        newest column col = [A[i][j] for i]
                // Eg. if cur = ["ab","de","gh"] and col = ("c","f","i"),
                // then cur2 = ["abc","def","ghi"].
                String[] cur2 = Arrays.copyOf(cur, N);
                for (int i = 0; i < N; ++i)
                    cur2[i] += A[i].charAt(j);
                if (isSorted(cur2))
                    cur = cur2;
                else
                    ans++;
            }
            return ans;
        }

        public boolean isSorted(String[] A) {
            for (int i = 0; i < A.length - 1; ++i)
                if (A[i].compareTo(A[i+1]) > 0)
                    return false;

            return true;
        }
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public char nextChar() {
            return next().charAt(0);
        }

        public String nextLine() throws IOException {
            return reader.readLine().trim();
        }
    }
}
