package com;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LanguageKnowledge {
    private Set<String> languagesKnownByAll;
    private Set<String> languagesKnownByAny;

    public LanguageKnowledge() {
        languagesKnownByAll = new HashSet<>();
        languagesKnownByAny = new HashSet<>();
    }

    public void addStudentLanguages(List<String> studentLanguages) {
        Set<String> currentStudentLanguages = new HashSet<>(studentLanguages);

        if (languagesKnownByAll.isEmpty()) {
            languagesKnownByAll.addAll(currentStudentLanguages);
        } else {
            languagesKnownByAll.retainAll(currentStudentLanguages);
        }

        languagesKnownByAny.addAll(currentStudentLanguages);
    }

    public Set<String> getLanguagesKnownByAll() {
        return languagesKnownByAll;
    }

    public Set<String> getLanguagesKnownByAny() {
        return languagesKnownByAny;
    }
}
