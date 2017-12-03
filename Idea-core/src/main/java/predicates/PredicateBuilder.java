package predicates;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tomas on 25.11.2017.
 */
public final class PredicateBuilder {

    private CriteriaBuilder criteriaBuilder;

    private Root<?> rootEntity;

    public PredicateBuilder(CriteriaBuilder criteriaBuilder) {
        this.criteriaBuilder = criteriaBuilder;
    }

    public Predicate[] parsePredicates(PredicateInfo[] predicateInfos, Root<?> rootEntity) {
        List<Predicate> predicates = new ArrayList<>();
        this.rootEntity = rootEntity;

        for (PredicateInfo predicateInfo : predicateInfos) {
            if (!predicateInfo.isValid())
                continue;

            predicates.add(buildPredicate(predicateInfo));
        }


        return predicates.toArray(new Predicate[]{});
    }

    private Predicate buildPredicate(PredicateInfo predicateInfo) {
        Operator operator = predicateInfo.getOperator();
        String[] params = predicateInfo.getParams();
        String fieldName = predicateInfo.getFieldName();

        Path<?> i = rootEntity.get(fieldName);

        if (operator == Operator.GREATER) {
            return criteriaBuilder.gt(
                    rootEntity.get(fieldName),
                    Integer.parseInt(params[0]));
        }

        if (operator == Operator.LESS) {
            return criteriaBuilder.lt(
                    rootEntity.get(fieldName),
                    Integer.parseInt(params[0]));
        }

        if (operator == Operator.GREATER_EQUALS) {
            return criteriaBuilder.ge(
                    rootEntity.get(fieldName),
                    Integer.parseInt(params[0]));
        }

        if (operator == Operator.LESS_EQUALS) {
            return criteriaBuilder.le(
                    rootEntity.get(fieldName),
                    Integer.parseInt(params[0]));
        }

        if (operator == Operator.EQUALS) {
            return criteriaBuilder.equal(
                    rootEntity.get(fieldName),
                    params[0]);
        }

        if (operator == Operator.LIKE) {
            return criteriaBuilder.like(
                    rootEntity.get(fieldName),
                    params[0]);
        }

        if (operator == Operator.BETWEEN && params.length == 2) {
            return criteriaBuilder.between(
                    rootEntity.get(fieldName),
                    Integer.parseInt(params[0]),
                    Integer.parseInt(params[1]));
        }

        return null;
    }
}
