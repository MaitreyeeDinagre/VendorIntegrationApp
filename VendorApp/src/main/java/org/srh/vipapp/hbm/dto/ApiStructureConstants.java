/**
 * 
 */
package org.srh.vipapp.hbm.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.srh.annotation.POJO;
import org.srh.vipapp.hbm.hql.ApiStructureConstantsQuery;

/**
 * The Entity representing the table 'branch_timings' from the 'aldi_vendor' database.
 * Date: 05 Dec 2018
 * @author Maitreyee
 */

@Entity
@Table(name="api_structure_constants")
@NamedQuery(name=ApiStructureConstantsQuery.GET_ALL_STRUCTURE_API_$N,query=ApiStructureConstantsQuery.GET_ALL_STRUCTURE_API_$Q)
@POJO(hidden= {"setCreatedBy","setModifiedBy"}, hiddenParam= {"org.srh.vipapp.hbm.dto.UserMaster","org.srh.vipapp.hbm.dto.UserMaster"})
public class ApiStructureConstants {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int apiStructId;

	@ManyToOne
	@JoinColumn(name="createdBy")
	private UserMaster createdBy;
	@ManyToOne
	@JoinColumn(name="modifiedBy")
	private UserMaster modifiedBy;

	private String constantName;
	private String displayName;
	private int deleteFlag;
	private Date createdOn = new Date();
	private Date modifiedOn = new Date();
	
	
	public int getApiStructId() {
		return apiStructId;
	}
	public void setApiStructId(int apiStructId) {
		this.apiStructId = apiStructId;
	}

	public String getConstantName() {
		return constantName;
	}
	public void setConstantName(String constantName) {
		this.constantName = constantName;
	}

	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public int getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public UserMaster getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(UserMaster createdBy) {
		this.createdBy = createdBy;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}
	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public UserMaster getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(UserMaster modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

}
