package com.yashika;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yashika.blogapp.BlogPost;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BlogPostTest {

    @Test
    void testBlogPostValidCreation() {
        BlogPost post = BlogPost.builder()
                .id("1")
                .authorId("1")
                .postContent("This is a test blog post")
                .build();

        assertNotNull(post);
        assertEquals("1", post.getId());
        assertEquals("1", post.getAuthorId());
        assertEquals("This is a test blog post", post.getPostContent());
    }

    @Test
    void testBlogPostInvalidCreation() {
        assertThrows(IllegalArgumentException.class, () -> {
            BlogPost.builder().id(null).authorId("1").postContent("Test").build();
        });
    }

    @Test
    void testJsonSerialization() throws Exception {
        BlogPost post = BlogPost.builder()
                .id("1")
                .authorId("1")
                .postContent("This is a test blog post")
                .build();

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(post);
        BlogPost deserializedPost = mapper.readValue(json, BlogPost.class);

        assertEquals(post, deserializedPost);
    }
}
