import java.io.*;
import java.util.*;

public class Main {
	static Team[] teams = new Team[6];
	static int[] teamA = new int[15];
	static int[] teamB = new int[15];
	static boolean possible = false;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		/* 4개의 테스트케이스 */
		for(int t=0; t<4; t++) {
			// input
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<6; i++) {
				teams[i] = new Team(
					Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken())
				);
			}

			// solution
			setPairs();
			DFS(0);
			if(possible) sb.append(1).append(" ");
			else sb.append(0).append(" ");
			possible = false;
		}

		// output
		System.out.println(sb.toString());
	}

	static void setPairs() {
		int cnt = 0;
		for(int i=0; i<5; i++) {
			for(int j=i+1; j<6; j++) {
				teamA[cnt] = i;
				teamB[cnt++] = j;
			}
		}
	}

	static void DFS(int cnt) {
		if(cnt == 15) {
			if(check()) possible = true;
			return;
		}

		Team a = teams[teamA[cnt]];
		Team b = teams[teamB[cnt]];

		// win
		a.win -= 1;
		b.lose -= 1;
		DFS(cnt+1);
		a.win += 1;
		b.lose += 1;

		// tie
		a.tie -= 1;
		b.tie -= 1;
		DFS(cnt+1);
		a.tie += 1;
		b.tie += 1;

		// lose
		a.lose -= 1;
		b.win -= 1;
		DFS(cnt+1);
		a.lose += 1;
		b.win += 1;
	}

	static boolean check() {
		for(Team team : teams) {
			if(!(team.win == 0 && team.tie == 0 && team.lose == 0)) return false;
		}
		return true;
	}
}

class Team {
	int win, tie, lose;

	public Team(int win, int tie, int lose) {
		this.win = win;
		this.tie = tie;
		this.lose = lose;
	}
}
