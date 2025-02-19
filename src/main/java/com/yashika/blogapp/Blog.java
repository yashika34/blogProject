package com.yashika.blogapp;

import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Getter
@ToString
public class Blog {

    private final List<BlogPost> posts;
    private final List<Person> contributors;

    public Blog(List<BlogPost> posts, List<Person> contributors) {
        if (posts == null) throw new IllegalArgumentException("Posts cannot be null");
        if (contributors == null) throw new IllegalArgumentException("Contributors cannot be null");

        this.posts = posts;
        this.contributors = contributors;
    }

    // Method to filter posts by author's age
    public List<BlogPost> getPostsByAuthorAge(int age) {
        return posts.stream()
                .filter(post -> {
                    Person author = findPersonById(post.getAuthorId());
                    return author != null && author.getAge() >= age;
                })
                .collect(Collectors.toList());
    }

    private Person findPersonById(String id) {
        return contributors.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // Manually adding the getPosts() method, in case Lombok is not generating it
    public List<BlogPost> getPosts() {
        return posts;
    }

    // Manually adding the getContributors() method, in case Lombok is not generating it
    public List<Person> getContributors() {
        return contributors;
    }
}
