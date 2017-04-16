package zx.qrcode;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class ZXingTestCases {
	
	Logger log = Logger.getLogger(ZXingTestCases.class);
	
	private int width = 300;
	private int height = 300;
	private String format = "png";
	//如果想要扫描二维码打开网址的话，一定要加上http://哦！
	private String content = "Hello QRCode";
	private Map hints = new HashMap();

	@Test
	public void testCreateQRCode() throws WriterException, IOException {
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
		hints.put(EncodeHintType.MARGIN, 2);
		BitMatrix bm = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height,hints);
		Path path = new File("C:/Users/Zhangxun/Desktop/zhangxun.png").toPath();
		MatrixToImageWriter.writeToPath(bm, format, path);
		log.info("生成二维码结束！");
	}
	
	@Test
	public void testParseQRCode() throws IOException, NotFoundException{
		MultiFormatReader mr = new MultiFormatReader();
		File file = new File(ZXingTestCases.class.getResource("zhangxun.png").getFile());
		BufferedImage bi = ImageIO.read(file);
		BinaryBitmap bb = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(bi)));
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		Result res = mr.decode(bb,hints);
		log.info("解析二维码的结果为：" + res.toString());
		log.info("解析二维码的类型为：" + res.getBarcodeFormat());
		log.info("解析二维码的文本为：" + res.getText());
	}

}
