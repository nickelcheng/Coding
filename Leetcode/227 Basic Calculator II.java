class Solution {
    public int calculate(String s){
        Stack<Integer> stack = new Stack<>();
        char keepOp = ' ';
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') {
                Pair<Integer, Integer> result = getNum(s, i);
                stack.push(result.getKey());
                i = result.getValue();
            } else if (ch == '+' || ch == '-') {
                if (keepOp != ' ') {
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    stack.push((keepOp == '+') ? num1 + num2 : num2 - num1);
                }
                keepOp = ch;
            } else if (ch == '*' || ch == '/') {
                Pair<Integer, Integer> result = getNum(s, i+1);
                int num = stack.pop();
                i = result.getValue();
                if (ch == '*') stack.push(num * result.getKey());
                else stack.push(num / result.getKey());
            }
        }
        if (keepOp != ' ') {
            int num1 = stack.pop();
            int num2 = stack.pop();
            return (keepOp == '+') ? num1 + num2 : num2 - num1;
        }
        
        return stack.pop();
    }
    
    private Pair<Integer, Integer> getNum(String s, int idx) {
        while (s.charAt(idx) == ' ') idx++;
        char ch = s.charAt(idx);
        int num = 0;
        while (ch >= '0' && ch <= '9') {
            num *= 10;
            num += ch - '0';
            idx++;
            if (idx >= s.length()) break;
            ch = s.charAt(idx);
        }
        return new Pair<Integer, Integer>(num, idx-1);
    }
}
// start coding: 13:00
// restart: 28:00
// restart2: 48:00
// start coding: 1:01:00
// WA: 1:35:00
// restart3: 1:36:00
// RE: 2:08:00
