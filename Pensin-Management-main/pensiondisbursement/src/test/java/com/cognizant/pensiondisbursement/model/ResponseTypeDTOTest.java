package com.cognizant.pensiondisbursement.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

class ResponseTypeDTOTest {

	LocalDateTime now = LocalDateTime.now();

	ResponseTypeDTO dto = new ResponseTypeDTO();

	

	@Test
	void testGetErrMsg() {
		dto.setErrMsg("Not found");
		assertEquals("Not found", dto.getErrMsg());
	}

	@Test
	void testGetErrDetail() {
		dto.setErrDetail(HttpStatus.NOT_FOUND);
		assertEquals(HttpStatus.NOT_FOUND, dto.getErrDetail());
	}

	@Test
	void testGetTimestamp() {
		dto.setTimestamp(now);
		assertEquals(now, dto.getTimestamp());

	}

	@Test
	void testGetStatus() {
		dto.setStatus(404);
		assertEquals(404, dto.getStatus());
	}

	@Test
	void testSetErrMsg() {
		dto.setErrMsg("Not found");
		assertEquals("Not found", dto.getErrMsg());
	}

	@Test
	void testSetErrDetail() {
		dto.setErrDetail(HttpStatus.NOT_FOUND);
		assertEquals(HttpStatus.NOT_FOUND, dto.getErrDetail());
	}

	@Test
	void testSetTimestamp() {
		dto.setTimestamp(now);
		assertEquals(now, dto.getTimestamp());
	}

	@Test
	void testSetStatus() {
		dto.setStatus(404);
		assertEquals(404, dto.getStatus());
	}

	
	@Test
	void testResponseTypeDTOStringHttpStatusLocalDateTimeInteger() {
		ResponseTypeDTO typeDTO = new ResponseTypeDTO("Not found", HttpStatus.NOT_FOUND, now, 404);
		assertNotNull(typeDTO);
	}

	@Test
	void testResponseTypeDTO() {
		ResponseTypeDTO typeDTO = new ResponseTypeDTO();
		assertNotNull(typeDTO);
	}

}
