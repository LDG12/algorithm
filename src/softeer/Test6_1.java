package softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Test6_1 {
    static StringTokenizer st;
    static StringBuilder sb;
    static int n,m, home, company;
    static ArrayList<Integer>[] list;
    static ArrayList<Integer>[] reverse;
    static boolean[] toHome;
    static boolean[] toCompany;
    static Set<Integer> toHomeSet;
    static Set<Integer> toCompanySet;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n+1];
        reverse = new ArrayList[n+1];

        toHome = new boolean[n+1];
        toCompany = new boolean[n+1];

        toHomeSet = new HashSet<>();
        toCompanySet = new HashSet<>();

        for(int i=1; i<list.length; i++){
            list[i] = new ArrayList<>();
            reverse[i] = new ArrayList<>();
        }
        for(int i=0; i<m; i++){
            st =new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list[from].add(to);
            reverse[to].add(from);
        }
        st = new StringTokenizer(br.readLine(), " ");
        home = Integer.parseInt(st.nextToken());
        company = Integer.parseInt(st.nextToken());

        HashSet<Integer> homeToCompanyForward = new HashSet<>();
        dfs(home, company, list, new boolean[n+1],homeToCompanyForward);
        System.out.println(homeToCompanyForward);
        HashSet<Integer> homeToCompanyReverse = new HashSet<>();
        dfs(company, -1, reverse, new boolean[n+1], homeToCompanyReverse);
        System.out.println(homeToCompanyReverse);

        homeToCompanyForward.retainAll(homeToCompanyReverse);

        HashSet<Integer> companyToHomeForward = new HashSet<>();
        dfs(company, home, list, new boolean[n+1], companyToHomeForward);
        System.out.println(companyToHomeForward);
        HashSet<Integer> companyToHomeReverse = new HashSet<>();
        dfs(home, -1, reverse, new boolean[n+1], companyToHomeReverse);
        System.out.println(companyToHomeReverse);
        companyToHomeForward.retainAll(companyToHomeReverse);

        homeToCompanyForward.retainAll(companyToHomeForward);
        int answer = homeToCompanyForward.size();
        if(homeToCompanyForward.contains(home))answer--;
        if(homeToCompanyForward.contains(company))answer--;

        System.out.println(answer);
    }
    static void dfs(int start, int end, ArrayList<Integer>[] list,boolean[]visited, HashSet<Integer> set){
        if(end != -1 && start == end){
            return;
        }
        for(Integer i : list[start]){
            if(!visited[i]){
                visited[i] = true;
                set.add(i);
                dfs(i, end, list,visited, set);
            }
        }
    }
}
