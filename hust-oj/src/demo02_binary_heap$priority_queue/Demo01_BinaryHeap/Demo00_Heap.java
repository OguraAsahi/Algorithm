package demo02_binary_heap$priority_queue.Demo01_BinaryHeap;

public class Demo00_Heap {
    private int hs; //currentSize
    private static final int DEFAULT_CAPACITY = 10;
    private int[] heap;

    public static void main(String[] args) {

    }
    void sink(int p){
        int q=p<<1, a = heap[p];
        while(q<=hs){
            if(q<hs&&heap[q+1]<heap[q])q++;
            if(heap[q]>=a) break;
            heap[p]=heap[q]; p=q; q=p<<1;
        }
        heap[p] = a;
    }
    void swim(int p){
        int q = p>>1, a = heap[p];
        while(q>0 && a<heap[q]){ heap[p]=heap[q]; p=q; q=p>>1; }
        heap[p] = a;
    }
    void insert(int a)
    { heap[++hs]=a; swim(hs); }
    int getmin()
    { int r=heap[1]; heap[1]=heap[hs--];
        sink(1); return r; }
    int decreaseKey(int p, int a)
    { heap[p]=a; swim(p); return a;}
    void build()
    { for(int i=hs/2;i>0;i--) sink(i); }
}
