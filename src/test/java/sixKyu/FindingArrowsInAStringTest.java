package sixKyu;


import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4ClassRunner.class)
public class FindingArrowsInAStringTest {

    public FindingArrowsInAStringTest() {

    }
    @Test
    public void testExample() {
        assertEquals(1, FindingArrowsInAString.searchArrows(">."));
    }

    @Test
    public void test() {
        assertEquals(-3, FindingArrowsInAString.searchArrows("<--.."));
    }
    @Test
    public void test1() {

        assertEquals(-2, FindingArrowsInAString.searchArrows("><=><--"));
    }
    @Test
    public void test2() {

        assertEquals(11, FindingArrowsInAString.searchArrows(">===>->"));
    }
    @Test
    public void test3() {

        assertEquals(15, FindingArrowsInAString.searchArrows(">===>=>->"));
    }
    @Test
    public void test4() {

        assertEquals(0, FindingArrowsInAString.searchArrows("......"));
    }
    @Test
    public void test5() {

        assertEquals(0, FindingArrowsInAString.searchArrows("<-->"));
    }
    @Test
    public void test6() {

        assertEquals(3, FindingArrowsInAString.searchArrows("-->"));
    }
    @Test
    public void test8() {

        assertEquals(-1, FindingArrowsInAString.searchArrows("<=-->"));
    }
    @Test
    public void test9() {

        assertEquals(6, FindingArrowsInAString.searchArrows("--==>"));
    }
    @Test
    public void test10() {

        assertEquals(0, FindingArrowsInAString.searchArrows("<====>"));
    }
  @Test
    public void test11() {

        assertEquals(-3, FindingArrowsInAString.searchArrows(">>><.=<=<..=<>"));
    }
  @Test
    public void test12() {

        assertEquals(-7, FindingArrowsInAString.searchArrows("<=<-<=<>==<=..<>.<>->>>=>=-=<-.>==>><->-->><<==<<>=.-<>=.-=<<->---.=->-=.=-=<-=<--=--<><>>><>=-..=-<"));
    }
  @Test
    public void test13() {

        assertEquals(-2, FindingArrowsInAString.searchArrows("<==>=>---=.--=.-<<.=>--=<--.=<.<<.=<=.=>=<-====.>-.>.<-<=.>=>=><-=>=>.=.-=-<<>.-=-<-<-..=<=-=..>><=-"));
    }

}