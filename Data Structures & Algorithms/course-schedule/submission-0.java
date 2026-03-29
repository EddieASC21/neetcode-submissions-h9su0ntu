class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // we create our map
        // map will map courses to list of prerequisites
        Map<Integer, List<Integer>> map = new HashMap<>();

        // create a visited set
        // will store all the courses along the dfs path
        Set<Integer> set = new HashSet<>();

        // for each course, we map to an empty list of prerequisites
        for(int i = 0; i < numCourses; i++) map.put(i, new ArrayList<>());

        // we iterate over prerequisites to help populate the empty lists with the actual prerequisites
        for(int[] pre : prerequisites) map.get(pre[0]).add(pre[1]);
        
        for(int i = 0; i < numCourses; i++){
            if(!helper(map, set, i)) return false;
        }

        return true;
    }

    // recursive helper function to carry out dfs
    private boolean helper(Map<Integer, List<Integer>> map, Set<Integer> set, int i){
        // base case

        // we check if we have visited the course, this helps detect loops 
        if(set.contains(i)) return false;

        // we check if the list of prerequisites for this key is empty
        // we would return as this path can be completed
        if(map.get(i).isEmpty()) return true;

        // add the current course in the path as visited
        set.add(i);

        // we will loop through the prerequisites of this course, the elements in its list
        for(int pre : map.get(i)){
            if(!helper(map, set, pre)) return false;
        }

        // we remove from our remove set as this path is complete
        set.remove(i);

        // we know this course can be visited so we set the key to be an empty list again
        // this helps if we have to run dfs on this course again, we avoid repeated work
        map.get(i).clear();

        return true;
    }
}

/*
We are to return true or false

we are given an integer and a 2D array 

Description:

We are given an array where the array[i] = [a, b]

We then note that [a, b] means we have to take course b first to take course a

So if was [0, 1] this would mean that we must take course 1 before course 0

The integer we are given is the numbers of courses we need to take

We label this as 0 to numCourses - 1

We return true if we can finish all course else return false

An approach:

We look at this way:

Each course is a node

The prerequisite pair [a, b] means there is a directed edge from b -> a

We must find if it is possible to complete all courses 

If a graph has a cycle, we can't complete all courses

We will use Khan's algorithm

We will build a graph

The graph will be an adjacency list

We will track the number of prerequisites each node/course has

We will queue all courses with no prerequisites

We then go through the queue

for each course in queue, we reduce its prerequisites of its neighbor

if its neighbor node has 0 prerequisites then we add to queue

if we have processed nodes in the queue equal to numCourses, we return true else false

Another Approach:

We will use an adjacency list

We will create a map

where the key is the course

the value of the key is a list of all prerequisites

for a course with no prerequisites, the key is an empty list

we will run dfs on every node in the order of 0 to numCourses - 1

We can remove the keys from the map once we know they can be completed

we will use a set to keep track of visited courses
*/