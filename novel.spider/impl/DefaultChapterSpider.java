package impl;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;

import javax.imageio.ImageIO;

public class DefaultChapterSpider extends AbstractChapterSpider {
	public int i = 1;

	public void saveFile(String path, int j, int baseI) throws IOException {
		URL url = new URL(path); // 声明url对象
		URLConnection connection = url.openConnection(); // 打开连接
		connection.setDoOutput(true);
		BufferedImage src = ImageIO.read(connection.getInputStream()); // 读取连接的流，赋值给BufferedImage对象
		// 输出图象到页面
		String fileName = "D:/采集51yc图片测试/" + "第" + baseI + "页" + "/" + j;
		File f = new File(fileName + "/" + (i++) + ".jpg");
		f.getParentFile().mkdirs();
		f.createNewFile();
		ImageIO.write(src, "JPEG", f);

	}

	// 保存txt小说
	public void saveTxtFile(String content) throws IOException {
		try {
			File f = new File("D:/采集看书中小说/雪鹰领主/" + "第" + (i++) + "章"+".txt");
			if (!f.exists()) {
				f.createNewFile();
			}
			FileWriter fw = new FileWriter(f);
			PrintWriter pw = new PrintWriter(fw);
			Random random = new Random();
			pw.append(content);
			pw.flush();
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
