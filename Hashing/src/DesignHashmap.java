import java.util.*;
public class DesignHashmap {
    static class HashMap<K,V>{
        private class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.key=key;
                this.value=value;
            }

        }
        private int n;
        private int N;
        private LinkedList<Node> buckets[];

        public HashMap(){
            this.N=4;
            this.buckets=new LinkedList[4];
            for(int i=0;i<N;i++){
                this.buckets[i]= new LinkedList<>(); // creating empty linked list
            }
        }
        private int hash(K key){
            int bi = key.hashCode();

            return Math.abs(bi)%N;
        }
        private int searchInLinkedList(K key, int bi){
            LinkedList<Node> ll = buckets[bi];
            for(int i=0;i<ll.size();i++){
                if(ll.get(i).key==key){
                    return i;//di
                }
            }
            return -1;
        }
        private void rehash(){
            LinkedList<Node> oldBucket[]=buckets;
            buckets=new LinkedList[N*2];
            for(int i=0;i<N*2;i++){
                buckets[i]= new LinkedList<>();
            }
            for(int i=0;i<oldBucket.length;i++){
                LinkedList<Node>ll=oldBucket[i];
                for(int j=0;j<ll.size();j++){
                    Node node = ll.get(j);
                    put(node.key,node.value);
                }
            }
        }
        public void put(K key, V value){
            // search bi
            int bi = hash(key);//black box

            // search di
            int di = searchInLinkedList(key,bi);// give data index
            if(di==-1){ // not there we have to create one
                buckets[bi].add(new Node(key,value));
                n++;
            }else{ // key exists
                Node data = buckets[bi].get(di);
                data.value=value;
            }
            double lambda = (double)n/N;
            if(lambda>2.0){
                //rehashing
                rehash();
            }
        }
        public boolean containsKey(K key){
            int bi = hash(key);//black box

            // search di
            int di = searchInLinkedList(key,bi);// give data index
            if(di==-1){ // not there we have to create one
                return false;
            }
            return true;
        }

        public V remove(K key){
            int bi = hash(key);//black box

            // search di
            int di = searchInLinkedList(key,bi);// give data index
            if(di==-1){ // not there we have to create one
                return null;
            }
            n--;
            Node node = buckets[bi].remove(di);
            return node.value;
        }
        public V get(K key){
            // search bi
            int bi = hash(key);//black box

            // search di
            int di = searchInLinkedList(key,bi);// give data index
            if(di==-1){ // not there we have to create one
                return null;
            }
            V val = buckets[bi].get(di).value;
            return val;

        }
        public boolean isEmpty(){
            return n==0;
        }
    }

    public static void main(String[] args) {
        HashMap<String,Integer> mp = new HashMap<>();
        mp.put("India",333);
        mp.put("China",149);
        mp.remove("India");
//        mp.remove("China");
        System.out.println(mp.isEmpty());
    }
}
