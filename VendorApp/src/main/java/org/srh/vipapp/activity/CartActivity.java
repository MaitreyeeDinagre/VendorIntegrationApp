package org.srh.vipapp.activity;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.srh.bean.ServiceResp;
import org.srh.constants.ErrorCode;
import org.srh.util.Common;
import org.srh.util.StringUtil;
import org.srh.vipapp.hbm.RootHB;
import org.srh.vipapp.hbm.dao.CustomerMasterDao;
import org.srh.vipapp.hbm.dao.ProductsMasterDao;
import org.srh.vipapp.hbm.dao.impl.CustomerMasterDaoImpl;
import org.srh.vipapp.hbm.dao.impl.ProductsMasterDaoImpl;
import org.srh.vipapp.hbm.dto.CartProduct;
import org.srh.vipapp.hbm.dto.CustomerCart;
import org.srh.vipapp.hbm.dto.CustomerMaster;
import org.srh.vipapp.hbm.dto.ProductsMaster;
import org.srh.vipapp.hbm.dto.UserMaster;


/**
 * Date: 09 Dec 2018 
 * @author Vivek
 */
public class CartActivity {

	private CustomerMasterDao customerMasterDao = new CustomerMasterDaoImpl();
	private ProductsMasterDao productsMasterDao = new ProductsMasterDaoImpl();


	public ServiceResp saveCart(Long customerId, String displayName, Long productId, Integer productCount) {
		Session session = RootHB.getSessionFactory().openSession();

		// Cart Transaction
		Transaction transaction = session.beginTransaction();
		try {
			// 
			CustomerMaster customerMaster = customerMasterDao.findById(customerId, session);
			if(customerMaster==null) {
				RootHB.closeSession(session);
				String description = StringUtil.append("The customer id [", customerId, "] is invalid integer.");
				return Common.buildServiceRespError(ErrorCode.INVALID_INPUT, description);
			}

			// 
			UserMaster systemUser = RootHB.getSystemUser();

			// Create [CustomerCart] entity object to save it.
			CustomerCart customerCart = new CustomerCart();
			customerCart.setCustomerId(customerMaster);
			customerCart.setCreatedBy(systemUser);
			customerCart.setModifiedBy(systemUser);
			customerCart.setDisplayName(displayName);
			session.save(customerCart);

			// Save Products in Cart
			ProductsMaster productsMaster = productsMasterDao.findById(productId, session);
			if(productsMaster==null) {
				String description = StringUtil.append("The product id [", productId, "] is invalid integer.");
				return Common.buildServiceRespError(ErrorCode.INVALID_INPUT, description);
			}
			CartProduct cartProduct = saveCartProduct(session, customerCart, productsMaster, productCount, systemUser);

			transaction.commit();
			return Common.buildServiceResp(cartProduct);
		}
		catch(Exception ex) {
			transaction.rollback();
			String desc = ex.getMessage();
			return Common.buildServiceRespError(ErrorCode.EXCEPTION, desc);
		}
		finally {
			RootHB.closeSession(session);
		}
	}


	private CartProduct saveCartProduct(Session session, CustomerCart cart,
			ProductsMaster productsMaster, Integer productCount, UserMaster systemUser) {
		CartProduct cartProduct = new CartProduct();
		cartProduct.setCartId(cart);
		cartProduct.setProductId(productsMaster);
		cartProduct.setProductCount(productCount);
		cartProduct.setCreatedBy(systemUser);
		cartProduct.setModifiedBy(systemUser);
		session.save(cartProduct);
		return cartProduct;
	}
}
