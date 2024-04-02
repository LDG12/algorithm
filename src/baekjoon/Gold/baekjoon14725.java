package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon14725 {
    static StringTokenizer st;
    static StringBuilder sb;
    static int n,m,k;
    static class Node{
        Map<String, Node> child = new HashMap<>();
        boolean isEnd;
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
        public void showAll(Node cur, int depth) {
            Node node = cur;
            if(node.child !=null) {
                List<String> list = new ArrayList<>(node.child.keySet());
                Collections.sort(list);
                for(String str : list) {
                    for(int i=0; i<depth; i++) {
                        System.out.print("--");
                    }
                    System.out.println(str);
                    showAll(node.child.get(str), depth+1);
                }
            }

        }

    }
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        Trie trie = new Trie();
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            m = Integer.parseInt(st.nextToken());
            String[] arr = new String[m];
            for(int j=0; j<m; j++){
                arr[j] = st.nextToken();
            }
            trie.insert(arr);
        }
        trie.showAll(trie.root,0);
    }
}
