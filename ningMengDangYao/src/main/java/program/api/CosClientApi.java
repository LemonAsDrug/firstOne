package program.api;



import com.qcloud.cos.COSClient;
import com.qcloud.cos.model.Bucket;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import program.utils.COSClientUtil;
import program.utils.R;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/cos")
public class CosClientApi {

    /**
     * 获取cos客户端对象
     * @return
     */
    @RequestMapping("/getClient")
    public String getClient(){
        COSClient cosClient = COSClientUtil.getCOSClient();
        String bucketLocation = cosClient.getBucketLocation("haiweilandetian-1301859586");
//        List<Bucket> buckets = cosClient.listBuckets();
//        //cosClient有很多对象

        return bucketLocation;
    }

    /**
     * COS SDK https://cloud.tencent.com/document/product/436/10199
     * 查询存储桶列表
     * @return
     */
    @RequestMapping("/getBuckets")
    public Map<String,List<Bucket>> getBuckets(){
        HashMap<String,List<Bucket>> stringMap = new HashMap<>();
        List<Bucket> buckets = COSClientUtil.getBuckets();
        stringMap.put("buckets",buckets);
        return stringMap;
    }

    /**
     * 测试 file的属性
     * @param file
     * @return
     */
    @RequestMapping("/testFileProperty")
    public R testFileProperty(MultipartFile file){
        System.out.println(file.getSize());
        System.out.println(file.getContentType());
        System.out.println(file.getName());
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getClass());
        return R.ok();
    }

    /**
     * 从postman上传一个文件到cos
     * @param file
     * @return
     */
    @RequestMapping("/uploadPic")
    public R uploadPic(MultipartFile file) throws Exception {

        COSClientUtil.uploadFile2Cos(file);
        return R.ok();
    }





}
