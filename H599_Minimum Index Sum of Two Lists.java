/*
599. Minimum Index Sum of Two Lists

Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants represented by strings.

You need to help them find out their common interest with the least list index sum. If there is a choice tie between answers, output all of them with no order requirement. You could assume there always exists an answer.

Example 1:
Input:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
Output: ["Shogun"]
Explanation: The only restaurant they both like is "Shogun".
Example 2:
Input:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["KFC", "Shogun", "Burger King"]
Output: ["Shogun"]
Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1).
Note:
The length of both lists will be in the range of [1, 1000].
The length of strings in both lists will be in the range of [1, 30].
The index is starting from 0 to the list length minus 1.
No duplicates in both lists.
*/

//2nd attempt:  save the index with the string as a map
//11ms beats 99.7%

class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> ret = new ArrayList<String>();
        HashMap<String,Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE; //NOT 1000
        
        for(int i =0; i<list1.length ;i++){
            map.put(list1[i],i);
        }
        
        for(int i =0; i<list2.length ;i++){
            if(map.containsKey(list2[i])){
                int index = i+ map.get(list2[i]);
                if(min > index){
                    ret.clear();
                    min = index;
                    ret.add(list2[i]);
                }
                else if(min == index){
                    ret.add(list2[i]);
                }
            }
        }
        return ret.toArray(new String[ret.size()]);
    }
}
// 1st attempt : 20ms beats 41.62%
class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> ret = new ArrayList<String>();
        HashSet<String> set = new HashSet<>();
        int min = Integer.MAX_VALUE; 
        
        for(String s : list1){
            set.add(s);
        }
        
        for(String s : list2){
            if(!set.add(s)){
                int index = Arrays.asList(list1).indexOf(s)+Arrays.asList(list2).indexOf(s);
                if(min > index){
                    ret.clear();
                    min = index;
                    ret.add(s);
                }
                else if(min == index){
                    ret.add(s);
                }
            }
        }
        return ret.toArray(new String[0]);
    }
}