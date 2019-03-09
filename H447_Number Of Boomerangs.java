/*
447. Number of Boomerangs

Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k) such that the distance between i and j equals the distance between i and k (the order of the tuple matters).

Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are all in the range [-10000, 10000] (inclusive).

Example:
Input:
[[0,0],[1,0],[2,0]]

Output:
2

Explanation:
The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
*/

//solution: 101ms beats 64.07%

class Solution {
	public int numberOfBoomerangs(int[][] points) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int line1 = 0;
        int line2 = 0;
        int len = 0;
        int total =0;
        int index=0;

    
        while(index < points.length){
            
            for(int j= 0 ;j< points.length ; j++){
            	//DO NOT PUT THIS IN THE CONDITION OF THE FOR LOOP, 
            	//IT WILL STOP THE FOLLOWING LOOPS
                if(index==j)
                    continue; 
                line1 = Math.abs(points[index][0]-points[j][0]);
                line2 = Math.abs(points[index][1]-points[j][1]);
                
                len = (line1*line1)+ (line2*line2);
                // System.out.println("len="+ len);
                
                if(map.containsKey(len)){
                    map.put(len, map.get(len)+1);
                }
                else
                    map.put(len,1);
            }
            
            Set<Integer> set = map.keySet();
            Iterator<Integer> itr = set.iterator();
            while(itr.hasNext()){
                Integer d = itr.next();
                // System.out.print(d+": "+map.get(d));
                 // System.out.println();
                if(map.get(d)>=2){
                    total += choose(map.get(d),2)*2;
                }
            }       
            map.clear();
            index++;
        }
        
        return total;
    }
    
    public static double choose(int x, int y) {
    if (y < 0 || y > x) return 0;
    if (y > x/2) {
        // choose(n,k) == choose(n,n-k), 
        // so this could save a little effort
        y = x - y;
    }

    double denominator = 1.0, numerator = 1.0;
    for (int i = 1; i <= y; i++) {
        denominator *= i;
        numerator *= (x + 1 - i);
    }
    return numerator / denominator;
    }
}

//faster, similiar solution class Solution 86ms beats 85.33%

public int numberOfBoomerangs(int[][] points) {
    HashMap<Integer,Integer> map = new HashMap<>();
    int ret = 0;
    for(int i=0 ; i< points.length ;i++){
        for(int j = 0 ;  j<points.length ;j++){
            if(i==j)
                continue;
            int a = points[i][0] - points[j][0];
            int b = points[i][1] - points[j][1];
            int d = a*a + b*b;
            map.put(d,map.getOrDefault(d,0)+1);                 
        }
        for(Integer v : map.values()){
            ret += v*(v-1);
        }
        map.clear();
    }
    return ret;
    
}
}