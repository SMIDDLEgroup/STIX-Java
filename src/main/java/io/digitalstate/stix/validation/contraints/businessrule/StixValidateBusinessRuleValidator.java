package io.digitalstate.stix.validation.contraints.businessrule;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.SpelCompilerMode;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class StixValidateBusinessRuleValidator implements ConstraintValidator<BusinessRule, Object> {

    private String ifExp;
    private String thenExp;
    private String errorMessage;
    private boolean expectedResult;

    //@TODO review compilation settings and how to optimize this
    private SpelParserConfiguration spelConfig = new SpelParserConfiguration(SpelCompilerMode.MIXED, Thread.currentThread().getContextClassLoader());
    private ExpressionParser parser = new SpelExpressionParser(spelConfig);

    @Override
    public void initialize(BusinessRule constraintAnnotation) {
        ifExp = constraintAnnotation.ifExp();
        thenExp = constraintAnnotation.thenExp();
        errorMessage = constraintAnnotation.errorMessage();
        expectedResult = constraintAnnotation.expectedResult();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext cxt) {
        return true;
    }
}
