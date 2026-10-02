class Solution {
    public boolean isValid(String s) {
        Stack<Character> braces = new Stack<>();

        for (char brace : s.toCharArray()) {
            
            if (brace == '(' || brace == '{' || brace == '[') {
                braces.push(brace);
            }
            else {
                if (braces.empty()) return false;

                char current = braces.peek();

                if (
                    (current == '(' && brace == ')') ||
                    (current == '[' && brace == ']') ||
                    (current == '{' && brace == '}')
                ) {
                    braces.pop();
                }
                else return false;
            }
        }

        return braces.empty();
    }
}
