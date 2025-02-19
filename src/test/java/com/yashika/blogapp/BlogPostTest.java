package com.yashika.blogapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BlogPostTest {

    @Test
    public void testValidBlogPost() {
        BlogPost blogPost = BlogPost.builder()
                .id("1")
                .authorId("101")
                .postContent("This is a valid blog post.")
                .build();

        assertNotNull(blogPost);
        assertEquals("1", blogPost.getId());
        assertEquals("101", blogPost.getAuthorId());
        assertEquals("This is a valid blog post.", blogPost.getPostContent());
    }

    @Test
    public void testInvalidBlogPost() {
        assertThrows(IllegalArgumentException.class, () -> {
            BlogPost.builder()
                    .id(null)
                    .authorId("101")
                    .postContent("Content")
                    .build();
        });

        assertThrows(IllegalArgumentException.class, () -> {
            BlogPost.builder()
                    .id("1")
                    .authorId(null)
                    .postContent("Content")
                    .build();
        });
    }
}
