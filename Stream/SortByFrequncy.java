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

    static int[] sortByFrequencyAndReturnByPrimitiveArray() {

        int [] arr = {1,1,1,2,2,2,2,3,4,4,7,6};
        
        int[] ans = Arrays.stream(arr).boxed()
               .collect(Collectors.groupingBy(x->x,LinkedHashMap::new,Collectors.counting()))
               .entrySet()
               .stream()
               .sorted((x,y)->-1*Long.compare(x.getValue(),y.getValue()))
               .flatMap(x->{
                           Long times = x.getValue();
                           List<Integer> list = new ArrayList<>();
                           while(times-->0) list.add(x.getKey());
                           return list.stream();
               })
               .mapToInt(Integer::intValue)
               .peek(System.out::println)
               .toArray();
        return ans;
    }
    
}
