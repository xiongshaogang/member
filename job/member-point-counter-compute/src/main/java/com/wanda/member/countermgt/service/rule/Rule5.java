package com.wanda.member.countermgt.service.rule;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.wanda.member.countermgt.data.TCinemaTicket;
import com.wanda.member.countermgt.service.Condition;
import com.wanda.member.countermgt.service.CounterComputeRule;
import com.wanda.member.countermgt.service.RuleCondition;
import com.wanda.member.upgrade.data.TMember;
@Service("rule5")
@Scope("prototype")
public class Rule5 extends AbstractCounterRule {
	@Resource(name="nullCounterRule")
	protected CounterComputeRule nullCounterRule = null;
	@Resource(name="rule6")
	protected CounterComputeRule rule6 = null;
	@Resource(name="setCounterRule")
	protected CounterComputeRule setCounterRule = null;
	@Override
	protected void handleMutiple(TMember memeber) {
		currentRule = rule6;
	}

	@Override
	protected void handleNull(TMember memeber) throws Exception {
		throw new UnsupportedOperationException();
	}

	@Override
	protected void handleUnique(TMember memeber) {
		TCinemaTicket re = counterComputeServcie.getTicketLastBuy(memeber.getMemberId());
		memeber.setRegistCinemaId(new BigDecimal(re.getCinemaKey()));
		currentRule = setCounterRule;
	}

	@Override
	protected Condition getCondition(TMember memeber) {
		 List<TCinemaTicket> re = counterComputeServcie.getTicketLastBuys(memeber.getMemberId());
		RuleCondition condition = genCondition(re);
		return condition;
	}
	@Override
	public String getRuleId() {
		return "5";
	}
}
