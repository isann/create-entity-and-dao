package ifno.isann.data.access.entity;

import java.util.Date;

public class AcceptOrderEntity {


	/** 受注番号 */
	private String oNum;

	/** 
	 * @return (受注番号)を返却します。
	 */ 
	public String getONum(){
		 return this.oNum;
	}

	/** 
	 * @param (受注番号)をこのエンティティの(受注番号)に設定します。
	 */ 
	public void setONum(String oNum){
		this.oNum = oNum;
	}


	/** 顧客番号 */
	private String cNum;

	/** 
	 * @return (顧客番号)を返却します。
	 */ 
	public String getCNum(){
		 return this.cNum;
	}

	/** 
	 * @param (顧客番号)をこのエンティティの(顧客番号)に設定します。
	 */ 
	public void setCNum(String cNum){
		this.cNum = cNum;
	}


	/** 製品番号 */
	private String pNum;

	/** 
	 * @return (製品番号)を返却します。
	 */ 
	public String getPNum(){
		 return this.pNum;
	}

	/** 
	 * @param (製品番号)をこのエンティティの(製品番号)に設定します。
	 */ 
	public void setPNum(String pNum){
		this.pNum = pNum;
	}


	/** 割引率 */
	private int dcRate;

	/** 
	 * @return (割引率)を返却します。
	 */ 
	public int getDcRate(){
		 return this.dcRate;
	}

	/** 
	 * @param (割引率)をこのエンティティの(割引率)に設定します。
	 */ 
	public void setDcRate(int dcRate){
		this.dcRate = dcRate;
	}


	/** オプション価格 */
	private int optionPrice;

	/** 
	 * @return (オプション価格)を返却します。
	 */ 
	public int getOptionPrice(){
		 return this.optionPrice;
	}

	/** 
	 * @param (オプション価格)をこのエンティティの(オプション価格)に設定します。
	 */ 
	public void setOptionPrice(int optionPrice){
		this.optionPrice = optionPrice;
	}


	/** 従業員番号 */
	private String employee;

	/** 
	 * @return (従業員番号)を返却します。
	 */ 
	public String getEmployee(){
		 return this.employee;
	}

	/** 
	 * @param (従業員番号)をこのエンティティの(従業員番号)に設定します。
	 */ 
	public void setEmployee(String employee){
		this.employee = employee;
	}


	/** 受注日 */
	private Date acceptDate;

	/** 
	 * @return (受注日)を返却します。
	 */ 
	public Date getAcceptDate(){
		 return this.acceptDate;
	}

	/** 
	 * @param (受注日)をこのエンティティの(受注日)に設定します。
	 */ 
	public void setAcceptDate(Date acceptDate){
		this.acceptDate = acceptDate;
	}

}

