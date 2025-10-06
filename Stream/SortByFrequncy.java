import java.util.*;
import java.util.stream.Collectors;
public class Main {

    public static void main(String[] args) {
        String str = "programming";
        
        Arrays.stream(str.split(""))
              .collect(Collectors.groupingBy(x->x,Collectors.counting()))
              .entrySet()
              .stream()
              .sorted((x,y)->{
                if (Double.compare(x.getValue(), y.getValue()) != 0) {
                    return Double.compare(y.getValue(), x.getValue());
                }   
                return Character.compare(x.getKey().charAt(0), y.getKey().charAt(0));
              })
              .forEach(x->{
                for(int i=0;i<x.getValue();i++) {
                    System.out.print(x.getKey());
                }
              });
    }
    
}
