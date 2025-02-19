package com.yourname;

import com.yashika.blogapp.Blog;
import com.yashika.blogapp.BlogPost;
import com.yashika.blogapp.Person;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BlogTest {

    @Test
    void testGetPostsByAuthorAge() {
        // Create test data
        Person person1 = Person.builder().id("1").firstName("John").lastName("Doe").age(25).gender("Male").build();
        Person person2 = Person.builder().id("2").firstName("Jane").lastName("Doe").age(30).gender("Female").build();

        BlogPost post1 = BlogPost.builder().id("1").authorId("1").postContent("Test content 1").build();
        BlogPost post2 = BlogPost.builder().id("2").authorId("2").postContent("Test content 2").build();
        BlogPost post3 = BlogPost.builder().id("3").authorId("1").postContent("Test content 3").build();

        Blog blog = new Blog(Arrays.asList(post1, post2, post3), Arrays.asList(person1, person2));

        // Test for age 25
        List<String> postIds = blog.getPostsByAuthorAge(25);
        assertEquals(2, postIds.size());
        assertTrue(postIds.contains("1"));
        assertTrue(postIds.contains("3"));

        // Test for age 30
        postIds = blog.getPostsByAuthorAge(30);
        assertEquals(1, postIds.size());
        assertTrue(postIds.contains("2"));

        // Test for non-existent age
        postIds = blog.getPostsByAuthorAge(40);
        assertEquals(0, postIds.size());
    }

    @Test
    void testMissingAuthorInPosts() {
        Person person1 = Person.builder().id("1").firstName("John").lastName("Doe").age(25).gender("Male").build();
        BlogPost post = BlogPost.builder().id("1").authorId("999").postContent("Test content").build(); // Invalid author ID

        Blog blog = new Blog(Arrays.asList(post), Arrays.asList(person1));

        List<String> postIds = blog.getPostsByAuthorAge(25);
        assertTrue(postIds.isEmpty()); // Should be empty since author ID doesn't exist
    }
}
