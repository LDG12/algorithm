package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon20055 {
    static StringTokenizer st;
    static StringBuilder sb;
    static int n,m,k;
    static int[] conveyor;
    static Queue<Integer> q;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        q = new ArrayDeque<>();
        conveyor = new int[n*2];
        int loop = 1;
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<conveyor.length; i++){
            conveyor[i] = Integer.parseInt(st.nextToken());
        }
        int[] isRobot = new int[n*2];
        while(true){
            moveConveyor(isRobot); // 1. 컨베이어 이동
            moveRobot(isRobot); // 2. 로봇 이동
            if(conveyor[0] > 0){ // 3. 0번 위치가 비어있다면 올리기.
                if(isRobot[0] != 1){
                    isRobot[0] = 1;
                    conveyor[0] --;
                    q.offer(0);
                }
            }

            int cnt = isEmpty(); // 4. 빈 컨베이어 체크
            if(cnt>=m)break;
            loop++;
        }
        System.out.println(loop);
    }
    static void moveRobot(int[] isRobot){
        int size = q.size();
        for(int i=0; i<size; i++){
            int index = q.poll();
            int now = (index+1)>=(n*2-1)?(index+1)%(n*2) : index+1;
            int next = (index+2)>=(n*2-1)?(index+2)%(n*2) : index+2;
            if(conveyor[next]>0){
                if(isRobot[next]==1){
                    q.offer(now);
                    continue;
                }
                conveyor[next]--;
                isRobot[now] = 0;
                if(next == n-1){

                }
                else{
                    isRobot[next] = 1;
                    q.offer(next);
                }
            }
            else{
                q.offer(now);
            }
        }
    }
    static int isEmpty(){
        int cnt =0 ;
        for(int i=0; i<conveyor.length; i++){
            if(conveyor[i]<=0){
                cnt++;
            }
        }
        return cnt;
    }
    static void moveConveyor(int[] isRobot){
        int last = conveyor[conveyor.length-1];
        boolean flag = false;
        if(isRobot[conveyor.length-1] == 1){
            flag = true;
            isRobot[conveyor.length-1]=0;
        }
        for(int i = conveyor.length-2; i>=0; i--){
            if(isRobot[i] == 1){
                if(i+1 == n-1){
                    isRobot[i]=0;
                    q.remove(i);
                }
                else{
                    isRobot[i+1] = 1;
                    isRobot[i] = 0;
                }
            }
            conveyor[i+1] = conveyor[i];
        }
        conveyor[0] = last;
        if(flag){
            isRobot[0] = 1;
        }
    }
}
