import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class PrivacyInformation {
	public static void main(String[] args) {
		Answer answer = new Answer();
		System.out.println(Arrays.toString(answer.solution("2022.05.19", new String[]{"A 6", "B 12", "C 3"}, new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"})));
	}

	public static class Answer {
		public int[] solution(String today, String[] terms, String[] privacies) {
			List<Integer> answer = new ArrayList<>();

			String[] nowDate = today.split("\\.");
			LocalDate compareDate = LocalDate.of(Integer.parseInt(nowDate[0]),Integer.parseInt(nowDate[1]),Integer.parseInt(nowDate[2]));

			Map<String, Integer> contractMap = new HashMap<>();
			for (String term : terms) {
				String[] contract = term.split(" ");
				contractMap.put(contract[0], Integer.parseInt(contract[1]));
			}
			int index = 1;
			for (String object : privacies) {
				String[] detail = object.split(" ");
				String[] date = detail[0].split("\\.");
				String contractType = detail[1];
				LocalDate privacyDate = LocalDate.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]));
				LocalDate afterDate = privacyDate.plusMonths(contractMap.get(contractType));

				long differentDays = ChronoUnit.DAYS.between(afterDate, compareDate);
				if(differentDays >= 0){
					answer.add(index);
				}

				index++;
			}

			int[] array = new int[answer.size()];
			for (int i = 0; i < answer.size(); i++) {
				array[i] = answer.get(i);
			}

			return  array;
		}
	}
}


