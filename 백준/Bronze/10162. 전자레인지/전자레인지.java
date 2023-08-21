import java.io.*; // 입출력에 필요한 라이브러리 임포트
import java.util.*; // 유틸 라이브러리 임포트

public class Main { // 클래스 시작
	static int T; // 입력을 담을 변수
	static int[] buttons = { 300,60,10 }; // 각 버튼에 지정된 시간(초단위) 배열로 생성

	public static void main(String[] args) throws Exception { // 메인메서드 시작( 입출력 예외처리 던지기 )
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 위한 객체 생성
		
		// 입력
		T = Integer.parseInt(br.readLine()); // 입력받기
		
		// 풀이 & 출력
		if(isPossible()) { // 3개의 버튼으로 T초를 맞출 수 있는 경우 정답 출력
			int[] cnts = getMinCnt(); // 풀이 메서드를 통해 정답 얻기
			for(int i=0; i<3; i++) System.out.print(cnts[i]+" "); // 배열안의 원소를 차례대로 출력
		}
		else System.out.println(-1); // 맞출 수 없는 경우 -1 출력
		
	} // 메인 메서드 끝
	
	// 아이디어 : 그리디하게 접근 가능 -> 버튼에 지정된 시간들이 더 작은 지정시간들로 만들 수 있는 수이기 때문에(300은 60, 10의 배수 & 60은 10의 배수), 다른 점은 시간의 크기일 뿐.
	//         따라서 가장 큰 지정시간부터 살펴보며, 해당 시간으로 T가 나눠지면 나누기한 값을 누적하여 다음 연산에 사용하고 안 나눠지면 다음 지정시간으로 넘어가고를 반복해서 T가 0이 될 때까지.
	//         3개의 버튼으로 정확히 맞출 수 없는 경우는 T를 10으로 나눌 수 없는 경우.
	static boolean isPossible() { // 풀이를 위한 메서드 시작(3개의 버튼으로 정확히 맞출 수 있는지 여부 확인)
		if(T % 10 == 0) return true; // T를 10으로 나눌 수 있는 경우 true 반환.
		else return false; // 3개의 버튼으로 정확히 맞출 수 없는 경우는 T를 10으로 나눌 수 없는 경우 false 반환
	} // 풀이를 위한 메서드 끝
	
	static int[] getMinCnt() { // 풀이를 위한 메서드 시작(3개의 버튼을 그리디하게 활용하여 최소 버튼 횟수 얻기)
		int[] cnts = new int[3]; // 결과를 담기 위한 배열
		while(T >= buttons[0]) { // T가 300초보다 클때까지 반복
			cnts[0] += T/buttons[0]; // 해당 버튼의 누른횟수를 증가시키며
			T %= buttons[0]; // 해당 버튼을 눌렀을 때 만큼의 시간을 줄인다
		}
		while(T >= buttons[1]) { // T가 60초보다 클때까지 반복
			cnts[1] += T/buttons[1]; // 해당 버튼의 누른횟수를 증가시키며
			T %= buttons[1]; // 해당 버튼을 눌렀을 때 만큼의 시간을 줄인다
		}
		while(T >= buttons[2]) { // T가 10초보다 클때까지 반복
			cnts[2] += T/buttons[2]; // 해당 버튼의 누른횟수를 증가시키며
			T %= buttons[2]; // 해당 버튼을 눌렀을 때 만큼의 시간을 줄인다
		}
		return cnts; // 도출된 결과 반환
	} // 풀이를 위한 메서드 끝
	
} // 클래스 끝
