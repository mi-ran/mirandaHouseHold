package com.example.demo.web.repository;

import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.web.mvc.model.Asset;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AssetRepositoryTest {
	@Autowired
	private ElasticsearchTemplate esTemplate;
	
	@Autowired
	private AssetRepository assetRepository;
	
	@Test
	public void addIndex() {
		//esTemplate.deleteIndex(Asset.class);
		//esTemplate.createIndex(Asset.class);
		//esTemplate.putMapping(Asset.class);
		//esTemplate.refresh(Asset.class);
	}
	
	@Test
	public void getAll() {
		Iterable<Asset> result = assetRepository.findAll();
		for (Asset as : result) {
			System.out.println(as);
		}
	}
	
	@Test
	public void getByUserId() {
		List<Asset> result = assetRepository.findByUserId("");
		for (Asset as : result) {
			System.out.println(as);
		}
	}
	
	@Test
	public void getByUserIdAndAssetId() {
		Asset result = assetRepository.findByUserIdAndAssetId("", 0);
		System.out.println(result);
	}
}
