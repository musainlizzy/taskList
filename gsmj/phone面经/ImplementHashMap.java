package phone面经;

/**
 * Created by lizzie on 10/30/18.
 */
public class ImplementHashMap {
    class Node{
        String key;
        Integer val;
        Node next;
        public Node(String key, Integer val){
            this.key = key;
            this.val = val;
        }
    }

    private int size = 3;
    private Node[] array;
    public ImplementHashMap() {
        array = new Node[size];
    }

    public void put(String key, Integer value){
        int index = key.hashCode()%this.size;
        System.out.println("index is:"+index);
        Node node = array[index];
        while(node!=null) {
            if(node.key.equals(key)){
                node.val = value;
                return;
            } else {
                node = node.next;
            }
        }

        // add new entry to the beginning of the bucket;
        Node newnode = new Node(key,value);
        newnode.next = array[index];
        array[index] = newnode;
        return;
    }

    public Integer get(String key){
        int index = key.hashCode()%this.size;
        Node node = array[index];
        while(node!=null){
            if(node.key.equals(key)){
                return node.val;
            } else {
                node = node.next;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ImplementHashMap hashmap = new ImplementHashMap();

        hashmap.put("a", 2);
        System.out.println(hashmap.get("a"));

        hashmap.put("b", 5);
        System.out.println(hashmap.get("b"));

        hashmap.put("c", 7);
        System.out.println(hashmap.get("c"));

        hashmap.put("d", 8);
        System.out.println(hashmap.get("d"));

        hashmap.put("e", 9);
        System.out.println(hashmap.get("e"));

        hashmap.put("f", 10);
        System.out.println(hashmap.get("f"));

    }

}

