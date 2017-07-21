package task;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

public class Task {
	public static List<YuJia> getResult(String urlCon) throws Exception {
		String urlPath = urlCon;
		// 建立连接
		URL url = new URL(urlPath);
		HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
		// 设置参数
		httpConn.setDoOutput(true); // 需要输出
		httpConn.setDoInput(true); // 需要输入
		httpConn.setUseCaches(false); // 不允许缓存
		httpConn.setRequestMethod("POST"); // 设置POST方式连接
		// 设置请求属性
		httpConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		httpConn.setRequestProperty("Connection", "Keep-Alive");// 维持长连接
		httpConn.setRequestProperty("Charset", "UTF-8");
		// 连接,也可以不用明文connect，使用下面的httpConn.getOutputStream()会自动connect
		httpConn.connect();
		// 建立输入流，向指向的URL传入参数
		DataOutputStream dos = new DataOutputStream(httpConn.getOutputStream());
		dos.flush();
		dos.close();
		// 获得响应状态
		int resultCode = httpConn.getResponseCode();
		if (HttpURLConnection.HTTP_OK == resultCode) {
			StringBuffer sb = new StringBuffer();
			String readLine = new String();
			BufferedReader responseReader = new BufferedReader(
					new InputStreamReader(httpConn.getInputStream(), "UTF-8"));
			while ((readLine = responseReader.readLine()) != null) {
				sb.append(readLine).append("\n");
			}
			responseReader.close();
			List<YuJia> result = getCoreStr(sb.toString());
			return result;
		}
		return null;
	}

	@Test
	public void fun() throws Exception {
		for(String o:CityUrl.keys){
			File f = new File("D:/瑜伽馆信息采集/"+o+".xls");
			if (!f.exists()) {
				f.createNewFile();
			}
		}
//		File f = new File("D:/瑜伽馆信息采集/s.xls");
//		if (!f.exists()) {
//			f.createNewFile();
//		}
	}

	public static void main(String[] args) throws Exception {
		CityUrl cityUrl = new CityUrl();
		int keyLength = cityUrl.keys.length;
		for(int k=6;k<7;k++){
			List<YuJia> total = new ArrayList<>();
			//取key
			String key = cityUrl.keys[k];
			String[] urls = cityUrl.cityMap.get(key).split(",");
			int length = urls.length;
			for(int j=0;j<length;j++){
				for(int i=0;i<40;i++){
					String urlPath = cityUrl.commomStr +  "&c=" + urls[j] +
							"&pn="+i+"&nn="+i*10;
					List<YuJia> result = getResult(urlPath);
					if(result.size()!=0)
						total.addAll(result);
				}
			}
			for (YuJia oo : total)
				System.out.println(oo);
			System.out.println(total.size());
			WriteExcel.writeMyExcel(total, 4, "D:/瑜伽馆信息采集/"+key+".xls");
			Thread.sleep(1000);
		}
	}

	public static List<YuJia> getCoreStr(String res) {
		List<YuJia> yuJias = new ArrayList<>();
		char[] chs = res.toCharArray();
		int length = chs.length;
		int i = 0;
		YuJia o = new YuJia();
		while (i < length) {
			if (chs[i] == 'a' && chs[i + 1] == 'd' && chs[i + 2] == 'd' && chs[i + 3] == 'r' && chs[i + 4] == '"') {
				i = i + 7;
				String temp1 = "";
				while (chs[i] != '"') {
					temp1 = temp1 + chs[i];
					i++;
				}
				o.setAddr(asciiToNative(temp1));
			}
			if (chs[i] == 'a' && chs[i + 1] == 'd' && chs[i + 2] == 'd' && chs[i + 3] == 'r' && chs[i + 4] == 'e'
					&& chs[i + 5] == 's' && chs[i + 6] == 's' && chs[i + 7] == '_' && chs[i + 8] == 'n'
					&& chs[i + 9] == 'o' && chs[i + 10] == 'r' && chs[i + 11] == 'm' && chs[i + 12] == '"') {
				i = i + 15;
				String temp2 = "";
				while (chs[i] != '"') {
					temp2 = temp2 + chs[i];
					i++;
				}
				o.setAddress_norm(asciiToNative(temp2));
			}
			if (chs[i] == ']' && chs[i + 1] == ',' && chs[i + 2] == '"' && chs[i + 3] == 'n' && chs[i + 4] == 'a'
					&& chs[i + 5] == 'm' && chs[i + 6] == 'e' && chs[i + 7] == '"') {
				i = i + 10;
				String temp3 = "";
				while (chs[i] != '"') {
					temp3 = temp3 + chs[i];
					i++;
				}
				o.setName(asciiToNative(temp3));
			}
			if (chs[i] == '"' && chs[i + 1] == 't' && chs[i + 2] == 'e' && chs[i + 3] == 'l' && chs[i + 4] == '"') {
				i = i + 7;
				String temp4 = "";
				while (chs[i] != '"') {
					temp4 = temp4 + chs[i];
					i++;
				}
				o.setTel(asciiToNative(temp4));
				yuJias.add(o);
				o = new YuJia();
			}
			i++;
		}
		return yuJias;
	}

	private static String asciiToNative(String asciicode) {
		String[] asciis = asciicode.split("\\\\u");
		String nativeValue = asciis[0];
		try {
			for (int i = 1; i < asciis.length; i++) {
				String code = asciis[i];
				nativeValue += (char) Integer.parseInt(code.substring(0, 4), 16);
				if (code.length() > 4) {
					nativeValue += code.substring(4, code.length());
				}
			}
		} catch (NumberFormatException e) {
			return asciicode;
		}
		return nativeValue;
	}

}
