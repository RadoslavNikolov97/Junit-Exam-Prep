package blueOrigin;

import org.junit.Assert;
import org.junit.Test;

public class SpaceshipTests {

    //Constructor throws NullPointerException for null name - NullPointerException
    @Test(expected = NullPointerException.class)
    public void testConstructorForNullName(){
        Spaceship spaceship = new Spaceship(null, 6);

    }

    //Constructor throws NullPointerException for empty name - NullPointerException
    @Test(expected = NullPointerException.class)
    public void testConstructorForEmptyName(){
        Spaceship spaceship = new Spaceship("   ", 6);

    }
    //Constructor throws IllegalArgumentException for negative capacity - IllegalArgumentException
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorForNegativeCapacity(){
        Spaceship spaceship = new Spaceship("SpaceX", -69);



    }
    //Constructor is successful
    @Test
    public void testConstructorIsSuccessful(){
        String spaceCompany = "SpaceX";
        int capacity = 2;
        Spaceship spaceship = new Spaceship(spaceCompany,capacity);
        Assert.assertEquals(spaceCompany,spaceship.getName());
        Assert.assertEquals(2,spaceship.getCapacity());
    }
    //Add method throws IllegalArgumentException if capacity is full - IllegalArgumentException
    @Test(expected = IllegalArgumentException.class)
    public void testAddMethodThrowsExceptionForFullCapacity(){
        String spaceCompany = "SpaceX";
        int capacity = 0;
        Spaceship spaceship = new Spaceship(spaceCompany,capacity);
        Astronaut astronaut = new Astronaut("Jeff Bezos",97);
        spaceship.add(astronaut);
    }

    //Add method throws IllegalArgumentException if there is already a matching object - IllegalArgumentException
    @Test(expected = IllegalArgumentException.class)
    public void testAddMethodThrowsExceptionForMatchingAstronauts(){
        String spaceCompany = "SpaceX";
        int capacity = 2;
        Spaceship spaceship = new Spaceship(spaceCompany,capacity);
        Astronaut astronaut = new Astronaut("Jeff Bezos",97);
        Astronaut astronaut1 = new Astronaut("Jeff Bezos",99);
        spaceship.add(astronaut);
        spaceship.add(astronaut1);

    }
    //Add method is successful
    @Test
    public void testAddMethodIsSuccessful(){
        String spaceCompany = "SpaceX";
        int capacity = 2;
        Spaceship spaceship = new Spaceship(spaceCompany,capacity);
        Astronaut astronaut = new Astronaut("Jeff Bezos",97);
        Astronaut astronaut1 = new Astronaut("Elon Musk",99);
        spaceship.add(astronaut);
        spaceship.add(astronaut1);
        Assert.assertEquals(2,spaceship.getCount());
    }

    //Remove method returns false if an astronaut is found or true
    @Test
    public void testIfRemoveMethodReturnsTrue(){
        String spaceCompany = "SpaceX";
        int capacity = 2;
        Spaceship spaceship = new Spaceship(spaceCompany,capacity);
        Astronaut astronaut = new Astronaut("Jeff Bezos",97);
        spaceship.add(astronaut);
        Assert.assertTrue(spaceship.remove("Jeff Bezos"));
    }
    @Test
    public void testIfRemoveMethodReturnsFalse(){
        String spaceCompany = "SpaceX";
        int capacity = 2;
        Spaceship spaceship = new Spaceship(spaceCompany,capacity);
        Astronaut astronaut = new Astronaut("Jeff Bezos",97);
        spaceship.add(astronaut);
        Assert.assertFalse(spaceship.remove("Elon Musk"));
    }
    @Test
    public void testGetAstronautsCountShouldReturnTwoWhenTwoAdded() {
        Spaceship spaceship = new Spaceship("SpaceX",2);
        spaceship.add(new Astronaut("test_1", 100));
        spaceship.add(new Astronaut("test_2", 100));
        Assert.assertEquals(2, spaceship.getCount());
    }

    @Test
    public void testGetAstronautsCountShouldReturnZeroWhennEmpty() {
        Spaceship spaceship = new Spaceship("SpaceX",2);
        Assert.assertEquals(0, spaceship.getCount());
    }

}
