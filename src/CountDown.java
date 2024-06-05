import java.util.Arrays;

public class CountDown {

    public static void main(String[] args) {
        int start = 10;
        int end_num = 3;

        System.out.println(Arrays.toString(solution(start, end_num)));
    }

    public static int[] solution(int start, int end_num) {
        int num_length = start - end_num + 1;
        int[] answer = new int[num_length];
        int idx = 0;
        while(end_num <= start){
            answer[idx] = start;
            start--;
            idx++;
        }

        return answer;
    }
}
