package io.digitalstate.stix.validation.contraints.vocab;

import io.digitalstate.stix.vocabulary.StixVocabulary;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StixVocabValidatorString implements ConstraintValidator<Vocab, String> {

    private Class<? extends StixVocabulary> vocabulary;

    @Override
    public void initialize(Vocab vocabConstraint) {
        vocabulary = vocabConstraint.value();
    }

    @Override
    public boolean isValid(String vocab, ConstraintValidatorContext cxt) {
        return true;
    }
}
