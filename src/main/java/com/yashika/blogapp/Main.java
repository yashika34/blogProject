package com.yashika.blogapp;

import com.fasterxml.jackson.databind.ObjectMapper;

package com.yourname;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yashika.blogapp.Blog;
import com.yashika.blogapp.BlogPost;
import com.yashika.blogapp.Person;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();

        // Read person.json and blogPosts.json into lists
        List<Person> persons = readPersonsFromFile(mapper, "src/main/resources/person.json");
        List<BlogPost> blogPosts = readBlogPostsFromFile(mapper, "src/main/resources/blogPosts.json");

        if (persons == null || blogPosts == null) {
            System.out.println("Error reading files or data is corrupt");
            return;
        }

        // Create a Blog instance with the read data
        Blog blog = new Blog(blogPosts, persons);

        // Get posts by author age (for demonstration, let's use age 25)
        List<String> postIds = blog.getPostsByAuthorAge(25);
        System.out.println("Posts by author age 25: " + postIds);

        // Print total number of blog posts and contributors
        System.out.println("Total number of blog posts: " + blog.getPosts().size());
        System.out.println("Total number of contributors: " + blog.getContributors().size());
    }

    // Method to read persons from a JSON file
    private static List<Person> readPersonsFromFile(ObjectMapper mapper, String filePath) {
        try {
            return mapper.readValue(new File(filePath), mapper.getTypeFactory().constructCollectionType(List.class, Person.class));
        } catch (IOException e) {
            System.out.println("Error reading persons from file: " + e.getMessage());
            return null;
        }
    }

    // Method to read blog posts from a JSON file
    private static List<BlogPost> readBlogPostsFromFile(ObjectMapper mapper, String filePath) {
        try {
            return mapper.readValue(new File(filePath), mapper.getTypeFactory().constructCollectionType(List.class, BlogPost.class));
        } catch (IOException e) {
            System.out.println("Error reading blog posts from file: " + e.getMessage());
            return null;
        }
    }
}
