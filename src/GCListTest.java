
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * superficial minimal jUnit test for a generic Circular Linked List
 *
 * @author Katz9
 */
public class GCListTest
{

    private class Twofer
    {

        int num;
        String str;

        Twofer(int a, String b)
        {
            num = a;
            str = b;
        }

        public boolean equals(Object other)
        {
            return other != null
                    && other instanceof Twofer
                    && ((Twofer) other).num == num
                    && ((Twofer) other).str.equalsIgnoreCase(str);
        }

        public String toString()
        {
            return str + num;
        }

    }

    public GCListTest()
    {
    }

    /**
     * Test of addFirst method, of class GCList.
     */
    @Test
    public void testAddFirst()
    {
        System.out.println("addFirst");
        GCList<Twofer> instance = new GCList<>();
        Twofer one = new Twofer(1, "one");
        instance.addFirst(one);
        assertEquals(instance.toString(), "first->|one1|");
        Twofer two = new Twofer(2, "two");
        instance.addFirst(two);
        assertEquals("first->|two2|->|one1|->|two2|", instance.toString());
        Twofer thr = new Twofer(3, "thr");
        instance.addFirst(thr);
        assertEquals("first->|thr3|->|two2|->|one1|->|thr3|", instance.toString());
    }

    /**
     * Test of contains method, of class GCList.
     */
    @Test
    public void testContains()
    {
        System.out.println("contains");
        GCList<Twofer> instance = new GCList<>();
        boolean expResult = false;
        // empty list
        boolean result = instance.contains(new Twofer(1, "one"));
        assertEquals(expResult, result);

        Twofer one = new Twofer(1, "one");
        Twofer two = new Twofer(2, "two");
        Twofer thr = new Twofer(3, "thr");

        // list of size 1
        instance.addFirst(one);
        assertEquals(false, instance.contains(new Twofer(1, "fiv")));
        assertEquals(true, instance.contains(new Twofer(1, "one")));

        // list of size 2
        instance.addFirst(two);
        assertEquals(false, instance.contains(new Twofer(1, "fiv")));
        assertEquals(true, instance.contains(new Twofer(1, "one")));
        assertEquals(true, instance.contains(new Twofer(2, "two")));

        // list of size 3
        instance.addFirst(thr);
        assertEquals(false, instance.contains(new Twofer(1, "fiv")));
        assertEquals(true, instance.contains(new Twofer(1, "one")));
        assertEquals(true, instance.contains(new Twofer(2, "two")));
        assertEquals(true, instance.contains(new Twofer(3, "thr")));
    }

    /**
     * Test of clear method, of class GCList.
     */
    @Test
    public void testClear()
    {
        System.out.println("clear");
        GCList<Twofer> instance = new GCList<>();
        instance.clear();
        assertEquals(0, instance.size());

        Twofer one = new Twofer(1, "one");
        Twofer two = new Twofer(2, "two");
        Twofer thr = new Twofer(3, "thr");
        instance.addFirst(thr);
        instance.addFirst(two);
        instance.addFirst(one);
        assertEquals(3, instance.size());
        instance.clear();
        assertEquals(0, instance.size());

    }

    /**
     * Test of isEmpty method, of class GCList.
     */
    @Test
    public void testIsEmpty()
    {
        System.out.println("isEmpty");
        GCList<Twofer> instance = new GCList<>();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);

        Twofer one = new Twofer(1, "one");
        Twofer two = new Twofer(2, "two");
        instance.addFirst(two);
        assertEquals(false, instance.isEmpty());

        instance.addFirst(one);
        assertEquals(false, instance.isEmpty());
    }

    /**
     * Test of getFirst method, of class GCList.
     */
    @Test
    public void testGetFirst()
    {
        System.out.println("getFirst");
        GCList<Twofer> instance = new GCList<>();
        Object expResult = null;
        Twofer result = instance.getFirst();
        assertEquals(expResult, result);

        Twofer one = new Twofer(1, "one");
        Twofer two = new Twofer(2, "two");
        Twofer thr = new Twofer(3, "thr");

        // list of size 1
        instance.addFirst(one);
        result = instance.getFirst();
        assertEquals(true, result.equals(new Twofer(1, "one")));

        // list of size 2
        instance.addFirst(two);
        result = instance.getFirst();
        assertEquals(true, result.equals(new Twofer(2, "two")));

        // list of size 3
        instance.addFirst(thr);
        result = instance.getFirst();
        assertEquals(true, result.equals(new Twofer(3, "thr")));

    }

    /**
     * Test of remove method, of class GCList.
     */
    @Test
    public void testRemove()
    {
        System.out.println("remove");
        GCList<Twofer> instance = new GCList<>();
        boolean expResult = false;
        // empty list
        boolean result = instance.remove(new Twofer(1, "one"));
        assertEquals(expResult, result);

        Twofer one = new Twofer(1, "one");
        Twofer two = new Twofer(2, "two");
        Twofer thr = new Twofer(3, "thr");

        // list of size 1
        instance.addFirst(one);
        assertEquals(false, instance.remove(new Twofer(1, "fiv")));
        assertEquals(true, instance.remove(new Twofer(1, "one")));
        assertEquals(0, instance.size());

        // list of size 2
        instance.addFirst(one);
        instance.addFirst(two);
        assertEquals(false, instance.remove(new Twofer(1, "fiv")));
        assertEquals(true, instance.remove(new Twofer(1, "one")));
        assertEquals(1, instance.size());
        assertEquals(true, instance.remove(new Twofer(2, "two")));
        assertEquals(0, instance.size());

        // list of size 3
        instance.addFirst(one);
        assertEquals(1, instance.size());
        instance.addFirst(two);
        assertEquals(2, instance.size());
        instance.addFirst(thr);
        assertEquals(3, instance.size());
        assertEquals(false, instance.remove(new Twofer(1, "fiv")));
        assertEquals(3, instance.size());
        assertEquals(true, instance.remove(new Twofer(2, "two")));
        assertEquals(2, instance.size());
        assertEquals(true, instance.remove(new Twofer(3, "thr")));
        assertEquals(1, instance.size());
        assertEquals(true, instance.remove(new Twofer(1, "one")));
        assertEquals(0, instance.size());
    }

    /**
     * Test of advance method, of class GCList.
     */
    @Test
    public void testAdvance()
    {
        System.out.println("advance");
        int count = 2;
        GCList<Twofer> instance = new GCList<>();
        instance.advance(count);
        Twofer result = instance.getFirst();
        assertEquals(null, result);

        Twofer one = new Twofer(1, "one");
        Twofer two = new Twofer(2, "two");
        Twofer thr = new Twofer(3, "thr");
        Twofer fou = new Twofer(4, "fou");
        Twofer fiv = new Twofer(5, "fiv");
        instance.addFirst(fiv);
        instance.addFirst(fou);
        instance.addFirst(thr);
        instance.addFirst(two);
        instance.addFirst(one);

        instance.advance(0);
        result = instance.getFirst();
        assertEquals(true, result.equals(new Twofer(1, "one")));
        instance.advance(1);
        result = instance.getFirst();
        assertEquals(true, result.equals(new Twofer(2, "two")));
        instance.advance(2);
        result = instance.getFirst();
        assertEquals(true, result.equals(new Twofer(4, "fou")));
        instance.advance(3);
        result = instance.getFirst();
        assertEquals(true, result.equals(new Twofer(2, "two")));
    }

    /**
     * Test of size method, of class GCList.
     */
    @Test
    public void testSize()
    {
        System.out.println("size");
        GCList<Twofer> instance = new GCList<>();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);

        Twofer one = new Twofer(1, "one");
        Twofer two = new Twofer(2, "two");
        Twofer thr = new Twofer(3, "thr");
        instance.addFirst(one);
        assertEquals(1, instance.size());

        instance.addFirst(two);
        assertEquals("first->|two2|->|one1|->|two2|", instance.toString());
        assertEquals(2, instance.size());

        instance.addFirst(thr);
        assertEquals(3, instance.size());
    }

    /**
     * Test of toString method, of class GCList.
     */
    @Test
    public void testToString()
    {
        System.out.println("toString");
        GCList instance = new GCList();
        String expResult = "first->";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

}
