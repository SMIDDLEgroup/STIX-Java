package io.digitalstate.stix.validation.contraints.vocab;

import io.digitalstate.stix.vocabulary.StixVocabulary;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Set;

public class StixVocabValidatorCollection implements ConstraintValidator<Vocab, Set<String>> {

    private Class<? extends StixVocabulary> vocabulary;

    @Override
    public void initialize(Vocab vocabConstraint) {
        vocabulary = vocabConstraint.value();
    }

    @Override
    public boolean isValid(Set<String> vocab, ConstraintValidatorContext cxt) {
        return true;
    }
}
