package com.golovanov_andrey.homework1;

public class Main {
    public static void main(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        map.put("Alice", 25);
        map.put("Bob", 30);
        map.put("Charlie", 35);

        System.out.println(map.get("Bob")); //30
        System.out.println(map.get("Alice")); //25
        System.out.println(map.get("Eve")); //null

        map.remove("Bob");

        System.out.println(map.get("Bob")); //null
    }
}
