package gen.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * �v���p�e�B�t�@�C���̃��[�e�B���e�B�N���X�B
 * @author �؂��؂��̂���
 * @version �V�K�쐬
 */
public class PropertyUtils {

	private static Map<String, Properties> propMap = new HashMap<String, Properties>();
	
	/** �v���p�e�B�t�@�C���̕����R�[�h */
	public static String charSet = "MS932";
	
	public static final String PROPERTIES_ROOT = "/";
	public static final String PROPERTIES_EXTENSION = ".properties";
	
	/**
	 * �v���p�e�B��ǂݍ��݁A���̎Q�ƒl��ԋp���܂��B
	 * @param properties �v���p�e�B�t�@�C����
	 * @return �v���p�e�B�t�@�C���̃C���X�^���X
	 * @throws IOException �v���p�e�B�t�@�C�������݂��Ȃ��ꍇ
	 */
	public static Properties getProperties(String properties) throws IOException{
		
		Properties prop;
		
		if(propMap.containsKey(properties)){
			
			prop = propMap.get(properties);
			
		} else {

            //�v���p�e�B�t�@�C����ǂݍ���
	        InputStream is = PropertyUtils.class.getResourceAsStream(PROPERTIES_ROOT + properties + PROPERTIES_EXTENSION);
	        if(is == null){
	        	throw new IOException();
	        }
	        
			Reader reader  = new InputStreamReader(is, charSet);
 
            //�v���p�e�B�t�@�C����Properties�N���X�ɓǂݍ���
            prop = new Properties();
            prop.load(reader);
            
            propMap.put(properties, prop);
			
		}
		
		return prop;
		
	}
	
	/**
	 * �v���p�e�B�����w�肵�A���̃v���p�e�B�����L�[�ɑΉ�����l���擾���܂��B
	 * @param properties �v���p�e�B�t�@�C����
	 * @param key        �擾����v���p�e�B�t�@�C���̃L�[
	 * @return �w�肳�ꂽ�v���p�e�B�t�@�C������擾�����L�[�ɑΉ�����l
	 * @throws IOException �v���p�e�B�t�@�C�������݂��Ȃ��ꍇ
	 */
	public static String getPropertiesValue(String properties, String key) throws IOException{
		
		Properties prop;
		String value;
		
		if(propMap.containsKey(properties)){
			
			prop = propMap.get(properties);
			
			value = (String) prop.get(key);
			
		} else {

            //�v���p�e�B�t�@�C����ǂݍ���
	        InputStream is = PropertyUtils.class.getResourceAsStream(PROPERTIES_ROOT + properties + PROPERTIES_EXTENSION);
	        if(is == null){
	        	throw new IOException();
	        }
	        
			Reader reader  = new InputStreamReader(is, charSet);
 
            //�v���p�e�B�t�@�C����Properties�N���X�ɓǂݍ���
            prop = new Properties();
            prop.load(reader);
            
            propMap.put(properties, prop);
            
            value = (String) prop.get(key);
			
		}
		
		return value;
		
	}
	
}

