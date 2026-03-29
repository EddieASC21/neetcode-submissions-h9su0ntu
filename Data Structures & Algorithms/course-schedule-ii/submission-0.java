class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // what we will return
        int[] output = new int[numCourses];

        // we will build our adjacency list
        // we map the course to its prerequisites
        Map<Integer, List<Integer>> map = new HashMap<>();

        // we will initialize empty lists for each course's prerequisites
        for(int i = 0; i < numCourses; i++) map.put(i, new ArrayList<>());

        // we populate the list with its respective prerequisites
        for(int[] pre : prerequisites) map.get(pre[0]).add(pre[1]);

        // we note that a course has 3 possible states

        // visited means that the course has been added to our output array
        // visiting means that the course has not been added to our ouput array, but has been added to our path
        // unvisited means that the course has not been added to our output and has not been added to our path
        
        // we create two sets

        // a visisted set 
        Set<Integer> visited = new HashSet<>();

        // a set to keep track of the given path
        Set<Integer> inPath = new HashSet<>();

        // we use an array list to then convert to an array 
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < numCourses; i++){
            // if we have a cycle
            // we return an empty array
            if(!helper(map, visited, inPath, i, result)) return new int[0];
        }

        for (int i = 0; i < numCourses; i++) output[i] = result.get(i);
        
        return output;
    }

    // recursive helper function to carry out dfs
    private boolean helper(Map<Integer, List<Integer>> map, Set<Integer> visited, Set<Integer> inPath, int i, List<Integer> result){
        // base cases

        // if we have visited the node twice in our current path, we are in a cycle
        if(inPath.contains(i)) return false;

        // if a course has been visited and added to output, we will not visit it twice
        if(visited.contains(i)) return true;

        // we add the course to our path
        inPath.add(i);

        // recursive case
        
        // we will now go through every prerequisite of this course
        for(int pre : map.get(i)){
            // if the helper returns false, we have detected a cycle
            // if we detect a cycle we return false right away
            if(!helper(map, visited, inPath, pre, result)) return false;
        }

        // we remove the course from our path as we are done with this path
        inPath.remove(i);

        // we add the course to visit as we went through the course and its prerequisites with no cycle
        visited.add(i);

        // as the course has been visited we can add it to our output
        result.add(i);

        return true;
    }
}

/*
We are to return an array of integers

We are given the number of courses and the prerequisites as a 2D array

Description:

We have an array prerequisites where prerequisites[i] = [a, b]

this means we have to take course b first if we want to take course a

so for example if we had [0, 1] this would mean that we have to take course 1 before we take course 0

The total number of courses is given to us

They are labeled from 0 to numCourses - 1

We are to return an ordering in which we can take and finish all the courses

We can return any valid answer

if we can't take and finish all courses, we return an empty array

An approach:

We will be using Khan's algorithm, bfs style

We will build a graph using an adjacency list with the prerequisites

We will have a tracker to see how many prerequisites each course has

We begin with all courses with 0 prerequisites

We will use a queue to process each course and decrease their neighbors prerequisites count

if at the end if we have added all courses, we return it

Else if we have a cycle we return an empty array

Another Approach:

We will use topological sort

We will run dfs on every single node

we will build an adjacency list to know its neighbors

We only add to array when the course no longer has prerequisites

We catch a cycle if we take a path starting at a node and end up at a node

We use a set to remember our current path to help detect a cycle
*/