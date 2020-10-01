package suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import tests.AccountTest;
import tests.BugReportRulesTest;
import tests.BugReportTest;
import tests.LoginTest;
import tests.LostPasswordMessageTest;
import tests.LostPasswordTest;
import tests.MenuAccountTest;
import tests.MenuTest;
import tests.MyViewTest;

@RunWith(Suite.class)
@SuiteClasses({
	LoginTest.class,
	LostPasswordTest.class,
	LostPasswordMessageTest.class,
	MyViewTest.class,
	MenuTest.class,
	AccountTest.class,
	MenuAccountTest.class,
	BugReportTest.class, 
	BugReportRulesTest.class
})
public class SuiteGeral {
	
}
