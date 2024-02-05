	package swea;
	
	import java.io.BufferedReader;
	import java.io.InputStreamReader;
	import java.util.Queue;
	import java.util.Stack;
	import java.util.StringTokenizer;
import java.util.TreeSet;
	
	
	
	public class swea1228 {
		static class Node{
			int data;
			Node next;
			
			public Node() {}
			public Node(int data) {
				this.data = data;
			}
			public Node(int data, Node next) {
				this.data = data;
				this.next = next;
			}
			@Override
			public String toString() {
				return this.data+" "+this.next;
			}
		}
		static class LinkedList{
			Node head;
			Node tail;
			int size;
			
			public LinkedList() {}
			
			
			private void addFirst(int data) {
				Node node = new Node(data);
				node.next = head;
				head = node;
				size++;
				if(tail==null) {
					tail = head;
				}
				return;
			}
			private void addLast(int data) {
				Node node = new Node(data);
				tail.next = node;
				tail = node;
				size++;
				return;
			}
			public void add(int index, int data) {
				if(index==0) {
					addFirst(data);
					return;
				}
				else if(index==size) {
					addLast(data);
					return;
				}else {
					Node tmp = get(index-1);
					Node next = tmp.next;
					Node newNode = new Node(data);
					newNode.next = tmp.next;
					tmp.next = next;
					size++;
				}
				
			}
			public void add(int data) {
				add(size, data);
			}
			Node get(int index) {
				Node tmp = head;
				for(int i=0; i<index; i++) {
					tmp = tmp.next;
				}
				return tmp;
			}
			@Override
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
		}
		/**
		 * @author 임동길
		 * @date 
		 * @link
		 * @keyword_solution  
		 * Stack의 pop 조건과 비교 조건
		 * 1. 현재의 내 value가 스택의 맨 위 value보다 작다면 StringBuilder에 저장 후 반복 탈출 (pop X)
		 * 2. 현재의 내 value가 스택의 맨 위 value와 같다면 flag를 변경 (pop O)
		 * -> pop을 하는 이유? 크기가 같다면 더 뒤의 인덱스를 먼저 마주볼 것이기 때문
		 * 3. 현재의 내 value가 스택의 맨 위 value보다 크다면? (pop O)
		 * -> 최소 같은것을 찾을때까지 반복. 못찾았다면 0을 StringBuilder에 저장
		 * @input 
		 * n이 최대 50만이기때문에 O(nⁿ)으로 풀면 시간초과
		 * O(n)으로 해결해야함
		 * @output
		 * 
		 * @time_complex 
		 * O(N)
		 * @perf 
		 * 141232KB, 796ms
		 */
		static int[] dx= {1,0,-1,0,1,-1,-1,1};
		static int[] dy= {0,1,0,-1,1,-1,1,-1};
		static int[] arr, oper;
		static int[] selectOper;
		static int direction;
		static int n,m,k, max, min;
		static Stack<Character>operStack;
		static Stack<Integer>intStack; 
		static StringTokenizer st;
		static boolean[] visited;
		static StringBuilder sb;
		static int[][] result;
		public static void main(String[] args) throws Exception {
			//여기에 코드를 작성하세요.
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			sb = new StringBuilder();
			for(int q=0; q<10; q++) {
				LinkedList list = new LinkedList();
				n = Integer.parseInt(br.readLine());
				st= new StringTokenizer(br.readLine(), " ");
				for(int i=0; i<n; i++) {
					list.add(Integer.parseInt(st.nextToken()));
				}
				m = Integer.parseInt(br.readLine());
				st = new StringTokenizer(br.readLine()," ");
				for(int i=0; i<m; i++) {
					char a = st.nextToken().charAt(0);
					int startIndex = Integer.parseInt(st.nextToken());
					int count = Integer.parseInt(st.nextToken());
					LinkedList tmp = new LinkedList();
					for(int j=0; j<count; j++) {
						tmp.add(Integer.parseInt(st.nextToken()));
					}
					if(startIndex-1 <= 0 ) {
						startIndex = 0;
					}
					else {
						startIndex -= 1;
					}
					if(startIndex == 0) {
						Node head = list.head;
						Node next = head.next;
						head.next = tmp.head;
						list.head = tmp.head;
						tmp.tail.next = head;
					}
					else {
						Node node = list.get(startIndex);
						Node next = node.next;
						node.next = tmp.head;
						tmp.tail.next = next;
					}
					list.size += tmp.size;
				}
				sb.append("#"+(q+1)+" ");
				Node start = list.get(0);
				int cnt=0;
				while(start!=null && cnt!=10) {
					sb.append(start.data+" ");
					start = start.next;
					cnt++;
				}
				sb.append("\n");
			}
			System.out.println(sb.toString());
		}
		
	}
