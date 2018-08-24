

// 283 Move Zeros

//    Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of
//    the non-zero elements.
//
//        Example:
//        Input: [0,1,0,3,12]
//        Output: [1,3,12,0,0]
//
//        Note:
//        You must do this in-place without making a copy of the array.
//        Minimize the total number of operations.
//

//bubble sort:
public class MoveZeros {

        public void moveZeroes(int[] nums) {

            int i, j ;
            for( i = 0; i< nums.length-1 ; i++ ){

                for( j = 0; j < nums.length-1 ; j++){

                    if( nums[j] == 0 ){
                        int temp = nums[j+1];
                        nums[j+1] = nums[j];
                        nums[j] = temp;
                    }
                }
            }
        }
    }

NOTE:
 for (int i=0 ; i<nums.length-1 ; i++) -->記得length要-1 
