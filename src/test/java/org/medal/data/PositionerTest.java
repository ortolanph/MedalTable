package org.medal.data;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.medal.entity.MedalShelf;

import static org.junit.Assert.*;

public class PositionerTest {

    private Positioner positioner;
    public static final String MOCKED_FEDERATION = "Mocked Federation";

    @Before
    public void setUp() throws Exception {
        positioner = new Positioner();
    }

    @After
    public void tearDown() throws Exception {
        positioner = null;
    }

    @Test
    public void testGetFirstPosition() throws Exception {
        MedalShelf medalShelf = new MedalShelf(MOCKED_FEDERATION, 1, 1, 1);

        int actual = positioner.positionFor(medalShelf);
        int expected = 1;

        assertEquals(expected, actual);
    }

    @Test
    public void testGetFirstPositionForADiferentCountry() throws Exception {
        MedalShelf medalShelf = new MedalShelf(MOCKED_FEDERATION, 1, 1, 1);

        positioner.positionFor(medalShelf);
        int actual = positioner.positionFor(medalShelf);
        int expected = 1;

        assertEquals(expected, actual);
    }

    @Test
    public void testGetSecondPosition() throws Exception {
        MedalShelf medalShelf1 = new MedalShelf(MOCKED_FEDERATION, 1, 1, 1);
        MedalShelf medalShelf2 = new MedalShelf(MOCKED_FEDERATION, 1, 1, 2);

        positioner.positionFor(medalShelf1);
        int actual = positioner.positionFor(medalShelf2);
        int expected = 2;

        assertEquals(expected, actual);
    }

    @Test
    public void testGetThirdPosition() throws Exception {
        MedalShelf medalShelf1 = new MedalShelf(MOCKED_FEDERATION, 1, 1, 1);
        MedalShelf medalShelf2 = new MedalShelf(MOCKED_FEDERATION, 1, 1, 1);
        MedalShelf medalShelf3 = new MedalShelf(MOCKED_FEDERATION, 1, 1, 2);

        positioner.positionFor(medalShelf1);
        positioner.positionFor(medalShelf2);
        int actual = positioner.positionFor(medalShelf3);
        int expected = 3;

        assertEquals(expected, actual);
    }
}