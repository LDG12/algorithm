import java.util.*;
import java.util.stream.Stream;
import java.io.*;
 
class Solution{
    static int n,m,k;
    static StringTokenizer st;
    static StringBuilder sb;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String word = br.readLine();
        String secondWord = br.readLine();
        Map<Character, Integer>compareMap = new HashMap<>();
        for(int i=0; i<secondWord.length(); i++) {
        	char key = secondWord.charAt(i);
        	compareMap.put(key, compareMap.getOrDefault(key, 0)+1);
        }
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<secondWord.length()-1; i++) {
        	char key = word.charAt(i);
        	map.put(key, map.getOrDefault(key, 0)+1);
        }
        int cnt=0;
        for(int i=secondWord.length()-1; i<word.length(); i++) {
        	char key = word.charAt(i);
        	map.put(key, map.getOrDefault(key, 0)+1);
        	if(map.equals(compareMap))cnt++;
        	key = word.charAt(i-secondWord.length()+1);
        	map.put(key, map.getOrDefault(key, 1)-1);
        	if(map.get(key)==0)map.remove(key);
        }
        System.out.println(cnt);
        br.close();
        bw.close();
    }
}

