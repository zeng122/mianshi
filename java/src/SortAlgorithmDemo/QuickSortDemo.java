package SortAlgorithmDemo;

public class QuickSortDemo {
    public static  void main(String [] args){
        int  [] a  = {5, 6 ,1 , 6 ,7 ,4, 3, 6, 7, 5, 9};
        QuickSortDemo quickSortDemo = new QuickSortDemo();
        quickSortDemo.sort(a,0,a.length-1);
        for(int index : a){
            System.out.print(index+" ");
        }
    }

    public void sort(int[] array, int left, int right) {
        if(left > right) {
            return;
        }
        int index = array[left];
        int i = left, j = right;
        while(i != j) {
            // 顺序很重要，先从右边开始往左找，直到找到比index值小的数 ,这里限制出口比index小
            while(array[j] >= index && i < j) {
                j--;
            }
            // 再从左往右边找，直到找到比index值大的数
            while(array[i] <= index && i < j) {
                i++;
            }
            // 上面的循环结束表示找到了位置或者(i>=j)了，交换两个数在数组中的位置
            if(i < j) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }
        // 将基准数放到中间的位置（基准数归位）
        array[left] = array[i];
        System.out.println(array[i]);
        array[i] = index;

        // 递归，继续向基准的左右两边执行和上面同样的操作
        // i的索引处为上面已确定好的基准值的位置，无需再处理
        sort(array, left, i - 1);
        sort(array, i + 1, right);
    }

}
