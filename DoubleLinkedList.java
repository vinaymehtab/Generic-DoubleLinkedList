package doublyLinkedList;


public class DoubleLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;

    public void addToEmptyList(T value) {
        this.head = new Node<T>();
        this.head.setData(value);
        this.tail = this.head;
    }

    public void addToFirst(T value) {

        if (this.head == null) {
            this.addToEmptyList(value);
        } else {
            Node<T> newNode = new Node<T>();
            newNode.setData(value);
            newNode.setNext(this.head);

            this.head.setPrevious(newNode);

            this.head = newNode;
        }
    }

    public void addToLast(T value) {

        if (this.head == null) {
            this.addToEmptyList(value);
        } else {
            Node<T> newNode = new Node<T>();
            newNode.setData(value);
            newNode.setPrevious(this.tail);

            this.tail.setNext(newNode);
            this.tail = newNode;
        }
    }
    
    public void addToIndex(T value, int index) {

    	index = index-1;
    	
        if (this.head == null) {
            this.addToEmptyList(value);
        } else {

            Node<T> currentNode = this.getNodeAtIndex(index);

            if (currentNode != null) {
                Node<T> newNode = new Node<T>();
                newNode.setData(value);
                newNode.setNext(currentNode.getNext());
                newNode.setPrevious(currentNode);

                if (currentNode.getNext() != null) {
                    currentNode.getNext().setPrevious(newNode);
                }

                currentNode.setNext(newNode);
            }
        }
    }

    public void delete(T value) {

        if (this.head != null) {
            Node<T> currentNode = this.head;

            while (currentNode != null) {
                if (currentNode.getData() == value) {
                    currentNode.getPrevious().setNext(currentNode.getNext());

                    if (currentNode.getNext() != null) {
                        currentNode.getNext().setPrevious(currentNode.getPrevious());
                    }

                    System.out.println("Deleted node with value " + value);
                    break;
                } else {
                    currentNode = currentNode.getNext();
                }
            }
        }
    }

 

    public void deleteNodeAtIndex(int index) {

        Node<T> currentNode = this.getNodeAtIndex(index);

        if (currentNode != null) {

            currentNode.getPrevious().setNext(currentNode.getNext());

            if (currentNode.getNext() != null) {
                currentNode.getNext().setPrevious(currentNode.getPrevious());
            }
        }
    }

    public void deleteNodeAfterIndex(int index) {

        Node<T> currentNode = this.getNodeAtIndex(index);

        if (currentNode != null) {

            if (currentNode.getNext() != null) {

                if (currentNode.getNext().getNext() != null) {
                    currentNode.getNext().getNext().setPrevious(currentNode);
                }

                currentNode.setNext(currentNode.getNext().getNext());
            } else {
                currentNode.setNext(null);
            }
        }
    }

    public Node<T> getNodeAtIndex(int index) {

        Node<T> currentNode = null;

        if (this.head != null) {

            int nodeIndex = 0;

            currentNode = this.head;

            while (nodeIndex != index) {

                if (currentNode.getNext() != null) {
                    currentNode = currentNode.getNext();
                }

                nodeIndex++;
            }
        }

        return currentNode;
    }
    
    public void traverse() {

        if (this.head != null) {
            Node<T> currentNode = this.head;

            while (currentNode != null) {
                System.out.print(currentNode.getData() + " <-> ");
                currentNode = currentNode.getNext();
            }

            System.out.println("END");

        } else {
            System.out.println("Linked list is empty.");
        }
    }
}