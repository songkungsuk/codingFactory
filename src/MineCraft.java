import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MineCraft {

    // 광물 배열을 5개씩 자름
    // 자른 광물 배열을 제일 안좋은 곡괭이부터 피로도가 적은순서대로 뿌셔나감
    // 그렇게 결산한 피로도를 제출하면됨.
    public int solution(int[] picks, String[] minerals) {
        // 1. 광물 배열을 5개씩 자르기
        List<List<String>> split = new ArrayList<>();
        for (int i = 0; i < minerals.length; i += 5) {
            List<String> subList = Arrays.asList(
                Arrays.copyOfRange(minerals, i, Math.min(i + 5, minerals.length)));
            split.add(subList);
        }

        int totalFatigue = 0;
        while (!split.isEmpty() && (picks[0] != 0 || picks[1] != 0 || picks[2] != 0)) {
            for (List<String> subList : split) {
                int subListFatigue = 0;
                for (String mineral : subList) {
                    if (picks[0] != 0) {
                        subListFatigue += calculateFatigue(0, mineral);
                        picks[0]--;
                    } else if (picks[1] != 0) {
                        subListFatigue += calculateFatigue(1, mineral);
                        picks[1]--;
                    } else {
                        subListFatigue += calculateFatigue(2, mineral);
                        picks[2]--;
                    }
                }
                totalFatigue += subListFatigue;
            }
            split.removeIf(List::isEmpty);
        }

        return totalFatigue;
    }

    private int calculateFatigue(int pickIndex, String mineral) {
        switch (pickIndex) {
            case 0: // picks[0]
                return 1;
            case 1: // picks[1]
                return mineral.equals("diamond") ? 5 : 1;
            case 2: // picks[2]
                switch (mineral) {
                    case "diamond":
                        return 25;
                    case "iron":
                        return 5;
                    default:
                        return 1;
                }
            default:
                return 0;
        }
    }
}
