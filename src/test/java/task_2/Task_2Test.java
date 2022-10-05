package task_2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Task_2Test {

    private String actual, expected, given;

    @Test
    public void happyPath_1() {
        given = "burakArikboga";
        actual = Task_2.getReverseOrder(given);
        expected = "agobkirAkarub";
        assertEquals(expected, actual);
    }

    @Test
    public void happyPath_2() {
        given = "string";
        actual = Task_2.getReverseOrder(given);
        expected = "gnirts";
        assertEquals(expected, actual);
    }

    @Test
    public void happyPath_3() {
        given = "GmX";
        actual = Task_2.getReverseOrder(given);
        expected = "XmG";
        assertEquals(expected, actual);
    }

    @Test
    public void lengthLessThan_1() {
        given = "";
        actual = Task_2.getReverseOrder(given);
        expected = "Given string \"" + "" + "\"'s length must be in 1-30 length!";
        assertEquals(expected, actual);
    }

    @Test
    public void lengthGreaterThan_30() {
        given = "abcdefghijklmnopqrstuwxvyzABCDE";
        actual = Task_2.getReverseOrder(given);
        expected = "Given string \"" + given + "\"'s length must be in 1-30 length!";
        assertEquals(expected, actual);
    }

    @Test
    public void blankTest() {
        given = "Burak Arikboga";
        actual = Task_2.getReverseOrder(given);
        expected = "Given string \"" + given + "\" shouldn't contain any character different from letters!";
        assertEquals(expected, actual);
    }

    @Test
    public void digitTest() {
        given = "1.BurakArikboga";
        actual = Task_2.getReverseOrder(given);
        expected = "Given string \"" + given + "\" shouldn't contain any character different from letters!";
        assertEquals(expected, actual);
    }

    @Test
    public void specialCharacterTest() {
        given = "Burak_Arikboga";
        actual = Task_2.getReverseOrder(given);
        expected = "Given string \"" + given + "\" shouldn't contain any character different from letters!";
        assertEquals(expected, actual);
    }

    @Test
    public void lengthGreaterThan_30AndSpecialTest() {
        given = "Burak_ArikbogaBurak_ArikbogaBurak_Arikboga";
        actual = Task_2.getReverseOrder(given);
        expected = "Given string \"" + given + "\" shouldn't contain any character different from letters!" + "\n"
                + "Given string \"" + given + "\"'s length must be in 1-30 length!";
        assertEquals(expected, actual);
    }


}