package poi.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/**
 * POI�𗘗p����ۂ̃��[�e�B���e�B��񋟂���N���X�B
 * @author �؂��؂��̂���
 */
public class POIUtils {

	public static int MAX_SHEET_INDEX = 65535;

	/**
	 * File�I�u�W�F�N�g����HSSFWorkbook�𐶐����ĕԋp���܂��B
	 * @param xlsFile
	 * @return HSSFWorkbook�̃C���X�^���X
	 */
	public static HSSFWorkbook getWorkBook(File xlsFile){
		FileInputStream in = null;
		HSSFWorkbook workbook = null;
		try{
			in = new FileInputStream(xlsFile.getAbsolutePath());
			POIFSFileSystem fs = new POIFSFileSystem(in);
			workbook = new HSSFWorkbook(fs);
		}catch(IOException e){
			System.out.println(e.toString());
		}finally{
			try{
				in.close();
			}catch (IOException e){
				System.out.println(e.toString());
			}
		}
		return workbook;
	}

	/**
	 * ���[�N�u�b�N�̎w�肳�ꂽ�V�[�g���擾���܂��B
	 * @param workBook
	 * @param sheetName
	 * @return
	 */
	public static HSSFSheet getSheet(HSSFWorkbook workBook, String sheetName){
		HSSFSheet sheet = workBook.getSheet(sheetName);
		return sheet;
	}

	/**
	 * ���[�N�u�b�N�̎w�肳�ꂽ�V�[�g���s���擾���܂��B
	 * @param workBook
	 * @param sheetName
	 * @param cellRow
	 * @return
	 */
	public static HSSFRow getRow(HSSFWorkbook workBook, String sheetName, int cellRow){
		HSSFSheet sheet = workBook.getSheet(sheetName);
		HSSFRow row = null;
		@SuppressWarnings("unused")
		HSSFCell cell = null;
		@SuppressWarnings("unused")
		Object value = null;
		row = sheet.getRow(cellRow-1);
		//		Object value = getCellValue(cell);
		return row;
	}

	/**
	 * ���[�N�u�b�N�̎w�肳�ꂽ�V�[�g���Z���̒l���擾���܂��B
	 * @param workBook
	 * @param sheetName
	 * @param cellColumn
	 * @param cellRow
	 * @return
	 * @throws NullPointerException �V�[�g�������݂��Ȃ��A�s�����݂��Ȃ��A�񂪑��݂��Ȃ��ꍇ�ɕԋp���܂��B
	 */
	public static Object getCellValue(HSSFWorkbook workBook, String sheetName, int cellColumn, int cellRow){
		HSSFSheet sheet = workBook.getSheet(sheetName);
		HSSFRow row = null;
		HSSFCell cell = null;
		Object value = null;
		row = sheet.getRow(cellRow-1);
		cell = row.getCell(cellColumn);
		value = getCellValue(cell);
		//		Object value = getCellValue(cell);
		return value;
	}

	/**
	 * ���[�N�u�b�N�̎w�肳�ꂽ�V�[�g���Z���̒l���擾���܂��B
	 * ���̃��\�b�h�̓Z���ɐ����������Ă���ꍇ�Ɏg�p���܂��B
	 * ��5�����Ő����̌v�Z���ʌ�̌^�����w�肵�Ēl���擾���郁�\�b�h�ł��B
	 * @param workBook
	 * @param sheetName
	 * @param cellColumn
	 * @param cellRow
	 * @param formulaCellType
	 * @return
	 */
	public static Object getCellValue(HSSFWorkbook workBook, String sheetName, int cellColumn, int cellRow, int formulaCellType){
		HSSFSheet sheet = workBook.getSheet(sheetName);
		HSSFRow row = null;
		HSSFCell cell = null;
		Object value = null;
		row = sheet.getRow(cellRow-1);
		cell = row.getCell(cellColumn);
		value = getCellFormulaValue(cell, formulaCellType);
		//		Object value = getCellValue(cell);
		return value;
	}

	/**
	 * ���[�N�u�b�N�̎w�肳�ꂽ�V�[�g���Z���̒l���擾���܂��B
	 * @param file
	 * @param sheetName
	 * @param cellColumn
	 * @param cellRow
	 * @return
	 */
	public static Object getCellValue(File file, String sheetName, int cellColumn, int cellRow){
		HSSFWorkbook workBook = getWorkBook(file);
		HSSFSheet sheet = workBook.getSheet(sheetName);
		HSSFRow row = null;
		HSSFCell cell = null;
		Object value = null;
		row = sheet.getRow(cellRow-1);
		cell = row.getCell(cellColumn);
		value = getCellValue(cell);
		//		Object value = getCellValue(cell);
		return value;
	}

	/**
	 * ���[�N�u�b�N�̎w�肳�ꂽ�V�[�g���Z���̒l���擾���܂��B
	 * ���̃��\�b�h�̓Z���ɐ����������Ă���ꍇ�Ɏg�p���܂��B
	 * ��5�����Ő����̌v�Z���ʌ�̌^�����w�肵�Ēl���擾���郁�\�b�h�ł��B
	 * @param workBook
	 * @param sheetName
	 * @param cellColumn
	 * @param cellRow
	 * @param formulaCellType
	 * @return
	 */
	public static Object getCellValue(File file, String sheetName, int cellColumn, int cellRow, int formulaCellType){
		HSSFWorkbook workBook = getWorkBook(file);
		HSSFSheet sheet = workBook.getSheet(sheetName);
		HSSFRow row = null;
		HSSFCell cell = null;
		Object value = null;
		row = sheet.getRow(cellRow-1);
		cell = row.getCell(cellColumn);
		value = getCellFormulaValue(cell, formulaCellType);
		//		Object value = getCellValue(cell);
		return value;
	}

	/**
	 * �G�N�Z���u�b�N���̂��ׂẴV�[�g���擾���A���X�g��ԋp���܂��B
	 * @param workBook
	 * @return
	 */
	public static List<HSSFSheet> getAllSeet(HSSFWorkbook workBook){
		// �V�[�g�����ׂĎ擾����
		List<HSSFSheet> sheetList = new ArrayList<HSSFSheet>();
		for(int i = 0; i < POIUtils.MAX_SHEET_INDEX; i++){
			try{
				HSSFSheet sheet = workBook.getSheetAt(i);
				sheetList.add(sheet);
			} catch(IllegalArgumentException e){
				//				e.printStackTrace();
				//				System.out.print("�u�b�N���ŏI�V�[�g�� : ");
				//				System.out.println(workBook.getSheetAt(i - 1).getSheetName());
				break;
			}
		}
		return sheetList;
	}

	/**
	 * �V�[�g���̂��ׂĂ̍s���擾���A�s�̃��X�g��ԋp���܂��B
	 * @param sheet
	 * @return
	 */
	public static List<HSSFRow> getAllRow(HSSFSheet sheet){
		List<HSSFRow> rowList = new ArrayList<HSSFRow>();
		int firstRowNum = sheet.getFirstRowNum();
		int lastRowNum = sheet.getLastRowNum();
		int rowIndex = firstRowNum;
		while(rowIndex <= lastRowNum){
			try{
				HSSFRow row = sheet.getRow(rowIndex);
				if(row == null){
					rowIndex++;
					continue;
				}
				rowList.add(row);
				rowIndex++;
			} catch(IllegalArgumentException e){
				rowIndex++;
			}
		}
		return rowList;
	}

	/**
	 * �s���̂��ׂẴZ�����擾���A�Z���̃��X�g��ԋp���܂��B
	 * @param sheet
	 * @return
	 */
	public static List<HSSFCell> getAllCell(HSSFRow row){
		List<HSSFCell> cellList = new ArrayList<HSSFCell>();
		int firstCellNum = row.getFirstCellNum();
		int lastCellNum = row.getLastCellNum();
		int cellIndex = firstCellNum;
		while(cellIndex <= lastCellNum){
			try{
				HSSFCell cell = row.getCell(cellIndex);
				if(cell == null){
					cellIndex++;
					continue;
				}
				cellList.add(cell);
				cellIndex++;
			} catch(IllegalArgumentException e){
				cellIndex++;
			}
		}
		return cellList;
	}

	/**
	 * �s���̂��ׂẴZ���̒l���擾���A�Z���̒l���X�g��ԋp���܂��B
	 * @param sheet
	 * @return
	 */
	public static List<Object> getAllCellValue(HSSFRow row){
		List<Object> cellValueList = new ArrayList<Object>();
		int firstCellNum = row.getFirstCellNum();
		int lastCellNum = row.getLastCellNum();
		int cellIndex = firstCellNum;
		while(cellIndex <= lastCellNum){
			try{
				HSSFCell cell = row.getCell(cellIndex);
				if(cell == null){
					cellIndex++;
					continue;
				}
				Object o = POIUtils.getCellValue(cell);
				cellValueList.add(o);
				cellIndex++;
			} catch(IllegalArgumentException e){
				cellIndex++;
			}
		}
		return cellValueList;
	}

	/**
	 * �V�[�g���̂��ׂẴZ�����擾���A�Z���̃��X�g��ԋp���܂��B
	 * @param sheet
	 * @return
	 */
	public static List<HSSFCell> getAllCell(HSSFSheet sheet){
		List<HSSFCell> cellList = new ArrayList<HSSFCell>();
		int firstRowNum = sheet.getFirstRowNum();
		int lastRowNum = sheet.getLastRowNum();
		int rowIndex = firstRowNum;
		while(rowIndex <= lastRowNum){
			try{
				HSSFRow row = sheet.getRow(rowIndex);
				if(row == null){
					rowIndex++;
					continue;
				}
				int firstCellNum = row.getFirstCellNum();
				int lastCellNum = row.getLastCellNum();
				int cellIndex = firstCellNum;
				while(cellIndex <= lastCellNum){
					try{
						HSSFCell cell = row.getCell(cellIndex);
						if(cell == null){
							cellIndex++;
							continue;
						}
						cellList.add(cell);
						cellIndex++;
					} catch(IllegalArgumentException e){
						cellIndex++;
					}
				}
				rowIndex++;
			} catch(IllegalArgumentException e){
				rowIndex++;
			}
		}
		return cellList;
	}

	/**
	 * �V�[�g���̂��ׂẴZ���̒l���擾���A�ԋp���܂��B
	 * @param sheet
	 * @return
	 */
	public static List<Object> getAllCellValue(HSSFSheet sheet){
		List<Object> cellValueList = new ArrayList<Object>();
		int firstRowNum = sheet.getFirstRowNum();
		int lastRowNum = sheet.getLastRowNum();
		int rowIndex = firstRowNum;
		while(rowIndex <= lastRowNum){
			try{
				HSSFRow row = sheet.getRow(rowIndex);
				if(row == null){
					rowIndex++;
					continue;
				}
				int firstCellNum = row.getFirstCellNum();
				int lastCellNum = row.getLastCellNum();
				int cellIndex = firstCellNum;
				while(cellIndex <= lastCellNum){
					try{
						HSSFCell cell = row.getCell(cellIndex);
						if(cell == null){
							cellIndex++;
							continue;
						}
						Object o = POIUtils.getCellValue(cell);
						cellValueList.add(o);
						//						System.out.println(o);
						cellIndex++;
					} catch(IllegalArgumentException e){
						cellIndex++;
					}
				}
				rowIndex++;
			} catch(IllegalArgumentException e){
				rowIndex++;
			}
		}
		return cellValueList;
	}

	/**
	 * �Z���̒l���擾���郁�\�b�h�B
	 * �Z���̃^�C�v�ɂ���Ď����I�ɕԋp����^���`�B
	 * ���t�ł����Date�A�����ł����Integer�A�����ł����Double�A������ł����String�ƂȂ�܂��B
	 * @param cell
	 * @param HSSFCellType
	 * @return
	 */
	public static Object getCellValue(HSSFCell cell) {

		Object ret = null;

		switch (cell.getCellType()) {
		case HSSFCell.CELL_TYPE_BLANK:
			ret = "";
			break;
		case HSSFCell.CELL_TYPE_BOOLEAN:
			ret = new Boolean(cell.getBooleanCellValue());
			break;
		case HSSFCell.CELL_TYPE_ERROR:
			break;
		case HSSFCell.CELL_TYPE_FORMULA:
			ret = cell.getCellFormula();
			break;
		case HSSFCell.CELL_TYPE_NUMERIC:
			if (HSSFDateUtil.isCellDateFormatted(cell)) {
				ret = cell.getDateCellValue();
			} else {
				double val = cell.getNumericCellValue();

				if (val == Math.ceil(val)) {
					ret = new Integer((int) val);
				} else {
					ret = new Double(val);
				}
			}
			break;
		case HSSFCell.CELL_TYPE_STRING:
			ret = cell.getStringCellValue();
			break;
		default:
			ret = null;
		}
		return ret;
	}

	/**
	 * �����̃Z���ł���A�����̌v�Z���ʂ̒l���擾���郁�\�b�h�B
	 * �������Z�����������ǂ����̃`�F�b�N�͍s��Ȃ��B
	 * �ԋp����^�́A���t�ł����Date�A�����ł����Integer�A�����ł����Double�A������ł����String�ƂȂ�܂��B
	 * @param cell
	 * @param HSSFCellType
	 * @return
	 */
	public static Object getCellFormulaValue(HSSFCell cell, int HSSFCellType) {

		Object ret = null;

		switch (HSSFCellType) {
		case HSSFCell.CELL_TYPE_BLANK:
			ret = "";
			break;
		case HSSFCell.CELL_TYPE_BOOLEAN:
			ret = new Boolean(cell.getBooleanCellValue());
			break;
		case HSSFCell.CELL_TYPE_ERROR:
			break;
		case HSSFCell.CELL_TYPE_FORMULA:
			ret = cell.getCellFormula();
			break;
		case HSSFCell.CELL_TYPE_NUMERIC:
			if (HSSFDateUtil.isCellDateFormatted(cell)) {
				ret = cell.getDateCellValue();
			} else {
				double val = cell.getNumericCellValue();

				if (val == Math.ceil(val)) {
					ret = new Integer((int) val);
				} else {
					ret = new Double(val);
				}
			}
			break;
		case HSSFCell.CELL_TYPE_STRING:
			ret = cell.getStringCellValue();
			break;
		default:
			ret = null;
		}
		return ret;
	}

}
