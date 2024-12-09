public class DrawWall {
	public static void main(String[] args) {
		int[] section = {1, 3};
		System.out.println(solution(5, 4, section));
	}


	public static int solution(int n, int m, int[] section) {
		// n 벽길이
		// m 롤러 길이
		// section 칠해야되는 곳
		int lastRollLength = section[0] + m - 1;
		int answer = 1;
		for (int area : section){
			if(lastRollLength < area){
				answer++;
				lastRollLength = area + m - 1;
			}
		}

		return answer;
	}
}
