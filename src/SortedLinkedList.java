public class SortedLinkedList {
    
    private NodeType head;
    private NodeType currentPos;

    public SortedLinkedList() {
        head = null;
        currentPos = head;
    }

    public int getLength() {
        NodeType temp = head;
        int count = 0;

        while (temp.next != null) {
            count++;
            temp = temp.next;
        }

        return count;
    }

    public void insertItem(ItemType item) {
        if (head == null) {
            head = new NodeType();
            head.info = item;
        } else if (item.compareTo(head.info) == -1) {
                NodeType temp = new NodeType();
                temp.info = item;
                temp.next = head;
                head = temp;
        } else if (head.next == null) {
            NodeType temp = new NodeType();
            temp.info = item;
            head.next = temp;
        } else {
            NodeType temp = head;
            while (temp.next != null) {
                switch (item.compareTo(temp.next.info)) {
                    case -1:                         
                        NodeType newNode = new NodeType();
                        newNode.info = item;
                        newNode.next = temp.next;
                        temp.next = newNode;
                        break;

                   case 1:
                        temp = temp.next;
                        break;

                   default:
                        System.out.println("Sorry. You cannot insert the duplicate item");
                        temp.next = null;
                        break;
                }
            }
        }  
    }

    public void deleteItem(ItemType item) {
        try{
            if (item.compareTo(head.info) == 0) {
                head = head.next;
            }
        } catch (NullPointerException npe) {
            System.out.println("List is empty");
        }

        NodeType temp = head;
        boolean isFound = false;
        while (!isFound) {
            try {
                if (item.compareTo(temp.next.info) == 0) {
                    temp.next = temp.next.next;
                    isFound = true;
                } 
                else
                    temp = temp.next;
            } catch (NullPointerException npe) {
                System.out.println("The end of the list has been reached");
                isFound = true;
            }
        }
    }
    
    public int searchItem(ItemType item) {
        int index = 0;
        NodeType temp = head;
        while (temp.next != null) {
            if (item.compareTo(temp.info) == 0) {
                return index;
            } else if (item.compareTo(temp.info) == -1) {
                temp = temp.next;
                index++;
            } else {
                System.out.println("The end of the list had been reached");
                return -1;
            }
        }
        if (item.compareTo(temp.info) == 0) {
            return index;
        } else {
            System.out.println("The end of the list had been reached");
            return -1;
        }
    }

    public ItemType getNextItem() {
        ItemType returnItem;
        if (head.info == null) {
            System.out.println("List is empty");
            returnItem = null;
        } else if (currentPos == null) {
            currentPos = head;
            returnItem = currentPos.info;
            currentPos = currentPos.next;
        } else {
            returnItem = currentPos.info;
            currentPos = currentPos.next;
        }
        return returnItem;
    }

    public void resetList() {
        currentPos = null;
    }

    public SortedLinkedList mergeList(SortedLinkedList list) {
        SortedLinkedList returnList = new SortedLinkedList();
        for(int count = 0; count < this.getLength(); count++) {
            returnList.insertItem(this.getNextItem());
        }
        for(int count = 0; count < list.getLength(); count++) {
            returnList.insertItem(list.getNextItem());
        }
        return returnList;   
    }

    public void deleteAlternateNodes() {
        NodeType temp = head;
        for(int count = 0; count < this.getLength(); count++) {
            if (count % 2 == 0) {
                deleteItem(temp.info);
            }
            temp = temp.next;
        }
    }

    public void intersection(SortedLinkedList list) {
        SortedLinkedList printList = new SortedLinkedList();
        NodeType temp = this.head;
        while (temp != null) {
            if(list.searchItem(temp.info) != -1) {
                printList.insertItem(temp.info);
            }
            temp = temp.next;
        }
        System.out.print("Intersection:");
        temp = printList.head;
        while (temp != null) {
            System.out.println(" " + temp.info);
            temp = temp.next;
        }
    }
}
