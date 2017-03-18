package com.yb.xml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.DOMReader;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;
import org.xml.sax.SAXException;

public class Dom4jTest {
	//@Test
	public void readDom4j() throws DocumentException, ParserConfigurationException, SAXException, IOException {
		SAXReader saxReader = new SAXReader();
		Document document = saxReader.read(new File(this.getClass().getResource("").getPath() + "/CityMapper.xml"));
		// 获取根元素
		Element root = document.getRootElement();
		System.out.println("Root: " + root.getName());

		// 获取所有子元素
		List<Element> childList = root.elements();
		System.out.println("total child count: " + childList.size());

		// 获取特定名称的子元素
		List<Element> childList2 = root.elements("hello");
		System.out.println("hello child: " + childList2.size());

		// 获取名字为指定名称的第一个子元素
		Element firstWorldElement = root.element("resultMap");
		// 输出其属性
		 System.out.println("first World Attr: "
		 + firstWorldElement.attribute(0).getName() + "="
		 + firstWorldElement.attributeValue("id"));

		System.out.println("迭代输出-----------------------");
		// 迭代输出
		for (Iterator iter = root.elementIterator(); iter.hasNext();) {
			Element e = (Element) iter.next();
			System.out.println(e.attributeValue("id"));
		}
	}
	
	@Test
	public void writeDom4j() throws DocumentException, IOException {
		// 第一种方式：创建文档，并创建根元素
        // 创建文档:使用了一个Helper类
        Document document = DocumentHelper.createDocument();

        // 创建根节点并添加进文档
        Element root = DocumentHelper.createElement("student");
        document.setRootElement(root);

        // 第二种方式:创建文档并设置文档的根元素节点
        Element root2 = DocumentHelper.createElement("student");
        Document document2 = DocumentHelper.createDocument(root2);

        // 添加属性
        root2.addAttribute("name", "zhangsan");
        // 添加子节点:add之后就返回这个元素
        Element helloElement = root2.addElement("hello");
        Element worldElement = root2.addElement("world");

        helloElement.setText("hello Text");
        worldElement.setText("world text");

        // 输出
        // 输出到控制台
        XMLWriter xmlWriter = new XMLWriter();
        xmlWriter.write(document);

        // 输出到文件
        // 格式
        OutputFormat format = new OutputFormat("    ", true);// 设置缩进为4个空格，并且另起一行为true
        XMLWriter xmlWriter2 = new XMLWriter(
                new FileOutputStream("student.xml"), format);
        xmlWriter2.write(document2);

        // 另一种输出方式，记得要调用flush()方法,否则输出的文件中显示空白
        XMLWriter xmlWriter3 = new XMLWriter(new FileWriter(this.getClass().getResource("").getPath() + "/student2.xml"),
                format);
        xmlWriter3.write(document2);
        xmlWriter3.flush();
        // close()方法也可以
	}
}
