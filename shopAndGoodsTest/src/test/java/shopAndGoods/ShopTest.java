package shopAndGoods;


import org.junit.Assert;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ShopTest {

    //test if addGoods shelf does not exist exception - IllegalArgumentException
    @Test (expected = IllegalArgumentException.class)
    public void testIfShelfDoesNotExistThrowIllegalArgumentException()throws OperationNotSupportedException, IllegalArgumentException{
        Shop shop = new Shop();
        shop.addGoods("Shelves14",new Goods("Toy","Teddy"));
    }
    // test if shelf is taken - IllegalArgumentException
    @Test (expected = IllegalArgumentException.class)
    public void testIfShelfIsAlreadyTakenThrowIllegalArgumentException()throws OperationNotSupportedException, IllegalArgumentException{
        Shop shop = new Shop();
        Goods goods = new Goods("Toy","Teddy");
        shop.addGoods("Shelves12",goods);
        shop.addGoods("Shelves12",goods);
    }

    // test if goods exist - OperationNotSupportedException
    @Test (expected = OperationNotSupportedException.class)
    public void testIfShelfGoodsAlreadyExistThrowOperationNotSupportedException()throws OperationNotSupportedException, IllegalArgumentException{
        Shop shop = new Shop();
        shop.addGoods("Shelves12",null);

    }
    // test if added correctly
    @Test
    public void testIfGoodsAddedCorrectly() throws OperationNotSupportedException, IllegalArgumentException {
        Shop shop = new Shop();
        String shelf = "Shelves12";
        Goods goods = new Goods("test_good", "test_code");
        String expected = "Goods: test_code is placed successfully!";
        String actual = shop.addGoods(shelf,goods);

        Assert.assertEquals(expected, actual);
    }
    // test if remove throws exception if shelf exists - IllegalArgumentException
    @Test (expected = IllegalArgumentException.class)
    public void testIfShelfDoesNotExistWhenRemovingThrowIllegalArgumentException()throws IllegalArgumentException{
        Shop shop = new Shop();
        shop.removeGoods("Shelves16",new Goods("Toy","Teddy"));
    }
    //test if shelf goods are different that specified - IllegalArgumentException

    @Test (expected = IllegalArgumentException.class)
    public void testIfShelfGoodsAreDifferentWhenRemovingThrowIllegalArgumentException()throws OperationNotSupportedException, IllegalArgumentException{
        Shop shop = new Shop();
        shop.addGoods("Shelves12",new Goods("Toy","45"));
        shop.removeGoods("Shelves12",new Goods("Plushier","55"));
    }

    // test if removed properly - assertEquals - shelf - null

    @Test
    public void testIFShelfHasRemovedGoodsCorrectly()throws OperationNotSupportedException, IllegalArgumentException{
        Shop shop = new Shop();
        String shelf = "Shelves12";
        Goods goods = new Goods("Toy","1");
        shop.addGoods(shelf,goods);
        String expected = "Goods: 1 is removed successfully!";
        String actual = shop.removeGoods(shelf, goods);
        Assert.assertEquals(expected,actual);
        Assert.assertNull(shop.getShelves().get(shelf));
    }
    @Test(expected = UnsupportedOperationException.class)
    public void testGetShelvesShouldReturnUnmodifiableCollection() {
        Shop shop = new Shop();
        shop.getShelves().clear();
    }
}