package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import exception.EntryException;
import model.Entry;
import model.EntryDto;
import service.EntryService;

@RestController
public class EntryController {
	@Autowired
	private EntryService service;
	
	@GetMapping("checking")
	public String checking() {
		return "it's working fine...";
	}
	
	
	@GetMapping("/entries/{category}")
	public ResponseEntity<List<EntryDto>> myGetTitlesAndDescriptionsHandler(@PathVariable("category") String cat) throws EntryException{
		
		
		List<EntryDto> entryDtos = service.getTitlesAndDescriptions(cat);
		
		
		return new ResponseEntity<List<EntryDto>>(entryDtos,HttpStatus.OK);
	}
	
	
	@PostMapping("/entries")
	public ResponseEntity<Entry> mySaveEntryHandler(@RequestBody Entry ent) {
		
		Entry savedObj = service.saveEntry(ent);
		
		return new ResponseEntity<Entry>(savedObj,HttpStatus.CREATED);
	}
	
}
