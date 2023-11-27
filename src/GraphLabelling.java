import java.util.*;


public class GraphLabelling {
    public void labelGraph(int rootNodes, int maxLabel, HashMap<Integer, List<Pair>> hashMap){
        int weight=3;
        hashMap.put(1,new ArrayList<Pair>(Arrays.asList(new Pair(1,2))));
        int edgeCount=3;
        int rootNode=2;
        int i=1;

        while(i<rootNodes){
            int j=0;
            while(j<edgeCount){
                int nextLink=weight-rootNode;
                Pair pair=new Pair(nextLink,weight);
                if(!hashMap.containsKey(rootNode)) hashMap.put(rootNode,new ArrayList<>());
                hashMap.get(rootNode).add(pair);
                weight++;
                j++;
            }
            edgeCount++;
            if(i==rootNodes-2) rootNode=maxLabel;
            else rootNode=weight-rootNode;
            i++;
        }
    }
    public void labelGraphWithLoops(int rootNodes, HashMap<Integer, List<Pair>> hashMap, HashSet<Integer> hashSet){
        hashMap.put(1,new ArrayList<Pair>(Arrays.asList(new Pair(1,2))));
        hashSet.add(2);
        int i=2, rootLimit=2+(4*(rootNodes-2));

        while(i<=rootLimit){
            int leftLabel=i+1;
            int rightLabel=i+2;
            int prevRootNode=i-4;
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

        int startRootNode=6, linkCount=1;

        while (startRootNode<=rootLimit){
            int count=linkCount;

            while (count>0){
                int idx=1;

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
