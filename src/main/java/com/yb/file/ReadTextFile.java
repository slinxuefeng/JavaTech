package com.yb.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

public class ReadTextFile {
	@Test
	public void readDocx() throws IOException {
		File file = new File("D:\\mnt\\acc.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String tempString = null;
        int i=0; 
        while ((tempString = reader.readLine()) != null) {
        	if(i++%50==0)System.out.println("已处理 "+ i +" 行"+tempString);
        }
	}
}
