package com.qsgsoft.Logicbay.main;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import com.qsgsoft.Logicbay.requirement.Core.*;
import com.qsgsoft.Logicbay.requirement.NMHG.*;

@RunWith(Suite.class)

@Suite.SuiteClasses( {
	Add_EditUserNMHG.class,
	Add_EditUserCore.class,
})
public class BQSTest {

}
