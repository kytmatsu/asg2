/*
 * Kyle Matsumoto
 * kytmatsu
 * CMPS012B
 * 11/5/14
 * This is the tester class for Dllist it has the assigned tests in it.
 * */

import org.junit.*;
import static org.junit.Assert.assertEquals;

public class dllistTest {

    @Test
    public void startsEmptyTest() {
        dllist lst = new dllist();
        assertEquals(true, lst.isEmpty());
    }
    @Test
    public void empty() {
        dllist lst = new dllist();
        lst.insert("hi",dllist.position.LAST);
        lst.isEmpty();
        assertEquals(false, lst.isEmpty());
    }
    @Test
    public void getitem() {
        dllist lst = new dllist();
        lst.insert("hi",dllist.position.LAST);
        lst.getItem();
        assertEquals("hi", lst.getItem());
    }
    
    @Test
    public void first() {
        dllist lst = new dllist();
        lst.insert("hi",dllist.position.FIRST);
        lst.insert("hey",dllist.position.FIRST);
        lst.getItem();
        assertEquals("hey", lst.getItem());
    }
    @Test
    public void setPos() {
        dllist lst = new dllist();
        lst.insert("hi",dllist.position.LAST);
        lst.insert("hey",dllist.position.LAST);
        lst.setPosition(dllist.position.FIRST);
        assertEquals("hi", lst.getItem());
    }
    
    @Test
    public void setPos2() {
        dllist lst = new dllist();
        lst.insert("hi",dllist.position.FIRST);
        lst.insert("hey",dllist.position.FIRST);
        lst.setPosition(dllist.position.LAST);
        assertEquals("hi", lst.getItem());
    }
    @Test
    public void buildList() {
        dllist lst = new dllist();
        lst.insert("A",dllist.position.LAST);
        lst.insert("B",dllist.position.LAST);
        lst.insert("C",dllist.position.LAST);
        lst.insert("D",dllist.position.PREVIOUS);
        lst.setPosition(dllist.position.LAST);
        assertEquals("C", lst.getItem());
    }
    @Test
    public void buildList2() {
        dllist lst = new dllist();
        lst.insert("A",dllist.position.FIRST);
        lst.insert("B",dllist.position.FIRST);
        lst.insert("C",dllist.position.FIRST);
        lst.insert("D",dllist.position.FOLLOWING);
        lst.setPosition(dllist.position.FIRST);
        assertEquals("C", lst.getItem());
    }

    @Test
    public void randList() {
        dllist lst = new dllist();
        lst.insert("A",dllist.position.FIRST);
        lst.insert("B",dllist.position.PREVIOUS);
        lst.insert("C",dllist.position.FOLLOWING);
        lst.insert("D",dllist.position.PREVIOUS);
        lst.insert("E", dllist.position.LAST);
        lst.setPosition(dllist.position.FIRST);
        assertEquals("B", lst.getItem());
        lst.setPosition(dllist.position.FOLLOWING);
        assertEquals("D",lst.getItem());
        lst.setPosition(dllist.position.FOLLOWING);
        assertEquals("C",lst.getItem());
        lst.setPosition(dllist.position.FOLLOWING);
        assertEquals("A",lst.getItem());
        lst.setPosition(dllist.position.FOLLOWING);
        assertEquals("E",lst.getItem());
    }
    
    @Test
    public void randList2() {
    	dllist lst = new dllist();
        lst.insert("A",dllist.position.FIRST);
        lst.insert("B",dllist.position.PREVIOUS);
        lst.insert("C",dllist.position.FOLLOWING);
        lst.insert("D",dllist.position.PREVIOUS);
        lst.insert("E", dllist.position.LAST);
        lst.setPosition(dllist.position.FIRST);
        assertEquals("B", lst.getItem());
        lst.setPosition(dllist.position.FOLLOWING);
        assertEquals("D",lst.getItem());
        lst.setPosition(dllist.position.FOLLOWING);
        assertEquals("C",lst.getItem());
        lst.setPosition(dllist.position.FOLLOWING);
        assertEquals("A",lst.getItem());
        lst.setPosition(dllist.position.FOLLOWING);
        assertEquals("E",lst.getItem());
    }
    @Test
    public void delete() {
        dllist lst = new dllist();
        lst.insert("A",dllist.position.FIRST);
        lst.delete();
        assertEquals(true, lst.isEmpty());
    }

}

