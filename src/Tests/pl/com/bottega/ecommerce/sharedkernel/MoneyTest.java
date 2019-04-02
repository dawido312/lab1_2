package pl.com.bottega.ecommerce.sharedkernel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MoneyTest {

    private Money money, money2, money3;

    @Before public void setUp() {
        money = new Money(10, "PLN");
        money2 = new Money(20, "PLN");
        money3 = new Money(30, "EUR");
    }

    @Test public void multiplyByTest() {
        Money tmp = money.multiplyBy(3d);
        Assert.assertThat(tmp.toString(), is("30.00 zł"));
        tmp.multiplyBy(-3d);
        Assert.assertThat(tmp.toString(), is("30.00 zł"));
    }

    @Test(expected = IllegalArgumentException.class) public void additionTest() {
        Assert.assertThat(money.add(money2).toString(), is("30.00 zł"));
        money2.add(money3);
    }

    @Test(expected = NullPointerException.class) public void additionWithNullTest() {
        money.add(null);
    }

    @Test(expected = IllegalArgumentException.class) public void subtractionTest() {
        Assert.assertThat(money2.subtract(money).toString(), is("10.00 zł"));
        Assert.assertThat(money.subtract(money2).toString(), is("-10.00 zł"));
        money.subtract(money3);

    }

    @Test(expected = NullPointerException.class) public void subtractionWithNull() {
        money.subtract(null);
    }

    @Test public void comparisonMethodsTest() {
        Assert.assertThat(money.greaterThan(money2), is(false));
        Assert.assertThat(money.lessThan(money2), is(true));
        Money tmp = new Money(30, "EUR");
        Assert.assertThat(money3.lessOrEquals(tmp), is(true));
        Assert.assertThat(money2.greaterThan(tmp), is(false));
    }
}
