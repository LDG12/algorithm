package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon20056 {
    static StringTokenizer st;
    static StringBuilder sb;
    static int n, m, k;
    static int[][] arr;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static ArrayList<Fireball> fireballs;

    static class Fireball {
        int x, y, speed, mass, direction, index;

        public Fireball(int x, int y, int mass, int speed, int direction, int index) {
            this.x = x;
            this.y = y;
            this.mass = mass;
            this.speed = speed;
            this.direction = direction;
            this.index = index;
        }

        public String toString() {
            return "(" + this.x + "," + this.y + ")" + " (속도 : " + this.speed + ")  (질량 : " + this.mass + ")" + "  (방향 : " + this.direction + ") ////";
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        fireballs = new ArrayList<>();
        arr = new int[n][n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int mass = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());
            fireballs.add(new Fireball(x - 1, y - 1, mass, speed, direction, (i + 1)));
            arr[x - 1][y - 1]++;
        }
        for (int oper = 0; oper < k; oper++) {
            // 2차원 List  ?
            // n<=50    2500 n^2

            int[][] copy = copyArray();
            for (int i = 0; i < fireballs.size(); i++) {
                Fireball now = fireballs.get(i);
                copy[now.x][now.y]--;
                int direction = now.direction;
                int nextDirection = dx[direction] * now.speed;
                int nextDirectiony = dy[direction] * now.speed;
                // 0보다 작으면 n-1
                // n-1보다 크면
                int nextX = now.x + nextDirection;
                int nextY = now.y + nextDirectiony;
                // 0에서 1속도로 위
                // 그럼 n-1이 되어야함
                // (-1, 3) --> (n-1, 3)
                // -1 + 4   3
                nextX = rangeCheck(nextX);
                nextY = rangeCheck(nextY);
                now.x = nextX;
                now.y = nextY;
                copy[nextX][nextY]++;
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (copy[i][j] > 1) {
                        calculate(i, j, copy);
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = copy[i][j];
                }
            }
        }
        int result = 0;
        for (int i = 0; i < fireballs.size(); i++) {
            result += fireballs.get(i).mass;
        }
        System.out.println(result);
    }

    static void calculate(int x, int y, int[][] copy) {
        int mass = 0;
        int speed = 0;
        int prevDirection = -1;
        int cnt = 0;
        boolean isSameDirection = true;
        for (int i = fireballs.size() - 1; i >= 0; i--) {
            Fireball now = fireballs.get(i);
            if ((now.x) == x && (now.y) == y) {
                mass += now.mass;
                speed += now.speed;
                cnt++;
                if (prevDirection == -1) {
                    prevDirection = now.direction;
                } else if (prevDirection != -1) {
                    if (prevDirection % 2 != now.direction % 2) {
                        isSameDirection = false;
                    }
                }
                fireballs.remove(i);
            }
        }
        copy[x][y] = 0;
        if (mass / 5 > 0) {
            copy[x][y] = 4;
            int resultMass = mass / 5;
            int resultSpeed = speed / cnt;
            if (isSameDirection) {
                int[] direc = {0, 2, 4, 6};
                for (int i = 0; i < 4; i++) {
                    fireballs.add(new Fireball(x, y, resultMass, resultSpeed, direc[i], 0));
                }
            } else {
                int[] direc = {1, 3, 5, 7};
                for (int i = 0; i < 4; i++) {
                    fireballs.add(new Fireball(x, y, resultMass, resultSpeed, direc[i], 0));
                }
            }
        }
    }

    static int rangeCheck(int range) {
        // (0,3)에서 속도가 9로 << 방향 전진
        // (-9,3) =>
        // 3,3
        // 2,3
        // 1,3
        // 0,3
        // 3,3
        // 2,3
        // 1,3
        // 0,3
        // 3,3
        // n을 더해봤자 -인 상태
        // 반복은 시간낭비
        // (0,3)에서 속도가 9로 >> 방향 전진

        if (range < 0) {
            while(range<0){
                range+=n;
            }
        }
        if (range > n - 1) {
            range %= (n);
        }
        return range;
    }

    static int[][] copyArray() {
        int[][] copy = new int[n][n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(arr[i], 0, copy[i], 0, copy[i].length);
        }
        return copy;
    }
}
