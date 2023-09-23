public class ItemType {
    
    private int value;

    public ItemType(int value) {
        this.value = value;
    }

    public int compareTo(ItemType item) {
        if (value < item.getValue())
            return -1;
        else if (value > item.getValue())
            return 1;
        else
            return 0;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
