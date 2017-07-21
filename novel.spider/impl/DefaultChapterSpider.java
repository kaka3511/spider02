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
		URL url = new URL(path); // ����url����
		URLConnection connection = url.openConnection(); // ������
		connection.setDoOutput(true);
		BufferedImage src = ImageIO.read(connection.getInputStream()); // ��ȡ���ӵ�������ֵ��BufferedImage����
		// ���ͼ��ҳ��
		String fileName = "D:/�ɼ�51ycͼƬ����/" + "��" + baseI + "ҳ" + "/" + j;
		File f = new File(fileName + "/" + (i++) + ".jpg");
		f.getParentFile().mkdirs();
		f.createNewFile();
		ImageIO.write(src, "JPEG", f);

	}

	// ����txtС˵
	public void saveTxtFile(String content) throws IOException {
		try {
			File f = new File("D:/�ɼ�������С˵/ѩӥ����/" + "��" + (i++) + "��"+".txt");
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
