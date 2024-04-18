class Solution {
    class Pair{
        int row;
        int col;
        int dis;
        Pair(int row,int col,int dis){
            this.row = row;
            this.col=col;
            this.dis=dis;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        boolean vis[][] = new boolean[n][m];
        int dis[][] = new int[n][m];
        Queue<Pair> q = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                   q.add(new Pair(i,j,0));
                   vis[i][j]=true;
                }
            }
        }
        int dr[] = {0,0,-1,1};
        int dc[] = {1,-1,0,0};
        while(q.size()>0){
            Pair rp = q.remove();
            int r = rp.row;
            int c = rp.col;
            int d = rp.dis;
            dis[r][c] = d;
            for(int i=0;i<4;i++){
                 int nr = r+dr[i];
                 int nc = c+dc[i];
                 if(0<=nr && nr<n && 0<=nc && nc<m && vis[nr][nc]==false){
                    q.add(new Pair(nr,nc,d+1));
                    vis[nr][nc]=true;
                 }
            }
        }
        return dis;
    }
}