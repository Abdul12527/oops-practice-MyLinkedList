package org.example;

public class DefaultMyList<E> implements MyList{
    Node<E> head=null;
    Node<E> tail=null;

    int size=0;

    @Override
    public void add(Object o) {
        Node node=new Node<>(o);
        if(head==null){
            head=node;
            tail=node;
            size++;
            return;
        }
        tail.next=node;
        tail=tail.next;
    }

    @Override
    public void clear() {
        head=null;
        tail=null;
        size=0;
    }

    @Override
    public boolean remove(Object o) {
        Node temp=head;
        if(temp.data.equals(o)){
            head=head.next;
            size--;
            return true;
        }
        while(temp.next!=null){
            if(size==0)return false;
            if(temp.next.data.equals(o)){
                temp.next=temp.next.next;
                size--;
                return true;
            }
            temp=temp.next;
        }

        return false;
    }

    @Override
    public Object[] toArray() {
        Object[] ans=new Object[size];
        int index=0;
        Node temp=head;
        while(temp!=null){
            ans[index++]=temp.data;
            temp=temp.next;
        }
        return ans;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object o) {
        Node temp=head;
        while(temp!=null){
            if(temp.data.equals(o))return true;
            temp=temp.next;
        }
        return false;
    }

    @Override
    public boolean containsAll(MyList c) {
        Object[] arr=c.toArray();
        for(Object i:arr){
            if(!contains(i))return false;
        }
        return true;
    }
}
