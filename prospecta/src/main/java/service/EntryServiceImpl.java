package service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import exception.EntryException;
import model.Data;
import model.Entry;
import model.EntryDto;
import repository.EntryRepo;



	@Service
	public class EntryServiceImpl implements EntryService{
		
		@Autowired
		private RestTemplate restTemplate;
		
		@Autowired
		private EntryRepo repo;




	@Override
	public List<EntryDto> getTitlesAndDescriptions(String cat) throws EntryException {
		// TODO Auto-generated method stub
		
		
//				 here I am using restTemplate because of all  
//				the entries in my Java application for extracting 
//				title and description from entries.
				
		
				Data data = restTemplate.getForObject("https://api.publicapis.org/entries", Data.class);
				
//				As mentioned in Documentation For categories like "Science & Math" 
//				correct query would be category=science so I am 
//				spliting by space and generating the String arrray and taking the first indexed, 
				
				
				String[] strArr = cat.split(" ");
				String myCategory = strArr[0];
				
				
				
				//lambda expression for filtering
				List<EntryDto> list  = data.getEntries()
										   .stream()
										   .filter(e -> e.getCategory().contains(myCategory))
										   .map(e -> new EntryDto(e.getApi(),e.getDescription()))
										   .collect(Collectors.toList());
				
				
				return list;
	}

	@Override
	public Entry saveEntry(Entry ent) {
		// TODO Auto-generated method stub
	
				Data data = restTemplate.getForObject("https://api.publicapis.org/entries", Data.class);
				
				// getting all the entries
				List<Entry> entries = data.getEntries();
				
				
				entries.add(ent);
				
// 				here I am using my local database for 
//				storing the entry because we do not have 
//				the access of the database that is given in
//				the assignment
				for(int i=0;i<entries.size();i++) {
					
					repo.save(entries.get(i));
					
				}
				
				return ent;
	}
	
	
//	  question 1 : Part- 3
	
//  Question: what are the key things you would consider when creating/consuming an API to ensure that it is secure and reliable?

//	Ans : 1) I will use the spring security(Authentication , Authorization, CORS, CSRF) for security purpose so that only authenticated
//			person can consume my api with proper authority.
//			
//		 2) I will handle all the exceptions so that the flow of our application will remain the smooth.
//		 
//		 3) I will use the data validation part so that I can ensure that particular field will can contain
//		 only specifics values.
	
//		 4) I will make sure that endpoints are correct while fetching
//		 5) I will use comments so that others developers can also know that the functionalities of API's.
//	
}