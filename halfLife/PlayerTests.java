package halfLife;

import org.junit.Assert;
import org.junit.Test;

public class PlayerTests {

    // constructor name throws exception for null name - NullPointerException
    @Test(expected = NullPointerException.class)
    public void testConstructorThrowsExceptionForNullName(){
        Player mc = new Player(null,50);
    }
    // constructor name throws exception for empty name - NullPointerException
    @Test(expected = NullPointerException.class)
    public void testConstructorThrowsExceptionForEmptyName(){
        Player mc = new Player("   ",50);
    }
    // constructor health throws exception for negative health - IllegalArgumentException
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorThrowsExceptionForNegativeHealth(){
        Player mc = new Player("Baal",-50);
    }
    // constructor is created properly
    @Test
    public void testConstructorIsCreatedProperly(){
        Player mc = new Player("Baal",50);
        Assert.assertEquals("Baal",mc.getUsername());
        Assert.assertEquals(50,mc.getHealth());
    }
    // take damage method throws exception if player health is below zero - IllegalStateException
    @Test(expected = IllegalStateException.class)
    public void testIfPlayerIsDeadBeforeTakingDamage(){
        Player mc = new Player("Baal",0);
        mc.takeDamage(6);
    }
    // take damage lowers health
    @Test
    public void testPlayerTakesDamage(){
        Player mc = new Player("MasterChef", 55);
        mc.takeDamage(5);
        Assert.assertEquals(50,mc.getHealth());
    }
    @Test(expected = IllegalStateException.class)
    public void testPlayerTakesDamageAndDies(){
        Player mc = new Player("MasterChef", 5);
        mc.takeDamage(5);
        mc.takeDamage(1);
    }

    // add gun throws exception if gun is null - NullPointerException
    @Test(expected = NullPointerException.class)
    public void testAddGunMethodThrowsExceptionIfGunIsNull(){
        Player mc = new Player("MasterChef", 55);
        mc.addGun(null);
    }
    // test if gun is added
    @Test
    public void testGunISAddedCorrectly(){
        Player mc = new Player("MasterChef", 55);
        Gun gun = new Gun("Glock",12);
        mc.addGun(gun);
        Assert.assertEquals(gun,mc.getGuns().get(0));
    }
    // test if gun is removed
    @Test
    public void testIfGunIsRemovedCorrectly(){
        Player mc = new Player("MasterChef", 55);
        Gun gun = new Gun("Glock",12);
        mc.addGun(gun);
        Assert.assertTrue(mc.removeGun(gun));
    }
    @Test
    public void testIfGunIsRemovedReturnsFalse(){
        Player mc = new Player("MasterChef", 55);
        Gun gun = new Gun("Glock",12);
        Gun gun1 = new Gun("MagicGlock",66);
        mc.addGun(gun);
        Assert.assertFalse(mc.removeGun(gun1));
    }
    //test if gun is gotten correctly
    @Test
    public void testIfGunIsGotten(){
        Player mc = new Player("MasterChef", 55);
        Gun gun = new Gun("Glock",12);
        Gun gun1 = new Gun("MagicGlock",66);
        mc.addGun(gun);
        Gun actual = mc.getGun("Glock");
        Assert.assertEquals(gun,actual);
    }
    @Test
    public void testIfGunIsNotGotten(){
        Player mc = new Player("MasterChef", 55);
        Gun gun = new Gun("Glock",12);
        Gun gun1 = new Gun("MagicGlock",66);
        Gun actual = mc.getGun("Glock");
        mc.addGun(gun);

        Assert.assertNotEquals(gun,actual);
    }
    // check if getGuns list is unmodifiableList
    @Test(expected = UnsupportedOperationException.class)
    public void testIfGetGunsIsUnmodifiableList(){
        Player mc = new Player("MasterChef", 55);
        Gun gun = new Gun("Glock",12);
        mc.addGun(gun);
        mc.getGuns().clear();
    }
}
