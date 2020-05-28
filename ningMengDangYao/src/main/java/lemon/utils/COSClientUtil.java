package lemon.utils;


import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.Bucket;
import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class COSClientUtil {

    // 设置用户属性, 包括appid, secretId和SecretKey
    // 这些属性可以通过cos控制台获取(https://console.qcloud.com/cos)

    private static final long appId = 1301859586;

    //密钥
    private static final String secretId = "AKIDg6F9YrFBwd4c18Pby4xZR5SebHgr3Ro5";

    private static final String secretKey = "b4HDsJUN2HGxMTM0MPdcy3x4vVnGTRBh";

    // 设置要操作的bucket
    private static final  String bucketName_1 = "ningmengdangyao-1301859586";

    private static final  String bucketName_2 = "haiweilandetian-1301859586";


    private static class ClientHolder{

        private static COSCredentials cred = new BasicCOSCredentials(secretId,secretKey);

        private static ClientConfig clientConfig = new ClientConfig(new Region("ap-chengdu"));

        private static COSClient cosClient = new COSClient(cred,clientConfig);

    }
    /**
     * 获取cos客户端对象
     * @return
     */
    public static COSClient getCOSClient(){
        return ClientHolder.cosClient;
    }

    /**
     * 查询存储桶列表
     * @return
     */
    public static List<Bucket> getBuckets(){
        ArrayList<String> buckentsList = new ArrayList<>();
        COSClient client = getCOSClient();
        List<Bucket> buckets = ClientHolder.cosClient.listBuckets();
        return buckets;
    }


    /**
     * 从本地上传文件
     * @return
     */
    public static void uploadPic(){
        COSClient cosClient = getCOSClient();

        String localFilePath = "C:\\Users\\EDZ\\Desktop\\longdian.png";

        // 指定要上传的文件
        File localFile = new File(localFilePath);
        // 指定要上传到的存储桶
        String bucketName = "ningmengdangyao-1301859586";
        // 指定要上传到 COS 上对象键
        String key = "wanghouyusheng";
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, localFile);
        PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
    }

    /**
     * Description: 判断Cos服务文件上传时文件的contentType
     *
     * @param filenameExtension 文件后缀
     * @return String
     */
    public static String getcontentType(String filenameExtension) {
        System.out.println("文件后缀:"+filenameExtension);
        if (filenameExtension.equalsIgnoreCase(".bmp")) {
            return "image/bmp";
        }
        if (filenameExtension.equalsIgnoreCase(".zip")) {
            return "application/zip";
        }
        if (filenameExtension.equalsIgnoreCase(".gif")) {
            return "image/gif";
        }
        if (filenameExtension.equalsIgnoreCase(".jpeg") || filenameExtension.equalsIgnoreCase(".jpg")
                || filenameExtension.equalsIgnoreCase(".png")) {
            return "image/jpeg";
        }
        if (filenameExtension.equalsIgnoreCase(".html")) {
            return "text/html";
        }
        if (filenameExtension.equalsIgnoreCase(".txt")) {
            return "text/plain";
        }
        if (filenameExtension.equalsIgnoreCase(".vsd")) {
            return "application/vnd.visio";
        }
        if (filenameExtension.equalsIgnoreCase(".pptx") || filenameExtension.equalsIgnoreCase(".ppt")) {
            return "application/vnd.ms-powerpoint";
        }
        if (filenameExtension.equalsIgnoreCase(".docx") || filenameExtension.equalsIgnoreCase(".doc")) {
            return "application/msword";
        }
        if (filenameExtension.equalsIgnoreCase(".xml")) {
            return "text/xml";
        }
        if (filenameExtension.equalsIgnoreCase(".avi")){
            return "video/x-msvideo";
        }
        if (filenameExtension.equalsIgnoreCase(".wmv")){
            return "video/x-ms-wmv";
        }
        if (filenameExtension.equalsIgnoreCase(".asf")){
            return "video/x-ms-asf";
        }
        if (filenameExtension.equalsIgnoreCase(".asx")){
            return "audio/x-ms-asx";
        }
        if (filenameExtension.equalsIgnoreCase(".rm")){
            return "application/vnd.rn-realmedia";
        }
        if (filenameExtension.equalsIgnoreCase(".rmvb")){
            return "application/vnd.rn-realmedia";
        }
        if (filenameExtension.equalsIgnoreCase(".mpg")||filenameExtension.equalsIgnoreCase(".mpe")
                || filenameExtension.equalsIgnoreCase(".mpeg")){
            return "video/mpeg";
        }
        if (filenameExtension.equalsIgnoreCase(".3gpp")||filenameExtension.equalsIgnoreCase(".3gp")
                ||filenameExtension.equalsIgnoreCase(".3ga")||filenameExtension.equalsIgnoreCase(".3g2")
                ||filenameExtension.equalsIgnoreCase(".3gp")){
            return "video/3gpp";
        }
        if (filenameExtension.equalsIgnoreCase(".qtvr")||filenameExtension.equalsIgnoreCase(".qt")
                ||filenameExtension.equalsIgnoreCase(".moov")||filenameExtension.equalsIgnoreCase(".mov")){
            return "video/quicktime";
        }
        if (filenameExtension.equalsIgnoreCase(".m4v")||filenameExtension.equalsIgnoreCase(".mp4")){
            return "video/mp4";
        }
        if (filenameExtension.equalsIgnoreCase(".mkv")){
            return "video/x-matroska";
        }
        if (filenameExtension.equalsIgnoreCase(".flv")){
            return "video/x-flv";
        }
        if (filenameExtension.equalsIgnoreCase(".vob")){
            return "video/mpeg";
        }
//        throw new BaseException("暂不支持此类型文件");
        return  "123";
    }


    /**
     * 获取图片链接
     * @param key
     */
    public static String getImgUrl(String key){
        /**
         * 设置url过期时间为10年，1000
         * System.currentTimeMillis() 获取当前时间戳
         */
        Date expiration = new Date(System.currentTimeMillis() +  1000L* 3600 * 24 * 365 * 10);


        URL url = getCOSClient().generatePresignedUrl(bucketName_1, key, expiration);

        if (url != null){
            return url.toString();
        }else {
            return "url为空";
        }
    }

    /**
     * 时间戳转换
     * @param
     */
    public static String getformat(){
        System.out.println(System.currentTimeMillis());
        System.out.println(System.currentTimeMillis());
        Long a =1l;
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy:MM:dd hh:mm:ss");
        String format = dateFormat.format(date);
        System.out.println(format);
        return null;
    }


    /**
     * 上传到COS服务器 如果同名文件会覆盖服务器上的
     *
     * @param instream
     *            文件流
     * @param fileName
     *            文件名称 包括后缀名
     * @return 出错返回"" ,唯一MD5数字签名
     */
    public static String uploadFileCos(InputStream instream, String fileName) {
        String ret = "";
        try {
            // 创建上传Object的Metadata
            ObjectMetadata objectMetadata = new ObjectMetadata();
            //设置内容长度
            objectMetadata.setContentLength(instream.available());
            objectMetadata.setCacheControl("no-cache");
            objectMetadata.setHeader("Pragma", "no-cache");
            objectMetadata.setContentType(getcontentType(fileName.substring(fileName.lastIndexOf("."))));

            //设置新生成新的图片名称
            objectMetadata.setContentDisposition("inline;filename=" + fileName);

//
            // 上传文件
//            PutObjectResult putResult = getCOSClient().putObject(bucketName_1,  fileName, instream, objectMetadata);
//            ret = putResult.getETag();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (instream != null) {
                    instream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return ret;
    }

    public static void uploadFile2Cos(MultipartFile file) throws Exception {


        if (file.getSize() > 100 * 1024 * 1024) {
            throw new Exception("上传文件大小不能超过100M！");
        }

        System.out.println("文件类的类型:"+file.getClass());
        System.out.println("文件变量名:"+file.getName());
        System.out.println("文件类型:" + file.getContentType());
        System.out.println("file.getBytes():"+file.getBytes());
        System.out.println("文件大小（字节数）:"+file.getSize()+"字节");
        System.out.println("文件输入流:"+file.getInputStream());
        System.out.println("");
        //图片名称
        String originalFilename = file.getOriginalFilename();
        System.out.println("originalFilename = " + originalFilename);

        //图片后缀w
        String substring = originalFilename.substring(originalFilename.lastIndexOf(".")).toLowerCase();
        System.out.println("substring = " + substring);

        //生成新的图片名称
        String name = UUID.randomUUID().toString() + substring;
        System.out.println("newFilename = " + name);
        InputStream inputStream = file.getInputStream();

        String s = uploadFileCos(inputStream, name);
//        uploadFileCos(file.getInputStream(),"wucunyang");
    }

    public static void main(String[] args) {


    }

}
