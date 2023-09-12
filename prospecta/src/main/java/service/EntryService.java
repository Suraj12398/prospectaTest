package service;

import java.util.List;

import exception.EntryException;
import model.Entry;
import model.EntryDto;

public interface EntryService {

public List<EntryDto> getTitlesAndDescriptions(String category) throws EntryException;
	
	public Entry saveEntry(Entry entry);
}
