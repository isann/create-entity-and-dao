package ifno.isann.data.access.entity;

import java.util.Date;

public class AcceptOrderEntity {


	/** �󒍔ԍ� */
	private String oNum;

	/** 
	 * @return (�󒍔ԍ�)��ԋp���܂��B
	 */ 
	public String getONum(){
		 return this.oNum;
	}

	/** 
	 * @param (�󒍔ԍ�)�����̃G���e�B�e�B��(�󒍔ԍ�)�ɐݒ肵�܂��B
	 */ 
	public void setONum(String oNum){
		this.oNum = oNum;
	}


	/** �ڋq�ԍ� */
	private String cNum;

	/** 
	 * @return (�ڋq�ԍ�)��ԋp���܂��B
	 */ 
	public String getCNum(){
		 return this.cNum;
	}

	/** 
	 * @param (�ڋq�ԍ�)�����̃G���e�B�e�B��(�ڋq�ԍ�)�ɐݒ肵�܂��B
	 */ 
	public void setCNum(String cNum){
		this.cNum = cNum;
	}


	/** ���i�ԍ� */
	private String pNum;

	/** 
	 * @return (���i�ԍ�)��ԋp���܂��B
	 */ 
	public String getPNum(){
		 return this.pNum;
	}

	/** 
	 * @param (���i�ԍ�)�����̃G���e�B�e�B��(���i�ԍ�)�ɐݒ肵�܂��B
	 */ 
	public void setPNum(String pNum){
		this.pNum = pNum;
	}


	/** ������ */
	private int dcRate;

	/** 
	 * @return (������)��ԋp���܂��B
	 */ 
	public int getDcRate(){
		 return this.dcRate;
	}

	/** 
	 * @param (������)�����̃G���e�B�e�B��(������)�ɐݒ肵�܂��B
	 */ 
	public void setDcRate(int dcRate){
		this.dcRate = dcRate;
	}


	/** �I�v�V�������i */
	private int optionPrice;

	/** 
	 * @return (�I�v�V�������i)��ԋp���܂��B
	 */ 
	public int getOptionPrice(){
		 return this.optionPrice;
	}

	/** 
	 * @param (�I�v�V�������i)�����̃G���e�B�e�B��(�I�v�V�������i)�ɐݒ肵�܂��B
	 */ 
	public void setOptionPrice(int optionPrice){
		this.optionPrice = optionPrice;
	}


	/** �]�ƈ��ԍ� */
	private String employee;

	/** 
	 * @return (�]�ƈ��ԍ�)��ԋp���܂��B
	 */ 
	public String getEmployee(){
		 return this.employee;
	}

	/** 
	 * @param (�]�ƈ��ԍ�)�����̃G���e�B�e�B��(�]�ƈ��ԍ�)�ɐݒ肵�܂��B
	 */ 
	public void setEmployee(String employee){
		this.employee = employee;
	}


	/** �󒍓� */
	private Date acceptDate;

	/** 
	 * @return (�󒍓�)��ԋp���܂��B
	 */ 
	public Date getAcceptDate(){
		 return this.acceptDate;
	}

	/** 
	 * @param (�󒍓�)�����̃G���e�B�e�B��(�󒍓�)�ɐݒ肵�܂��B
	 */ 
	public void setAcceptDate(Date acceptDate){
		this.acceptDate = acceptDate;
	}

}

