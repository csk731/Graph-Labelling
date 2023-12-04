import java.util.*;


public class GraphLabelling {
    public void labelGraph(int rootNodes, long maxLabel, HashMap<Long, List<Pair>> hashMap){
        long weight=3;
        hashMap.put(1L,new ArrayList<Pair>(Arrays.asList(new Pair(2,1))));
        long edgeCount=3;
        long rootNode=2;
        long i=1, usedWeight=-1;

        while(i<rootNodes){
            long j=0;
            while(j<edgeCount){
                long nextLink=weight-rootNode;
                if(weight!=usedWeight) {
                    Pair pair = new Pair(weight, nextLink);
                    if (!hashMap.containsKey(rootNode)) hashMap.put(rootNode, new ArrayList<>());
                    hashMap.get(rootNode).add(pair);
                }
                weight++;
                j++;
            }
            edgeCount++;
            if(i==rootNodes-2) {
                usedWeight=maxLabel+rootNode;
                hashMap.put(maxLabel,new ArrayList<>());
                hashMap.get(maxLabel).add(new Pair(maxLabel+rootNode,rootNode));
                rootNode=maxLabel;
            }
            else rootNode=weight-rootNode;
            i++;
        }
    }
    public void labelGraphWithLoops(int rootNodes, HashMap<Integer, LinkedList<Integer>> hashMap){

//        Set<Integer> set=new HashSet<>();
//        set.add(2);
//        set.add(1);

        hashMap.put(1,new LinkedList<>(Arrays.asList(2)));
        hashMap.put(2,new LinkedList<>(Arrays.asList(1)));

        int weight=4;
        int edgeCount=2;
        int rootNode=1;
        int i=1, count=0;

        while(i<rootNodes) {
            int j = 0;
            int prevRootNode=rootNode;
            rootNode = weight - prevRootNode;
            hashMap.put(rootNode, new LinkedList<Integer>());
            hashMap.get(rootNode).add(prevRootNode);
            hashMap.get(prevRootNode).add(rootNode);

//            if(!set.add(prevRootNode+rootNode)){
//                System.exit(123);
//            };

            weight = (2 * rootNode) + 1;

            int leftMostChild=weight-rootNode;
            hashMap.put(leftMostChild, new LinkedList<>());

            while (j < edgeCount) {
                int child=weight - rootNode;
                hashMap.get(rootNode).add(child);
                if(!hashMap.containsKey(child)) hashMap.put(child,new LinkedList<>());
                hashMap.get(child).add(rootNode);

//                if(!set.add(child+rootNode)){
//                    System.exit(123);
//                };

                weight++;
                j++;
            }

            int rightMostChild=weight-rootNode-1;

//            if(!set.add(rightMostChild+leftMostChild)){
//                System.exit(123);
//            };

            hashMap.get(leftMostChild).add(rightMostChild);
            hashMap.get(rightMostChild).add(leftMostChild);

            weight++;
            edgeCount++;
            i++;
        }
    }
}
