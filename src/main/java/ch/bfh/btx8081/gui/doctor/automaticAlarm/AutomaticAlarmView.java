package ch.bfh.btx8081.gui.doctor.automaticAlarm;

import java.util.ArrayList;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.router.Route;

import ch.bfh.btx8081.exceptions.ConditionNotAllowedException;
import ch.bfh.btx8081.model.Condition;
import ch.bfh.btx8081.model.Metric;
import ch.bfh.btx8081.model.NextCondition;
import ch.bfh.btx8081.model.Operand;

@Route(value = "condition-automatic-alarm")
public class AutomaticAlarmView extends VerticalLayout implements AutomaticAlarmInterface {

	private static final long serialVersionUID = 1L;
	public static final String TITLE = "ConditionAtomaticAlarm";

	private AutomaticAlarmListener presenter;

	private VerticalLayout conditions = new VerticalLayout();
	private ArrayList<ConditionRow> conditionRows = new ArrayList<ConditionRow>();
	private HorizontalLayout buttons = new HorizontalLayout();
	
	public AutomaticAlarmView() {

		Button saveButton = new Button("Save", event -> {
			if (this.conditionRows.size() < 1) {
				presenter.handleSetConditionClick(null);
			} else {
				try {
					presenter.handleSetConditionClick(this.getDecoratedCondition());
				} catch (ConditionNotAllowedException e) {
					if (this.conditionRows.size() < 2) {
						presenter.handleSetConditionClick(null);
					} else {
						Notification.show("A condition for an automatic alarm is not valid.");
					}
				}
			}
		});

		Button deleteButton = new Button("Delete all", event -> {
			presenter.handleDeleteConditionClick();
		});

		Button backButton = new Button("Back", event -> {
			presenter.hadleBackClick();
		});

		buttons.add(saveButton, deleteButton, backButton);
		add(conditions, buttons);

	}
	
	public Condition getDecoratedCondition() throws ConditionNotAllowedException {
		ArrayList<Condition> allConditions = new ArrayList<Condition>();
		for (ConditionRow c : conditionRows) {
			allConditions.add(c.getCondition());
		}
		Condition res = allConditions.get(allConditions.size() - 1);
		for (int i = allConditions.size() - 2; i >= 0 ; i--) {
			if (allConditions.get(i).getNextCondition() == NextCondition.NONE) {
				throw new ConditionNotAllowedException();
			} else if (allConditions.get(i).getNextCondition() == NextCondition.AND) {
//				Condition tmp = allConditions.get(i);
//				tmp.decorateAnd(res);
//				res = tmp;
				res = allConditions.get(i).decorateAnd(res);
			} else if (allConditions.get(i).getNextCondition() == NextCondition.OR) {
//				Condition tmp = allConditions.get(i);
//				tmp.decorateOr(res);
//				res = tmp;
				res = allConditions.get(i).decorateOr(res);
			} 
		}
		return res;
	}

	public class ConditionRow {

		HorizontalLayout row = new HorizontalLayout();
		Select<String> metric = new Select<>();
		Label is = new Label("is");
		Select<String> operand = new Select<>();
		Label than = new Label("than");
		Select<String> thresholdValue = new Select<>();
		Label in = new Label("in");
		NumberField thresholdDays = new NumberField();
		Label of = new Label("day(s) of the last");
		NumberField amountOfDays = new NumberField();
		Label days = new Label("day(s)");
		Select<String> nextCondition = new Select<>();
		Icon add = VaadinIcon.PLUS_CIRCLE_O.create();
		Icon remove = VaadinIcon.MINUS_CIRCLE_O.create();

		public ConditionRow() {
			this.create();
		}

		public ConditionRow(Condition condition) {
			this.create();
			this.setMetric(condition.getMetric());
			this.setOperand(condition.getOperand());
			this.thresholdValue.setValue(String.valueOf(condition.getThresholdValue()));
			this.thresholdDays.setValue(Double.valueOf(condition.getThresholdDays()));
			this.amountOfDays.setValue(Double.valueOf(condition.getAmountOfDays()));
			this.setNextCondition(condition.getNextCondition());
		}

		public void create() {
			metric.setItems("Consumption", "Motivation", "Pressure to consume");
			metric.setPlaceholder("What");

			operand.setItems("higher", "equal or higher", "equal", "equal or lower", "lower");
			operand.setPlaceholder("higher or lower");

			thresholdValue.setItems("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
			thresholdValue.setValue("5");

			thresholdDays.setValue(1d);
			thresholdDays.setHasControls(true);
			thresholdDays.setMin(1);

			amountOfDays.setValue(1d);
			amountOfDays.setHasControls(true);
			amountOfDays.setMin(1);
			
			nextCondition.setItems("AND", "OR", "END");
			nextCondition.setValue("END");

			Button addButton = new Button(add, event -> {
				conditionRows.add(new ConditionRow());
			});

			Button removeButton = new Button(remove, event -> {
				conditions.remove(this.getRow());
				conditionRows.remove(this);
				if (conditionRows.size() < 1) {
					setCondition(null);
				}
			});

			row.add(metric, is, operand, than, thresholdValue, in, thresholdDays, of, amountOfDays, days, nextCondition, addButton,
					removeButton);
			row.setDefaultVerticalComponentAlignment(Alignment.CENTER);
			
			conditions.add(this.getRow());
		}

		public HorizontalLayout getRow() {
			return row;
		}
		
		public Condition getCondition() throws ConditionNotAllowedException {
			if(getMetric() == null || getOperand() == null) {
				throw new ConditionNotAllowedException();
			} else {
				Condition condition = new Condition(getMetric(), getOperand(), Integer.parseInt(thresholdValue.getValue()),
						thresholdDays.getValue().intValue(), amountOfDays.getValue().intValue());
				condition.setNextCondition(this.getNextCondition());
				return condition;
			}
		}

		public Metric getMetric() {
			if (metric.getValue() == null) {
				return null;
			}
			switch (metric.getValue()) {
			case "Consumption":
				return Metric.CONSUMPTION;
			case "Motivation":
				return Metric.MOTIVATION;
			case "Pressure to consume":
				return Metric.PRESSURE;
			default:
				return null;
			}
		}

		public void setMetric(Metric metric) {
			
			switch (metric) {
			case CONSUMPTION:
				this.metric.setValue("Consumption");
				break;
			case MOTIVATION:
				this.metric.setValue("Motivation");
				break;
			case PRESSURE:
				this.metric.setValue("Pressure to consume");
				break;
			default:
				break;
			}
		}

		public Operand getOperand() {
			if (operand.getValue() == null) {
				return null;
			}
			switch (operand.getValue()) {
			case "higher":
				return Operand.ISHIGHER;
			case "equal or higher":
				return Operand.ISHIGHEROREQUAL;
			case "equal":
				return Operand.ISEQUAL;
			case "equal or lower":
				return Operand.ISEQUALORLOWER;
			case "lower":
				return Operand.ISLOWER;
			default:
				return null;
			}
		}

		public void setOperand(Operand operand) {
			switch (operand) {
			case ISEQUAL:
				this.operand.setValue("equal");
				break;
			case ISEQUALORLOWER:
				this.operand.setValue("equal or lower");
				break;
			case ISHIGHER:
				this.operand.setValue("higher");
				break;
			case ISHIGHEROREQUAL:
				this.operand.setValue("equal or higher");
				break;
			case ISLOWER:
				this.operand.setValue("lower");
				break;
			default:
				break;
			}
		}
		
		public NextCondition getNextCondition() {
			if (nextCondition.getValue() == null) {
				return null;
			}
			switch (nextCondition.getValue()) {
			case "AND":
				return NextCondition.AND;
			case "OR":
				return NextCondition.OR;
			case "END":
				return NextCondition.NONE;
			default:
				return null;
			}
		}
		
		public void setNextCondition(NextCondition nextCondition) {
			switch (nextCondition) {
			case AND:
				this.nextCondition.setValue("AND");
				break;
			case OR:
				this.nextCondition.setValue("OR");
				break;
			case NONE:
				this.nextCondition.setValue("END");
				break;
			default:
				break;
			}
		}
		
	}

	@Override
	public void setCondition(Condition condition) {
		conditions.removeAll();
		conditionRows.removeAll(conditionRows);
		if (condition == null) {
			conditionRows.add(new ConditionRow());
		} else {
			// TODO Auto-generated method stub
			Condition load = condition;
			while (load != null) {
				conditionRows.add(new ConditionRow(load));
				load = load.getCondition();
			}
		}
		for (ConditionRow c : conditionRows) {
			conditions.add(c.getRow());
		}
	}

	@Override
	public void addListener(AutomaticAlarmListener presenter) {
		this.presenter = presenter;

	}

	@Override
	public void showSavedNotification() {
		Notification.show("Saved.");
	}

}
