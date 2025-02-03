package src.com.problems.hash;
import java.util.LinkedList;
public class HashImplement<K, V> {

        private LinkedList<Entry<K, V>>[] map;
        @SuppressWarnings("unchecked")
        public HashImplement(int size) {
            map = new LinkedList[size];
            for (int i = 0; i < size; i++) map[i] = new LinkedList<>();
        }
        private static class Entry<K, V> {
            K key;
            V value;
            Entry(K key, V value) { this.key = key; this.value = value; }
        }
        private int hash(K key) { return Math.abs(key.hashCode()) % map.length; }
        public void insert(K key, V value) {
            int index = hash(key);
            LinkedList<Entry<K, V>> bucket = map[index];
            for (Entry<K, V> entry : bucket) {
                if (entry.key.equals(key)) { entry.value = value; return; }
            }
            bucket.add(new Entry<>(key, value));
        }
        public V retrieve(K key) {
            int index = hash(key);
            for (Entry<K, V> entry : map[index]) {
                if (entry.key.equals(key)) return entry.value;
            }
            return null;
        }
        public boolean delete(K key) {
            int index = hash(key);
            for (Entry<K, V> entry : map[index]) {
                if (entry.key.equals(key)) { map[index].remove(entry); return true; }
            }
            return false;
        }
        public String toString() {
            StringBuilder sb = new StringBuilder("{");
            for (LinkedList<Entry<K, V>> bucket : map) {
                for (Entry<K, V> entry : bucket) {
                    sb.append(entry.key).append(": ").append(entry.value).append(", ");
                }
            }
            if (sb.length() > 1) sb.setLength(sb.length() - 2);
            sb.append("}");
            return sb.toString();
        }
        public static void main(String[] args) {
            HashImplement<String, String> hm = new HashImplement<>(10);
            hm.insert("name", "Pankaj");
            hm.insert("age", "21");
            System.out.println(hm.retrieve("name"));
            System.out.println(hm.delete("age"));
            System.out.println(hm);
        }
    }
    