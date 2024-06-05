import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.Set;

public class Calender {

    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();
        set.add("a");
        set.add("a");
        set.add("b");

        System.out.println("set의 내용을 출력합니다.");
        for(String str : set){
            System.out.println(str);
        }

        set.forEach(System.out::println);

    }

    public static String solution(int a, int b) {
        String[] daysName = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        final int YEAR = 2016;
        LocalDate date1 = LocalDate.of(YEAR, 1, 1);
        LocalDate date2 = LocalDate.of(YEAR, a, b);
        long dateDiff = ChronoUnit.DAYS.between(date1, date2);
        String answer = daysName[(int) (dateDiff % 7)];
        return answer;
    }
}
