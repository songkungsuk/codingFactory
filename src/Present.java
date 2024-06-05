import java.util.HashMap;
import java.util.Map;

public class Present {

    public static void main(String[] args) {
        String[] friends = {"muzi", "ryan", "frodo", "neo"};
        String[] gifts = {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi",
            "frodo muzi", "frodo ryan", "neo muzi"};

        System.out.println(solution(friends, gifts));
    }

    // 규칙 1 : 선물을 많이 준 쪽이 선물을 받는다
    // 규칙 2 : 선물을 서로 주고 받지 않았다면 선물지수로 계산해서 받는다 [선물한 개수 - 선물 받은 개수]
    // 규칙 3 : 선물지수도 없고 주고받은게 없으면 서로 주고 받지 않는다
    public static int solution(String[] friends, String[] gifts) {

        Map<String, Integer> giftCount = new HashMap<>();
        Map<String, Integer> giftIndex = new HashMap<>();

        // 초기화
        for (String friend : friends) {
            giftCount.put(friend, 0);
            giftIndex.put(friend, 0);
        }

        // 선물 기록 처리
        for (String gift : gifts) {
            String[] giftInfo = gift.split(" ");
            String from = giftInfo[0];
            String to = giftInfo[1];

            giftCount.put(from, giftCount.get(from) + 1);
            giftCount.put(to, giftCount.get(to) - 1);
        }

        // 선물 지수 계산
        for (String friend : friends) {
            giftIndex.put(friend, giftCount.get(friend));
        }

        // 다음 달에 받을 선물 수 계산
        int maxGiftIndex = Integer.MIN_VALUE;
        int minGiftIndex = Integer.MAX_VALUE;
        for (int index : giftIndex.values()) {
            maxGiftIndex = Math.max(maxGiftIndex, index);
            minGiftIndex = Math.min(minGiftIndex, index);
        }

        int answer = 0;
        if (maxGiftIndex != minGiftIndex) {
            for (Map.Entry<String, Integer> entry : giftIndex.entrySet()) {
                if (entry.getValue() == minGiftIndex) {
                    answer++;
                }
            }
        }

        return answer;
    }
}

