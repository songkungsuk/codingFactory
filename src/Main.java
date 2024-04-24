import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int[] bandage = {5, 1, 5};
        int health = 30;
        int[][] attacks = {{2, 10}, {9, 15}, {10, 5}, {11, 5}};

        System.out.println(solution(bandage, health, attacks));

    }

    public static int solution(int[] bandage, int health, int[][] attacks) {
        int maxHealth = health; // 최대 체력
        int useTime = 0; // 시전 시간
        int attackTime = 0;
        // 시전시간은 마지막에 몬스터가 공격할때까지 적용되나봄.
        for (int i = 0; i <= attacks[attacks.length - 1][0]; i++) {

            // 공격 당함
            if (attacks[attackTime][0] == i) {
                health = health - attacks[attackTime][1];
                useTime = 0;
                attackTime++;
                if (health <= 0) {
                    return -1;
                }
                // 공격당햇을땐 치료가 취소되나봄

            } else { // 공격 당하지 않았을 때
                // 초당 체력오르는중
                health = health + bandage[1];
                useTime++;
                // 원하는 시간이 흐르면 체력이 더 오름
                if (useTime == bandage[0]) {
                    health = health + bandage[2];
                    useTime = 0;
                }
                // 체력은 최대체력을 못넘음
                if (health > maxHealth) {
                    health = maxHealth;
                }

            }
        }
        // 모든 행동이 끝나면 남은 체력 리턴
        return health;
    }
}