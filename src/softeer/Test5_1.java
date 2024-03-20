package softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Test5_1 {
    static StringTokenizer st;
    static StringBuilder sb;
    static int n,m,k;
    static class Person implements Comparable<Person>{
        int score, index;
        Person(int score, int index){
            this.score = score;
            this.index = index;
        }

        @Override
        public int compareTo(Person o) {
            return Integer.compare(o.score, this.score);
        }

        @Override
        public String toString() {
            return "Person{" +
                    "score=" + score +
                    ", index=" + index +
                    '}';
        }
    }
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[][] result = new int[3][n];
        int[][] arr = new int[3][n];
        sb = new StringBuilder();
        for(int i=0; i<3; i++){
            PriorityQueue<Person> pq = new PriorityQueue<>();
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<n; j++){
                int score = Integer.parseInt(st.nextToken());
                arr[i][j] = score;
                pq.offer(new Person(score,j));
            }
            int grade = 1;
            int cnt = 2;
            Person first = pq.poll();
            int prev = first.score;
            result[i][first.index] = grade;
            boolean flag = false;
            while(!pq.isEmpty()){
                Person now = pq.poll();
                int nowScore = now.score;
                int nowIndex = now.index;
                if(prev == nowScore){
                    flag = true;
                }
                else{
                    flag = false;
                }
                if(flag){
                    result[i][nowIndex] = grade;
                }
                else{
                    result[i][nowIndex] = cnt;
                    grade = cnt;
                }
                cnt++;
                prev = nowScore;
            }
        }
        for(int i=0; i<3; i++){
            for(int j=0; j<n; j++){
                sb.append(result[i][j]+ " ");
            }
            sb.append("\n");
        }
        PriorityQueue<Person> lastPq = new PriorityQueue<>();
        int[] lastResult = new int[n];
        for(int i=0; i<n; i++){
            int sum = 0;
            for(int j=0; j<3; j++){
                sum+=arr[j][i];
            }
            lastPq.offer(new Person(sum, i));
        }
        Person first = lastPq.poll();
        lastResult[first.index] = 1;
        int prev = first.score;
        int cnt=2;
        int grade=1;
        boolean flag = false;
        while(!lastPq.isEmpty()){
            Person now = lastPq.poll();
            int nowScore = now.score;
            int nowIndex = now.index;
            if(prev == nowScore){
                flag = true;
            }
            else{
                flag = false;
            }
            if(flag){
                lastResult[now.index] = grade;
            }
            else{
                lastResult[now.index] = cnt;
                grade = cnt;
            }
            cnt++;
            prev = nowScore;
        }
        for(int i=0; i<n; i++){
            sb.append(lastResult[i]+" ");
        }
        System.out.println(sb.toString().trim());
    }
}
