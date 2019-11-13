package practice;
import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 
cbdke  
cbdj
a
ab
b

c a b d k j e

cbb
cbc
aa
ak
aj

b

ArrayList<Char> BuildAlphabet(ArrayList<String>)
 */

class SolutionOld {
  public static void main(String[] args) {
    ArrayList<String> strings = new ArrayList<String>();
    strings.add("Hello, World!");
    strings.add("Welcome to CoderPad.");
    strings.add("This pad is running Java " + Runtime.version().feature());

    for (String string : strings) {
      System.out.println(string);
    }
  }
}


/* 
Your previous Plain Text content is preserved below:

Possible Solution algorithm
// Parse through the first letter of the strings

Assumption:
Letters a-z
Considering only lower cases
Ascii- small to small z =97 - 122

//StringBuilder strbuilder = "";
Graph graph=new Graph();
private String parseStrings(List<String> strings){
  for(int i=0; i<strings.length-2 ; i++){
    char[] chars1 = strings[i].toCharArray();
    char[] chars2 = strings[i+1].toCharArray();
    int j=0;
    int minLength = Math.min(strings[i].length,strings[i+1].length);
    while(j<minLength){
      if(chars1[j].equals(chars2[j]){
        j++;
      } else {
        GraphNode graphNode =  new GraphNode(chars1[j]);
        if(!graph.hasNode(graphNode)) 
          graph.add(graphNode);
        else{
          graph.getChildrenNodes().add(graphNode);
        }
        
        //strbuilder.append(chars1[j]).append(chars1[j]); // strbuilder = b c
      }
  }
}

private int compareChars(char ch1, char ch2){
//returns greater(first occcuring character) 
}


        b - e
      /  \ /
     c    d
      \  /
       a

//GraphNode : value, children
class GraphNode{
  char graphval;
  List<GraphNodes> children = new ArrayList<GraphNode>();
  
  public GraphNode(char val){
  this.graphval = val;
  }
  
  private List<GraphNodes> getChildrenNodes(){
    return children;
  }
}

-----
  for(int j=0;j<strings.size();j++){
    char[] chars = str.toCharArray[];
      for(int i =0;i<chars.length();i++){
        if(i==0 && j==0) 
          strbuilder.append(char[i]);
      }
      
  }
 */