package com.ailk.toptea.itsm.extra.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

public class uploadXml {
	public static boolean uploadFile(String url, String username,
			String password, String path, String filename, InputStream input) {
		boolean success = false;
		FTPClient ftp = new FTPClient();
		try {
			int reply;
			ftp.connect(url);// ����FTP������
			// �������Ĭ�϶˿ڣ�����ʹ��ftp.connect(url)�ķ�ʽֱ������FTP������
			ftp.login(username, password);// ��¼

			reply = ftp.getReplyCode();
			System.out.println(reply);
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftp.disconnect();
				return success;
			}
			System.out.println("work to path");
			ftp.changeWorkingDirectory(path);
			// ����˿ڽ��д���
			ftp.enterLocalPassiveMode();

			System.out.println("start input....");
			ftp.storeFile(filename, input);
			System.out.println("copied");
			input.close();
			ftp.logout();
			success = true;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ftp.isConnected()) {
				try {
					ftp.disconnect();
				} catch (IOException ioe) {
				}
			}
		}
		return success;
	}

	public static boolean downFile(String url, int port, String username,
			String password, String remotePath, String fileName,
			String localPath) {
		boolean success = false;
		FTPClient ftp = new FTPClient();
		try {
			int reply;
			ftp.connect(url);
			// �������Ĭ�϶˿ڣ�����ʹ��ftp.connect(url)�ķ�ʽֱ������FTP������
			ftp.login(username, password);// ��¼
			reply = ftp.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftp.disconnect();
				return success;
			}
			System.out.println("connected success!");
			ftp.changeWorkingDirectory(remotePath);// ת�Ƶ�FTP������Ŀ¼
			System.out.println("trun to remotePath!");
			// ע����Ӵ˾�
			ftp.enterLocalPassiveMode();
			FTPFile[] fs = ftp.listFiles();

			// System.out.println("fs:"+ fs[0]);
			for (FTPFile ff : fs) {
				/*
				 * for(int i =0;i<fs.length;i++){ FTPFile ff = fs[i];
				 * System.out.println("ff:"+ff);
				 */
				if (ff.getName().equals(fileName)) {
					System.out.println("find file");
					File localFile = new File(localPath + "/" + ff.getName());
					OutputStream is = new FileOutputStream(localFile);

					// ����˿ڽ��д���

					System.out.println("start....");
					ftp.retrieveFile(ff.getName(), is);
					is.close();
				}
			}
			System.out.println("end...");
			ftp.logout();
			success = true;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ftp.isConnected()) {
				try {
					ftp.disconnect();
				} catch (IOException ioe) {
				}
			}
		}
		return success;
	}

}
