package gen.utils;

import java.util.List;

public class WorkBookEntity {

	private String tableName;
	private String packageName;
	private String className;
	/**
	 * @return className��ԋp���܂��B
	 */
	public String getClassName() {
		return className;
	}
	/**
	 * @param className��className�ɐݒ肵�܂��B
	 */
	public void setClassName(String className) {
		this.className = className;
	}
	private List<WorkBookRowEntity> list;
	
	/**
	 * @return tableName��ԋp���܂��B
	 */
	public String getTableName() {
		return tableName;
	}
	/**
	 * @param tableName��tableName�ɐݒ肵�܂��B
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	/**
	 * @return packageName��ԋp���܂��B
	 */
	public String getPackageName() {
		return packageName;
	}
	/**
	 * @param packageName��packageName�ɐݒ肵�܂��B
	 */
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	/**
	 * @return list��ԋp���܂��B
	 */
	public List<WorkBookRowEntity> getList() {
		return list;
	}
	/**
	 * @param list��list�ɐݒ肵�܂��B
	 */
	public void setList(List<WorkBookRowEntity> list) {
		this.list = list;
	}
	
}
