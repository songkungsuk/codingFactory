import java.util.ArrayList;
import java.util.List;

public class Poketmon {

    public static void main(String[] args) {
        int[] nums = {3,3,3,2,2,4};

        System.out.println(solution(nums));
    }


    public static int solution(int[] nums) {
        int answer = 0; // 종류
        int count = 0; // 넣은개수
        List<Integer> type = new ArrayList<>();

        for (int num : nums) {
            if (!type.contains(num)) {
                type.add(num);
                count++;
            }
            if (count == nums.length / 2) {
                break;
            }
        }
        answer = type.size();

        return answer;
    }
}
