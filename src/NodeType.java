public class NodeType {
    public ItemType info;
    public NodeType next;

    public NodeType() {
        info = null;
        next = null;
    }

    public NodeType(ItemType info, NodeType next) {
        this.info = info;
        this.next = next;
    }
}
