package cats;

import org.junit.Assert;
import org.junit.Test;

public class HouseTests {

    // constructor check if name is null - NullPointerException
    @Test(expected = NullPointerException.class)
    public void testConstructorThrowsExceptionForNullName(){
        House house = new House(null,6);
    }
    // constructor check if name is empty - NullPointerException
    @Test(expected = NullPointerException.class)
    public void testConstructorThrowsExceptionForEmptyName(){
        House house = new House("  ",6);
    }
    // constructor check if capacity is below zero - IllegalArgumentException
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorThrowsExceptionForNegativeCapacity(){
        House house = new House("Jimmy's",-6);
    }
    //constructor is successfully created
    @Test
    public void testConstructorIsCreatedProperly(){
        House house = new House("Jimmy's",6);
    }
    // addCat throws IllegalArgumentException if capacity is full - IllegalArgumentException
    @Test(expected = IllegalArgumentException.class)
    public void testIfAddCatThrowsExceptionForFullCapacity(){
        House house = new House("Jimmy's",0);
        house.addCat(new Cat("Ani"));
    }
    // addCat is successful
    @Test
    public void testAddCatMethodIsSuccessful(){
        House house = new House("Jimmy's",1);
        house.addCat(new Cat("Ani"));
        Assert.assertEquals(1,house.getCount());
    }
    // removeCat throws IllegalArgumentException if cat is missing - IllegalArgumentException
   @Test(expected = IllegalArgumentException.class)
    public void testRemoveCatThrowsExceptionForMissingCat(){
       House house = new House("Jimmy's",2);
       house.addCat(new Cat("Ani"));
       house.removeCat("Pesho");
   }
    // removeCat is successful
    @Test
    public void testRemoveCatIsSuccessful(){
        House house = new House("Jimmy's",2);
        house.addCat(new Cat("Ani"));
        house.removeCat("Ani");
        Assert.assertEquals(0,house.getCount());
    }
    //catForSale throws exception if cat is missing - IllegalArgumentException
    @Test(expected = IllegalArgumentException.class)
    public void testCatForSaleMethodThrowsExceptionIfCatIsMissing(){
        House house = new House("Jimmy's",2);
        house.addCat(new Cat("Ani"));
        house.catForSale("Pesho");
    }
    // catForSale is successful
    @Test
    public void testCatForSaleMethodIsSuccessful(){
        House house = new House("Jimmy's",2);
        Cat cat = new Cat("Ani");
        house.addCat(cat);
        house.catForSale("Ani");
        Assert.assertFalse(cat.isHungry());
    }
    // getStatistics - "The cat %s is in the house %s!" - cats name , house name;
    @Test
    public void testStatistics(){
        House house = new House("Jimmy's",2);
        Cat cat = new Cat("Ani");
        Cat cat1 = new Cat("Pesho");
        house.addCat(cat);
        house.addCat(cat1);
        String expected = "The cat Ani, Pesho is in the house Jimmy's!";
        Assert.assertEquals(expected,house.statistics());
    }
}
