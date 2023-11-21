package fgw.L02_LinearDS.Stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListStack<E> implements AbstractStack<E> {
    private Node<E> top; // Top of the stack
    private int size; // Track the size of stack

    /**
     * METHODS
     */
    // Constructor
    public LinkedListStack( ) {
        top = null;
    }
    // Push an element onto the stack
    @Override
    public void push( E data ) {
        Node<E> newNode = new Node<>( data );
        if ( isEmpty( ) ) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
            size++;
        }
    }
    // Pop an element from the stack
    @Override
    public E pop( ) {
        if ( isEmpty( ) ) {
            throw new NoSuchElementException( );
        }

        E data = top.data;
        top = top.next;
        size--;
        return data;
    }
    // Peek at the top element without removing it
    @Override
    public E peek( ) {
        if ( isEmpty( ) ) {
            throw new NoSuchElementException( );
        }
        return top.data;
    }
    @Override
    public int size( ) {
        return size;
    }
    // Check if the stack is empty
    @Override
    public boolean isEmpty( ) {
        return top == null; // or size == 0
    }
    @Override
    public Iterator<E> iterator( ) {
        return new Iterator<E>( ) {
            Node<E> current = top;
            @Override
            public boolean hasNext( ) {
                return current != null;
            }

            @Override
            public E next( ) {
                if ( !hasNext( ) ) {
                    throw new NoSuchElementException( );
                }
                E data = current.data;
                current = current.next;
                return data;
            }
        };
    }
    @Override
    public String toString( ) {
        StringBuilder result = new StringBuilder( "[" );
        Node<E> current = top;

        while ( current != null ) {
            result.append( current.data );
            if ( current.next != null ) {
                result.append( ", " );
            }
            current = current.next;
        }

        result.append( "]" );
        return result.toString( );
    }
    private static class Node<E> {
        private E data;
        private Node<E> next;
        public Node( E data ) {
            this.data = data;
        }
    }
}

class LinkedListStackTest {
    public static void main( String[] args ) {
        /**
         * Integer Linked List
         */
        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>( );

        linkedListStack.push( 10 );
        linkedListStack.push( 20 );
        linkedListStack.push( 30 );

        System.out.println( "Peek: " + linkedListStack.peek( ) ); // Should print 30

        System.out.println( "Pop: " + linkedListStack.pop( ) ); // Should print 30
        System.out.println( "Pop: " + linkedListStack.pop( ) ); // Should print 20

        linkedListStack.push( 40 );

        System.out.println( "Peek: " + linkedListStack.peek( ) ); // Should print 40
        System.out.println( linkedListStack );

        /**
         * String Linked List
         */

        LinkedListStack<String> stringStack = new LinkedListStack<>( );
        stringStack.push( "Hello" );
        stringStack.push( "World" );

        System.out.println( stringStack.pop( ) ); // Should print "World"
        System.out.println( stringStack.peek( ) ); // Should print "Hello"
    }
}