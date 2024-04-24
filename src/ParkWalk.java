import java.util.Arrays;

public class ParkWalk {

    public static void main(String[] args) {
        String[] park = {"SOO", "OXX", "OOO"};
        String[] routes = {"E 2", "S 2", "W 1"};

        System.out.println(Arrays.toString(new ParkWalk().solution(park, routes)));
        //System.out.println(park.length);
        //System.out.println(park[0].length());
    }

    public int[] solution(String[] park, String[] routes) {
        // 자신의 위치를 먼저 확인
        // 주어진 방향으로 이동할 때 공원을 벗어나는지 확인합니다.
        // 주어진 방향으로 이동 중 장애물을 만나는지 확인합니다.
        // y, x 느낌으로 이해하는게 편함.
        // 공원의 가로길이 세로길이를 아는게 중요.
        // 공원을 둘러보며 로봇강아지 위치를 탐색
        int[] dogLocation = serachRobotDog(park);
        for (String route : routes) {
            dogLocation = serachRobotDog(dogLocation, route, park);
        }
        return dogLocation;
    }

    public static int[] serachRobotDog(String[] park) {
        int[] dogLocation;
        int y = 0;
        int x = 0;
        for (String s : park) {
            if (s.contains("S")) {
                x = s.indexOf("S");
                break;
            }
            y++;
        }

        dogLocation = new int[]{y, x};

        return dogLocation;
    }

    public static int[] serachRobotDog(int[] start, String route, String[] park) {
        int park_y = park.length - 1; //  = y
        int park_x = park[0].length() - 1; //  = x
        int y = start[0];
        int x = start[1];
        boolean goForward = true;
        String command = route.substring(0, 1);
        int distance = Integer.parseInt(route.substring(2, 3));
        // 코드가 더러워도 이해좀
        switch (command) {
            case "E":
                // 주어진 방향으로 이동할 때 공원을 벗어나는지 확인합니다.
                if (park_x >= x + distance) {
                    //  주어진 방향으로 이동 중 장애물을 만나는지 확인합니다.
                    for (int i = x; i <= x + distance; i++) {
                        if (park[y].substring(i, i + 1).equals("X")) {
                            goForward = false;
                            break;
                        }
                    }
                    if (goForward) {
                        x += distance;
                    }
                }
                break;
            case "S":
                // 주어진 방향으로 이동할 때 공원을 벗어나는지 확인합니다.
                if (park_y >= y + distance) {
                    //  주어진 방향으로 이동 중 장애물을 만나는지 확인합니다.
                    for (int i = y; i <= y + distance; i++) {
                        if (park[i].substring(x, x + 1).equals("X")) {
                            goForward = false;
                            break;
                        }
                    }
                    if (goForward) {
                        y += distance;
                    }
                }
                break;
            case "W":
                // 주어진 방향으로 이동할 때 공원을 벗어나는지 확인합니다.
                if (0 <= x - distance) {
                    //  주어진 방향으로 이동 중 장애물을 만나는지 확인합니다.
                    for (int i = x; i >= x - distance; i--) {
                        if (park[y].substring(i, i + 1).equals("X")) {
                            goForward = false;
                            break;
                        }
                    }
                    if (goForward) {
                        x -= distance;
                    }
                }
                break;
            case "N":
                // 주어진 방향으로 이동할 때 공원을 벗어나는지 확인합니다.
                if (0 <= y - distance) {
                    //  주어진 방향으로 이동 중 장애물을 만나는지 확인합니다.
                    for (int i = y; i >= y - distance; i--) {
                        if (park[i].substring(x, x + 1).equals("X")) {
                            goForward = false;
                            break;
                        }
                    }
                    if (goForward) {
                        y -= distance;
                    }
                }
                break;
        }
        int[] result = {y, x};
        return result;
    }
}
