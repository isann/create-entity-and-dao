package gen.accessdb;

import gen.utils.FileAccessWriterUtils;
import gen.utils.PropertyUtils;
import gen.utils.WorkBookEntity;
import gen.utils.WorkBookRowEntity;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import poi.utils.CellColumnName;
import poi.utils.POIUtils;

public class CreateDao {

	private String outDirectory;
	private String jdbcClassName;
	private String dbAccessUri;
	private String dbUser;
	private String dbPassword;

	public CreateDao(String str){
		this.outDirectory = str;
	}

	/**
	 * Dao�쐬�̃��C�����\�b�h�B
	 * @param file
	 * @return
	 */
	public boolean createDao(File file){
		boolean ret = false;

		WorkBookEntity entity = this.step1(file);
		this.step2(entity);

		return ret;
	}

	/**
	 * �쐬���ׂ��G���e�B�e�B�̕K�v�ȏ�����͂���
	 * @return
	 */
	private WorkBookEntity step1(File file){

		try {
			this.jdbcClassName = PropertyUtils.getPropertiesValue("db", "jdbc.class");
			this.dbAccessUri = PropertyUtils.getPropertiesValue("db", "db.uri");
			this.dbUser = PropertyUtils.getPropertiesValue("db", "db.user");
			this.dbPassword = PropertyUtils.getPropertiesValue("db", "db.password");
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		HSSFWorkbook workBook = POIUtils.getWorkBook(file);

		WorkBookEntity wentity = new WorkBookEntity();

		String tableName = (String)POIUtils.getCellValue(workBook, "�e�[�u����`", CellColumnName.A.getValue(), 2);
		String packageName = (String)POIUtils.getCellValue(workBook, "�e�[�u����`", CellColumnName.B.getValue(), 2);
		String className = this.getClassName(tableName);
		wentity.setTableName(tableName);
		wentity.setPackageName(packageName);
		wentity.setClassName(className);

		List<WorkBookRowEntity> rowList = new ArrayList<WorkBookRowEntity>();
		//		for(int i = 5; endFlg; i++){
		int rowNum = 5;
		while(true){
			if(POIUtils.getRow(workBook, "�e�[�u����`", rowNum) == null){
				break;
			}
			WorkBookRowEntity entity = this.getWorkBookRowEntity(workBook, rowNum);
			if(entity == null){
				rowNum++;
				continue;
			}
			rowList.add(entity);
			rowNum++;
		}

		wentity.setList(rowList);

		return wentity;
	}

	/**
	 * �t�@�C�����쐬����
	 * @param entity
	 */
	private void step2(WorkBookEntity entity){

		// �p�b�P�[�W���𕪉�����
		String dir = entity.getPackageName().replaceAll("\\.", "/");
		if(!"\\".equals(outDirectory.substring(0, 1)) || !"/".equals(outDirectory.substring(0, 1))){
			outDirectory = outDirectory + "/";
		}
		String packageRoot = outDirectory + dir;
		//		if("/".equals(packageRoot.substring(0, 1))){
		//			// �������Ȃ�
		//		} else {
		//			packageRoot = "/" + packageRoot;
		//		}
		File packageDir = new File(packageRoot + "/dao");
		if(packageDir.mkdirs() || packageDir.exists()){
			// �쐬����G���e�B�e�B�̃p�X
			File javaDao = new File(packageDir.getPath() + "/" + entity.getClassName() + "Dao" + ".java");
			javaDao.delete();
			BufferedWriter bw = FileAccessWriterUtils.getBufferedWrite(javaDao);
			this.writeClassFile(entity, bw);
		}

	}

	/**
	 * �G���e�B�e�B�̃J�������擾���܂��B
	 * �s�͂��邪�A�L���ȕ��������擾�ł��Ȃ��ꍇ��NULL��ԋp���܂��B
	 * @param workBook
	 * @param rowNum
	 * @return
	 */
	private WorkBookRowEntity getWorkBookRowEntity(HSSFWorkbook workBook, int rowNum){
		WorkBookRowEntity entity = new WorkBookRowEntity();
		try{
			String columnName = (String)POIUtils.getCellValue(workBook, "�e�[�u����`", CellColumnName.A.getValue(), rowNum);
			entity.setColumnName(columnName);
		} catch(NullPointerException e){
			// �ɂ���Ԃ�
		}
		try{
			String columnButuriMei = (String)POIUtils.getCellValue(workBook, "�e�[�u����`", CellColumnName.B.getValue(), rowNum);
			if(columnButuriMei == null || "".equals(columnButuriMei)){
				System.out.println("�s�͂��邯��ǂ��L���Ȓl���擾�ł��Ȃ��̂ŃX�L�b�v���܂��B");
				entity = null;
				return entity;
			}
			entity.setColumnButurimei(columnButuriMei);
			entity.setMethodNameForJavaNaming(this.firstUpper(this.getFieldName(columnButuriMei)));
			entity.setPropertyNameForJavaNaming(this.getFieldName(columnButuriMei));
		} catch(NullPointerException e){
			throw new RuntimeException("�K�{�̗񕨗��������͂���Ă��܂���B");
		}
		try{
			String columnId = (String)POIUtils.getCellValue(workBook, "�e�[�u����`", CellColumnName.C.getValue(), rowNum);
			if("��".equals(columnId)){
				entity.setIdFlg(true);
			} else {
				entity.setIdFlg(false);
			}
		} catch(NullPointerException e){
			entity.setIdFlg(false);
		}
		try{
			String columnDataBaseColumnType = (String)POIUtils.getCellValue(workBook, "�e�[�u����`", CellColumnName.D.getValue(), rowNum);
			entity.setColumnType(columnDataBaseColumnType);
		} catch(NullPointerException e){
			// �ɂ���Ԃ�
		}
		try{
			Integer columnDigit = (Integer)POIUtils.getCellValue(workBook, "�e�[�u����`", CellColumnName.E.getValue(), rowNum);
			entity.setDigit(columnDigit);
		} catch(NullPointerException e){
			// �ɂ���Ԃ�
		}
		try{
			String columnEntityFieldClass = (String)POIUtils.getCellValue(workBook, "�e�[�u����`", CellColumnName.F.getValue(), rowNum);
			entity.setEntityFiledClassType(columnEntityFieldClass);
			entity.setFieldClassForStatement(this.firstUpper(this.getFieldName(columnEntityFieldClass)));
		} catch(NullPointerException e){
			throw new RuntimeException("�K�{�̃N���X�^�����͂���Ă��܂���B");
		}
		return entity;
	}

	public String getClassName(String tableName) {

		String str = tableName;
		Pattern pa = Pattern.compile("_");
		Matcher mat = pa.matcher(str);
		while(mat.find()){
			str = replaceStrings(str);
			mat = pa.matcher(str);
		}

		str = str.substring(0, 1).toUpperCase() + str.substring(1, str.length());

		return str;

	}

	private String replaceStrings(String str){

		int s = str.indexOf("_");

		if(s == 0){
			return str.substring(s+1, str.length());
		}

		String zenhan = str.substring(0, s);
		zenhan = zenhan.substring(0, 1).toUpperCase() + zenhan.substring(1, zenhan.length());

		String kouhan = str.substring(s, str.length());

		if(kouhan.length() == 1){
			return zenhan;
		}

		kouhan = kouhan.substring(1, 2).toUpperCase() + kouhan.substring(2, kouhan.length());

		str = zenhan + kouhan;

		return str;

	}

	/**
	 * JAVA�N���X���������݂��s���܂��B
	 * @param entity
	 * @param bw
	 */
	private void writeClassFile(WorkBookEntity entity, BufferedWriter bw){
		//Velocity�̏�����
		Velocity.init();
		//Velocity�R���e�L�X�g�ɒl��ݒ�
		VelocityContext context = new VelocityContext();
		context.put("workBookEntity", entity);
		context.put("jdbcClassName", jdbcClassName);
		context.put("dbAccessUri", dbAccessUri);
		context.put("dbUser", dbUser);
		context.put("dbPassword", dbPassword);
		StringWriter sw = new StringWriter();
		//�e���v���[�g�̍쐬
		Template template = Velocity.getTemplate("./template/dao.vm", "UTF-8");
		//�e���v���[�g�ƃ}�[�W
		template.merge(context,sw);
		FileAccessWriterUtils.write(bw, sw.toString());
		FileAccessWriterUtils.closeBufferedWrite(bw);
	}

	/**
	 * �e�[�u������������Java�����K���ɏ]�������O���擾���܂��B
	 * @param buturimei
	 * @return
	 */
	private String getFieldName(String buturimei){
		String getterSetterFieldName = this.getClassName(buturimei);
		buturimei = getterSetterFieldName.substring(0, 1).toLowerCase() + getterSetterFieldName.substring(1, getterSetterFieldName.length());
		return buturimei;
	}

	/**
	 * �����̏��߂�啶���ɂ��ĕԂ��܂��B
	 * @param 
	 * @return
	 */
	private String firstUpper(String str){
		if(str.length() == 1){
			return str.substring(0).toUpperCase();
		} else {
			return str.substring(0, 1).toUpperCase() + str.substring(1, str.length());
		}
	}

}
