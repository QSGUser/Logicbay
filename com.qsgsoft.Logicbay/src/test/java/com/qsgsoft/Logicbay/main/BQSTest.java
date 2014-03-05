package com.qsgsoft.Logicbay.main;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import com.qsgsoft.Logicbay.requirement.core.*;
import com.qsgsoft.Logicbay.requirement.daimler.*;
import com.qsgsoft.Logicbay.requirement.nmhg.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({ Add_EditUserNMHG.class, Add_EditUserCore.class,
		Add_EditUserDaimler.class, })
public class BQSTest {

}
