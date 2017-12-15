package sk.upjs.ics.predicates;

/**
 * Created by Tomas on 25.11.2017.
 */
public class PredicateInfo {

    private String fieldName;

    private Operator operator;

    private String[] params;

    public PredicateInfo(String fieldName, Operator operator, String[] params) {
        this.fieldName = fieldName;
        this.operator = operator;
        this.params = params;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Operator getOperator() {
        return operator;
    }

    public String[] getParams() {
        return params;
    }

    public boolean isValid() {
        return !(fieldName == null || operator == null || params == null
                || (operator == Operator.BETWEEN && params.length < 2)
                || params.length < 1);
    }
}
