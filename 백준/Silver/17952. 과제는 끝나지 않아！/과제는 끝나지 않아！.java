import java.io.*; // 입출력에 필요한 라이브러리 임포트
import java.util.*; // 유틸 라이브러리 임포트

public class Main { // 클래스 시작
	static int N; // 몇 분기인지를 나타내는 정수를 담을 변수

	public static void main(String[] args) throws Exception { // 메인메서드 시작( 입출력 예외처리 던지기 )
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 위한 객체 생성
		
		N = Integer.parseInt(br.readLine()); // 몇분기인지 입력받아서 담기
		Stack<int[]> prevWork = new Stack<>(); // 이전에 하던 덜 마친 업무를 저장해두기 위한 스택
		int totalScore = 0; // 마친 업무의 점수를 저장할 변수
		
		for(int sec=0; sec<N; sec++) { // 분기수만큼 반복 시작
			StringTokenizer st = new StringTokenizer(br.readLine()); // 공백을 기준으로 입력받은 문자열 구분해서 저장하기 위한 객체
			int type = Integer.parseInt(st.nextToken()); // 업무 유무 입력받기
			if(type == 1) { // 새로운 업무가 주어지는 경우
				int score = Integer.parseInt(st.nextToken()); // 해당 업무의 점수
				int remainSec = Integer.parseInt(st.nextToken()); // 해당 업무의 남은 시간
				remainSec -= 1; // 업무 수행
				if(remainSec == 0) {
					totalScore += score; // 업무를 마쳤으면 그 점수 획득
				} else {
					prevWork.push(new int[] {score, remainSec}); // 업무 다 못마쳤으면 스택에 저장
				}
			} else { // 새로운 업무가 없는 경우
				if(prevWork.isEmpty()) continue;
				int[] prev = prevWork.pop(); // 이전에 하던 업무 불러오기
				int score = prev[0]; // 이전에 하던 업무의 점수
				int remainSec = prev[1]; // 이전에 하던 업무의 남은 시간
				remainSec -= 1; // 업무 수행
				if(remainSec == 0) {
					totalScore += score; // 업무를 마쳤으면 그 점수 획득
				} else {
					prevWork.push(new int[] {score, remainSec}); // 업무 다 못마쳤으면 스택에 저장
				}
			}
		} // 분기수만큼 반복 끝
		
		System.out.println(totalScore); // 최종적으로 얻어낸 정답 출력
	} // 메인 메서드 끝

} // 클래스 끝
