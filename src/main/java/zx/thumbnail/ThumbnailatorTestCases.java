package zx.thumbnail;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.junit.Test;

import net.coobird.thumbnailator.Thumbnails;

public class ThumbnailatorTestCases {
	
	Logger log = Logger.getLogger(ThumbnailatorTestCases.class);
	
	public static final int THUMBWIDTH = 100;
	public static final int THUMBHEIGHT = 100;

	@Test
	public void testOriginToThumb() throws IOException {
		File origin = new File(ThumbnailatorTestCases.class.getResource("origin.jpg").getFile());
		File dest = new File("C:/Users/Zhangxun/Desktop/thumb.jpg");
		Thumbnails.of(origin).size(THUMBWIDTH, THUMBHEIGHT).toFile(dest);
		log.info("…˙≥…Àı¬‘ÕºΩ· ¯£°");
	}

}
