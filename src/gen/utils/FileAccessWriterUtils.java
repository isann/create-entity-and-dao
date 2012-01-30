package gen.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class FileAccessWriterUtils {

	private static int writeCount = 0;
	private static int writeCommit = 100;
	private static StringBuilder sb;
	
	public static BufferedWriter getBufferedWrite(File file){
        BufferedWriter bw = null;
	    try {
	    	if(file != null && file.isFile()){
	    		if(!file.delete()){
	    			// delete failed 
	    			throw new RuntimeException();
	    		}
	    	}
	    	
	        bw = new BufferedWriter(new FileWriter(file, true)); // �ǋL���[�h
	      } catch (FileNotFoundException e) {
	        // File�I�u�W�F�N�g�������̗�O�ߑ�
	        e.printStackTrace();
	      } catch (IOException e) {
	        // BufferedWriter�I�u�W�F�N�g�̃N���[�Y���̗�O�ߑ�
	        e.printStackTrace();
	      }
	      return bw;
	}
	
	public static void write(BufferedWriter bw, String str){
	    try {
	    	if(writeCount % writeCommit == 0){
	    		if(sb == null){
			        sb = new StringBuilder();
	    		}
	    		sb.append(str);
	    		sb.append("\n");
	    		bw.write(sb.toString());
//		        bw.write(str);
//		        bw.newLine();
		        sb = null;
		        sb = new StringBuilder();
	    	} else {
	    		sb.append(str);
	    		sb.append("\n");
	    	}
	      } catch (FileNotFoundException e) {
	        // File�I�u�W�F�N�g�������̗�O�ߑ�
	        e.printStackTrace();
	      } catch (IOException e) {
	        // BufferedWriter�I�u�W�F�N�g�̃N���[�Y���̗�O�ߑ�
	        e.printStackTrace();
	      }
	}
	
	public static void closeBufferedWrite(BufferedWriter bw){
	    try {
    		if(sb != null){
        		bw.write(sb.toString());
    		}
	        sb = null;
	        bw.close();
	      } catch (FileNotFoundException e) {
	        // File�I�u�W�F�N�g�������̗�O�ߑ�
	        e.printStackTrace();
	      } catch (IOException e) {
	        // BufferedWriter�I�u�W�F�N�g�̃N���[�Y���̗�O�ߑ�
	        e.printStackTrace();
	      }
	}

}
