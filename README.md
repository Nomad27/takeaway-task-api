## Task API Framework ##
1. Framework supports GET, POST, DELETE request as of now. However can be enhanced for other request.
2. All the test data are kept under common Yaml file (src\test\resources\testdata)
3. For every test cases, we have single Data Provider which is of great importance
4. Test Data is kept in a YAML file rather json, excel, csv etc. Yaml gives huge advantages over other format in terms of readability, code minimization, maintenance

## Project Configuration Steps ##
	1.Clone this repository [CLONE] (https://github.com/Nomad27/mobiquity.git)
	2.Run 'mvn clean test'
	3.Location of report (/target/taskapi_report.html").Reports will be in HTML format here.

## Project Structure & Advantages ##
1. Its a properly layered framework means every layer has its own functionalities 

	#Data Layer (src/test/java/com/data)
		a. Data layer will read yaml, convert it into AllTestCaseData.java (src/test/java/com/data/yaml)
		b. AllTestCaseData contains a Map which contains all data present in yaml file
		c. Map is based on test cases name and their respective data
		d. At runtime Data Provider will provider only specific data to @Test method which is required
	
	#Business Layer (src/test/java/com/businesslayer)
		a. Sole purpose is to perform business logic tasks
		b. Methods expects some data and populate response POJOs (src/test/java/com/pojos)
		
	#Test Case Layer (src/test/java/com/testcases)
		a. Will get data from Data Provider, Call Business Layer for operation and perform Assertions
	

2. Data is getting picked from YAML rather excel. Make sure data is kept either in JSON, YAML or CSV but never in excel
3. Logger has been implemented and logs can be taken from "Takeawaytaskapi-test-(timesatmpvalue).txt"

