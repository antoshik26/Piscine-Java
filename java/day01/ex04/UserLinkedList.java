import java.util.UUID;

public class UserLinkedList {

    private Node head;
    private Node last;
    private int size;
    private class Node
    {
        private Node prev;
        private User data;
        private Node next;
        public Node(Node prev, User data, Node next)
        {
            this.prev = prev;
            this.data = data;
            this.next = next;
        }
    }

    public boolean UserLinkedListADD(User data)
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

    public User UserLinkedListFind(int _uuid)
    {
        int i = 0;
        for(Node temp = head;temp!=null;temp = temp.next) {
            if (temp.data.get_Identifier() == _uuid) {
                return temp.data;
            }
            i++;
        }
        return null;
    }

    public boolean remove(int _uuid){
        for(Node temp = head;temp!=null;temp = temp.next){
            if(temp.data.get_Identifier() == _uuid){
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

    public User[] toArray()
    {
        User[] arrayTransactions = new User[size];
        return (arrayTransactions);
    }

}
