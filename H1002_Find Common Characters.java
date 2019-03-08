/*
1002. Find Common Characters

Given an array A of strings made only from lowercase letters, return a list of all characters that show up in all strings within the list (including duplicates).  For example, if a character occurs 3 times in all strings but not 4 times, you need to include that character three times in the final answer.

You may return the answer in any order.

 

Example 1:

Input: ["bella","label","roller"]
Output: ["e","l","l"]
Example 2:

Input: ["cool","lock","cook"]
Output: ["c","o"]
 

Note:

1 <= A.length <= 100
1 <= A[i].length <= 100
A[i][j] is a lowercase letter
*/

//solutions using 2D array:

class Solution {
    public List<String> commonChars(String[] A) {
        List<String> charArr = new ArrayList<>();
        int[][] lowerCase = new int[26][A.length];
        for(int i = 0 ; i< A.length ; i++){
            for(int j =0; j<A[i].length();j++)
            lowerCase[A[i].charAt(j)-'a'][i] ++;            
        }
        for(int i =0; i < 26 ;i++){
            int min = lowerCase[i][0];
            for(int j = 0 ; j< A.length ; j++){
                if(lowerCase[i][j]<min)
                    min = lowerCase[i][j];
            }
            while(min!=0){
                charArr.add(Character.toString((char)(i+'a')));
                min--;
                    
            }
        }
        return charArr;
    }
}

//not working solution :
/*
 1.
 A[0].replaceAll("[^" + A[i] + "]", ""); 
 you need to assign this to a string. 
 like A[0] = A[0].replaceAll("[^" + A[i] + "]", ""); 
 With this the algo still is not complete, 
 but I think this is a good first point to move forward. 
 So the reason you see all characters of bella in the output 
 is because the first for loop is essentially doing nothing. – apadana 56 mins ago 

 2.
 Using replaceAll simply cannot give a correct answer for number 
 of duplicates of a particular letter. E.g. if input is [aaa, a], 
 you would return [a, a, a], which is wrong,
 since second string only has one a.
*/

class Solution {
public List<String> commonChars(String[] A) {
  List<String> charArr = new ArrayList<>();
 
  for(int i = 1; i<A.length ; i++){
      A[0].replaceAll("[^" + A[i] + "]", "");
  }
  for(int i=0; i<A[0].length(); i++){
      charArr.add(Character.toString(A[0].charAt(i)));
  }
  return charArr;
 
}

