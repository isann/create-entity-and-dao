package gen.utils;

public class WorkBookRowEntity {

	private String columnName;
	private String columnButurimei;
	private boolean idFlg;
	private String columnType;
	private Integer digit;
	private String entityFiledClassType;

	private String propertyNameForJavaNaming;
	private String methodNameForJavaNaming;
	private String fieldClassForStatement;
	
	/**
	 * @return columnName��ԋp���܂��B
	 */
	public String getColumnName() {
		return columnName;
	}
	/**
	 * @param columnName��columnName�ɐݒ肵�܂��B
	 */
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	/**
	 * @return columnButurimei��ԋp���܂��B
	 */
	public String getColumnButurimei() {
		return columnButurimei;
	}
	/**
	 * @param columnButurimei��columnButurimei�ɐݒ肵�܂��B
	 */
	public void setColumnButurimei(String columnButurimei) {
		this.columnButurimei = columnButurimei;
	}
	/**
	 * @return idFlg��ԋp���܂��B
	 */
	public boolean isIdFlg() {
		return idFlg;
	}
	/**
	 * @param idFlg��idFlg�ɐݒ肵�܂��B
	 */
	public void setIdFlg(boolean idFlg) {
		this.idFlg = idFlg;
	}
	/**
	 * @return columnType��ԋp���܂��B
	 */
	public String getColumnType() {
		return columnType;
	}
	/**
	 * @param columnType��columnType�ɐݒ肵�܂��B
	 */
	public void setColumnType(String columnType) {
		this.columnType = columnType;
	}
	/**
	 * @return digit��ԋp���܂��B
	 */
	public Integer getDigit() {
		return digit;
	}
	/**
	 * @param digit��digit�ɐݒ肵�܂��B
	 */
	public void setDigit(Integer digit) {
		this.digit = digit;
	}
	/**
	 * @return entityFiledClassType��ԋp���܂��B
	 */
	public String getEntityFiledClassType() {
		return entityFiledClassType;
	}
	/**
	 * @param entityFiledClassType��entityFiledClassType�ɐݒ肵�܂��B
	 */
	public void setEntityFiledClassType(String entityFiledClassType) {
		this.entityFiledClassType = entityFiledClassType;
	}
	public void setFieldClassForStatement(String fieldClassForStatement) {
		this.fieldClassForStatement = fieldClassForStatement;
	}
	public String getFieldClassForStatement() {
		return fieldClassForStatement;
	}
	public void setPropertyNameForJavaNaming(String propertyNameForJavaNaming) {
		this.propertyNameForJavaNaming = propertyNameForJavaNaming;
	}
	public String getPropertyNameForJavaNaming() {
		return propertyNameForJavaNaming;
	}
	public void setMethodNameForJavaNaming(String methodNameForJavaNaming) {
		this.methodNameForJavaNaming = methodNameForJavaNaming;
	}
	public String getMethodNameForJavaNaming() {
		return methodNameForJavaNaming;
	}
}
