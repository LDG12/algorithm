package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon21610 {
    static StringTokenizer st;
    static StringBuilder sb;
    static int n,m,k;
    static int[][]arr;
    static int[] dx = {0,-1,-1,-1,0,1,1,1};
    static int[] dy = {-1,-1,0,1,1,1,0,-1};
    static ArrayList<Raindance> raindances;
    static class Raindance{
        int x,y;
        Raindance next;
        public Raindance(int x,int y){
            this.x=x;
            this.y=y;
            this.next = null;
        }

        @Override
        public String toString() {
            return "Raindance{" +
                    "x=" + x +
                    ", y=" + y +
                    ", next=" + next +
                    '}';
        }
    }
    static class RaindanceList{
        Raindance head;
        Raindance tail;
        int size;

        public RaindanceList(){
            this.head = null;
            this.tail = null;
            this.size = 0;
        }

        void addFirst(Raindance raindance){
            raindance.next = head;
            head = raindance;
            size++;
            if(tail==null){
                tail = head;
            }
        }
        void addLast(Raindance raindance){
            tail.next = raindance;
            tail = raindance;
            size++;
        }
        Raindance getRaindance(int index){
            Raindance x = head;
            for(int i=0; i<index; i++){
                x = x.next;
            }
            return x;
        }
        void add(int index, Raindance raindance){
            if(index == 0){
                addFirst(raindance);
            }
            else{
                Raindance tmp1 = getRaindance(index-1);
                Raindance tmp2 = tmp1.next;
                tmp1.next = raindance;
                raindance.next = tmp2;
                size++;
                if(raindance.next == null){
                    tail = raindance;
                }
            }
        }
        void add(Raindance raindance){
            add(size, raindance);
        }
        public void remove(int index){
            Raindance now = getRaindance(index-1);
            Raindance target = now.next;
            Raindance next = target.next;
            if(target==tail){
                tail = now;
            }
            target = null;
            size--;
        }
        void removeAll(){
            if(head!=null){
                head = null;
                tail = null;
            }
            size = 0;
        }

        @Override
        public String toString() {
            return ""+head;
        }
    }
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        RaindanceList list = new RaindanceList();
        list.add(new Raindance(n-2,0));
        list.add(new Raindance(n-2,1));
        list.add(new Raindance(n-1,0));
        list.add(new Raindance(n-1,1));
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int direction = Integer.parseInt(st.nextToken())-1;
            int speed = Integer.parseInt(st.nextToken());
            boolean[][] visited = new boolean[n][n];
            for(Raindance now = list.getRaindance(0); now!=null; now = now.next){
                int distanceX = dx[direction] * speed;
                int distanceY = dy[direction] * speed;
                now.x += distanceX;
                now.y += distanceY;
                if(now.x < 0){
                    while(now.x<0){
                        now.x+=n;
                    }
                }
                if(now.y < 0){
                    while(now.y<0){
                        now.y+=n;
                    }
                }
                if(now.x>=n)now.x%=n;
                if(now.y>=n)now.y%=n;
                visited[now.x][now.y] = true;
                arr[now.x][now.y]++;
            }
            for(Raindance now = list.getRaindance(0); now!=null; now = now.next){
                int cnt=0;
                for(int j = 1; j<8; j+=2){
                    int nextX = now.x+dx[j];
                    int nextY = now.y+dy[j];
                    if(rangeCheck(nextX,nextY) && arr[nextX][nextY]>=1){
                        cnt++;
                    }
                }
                arr[now.x][now.y]+=cnt;
            }
            list.removeAll();
            for(int j=0; j<n; j++){
                for(int k=0; k<n; k++){
                    if(!visited[j][k] && arr[j][k]>=2){
                        arr[j][k] -=2;
                        list.add(new Raindance(j,k));
                    }
                }
            }
        }
        int result=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                result+=arr[i][j];
            }
        }
        System.out.println(result);
    }
    static boolean rangeCheck(int x,int y){
        if(x>=0 && y>=0 && x<n && y<n)return true;
        return false;
    }
    static void solve(){

    }
}
