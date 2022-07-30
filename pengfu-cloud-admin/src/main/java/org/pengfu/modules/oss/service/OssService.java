package org.pengfu.modules.oss.service;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.common.utils.BinaryUtil;
import com.aliyun.oss.model.MatchMode;
import com.aliyun.oss.model.PolicyConditions;
import lombok.AllArgsConstructor;
import org.pengfu.modules.oss.domain.vo.PolicyVO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author PrideZH
 * @since 2022/7/30 19:57
 */
@AllArgsConstructor
@Service
public class OssService {

    private OSSClient ossClient;

    @Value("${spring.cloud.alicloud.oss.endpoint}")
    private String endpoint;

    @Value("${spring.cloud.alicloud.access-key}")
    private String accessId;

    public PolicyVO policy() throws UnsupportedEncodingException {
        // Bucket名称
        String bucket = "examplebucket";

        // Host地址
        String host = "https://" + bucket + "."+ endpoint;

        // 上传到OSS文件的前缀
        String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String dir = format + "/";

        long expireTime = 30;
        long expireEndTime = System.currentTimeMillis() + expireTime * 1000;
        Date expiration = new Date(expireEndTime);
        PolicyConditions policyConds = new PolicyConditions();
        policyConds.addConditionItem(PolicyConditions.COND_CONTENT_LENGTH_RANGE, 0, 1048576000);
        policyConds.addConditionItem(MatchMode.StartWith, PolicyConditions.COND_KEY, dir);

        String postPolicy = ossClient.generatePostPolicy(expiration, policyConds);
        byte[] binaryData = postPolicy.getBytes(StandardCharsets.UTF_8);
        String encodedPolicy = BinaryUtil.toBase64String(binaryData);
        String postSignature = ossClient.calculatePostSignature(postPolicy);

        PolicyVO policyVO = new PolicyVO();
        policyVO.setAccessId(accessId);
        policyVO.setPolicy(encodedPolicy);
        policyVO.setSignature(postSignature);
        policyVO.setDir(dir);
        policyVO.setHost(host);
        policyVO.setExpire(String.valueOf(expireEndTime / 1000));

        return policyVO;
    }

}
