package io.digitalstate.stix.validation.contraints.hashingvocab;

import io.digitalstate.stix.vocabulary.StixVocabulary;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StixHashingVocabValidatorString implements ConstraintValidator<HashingVocab, String> {

    private Class<? extends StixVocabulary> vocabulary;

    @Override
    public void initialize(HashingVocab hashingVocabConstraint) {
        vocabulary = hashingVocabConstraint.value();
    }

    @Override
    public boolean isValid(String vocab, ConstraintValidatorContext cxt) {
        return true;
    }
}
