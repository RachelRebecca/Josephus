/**
 * Class to implement a Generic circular linked list (implements the IGCLL interface)
 * @param <T>: the Generic type of Objects going in the GCList
 */
public class GCList<T> implements IGCLL<T>
{
    /**
     * creates a private Node - an element on the GCList
     * @param <T>: the info for the Node
     */
    private class Node<T>
    {
        private T info;
        private Node<T> next;

        Node(T value)
        {
            info = value;
            next = null;
        }

        //<editor-fold desc="Getters and Setters">

        public T getInfo()
        {
            return info;
        }

        public void setInfo(T info)
        {
            this.info = info;
        }

        public Node<T> getNext()
        {
            return next;
        }

        public void setNext(Node<T> next)
        {
            this.next = next;
        }
        //</editor-fold>  getters and setters
    }

    private Node<T> first = null;

    public GCList() {}

    /**
     * adds a new Node and make it first
     * @param value: the info for the new node being added
     */
    @Override
    public void addFirst(T value)
    {
        Node<T> newNode = new Node<>(value);
        if (first == null)
        {
            first = newNode;
            newNode.next = first;
        }
        else
        {
            Node<T> curr = first;
            while (curr.next != first)
                curr = curr.next;
            newNode.next = curr.next;// (current is pointing to first)
            curr.next = newNode;
            first = newNode;
        }
    }

    /**
     * checks if GCList contains a Node with the value as its info
     * @param value - value to check (of type T)
     * @return boolean: if value was found or not
     */
    public boolean contains(T value)
    {
        boolean success = false;
        if (first != null)
        {
            Node<T> curr = first;
            while (curr.next != first)
            {
                if (curr.info.equals(value))
                {
                    success = true;
                }
                curr = curr.next;
            }
            if (curr.info.equals(value))
            {
                success = true;
            }
        }
        return success;
    }

    /**
     * clears the GCList
     */
    public void clear()
    {
        first = null;
    }

    /**
     * checks if GCList is empty (if first is a null value)
     * @return boolean: if GCList is empty or not
     */
    public boolean isEmpty()
    {
        return (first == null);
    }

    /**
     * finds the size of the GCList
     * @return int: the number of nodes of the GCList up until the first for round two of the circular list
     */
    public int size()
    {
        int listSize = 0;
        if (first != null)
        {
            Node<T> curr = first;
            while (curr.next != first)
            {
                listSize++;
                curr = curr.next;
            }
            listSize++;
        }
        return listSize;
    }

    /**
     * removes the first node with info containing the value passed through method
     * @param value of type T - to be removed
     * @return boolean: if the Node containing info with the value was successfully removed
     */
    @Override
    public boolean remove(T value)
    {
        boolean success = false;
        if (first != null)
        {
            Node<T> curr = first;
            while (curr.next != first)
            {
                if (curr.next.info.equals(value))
                {
                    curr.next = curr.next.next;
                    success = true;
                    break;
                }
                else
                {
                    curr = curr.next;
                }
            }

            //while loop stops by the last element before the first in round two of circular list
            if (curr.next.getInfo().equals(value))
            {
                curr.next = curr.next.next; // curr.next should now be pointing to the second
                if (first.next != first) // if there is more afterward, point first to the second
                    first = curr.next;
                else // otherwise, there's only one element on the list, so just clear it
                    clear();
                success = true;
            }
        }
        return success;
    }

    /**
     * gets the first soldier on the GCList
     * @return the information of the first element on the GCList
     */
    public T getFirst()
    {
        T info = null;
        if (first != null)
        {
            info = first.getInfo();
        }
        return info;
    }

    /**
     * advance the first node by the count
     * @param count : int - number of places to advance first
     */
    @Override
    public void advance(int count)
    {
        int current = 0;
        Node<T> currNode = first;
        if (first != null)
        {
            while (current < count)
            {
                current++;
                currNode = currNode.next;
            }
            first = currNode;
        }
    }

    /**
     * represent GCList object as a String (trying to pass the GCListTest and match its expected value)
     * @return the info of all nodes in the GCList until after the first one of the second round of the circular list
     */
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        Node<T> current = first;
        builder.append("first->");
        if (first != null)
        {
            while (current.next != first)
            {
                builder.append("|").append(current.info).append("|").append("->");
                current = current.getNext();
            }
            //the new current is the one right before the first, so can't forget this information
            builder.append("|").append(current.info).append("|");

            if (size() > 1) //reprinted info of the first one to show that it's circular and to pass teh GCListTest
            {
                builder.append("->").append("|").append(first.info).append("|");
            }
        }
        return builder.toString();
    }
}
