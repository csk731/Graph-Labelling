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
    public void labelGraphWithLoops(int rootNodes, HashMap<Long, List<Pair>> hashMap, HashSet<Long> hashSet){
        hashMap.put(1l,new ArrayList<Pair>(Arrays.asList(new Pair(1,2))));
        hashSet.add(2l);
        long i=2, rootLimit=2+(4*(rootNodes-2));

        while(i<=rootLimit){
            long leftLabel=i+1;
            long rightLabel=i+2;
            long prevRootNode=i-4;
            if(i==2) prevRootNode=1;

            if(!hashMap.containsKey(i)) hashMap.put(i,new ArrayList<>());
            if(!hashMap.containsKey(leftLabel)) hashMap.put(leftLabel,new ArrayList<>());

            hashMap.get(i).add(new Pair(prevRootNode, i+prevRootNode));
            hashSet.add(i+prevRootNode);

            hashMap.get(i).add(new Pair(leftLabel,i+leftLabel));
            hashSet.add(i+leftLabel);

            hashMap.get(i).add(new Pair(rightLabel,i+rightLabel));
            hashSet.add(i+rightLabel);

            hashMap.get(leftLabel).add(new Pair(rightLabel,leftLabel+rightLabel));
            hashSet.add(leftLabel+rightLabel);

            i+=4;
        }

        long startRootNode=6, linkCount=1;

        while (startRootNode<=rootLimit){
            long count=linkCount;

            while (count>0){
                long idx=1;

                while (true){
                    if(!hashSet.contains(startRootNode+idx)){
                        hashSet.add(startRootNode+idx);
                        hashMap.get(startRootNode).add(new Pair(idx,startRootNode+idx));
                        break;
                    }
                    idx++;
                }
                count--;
            }
            linkCount++;
            startRootNode+=4;
        }

        i+=4;
    }
}
