public class Pair {
    int weight;
    int linkedNode;
    Pair nextPair;

    public Pair(int weight, int linkedNode) {
        this.weight = weight;
        this.linkedNode = linkedNode;
    }

    public Pair(int linkedNode, int weight, Pair nextPair) {
        this.linkedNode = linkedNode;
        this.weight = weight;
        this.nextPair=nextPair;
    }

    @Override
    public String toString() {
        return "{ " + linkedNode +","+weight +" }";
    }
}
