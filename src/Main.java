import java.util.ArrayList;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String regex = "(\\[[0-9/0-9]+\\])";
        Pattern pattern = Pattern.compile(regex);
        Pattern subPattern = Pattern.compile("\\d+");


        String text = "[Fri Jul 22 03:20:13.122 2016] !0x5002D0F0|JVM| Free Memory: Heap [17277944/27262976], Native[25064664/50331648]";
        Matcher matcher = pattern.matcher(text);

        Stack<MemoryLog> memoryStack = new Stack<MemoryLog>();
        while(matcher.find()){
            System.out.println(matcher.group());
            String key = matcher.group();
            Matcher subMatcher = subPattern.matcher(key);
            Stack<String> memory = new Stack<String>();
            while (subMatcher.find()) {
                memory.push(subMatcher.group());
            }

            MemoryLog memoryLog = new MemoryLog(memory.pop(),memory.pop());
            memoryStack.push(memoryLog);
        }



        if(memoryStack.size() > 1){
            MemoryLog heap = memoryStack.pop();
            MemoryLog nativ = memoryStack.pop();
            MemoryPocket memoryPocket = new MemoryPocket(heap , nativ);

        }

    }
}
