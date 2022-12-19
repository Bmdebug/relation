package com.bm.relation;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class RelationApplicationTests {

	@Test
	void contextLoads() {
		List<Integer> list = Lists.newArrayList(
				65,61, 61, 62, 62, 62, 78, 86, 86, 86, 92, 70
		);

		List<Double> diff = Lists.newArrayList(10.0, 7.4, 2.8, 10.0, 5.0, 10.0);

		Integer total = 0;
		for (Integer temp: list) {
			total=total+temp;
		}
		System.out.println("total:"+total+",avg:"+total/list.size()+",size:"+list.size());
		System.out.println("*******************************************");
		Double total_diff = 0.0;
		for (Double temp: diff) {
			total_diff=total_diff+temp;
		}
		System.out.println("total_diff:"+total_diff+",avg:"+total_diff/diff.size()+",size:"+diff.size());
	}

}
