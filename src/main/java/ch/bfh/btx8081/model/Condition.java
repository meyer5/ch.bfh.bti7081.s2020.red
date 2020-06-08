package ch.bfh.btx8081.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Condition {

	private Metric metric;
	private Operand operand;
	private int thresholdValue;
	private int thresholdDays;
	private int amountOfDays;

	NextCondition nextCondition = NextCondition.NONE;

	Condition condition;

	public Condition(Metric metric, Operand operand, int thresholdValue, int thresholdDays, int amountOfDays) {
		this.metric = metric;
		this.operand = operand;
		this.thresholdValue = thresholdValue;
		this.thresholdDays = thresholdDays;
		this.amountOfDays = amountOfDays;
	}

	protected Condition decorateAnd(Condition condition) {
		this.nextCondition = NextCondition.AND;
		this.condition = condition;
		return this.condition;
	}

	protected Condition decorateOr(Condition condition) {
		this.nextCondition = NextCondition.OR;
		this.condition = condition;
		return this.condition;
	}

	protected boolean isGiven(List<Entry> entries) {
		Collections.sort(entries);
		switch (this.isGiven(ConditionState.UNKNOWN, entries)) {
		case FALSE:
			return false;
		case TRUE:
			return true;
		case UNKNOWN:
			return false;
		default:
			return false;
		}
	}

	protected ConditionState isGiven(ConditionState state, List<Entry> entries) {
		switch (state) {
		case FALSE:
			switch (this.nextCondition) {
			case AND:
				return this.condition.isGiven(ConditionState.FALSE, entries);
			case NONE:
				return ConditionState.FALSE;
			case OR:
				return this.condition.isGiven(ConditionState.UNKNOWN, entries);
			}
		case TRUE:
			return ConditionState.TRUE;
		case UNKNOWN:
			switch (this.nextCondition) {
			case AND:
				if (this.check(entries)) {
					return this.condition.isGiven(ConditionState.UNKNOWN, entries);
				} else {
					return this.condition.isGiven(ConditionState.FALSE, entries);
				}
			case NONE:
				if (this.check(entries)) {
					return ConditionState.TRUE;
				} else {
					return ConditionState.FALSE;
				}
			case OR:
				if (this.check(entries)) {
					return this.condition.isGiven(ConditionState.TRUE, entries);
				} else {
					return this.condition.isGiven(ConditionState.UNKNOWN, entries);
				}
			}
		}
		return state;
	}

	private boolean check(List<Entry> entries) {
		int res = 0;
		switch (this.operand) {
		case ISEQUAL:
			for (Integer i : getValues(entries)) {
				if (i == this.thresholdValue) {
					res++;
				}
			}
			break;
		case ISEQUALORLOWER:
			for (Integer i : getValues(entries)) {
				if (i <= this.thresholdValue) {
					res++;
				}
			}
			break;
		case ISHIGHER:
			for (Integer i : getValues(entries)) {
				if (i > this.thresholdValue) {
					res++;
				}
			}
			break;
		case ISHIGHEROREQUAL:
			for (Integer i : getValues(entries)) {
				if (i >= this.thresholdValue) {
					res++;
				}
			}
			break;
		case ISLOWER:
			for (Integer i : getValues(entries)) {
				if (i < this.thresholdValue) {
					res++;
				}
			}
			break;
		default:
			break;
		}
		if (res >= this.thresholdDays) {
			return true;
		} else {
			return false;
		}
	}

	private List<Integer> getValues(List<Entry> entries) {
		List<Integer> res = new ArrayList<Integer>();
		switch (this.metric) {
		case CONSUMPTION:
			for (int i = 0; i < this.amountOfDays; i++) {
				res.add(Math.toIntExact(entries.get(i).getConsumption()));
			}
			break;
		case MOTIVATION:
			for (int i = 0; i < this.amountOfDays; i++) {
				res.add(entries.get(i).getMotivation());
			}
			break;
		case PRESSURE:
			for (int i = 0; i < this.amountOfDays; i++) {
				res.add(entries.get(i).getPressureToConsume());
			}
			break;
		default:
			return null;
		}
		return res;
	}

}
