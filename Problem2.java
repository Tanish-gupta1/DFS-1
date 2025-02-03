public class Problem2 {
    //t.c -> O(m*n)
    //s.c -> O(m*n)
    public int[][] updateMatrix(int[][] mat) {
        if(mat == null ||mat.length == 0){
            return mat;
        }

        int rowLength = mat.length;
        int colLength = mat[0].length;
        int level = 0;//this will inc when we're done with one level mean all the value at that point in queue is removed
        Queue<int[]> q = new LinkedList<>();//for bfs
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}}; // directions for the neighbours

        for(int i = 0;i<rowLength;i++){
            for(int j = 0;j<colLength;j++){
                if(mat[i][j]==0){
                    //if the element is 0 add to q or if its 1 change it to -1 so it can't be used again and again(visited)
                    q.add(new int[]{i,j});
                }
                else{
                    mat[i][j]= -1;
                }
            }
        }

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int[] curr =  q.poll();
                for(int[] dir : dirs){
                    //check each possible directions and if the any of them is -1 means add to queue and change the value to level + 1 as at level 0 every thing has 0
                    int nr = curr[0]+dir[0];
                    int nc = curr[1]+dir[1];
                    if(nr>=0&& nr<rowLength && nc>=0 && nc< colLength && mat[nr][nc]==-1){
                        q.add(new int[]{nr,nc});
                        mat[nr][nc]= level+1;
                    }
                }
            }
            level++;
        }
        return mat;
    }
}
