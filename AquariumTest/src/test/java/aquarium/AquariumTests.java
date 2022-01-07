package aquarium;

import org.junit.Assert;
import org.junit.Test;

public class AquariumTests {


    //constructor throws null exception because name is null or empty - NullPointerException
    @Test (expected = NullPointerException.class)
    public void testConstructorThrowsNullPointerExceptionBecauseNameIsNull(){
        Aquarium aquarium = new Aquarium(null,6);
    }

    @Test(expected = NullPointerException.class)
    public void testConstructorThrowsNullPointerExceptionBecauseNameIsEmpty(){
        Aquarium aquarium = new Aquarium("   ",7);
    }
    //constructor throws IllegalArgumentException because capacity is negativeNumber - IllegalArgumentException
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorThrowsIllegalArgumentExceptionBecauseCapacityIsNegative(){
        Aquarium aquarium = new Aquarium("Aqua",-77);
    }
    //constructor is successful
    @Test
    public void testConstructorIsSuccessfullyBuild(){
        String aquariumName = "Aqua";
        int aquariumCapacity = 7;
        Aquarium aquarium = new Aquarium(aquariumName,aquariumCapacity);
        Assert.assertEquals(aquariumName,aquarium.getName());
        Assert.assertEquals(aquariumCapacity,aquarium.getCapacity());
    }
    //add throws exception if capacity is full - IllegalArgumentException
    @Test (expected = IllegalArgumentException.class)
    public void testIfAddMethodThrowsIllegalArgumentExceptionWhenCapacityIsFull(){
        String aquariumName = "Aqua";
        int aquariumCapacity = 0;
        Aquarium aquarium = new Aquarium(aquariumName,aquariumCapacity);
        aquarium.add(new Fish("Nemo"));
    }
    // add is successful
    @Test
    public void testIfAddMethodIsSuccessful(){
        String aquariumName = "Aqua";
        int aquariumCapacity = 2;
        Aquarium aquarium = new Aquarium(aquariumName,aquariumCapacity);
        Fish fish = new Fish("Nemo");
        aquarium.add(fish);
        Assert.assertEquals(1,aquarium.getCount());
    }
    // remove throws exception is fish is not found - IllegalArgumentException
    @Test (expected = IllegalArgumentException.class)
    public void testRemoveThrowsIllegalArgumentExceptionWhenFishIsNotFound(){
        String aquariumName = "Aqua";
        int aquariumCapacity = 2;
        Aquarium aquarium = new Aquarium(aquariumName,aquariumCapacity);
        Fish fish = new Fish("Nemo");
        aquarium.add(fish);
        aquarium.remove("Dory");
    }
    //remove is successful
    @Test
    public void testRemoveMethodIsSuccessful(){
        String aquariumName = "Aqua";
        int aquariumCapacity = 2;
        Aquarium aquarium = new Aquarium(aquariumName,aquariumCapacity);
        Fish expected = new Fish("Nemo");
        aquarium.add(expected);
        aquarium.remove("Nemo");
        Assert.assertEquals(0,aquarium.getCount());
    }
    //sellFish throws exception because fish is not found - IllegalArgumentException with message "Fish with name %s doesn't exist"
    @Test(expected = IllegalArgumentException.class)
    public void testIfSellFishMethodDoesNotFindFish(){
        String aquariumName = "Aqua";
        int aquariumCapacity = 2;
        Aquarium aquarium = new Aquarium(aquariumName,aquariumCapacity);
        Fish expected = new Fish("Nemo");
        aquarium.add(expected);
        Fish actual = aquarium.sellFish("Dory");

    }
    // sellFish is successful - assert false for fish setAvailable
    @Test
    public void testIfSellFishMethodIsSuccessful(){
        String aquariumName = "Aqua";
        int aquariumCapacity = 2;
        Aquarium aquarium = new Aquarium(aquariumName,aquariumCapacity);
        Fish expected = new Fish("Nemo");
        aquarium.add(expected);
        Fish actual = aquarium.sellFish("Nemo");
        Assert.assertEquals(expected,actual);
       Assert.assertFalse(actual.isAvailable());

    }

    // report method - "Fish available at %s: %s" aquarium , fishes

    @Test
    public void testIfReportIsSuccessful(){
        String aquariumName = "Aqua";
        int aquariumCapacity = 2;
        Aquarium aquarium = new Aquarium(aquariumName,aquariumCapacity);
        Fish fish = new Fish("Nemo");
        Fish fish1 = new Fish("Dory");
        aquarium.add(fish);
        aquarium.add(fish1);

        String expected = "Fish available at Aqua: Nemo, Dory";
        String actual = aquarium.report();
        Assert.assertEquals(expected,actual);

    }
}

