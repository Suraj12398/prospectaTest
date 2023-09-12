package model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Data {
	
	
Integer count;

List<Entry> entries;


}
