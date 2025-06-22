package dynamicProgramming;

public class MinimumIncrementsToFormTargetArray {
    public static void main(String[] args) {
        int[] target = {3,1,5,4,2};
        int minCount = minNumberOperations(target);
        System.out.println(minCount);
    }

    private static int minNumberOperations(int[] target) {
        int count = target[0];
        for(int i = 1; i < target.length; i++){
            if(target[i] > target[i - 1]){
                count += target[i] - target[i - 1];
            }
        }
        return count;
    }
}
