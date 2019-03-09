/*
690. Employee Importance

You are given a data structure of employee information, which includes the employee's unique id, his importance value and his direct subordinates' id.

For example, employee 1 is the leader of employee 2, and employee 2 is the leader of employee 3. They have importance value 15, 10 and 5, respectively. Then employee 1 has a data structure like [1, 15, [2]], and employee 2 has [2, 10, [3]], and employee 3 has [3, 5, []]. Note that although employee 3 is also a subordinate of employee 1, the relationship is not direct.

Now given the employee information of a company, and an employee id, you need to return the total importance value of this employee and all his subordinates.

Example 1:

Input: [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
Output: 11
Explanation:
Employee 1 has importance value 5, and he has two direct subordinates: employee 2 and employee 3. They both have importance value 3. So the total importance value of employee 1 is 5 + 3 + 3 = 11.
 

Note:

One employee has at most one direct leader and may have several subordinates.
The maximum number of employees won't exceed 2000.

*/




// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
//great solution using HashMap -bfs: from xuyirui

class Solution {    
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> hash = new HashMap<>();
        int value =0; 
        for(Employee e: employees){
            hash.put(e.id, e);
        }
        
        Queue<Employee> queue = new LinkedList<>();
        queue.offer(hash.get(id));
        while(!queue.isEmpty()){
            Employee curr = queue.poll();
            value+= curr.importance;
            for(Integer i: curr.subordinates){
                queue.offer(hash.get(i));
            }
        }
        return value;
        
    }
}
//great solution using HashMap - dfs: from xuyirui
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        return getImportanceHelper(map, id);
    }
    
    private int getImportanceHelper(Map<Integer, Employee> map, int rootId) {
        Employee root = map.get(rootId);
        int total = root.importance;
        for (int subordinate : root.subordinates) {
            total += getImportanceHelper(map, subordinate);
        }
        return total;
    }
}

//slow solution using recursion : 20ms

class Solution {
    int value = 0;
        public int getImportance(List<Employee> employees, int id) {
            for(Employee e :employees){
                    if(e.id == id){
                        getTotal(employees,e);
                    }
                }
            return value;
        }
        public int getTotal(List<Employee> employees,Employee e){
            value+=e.importance;
            if(e.subordinates.size()==0)
                return value;            
            for(Integer i : e.subordinates){
                for(Employee em : employees){
                    if(em.id == i){
                        getTotal(employees,em);
                    }
                }
            }
            return value;
        }
    
}
