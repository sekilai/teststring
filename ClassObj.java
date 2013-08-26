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
