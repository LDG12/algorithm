package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


// LinkedList 구현
class LinkedList{
	Node head;
	Node tail;
	int size=0;
	
	class Node{
		Object data;
		Node next;
		
		public Node(Object data) {
			this.data = data;
			this.next = null;
		}
		
		public String toString() {
			return this.data+" "+this.next;
		}
	}
	public LinkedList() {}
	public void addFirst(Object data) {
		Node node = new Node(data);
		node.next = head;
		head = node;
		size++;
		if(tail==null) {
			tail = head;
		}
	}
	public void addLast(Object data) {
		Node node = new Node(data);
		tail.next = node;
		tail = node;
		size++;
	}
	Node node(int index) {
		Node x = head;
		for(int i=0; i<index; i++) {
			x = x.next;
		}
		return x;
	}
	public void add(int index, Object data) {
		if(index==0) {
			addFirst(data);
		}
		else {
			  Node temp1 = node(index-1);
	          Node temp2 = temp1.next;
	          Node newNode = new Node(data);
	          temp1.next = newNode;
	          newNode.next = temp2;
	          size++;	           
	          if(newNode.next == null){
	              tail = newNode;
	          }
		}
	}
	public void add(Object data) {
		add(size, data);
	}
	public void remove(int index) {
		Node prev = node(index-1);
		Node target = prev.next;
		Node next = target.next;
		prev.next = next;
		if(target==tail) {
			tail=prev;
		}
		target = null;
		size--;
	}
	public void removeFirst() {
		Node tmp = head;
		Node next = tmp.next;
		head = next;
		tmp = null;
		size--;
	}
	public void removeLast() {
		remove(size-1);
	}
	public void change(int index, Object data) {
		Node tmp = node(index-1);
		Node indexNode = tmp.next;
		indexNode.data = data;
	}
	public String toString() {
		if(head == null){
            return "[]";
        }
        Node temp = head;
        String str = "[";
        while(temp.next != null){
            str += temp.data + ",";
            temp = temp.next;
        }
        str += temp.data;
        return str+"]";
	}
	public Node get(int index) {
		Node x = head;
		for(int i=0; i<index; i++) {
			x = x.next;
		}
		return x;
	}
	public int size() {
		return this.size;
	}
	
}

public class swea1230 {
	static int[] dx= {1,0,-1,0,1,-1,-1,1};
	static int[] dy= {0,1,0,-1,1,-1,1,-1};
	static int[]arr, oper;
	static int direction;
	static int n,m,k, max, min;
	static Stack<Character>stack; 
	static StringTokenizer st;
	static StringBuilder sb;
	static boolean[] visited;
	static int[][] result;
	public static void main(String[] args) throws Exception {
		//여기에 코드를 작성하세요.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			for(int q=0; q<10; q++) {
			n = Integer.parseInt(br.readLine());
			LinkedList list = new LinkedList();
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				String tmp = st.nextToken();
				list.add(tmp);
			}
			int opers = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			while(st.hasMoreTokens()) {
				String now = st.nextToken();
				if(now.length()==1 && Character.isAlphabetic(now.charAt(0))) {
					char oper = now.charAt(0);
					String word="";
					if(oper=='I') {
						int index = Integer.parseInt(st.nextToken());
						int nextOper = Integer.parseInt(st.nextToken());
						for(int i=0; i<nextOper; i++) {
							word = st.nextToken();
							list.add((index+i), word);
						}
					}
					else if(oper=='D') {
						int index = Integer.parseInt(st.nextToken());
						int nextOper = Integer.parseInt(st.nextToken());
						for(int i=0; i<nextOper; i++) {
							list.remove((index+i));
						}
					}
					else if(oper=='A') {
						int nextOper = Integer.parseInt(st.nextToken());
						for(int i=0; i<nextOper; i++) {
							word = st.nextToken();
							list.addLast(word);
						}
					}
				}
			}
			String tmp="";
			for(int i=0; i<10; i++) {
				tmp+=list.get(i).data+" ";
			}
			System.out.println("#"+(q+1)+" "+tmp);
		}
	}
}
