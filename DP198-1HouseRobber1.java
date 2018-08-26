//
//198. House Robber
//
//        You are a professional robber planning to rob houses along a street.
//        Each house has a certain amount of money
//        stashed, the only constraint stopping you from robbing each of them is that
//        adjacent houses have security system
//        connected and it will automatically contact the police if two adjacent houses
//        were broken into on the same night.
//
//        Given a list of non-negative integers representing the amount of money of each
//        house, determine the maximum amount of money you can rob tonight without alerting the police.
//
//        Example 1:
//        Input: [1,2,3,1]
//        Output: 4
//        Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
//        Total amount you can rob = 1 + 3 = 4.
//
//        Example 2:
//        Input: [2,7,9,3,1]
//        Output: 12
//        Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
//        Total amount you can rob = 2 + 9 + 1 = 12.

My Solution:
public class Main {
    
    public static void main(String[] args) {
        int[] nums = {7,5,4,2,8,9};
        
        int currob = 0; //現在搶與不搶的結論
        int notrob = 0;
        int rob = 0;
        
        for( int i=0 ; i<nums.length ; i++){
            rob = notrob + nums[i]; //若要搶[i]間,[i-1]必不可搶(notrob為[i-1]不搶的最大值)則搶這間結果應為[i-1]不搶的最大值再加上這一間
            notrob = currob; //不搶[i]間的話,由上一輪最大值延續比較
            currob = Math.max(rob, notrob); //比較後為這輪結果
            System.out.println(rob+" "+notrob+" "+currob);
            
        }
        System.out.println( Math.max(rob,notrob)); //return currob;
    }
}
//執行結果:
//7   0   7
//5   7   7
//11  7   11
//9   11  11
//19  11  19
//20  19  20

//20

Solution 2:
public class Main {

    public static void main(String[] args) {
        int[] nums = {7,5,4,2,8,9};
        int rob = 0;
        int notrob = 0;
        int currob = 0;

        for (int i=0 ; i<nums.length ; i++) {
            currob = notrob + nums[i];  //要搶[i]間,[i-1]必不可搶(notrob為[i-1]不搶的最大值)則搶這間結果應為[i-1]不搶的最大值再加上這一間
            notrob = Math.max(rob, notrob);  //不搶[i]間的話,最大值由[i-1]迴搶與不搶的比較(右邊rob及notrob皆為[i-1]產生)

            rob = currob;  //搶[i]間,放入[i+1]輪迴繼續比較
            System.out.println(rob+" "+notrob+" "+currob);
        }
        System.out.println( Math.max(rob,notrob));
    }
}
//執行結果:
//7   0   7
//5   7   5
//11  7   11
//9   11  9
//19  11  19
//20  19  20

//20


