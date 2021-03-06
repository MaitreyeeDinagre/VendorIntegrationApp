package org.srh.nettiapp.hbm.dao;

import java.util.List;

/**
 * HBM DAO to perform task related to {@link BranchMaster} entity. <br/>
 * Date: 05 Dec 2018
 * 
 * @author Shraddha
 */
public interface BranchMasterDao {

	/**
	 * Fetches the list of branches within the city.
	 * 
	 * @param city {@link String}
	 * @return branchList {@link List<BranchMaster}
	 */
	List<org.srh.nettiapp.hbm.dto.BranchMaster> getBranchesInCity(String city);

}
