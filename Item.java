This is a multi-part message in MIME format.

------=_NextPart_000_000C_01CEA243.E01AE2D0
Content-Type: multipart/alternative;
	boundary="----=_NextPart_001_000D_01CEA243.E01D53D0"


------=_NextPart_001_000D_01CEA243.E01D53D0
Content-Type: text/plain;
	charset="iso-2022-jp"
Content-Transfer-Encoding: 7bit

 

 

$B!!!!MM(B

$B$$$D$b$*@$OC$K$J$C$F$*$j$^$9!"%S%C%H%&%'%"$NAb$G$9!#(B

 

 

$B0J>e!"$h$m$7$/$*4j$$$$$?$7$^$9!#(B

 


------=_NextPart_001_000D_01CEA243.E01D53D0
Content-Type: text/html;
	charset="iso-2022-jp"
Content-Transfer-Encoding: quoted-printable

<html xmlns:o="urn:schemas-microsoft-com:office:office" xmlns:w="urn:schemas-microsoft-com:office:word" xmlns="http://www.w3.org/TR/REC-html40">

<head>
<meta http-equiv=Content-Type content="text/html; charset=iso-2022-jp">
<meta name=Generator content="Microsoft Word 11 (filtered medium)">
<style>
<!--
 /* Font Definitions */
 @font-face
	{font-family:"$B#M#S(B $BL@D+(B";
	panose-1:2 2 6 9 4 2 5 8 3 4;}
@font-face
	{font-family:"$B#M#S(B $B%4%7%C%/(B";
	panose-1:2 11 6 9 7 2 5 8 2 4;}
@font-face
	{font-family:Century;
	panose-1:2 4 6 4 5 5 5 2 3 4;}
@font-face
	{font-family:"\@$B#M#S(B $BL@D+(B";
	panose-1:2 2 6 9 4 2 5 8 3 4;}
@font-face
	{font-family:"\@$B#M#S(B $B%4%7%C%/(B";
	panose-1:2 11 6 9 7 2 5 8 2 4;}
 /* Style Definitions */
 p.MsoNormal, li.MsoNormal, div.MsoNormal
	{margin:0mm;
	margin-bottom:.0001pt;
	text-align:justify;
	text-justify:inter-ideograph;
	font-size:10.5pt;
	font-family:Century;}
a:link, span.MsoHyperlink
	{color:blue;
	text-decoration:underline;}
a:visited, span.MsoHyperlinkFollowed
	{color:purple;
	text-decoration:underline;}
span.EmailStyle17
	{mso-style-type:personal-compose;
	font-family:Arial;
	color:windowtext;}
 /* Page Definitions */
 @page Section1
	{size:595.3pt 841.9pt;
	margin:99.25pt 30.0mm 30.0mm 30.0mm;
	layout-grid:18.0pt;}
div.Section1
	{page:Section1;}
-->
</style>

</head>

<body lang=JA link=blue vlink=purple style='text-justify-trim:punctuation'>

<div class=Section1 style='layout-grid:18.0pt'>

<p class=MsoNormal><font size=2 face=Arial><span lang=EN-US style='font-size:
10.0pt;font-family:Arial'><o:p>&nbsp;</o:p></span></font></p>

<p class=MsoNormal><font size=2 face=Arial><span lang=EN-US style='font-size:
10.0pt;font-family:Arial'><o:p>&nbsp;</o:p></span></font></p>

<p class=MsoNormal><font size=2 face="$B#M#S(B $BL@D+(B"><span style='font-size:10.0pt;
font-family:"$B#M#S(B $BL@D+(B"'>$B!!!!MM(B</span></font><span lang=EN-US><o:p></o:p></span></p>

<p class=MsoNormal><font size=2 face="$B#M#S(B $BL@D+(B"><span style='font-size:10.0pt;
font-family:"$B#M#S(B $BL@D+(B"'>$B$$$D$b$*@$OC$K$J$C$F$*$j$^$9!"%S%C%H%&%'%"$NAb$G$9!#(B</span></font><span lang=EN-US><o:p></o:p></span></p>

<p class=MsoNormal><font size=2 face=Century><span lang=EN-US style='font-size:
10.5pt'>&nbsp;<o:p></o:p></span></font></p>

<p class=MsoNormal><font size=2 face=Century><span lang=EN-US style='font-size:
10.5pt'>&nbsp;<o:p></o:p></span></font></p>

<p class=MsoNormal><font size=2 face="$B#M#S(B $BL@D+(B"><span style='font-size:10.0pt;
font-family:"$B#M#S(B $BL@D+(B"'>$B0J>e!"$h$m$7$/$*4j$$$$$?$7$^$9!#(B</span></font><span lang=EN-US><o:p></o:p></span></p>

<p class=MsoNormal><font size=2 face=Century><span lang=EN-US><o:p>&nbsp;</o:p></span></font></p>

</div>

</body>

</html>

------=_NextPart_001_000D_01CEA243.E01D53D0--

------=_NextPart_000_000C_01CEA243.E01AE2D0
Content-Type: application/octet-stream;
	name="ClassObj.java"
Content-Transfer-Encoding: quoted-printable
Content-Disposition: attachment;
	filename="ClassObj.java"

package actiongenerator.obj;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClassObj {

	public String className;

	List<FieldObj> fields = null;

	List<ClassObj> innerClasses;

	public void addFieldObj(FieldObj obj) {
		if (fields == null) {
			fields = new ArrayList<FieldObj>();
		}
		fields.add(obj);
	}

	public void addClassObj(ClassObj obj) {
		if (innerClasses == null) {
			innerClasses = new ArrayList<ClassObj>();
		}
		innerClasses.add(obj);
	}

	static List<String> getFields(String line) {

		List<String> fielddefine = new ArrayList<String>();

		Stack<String> stack = new Stack<String>();
		boolean found = false;
		int index = 0;
		for (char c : line.toCharArray()) {
			if (c == '{') {
				stack.push("{");

			} else if (c == '}' && !stack.empty()) {
				stack.pop();

			} else if (c == ',' && stack.empty()) {
				found = true;
				break;
			}
			index++;
		}
		if (found) {
			fielddefine.add(line.substring(0, index).trim());
			fielddefine.addAll(getFields(line.substring(index + 1)));
		} else {
			fielddefine.add(line.trim());
		}

		return fielddefine;
	}

	// SpecialMessage{title string, persons List<Person{name string, sex
	// boolean, address string[]}>}
	public static ClassObj parseInnerClass(String typedefine) {
		System.out.println();
		System.out.println("【parseInnerClass】" + typedefine);

		ClassObj inner = new ClassObj();

		// クラス名
		int firstLeft = typedefine.indexOf("{");
		String classnamestring = new StringBuffer(typedefine.substring(0, firstLeft)).reverse().toString();

		Matcher classnamematcher = Pattern.compile("\\w+").matcher(classnamestring);
		if (classnamematcher.find()) {
			classnamestring = (new StringBuffer(classnamematcher.group(0))).reverse().toString();

		} else {
			System.out.println("【InnerClassがNotExist】" + typedefine);
			return null;
		}
		System.out.println("<CLASSNAME>:" + classnamestring);
		inner.className = classnamestring;

		// ClassObj / Field
		int lastRight = typedefine.lastIndexOf("}");
		String classbody = typedefine.substring(firstLeft + 1, lastRight);
		// System.out.println("<CLASSBODY>:" + classbody);

		// FIELDS
		List<String> fields = getFields(classbody);
		for (String afield : fields) {

			// ClassObjがない場合
			if (afield.indexOf("{") < 0) {

				FieldObj f = FieldObj.newFieldObj(afield);
				if (f == null) {
					System.out.println("定義エラー：" + afield);
				} else {
					System.out.println("[FIELD]" + f.toString());
					if (inner.fields == null) {
						inner.fields = new ArrayList<FieldObj>();
					}
					inner.fields.add(f);
				}

			}

			// ClassObjがある場合
			else {
				// FIELDS
				String reg_big = "\\{(.*)\\}";
				String fieldString = afield.replaceAll(reg_big, "");
				FieldObj f = FieldObj.newFieldObj(fieldString);
				if (f == null) {
					System.out.println("定義エラー：" + afield);
				} else {
					System.out.println("[FIELD]" + f.toString());
					if (inner.fields == null) {
						inner.fields = new ArrayList<FieldObj>();
					}
					inner.fields.add(f);
				}

				// ClassObj
				reg_big = "\\w+\\{(.*)\\}";
				Pattern pattern = Pattern.compile(reg_big);
				Matcher matcher = pattern.matcher(afield);

				while (matcher.find()) {
					if (inner.innerClasses == null) {
						inner.innerClasses = new ArrayList<ClassObj>();
					}
					inner.innerClasses.add(ClassObj.parseInnerClass(matcher.group(0)));

				}
			}
		}

		return inner;
	}

	public String toString() {
		return toString("");
	}

	public String toString(String tab) {
		StringBuffer sb = new StringBuffer();

		sb.append(tab + "ClassObj{\n");
		sb.append(tab + "<className>" + className + "\n");

		if (fields == null || fields.size() == 0) {
			sb.append(tab + "<fields(0)>\n");
		} else {
			sb.append(tab + "<fields(" + fields.size() + ")>\n");
			for (FieldObj obj : fields) {
				sb.append(tab + "    "+ obj.toString() + "\n");
			}
		}
		if (innerClasses == null || innerClasses.size() == 0) {
			sb.append(tab + "<innerClasses(0)>\n");
		} else {
			sb.append(tab + "<innerClasses(" + innerClasses.size() + ")>\n");
			tab = tab + "    ";

			for (ClassObj obj : innerClasses) {
				sb.append(obj.toString(tab) + "\n");
			}
		}
		sb.append(tab + "}\n");
		return sb.toString();
	}
}

------=_NextPart_000_000C_01CEA243.E01AE2D0
Content-Type: application/octet-stream;
	name="FieldObj.java"
Content-Transfer-Encoding: quoted-printable
Content-Disposition: attachment;
	filename="FieldObj.java"

package actiongenerator.obj;

public class FieldObj {

	public String fieldName;

	public String fieldType;

	public String fieldComment = "";

	public FieldObj() {
	}

	public FieldObj(String name, String type, String comment) {
		this.fieldName = name;
		this.fieldType = type;
		this.fieldComment = comment;
	}

	public static FieldObj newFieldObj(String afield) {

		FieldObj f = null;
		String[] thisfield = afield.split(" ");

		if (thisfield.length >= 2) {
			f = new FieldObj();
			f.fieldName = thisfield[0];
			f.fieldType = thisfield[1];
			if (thisfield.length > 2) {
				f.fieldComment = thisfield[2];
			}
		}
		return f;
	}

	public String toString() {
		return "FieldObj{ " + fieldType + "    " + fieldName + "    //" + fieldComment + "}";
	}
}

------=_NextPart_000_000C_01CEA243.E01AE2D0
Content-Type: application/octet-stream;
	name="Item.java"
Content-Transfer-Encoding: quoted-printable
Content-Disposition: attachment;
	filename="Item.java"

package actiongenerator.obj;


public class Item {

	public String actionName;
	public String inout;
	public String fieldname;
	public String type;
	public String comment;

	public String toString() {
		return "Item{ actionName:" + actionName + " inout:" + inout + " fieldname:" + fieldname + " type:" + type + " comment:" + comment + "}";
	}
}

------=_NextPart_000_000C_01CEA243.E01AE2D0
Content-Type: application/octet-stream;
	name="FileUtil.java"
Content-Transfer-Encoding: quoted-printable
Content-Disposition: attachment;
	filename="FileUtil.java"

package actiongenerator;
 
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import actiongenerator.obj.Item;

public class FileUtil {

	// "#"が�?ぞいて
	public static List<Item> readFile(String filename) {
		List<Item> items = new ArrayList<Item>();

		System.out.println("定義ファイル:"+ filename);
		try {
			InputStreamReader isr = new InputStreamReader(new FileInputStream(filename), "utf-8");
			BufferedReader br = new BufferedReader(isr);

			String line;
			while ((line = br.readLine()) != null) {
				if (line != null && line.trim().length() != 0 && !line.trim().startsWith("#")) {

					String[] data = line.split("\t");
					if (data.length > 4) {
						Item item = new Item();
						item.actionName = data[0];
						item.inout = data[1] ;
						item.fieldname = data[2];
						item.type = data[3];
						item.comment = data[4];
						items.add(item);
						System.out.println("     " + item);
					} else {
						System.out.println("【不正定義 length:" + data.length + "]" + line);

					}

				}

			}
			br.close();
			isr.close();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return items;
	}

	public static void writeFile(String filename, String contents) throws Exception {
		try {
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(filename), "utf-8"));
			pw.println(contents);
			pw.close();
		} catch (IOException e) {
			throw e;
		}
	}

}

------=_NextPart_000_000C_01CEA243.E01AE2D0
Content-Type: application/octet-stream;
	name="GeneratorManager.java"
Content-Transfer-Encoding: quoted-printable
Content-Disposition: attachment;
	filename="GeneratorManager.java"

package actiongenerator;

import java.util.ArrayList;
import java.util.List;

import actiongenerator.obj.ClassObj;
import actiongenerator.obj.FieldObj;
import actiongenerator.obj.Item;

public class GeneratorManager {

	public static List<ClassObj> classes = new ArrayList<ClassObj>();

	// Excelファイル
	public static void readXLS(String filename) {

	}

	// CSVファイル
	public static void readCSV(String filename) {
		// CSVから
		List<Item> items = FileUtil.readFile(filename);

		// 定義からFieldとInnerClass
		for (Item item : items) {

			// 準備として、載せるClass
			String classname = item.actionName + "_" + item.inout.toString().toLowerCase();
			ClassObj classobj = getClassObj(classname);
			if (classobj == null) {
				classobj = new ClassObj();
				classobj.className = classname;
				classes.add(classobj);
			}

			// ClassObjがない場合
			String fieldtype = null;
			if (item.type.indexOf("{") < 0) {
				fieldtype = item.type;
			} else {
				// 先ず、Field
				// ※"{"と"}"を除いた内容はTypeとなる
				fieldtype = item.type.replaceAll("\\{(.*)\\}", "");

				// ※InnerClassとして処理する
				classobj.addClassObj(classobj.parseInnerClass(item.type));

			}

			FieldObj fieldobj = new FieldObj();
			fieldobj.fieldName = item.fieldname;
			fieldobj.fieldType = fieldtype;
			fieldobj.fieldComment = item.comment;
			classobj.addFieldObj(fieldobj);

		}
	}

	public void writeOut() {
		// java
		// H
		// ...
	}

	private static ClassObj getClassObj(String classname) {
		if (classes == null || classes.size() == 0) {
			return null;
		}

		for (ClassObj obj : classes) {
			if (obj.className.equals(classname)) {
				return obj;
			}
		}
		return null;
	}

	public static void removeAll() {
		classes = null;
	}

}

------=_NextPart_000_000C_01CEA243.E01AE2D0--


