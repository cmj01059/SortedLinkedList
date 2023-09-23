public class ItemType {
    
    private int value;

    public ItemType(int value) {
        this.value = value;
    }

    public int compareTo(ItemType item) {
        if (item.getValue() > value)
            return -1;
        else if (item.getValue() < value)
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
