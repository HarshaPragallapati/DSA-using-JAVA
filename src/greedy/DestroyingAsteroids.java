package greedy;

public class DestroyingAsteroids {
    public static void main(String[] args) {
        int mass = 10;
        int[] asteroids = {3,9,19,5,21};
        System.out.println(asteroidsDestroyed(mass, asteroids));
    }

    private static boolean asteroidsDestroyed(int mass, int[] asteroids) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int asteroid : asteroids){
            min = Math.min(min, asteroid);
            max = Math.max(max, asteroid);
        }
        int[] count = new int[max + 1];
        long temp = mass;
        for (int asteroid : asteroids) {
            if (asteroid > mass) {
                count[asteroid]++;
            } else {
                temp += asteroid;
            }
        }
        for (int i = min; i <= max; i++) {
            if (count[i] > 0){
                if (i > temp){
                    return false;
                }
                temp += count[i] * i;
            }
        }
        return true;
    }
}
