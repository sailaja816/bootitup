package com.elibrary;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.elibrary.author.Author;
import com.elibrary.author.AuthorController;
import com.elibrary.author.AuthorService;
import com.elibrary.book.Book;

@RunWith(SpringRunner.class)
@WebMvcTest(value = AuthorController.class, secure = false)
public class AuthorControllerTest {

		@Autowired
		private MockMvc mockMvc;

		@MockBean
		private AuthorService authorService;
		
		Set<Book> books = new HashSet<>();
		Book book1 = new Book(1, "AHrry Potter", null);
		
		Author mockAuthor = new Author(1, "JK", "Rowling", "London",
				books);

		
		@Test
		public void testGetAuthorById() throws Exception {

			Mockito.when(
					authorService.getAuthor(Mockito.anyInt())).thenReturn(mockAuthor);

			RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
					"/author/getAuthor?id=1").accept(
					MediaType.APPLICATION_JSON);

			MvcResult result = mockMvc.perform(requestBuilder).andReturn();

			System.out.println(result.getResponse());
			String expected = "{\"id\":1,\"firstName\":\"JK\",\"lastName\":\"Rowling\",\"city\":\"London\",\"books\":[]}";
			System.out.println(result.getResponse()
					.getContentAsString());
			
			JSONAssert.assertEquals(expected, result.getResponse()
					.getContentAsString(), false);
		}
		
		@Test
		public void testcreateAuthor() throws Exception {
			Author mockAuthor = new Author(1, "JK", "Rowling", "London",
					books);
			String expected = "{\"id\":1,\"firstName\":\"JK\",\"lastName\":\"Rowling\",\"city\":\"London\",\"books\":[]}";
			
			// studentService.addCourse to respond back with mockCourse
			Mockito.when(
					authorService.addAuthor(Mockito.any(Author.class))).thenReturn(mockAuthor);
			String exampleCourseJson = "{\"name\":\"Spring\",\"description\":\"10 Steps\",\"steps\":[\"Learn Maven\",\"Import Project\",\"First Exasmple\",\"Second Example\"]}";

			// Send course as body to /students/Student1/courses
			RequestBuilder requestBuilder = MockMvcRequestBuilders
					.post("/author/addAuthor")
					.accept(MediaType.APPLICATION_JSON).content(exampleCourseJson)
					.contentType(MediaType.APPLICATION_JSON);

			MvcResult result = mockMvc.perform(requestBuilder).andReturn();

			MockHttpServletResponse response = result.getResponse();

			assertEquals(HttpStatus.OK.value(), response.getStatus());
			
			System.out.println(response.getHeader(HttpHeaders.LOCATION));

			JSONAssert.assertEquals(expected, result.getResponse()
					.getContentAsString(), false);

		}


	}

