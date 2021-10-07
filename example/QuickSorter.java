package example;

public class QuickSorter implements Sorter{
    
    private int[] a;

    @Override
    public void load(int[] a) {
        this.a = a;
    }

    private void swap(int i, int j) {
        int temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        plan += "" + a[i] + "<->" + a[j] + "\n";
    }

    private void quicksort(int start, int end){
        if(end-start < 1)
            return;
        int base = a[end];
        int n = start;
        for (int i = start; i < end; i++) {
            if (a[i] < base) {
                if (i != n)
                    swap(i, n);
                n++;
            }
        }
        swap(n, end);
        if(n==start)
            quicksort(n+1,end);
        else if(n ==end)
            quicksort(start,end-1);
        else{
            quicksort(start,n-1);
            quicksort(n+1,end);
        }
    }

    private String plan = "";

    @Override
    public void sort() {
        quicksort(0, a.length-1);
    }

    @Override
    public String getPlan() {
        return this.plan;
    }

}