package com.kumar.ritu.takeaway.data;

import com.kumar.ritu.takeaway.data.yaml.AllTestCaseData;
import com.kumar.ritu.takeaway.data.yaml.TestData;
import org.testng.annotations.DataProvider;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Here we have single DP method for any type of data present in all_test_data.yaml
 * 
 * @author Ritu
 */
public class DataProviderClass {


	@DataProvider(name="common_test_data_provider")
	public Object[][] getDataFromYamlFile(Method method)
	{
		Yaml yaml = new Yaml();
		AllTestCaseData allTestCaseData = null;
		String testCasePath = ".\\src\\test\\resources\\testdata\\all_test_data.yaml";
		
		
		try {
			allTestCaseData = yaml.loadAs(new FileReader(new File(testCasePath)), AllTestCaseData.class);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		String testCaseName = method.getName();
		List<TestData> testDataSets = allTestCaseData.getAllTestCaseDataMap().get(testCaseName);  //list will be specific for @test method

		Object[][] data = new Object[testDataSets.size()][1]; //on runtime, rows will be decided, column will always be 1 in all the cases
		
		//on runtime Object[n][1] array will be populated based on list size
		for (int i = 0; i < testDataSets.size(); i++) {
			data[i][0] = testDataSets.get(i);
		}
	
		return data;
	}
	
	
}
