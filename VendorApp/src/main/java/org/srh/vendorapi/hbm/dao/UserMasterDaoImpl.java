package org.srh.vendorapi.hbm.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.srh.util.StringUtil;
import org.srh.vendorapi.hbm.RootHB;
import org.srh.vendorapi.hbm.dto.UserMaster;
import org.srh.vendorapi.hbm.hql.UserMasterQuery;


/**
 * Implementation class of HBM DAO {@link UserMasterDao}
 * Date: 29 Nov 2018
 * @author Vivek
 */
public class UserMasterDaoImpl implements UserMasterDao {


	@Override
	public UserMaster findById(int userId) {
		UserMaster userMaster = null;
		Session session = RootHB.getSessionFactory().openSession();
		try {
			userMaster = session.find(UserMaster.class, userId);
		}
		catch(NoResultException ex) {
			System.err.println( StringUtil.append("No user exist with Id:", userId) );
		}
		finally {
			RootHB.closeSession(session);
		}
		return userMaster;
	}


	@Override
	public List<UserMaster> getAllUsers() {
		try ( Session session = RootHB.getSessionFactory().openSession(); ) {
			@SuppressWarnings("unchecked")
			Query<UserMaster> query = session.createNamedQuery(UserMasterQuery.GET_ALL_USER_$N);
			List<UserMaster> userMasterList = query.getResultList();
			return userMasterList;
		}
	}


	@Override
	public UserMaster findByUsername(String username) {
		Session session = RootHB.getSessionFactory().openSession();
		try {
			@SuppressWarnings("unchecked")
			Query<UserMaster> query = session.createNamedQuery(UserMasterQuery.FIND_USER_BY_USERNAME_$N);
			query.setParameter(UserMasterQuery.FIND_USER_BY_USERNAME_$P1, username);
			return query.getSingleResult();
		}
		catch(NoResultException ex) {
			System.err.println( StringUtil.append("No user with exist with Username:", username) );
			return null;
		}
		finally {
			RootHB.closeSession(session);
		}
	}

}
