package com.alsaba.backend;

import com.alsaba.backend.repository.PaysRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BackendApplicationTests {

	@Autowired
	PaysRepository paysRepository ;

	@Test
	void contextLoads() {

	}

}
