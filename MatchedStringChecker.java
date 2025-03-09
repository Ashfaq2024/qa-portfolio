import java.util.Stack;

public class MatchedStringChecker {

    // Method to check if a string has matched brackets
    public static boolean isMatched(String input) {
        Stack<Character> stack = new Stack<>();
        
        // Iterate through each character in the string
        for (char ch : input.toCharArray()) {
            // If the character is an opening bracket, push it onto the stack
            if (ch == '{' || ch == '(' || ch == '[') {
                stack.push(ch);
            }
            // If it's a closing bracket
            else if (ch == '}' || ch == ')' || ch == ']') {
                // Check if the stack is empty or the top element doesn't match
                if (stack.isEmpty()) {
                    return false;
                }
                
                char top = stack.pop();
                
                // Check if the top element matches the corresponding opening bracket
                if ((ch == '}' && top != '{') ||
                    (ch == ')' && top != '(') ||
                    (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }
        
        // If the stack is empty, all brackets are matched
        return stack.isEmpty();
    }
    
    public static void main(String[] args) {
        String test1 = "{{()[]}}";
        String test2 = "{{()]}";
        
        // Test with matched string
        System.out.println(test1 + " is matched: " + isMatched(test1));
        
        // Test with unmatched string
        System.out.println(test2 + " is matched: " + isMatched(test2));
    }
}
