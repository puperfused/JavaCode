import java.util.*;
import java.util.HashSet;
import java.util.Deque;

/**
    Implement Least Recently Used Cache Invalidation Algorithm
    Given a cache of size N, if CPU demands for page say 'x' , following cases may arise
    1) if the page x is not available in the cache add x to the front, given cache is not full
    2) Given cache is full, remove the last element or least recently used from the cache and add x
    3) x is present in cache, bring it to the front

    Solution: 
        Using Deque with HashMap
        Deque to maintain the pages and insertion order
        HashSet to lookup for the page existence in Cache/Dqeue

*/

class Cache {

    private Deque<Integer> deque;
    private HashSet<Integer> mp;
    private int capacity;

    Cache(int capacity) {
        this.capacity = capacity;
        this.deque = new LinkedList();
        this.mp = new HashSet<>();
    }

    public boolean isEmpty() {
        return deque.size() == 0;
    }

    public int getCacheSize() {
        return deque.size();
    }
    public boolean hasPage(int pageNumber) {
        if(mp.contains(pageNumber)) {
            return true;
        }
        return false;
    }

    public void referPage(int pageNumber) {

        // if the page is there in cache , move it to the front
        if(hasPage(pageNumber)) {
            deque.remove(pageNumber);
            deque.addFirst(pageNumber);
            mp.add(pageNumber);
            System.out.println("Bring Page to Front = " + pageNumber);
            return;
        }

        // if the page is not there in cache and cache is full
        if(getCacheSize() >= capacity) {
            int removedEntry = deque.removeLast();
            mp.remove(removedEntry);
            deque.addFirst(pageNumber);
            mp.add(pageNumber);
            System.out.println("Removing LRU Entry = " + removedEntry + " Adding new Page = " + pageNumber);
            return;
        }

        // if the page is not there in cache and cache is not full
        deque.addFirst(pageNumber);
        mp.add(pageNumber);
        System.out.println(" Adding new Page = "  + pageNumber);
    }

    public void printCache() {
        for(Integer val : deque) {
            System.out.print(val + " ");
        }
        System.out.println();

    }

}

class LRUCache {
    public static void main(String args[]) {
        Cache cache = new Cache(3);
        System.out.println("Current Cache Size = " + cache.getCacheSize());
        cache.referPage(1);
        cache.referPage(2);
        cache.referPage(3);
        System.out.println("Current Cache Size = " + cache.getCacheSize());
        cache.referPage(4);
        cache.referPage(4);
        System.out.println("Current Cache Size = " + cache.getCacheSize());
        cache.referPage(3);
        cache.printCache();
        cache.referPage(1);
        cache.printCache();
    }
}