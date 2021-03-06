package org.srh.config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.json.JSONArray;
import org.srh.nettiapp.hbm.RootHB;
import org.srh.nettiapp.hbm.dao.impl.ProductMasterDaoImpl;
import org.srh.nettiapp.hbm.dto.BranchMaster;
import org.srh.nettiapp.service.impl.BranchServiceImpl;
import org.srh.util.AppLog;


/**
 * Crash and Burn App
 * 
 * Date: 28 Nov 2018
 * @author Vivek
 */
public class AppMain {

	public static void main(String[] args) {
		// testCustomerFunctinalities();
		JSONArray obj = new JSONArray(new ProductMasterDaoImpl().getAllProducts());
		AppLog.print( obj );
		System.exit(0);
	}


	// VIVEK
	static Object display() {
		SessionFactory sessionFactory = RootHB.getSessionFactory();
		Session session = sessionFactory.openSession();
		BranchMaster branchMaster = session.find(BranchMaster.class, 1);
		session.close();
		sessionFactory.close();
		return branchMaster;
	}

}
