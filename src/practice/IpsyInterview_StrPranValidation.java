package practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class IpsyInterview_StrPranValidation {

/*
Turn off automatic capitalization:
Tools -> Preferences -> “Automatically capitalize words”



Given: String containing just the characters '(', ')', '{', '}', '[' and ']'. Determine if the input string is valid with closing braces in the right order.
Examples:
{}
[](){}
[{()}]
(()){{}}[[]]
 
()]
{)
 
(()
 
((()
)(())(
 
 
<>
/\
 
Map → 
‘(‘ -‘)’
‘)’ - ‘(‘
 
 
//Base cases:
If str not even length, then return false
If current is ‘)’ or ‘}’ or ‘]’, then i peek and see if they openings of the same,
Once the operation is complete, if the stack is not empty, then false.
Else true
 
*/
 
public static Map<Character, Character> generateMap(String[] keys) {
Map<Character, Character> map = new HashMap<Character, 
Character>();
//for(int i =0; i<keys.length;i++) {
//	map.put(keys[i]
//}
return map;
 
//TODO
}
/*
Map → 
‘(‘:‘)’
‘{’:‘}‘
‘[‘:’]’
‘<’:’>’
*/
public static boolean isGivenInputValid(String input, Map<Character, Character> map) {
	if(input==null) { 
return true;
}
if(!(input.length()%2 ==0)) {
		return false;
}
Stack<Character> stk = new Stack<Character>();
for(int i =0; i<input.length();i++) {
  	if(map.keySet().contains(input.charAt(i))){
		stk.push(input.charAt(i));
} else {
     if(!stk.isEmpty() && (map.get(stk.peek())== input.charAt(i))) {
		stk.pop();
} else {
	return false;
}
}
}
return stk.isEmpty();
}
 
 
/*
	Public static boolean isGivenInputValid(String input) {
		if(!(input.length()%2 ==0)) {
			return false;
}
Stack<Character> stk = new Stack<Character>();
for(int i =0; i<str.length();i++) {
	if(str.charAt(i) == ‘(‘ 
		|| str.charAt(i) == ‘{‘ 
		|| str.charAt(i) == ‘[‘ ) {
		stk.push(str.charAt(i));
} else {
     if((!stk.isEmpty() && str.charAt(i) ==’)’ && stk.peek()== ‘(‘)
	|| (!stk.isEmpty() &&  str.charAt(i) ==’}’ && stk.peek()== ‘{‘)
	|| (!stk.isEmpty() && str.charAt(i) ==’]’ && stk.peek()== ‘[‘)) {
		stk.pop();
} else {
	return false;
}
}
}
if(!stk.isEmpty()) {
	return false;
}
return true;
}
*/
}

