import java.util.Arrays;

public class ClearWallpaper {

    public static void main(String[] args) {
        String[] wallpaper = {".....", "....#"};

        System.out.println(Arrays.toString(new ClearWallpaper().solution(wallpaper)));
    }


    public int[] solution(String[] wallpaper) {
        // 시작점
        int lux = -1;
        int luy = -1;
        // 끝점
        int rdx = 0;
        int rdy = 0;
        for (int i = 0; i < wallpaper.length; i++) {
            if (wallpaper[i].contains("#")) {
                if (lux == -1) {
                    lux = i;
                }
                rdx = i + 1;

                if (luy >= wallpaper[i].indexOf("#")) {
                    luy = wallpaper[i].indexOf("#");
                }
                if (luy == -1) {
                    luy = wallpaper[i].indexOf("#");
                }

                if (rdy <= wallpaper[i].lastIndexOf("#") + 1) {
                    rdy = wallpaper[i].lastIndexOf("#") + 1;
                }

            }
        }
        int[] result = {lux, luy, rdx, rdy};
        return result;
    }
}
