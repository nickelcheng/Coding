class OrderedStream {
    
    private List<String> stream;
    private int ptr;

    public OrderedStream(int n) {
        stream = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            stream.add("");
        }
        ptr = 0;
    }
    
    public List<String> insert(int id, String value) {
        stream.set(id-1, value);
        List<String> ans = new ArrayList<>();
        while (ptr < stream.size() && !stream.get(ptr).equals("")) {
            ans.add(stream.get(ptr++));
        }
        return ans;
    }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(id,value);
 */
