class Solution {
    class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        Point move(Point dir) {
            return new Point(x+dir.x, y+dir.y);
        }
        void next() {
            if (y == 1) { x = 1; y = 0; }
            else if (x == 1) { x = 0; y = -1; }
            else if (y == -1) { x = -1; y = 0; }
            else if (x == -1) { x = 0; y = 1; }
        }
    }
    
    private int[][] matrix;
    
    public int[][] generateMatrix(int n) {
        matrix = new int[n][n];
        int num = 1;
        Point dir = new Point(0, 1);
        Point curr = new Point(0, 0);
        while(num <= n*n) {
            matrix[curr.x][curr.y] = num++;
            if (outOfBoundary(curr.move(dir), n)) {
                dir.next();
            }
            if (outOfBoundary(curr.move(dir), n)) {
                break;
            }
            curr = curr.move(dir);
        }
        return matrix;
    }
    
    private boolean outOfBoundary(Point p, int n) {
        return p.x >= n || p.y >= n || p.x < 0 || p.y < 0 || matrix[p.x][p.y] != 0;
    }
}
