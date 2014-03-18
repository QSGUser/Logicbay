package dataobject.core;

public class AssetsData {
	public String quicklinkTitle = "Qlink" + System.currentTimeMillis(),
				  contentType = "URL", 
				  linkURL = "http://www.google.com",
			      orgName = "Org" + System.currentTimeMillis(), 
			      orgCode = "1234567",
			      subOrgName = "suborg" + System.currentTimeMillis(),
			      subOrgCode = "9090909", newOrg = "*** Create New Division ***",
			      subType = "All", orgSrc = orgCode + "-" + orgName,
			      subOrgSrc = subOrgCode + "-" + subOrgName;
}
