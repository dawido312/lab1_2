package pl.com.bottega.ecommerce.sharedkernel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MoneyTest {

    private Money money, money2, money3;

    @Before public void setUp(){
        money = new Money(10, "PLN");
        money2 = new Money(20,"PLN");
        money3 = new Money(30, "EUR");
    }

    @Test public void multiplyByTest()
    {
        Money tmp = money.multiplyBy(3d);
        Assert.assertThat("30.00 zł", is(tmp.toString()));
        tmp.multiplyBy(-3d);
        Assert.assertThat("30.00 zł", is(tmp.toString()));
    }

    @Test(expected = IllegalArgumentException.class) public void additionTest()
    {
        Assert.assertThat("30.00 zł", is(money.add(money2).toString()));
        money2.add(money3);
    }

    @Test(expected = NullPointerException.class) public void additionWithNullTest()
    {
        money.add(null);
    }

    @Test(expected=IllegalArgumentException.class)public void subtractionTest()
    {
        Assert.assertThat("10.00 zł", is(money2.subtract(money).toString()));
        Assert.assertThat("-10.00 zł", is(money.subtract(money2).toString()));
        money.subtract(money3);

    }

    @Test(expected = NullPointerException.class)public void subtractionWithNull()
    {
        money.subtract(null);
    }


}
