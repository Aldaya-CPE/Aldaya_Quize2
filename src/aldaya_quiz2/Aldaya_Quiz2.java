package aldaya_quiz2;
import java.util.LinkedList;
import java.util.Scanner;

class Node{
int data;
Node next;

     Node(int m) {
        
         data = m;
         next = null;
     }
}


public class Aldaya_Quiz2 {
    private class Node {
        int data;
        Node next;
    }
      
    public Node insertNode(int data){
        
    Node newNode = new Node();
    newNode.next = head;
    head = newNode;
    
        return head;
    }
    
    
    public void display1(){
        Node node = head;
        
        while (node != null) {            
            System.out.println(node.data + ",");
            node = node.next;
        }
        System.out.println("");
    }
    
    
    
    public boolean search(int target){
        Node current = head;
        
            while (current != null) {            
                if (current.data == target) {
                    return true;
                }
                current = current.next;
        }
        
        return false;
    }
    
    public int searchPosition(int target){
    Node current = head;
    int pos = 0;
    
        while (current != null) {            
            if (current.data == target) {
                return pos;
                
            }
            current = current.next;
            pos++;
        }
        return -1;
    }
    
    
     
    private static Node head, tail;
    private int size;

    private Node createNewNode(int index) {
        Node node = new Node();
        node.data = index;
        node.next = null;
        return node;
    }

    private void insertBeg(int index) {
        Node node = createNewNode(index);

        if (size == 0) {
            head = tail = node;
        } else {
            node.next = head;
            head = node;
        }

        tail.next = head;
        size++;
    }

    private void insertEnd(int index) {
        Node node = createNewNode(index);

        if (size == 0) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }

        tail.next = head;
        size++;
    }
    
    private void insertAtPosition(int index, int position) throws Exception {
        if (position < 0 || position > size) {
            throw new Exception("Invalid position");
        } else if (position == 0) {
            insertBeg(index);
        } else if (position == size) {
            insertEnd(index);
        } else {
            Node node = createNewNode(index);
            Node current = head;

            for (int i = 0; i < position - 1; i++) {
                current = current.next;
            }

            node.next = current.next;
            current.next = node;
            size++;
        }
    }
    
    
    
    

    private void display() {
        if (size == 0) {
            System.out.println("List is empty");
            return;
        }

        Node current = head;

        do {
            System.out.print(current.data + " -> ");
            current = current.next;
        } while (current != head);
        

        System.out.println();
    }

    public static void main(String[] args) throws Exception {
      Aldaya_Quiz2 circularList = new Aldaya_Quiz2();
        Scanner scn = new Scanner(System.in);
         
        while (true) {
            System.out.println("\nCircular Linked List:");
            System.out.println("1. Insert at a Position");
            System.out.println("2. Display Singly Linkedlist");
            System.out.println("3. Display Circular Linkedlist");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scn.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the element to insert: ");
                    int element3 = scn.nextInt();
                    System.out.print("Enter the position to insert at: ");
                    int position = scn.nextInt();
                    circularList.insertAtPosition(element3, position);
                    break;
                case 2:
                    circularList.insertNode(1000);
                    circularList.insertNode(2000);
                    circularList.insertNode(3000);
                    circularList.insertNode(666);
                    circularList.display1();
                    System.out.println("===========================");
                    System.out.println("===========================");
                        
                    System.out.println("Inter element search");
                    
                    int search = scn.nextInt();
                    int targerVal = search;

                    int posi = circularList.searchPosition(targerVal);

                    if (posi != -1) {
                        System.out.println(targerVal + "Here in" + posi);
                    } else {
                        System.out.println("The"+ targerVal + "is not here");
                    }
                    break;
                    
                case 3:
                    System.out.println("Circular Linked List:");
                    circularList.display();
                    break;

                case 4:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
            }
        }
        
        
        
        
        
        
    }
}

