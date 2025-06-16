package arrays;

public class RearrangeBySign {
    public static void main(String[] args) {
        int[] nums = {3,1,2,8,-2,-5,-4,-3};
        int p_ind = 0, n_ind = 1;
        int[] arr = new int[nums.length];
        for(int i : nums)
        {
            if(i>0)
            {
                arr[p_ind] = i;
                p_ind += 2;
            }
            else
            {
                arr[n_ind] = i;
                n_ind += 2;
            }
        }
        for (int i : arr)
        {
            System.out.println(i);
        }
    }
}
