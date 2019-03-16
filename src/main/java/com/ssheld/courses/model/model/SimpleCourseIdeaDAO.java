package com.ssheld.courses.model.model;

import java.util.List;
import java.util.ArrayList;

/**
 * Author: Stephen Sheldon 3/14/2019
 */

public class SimpleCourseIdeaDAO implements CourseIdeaDAO {

    private List<CourseIdea> ideas;

    public SimpleCourseIdeaDAO() {
        ideas = new ArrayList<>();
    }

    @Override
    public boolean add(CourseIdea idea) {
        return ideas.add(idea);
    }

    @Override
    public List<CourseIdea> findAll() {
        return new ArrayList<>(ideas);
    }

    @Override
    public CourseIdea findBySlug(String slug) {
        return ideas.stream().filter(idea -> idea.getSlug()
                .equals(slug))
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }
}
