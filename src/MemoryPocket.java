public class MemoryPocket{
    public MemoryPocket(MemoryLog heap , MemoryLog nati){
        this.heap = heap;
        this.nati = nati;
    }
    private MemoryLog heap;
    private MemoryLog nati;

    public MemoryLog getHeap(){
        return this.heap;
    }

    public MemoryLog getNative(){
        return this.nati;
    }
}