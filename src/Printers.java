import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Printers {
    public void printMapAcyclic(HashMap<Long, List<Pair>> hashMap){
        System.out.println(hashMap);
    }
    public void printMapCyclic(HashMap<Integer, LinkedList<Integer>> hashMap){
        System.out.println(hashMap);
    }

    public void printHashSet(HashSet hashSet){
        System.out.println(hashSet);
    }

}
