package com.systemintegration.projekt;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ IntegrationTest.class, TestReadFile.class, TestZustand.class })
public class AllTests {

}
