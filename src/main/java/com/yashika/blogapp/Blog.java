package com.yashika.blogapp;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@ToString
@EqualsAndHashCode
public class Blog {

    private final List<BlogPost> posts;
    private final List<Person> contributors;

    public Blog(List<BlogPost> posts, List<Person> contributors) {
        this.posts = posts;
        this.contributors = contributors;
    }

    // Method to get BlogPost IDs based on author's age
    public List<String> getPostsByAuthorAge(Integer age) {
        return posts.stream()
                .filter(post -> {
                    Person author = findAuthorById(post.getAuthorId());
                    return author != null && author.getAge().equals(age);
                })
                .map(BlogPost::getId)
                .collect(Collectors.toList());
    }

    // Helper method to find a Person by ID
    private Person findAuthorById(String authorId) {
        return contributors.stream()
                .filter(person -> person.getId().equals(authorId))
                .findFirst()
                .orElse(null);
    }
}
