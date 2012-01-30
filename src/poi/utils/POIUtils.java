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
 * POIを利用する際のユーティリティを提供するクラス。
 * @author ぺえぺえのうんこ
 */
public class POIUtils {

	public static int MAX_SHEET_INDEX = 65535;

	/**
	 * FileオブジェクトからHSSFWorkbookを生成して返却します。
	 * @param xlsFile
	 * @return HSSFWorkbookのインスタンス
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
	 * ワークブックの指定されたシートを取得します。
	 * @param workBook
	 * @param sheetName
	 * @return
	 */
	public static HSSFSheet getSheet(HSSFWorkbook workBook, String sheetName){
		HSSFSheet sheet = workBook.getSheet(sheetName);
		return sheet;
	}

	/**
	 * ワークブックの指定されたシート内行を取得します。
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
	 * ワークブックの指定されたシート内セルの値を取得します。
	 * @param workBook
	 * @param sheetName
	 * @param cellColumn
	 * @param cellRow
	 * @return
	 * @throws NullPointerException シート名が存在しない、行が存在しない、列が存在しない場合に返却します。
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
	 * ワークブックの指定されたシート内セルの値を取得します。
	 * このメソッドはセルに数式が入っている場合に使用します。
	 * 第5引数で数式の計算結果後の型名を指定して値を取得するメソッドです。
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
	 * ワークブックの指定されたシート内セルの値を取得します。
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
	 * ワークブックの指定されたシート内セルの値を取得します。
	 * このメソッドはセルに数式が入っている場合に使用します。
	 * 第5引数で数式の計算結果後の型名を指定して値を取得するメソッドです。
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
	 * エクセルブック内のすべてのシートを取得し、リストを返却します。
	 * @param workBook
	 * @return
	 */
	public static List<HSSFSheet> getAllSeet(HSSFWorkbook workBook){
		// シートをすべて取得する
		List<HSSFSheet> sheetList = new ArrayList<HSSFSheet>();
		for(int i = 0; i < POIUtils.MAX_SHEET_INDEX; i++){
			try{
				HSSFSheet sheet = workBook.getSheetAt(i);
				sheetList.add(sheet);
			} catch(IllegalArgumentException e){
				//				e.printStackTrace();
				//				System.out.print("ブック内最終シート名 : ");
				//				System.out.println(workBook.getSheetAt(i - 1).getSheetName());
				break;
			}
		}
		return sheetList;
	}

	/**
	 * シート内のすべての行を取得し、行のリストを返却します。
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
	 * 行内のすべてのセルを取得し、セルのリストを返却します。
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
	 * 行内のすべてのセルの値を取得し、セルの値リストを返却します。
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
	 * シート内のすべてのセルを取得し、セルのリストを返却します。
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
	 * シート内のすべてのセルの値を取得し、返却します。
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
	 * セルの値を取得するメソッド。
	 * セルのタイプによって自動的に返却する型を定義。
	 * 日付であればDate、整数であればInteger、小数であればDouble、文字列であればStringとなります。
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
	 * 数式のセルであり、数式の計算結果の値を取得するメソッド。
	 * ただしセルが数式かどうかのチェックは行わない。
	 * 返却する型は、日付であればDate、整数であればInteger、小数であればDouble、文字列であればStringとなります。
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
