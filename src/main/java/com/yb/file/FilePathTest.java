package com.yb.file;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.junit.Test;

public class FilePathTest {

	@Test
	public void readFilePath() throws IOException {
		File f = new File(this.getClass().getResource("/").getPath()); 
		System.out.println("1."+f); 
		
		File f2 = new File(this.getClass().getResource("").getPath()); 
		System.out.println("2."+f2); 
		
		File directory = new File("");//参数为空 
		String courseFile = directory.getCanonicalPath() ; 
		System.out.println("3."+courseFile); 
		
		URL xmlpath = this.getClass().getClassLoader().getResource("selected.txt"); 
		System.out.println("4."+xmlpath); 
		
		System.out.println("5."+System.getProperty("user.dir")); 
		
		System.out.println("6."+System.getProperty("java.class.path")); 
	}
}
