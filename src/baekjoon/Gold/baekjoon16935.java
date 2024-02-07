package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

public class baekjoon16935 {
	/**
	 * @author 임동길
	 * @date 2024-02-06
	 * @link https://www.acmicpc.net/problem/16926
	 * @keyword_solution  
	 * if(!check(nextX, nextY,j)) {
						direction = (direction+1)%4;
						nextX = startX+dx[direction];
						nextY = startY+dy[direction];
					} 무한루프
					
	 * 내부적으로 돌아야 하는 반복문의 횟수 = Math.min(n,m)/2
	 * 1. 외부에서부터 내부적으로 들어가며 값 이전을 실시
	 * 2. 해당 작업을 입력값인 k번 만큼 진행하면 완료
	 * 3. 값을 정상적으로 옮기기 위해서는 반시계 방향으로 이동하며, 초기값은 저장후에 배열에 넣어줘야함
	 * @input 
	 * 2<=N,M<=300
	 * min(N,M)mod 2 = 0
	 * @output
	 * 1<=A(i,j)<=10^8
	 * int로 처리 가능
	 * @time_complex 
	 * O(N)
	 * @perf 
	 * 42036kb, 1460ms
	 */
	static int[] dx= {0,1,0,-1};
	static int[] dy= {1,0,-1,0};
	static int[][] arr;
	static int[] selectOper;
	static int direction;
	static int n,m,k, max, min;
	static Set<Integer> set; 
	static Stack<Integer>intStack;
	static PriorityQueue<Integer>pq; 
	static StringTokenizer st;
	static boolean[] visited;
	static StringBuilder sb;
	static int[][] result, dp;
	public static void main(String[] args) throws Exception {
		//여기에 코드를 작성하세요.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<m; j++) {
				arr[i][j]= Integer.parseInt(st.nextToken()); 
			}
		}
		result = new int[n][m];
		st = new StringTokenizer(br.readLine()," ");
		while(st.hasMoreTokens()) {
			int operation = Integer.parseInt(st.nextToken());
			if(operation==1) {
				operation1();
			}else if(operation==2) {
				operation2();
			}else if(operation==3) {
				operation3();
			}else if(operation==4) {
				operation4();
			}else if(operation==5) {
				operation5();
			}else if(operation==6) {
				operation6();
			}
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	static void operation1() {

			int[][] saveArr = new int[n][m];
			for(int j=n-1; j>=n/2; j--) {
				saveArr[n-j-1] = Arrays.copyOf(arr[j], arr[j].length);
			}
			for(int j=0; j<n/2; j++) {
				saveArr[n-j-1] = Arrays.copyOf(arr[j], arr[j].length); 
			}
			arr = saveArr;
	}
	static void operation2() {

			int[][] saveArr = new int[n][m];
			for(int i=0; i<n; i++) {
				for(int j=m-1; j>=0; j--) {
					saveArr[i][m-j-1] = arr[i][j];
				}
			}
			arr = saveArr;
		
	}
	static void operation3() {

				int tmp = n;
				n = m;
				m = tmp;
				int[][] saveArr = new int[n][m];
				for(int j=0; j<m; j++) {
					for(int k=0; k<n; k++) {
						saveArr[k][m-1-j] = arr[j][k];
					}
				}
				arr= saveArr;
					
	}
	static void operation4() {
				int tmp = n;
				n = m;
				m = tmp;
				int[][] saveArr = new int[n][m];
				for(int j=0; j<m; j++) {
					for(int k=0; k<n; k++) {
						saveArr[n-1-k][j] = arr[j][k];
					}
				}
				arr= saveArr;

	}
	static void operation5() {


			int rowHalf = n/2; // 0 1 2 3 4 5
			int colHalf = m/2;
				int[][] tmp1 = new int[rowHalf][colHalf];
				int[][] tmp2 = new int[rowHalf][colHalf];
				int[][] tmp3 = new int[rowHalf][colHalf];
				int[][] tmp4 = new int[rowHalf][colHalf];
				int[][] saveArr = new int[n][m];
				for(int j=0; j<rowHalf; j++) {
					for(int k=0; k<colHalf; k++) {
						tmp1[j][k] = arr[j][k]; 
					}
					for(int k=colHalf; k<m; k++) {
						tmp2[j][k-colHalf] = arr[j][k]; 
					}
				}
				for(int j=rowHalf; j<n; j++) {
					for(int k=0; k<colHalf; k++) {
						tmp3[j-rowHalf][k] = arr[j][k];
					}
					for(int k=colHalf; k<m; k++) {
						tmp4[j-rowHalf][k-colHalf] = arr[j][k]; 
					}
				}
				
				for(int j=0; j<rowHalf; j++) {
					for(int k=0; k<colHalf; k++) {
						saveArr[j][k] = tmp3[j][k];
					}
					for(int k=colHalf; k<m; k++) {
						saveArr[j][k] = tmp1[j][k-colHalf]; 
					}
				}
				for(int j=rowHalf; j<n; j++) {
					for(int k=0; k<colHalf; k++) {
						saveArr[j][k] = tmp4[j-rowHalf][k]; 
					}
					for(int k=colHalf; k<m; k++) {
						saveArr[j][k] = tmp2[j-rowHalf][k-colHalf]; 
					}
				}
				arr = saveArr;

	}
	static void operation6() {

			int rowHalf = n/2; // 0 1 2 3 4 5
			int colHalf = m/2;
				int[][] tmp1 = new int[rowHalf][colHalf];
				int[][] tmp2 = new int[rowHalf][colHalf];
				int[][] tmp3 = new int[rowHalf][colHalf];
				int[][] tmp4 = new int[rowHalf][colHalf];
				int[][] saveArr = new int[n][m];
				for(int j=0; j<rowHalf; j++) {
					for(int k=0; k<colHalf; k++) {
						tmp1[j][k] = arr[j][k]; 
					}
					for(int k=colHalf; k<m; k++) {
						tmp2[j][k-colHalf] = arr[j][k]; 
					}
				}
				for(int j=rowHalf; j<n; j++) {
					for(int k=0; k<colHalf; k++) {
						tmp3[j-rowHalf][k] = arr[j][k];
					}
					for(int k=colHalf; k<m; k++) {
						tmp4[j-rowHalf][k-colHalf] = arr[j][k]; 
					}
				}
				
				for(int j=0; j<rowHalf; j++) {
					for(int k=0; k<colHalf; k++) {
						saveArr[j][k] = tmp2[j][k];
					}
					for(int k=colHalf; k<m; k++) {
						saveArr[j][k] = tmp4[j][k-colHalf]; 
					}
				}
				for(int j=rowHalf; j<n; j++) {
					for(int k=0; k<colHalf; k++) {
						saveArr[j][k] = tmp1[j-rowHalf][k]; 
					}
					for(int k=colHalf; k<m; k++) {
						saveArr[j][k] = tmp3[j-rowHalf][k-colHalf]; 
					}
				}
				arr = saveArr;
	}
}
