// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
import java.util.stream.Collectors;
class Main {
    public static void main(String[] args) {
        
        String str = "pprooggrramme";
        
        String first = helper_v1(str);
        
        System.out.println(first);
        
    }
    
    static String helper(String str) {
        
        return Arrays.stream(str.split(""))
              .collect(Collectors.groupingBy(x->x,LinkedHashMap::new,Collectors.counting()))
              .entrySet()
              .stream()
              .filter(x->x.getValue()==1)
              .map(x->x.getKey())
              .findFirst()
              .get();
    }
    
    static String helper_v1(String str) {
        
        return Arrays.stream(str.split(""))
                     .distinct()
                     .findFirst()
                     .get();
    }
}
