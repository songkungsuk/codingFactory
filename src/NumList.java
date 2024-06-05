public class NumList {

    public static void main(String[] args) {
        int[] num_list = {12, 4, 15, 46, 38, -2, 15};
        int idx = 0;

        for(int num : num_list){
            if(num < 0){
                 break;
            }
            idx++;
        }
        System.out.println(idx);

    }
}
