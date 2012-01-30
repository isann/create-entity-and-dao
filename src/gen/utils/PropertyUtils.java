package gen.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * プロパティファイルのユーティリティクラス。
 * @author ぺえぺえのうんこ
 * @version 新規作成
 */
public class PropertyUtils {

	private static Map<String, Properties> propMap = new HashMap<String, Properties>();
	
	/** プロパティファイルの文字コード */
	public static String charSet = "MS932";
	
	public static final String PROPERTIES_ROOT = "/";
	public static final String PROPERTIES_EXTENSION = ".properties";
	
	/**
	 * プロパティを読み込み、その参照値を返却します。
	 * @param properties プロパティファイル名
	 * @return プロパティファイルのインスタンス
	 * @throws IOException プロパティファイルが存在しない場合
	 */
	public static Properties getProperties(String properties) throws IOException{
		
		Properties prop;
		
		if(propMap.containsKey(properties)){
			
			prop = propMap.get(properties);
			
		} else {

            //プロパティファイルを読み込む
	        InputStream is = PropertyUtils.class.getResourceAsStream(PROPERTIES_ROOT + properties + PROPERTIES_EXTENSION);
	        if(is == null){
	        	throw new IOException();
	        }
	        
			Reader reader  = new InputStreamReader(is, charSet);
 
            //プロパティファイルをPropertiesクラスに読み込む
            prop = new Properties();
            prop.load(reader);
            
            propMap.put(properties, prop);
			
		}
		
		return prop;
		
	}
	
	/**
	 * プロパティ名を指定し、そのプロパティが持つキーに対応する値を取得します。
	 * @param properties プロパティファイル名
	 * @param key        取得するプロパティファイルのキー
	 * @return 指定されたプロパティファイルから取得したキーに対応する値
	 * @throws IOException プロパティファイルが存在しない場合
	 */
	public static String getPropertiesValue(String properties, String key) throws IOException{
		
		Properties prop;
		String value;
		
		if(propMap.containsKey(properties)){
			
			prop = propMap.get(properties);
			
			value = (String) prop.get(key);
			
		} else {

            //プロパティファイルを読み込む
	        InputStream is = PropertyUtils.class.getResourceAsStream(PROPERTIES_ROOT + properties + PROPERTIES_EXTENSION);
	        if(is == null){
	        	throw new IOException();
	        }
	        
			Reader reader  = new InputStreamReader(is, charSet);
 
            //プロパティファイルをPropertiesクラスに読み込む
            prop = new Properties();
            prop.load(reader);
            
            propMap.put(properties, prop);
            
            value = (String) prop.get(key);
			
		}
		
		return value;
		
	}
	
}

