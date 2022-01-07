package farmville;


import org.junit.Assert;
import org.junit.Test;

import java.security.PublicKey;

public class FarmvilleTests {



    //test farm name null - NullPointerException
    @Test (expected = NullPointerException.class)
   public void testFarmReturnsNullPointerExceptionBecauseNameIsNull(){
        Farm farm = new Farm(null, 3);
    }


    //test farm capacity negative value - IllegalArgumentException
    @Test (expected = IllegalArgumentException.class)
    public void testReturnsIllegalArgumentExceptionBecauseCapacityIsNegative(){
        Farm farm = new Farm("Pig Farm", -4);
    }

    //test farm name white spaces - NullPointerException
    @Test (expected = NullPointerException.class)
    public void testFarmReturnsNullPointerExceptionBecauseNameIsEmpty(){
        Farm farm = new Farm("    ", 3);
    }
    //test farm created properly - no exception
    @Test
    public void testFarmCorrectlyConstructed(){
        String farmName = "Pig Farm";
        int farmCapacity = 5;
        Farm farm = new Farm("Pig Farm", 5);
        Assert.assertEquals(farmName,farm.getName());
        Assert.assertEquals(farmCapacity,farm.getCapacity());
    }

    //test add method throws exception because capacity is full - IllegalArgumentException

    @Test (expected = IllegalArgumentException.class)
    public void testAddMethodThrowsIllegalArgumentExceptionBecauseCapacityIsFull(){
        Farm farm = new Farm("Pig Farm", 0);
        farm.add(new Animal("Pig",45));
    }

    // test add method throws exception because of matching entities -IllegalArgumentException
    @Test (expected = IllegalArgumentException.class)
    public void testAddMethodThrowsIllegalArgumentExceptionBecauseOfMatchingEntities(){
        Farm farm = new Farm("Pig Farm", 2);
        farm.add(new Animal("Pig",45));
        farm.add(new Animal("Pig",60));
    }

    // test add method adds successfully - no exception
    @Test
    public void testAddMethodAddsCorrectly(){
        String farmName = "Pig Farm";
        int farmCapacity = 5;
        Farm farm = new Farm("Pig Farm", 5);
        Assert.assertEquals(0,farm.getCount());
        farm.add(new Animal("Pig",60));
        Assert.assertEquals(1,farm.getCount());
    }
    // test animal is not removed - no exception
    @Test
    public void testRemoveMethodDoesNotRemove(){
        String farmName = "Pig Farm";
        int farmCapacity = 5;
        Farm farm = new Farm(farmName, farmCapacity);
        Assert.assertEquals(0,farm.getCount());
        farm.add(new Animal("Animal",777));
        Assert.assertEquals(1,farm.getCount());
        Assert.assertFalse(farm.remove("Dog"));
    }

    // test animal removed - no exception
    @Test
    public void testRemoveMethodRemovesProperly(){
        String farmName = "Pig Farm";
        int farmCapacity = 5;
        Farm farm = new Farm(farmName, farmCapacity);
        Assert.assertEquals(0,farm.getCount());
        farm.add(new Animal("Animal",777));
        Assert.assertEquals(1,farm.getCount());
        Assert.assertTrue(farm.remove("Animal"));
        Assert.assertEquals(0,farm.getCount());
    }



}
