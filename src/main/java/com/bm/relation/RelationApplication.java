package com.bm.relation;

import com.bm.relation.core.config.BaseRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * 程序入口
 * @author : zyg
 * @since : 2022/07/19
 **/
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableMongoRepositories(repositoryBaseClass = BaseRepository.class)
public class RelationApplication {

	public static void main(String[] args) {
		SpringApplication.run(RelationApplication.class, args);
	}

}
