/**
 * 迷宫回溯递归问题
 */
public class recursion {
    public static void main(String[] args) {
        //构建迷宫
        int[][] maze=new int[6][8];

        //设置围墙
        for (int i = 0; i < maze.length; i++) {
            maze[i][0]=1;
            maze[i][maze[0].length-1]=1;
            if (i==2){
                maze[i][2]=1;
                maze[i][3]=1;
                maze[i][4]=1;
            }
            if (i==3){
                maze[i][4]=1;
                maze[i][5]=1;
                maze[i][6]=1;
            }
        }
        for (int i = 1; i < maze[0].length; i++) {
            maze[0][i]=1;
            maze[maze.length-1][i]=1;
        }

        //遍历出迷宫
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                System.out.print(maze[i][j]+" ");
            }
            System.out.println();
        }
        //找通路(传入地图，起点，终点),策略，（右→下→左→上）
        lookChannel(maze,1,1);
        System.out.println("------------------------");
        //遍历出迷宫
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                System.out.print(maze[i][j]+" ");
            }
            System.out.println();
        }

    }

    private static boolean lookChannel(int[][] maze, int i, int i1) {
        if (maze[4][6]==2){
            return true;
        }else{
            if (maze[i][i1]==0){
                maze[i][i1]=2;//假定该点可以走通
                if (lookChannel(maze, i,i1+1)){//向右走
                    return  true;
                }else if(lookChannel(maze,i+1,i1)){//向下走
                    return true;
                }else if(lookChannel(maze,i,i1-1)){//向左走
                    return  true;
                }else if (lookChannel(maze,i-1,i1)){//向上走
                    return true;
                }else {
                    maze[i][i1]=3;//都走不通，就设为3,表示走不通
                    return false;
                }
            }else {
                return false;
            }
        }
    }
}
