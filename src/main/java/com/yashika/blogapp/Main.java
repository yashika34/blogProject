package com.yashika.blogapp;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            // Reading JSON files
            List<Person> persons = List.of(objectMapper.readValue(new File("src/main/resources/person.json"), Person[].class));
            List<BlogPost> blogPosts = List.of(objectMapper.readValue(new File("src/main/resources/blogPosts.json"), BlogPost[].class));

            // Create Blog instance
            Blog blog = new Blog(blogPosts, persons);

            // Example of filtering posts by author age
            blog.getPostsByAuthorAge(30).forEach(System.out::println);

            // Print total number of blog posts and contributors
            System.out.println("Total Blog Posts: " + blog.getPosts().size());
            System.out.println("Total Contributors: " + blog.getContributors().size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
