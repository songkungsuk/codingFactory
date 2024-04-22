import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DataAnalysis {

    public static void main(String[] args) {
        DataAnalysis analysis = new DataAnalysis();
        int[][] data = {{3, 20300401, 10, 8}, {1, 20300104, 100, 80}};
        System.out.println(Arrays.deepToString(analysis.solution(data, "code", 4, "code")));

    }
    /*
     * 1. 데이터를 정제 ext_idx 기준으로
     * 2. 정제한 데이터를 정렬
     * 3. Idx 번호는 일치하지않으면 인덱스를 증가시키는 형태로 제작하기 메소드 구현
     * */

    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        // 데이터를 리스트로 변환
        List<List<Integer>> schema = DataAnalysis.convert(data);
        // 정제한리스트
        List<List<Integer>> newData = new ArrayList<>();
        // 위치변환용 리스트
        List<Integer> tmpList;

        // 컬럼 위치
        int ext_Idx = getIdx(ext); // 작아야되는 기준
        int sort_Idx = getIdx(sort_by); // 오름차순으로 정렬되야 되는 기준

        // 원하는대로 리스트를 뽑아냄
        for (List<Integer> tmpValue : schema) {
            if (tmpValue.get(ext_Idx) < val_ext) {
                newData.add(tmpValue);
            }
        }

        // 정렬
        for (int i = 0; i < newData.size(); i++) {
            for (int j = 0; j < newData.size()-1; j++) {
                if (newData.get(j).get(sort_Idx) > newData.get(j+1).get(sort_Idx)) {
                    tmpList = newData.get(j);
                    newData.set(j, newData.get(j + 1));
                    newData.set(j + 1, tmpList);
                }
            }
        }
        // 정제한 데이터
        int[][] sortData = DataAnalysis.convertToArray(newData);

        return sortData;
    }

    public int getIdx(String columName) {
        // 컬럼 이름 목록
        String[] extText = {"code", "date", "maximum", "remain"};

        for (int i = 0; i < extText.length; i++) {
            if (extText[i].equals(columName)) {
                return i;
            }
        }
        return 0;
    }

    public static int[][] convertToArray(List<List<Integer>> list) {
        int[][] result = new int[list.size()][];

        for (int i = 0; i < list.size(); i++) {
            List<Integer> row = list.get(i);
            result[i] = new int[row.size()];

            for (int j = 0; j < row.size(); j++) {
                result[i][j] = row.get(j);
            }
        }

        return result;
    }

    public static List<List<Integer>> convert(int[][] data) {
        List<List<Integer>> result = new ArrayList<>();

        for (int[] row : data) {
            List<Integer> rowList = new ArrayList<>();
            for (int value : row) {
                rowList.add(value);
            }
            result.add(rowList);
        }

        return result;
    }
}
