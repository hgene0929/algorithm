import java.io.*;
import java.util.*;

/**
 * 행을 기준으로 그 행에 없는(가능성 있는) 숫자를 시작으로 DFS
 * 오름차순으로 탐색해서 최적수 찾으면 중단 -> 사전순을 위함
 *
 * 좌표 설정(1열의 숫자들을 2차원으로 만드는 방법)
 * - 전체 칸은 81(9*9) 개, 이를 기준으로
 * - row : cnt(현재 살펴볼 차례) / 9
 * - col : cnt(현재 살펴볼 차례) % 9
 * - 전체 배열을 구획하여 특정 부분만 살펴보기 : 시작점 = (전체길이 / 구획길이) * 구획길이, 시작점 + offset
 */
public class Main {
	static int[][] board;
	static boolean done = false;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// input
		board = new int[9][9];
		for(int i=0; i<9; i++) {
			String inputs = br.readLine();
			for(int j=0; j<9; j++) {
				board[i][j] = inputs.charAt(j) - '0';
			}
		}

		// solution
		DFS(0);

		// output
		System.out.println(sb.toString());
	}

	static void DFS(int cnt) {
		if(cnt == 81) {
			print();
			done = true;
			return;
		}

		int r = cnt / 9;
		int c = cnt % 9;

		if(board[r][c] != 0) {
			DFS(cnt+1);
			if(done) {
				return;
			}
		}
		else {
			for(int num=1; num<=9; num++) {
				board[r][c] = num;
				if(checkRow(r, c) && checkCol(r, c) && checkBlock(r, c)) {
					DFS(cnt+1);
					if(done) {
						return;
					}
				}
				board[r][c] = 0;
			}
		}
	}

	/** 출력할 정답 저장 */
	static void print() {
		for(int r=0; r<9; r++) {
			for(int c=0; c<9; c++) {
				sb.append(board[r][c]);
			}
			sb.append("\n");
		}
	}

	/** 가로 방향 조건 검사 */
	static boolean checkRow(int tr, int tc) {
		for(int c=0; c<9; c++) {
			if(c != tc && board[tr][c] == board[tr][tc]) {
				return false;
			}
		}
		return true;
	}

	/** 세로 방향 조건 검사 */
	static boolean checkCol(int tr, int tc) {
		for(int r=0; r<9; r++) {
			if(r != tr && board[r][tc] == board[tr][tc]) {
				return false;
			}
		}
		return true;
	}

	/** 3*3 블록 조건 검사 */
	static boolean checkBlock(int tr, int tc) {
		int sr = (tr / 3) * 3;
		int sc = (tc / 3) * 3;
		for(int r=0; r<3; r++) {
			for(int c=0; c<3; c++) {
				if((tr != sr+r || tc != sc+c) && board[sr+r][sc+c] == board[tr][tc]) {
					return false;
				}
			}
		}
		return true;
	}
}
