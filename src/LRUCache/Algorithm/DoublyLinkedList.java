package LRUCache.Algorithm;

public class DoublyLinkedList<E> {
    DoubleLinkedListNode<E> head;
    DoubleLinkedListNode<E> tail;

    public DoublyLinkedList(){
        head = new DoubleLinkedListNode<>(null);
        tail = new DoubleLinkedListNode<>(null);
        head.next = tail;
        tail.prev = head;
    }

    public void deattachNode(DoubleLinkedListNode<E> node){
        if(node!=null){
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    public void addNodeAtLast(DoubleLinkedListNode<E> node){
        DoubleLinkedListNode<E> tailPrev = tail.prev;
        tailPrev.next = node;
        node.prev = tailPrev;
        node.next = tail;
        tail.prev = node;
    }

    public DoubleLinkedListNode<E> addElementAtLast(E element){
        if(element == null){
            System.out.println("Invalid element");
        }
        DoubleLinkedListNode<E> doubleLinkedListNode = new DoubleLinkedListNode<>(element);
        addNodeAtLast(doubleLinkedListNode);
        return doubleLinkedListNode;
    }
    public boolean isItemPresent(){
        return head.next!=tail;
    }

    public DoubleLinkedListNode<E> getFirstNode(){
        return head.next;
    }
    public DoubleLinkedListNode<E> getLastNode(){
        return tail.prev;
    }


}
