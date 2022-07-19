import java.lang.reflect.Array;
import java.util.UUID;

public class TransactionsLinkedList {

    private Node head;
    private Node last;
    private int size;
    private class Node
    {
        private Node prev;
        private Transaction data;
        private Node next;
        public Node(Node prev, Transaction data, Node next)
        {
            this.prev = prev;
            this.data = data;
            this.next = next;
        }
    }

    public boolean TransactionsLinkedListADD(Transaction data)
    {
        Node temp = this.last;
        Node newNode = new Node(temp,data,null);
        this.last = newNode;
        if(head == null){
            this.head = newNode;
        }else{
            temp.next = newNode;
        }
        this.size++;
        return true;
    }

    public int TransactionsLinkedListFind(UUID _uuid)
    {
        int i = 0;
        for(Node temp = head;temp!=null;temp = temp.next) {
            if (temp.data.get_uuid().equals(_uuid)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public boolean remove(UUID _uuid){
        for(Node temp = head;temp!=null;temp = temp.next){
            if(temp.data.get_uuid().equals(_uuid)){
                unLike(temp);
                return true;
            }
        }
        return false;
    }

    private Object unLike(Node x){
        Object elementData = x.data;
        Node prev = x.prev;
        Node next = x.next;
        if(prev == null){
            this.head = next;
        }else{
            prev.next = next;
            x.prev = null;
        }
        if(next == null){
            this.last = prev;
        }else{
            next.prev = prev;
            x.next = null;
        }
        x.data = null;
        this.size--;
        return elementData;
    }

    public Transaction[] toArray()
    {
        int i = 0;
        Node newhead = head;
        Transaction[] arrayTransactions = new Transaction[size];
        while (i < size)
        {
            arrayTransactions[i] = newhead.data;
            i++;
            newhead = newhead.next;
        }
        return (arrayTransactions);
    }

}
