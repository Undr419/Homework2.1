package com.golovanov_andrey.homework1;

public class MyHashMap<K,V> {
    private static final int DEF_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;

    private Node<K,V>[] table;
    private int size= 0;
    private int capacity;

    static class Node<K, V> {
        K key;
        V value;
        int hash;
        Node<K, V> next;

        Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public MyHashMap() {

        this.capacity = DEF_CAPACITY;
        table = new Node[capacity];
    }

    public void put(K key, V value) {

        int hash = key.hashCode();
        int index = hash & (capacity - 1);

        Node<K,V> newNode = new Node(hash, key, value, null);

        if (table[index] == null) {
            table[index] = newNode;
        } else {
            Node<K,V> current = table[index];
            while (true) {
                if (current.hash == hash && current.key.equals(key)) {
                    current.value = value;
                    return;
                }
                if (current.next == null) {
                    current.next = newNode;
                    break;
                }
                current = current.next;
            }
        }
        size++;
    }

    public V get(K key) {
        int hash = key.hashCode();
        int index = hash & (capacity - 1);

        Node<K,V> current = table[index];

        while (current != null) {
            if (current.hash == hash && current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    public V remove(K key){
        int hash = key.hashCode();
        int index = hash & (capacity - 1);

        Node<K,V> current = table[index];
        Node<K,V> previous = null;

        while (current != null) {
            if (current.hash == hash && current.key.equals(key)) {
                if (previous == null) {
                    table[index] = current.next;
                } else {
                    previous.next = current.next;
                }
                size--;
                return current.value;
            }
            previous = current;
            current = current.next;
        }
        return null;
    }
}

