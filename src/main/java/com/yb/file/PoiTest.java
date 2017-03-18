package com.yb.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.poi.POIXMLProperties.CoreProperties;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Paragraph;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.hwpf.usermodel.Table;
import org.apache.poi.hwpf.usermodel.TableCell;
import org.apache.poi.hwpf.usermodel.TableIterator;
import org.apache.poi.hwpf.usermodel.TableRow;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.IBodyElement;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.junit.Test;

/**
 * HSSF: MS－Excel 97-2003（.xls），基于BIFF8格式的JAVA接口。 XSSF：MS－Excel
 * 2007+(.xlsx),基于OOXML格式的JAVA接口。
 * 
 * HWPF: MS－Word
 * 97-2003(.doc)，基于BIFF8格式的JAVA接口。只支持.doc文件简单的操作，读写能力有限。本API为POI项目早期开发，很不幸的
 * 是主要负责HWPF模块开发的工程师-“Ryan Ackley”已经离开Apache组织，现在该模块没有人维护、更新、完善。 XWPF：MS－Word
 * 2007+(.docx),基于OOXML格式的JAVA接口。较HWPF功能完善。
 * 
 * @Project : com.yb.springmvc Maven Webapp
 * @Program : com.yb.test.PoiTest.java
 * @Class : PoiTest
 * @Description : 类描述
 * @Author : 杨斌
 * @Creation : 2017年3月11日 下午1:14:28
 * @ModificationHistory Who When What -------- ----------
 *                      ----------------------------------- 杨斌 2017年3月11日 TODO
 */
public class PoiTest {

	@Test
	public void readDocx() throws IOException {
		InputStream is = ReadPorperties.class.getClassLoader()
				.getResourceAsStream("com/yb/file/公司注册相关V1.0.docx");

		XWPFDocument doc = new XWPFDocument(is);
		List<XWPFParagraph> paras = doc.getParagraphs();

		List tmpList;
		XWPFRun tmpXWPFRun;
		int rownum = 0;
		for (XWPFParagraph para : paras) {
			// 当前段落的属性
			// CTPPr pr = para.getCTP().getPPr();
			System.out.println(
					"(" + rownum++ + ")、:" + para.getParagraphText() + "*******" + para.getIndentationLeft() + "-----");
			tmpList = para.getRuns();
			for (int i = 0; i < tmpList.size(); i++) {
				tmpXWPFRun = (XWPFRun) tmpList.get(i);
				System.out.println(tmpXWPFRun + "::" + tmpXWPFRun.getColor());
			}
		}
		is.close();
	}

}
