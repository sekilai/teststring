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
