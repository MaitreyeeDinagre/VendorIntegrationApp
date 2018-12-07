/**
 * 
 */
package org.srh.vipapp.hbm.dao;

import java.util.List;

import org.srh.vipapp.hbm.dto.ApiStructure;

/**
 * Implementation class of HBM DAO {@link ApiStructureDao}
 * Date: 05 Nov 2018
 * @author Maitreyee
 */
public interface ApiStructureDao {

	/**
	 * Returns all the {@link ApiStructure} entities from persistence database
	 * associated to the given vendor id.
	 * @param vendorId {@link Integer}
	 * @return apiStructureList {@link List<ApiStructure>}
	 */
	public List<ApiStructure> getApiStructureOfVendor(int vendorId);

	/**
	 * Returns all the {@link ApiStructure} entities from persistence database
	 * associated to the given vendor name.
	 * @param vendorName {@link String}
	 * @return apiStructureList {@link List<ApiStructure>}
	 */
	public List<ApiStructure> getApiStructureOfVendor(String vendorName);

}
