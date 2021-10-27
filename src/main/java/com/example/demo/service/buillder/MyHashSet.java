package com.example.demo.service.buillder;

import org.w3c.dom.Node;

import java.util.*;

/**
 * @author ranran.mao
 * @date 2021/8/25 17:41
 */
public class MyHashSet<k, v> implements Map<k, v> {
    /**
     * 最大容量，在两个带参数的构造函数隐式指定更高值时使用。 必须是 2 的幂 <= 1<<30。
     */
    static final int MAXIMUM_CAPACITY = 1 << 30;
    /**
     * 在构造函数中未指定时使用的负载因子。
     */
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public v get(Object key) {
        return null;
    }

    @Override
    public v put(k key, v value) {
        return null;
    }

    @Override
    public v remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends k, ? extends v> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<k> keySet() {
        return null;
    }

    @Override
    public Collection<v> values() {
        return null;
    }

    @Override
    public Set<Entry<k, v>> entrySet() {
        return null;
    }

    static class Node<K, V> implements Map.Entry<K, V> {
        final int hash;
        final K key;
        V value;
        Node<K, V> next;

        Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public final K getKey() {
            return key;
        }

        @Override
        public final V getValue() {
            return value;
        }

        @Override
        public final String toString() {
            return key + "=" + value;
        }

        @Override
        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

        /**
         * 返回原有的value并设置好新的value
         */
        @Override
        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        @Override
        public final boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (o instanceof Map.Entry) {
                Map.Entry<?, ?> e = (Map.Entry<?, ?>) o;
                if (Objects.equals(key, e.getKey()) && Objects.equals(value, e.getValue())) {
                    return true;
                }
            }
            return false;
        }
    }

    public final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    transient Node<k, v>[] table;
    transient Set<Map.Entry<k, v>> entrySet;
    transient int size;
    transient int modCount;
    /**
     * 要调整大小的下一个大小值（容量 * 负载因子）
     */
    int threshold;
    /**
     * hash表的加载因子
     */
    final float loadFactor;

    /**
     * 构造函数:initialCapacity设定初始hash表容量大小，为2的n次幂
     * loadFactor设定表的加载因子，当前表的容量超过加载因子范围后，扩容hash表。
     */
    public MyHashSet(int initialCapacity, float loadFactor) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal initial capacity:" + initialCapacity);
        }
        if (initialCapacity > MAXIMUM_CAPACITY) {
            initialCapacity = MAXIMUM_CAPACITY;
        }
        if (loadFactor <= 0 || Float.isNaN(loadFactor)) {
            throw new IllegalArgumentException("Illegal load factor: " + loadFactor);
        }
        this.loadFactor = loadFactor;
        this.threshold = tableSizeFor(initialCapacity);
    }

    public MyHashSet(int initialCapacity) {
        this(initialCapacity, DEFAULT_LOAD_FACTOR);
    }

    public MyHashSet() {
        this.loadFactor = DEFAULT_LOAD_FACTOR;
    }
    public MyHashSet(Map<? extends k,? extends v> m){
        this.loadFactor=DEFAULT_LOAD_FACTOR;
    }
    /**
     * 实现 Map.putAll 和 Map 构造函数。
     * 参数：
     * m——地图
     * evict – 最初构造此映射时为 false，否则为 true（中继到方法 afterNodeInsertion）
     */
    final void putMapEntries(Map<? extends k,? extends v> m,boolean evict){
        int s=m.size();
        if (s>0){
            if (table==null){
                float ft=((float) s/loadFactor)+1.0F;
                int t = ((ft < (float)MAXIMUM_CAPACITY) ?
                        (int)ft : MAXIMUM_CAPACITY);
                if (t>threshold){
                    threshold=tableSizeFor(t);
                }
            }else if(s>threshold){

            }
        }
    }
    final Node<k,v>[] resize(){
        Node<k,v>[] oldTab=table;
        int oldCap=(oldTab==null)?0:oldTab.length;
        int oldThr=threshold;
        int newCap,newThr=0;
        if (oldCap>0){
            if (oldCap>=MAXIMUM_CAPACITY){
                threshold=Integer.MAX_VALUE;
                return oldTab;
            }
            else if ((newCap=oldCap<<1)<MAXIMUM_CAPACITY&&oldCap>=DEFAULT_INITIAL_CAPACITY){
                newThr=oldThr<<1;
            }
        }else if(oldThr>0){
            newCap=oldThr;
        }else {
            newCap=DEFAULT_INITIAL_CAPACITY;
            newThr=(int) (DEFAULT_LOAD_FACTOR*DEFAULT_INITIAL_CAPACITY);
        }
        if (newThr==0){
            float ft=(float) newCap*loadFactor;
            newThr=(newCap<MAXIMUM_CAPACITY&&ft<(float) MAXIMUM_CAPACITY ?(int) ft:Integer.MAX_VALUE);
        }
        return null;
    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    public static void main(String[] args) {
        System.out.println(MyHashSet.tableSizeFor(1023));
    }
}
