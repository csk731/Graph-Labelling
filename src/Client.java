import javax.swing.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        System.out.println("Enter number of root nodes: ");
        int rootNodes=scanner.nextInt();

        System.out.println("Enter '1' for Acyclic labelling (OR) '2' for Cyclic labelling: ");
        int labelType=scanner.nextInt();

        long totalNodes=((long)rootNodes*(rootNodes+3))/2;
        long maxLabel = (long) Math.ceil((double)totalNodes/2);

        HashMap<Long, List<Pair>> hashMap=new HashMap<>();
        HashSet<Long> hashSet=new HashSet<>();

        GraphLabelling graphLabeler=new GraphLabelling();
        Printers printer=new Printers();

        if(labelType==1) {
            System.out.println("Labelling Acyclic Graph....");
            System.out.println("maxLabel: "+ maxLabel);
            graphLabeler.labelGraph(rootNodes, maxLabel, hashMap);
        }
        else if(labelType==2) {
            System.out.println("Labelling Cyclic Graph....");
            graphLabeler.labelGraphWithLoops(rootNodes, hashMap, hashSet);
            System.out.println("Unique weights we got: ");
            printer.printHashSet(hashSet);
        }
        else System.out.println("Wrong input");

        printer.printMap(hashMap);
    }

}
