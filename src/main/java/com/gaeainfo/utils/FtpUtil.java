package com.gaeainfo.utils;

import java.io.*;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;

import sun.net.ftp.FtpClient;
import sun.net.ftp.FtpProtocolException;

/**
 * Created by Rock on 2017/2/14.
 */
public class FtpUtil {

    /**
     * FTP客户端
     */
    private FtpClient ftpClient;

    /**
     * 服务器连接
     *
     * @param ip       服务器IP
     * @param port     服务器端口
     * @param user     用户名
     * @param password 密码
     * @param path     服务器路径
     * @throws FtpProtocolException
     */
    public void connectServer(String ip, int port, String user, String password, String path) {
        try {
            ftpClient = FtpClient.create();
            ftpClient.connect(new InetSocketAddress(ip, port));
            ftpClient.login(user, password.toCharArray());
            // 设置成2进制传输
            ftpClient.setBinaryType();

            System.out.println("login success!");

            if (path.length() != 0) {
                // 把远程系统上的目录切换到参数path所指定的目录
                ftpClient.changeDirectory(path);
            }
            ftpClient.setBinaryType();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /**
     * 关闭连接
     */
    public void closeConnect() {
        try {
            ftpClient.close();
            System.out.println("disconnect success");
        } catch (IOException ex) {
            System.out.println("not disconnect");
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /**
     * 下载文件
     *
     * @param remoteFile 远程文件路径(服务器端)
     * @param localFile  本地文件路径(客户端)
     * @throws FtpProtocolException
     */
    public void download(String remoteFile, String localFile) {
        FileInputStream is = null;
        FileOutputStream os = null;
        try {

            is = (FileInputStream) ftpClient.getFileStream(remoteFile);
            File file_in = new File(localFile);
            os = new FileOutputStream(file_in);

            byte[] bytes = new byte[1024];
            int c;
            while ((c = is.read(bytes)) != -1) {
                os.write(bytes, 0, c);
            }
            System.out.println("download success");
        } catch (Exception ex) {
            System.out.println("not download");
            ex.printStackTrace();
            throw new RuntimeException(ex);
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (os != null) {
                        os.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 取得相对于当前连接目录的某个目录下所有文件列表
     *
     * @param path
     * @return
     */
    public List<String> getFileList(String path) {
        List<String> list = new ArrayList<String>();
        InputStreamReader isr = null;
        try {
            isr = new InputStreamReader(ftpClient.nameList(path));
            BufferedReader bufferedReader = new BufferedReader(isr);
            String filename = "";
            while ((filename = bufferedReader.readLine()) != null) {
                list.add(filename);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (isr != null) {
                    isr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    /**
     * @param filePath 上传的文件或文件夹
     * @throws Exception
     */
    private void upload(String filePath){
        FileInputStream input = null;
        try {
            File file = new File(filePath);
            if(file.isDirectory()){
                ftpClient.makeDirectory(file.getName());
                ftpClient.changeDirectory(file.getName());
                String[] files = file.list();
                for (int i = 0; i < files.length; i++) {
                    File file1 = new File(file.getPath()+"\\"+files[i] );
                    if(file1.isDirectory()){
                        upload(file1.getAbsolutePath());
                        ftpClient.changeToParentDirectory();
                    }else{
                        File file2 = new File(file.getPath()+"\\"+files[i]);
                        input = new FileInputStream(file2);
                        ftpClient.putFile(file2.getName(), input);

                    }
                }
            }else{
                File file2 = new File(file.getPath());
                input = new FileInputStream(file2);
                ftpClient.putFile(file2.getName(), input);
            }
        } catch (FtpProtocolException e) {
            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();
        } finally {
            try {
                if (input != null) {
                    input.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        FtpUtil ftpUtil = new FtpUtil();
        ftpUtil.connectServer("139.224.10.47", 21, "ftpxzxf", "xzxf!23", "");
        List<String> list = ftpUtil.getFileList("");
        for (String fileName : list) {
            //ftpUtil.download(fileName,fileName.substring(5,fileName.length()));
            System.out.println(fileName);
        }
        ftpUtil.closeConnect();
    }

}
