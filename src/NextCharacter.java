import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NextCharacter {

    public static void main(String[] args) {
        String s = "banana";

        NextCharacter nextCharacter = new NextCharacter();
        System.out.println(Arrays.toString(nextCharacter.solution(s)));
    }

    public int[] solution(String s) {
        List<Integer> StringIdx = new ArrayList<>();
        Map<String, Integer> StringBatch = new HashMap<>();
        final int NOT_FOUND = -1;
        for (int index = 0; index < s.length(); index++) {
            String tmpString = s.substring(index, index + 1);
            if (StringBatch.get(tmpString) == null) {
                StringBatch.put(tmpString, index);
                StringIdx.add(NOT_FOUND);
            } else {
                int beforeIdx = StringBatch.get(tmpString);
                StringIdx.add(index-beforeIdx);
                StringBatch.put(tmpString, index);
            }
        }

        return toIntArray(StringIdx);
    }

    private static int[] toIntArray(List<Integer> list) {
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
