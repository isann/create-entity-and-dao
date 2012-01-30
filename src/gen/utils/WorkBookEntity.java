package gen.utils;

import java.util.List;

public class WorkBookEntity {

	private String tableName;
	private String packageName;
	private String className;
	/**
	 * @return classNameを返却します。
	 */
	public String getClassName() {
		return className;
	}
	/**
	 * @param classNameをclassNameに設定します。
	 */
	public void setClassName(String className) {
		this.className = className;
	}
	private List<WorkBookRowEntity> list;
	
	/**
	 * @return tableNameを返却します。
	 */
	public String getTableName() {
		return tableName;
	}
	/**
	 * @param tableNameをtableNameに設定します。
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	/**
	 * @return packageNameを返却します。
	 */
	public String getPackageName() {
		return packageName;
	}
	/**
	 * @param packageNameをpackageNameに設定します。
	 */
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	/**
	 * @return listを返却します。
	 */
	public List<WorkBookRowEntity> getList() {
		return list;
	}
	/**
	 * @param listをlistに設定します。
	 */
	public void setList(List<WorkBookRowEntity> list) {
		this.list = list;
	}
	
}
