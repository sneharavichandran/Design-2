//time complexity: m =slots in hashmap ,n = total keys Load factor α = n/m Expected time to search = O(1 + α),Expected time to delete = O(1 + α)
//space complexity: O(n)
class MyHashMap {
    class Node{
        int key;
        int val;
        Node next;
        public Node(int key, int val)
        {
            this.key=key;
            this.val=val;
        }
    }
        Node[] storage;
        int buckets;
    
    public MyHashMap() {
        buckets=10000;
        this.storage= new Node[buckets];
        
        
    }
    private int bucket(int key){
        return key% buckets;
    }
    private Node find(Node head, int key)
    {
        Node prev = null;
        Node curr = head;
        while(curr!=null && curr.key !=key)
        {
            prev=curr;
            curr=curr.next;
        }
        return prev;
    }
    public void put(int key, int val) {
        int bucket= bucket(key);
        if(storage[bucket]==null)
        {
            storage[bucket]= new Node(-1,-1);
        }
        Node prev= find(storage[bucket], key);
        if(prev.next == null)
        {
            prev.next= new Node(key, val);
        }
        else
        {
            prev.next.val= val;
        }
        
    }
    
    public int get(int key) {
        int bucket = bucket(key);
        if(storage[bucket]==null)return -1;
        Node prev= find(storage[bucket], key);
        if(prev.next==null) return -1;
        return prev.next.val;
        
    }
    
    public void remove(int key) {
        int bucket= bucket(key);
        if(storage[bucket]==null)return ;
        Node prev= find(storage[bucket], key);
        if(prev.next==null)return;
        prev.next= prev.next.next;
        
        
    }
    public static void main(String args[]) 
    { 
        MyHashMap mhm = new MyHashMap();  
        mhm.put(2, 121);
        
    }
}