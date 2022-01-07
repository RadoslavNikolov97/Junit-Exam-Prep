package computers;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;
import java.util.List;

public class ComputerManagerTests {



    // getComputersMethodShouldBeUnmodifiable try to clear it
    @Test (expected = UnsupportedOperationException.class)
    public void testGetComputersMethodShouldBeUnmodifiable(){
        ComputerManager computerManager = new ComputerManager();
        computerManager.addComputer(new Computer("Asus","ROG",3000));
        computerManager.getComputers().clear();
    }

    // if computer is null throw IllegalArgumentException - addComputer
    @Test(expected = IllegalArgumentException.class)
    public void testAddComputerNameIsNullAndThrowsException(){
        ComputerManager computerManager = new ComputerManager();
        computerManager.addComputer(null);
    }
    // if computer is not found throw IllegalArgumentException - addComputer
    @Test (expected = IllegalArgumentException.class)
    public void testAddComputerIsNotFoundAndThrowsException(){
        ComputerManager computerManager = new ComputerManager();
        computerManager.addComputer(new Computer("Asus","ROG",3000));
        computerManager.addComputer(new Computer("Asus","ROG",3000));

    }
    // add computer is successful
    @Test
    public void testAddComputersIsSuccessful(){
        ComputerManager computerManager = new ComputerManager();
        computerManager.addComputer(new Computer("Asus","ROG",3000));
        computerManager.addComputer(new Computer("Acer","Nitro",2300));
        Assert.assertEquals(2,computerManager.getCount());
    }
    // if removeComputer first String is null throw IllegalArgumentException
    @Test (expected = IllegalArgumentException.class)
    public void testRemoveComputerThrowsExceptionIfFirstStringIsNull(){
        ComputerManager computerManager = new ComputerManager();
        computerManager.addComputer(new Computer("Asus","ROG",3000));
        computerManager.removeComputer(null,"ROG");
    }
    // remove computer is successful
    @Test
    public void testRemoveComputerIsSuccessful(){
        ComputerManager computerManager = new ComputerManager();
        Computer expected = new Computer("Asus","ROG",3000);
        computerManager.addComputer(expected);
        Computer actual = computerManager.removeComputer("Asus","ROG");
        Assert.assertEquals(expected,actual);
        Assert.assertEquals(0,computerManager.getCount());
    }
    // if get computer first string is null throw IllegalArgumentException
    @Test(expected = IllegalArgumentException.class)
    public void testGetComputersFirstStringISNull(){
        ComputerManager computerManager = new ComputerManager();
        Computer expected = new Computer("Asus","ROG",3000);
        computerManager.addComputer(expected);
        computerManager.getComputer(null,"ROG");
    }
    // if get computer second string is null throw IllegalArgumentException
    @Test(expected = IllegalArgumentException.class)
    public void testGetComputersSecondStringISNull(){
        ComputerManager computerManager = new ComputerManager();
        Computer expected = new Computer("Asus","ROG",3000);
        computerManager.addComputer(expected);
        computerManager.getComputer("Asus",null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetComputerMethodDoesNotFindMatchingComputer(){
        ComputerManager computerManager = new ComputerManager();
        Computer expected = new Computer("Asus","ROG",3000);
        computerManager.addComputer(expected);
        computerManager.getComputer("Lenovo","Yoga");
    }
    //get computer is successful
    @Test
    public void testGetComputerIsSuccessful(){
        ComputerManager computerManager = new ComputerManager();
        Computer expected = new Computer("Asus","ROG",3000);
        computerManager.addComputer(expected);
        Computer actual = computerManager.getComputer("Asus","ROG");
        Assert.assertEquals(expected,actual);
    }
    // getComputersByManufacturer if first string is null throw IllegalArgumentException
    @Test (expected = IllegalArgumentException.class)
    public void testGetComputersByManufacturerThrowsIllegalArgumentExceptionIfNull(){
        ComputerManager computerManager = new ComputerManager();
        Computer computer = new Computer("Asus","ROG",3000);
        Computer computer1 = new Computer("Asus","Aspire",1002);
        Computer computer2 = new Computer("Asus","Something",999);
        computerManager.addComputer(computer);
        computerManager.addComputer(computer1);
        computerManager.addComputer(computer2);
        computerManager.getComputersByManufacturer(null);
    }
    //  getComputersByManufacturer is successful
    @Test
    public void testGetComputersByManufacturerIsSuccessful(){
        ComputerManager expected = new ComputerManager();
        Computer computer = new Computer("Asus","ROG",3000);
        Computer computer1 = new Computer("Asus","Aspire",1002);
        Computer computer2 = new Computer("Asus","Something",999);
        expected.addComputer(computer);
        expected.addComputer(computer1);
        expected.addComputer(computer2);
        List<Computer> actual = expected.getComputersByManufacturer("Asus");
        Assert.assertEquals(expected.getComputers(),actual);

    }
}