package HW_seminar_3;

 import java.util.*;
 import java.io.*;

public class connected_list_reversal_method{
    class GFG {
      
        class Node {
            char data;
            Node next;
            Node pre;
            Node(char data)
            {
                this.data = data;
                pre = null;
                next = null;
            }
        }
      
        Node head = null;
      
        public void insertAtHead(char data)
        {
            Node n = new Node(data);
            if (head == null) {
                head = n;
                return;
            }
            n.next = head;
            head.pre = n;
            head = n;
        }
      
        public void insertAtTail(char data)
        {
            if (head == null) {
                insertAtHead(data);
                return;
            }
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            Node n = new Node(data);
            temp.next = n;
            n.pre = temp;
        }
      
        // Function to print the list.
        public void display()
        {
            Node curr = head;
            while (curr != null) {
                System.out.print(curr.data + "-->");
                curr = curr.next;
            }
            System.out.print("NULL\n\n");
        }
      
        public void rotateByN(int pos)
        {
            if (pos == 0) {
                return;
            }
            Node curr = head;
            while (pos != 0) {
                curr = curr.next;
                pos--;
            }
            Node tail = curr.pre;
            Node NewHead = curr;
            tail.next = null;
            curr.pre = null;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = head;
            head.pre = curr;
            head = NewHead;
        }
      
        public void main(String[] args)
        {
            GFG list = new GFG();
      
            list.insertAtTail('a');
            list.insertAtTail('b');
            list.insertAtTail('c');
            list.insertAtTail('d');
            list.insertAtTail('e');
      
            int n = 2;
            System.out.print("Before Rotation : \n");
            list.display();
            
            list.rotateByN(n);
            System.out.print("After Rotation : \n");
            list.display();
        }
    }

}