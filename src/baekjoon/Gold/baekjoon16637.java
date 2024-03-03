package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class baekjoon16637 {
    static StringTokenizer st;
    static StringBuilder sb;
    static int n, m, k, max;
    static List<Character> charList;
    static List<Integer> numList;
    static boolean[] visited;
    static int[] saveIndex;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String word = br.readLine();
        charList = new ArrayList<>();
        numList = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            char a = word.charAt(i);
            if (a == '*' || a == '/' || a == '+' || a == '-') {
                charList.add(a);
            } else {
                numList.add(a - '0');
            }
        }
        visited = new boolean[charList.size()];
        saveIndex = new int[numList.size()];
        max = Integer.MIN_VALUE;
        dfs(0, numList.get(0));
        System.out.println(max);
    }

    static void dfs(int depth, int sum) {
        if (depth >= charList.size()) {
            max = Math.max(max, sum);
            return;
        }
        int notBracket = cal(depth, sum, numList.get(depth + 1));
        dfs(depth + 1, notBracket);

        if (depth + 1 < charList.size()) {
            int bracket = cal(depth + 1, numList.get(depth + 1), numList.get(depth + 2));
            int result = cal(depth, sum, bracket);
            dfs(depth + 2, result);
        }
    }

    static int cal(int index, int a, int b) {
        char oper = charList.get(index);
        if (oper == '+') {
            return a + b;
        } else if (oper == '-') {
            return a - b;
        } else if (oper == '*') {
            return a * b;
        }
        return 0;
    }
}
