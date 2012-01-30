package gen.accessdb;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 所定フォーマットで記述されたXLSファイルから
 * EntityｔとDAOを作成するプログラムです。
 * @author visann
 */
public class Creater {

	public static void main(String[] args) {
		if(args == null || args.length <= 1){
			throw new IllegalArgumentException("param check fault");
		}
		executeGenerated(args[0], args[1]);
	}
	
	private static void executeGenerated(String inDirectory, String outDirectory){
		File f = new File(inDirectory);
		File[] dir = f.listFiles();
		if(dir == null) throw new IllegalArgumentException("param check fault");// ファイルパスではなくフォルダパスを指定すること。
		for(File dirs : dir){
			// ファイルのとき
			if(dirs.isFile()){
				CreateEntity ce = new CreateEntity(outDirectory);
				ce.createEntity(dirs);
				CreateDao cd = new CreateDao(outDirectory);
				cd.createDao(dirs);
				checkXlsFile(dirs);
			} else {
				executeGenerated(dirs.getAbsolutePath(), outDirectory);
			}
		}
	}

	private static Pattern xlsFileNamePattern = Pattern.compile("\\.xls$"); // xlsファイル名
	
	private static boolean checkXlsFile(File file){
		Matcher matcher = xlsFileNamePattern.matcher(file.getName());
		boolean ret = false;
		if(matcher.find()){
			ret = true;
		}
		return ret;
	}

}
