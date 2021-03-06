/**
 * 
 */
package org.srh.vipapp.hbm.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.srh.util.AppLog;
import org.srh.util.StringUtil;
import org.srh.vipapp.hbm.RootHB;
import org.srh.vipapp.hbm.dao.ApiStructureDao;
import org.srh.vipapp.hbm.dao.VendorMasterDao;
import org.srh.vipapp.hbm.dto.ApiStructure;
import org.srh.vipapp.hbm.dto.VendorMaster;
import org.srh.vipapp.hbm.hql.ApiStructureQuery;

/**
 * Implementation class of HBM DAO {@link ApiStructureDao}
 * Date: 05 Nov 2018
 * @author Maitreyee
 */
public class ApiStructureDaoImpl implements ApiStructureDao {

	private VendorMasterDao vendorMasterDao = new VendorMasterDaoImpl();


	private List<ApiStructure> getApiStructureOfVendor(VendorMaster vendorMaster, Session session) {
		@SuppressWarnings("unchecked")
		Query<ApiStructure> query = session.createNamedQuery(ApiStructureQuery.GET_API_STRUCTURE_OF_VENDOR_$N);
		query.setParameter(ApiStructureQuery.GET_API_STRUCTURE_OF_VENDOR_$P1, vendorMaster);
		return query.getResultList();
	}


	@Override
	public List<ApiStructure> getApiStructureOfVendor(int vendorId) {
		try ( Session session = RootHB.getSessionFactory().openSession(); ) {
			VendorMaster vendorMaster = vendorMasterDao.findById(vendorId, session);
			if(vendorMaster==null) {
				AppLog.log(ApiStructureDaoImpl.class, StringUtil.append("Vendor with id '", vendorId, "' not found"));
				return new ArrayList<>();
			}
			return getApiStructureOfVendor(vendorMaster, session);
		}
	}


	@Override
	public List<ApiStructure> getApiStructureOfVendor(String vendorName) {
		try ( Session session = RootHB.getSessionFactory().openSession(); ) {
			VendorMaster vendorMaster = vendorMasterDao.findByVendorName(vendorName, session);
			if(vendorMaster==null) {
				AppLog.log(ApiStructureDaoImpl.class, StringUtil.append("Vendor with name '", vendorName, "' not found"));
				return new ArrayList<>();
			}
			return getApiStructureOfVendor(vendorMaster, session);
		}
	}


}
