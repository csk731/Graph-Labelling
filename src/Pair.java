public class Pair {
    long weight;
    long linkedNode;

    public Pair(long weight, long linkedNode) {
        this.weight = weight;
        this.linkedNode = linkedNode;
    }

    @Override
    public String toString() {
        return "<" + linkedNode +","+weight +">";
    }
}
