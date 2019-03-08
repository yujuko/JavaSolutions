/*

748. Shortest Completing Word

Find the minimum length word from a given dictionary words, which has all the letters from the string licensePlate. Such a word is said to complete the given string licensePlate

Here, for letters we ignore case. For example, "P" on the licensePlate still matches "p" on the word.

It is guaranteed an answer exists. If there are multiple answers, return the one that occurs first in the array.

The license plate might have the same letter occurring multiple times. For example, given a licensePlate of "PP", the word "pair" does not complete the licensePlate, but the word "supper" does.

Example 1:
Input: licensePlate = "1s3 PSt", words = ["step", "steps", "stripe", "stepple"]
Output: "steps"
Explanation: The smallest length word that contains the letters "S", "P", "S", and "T".
Note that the answer is not "step", because the letter "s" must occur in the word twice.
Also note that we ignored case for the purposes of comparing whether a letter exists in the word.
Example 2:
Input: licensePlate = "1s3 456", words = ["looks", "pest", "stew", "show"]
Output: "pest"
Explanation: There are 3 smallest length words that contains the letters "s".
We return the one that occurred first.
Note:
licensePlate will be a string with length in range [1, 7].
licensePlate will contain digits, spaces, or letters (uppercase or lowercase).
words will have a length in the range [10, 1000].
Every words[i] will consist of lowercase letters, and have length in range [1, 15].

*/

//solution 12ms
class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        String str ="" ;       
        int i =0 ;
        int j= 0;
        int index;
        int len = -1;
        String ret ="";
        String license = licensePlate.toLowerCase().replaceAll("[^a-z]","");
        
        for(j=0 ; j<words.length; j++){
            str = words[j].toLowerCase();
            i = 0;
            while(i<license.length()){
                if(i==license.length()-1 && str.indexOf(license.charAt(i))>=0)
                    if(words[j].length()<len || len==-1){
                        len = words[j].length();
                        ret = words[j];
                    }
                if(license.charAt(i)<=122 && license.charAt(i)>=97){
                  if(str.indexOf(license.charAt(i))<0){
                      break;
                  }
                  else 
                      index = str.indexOf(license.charAt(i));
                      StringBuilder strB = new StringBuilder(str);
                      strB.setCharAt(index,'0');
                      str = strB.toString();                                                          
                } 
                i++;
            }            
        }
        return ret;
        
    }
}
