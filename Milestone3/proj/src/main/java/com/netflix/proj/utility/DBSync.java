package com.netflix.proj.utility;

import java.text.SimpleDateFormat;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.netflix.proj.DataLoader;
import com.netflix.proj.Entity.Title;
import com.netflix.proj.repo.TitleRepo;
import com.netflix.proj.repo.TitleRepository;

@Component
public class DBSync {
	
	@Autowired
	TitleRepo repo;
	
	@Autowired
	TitleRepository trepo;
	
	
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	
	@Scheduled(fixedRate = 15000)
	public void syncRecords() {
		System.out.println("got in");
		DataLoader.loadData();
		Map<Integer, Title> mp = repo.getMp();
		String id;
		for(int key: mp.keySet()) {
			id = mp.get(key).getShow_id();
			if(trepo.findById(id).isEmpty()) {
				trepo.save(mp.get(key));
			}
		}
	}
}
