package com.taudemo;

import org.testng.Assert;
import org.testng.annotations.Test;

public class WithAssertionsTest {

    @Test
    public void firstAssertion() {
        Assert.assertEquals(2, 2);
    }

    @Test
    public void secondAssertion() {
        Assert.assertEquals(45, 45);
    }

    @Test
    public void thirdAssertion() {
        Assert.assertEquals(34, 34);
    }
}
