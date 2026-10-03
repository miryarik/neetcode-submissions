class MinStack {
    Stack<Long> stack;
    long min;

    public MinStack() {
        this.stack = new Stack<>();
        this.min = 0;
    }

    public void push(int value) {
        if (stack.empty()) {
            min = value;
            stack.push(0L);
        }
        else {
            stack.push(value - min);
            if (value < min) min = value;
        }
    }

    public void pop() {
        if (stack.isEmpty()) return;
        long en = stack.pop();
        if (en < 0) min = min - en;
        
    }

    public int top() {
        long en = stack.peek();
        return (int) ((en < 0) ? min : en + min);
    }

    public int getMin() {
        return (int) min;
    }
}
