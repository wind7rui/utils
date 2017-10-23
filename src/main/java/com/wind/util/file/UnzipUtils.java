package com.wind.util.file;

import org.kamranzafar.jtar.TarEntry;
import org.kamranzafar.jtar.TarInputStream;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * 用于解压压缩包的工具类
 */
public class UnzipUtils {

    private static final int _200K = 1024 * 200;

    /**
     * 解压tar.gz类型文件
     *
     * @param tarFileName 需要解压的文件（到文件名）
     * @param destFolder  解压后的文件路径
     * @return
     * @throws IOException
     */
    public static void unTarGzFile(String tarFileName, String destFolder) throws IOException {
        try {
            File tarFile = new File(tarFileName);
            TarInputStream tis = null;
            tis = new TarInputStream(new GZIPInputStream(new BufferedInputStream(new FileInputStream(tarFile))));
            TarEntry entry;
            while ((entry = tis.getNextEntry()) != null) {
                int count;
                byte data[] = new byte[_200K];

                FileOutputStream fos = new FileOutputStream(new File(destFolder + "/" + entry.getName()));
                BufferedOutputStream dest = new BufferedOutputStream(fos);

                while ((count = tis.read(data)) != -1) {
                    dest.write(data, 0, count);
                }
                dest.flush();
                dest.close();
            }
            tis.close();
        } catch (FileNotFoundException fileNotFoundException) {
            throw fileNotFoundException;
        } catch (IOException e) {
            throw e;
        }
    }

    /**
     * 解压文件
     *
     * @param filePath 压缩文件路径
     */
    public static void unzip(String filePath) {
        File source = new File(filePath);
        if (source.exists()) {
            ZipInputStream zis = null;
            BufferedOutputStream bos = null;
            try {
                zis = new ZipInputStream(new FileInputStream(source));
                ZipEntry entry = null;
                while ((entry = zis.getNextEntry()) != null
                        && !entry.isDirectory()) {
                    File target = new File(source.getParent(), entry.getName());
                    if (!target.getParentFile().exists()) {
                        // 创建文件父目录
                        target.getParentFile().mkdirs();
                    }
                    // 写入文件
                    bos = new BufferedOutputStream(new FileOutputStream(target));
                    int read = 0;
                    byte[] buffer = new byte[1024 * 10];
                    while ((read = zis.read(buffer, 0, buffer.length)) != -1) {
                        bos.write(buffer, 0, read);
                    }
                    bos.flush();
                }
                zis.closeEntry();
            } catch (IOException e) {
                throw new RuntimeException(e);
            } /*finally {
                IOUtil.closeQuietly(bos);
            }*/
        }
    }
}
