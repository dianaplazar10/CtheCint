package practice;

/*ROBLOX INTERVIEW PROBLEM - KARAT interface
 * 
 * 
Suppose we have some input data describing a graph of relationships between parents and children over multiple generations. The data is formatted as a list of (parent, child) pairs, where each individual is assigned a unique integer identifier.

For example, in this diagram, 3 is a child of 1 and 2, and 5 is a child of 4:

1   2    4
 \ /   / | \
  3   5  8  9
   \ / \     \
    6   7    11


Sample input/output (pseudodata):

parentChildPairs = [
    (1, 3), (2, 3), (3, 6), (5, 6),
    (5, 7), (4, 5), (4, 8), (4, 9), (9, 11)
]


Write a function that takes this data as input and returns two collections: one containing all individuals with zero known parents, and one containing all individuals with exactly one known parent.


Output may be in any order:

findNodesWithZeroAndOneParents(parentChildPairs) => [
  [1, 2, 4],       // Individuals with zero parents
  [5, 7, 8, 9, 11] // Individuals with exactly one parent
]

n: number of pairs in the input

*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class RobloxIview {
  public static void main(String[] argv) {
    int[][] parentChildPairs = new int[][] {
        {1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7},
        {4, 5}, {4, 8}, {4, 9}, {9, 11}
    };
    List<List<Integer>> parentChildPairsList =  findNodesWithZeroAndOneParents(parentChildPairs);
    
    System.out.println(parentChildPairsList);
  }
  
  public static List<List<Integer>> findNodesWithZeroAndOneParents(int[][] parentChildPairs) {
    List<List<Integer>> parentChildPairsList = new ArrayList<List<Integer>>();
    
    List<Integer> listZeroParent =  new ArrayList<Integer>();
    List<Integer> listOneParent =  new ArrayList<Integer>();

    Map<Integer, Integer> map = new ConcurrentHashMap<Integer, Integer>();
    Set<Integer> nodes = new HashSet<Integer>();
    for(int i = 0; i<parentChildPairs.length ; i ++) {
    	nodes.add(parentChildPairs[i][0]);
    	nodes.add(parentChildPairs[i][1]);
    }
    
    for(int i = 0; i<parentChildPairs.length ; i ++) {
      
      int child = parentChildPairs[i][1];
      int parent = parentChildPairs[i][0];
      if(nodes.contains(child)) {
        nodes.remove(child);
      }
      int  mapVal = map.get(child)==null ? 1 : map.get(child) +1;
      map.put(child,mapVal);
    }
    
    for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
     if(entry.getValue() == 1) {
        listOneParent.add(entry.getKey());
      }
    }
    
    for(Integer val : nodes) {
    	listZeroParent.add(val);
  	}
    
    parentChildPairsList.add(listZeroParent);
    parentChildPairsList.add(listOneParent);    
    return parentChildPairsList;
  }
}