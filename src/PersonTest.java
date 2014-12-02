import static org.junit.Assert.*;

public class PersonTest {

    @org.junit.Test
    public void testSum() throws Exception {
        Person person = new Person("Bent", "200");
        int[] testArray = new int[]{1, 2, 3};
        assertEquals(person.sum(testArray), 6);
    }
}