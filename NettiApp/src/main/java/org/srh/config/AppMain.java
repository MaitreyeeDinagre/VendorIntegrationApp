package org.srh.config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.json.JSONObject;
import org.srh.nettiapp.hbm.RootHB;
import org.srh.nettiapp.hbm.dto.BranchMaster;
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
		Object obj = display();
		AppLog.print( new JSONObject(obj) );
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
