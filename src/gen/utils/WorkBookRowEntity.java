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
	 * @return columnNameを返却します。
	 */
	public String getColumnName() {
		return columnName;
	}
	/**
	 * @param columnNameをcolumnNameに設定します。
	 */
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	/**
	 * @return columnButurimeiを返却します。
	 */
	public String getColumnButurimei() {
		return columnButurimei;
	}
	/**
	 * @param columnButurimeiをcolumnButurimeiに設定します。
	 */
	public void setColumnButurimei(String columnButurimei) {
		this.columnButurimei = columnButurimei;
	}
	/**
	 * @return idFlgを返却します。
	 */
	public boolean isIdFlg() {
		return idFlg;
	}
	/**
	 * @param idFlgをidFlgに設定します。
	 */
	public void setIdFlg(boolean idFlg) {
		this.idFlg = idFlg;
	}
	/**
	 * @return columnTypeを返却します。
	 */
	public String getColumnType() {
		return columnType;
	}
	/**
	 * @param columnTypeをcolumnTypeに設定します。
	 */
	public void setColumnType(String columnType) {
		this.columnType = columnType;
	}
	/**
	 * @return digitを返却します。
	 */
	public Integer getDigit() {
		return digit;
	}
	/**
	 * @param digitをdigitに設定します。
	 */
	public void setDigit(Integer digit) {
		this.digit = digit;
	}
	/**
	 * @return entityFiledClassTypeを返却します。
	 */
	public String getEntityFiledClassType() {
		return entityFiledClassType;
	}
	/**
	 * @param entityFiledClassTypeをentityFiledClassTypeに設定します。
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
