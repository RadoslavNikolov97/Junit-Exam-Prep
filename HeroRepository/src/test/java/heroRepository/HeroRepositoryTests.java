package heroRepository;

import org.junit.Assert;
import org.junit.Test;

public class HeroRepositoryTests {





    //createMethod throws exception if hero object is null - NullPointerException
    @Test(expected = NullPointerException.class)
    public void testCreateMethodThrowsExceptionWhenHeroIsNull(){
        HeroRepository  heroes = new HeroRepository();
        heroes.create(null);


    }

    // create method throws exception if hero is already added in the repository - IllegalArgumentException
    @Test(expected = IllegalArgumentException.class)
    public void testCreateMethodThrowsExceptionIfHeroIsAlreadyInTheRepository(){
        HeroRepository  heroes = new HeroRepository();
        Hero hero = new Hero("Valhelm",99);
        Hero hero1 = new Hero("Valhelm",100);
        heroes.create(hero);
        heroes.create(hero1);
    }

    // createMethod returns string for successful adding to repository - message Successfully added hero %s with level %d
    @Test
    public void testCreateMethodIsSuccessful() {
        HeroRepository heroes = new HeroRepository();
        Hero hero = new Hero("Valhelm", 99);
        String expected = "Successfully added hero Valhelm with level 99";
        String actual = heroes.create(hero);
        Assert.assertEquals(expected,actual);
        Assert.assertEquals(1,heroes.getCount());
    }


    //remove method throws exception if name is null - NullPointerException
    @Test(expected = NullPointerException.class)
    public void testRemoveMethodThrowsExceptionBecauseHeroNameIsNull(){
        HeroRepository heroes = new HeroRepository();
        heroes.remove(null);
    }
    //remove method throws exception if name is Empty - NullPointerException
    @Test(expected = NullPointerException.class)
    public void testRemoveMethodThrowsExceptionBecauseHeroNameIsEmpty(){
        HeroRepository heroes = new HeroRepository();
        heroes.remove("   ");
    }
    //remove method returns boolean for successful removal from repository
    @Test
    public void testRemoveIsSuccessful(){
        HeroRepository heroes = new HeroRepository();
        Hero hero = new Hero("Valhelm", 99);
        heroes.create(hero);
        Assert.assertTrue(heroes.remove("Valhelm"));
        Assert.assertEquals(0,heroes.getCount());
    }

    // getHeroWithHighestLevel returns hero with the highest level
    @Test
    public void testGetsHeroWithHighestLevel(){
        HeroRepository heroes = new HeroRepository();
        Hero hero = new Hero("Valhelm", 99);
        Hero hero1 = new Hero("Ragnarok",100);
        Hero hero2 = new Hero("Dragonborn",999);
        heroes.create(hero);
        heroes.create(hero1);
        heroes.create(hero2);
        Assert.assertEquals(hero2,heroes.getHeroWithHighestLevel());
    }

    //getHeroWithMatchingName
    @Test
    public void testGetsHeroWithMatchingName(){
        HeroRepository heroes = new HeroRepository();
        Hero expected = new Hero("Valhelm", 99);
        heroes.create(expected);
        Hero actual = heroes.getHero("Valhelm");
        Assert.assertEquals(expected,actual);
    }
    // get heroes list and try to modify it
    @Test (expected = UnsupportedOperationException.class)
    public void testGetHeroes(){
        HeroRepository heroes = new HeroRepository();
        Hero expected = new Hero("Valhelm", 99);
        heroes.create(expected);
        heroes.getHeroes().clear();
    }

}
