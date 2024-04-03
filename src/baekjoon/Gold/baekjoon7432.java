package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon7432 {
    static StringTokenizer st;
    static StringBuilder sb;
    static int n,m,k;
    static class Node{
        Map<String,Node> child = new HashMap<>();
        boolean isEnd;

        @Override
        public String toString() {
            return "Node{" +
                    "child=" + child +
                    ", isEnd=" + isEnd +
                    "}\n";
        }
    }
    static class Trie{
        Node root = new Node();

        void insert(String[] word){
            Node node = this.root;
            for(int i=0; i<word.length; i++){
                node = node.child.computeIfAbsent(word[i], key->new Node());
            }
            node.isEnd = true;
        }
        void showAll(int depth, Node root){
            Node node = root;
            if(node.child != null){
                List<String> list = new ArrayList<>(node.child.keySet());
                Collections.sort(list);
                for(String key : list){
                    for(int j=0; j<depth; j++){
                        System.out.print(" ");
                    }
                    System.out.println(key);
                    showAll(depth+1, node.child.get(key));
                }

            }
        }
    }
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        Trie trie = new Trie();
        for(int i=0; i<n; i++){
            st= new StringTokenizer(br.readLine(), "\\");
            String[] words = new String[st.countTokens()];
            for(int j=0; j<words.length; j++){
                words[j] = st.nextToken();
            }
            trie.insert(words);
        }
        trie.showAll(0, trie.root);
    }
}
