package com.wanda.ccs.service.impl;

import com.wanda.ccs.model.AbstractStateUVEntity;
import com.wanda.ccs.model.State;
import com.wanda.ccs.service.IStateUVService;
import com.xcesys.extras.core.util.DateUtil;
import com.xcesys.extras.util.SecurityUtil;

public abstract class BaseStateUVServiceImpl<T extends AbstractStateUVEntity>
		extends BaseApprovableUVServiceImpl<T> implements IStateUVService<T> {

	@Override
	public void approve(Long id) {
		T o = findById(id);
		((AbstractStateUVEntity) o).setState(((AbstractStateUVEntity) o).getState()
				.desire(State.APPROVED));
		o.setApproved(Boolean.TRUE);
		o.setApprovedTime(DateUtil.getCurrentDate());
		o.setApprovedBy(SecurityUtil.getLoginUser());
		super.update(o);

	}

	@Override
	public void cancelSubmit(Long id) {
		T o = findById(id);
		((AbstractStateUVEntity) o).setState(((AbstractStateUVEntity) o).getState()
				.desire(State.CANCEL));
		o.setSubmit(Boolean.FALSE);
		o.setSubmitTime(null);
		o.setSubmitBy(null);
		super.update(o);
	}

	@Override
	public void submit(Long id) {
		T o = findById(id);
		((AbstractStateUVEntity) o).setState(((AbstractStateUVEntity) o).getState()
				.desire(State.SUBMIT));
		o.setSubmit(Boolean.TRUE);
		o.setSubmitTime(DateUtil.getCurrentDate());
		o.setSubmitBy(SecurityUtil.getLoginUser());
		super.update(o);
	}
	
	@Override
	public void cancelApprove(Long id) {
		T o = findById(id);
		((AbstractStateUVEntity) o).setState(((AbstractStateUVEntity) o).getState()
				.desire(State.REJECTED));
		o.setSubmit(Boolean.FALSE);
		o.setApproved(Boolean.FALSE);
		o.setApprovedTime(DateUtil.getCurrentDate());
		o.setApprovedBy(SecurityUtil.getLoginUser());
		super.update(o);
	}
	@Override
	public void published(Long[] ids){}
}
