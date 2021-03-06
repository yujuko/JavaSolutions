/*

338. Counting Bits

Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

Example 1:

Input: 2
Output: [0,1,1]
Example 2:

Input: 5
Output: [0,1,1,2,1,2]
Follow up:

It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
Space complexity should be O(n).
Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
*/

//solution: 1ms beats 99%

class Solution {
    public int[] countBits(int num) {
    int[] ret = new int[num+1];
    ret[0] = 0;
    int pow = 1;
    for(int i = 1, t = 0; i <= num; i++, t++) {
        if(i == pow) {
            pow *= 2;
            t = 0;
        }
        ret[i] = ret[t] + 1;
    }
    return ret;
}
}

//attempts
public int[] countBits(int num) {
    int[] ret = new int[num+1];

    double index =0;
    double digit=0;
        while(num > Math.pow(2.00,digit)){
            digit++;
        }
    index = digit;
    while(index !=0){
        int count=Math.pow(2.00,index-1.00) ;
        while(count!=0){
            while(num>=0 ){
                    if(num % Math.pow(2.00,index) == Math.pow(2.00,index)-count){
                        ret[num]++;                       
                    }                    
            num--;
            }
        count ++;
        }
    index --;
    }
        
    }
}