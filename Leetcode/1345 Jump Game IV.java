class Solution {
    int[] dis;
    Queue<Integer> que;

    public int minJumps(int[] arr) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            List<Integer> nei = adj.get(arr[i]);
            if (nei == null) adj.put(arr[i], new ArrayList<>(Arrays.asList(i)));
            else nei.add(i);
        }
        
        dis = new int[len];
        Arrays.fill(dis, -1);
        que = new LinkedList<>();
        
        push(0, 0);
        while(!que.isEmpty() && dis[len-1] == -1) {
            int curr = que.poll();
            int d = dis[curr]+1;
            if (curr < len-1) push(curr+1, d);
            if (curr > 0) push(curr-1, d);
            for (int nei : adj.get(arr[curr])) {
                push(nei, d);
            }
            adj.put(arr[curr], new ArrayList<>());
        }
        
        return dis[len-1];
    }
    
    private void push(int idx, int d) {
        if (dis[idx] != -1) return;
        dis[idx] = d;
        que.add(idx);
    }
}
