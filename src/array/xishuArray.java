package array;

public class xishuArray {
    public static void main(String[] args) {
        int[][] arr1=new int[11][12];
        arr1[5][7]=123;
        arr1[6][8]=133;
        //二维数组转化为稀疏数组
        int[][] xi=xishu(arr1);
        for (int[] ints : xi) {
            for (int i = 0; i < ints.length; i++) {
                System.out.print(ints[i]+" ");
            }
            System.out.println();
        }
    }

    private static int[][] xishu(int[][] arr1) {
        //size纪律该数组非零数据的个数
        int size=0;
        //遍历获取非零数据个数
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[0].length; j++) {
                if (arr1[i][j]!=0){
                    size++;
                }
            }
        }
        //设置稀疏数组的第一行数据
        int[][] xis=new int[size+1][3];
        xis[0][0]=arr1.length;
        xis[0][1]=arr1[0].length;
        xis[0][2]=size;
        //遍历设置稀疏数组的行
        int count=0;
        for (int i = 0; i <arr1.length ; i++) {
            for (int j = 0; j < arr1[0].length; j++) {
                if (arr1[i][j]!=0){
                    count++;
                    xis[count][0]=i;
                    xis[count][1]=j;
                    xis[count][2]=arr1[i][j];
                }
            }
        }
        return xis;
    }
}
