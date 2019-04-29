package interview;

/**
 * 最简单的哈希表，只含有put()和get()方法，默认长度为16，不支持扩容，拉链法解决冲突
 * @author  <mohaitao>
 * @version  <1.0>
 */
public class SuperSimpleMap<K, V> {
    static final int DEFAULT_CAPACITY = 1 << 4;
    static final float DEFAULT_LOAD_FACTOR = 0.75f;

    Node<K, V>[] table = (Node<K, V>[]) new Node[DEFAULT_CAPACITY];
    public int hash(K key) {
        int h;
        return (key == null)? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
    public V put(K key, V value) {
        Node<K, V>[] tab = table; Node<K, V> p; int n = table.length, hash = hash(key), i;
        //先判断首节点是不是空的
        if ((p = tab[(i = (n - 1) & hash)]) == null) {
            tab[i] = new Node<>(key, value, hash, null);
            System.out.println("插入成功！键: " + key + " 值: "+ value + " 插入点: "+i+" 桶首位");
        } else {
            Node<K, V> e;
            //先判断首节点是否符合
            if (p.hash == hash && p.key == key) {
                System.out.println("插入成功！键: " + key + " 值: "+ value + " 插入点: "+i+" 桶首位");
                e = p;
            }
            //不符合就插入到链表
            else {
                for (int count = 0; ; count++) {
                    e = p.next;
                    //遍历到尾部
                    if (e == null) {
                        p.next = new Node<>(key, value, hash, null);
                        System.out.println("插入成功！键: " + key + " 值: "+ value +
                                " 插入点: "+i+" 链表尾部"+ " 链表长度: "+(count+1));

                        break;
                    }
                    //遍历过程找到键值相同的，覆盖旧值
                    if (e.hash == hash && e.key == key) {
                        System.out.println("插入成功！键: " + key + " 值: "+ value +
                                " 插入点: "+i+"链表中间"+ " 链表长度: "+(count+1));
                        break;
                    }
                    p = e;
                }
            }
            if (e != null) {
                V oldVal = e.value;
                e.value = value;
                return oldVal;
            }
        }
        //System.out.println("找不到插入点...");
        return value;
    }
    public V get(K key) {
        Node<K, V>[] tab; Node<K, V> first, e; int hash = hash(key), n;
        //如果表是空的，或者对应的桶是空的，就不用找了
        if ((tab = table) != null && (n = table.length) > 0 &&
                (first = tab[(n - 1) & hash]) != null) {
            //先判断首元素
            if (first.hash == hash && first.key == key) return first.value;
            if ((e = first.next) != null) {
                while (e != null) {
                    if (e.hash == hash && e.key == key) return e.value;
                    e = e.next;
                }
            }
        }
        return null;
    }
}
class SuperSimpleMapTestDrive {
    public static void main(String[] args) {
        SuperSimpleMap<String, Integer> map = new SuperSimpleMap<>();
        map.put("a",1);
        map.put("bb",3);
        map.put("ccc",5);
        map.put("d",7);
        map.put("ee",5);
        map.put("fff",6);
        map.put("g",7);
        map.put("hh",8);
        map.put("iii",9);
        map.put("j",10);
        map.put("kk",11);
        map.put("lll",12);

        map.get("a");
        //覆盖a的值
        map.put("a",2);
        map.get("a");
        map.get("iii");
        map.get("hh");
    }
}