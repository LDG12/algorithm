package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// 종료시간 11:21
// 키워드 : 완전탐색, 부분집합
// 시간복잡도 : O(n⁴ * 2^5)  --> max = 10000 * 32 -> 320000
// 50개의 테스트케이스를 3초 이내 -> 50문제에 3억 -> 1문제에 600만이면 충분
// 20,348 kb, 123ms

public class swea2115 {
    static StringTokenizer st;
    static StringBuilder sb;
    static int n, m, k, max1, max2, result;
    static int[][] honey;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            honey = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < n; j++) {
                    honey[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            result = 0;
            makeHoney();
            sb.append("#" + (tc + 1) + " " + result + "\n");
        }
        System.out.print(sb.toString());
    }

    // 일꾼 1과 일꾼 2를 나누어 부분집합을 구하기
    static void makeHoney() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n - m; j++) {
                max1 = 0; // 노예 1의 이번 조합 max값
                max2 = 0; // 노예 2의 이번 조합 max값
                subset(i, j, 0, 0, 0, 0);
                // 만약 일꾼 하나를 만들고 남은 범위의 구역이 m이 안된다...?
                // 그러면 다음 줄로 넘어가고, 아니면 이번줄 탐색 해보고.
                int nextSlaveX = i;
                int nextSlaveY = j + m;
                // 한 줄에서 아직 탐색할 부분이 남아있다?
                // j = 1이라 쳐봐   m=2
                // 0~2 1~3 2~4     j+m <= n-m
                for (int k = j + m; k <= n - m; k++) {
                    subset(i, k, 0, 0, 0, 1);
                }
                // 한 줄이 이미 탐색을 했거나 공간이 안남아있다.
                nextSlaveX = i + 1;
                for (int k = nextSlaveX; k < n; k++) {
                    for (int s = 0; s <= n - m; s++) {
                        subset(k, s, 0, 0, 0, 1);
                    }
                }
                result = Math.max(result, (max1 + max2));
            }
        }
    }

    static void subset(int x, int y, int depth, int sum, int money, int slaveNum) {
        if (sum > k) return;
        if (depth == m) {
            if (slaveNum == 0) {
                max1 = Math.max(max1, money);
            } else if (slaveNum == 1) {
                max2 = Math.max(max2, money);
            }
            return;
        }
        int mmoney = (int) (Math.pow(honey[x][y], 2));
        // 이번 꿀은 부분집합에 포함을 시키고
        subset(x, y + 1, depth + 1, sum + honey[x][y], money + mmoney, slaveNum);
        // 이번 꿀은 부분집합에 포함시키지 않고.
        subset(x, y + 1, depth + 1, sum, money, slaveNum);
    }
}
