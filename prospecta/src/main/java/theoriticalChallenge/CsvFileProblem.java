package theoriticalChallenge;

public class CsvFileProblem {

	
//	Question : Suppose you have a CSV file with the data below.
//
//	A1: 5, A2: 7, A3: 9, B1: 3, B2: 8, B3: =4+5, C1: =5+A1, C2: =A2+B2, C3: =C2+B3
//
//
//	I want a program that will take the CSV input above and produce CSV output 
//	with the results. If it is a value, then return a value. If it is a formula then
//	calculate the formula and return the value of that formula
//	 
//	 
//	 
//	 Question 1 :  How will you tackle the challenge above?
//	 
	
//	 Answer :  The following steps needs to be followed to solve the above problem
//	 
//	 1 :  I will Create a file with extension .CSV as : `input.csv` put the comma separated values in this file 
//	 			to able to read the file in our Java application using object of BufferReader() class. Also create an object
//	 			of BufferWriter() to write our results into another file
//	 			
//	          
//	          `BufferedReader bufferedReader = new BufferedReader(new FileReader("input.csv");`
//	          `BufferedWriter bufferedWriter = new BufferedWriter(new FileReader("output.csv");`
//	          
//	         
//	 
//	 2 :  With the help of BufferedReader() class object, read the `input.csv` file by using readLine() method.
//	 
//	          `String data = bufferedReader.readLine();`
//	          
//	 
//	 3 : I will Convert this whole string in Array of String by splitting the values by comma(,).
//	 
//	         String[] keys = data.split(", ");
//	         
//	 
//	 4 : Create a map and iterate through array and store the value as `key: value` pairs
//	 
//	 		
//	 		 Map<String, String> myMap = new LinkedHashMap<>();
//	 		 
//	 		 
//	 		 for(int i = 0;i < key.length(); i++){
//	 		 
//		 		 String[] temp = keys[i].split(": ");
	
	
//		 		 map.put(temp[0].trim(), temp[1].trim());
	
//	 		 }
//	 
//	5 : Iterate through the map created above, for values which can be parsed using Integer.parseInt() that should be written in the output file.
//		Where as for all the Exception we know it is a formula starting with "=" where the main formula will be after "=". So we will
//		
//		for (Map.Entry<String, String> m: myMap.entrySet()) {
//			try {
//			int value = Integer.parse(m.getValue());
//			} catch (Exception e) {
//				String formula = m.getValue().substring(1);
//			}
//		}
//	        
//	6: we can Use JavaScript engine to evaluate the expression
//		
//			ScriptEngineManager manager = new ScriptEngineManager();
//	        ScriptEngine engine = manager.getEngineByName("JavaScript");
//
//	      
//	            Object result = engine.eval("4+5");
//	            System.out.println(result); // Output: 9
//	        
//	        
//	7: save the values as comma separate in the output.csv file using bufferWriter.write() method.
//
//
//
//	Question 2 :  What type of errors you would you check for?
//
//	Ans : There might be few types of error like: 
//
//	      1. Catch FileNotFoundException. In reading data with BufferReader and converting it into proper strings. 
//	         
//	      2. In finding that it is normal Integer value of function of string which key here.
//	         For solving that I will use Regular Expressions to match it and finding if there will 
//	         be any Integer value without connected with any Character(A-Z) at the front of that.
//	         
//	      3. And one more thing we need to care about = , : and + sign as well.
//	      
//	      4. Wrong syntax for the formula :  "+B1"
//	      
//		  5. Circular dependency  : When like A1 = B1 and  B1 = A1 , both referring to each other
//	      
//	      
//
//	 Question 3 : How might a user break your code?
//	 
//	 Ans :  Following ways user can break our code :
	
//		By making changes to CSV which can lead to invalid CSV format i.e. not separating with commas properly 
	
//		By using unsupported functions or formulas
	
	
//		By using providing invalid data types  : non-numeric values in cells that are expected to contain numbers
//	
	
}
