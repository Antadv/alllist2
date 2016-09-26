package com.coderbike.baseTest;

import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * <p>描述<p/>
 * Created with IDEA
 * author: liubingguang
 * date: 2016/9/20 16:19
 */

@ContextConfiguration(locations = {"classpath:spring/application.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public abstract class BaseTest {
    protected final org.slf4j.Logger Logger = LoggerFactory.getLogger(this.getClass());
}
