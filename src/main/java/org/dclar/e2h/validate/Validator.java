package org.dclar.e2h.validate;

import org.dclar.e2h.entity.Rule;

import java.util.List;

public interface Validator {

    List<String> validate();

    boolean support(Rule rule);
}
