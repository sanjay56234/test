package LRUCache.Cache.EvictionPolicy;

import LRUCache.Algorithm.DoubleLinkedListNode;
import LRUCache.Algorithm.DoublyLinkedList;

import java.util.HashMap;
import java.util.Map;

public class LRUEvictionPolicy<Key> implements EvictionPolicy<Key>{

    private DoublyLinkedList<Key> doublyLinkedList;
    private Map<Key, DoubleLinkedListNode<Key>> map;

    public LRUEvictionPolicy(){
        this.doublyLinkedList = new DoublyLinkedList<>();
        this.map = new HashMap<>();
    }
    @Override
    public void keyAccessed(Key key) {
        if(map.containsKey(key)){
            doublyLinkedList.deattachNode(map.get(key));
            doublyLinkedList.addNodeAtLast(map.get(key));
        }else{
            DoubleLinkedListNode<Key> node = doublyLinkedList.addElementAtLast(key);
            map.put(key, node);
        }
    }

    @Override
    public Key evictKey() {
        DoubleLinkedListNode<Key> first = doublyLinkedList.getFirstNode();
        if(first == null) {
            return null;
        }
        doublyLinkedList.deattachNode(first);
        return first.getElement();
    }
}
