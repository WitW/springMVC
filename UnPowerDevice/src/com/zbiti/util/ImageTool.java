package com.zbiti.util;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;

import com.sun.image.codec.jpeg.ImageFormatException;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class ImageTool {
	private BufferedImage bufferedImage;

	/**
	 * 通过十六进制字符串构造图片
	 * 
	 * @param hexString
	 */
	public ImageTool(String hexString) {
		try {
			// byte[] result = CharConvertTool.convertHexStringToByte( hexString
			// ); //将十六进制字符串转为字节码
			byte[] result = Base64.decodeBase64(hexString.getBytes());
			ByteArrayInputStream in = new ByteArrayInputStream(result);
			this.bufferedImage = ImageIO.read(in); // 通过字节流构造图片
		} catch (Exception e) {
			e.printStackTrace();
			this.bufferedImage = null;
		}
	}
	
	/**
	 * 把字节数组保存为一个文件
	 * 
	 * @param b
	 * @param outputFile
	 * @return
	 */
	public static File saveVoiceFileFromString(String hexString, String outputFile) {
		byte[] result = Base64.decodeBase64(hexString.getBytes());
		File ret = null;
		BufferedOutputStream stream = null;
		try {
			ret = new File(outputFile);
			FileOutputStream fstream = new FileOutputStream(ret);
			stream = new BufferedOutputStream(fstream);
			stream.write(result);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stream != null) {
				try {
					stream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return ret;
	}

	public ImageTool(byte[] bytes) {
		try {
			ByteArrayInputStream in = new ByteArrayInputStream(bytes);
			this.bufferedImage = ImageIO.read(in); // 通过字节流构造图片
		} catch (Exception e) {
			e.printStackTrace();
			this.bufferedImage = null;
		}
	} 

	/**
	 * 按比例缩放图像
	 * 
	 * @param percentOfOriginal
	 */
	public void resize(int percentOfOriginal) {
		int newWidth = this.bufferedImage.getWidth() * percentOfOriginal / 100;
		int newHeight = this.bufferedImage.getHeight() * percentOfOriginal
				/ 100;
		resize(newWidth, newHeight);
	}

	/**
	 * 根据长度和宽度缩放图像
	 * 
	 * @param newWidth
	 * @param newHeight
	 */
	public void resize(int newWidth, int newHeight) {
		int oldWidth = this.bufferedImage.getWidth(); // 获得新图像的长和宽
		int oldHeight = this.bufferedImage.getHeight();

		if ((newWidth == -1) || (newHeight == -1)) {
			if (newWidth == -1) {
				if (newHeight == -1) {
					return;
				}
				newWidth = newHeight * oldWidth / oldHeight;
			} else {
				newHeight = newWidth * oldHeight / oldWidth;
			}
		}

		BufferedImage result = new BufferedImage(newWidth, newHeight, 4);

		int widthSkip = oldWidth / newWidth;
		int heightSkip = oldHeight / newHeight;

		if (widthSkip == 0)
			widthSkip = 1;
		if (heightSkip == 0)
			heightSkip = 1;

		for (int x = 0; x < oldWidth; x += widthSkip) {
			for (int y = 0; y < oldHeight; y += heightSkip) {
				int rgb = this.bufferedImage.getRGB(x, y);

				if ((x / widthSkip < newWidth) && (y / heightSkip < newHeight)) {
					result.setRGB(x / widthSkip, y / heightSkip, rgb);
				}
			}

		}

		this.bufferedImage = result;
	}

	public BufferedImage getBufferedImage() {
		return bufferedImage;
	}

	/**
	 * 图片转字节码
	 * 
	 * @param photoPath
	 *            图片存放路径
	 */
	public static byte[] photoToByte(String photoPath) {
		byte[] b = null;
		try {
			File file = new File(photoPath);
			if (file != null) {
				FileInputStream fis = new FileInputStream(file);
				if (fis != null) {
					int len = fis.available();
					b = new byte[len];
					fis.read(b);// file中的内容全读到byte[]数组中
				}
			}
		} catch (Exception e) {
		}
		return b;
	}

	/**
	 * 将图片存储到指定路径，供测试用
	 * 
	 * @param outputPath
	 * @param bi
	 * @throws ImageFormatException
	 * @throws IOException
	 */
	public static void storePhoto(String outputPath, BufferedImage bi)
			throws ImageFormatException, IOException {
		FileOutputStream out = new FileOutputStream(outputPath);
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
		encoder.encode(bi);
		out.close();
	}

	/* 测试 */
	/*
	 * public static void main(String[] args) throws IOException { String
	 * photoPath="D://test.jpg"; byte[] b=photoToByte(photoPath); String
	 * hex=CharConvertTool.convertByteToHexString(b); System.out.println(hex);
	 * ImageTool it=new ImageTool(hex); BufferedImage bi=it.getBufferedImage();
	 * storePhoto("D://Java//package//t.jpg",bi); }
	 */

//	public String saveAsHex() {
//		ByteArrayOutputStream out = new ByteArrayOutputStream();
//		try {
//			ImageIO.write(this.getBufferedImage(), "jpeg", out);
//			byte[] result = out.toByteArray();
//			String hexString = CharConvertTool.convertByteToHexString(result);
//			return hexString;
//		} catch (IOException e) {
//			e.printStackTrace();
//			return null;
//		}
//
//	}

	/**
	 * 从流中读取照片信息并返回字节数组
	 * 
	 * @param request
	 * @return
	 */
	public static byte[] getPhotoHexStrFromStream(HttpServletRequest request) {
		byte[] photoByte = null;
		try {
			InputStream in = request.getInputStream();
			ByteArrayOutputStream ba = new ByteArrayOutputStream();
			int ch;
			while ((ch = in.read()) != -1) {
				ba.write(ch);
			}
			ba.flush();
			photoByte = ba.toByteArray();
			ba.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return photoByte;
	}
}