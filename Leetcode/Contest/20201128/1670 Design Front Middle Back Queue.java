class FrontMiddleBackQueue {

    List<Integer> fmbQueue = new ArrayList<>();
    
    public FrontMiddleBackQueue() {
        
    }
    
    public void pushFront(int val) {
        fmbQueue.add(0, val);
    }
    
    public void pushMiddle(int val) {
        int len = fmbQueue.size();
        int pos = len / 2;
        fmbQueue.add(pos, val);
    }
    
    public void pushBack(int val) {
        fmbQueue.add(val);
    }
    
    public int popFront() {
        if (fmbQueue.isEmpty()) return -1;
        int val = fmbQueue.get(0);
        fmbQueue.remove(0);
        return val;
    }
    
    public int popMiddle() {
        if (fmbQueue.isEmpty()) return -1;
        int len = fmbQueue.size();
        int pos = (len-1) / 2;
        int val = fmbQueue.get(pos);
        fmbQueue.remove(pos);
        return val;
    }
    
    public int popBack() {
        if (fmbQueue.isEmpty()) return -1;
        int pos = fmbQueue.size()-1;
        int val = fmbQueue.get(pos);
        fmbQueue.remove(pos);
        return val;
    }
}

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */
