/** * ContactService.java 
 * Created on 2014年4月10日 下午3:27:15 
 */

package com.wcs.common.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.wcs.base.service.EntityService;
import com.wcs.base.service.LoginService;
import com.wcs.common.controller.vo.ContactVo;
import com.wcs.tih.model.Contact;

@Stateless
public class ContactService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private LoginService loginService;
	@EJB
	private EntityService entityService;

	public void saveContact(ContactVo contactVo) {

		Contact contact = getContactByContactVo(contactVo);
		if (contact.getId() == null) {
			entityService.create(contact);
		} else {
			entityService.update(contact);
		}
	}

	public Contact getContactByContactVo(ContactVo contactVo) {
		String username = loginService.getCurrentUserName();
		Date date = new Date();

		Contact contact = contactVo.getContact();

		if (contact == null) {
			contact = new Contact();
			contact.setCreatedBy(username);
			contact.setCreatedDatetime(date);
			contact.setDefunctInd("N");
		}

		contact.setUpdatedBy(username);
		contact.setUpdatedDatetime(date);
		contact.setDefunctInd(contactVo.getDefunctInd());
		contact.setAddress(contactVo.getAddress());
		contact.setCompany(contactVo.getCompany());
		contact.setEmail(contactVo.getEmail());
		contact.setMobile(contactVo.getMobile());
		contact.setPosition(contactVo.getPosition());
		contact.setRemark(contactVo.getRemark());
		contact.setTelephone(contactVo.getTelephone());
		contact.setUsername(contactVo.getUsername());

		return contact;
	}

	public List<ContactVo> findContactsBy(Map<String, Object> filter, int first, int pageSize) {
		List<Contact> contacts = entityService.findByMap(buildXsql(filter, false), filter);

		List<ContactVo> contactVos = new ArrayList<ContactVo>();
		for (Contact contact : contacts) {
			contactVos.add(getContactVoByContact(contact));
		}

		return contactVos;
	}

	public ContactVo getContactVoByContact(Contact contact) {
		ContactVo contactVo = new ContactVo();
		contactVo.setContact(contact);

		contact.setCreatedBy(contact.getCreatedBy());
		contact.setCreatedDatetime(contact.getCreatedDatetime());
		contactVo.setUpdatedBy(contact.getUpdatedBy());
		contactVo.setUpdatedDatetime(contact.getUpdatedDatetime());
		contactVo.setDefunctInd(contact.getDefunctInd());

		contactVo.setAddress(contact.getAddress());
		contactVo.setCompany(contact.getCompany());
		contactVo.setEmail(contact.getEmail());
		contactVo.setMobile(contact.getMobile());
		contactVo.setPosition(contact.getPosition());
		contactVo.setRemark(contact.getRemark());
		contactVo.setTelephone(contact.getTelephone());
		contactVo.setUsername(contact.getUsername());
		return contactVo;
	}

	public Integer findContactsCountBy(Map<String, Object> filter) {
		List<Integer> count = entityService.findByMap(buildXsql(filter, true), filter);
		return count.get(0);
	}

	public String buildXsql(Map<String, Object> filter, boolean isCount) {
		StringBuffer xsql = new StringBuffer();
		xsql.append("select");
		if (isCount) {
			xsql.append(" count(1)");
		} else {
			xsql.append(" c");
		}
		xsql.append(" from Contact c where 1=1");
		// xsql.append(" /~ and p.id = {id}~/ ");
		// xsql.append(" /~ and p.nachn = {nachn}~/ ");
		// xsql.append(" /~ and p.name2 = {name2}~/ ");
		// xsql.append(" /~ and p.orgeh = {orgeh}~/ ");
		// xsql.append(" /~ and p.email = {email}~/ ");
		return xsql.toString();
	}

	public LazyDataModel<ContactVo> findEmailHistory(final Map<String, Object> filter) {
		LazyDataModel<ContactVo> contactVos = new LazyDataModel<ContactVo>() {
			@Override
			public List<ContactVo> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters) {
				Integer rowCount = findContactsCountBy(filter);
				setRowCount(rowCount);
				return findContactsBy(filter, first, pageSize);
			}
		};

		return contactVos;
	}

	public void deleteContact(ContactVo contactVo) {
		Contact contact = contactVo.getContact();
		contact.setDefunctInd("Y");
		entityService.update(contact);
	}

}