package com.aotu.service.impl;

import com.aotu.dao.DeliverDAO;
import com.aotu.entity.Deliver;
import com.aotu.entity.Page;
import com.aotu.service.IDeliverService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("deliverService")
public class DeliverServiceImpl implements IDeliverService {

	@Autowired
	private DeliverDAO deliverDAO;

	public void save(Deliver deliver) throws Exception {
		this.deliverDAO.save(deliver);
	}

	public void delete(String id) throws Exception {
		this.deliverDAO.delete(id);
	}	

	public void update(Deliver deliver) throws Exception {
		this.deliverDAO.update(deliver);
	}

	public Deliver get(String id) throws Exception {
		return (Deliver)this.deliverDAO.get(id);
	}

	public Page queryPage(Page page, Deliver deliver) throws Exception {
		int totalRecordsNum = this.deliverDAO.queryCount(deliver);
		page.setTotalRecordsNum(totalRecordsNum);

		List records = this.deliverDAO.queryPage(page.getPageSize(), page.getStartIndex(), deliver);
		page.setRecords(records);
		return page;
	}

	public List<Deliver> queryList(Deliver deliver) throws Exception {
		return this.deliverDAO.queryList(deliver);
	}

	public int queryCount(Deliver deliver) throws Exception {
		return this.deliverDAO.queryCount(deliver);
	}
	
}