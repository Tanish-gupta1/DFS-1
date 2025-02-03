public class Problem1 {

    //BFS
    //tc->O(m*n)
    //sc -> O(m*n)
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image == null ||image.length == 0 || image[sr][sc] == color){
            return image;
        }
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}}; // directions for the neighbours
        int rowLength =  image.length;
        int colLength = image[0].length;

        Queue<int[]> q = new LinkedList<>();
        int oldColor =  image[sr][sc];// get the old colour
        image[sr][sc] = color;
        q.add(new int[]{sr,sc});
        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int[] dir : dirs){
                int nr =  curr[0]+ dir[0];
                int nc = curr[1]+ dir[1];
                //go for each neighbour and check if it's a oldcolour if yes then add it to queue and change the color
                if(nr>=0 &&nr<rowLength && nc >= 0 && nc< colLength&& image[nr][nc]==oldColor){
                    q.add(new int[]{nr,nc});
                    image[nr][nc]=color;
                }
            }
        }
        return image;
    }


    //dfs
    //t.c->O(m*n)
    //sc->O(m*n)
    class Solution {
        int rowLength;
        int colLength;
        int[][] dirs;
        public int[][] floodFill(int[][] image, int sr, int sc, int color) {
            if(image == null ||image.length == 0 || image[sr][sc] == color){
                return image;
            }
            dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}}; // directions for the neighbours
            rowLength =  image.length;
            colLength = image[0].length;
            dfs(image,sr,sc,color,image[sr][sc]);
            return image;
        }
        private void dfs(int[][] image, int sr, int sc, int newColor, int oldColor){
            //base
            if(sr<0 ||sr ==rowLength || sc <0 || sc ==colLength|| image[sr][sc]!= oldColor){
                return;
            }

            //logic
            image[sr][sc] = newColor;
            for(int[] dir :  dirs){
                int nr = sr + dir[0];
                int nc = sc + dir[1];
                dfs(image,nr,nc,newColor,oldColor);
            }

        }
    }

}
