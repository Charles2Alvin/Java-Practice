package interview;

import innerclasses.SimpleInterface;

import java.util.Objects;

class Node<K,V> {
    final K key;
    V value;
    Node<K,V> next;
    final int hash;
    //构造器
    public Node(K key, V value, int hash, Node<K, V> next) {
        this.key = key;
        this.value = value;
        this.hash = hash;
        this.next = next;
    }
    //getter and toString
    public final K getKey() {return key;}
    public final V getValue() {return value;}
    public final String toString() {return key+"="+value;}
    //setter
    public final V setValue(V newValue) {
        V oldValue = value;
        value = newValue;
        return oldValue;
    }
    //hashCode
    public final int hashCode() {
        return Objects.hashCode(key) ^ Objects.hashCode(value);
    }
    //equals
    public final boolean equals(Object o) {
        if (o == this) return true;
        return false;
    }
}
public class SimpleMap<K,V> {
    //默认的初始容量
    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;
    //最大容量
    static final int MAXIMUM_CAPACITY = 1 << 30;
    //默认的填充因子
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    //当前的填充因子
    final float loadFactor;
    //阈值
    int threshold;

    //存放元素的桶
    Node<K, V>[] table;

    public SimpleMap() {
        loadFactor = DEFAULT_LOAD_FACTOR;
    }
    public V put(K key, V value) {
        //n是桶的长度
        Node<K, V>[] tab; Node<K ,V> p; int n, hash = hash(key);
        //如果table是空的，调用扩容函数
        if ((tab = table) == null || (n = table.length) == 0) {
            //返回桶数组的引用
            tab = resize();
            n = tab.length;
        }
        //找出应该插入到数组的哪个桶
        int position = (n - 1) & hash;
        //p是临时链表节点
        p = tab[position];
        //如果要插入的是个空节点，那就创建一个新的
        if (p == null)
            tab[position] = new Node<>(key, value, hash,null);
        else {
            //发生冲突，用拉链法解决冲突；p是桶的首节点，e用来记录链上要插入的节点
            Node<K, V> e;
            //如果这个桶的元素有相同的key, 那就覆盖
            if (p.hash == hash && p.key == key) e = p;
            else {
                for (int count = 0; ; count++) {
                    e = p.next;
                    if (e == null) {
                        //说明到达了链表的尾部
                        System.out.println("插入成功！键: " + key + " 值: "+
                                value + " 插入点: "+position+ " 链表尾部，" +
                                "链表长度: "+(count+1));
                        p.next = new Node<>(key, value, hash, null);
                        break;
                    }
                    if (e.hash == hash && e.key == key) {
                        System.out.println("插入成功！键: " + key + " 值: "+
                                value + " 插入点: "+position + " 在链表上插入" +
                                "链表长度: "+(count+1));
                        //遍历过程中遇到key相同的
                        break;
                    }
                    //另类的遍历方式，用两个指针
                    p = e;
                }
            }
            //已经找到了插入的位置，也就是e
            if (e != null) {
                //先保存旧值，最后返回
                V oldVal = e.value;
                e.value = value;
                return oldVal;
            }

            //System.out.println("插入失败！存在元素 "+tab[position]+" ，插入点: "+position);
            return null;
        }
        System.out.println("插入成功！键: " + key + " 值: "+ value + " 插入点: "+position);
        return value;
    }
    public V get(K key) {
        //tab用来操作数组，first是桶的首元素
        Node<K, V>[] tab; Node<K, V> first, e; int hash = hash(key), n;
        //如果数组是空的，就不用找了
        if ((tab = table) != null && (n = tab.length) > 0 &&
                (first = tab[(n-1)&hash]) != null) {
            //先判断首元素
            if (first.hash == hash && first.key == key) {
                System.out.println("找到节点！键: "+key+" 值: "+first.value+" 位于桶首位");
                return first.value;
            }
            //如果桶里不止一个节点
            if ((e = first.next) != null) {
                while (e != null) {
                    if (e.hash == hash && e.key == key) {
                        System.out.println("找到节点！键: "+key+" 值: "+first.value+" 在链表上");
                        return e.value;
                    }
                    e = e.next;
                }
            }
        }
        return null;
    }
    public Node[] resize(){
        Node<K, V>[] oldTab = table;
        //记录当前容量是多少
        int oldCap = (oldTab == null)? 0 : oldTab.length;
        //记录当前触发扩容的阈值
        int oldThr = threshold;
        //初始化新的容量和阈值
        int newCap = 0, newThr = 0;
        newCap = oldCap;
        //需要确定扩容到多大的新数组，也就是新的容量是多少
        if (oldCap > 0) {
            //如果超出容量，不允许扩容
            if (oldCap > MAXIMUM_CAPACITY) {
                threshold = Integer.MAX_VALUE;
                return oldTab;
            }
            //没超过最大值就扩充为原来的两倍
            else {
                newCap = oldCap << 1;
                //如果当前容量超出了默认容量16，那么阈值也要double
                if (oldCap > DEFAULT_INITIAL_CAPACITY)
                    newThr = oldThr << 1;
            }
        } else if (oldThr > 0) {//表是空的，但是有设置过阈值，说明调用了带参的构造器
            newCap = oldThr;

        } else {//表明当前表是空的，也没有阈值
            newCap = DEFAULT_INITIAL_CAPACITY;
            newThr = (int) (DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);

        }
        Node<K, V>[] newTab = (Node<K, V>[]) new Node[newCap];

        //更新引用
        threshold = newThr;
        table = newTab;
        //下面开始转移所有的元素到新桶
        return newTab;
    }
    //hash的扰动函数
    public int hash(K key) {
        int h;
        return key == null? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

}
class MapTestDrive {
    public static void main(String[] args) {
        SimpleMap<String, Integer> map = new SimpleMap<>();
        map.put("a",1);
        map.put("bb",1);
        map.put("ccc",1);
        map.put("d",1);
        map.put("ee",1);
        map.put("fff",1);
        map.put("g",1);
        map.put("hh",2);
        map.put("iii",3);
        map.put("j",1);
        map.put("kk",2);
        map.put("lll",3);
        map.get("a");
        map.get("iii");
        map.get("hh");
    }
}