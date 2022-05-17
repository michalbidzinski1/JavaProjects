package pl.michalbidzinski;

import org.junit.*;

import java.util.EmptyStackException;

import static org.junit.Assert.*;

public class StackTest {
    private Stack stack;
    @Before
    public void setup() {
        stack = new Stack(10);
    }
    @Test
    public void testAddingElementOnStack(){
        stack.push(10);
        assertEquals("Adding 10 to stack", 10, stack.peek());
    }
    @Test
    public void testPushAndPop(){

        stack.push(10);
        assertEquals("Push and Pop 10 to stack", 10, stack.pop());

    }
    @Test
    public void testPushTwoElementsPeekLast() {
        stack.push(1);
        stack.push(13);
        assertEquals( 13, stack.peek());
    }
    @Test
    public void testPushTwoElementsPopLast() {
        stack.push(1);
        stack.push(13);
        assertEquals( 13, stack.pop());
    }

    @Test(expected = EmptyStackException.class)
    public void testPopOnEmptyStack(){
        stack.pop();
    }
    @Test(expected = EmptyStackException.class)
    public void testPeekOnEmptyStack(){
        stack.peek();
    }
    @Test(expected = EmptyStackException.class)
    public void testTooManyPopException() {
        stack.push(13);
        stack.pop();
        stack.pop();
    }
    @Test
    public void test2PushAndPeek() {
        stack.push(1);
        stack.push(13);
        assertEquals( 13, stack.peek());
    }
    @Test
    public void testPushHundredElementsPopTheLastOne() {
        for (int i = 0; i < 100; i++) {
            stack.push(i);
        }
        assertEquals( 99, stack.pop());
    }
    @Test
    public void testIsStackEmptyTrue() {
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testIsStackEmptyFalse() {
        stack.push(3);
        assertFalse(stack.isEmpty());
    }




}
