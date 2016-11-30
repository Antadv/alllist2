package com.coderbike.baseTest;

import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
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
@ActiveProfiles("dev")
public abstract class BaseTest {
}
