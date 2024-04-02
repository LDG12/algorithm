package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class beakjoon5052 {
    static StringTokenizer st;
    static StringBuilder sb;
    static int n,m,k;
    static class Node{
        Map<Character, Node> child = new HashMap<>();
        boolean endOfword;
    }
    static class Trie{
        Node rootNode = new Node();
        void insert(String word){
            Node node = this.rootNode;
            for(int i=0; i<word.length(); i++){
                node = node.child.computeIfAbsent(word.charAt(i), key->new Node());
            }
            node.endOfword = true;

        }
        public boolean contains(String word) {
            Node trieNode = rootNode;
            for(int i=0; i<word.length(); i++) {
                char c= word.charAt(i);
                Node node = trieNode.child.get(c);

                if(node == null) {
                    return false;
                }
                trieNode = node;
            }

            // 해당 단어로 종료하는 문자가 있는 경우 false
            if(trieNode.endOfword) {
                if(trieNode.child.isEmpty()) {
                    return false;
                }
            }
            return true;
        }
    }
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc=0; tc<T; tc++){
            Trie trie = new Trie();
            n = Integer.parseInt(br.readLine());
            boolean isConsistent = true;
            String[] word = new String[n];
            for(int i=0; i<n; i++){
                String tmp = br.readLine();
                word[i] = tmp;
                trie.insert(tmp);
            }
            for(String key : word){
                if(trie.contains(key)){
                    isConsistent =false;
                    break;
                }
            }
            System.out.println(isConsistent?"YES":"NO");
        }
    }
}
