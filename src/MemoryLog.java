public class MemoryLog{
    private String current;
    private String total;
    public MemoryLog(String current , String total){
        this.current = current;
        this.total = total;
    }

    public String getCurrent(){
        return this.current;
    }

    public String getTotal(){
        return this.total;
    }
}