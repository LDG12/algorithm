package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class swea2383 {
    static StringTokenizer st;
    static StringBuilder sb;
    static int n,m,k,min;
    static int[][] arr;
    static ArrayList<Person> person;
    static ArrayList<Stair> stair;
    static class Person implements Comparable<Person>{
        int x,y,stair, dist;
        public Person(int x, int y){
            this.x=x;
            this.y=y;
        }
        public Person(int x,int y,int stair, int dist){
            this.x = x;
            this.y=y;
            this.stair = stair;
            this.dist = dist;
        }
        public int compareTo(Person o){
            return Integer.compare(this.dist, o.dist);
        }
    }
    static class Stair{
        int x,y,cost;
        public Stair(int x, int y, int cost){
            this.x=x;
            this.y=y;
            this.cost =cost;
        }
    }
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc=0; tc<T; tc++){
            n = Integer.parseInt(br.readLine());
            arr = new int[n][n];
            person = new ArrayList<>();
            stair = new ArrayList<>();
            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine() , " ");
                for(int j=0; j<n; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    if(arr[i][j] == 1){
                        person.add(new Person(i,j));
                    }
                    if(arr[i][j]>1){
                        stair.add(new Stair(i,j,arr[i][j]));
                    }
                }
            }
            subset(0,new boolean[person.size()]);
            min = Integer.MAX_VALUE;
            subset(0, new boolean[person.size()]);
            System.out.println("#"+(tc+1)+" "+min);
        }
    }
    static void subset(int depth, boolean[] visited){
        if(depth==person.size()){
            calculator(visited);
            return;
        }

        visited[depth] = true;
        subset(depth+1, visited);
        visited[depth] = false;
        subset(depth+1, visited);
    }
    static void calculator(boolean[] visited){
        Person[] parr = new Person[person.size()];
        Stair stair1 = stair.get(0);
        Stair stair2 = stair.get(1);
        for(int i=0; i<visited.length; i++){
            Person now = person.get(i);
            if(visited[i]){
                parr[i] = new Person(now.x, now.y, 0, distance(now, stair1));
            }
            else{
                parr[i] = new Person(now.x, now.y, 1, distance(now, stair2));
            }
        }
        int max=0;
        for(int i=0; i<2; i++){
            PriorityQueue<Person> pq = new PriorityQueue<>();
            for(int j=0; j<parr.length; j++){
                if(parr[j].stair == i){
                    pq.offer(parr[j]);
                }
            }
            int[] time = new int[100];
            int end=0;
            while (!pq.isEmpty()) {
                Person cur = pq.poll();
                int start = cur.dist;
                end = start + stair.get(i).cost;
                for (int j = start; j < end; j++) {
                    if (time[j] == 3) {
                        end++;
                        continue;
                    }
                    time[j]++;
                }
                if (max < end) {
                    max = end;
                }
            }
        }
        if(min>max){
            min = max;
        }
    }
    static int distance(Person now, Stair stair){
        int dist = Math.abs(now.x - stair.x)+Math.abs(now.y - stair.y)+1;
        return dist;
    }
}
