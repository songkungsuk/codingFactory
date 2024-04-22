import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhotoPoint {

    public static void main(String[] args) {
        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photo = {{"may", "kein", "kain", "radi"}, {"may", "kein", "brin", "deny"},
            {"kon", "kain", "may", "coni"}};
        PhotoPoint p = new PhotoPoint();
        System.out.println(Arrays.toString(p.solution(name, yearning, photo)));
    }

    public int[] solution(String[] name, int[] yearning, String[][] photo) {

        Map<String, Integer> map = new HashMap<>();
        List<Integer> pointList = new ArrayList<>();
        for (int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }

        for(String[] photoNames : photo){
            int result = 0;
            for(String photoName : photoNames){
                if(map.get(photoName) != null){
                    result += map.get(photoName);
                }
            }
            pointList.add(result);
        }
        int[] resultPoints = toIntArray(pointList);
        return resultPoints;
    }

    private static int[] toIntArray(List<Integer> list) {
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
